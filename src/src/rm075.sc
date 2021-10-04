;;; Sierra Script 1.0 - (do not remove this comment)
(script# 75)
(include sci.sh)
(use Main)
(use sewer)
(use SQRoom)
(use Polygon)
(use Cycle)
(use Obj)

(public
	rm075 0
)

(instance rm075 of SQRoom
	(properties
		picture 75
		east 80
		south 90
		picAngle 70
		vanishingX 319
		vanishingY -40
	)
	
	(method (init)
		(sewer roomVer: 22891)
		(Load rsVIEW 80)
		(switch global12
			(east
				(proc0_3)
				(gEgo y: 100)
				(self style: 11)
			)
			(south
				(proc0_2)
				(if
				(and (== (sewer status?) 3) (== (sewer location?) 75))
					((ScriptID 702 2)
						init:
						hide:
						posn: 120 116
						setLoop: 0
						setScript: (ScriptID 702 4)
					)
				)
				(self setScript: enterScript style: 10)
			)
			(else 
				(gLongSong number: 805 vol: 127 loop: -1 playBed:)
				(self setScript: enterScript style: 10)
			)
		)
		(gEgo init:)
		((ScriptID 702 5)
			init:
			setLoop: 0
			posn: 37 122
			setScript: daDripScript
		)
		((ScriptID 702 6)
			init:
			setLoop: 1
			posn: 219 46
			cycleSpeed: 12
			setCycle: Fwd
		)
		(super init:)
		((ScriptID 702 2) show:)
		(self
			setRegions: 702
			addObstacle:
				((Polygon new:)
					type: 2
					init: 153 95 36 189 0 189 0 0 319 0 319 95
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 319 101 319 189 50 189 159 101
					yourself:
				)
		)
		(if
		(and (!= (sewer location?) 75) (!= global12 90))
			(sewer status: 1)
		)
	)
	
	(method (doit)
		(cond 
			(script 0)
			((== (gEgo edgeHit?) 3) (proc0_2) (global2 setScript: exitScript))
			(
				(and
					(== (sewer location?) 90)
					(or (> (sewer rmTimer?) 7) (< (gEgo y?) 129))
				)
				(sewer location: 0 status: 0)
			)
		)
		(super doit: &rest)
		(if
			(and
				(> (gEgo y?) 170)
				(== (sewer status?) 1)
				(!= (sewer location?) 75)
			)
			((ScriptID 702 3) init: hide: setScript: dripScript)
			(sewer location: 75)
		)
	)
	
	(method (doVerb)
		(sewer doVerb: &rest)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					x: -16
					y: 246
					setLoop: 6
					setMotion: MoveTo 50 181 self
				)
				(sewer rmTimer: 0)
			)
			(1
				(proc0_1)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance exitScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gEgo setHeading: 225 self setMotion: 0)
			)
			(1
				(gEgo setMotion: MoveTo -16 246 self)
			)
			(2
				(if (== (sewer status?) 2) (sewer status: 3))
				(global2 newRoom: 90)
			)
		)
	)
)

(instance dripScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0 (= cycles 1))
			(1
				((ScriptID 702 3)
					show:
					setLoop: 5
					posn: 82 90
					cel: 0
					cycleSpeed: 18
					setCycle: CT 9 1 self
				)
				(gLongSong vol: 0 changeState:)
				(gLongSong2 vol: 127 number: 806 loop: 1 play:)
				((ScriptID 702 2) posn: 109 125)
				(sewer status: 2)
			)
			(2
				((ScriptID 702 3) setCycle: End)
				((ScriptID 702 2)
					init:
					setLoop: 7
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(gLongSong2 vol: 127 number: 819 loop: -1 playBed:)
				(sewer status: 3)
				((ScriptID 702 2)
					setLoop: 0
					setCycle: Fwd
					cycleSpeed: 6
					moveSpeed: (- global199 2)
					setScript: (ScriptID 702 4)
				)
				(self dispose:)
			)
		)
	)
)

(instance daDripScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				((ScriptID 702 5) setCycle: End self)
			)
			(1 (= cycles (Random 5 20)))
			(2 (self init:))
		)
	)
)

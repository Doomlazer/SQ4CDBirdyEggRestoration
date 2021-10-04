;;; Sierra Script 1.0 - (do not remove this comment)
(script# 80)
(include sci.sh)
(use Main)
(use sewer)
(use SQRoom)
(use Polygon)
(use Cycle)
(use Obj)

(public
	rm080 0
)

(instance rm080 of SQRoom
	(properties
		picture 80
		east 85
		south 95
		west 75
		picAngle 70
	)
	
	(method (init &tmp temp0)
		(sewer roomVer: 3591)
		(proc0_3)
		(Load rsVIEW 80)
		(switch global12
			(west
				(gEgo y: 100)
				(= temp0 12)
			)
			(south
				(if (< (gEgo x?) 145) (gEgo x: 146))
				(if (> (gEgo x?) 172) (gEgo x: 171))
				(= temp0 14)
				(if
				(and (== (sewer location?) 80) (== (sewer status?) 6))
					(proc0_2)
					(Load rsSOUND 818)
					(Load rsVIEW 76)
					((ScriptID 702 2)
						init:
						hide:
						setCycle: Fwd
						cycleSpeed: 6
						moveSpeed: (- global199 2)
						posn: 157 160
					)
					(sewer status: 4)
				)
			)
			(east
				(if
				(and (== (sewer location?) 80) (== (sewer status?) 6))
					(Load rsSOUND 818)
					(Load rsVIEW 76)
					((ScriptID 702 2)
						init:
						hide:
						setCycle: Fwd
						setLoop: 2
						posn: 255 91
						setScript: (ScriptID 702 4)
					)
					(sewer status: 4)
				else
					(sewer status: 0 location: 0)
				)
				(self setScript: enterRight)
				(= temp0 11)
			)
			(else 
				(gLongSong number: 805 vol: 127 loop: -1 playBed:)
				(gEgo posn: 27 94)
			)
		)
		(self style: temp0)
		((ScriptID 702 5)
			init:
			setLoop: 2
			posn: 113 62
			setScript: daDripScript
		)
		((ScriptID 702 6)
			init:
			setLoop: 3
			posn: 250 45
			cycleSpeed: 12
			setCycle: Fwd
		)
		(gEgo init: setPri: -1)
		(super init:)
		((ScriptID 702 2) show:)
		(self
			setRegions: 702
			addObstacle:
				((Polygon new:)
					type: 2
					init: 0 101 132 101 152 123 151 189 0 189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 166 189 166 123 187 101 319 102 319 189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 0 0 319 0 319 94 0 94
					yourself:
				)
		)
		(if
		(and (!= global12 95) (!= (sewer location?) 80))
			(sewer status: 1)
		)
	)
	
	(method (doit)
		(cond 
			(script 0)
			((== (gEgo edgeHit?) 3) (proc0_2) (self setScript: exitSouth))
			(
			(or (== (gEgo edgeHit?) 2) (== (gEgo edgeHit?) 4)) (sewer location: 0 status: 0))
		)
		(super doit: &rest)
		(if
			(and
				(== (dripScript state?) -1)
				(> (gEgo y?) 170)
				(== (sewer status?) 1)
			)
			((ScriptID 702 3) init: hide: setScript: dripScript)
		)
		(if
			(and
				(== (sewer status?) 3)
				(== ((ScriptID 702 2) loop?) 3)
				(> ((ScriptID 702 2) y?) 163)
			)
			(if (< (gEgo y?) ((ScriptID 702 2) y?))
				((ScriptID 702 2) setScript: slimeLeaving)
				(sewer status: 8)
			else
				((ScriptID 702 2) setMotion: 0 setScript: 0)
			)
		)
	)
	
	(method (doVerb)
		(sewer doVerb: &rest)
	)
)

(instance exitSouth of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setHeading: 180 self)
			)
			(1
				(if
					(and
						(or (== (sewer status?) 3) (== (sewer status?) 4))
						(> ((ScriptID 702 2) y?) 160)
					)
					((ScriptID 702 2) setMotion: 0 setScript: 0)
				)
				(gEgo setMotion: MoveTo (gEgo x?) 239 self)
			)
			(2
				(if (== (sewer status?) 2)
					(sewer status: 3)
					(gLongSong2 vol: 127 number: 819 loop: -1 playBed:)
				)
				(if
					(and
						(== (sewer location?) 95)
						(== (sewer status?) 6)
						(> (sewer rmTimer?) 7)
					)
					(sewer status: 8)
				)
				(global2 newRoom: 95)
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
				(gLongSong fade: 0 10 10 0)
				(gLongSong2 vol: 127 number: 806 loop: 1 play:)
				(sewer location: 80)
				((ScriptID 702 3)
					show:
					setPri: 5
					setLoop: 4
					posn: 159 38
					cel: 0
					cycleSpeed: 12
					setCycle: CT 10 1 self
				)
				((ScriptID 702 2)
					init:
					hide:
					setLoop: 3
					setPri: 3
					setCycle: 0
					posn: 159 60
					cycleSpeed: 6
					moveSpeed: (- global199 2)
				)
			)
			(2
				((ScriptID 702 3) setCel: 11)
				((ScriptID 702 2) show: posn: 159 65)
				(= cycles 3)
			)
			(3
				((ScriptID 702 3) setCel: 12)
				((ScriptID 702 2) posn: 159 70)
				(= cycles 3)
			)
			(4
				((ScriptID 702 3) setCel: 13)
				((ScriptID 702 2) posn: 159 75)
				(= cycles 3)
			)
			(5
				((ScriptID 702 3) setCel: 14)
				((ScriptID 702 2) posn: 159 80)
				(= cycles 3)
			)
			(6
				(gLongSong2 vol: 127 number: 819 loop: -1 playBed:)
				((ScriptID 702 3) hide:)
				((ScriptID 702 2) posn: 159 85)
				(sewer status: 3)
				((ScriptID 702 2)
					setScript: (ScriptID 702 4)
					moveSpeed: (- global199 2)
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

(instance slimeLeaving of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				((ScriptID 702 2) setMotion: MoveTo 158 210 self)
			)
			(1
				((ScriptID 702 2) posn: 1000 1000 dispose:)
				(sewer location: 95 status: 6 rmTimer: 0)
				(self dispose:)
			)
		)
	)
)

(instance enterRight of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo posn: 303 99 setMotion: MoveTo 294 99 self)
			)
			(1
				(proc0_3)
				(proc0_1)
				(self dispose:)
			)
		)
	)
)

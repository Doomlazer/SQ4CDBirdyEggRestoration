;;; Sierra Script 1.0 - (do not remove this comment)
(script# 115)
(include sci.sh)
(use Main)
(use sewer)
(use SQRoom)
(use Polygon)
(use Cycle)
(use Obj)

(public
	rm115 0
)

(instance rm115 of SQRoom
	(properties
		picture 115
		horizon 50
		west 110
		picAngle 70
		vanishingX 0
		vanishingY -65
	)
	
	(method (init)
		(sewer roomVer: 22291)
		(Load rsVIEW 80)
		(switch global12
			(100
				(gEgo posn: 88 -1)
				(self setScript: enterNorth style: 10)
				(cond 
					((not (proc999_5 (sewer location?) 100 115)) (sewer status: 1))
					(
						(and
							(== (sewer status?) 3)
							(== (sewer location?) 115)
						)
						((ScriptID 702 2)
							init:
							posn: 189 75
							setLoop: 1
							setCycle: Fwd
							cycleSpeed: 6
							setScript: (ScriptID 702 4)
						)
						(sewer status: 4)
					)
				)
			)
			(west
				(if
					(and
						(== (sewer location?) 115)
						(== (sewer status?) 6)
					)
					(Load rsSOUND 818)
					(Load rsVIEW 76)
					(sewer status: 4)
					((ScriptID 702 2) init: posn: 61 127 hide: setCycle: Fwd)
				)
				(self style: 12 setScript: enterLeft)
			)
			(else 
				(gLongSong number: 805 vol: 127 loop: -1 playBed:)
				(gEgo init: posn: 18 128)
				(proc0_1)
			)
		)
		((ScriptID 702 5)
			init:
			setLoop: 14
			posn: 85 80
			cycleSpeed: 12
			setCycle: Fwd
		)
		((ScriptID 702 6)
			init:
			setLoop: 15
			posn: 232 78
			cycleSpeed: 12
			setCycle: Fwd
		)
		(super init:)
		(gEgo init: show:)
		((ScriptID 702 2) show:)
		(self
			setRegions: 702
			addObstacle:
				((Polygon new:)
					type: 2
					init: 0 0 81 0 233 121 227 129 0 129
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 319 0 319 189 0 189 0 136 241 136 248 129 243 118 95 0
					yourself:
				)
		)
	)
	
	(method (doit)
		(cond 
			(script 0)
			((== (gEgo edgeHit?) 1)
				(proc0_2)
				((ScriptID 702 2) setScript: 0)
				(self setScript: exitNorth)
			)
			((== (gEgo edgeHit?) 4)
				(if (> (sewer distance?) 39)
					(gLongSong2 vol: 0 fade: 0 10 10 0)
				)
				(if
					(or
						(< ((ScriptID 702 2) y?) 80)
						(== (sewer location?) 100)
					)
					(gLongSong2 vol: 0 fade: 0 10 10 0)
					(sewer location: 0 status: 0)
				)
			)
		)
		(super doit: &rest)
		(if
			(and
				(== (dripScript state?) -1)
				(!= global12 110)
				(== (sewer status?) 1)
			)
			((ScriptID 702 3) init: hide: setScript: dripScript)
		)
		(if
			(and
				(== (sewer location?) 110)
				(> (gEgo x?) 121)
				(> (sewer prevDistance?) 90)
				(> (sewer rmTimer?) 5)
			)
			(sewer location: 0 status: 0)
		)
		(if (< (gEgo y?) 60)
			(gEgo setPri: 4)
		else
			(gEgo setPri: -1)
		)
	)
	
	(method (doVerb)
		(sewer doVerb: &rest)
	)
)

(instance exitNorth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					setPri: 4
					illegalBits: 0
					ignoreActors: 1
					setLoop: 7
					setMotion: MoveTo 89 0 self
				)
			)
			(1
				(if
					(and
						(== (sewer location?) 100)
						(> (sewer rmTimer?) 30)
					)
					(sewer location: 0 status: 0)
				)
				(if
					(or
						(== ((ScriptID 702 2) loop?) 2)
						(== (sewer location?) 110)
					)
					(sewer location: 0 status: 0)
				)
				((ScriptID 702 2) posn: 1000 1000)
				(global2 newRoom: 100)
			)
		)
	)
)

(instance dripScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0 (= seconds (Random 3 8)))
			(1
				(if (< (gEgo y?) 105) (self init:) else (self cue:))
			)
			(2
				(sewer status: 2 location: 115)
				(gLongSong vol: 0 fade: 0 10 10 0)
				(gLongSong2 vol: 127 number: 806 loop: 1 play:)
				((ScriptID 702 3)
					show:
					setLoop: 6
					posn: 186 14
					cel: 0
					cycleSpeed: 18
					setCycle: CT 9 1 self
				)
			)
			(3
				((ScriptID 702 3) cycleSpeed: 12 setCycle: End)
				((ScriptID 702 2)
					init:
					setLoop: 8
					cycleSpeed: 12
					setCycle: End self
					posn: 161 48
				)
			)
			(4
				(gLongSong2 vol: 127 number: 819 loop: -1 playBed:)
				(sewer status: 3)
				((ScriptID 702 2)
					setLoop: 1
					setCycle: Fwd
					cycleSpeed: 6
					setScript: (ScriptID 702 4)
				)
				(self dispose:)
			)
		)
	)
)

(instance enterNorth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					ignoreHorizon: 1
					setLoop: 4
					setMotion: MoveTo 123 29 self
				)
			)
			(1
				(if
					(and
						(== (sewer location?) 115)
						(== (sewer status?) 3)
					)
					((ScriptID 702 2) setScript: (ScriptID 702 4))
				)
				(if
					(and
						(== (sewer status?) 3)
						(== (sewer location?) 100)
					)
					(if (< (sewer prevDistance?) 60)
						((ScriptID 702 2) posn: 79 -16)
					else
						((ScriptID 702 2) posn: 73 -22)
					)
					((ScriptID 702 2)
						init:
						setLoop: 1
						setCycle: Fwd
						cycleSpeed: 6
						setScript: (ScriptID 702 4)
					)
					(sewer location: 115)
				)
				(gEgo setMotion: MoveTo 159 59 self)
			)
			(2
				(proc0_3)
				(proc0_1)
				(self dispose:)
			)
		)
	)
)

(instance enterLeft of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					init:
					hide:
					posn: 10 133
					setMotion: MoveTo 30 133 self
				)
				(cond 
					(
						(and
							(== (sewer status?) 3)
							(== (sewer location?) 110)
						)
						(if (< (sewer prevDistance?) 50)
							((ScriptID 702 2)
								init:
								hide:
								posn: -32 125
								setLoop: 2
								moveSpeed: (- global199 2)
								setScript: (ScriptID 702 4)
							)
							(sewer location: 115)
						else
							(gLongSong vol: 127 playBed:)
							(gLongSong2 vol: 0 fade: 0 10 10 0)
						)
					)
					(
						(and
							(== (sewer status?) 3)
							(== (sewer location?) 115)
						)
						(if (> (sewer oldDistance?) 140)
							((ScriptID 702 2) posn: 203 127)
						else
							((ScriptID 702 2) posn: (sewer oldDistance?) 127)
						)
						(sewer status: 4)
						((ScriptID 702 2)
							init:
							hide:
							setLoop: 2
							moveSpeed: (- global199 2)
							setScript: (ScriptID 702 4)
						)
						(gLongSong2 vol: 127 loop: -1 playBed:)
						(gLongSong vol: 0 fade: 0 10 10 0)
					)
				)
			)
			(1
				(proc0_3)
				(proc0_1)
				(self dispose:)
			)
		)
	)
)

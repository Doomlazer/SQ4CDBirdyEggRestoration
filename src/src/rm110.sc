;;; Sierra Script 1.0 - (do not remove this comment)
(script# 110)
(include sci.sh)
(use Main)
(use sewer)
(use SQRoom)
(use Polygon)
(use Cycle)
(use Obj)

(public
	rm110 0
)

(local
	local0
)
(instance rm110 of SQRoom
	(properties
		picture 110
		horizon 50
		east 115
		west 105
		picAngle 70
	)
	
	(method (init &tmp temp0)
		(sewer roomVer: 22691)
		(Load rsVIEW 80)
		(switch global12
			(95
				(self setScript: enterNorth)
				(= temp0 13)
			)
			(east
				(= temp0 11)
				(proc0_2)
				(self setScript: enterRight)
			)
			(west
				(if (== (sewer location?) 90)
					(sewer status: 0 location: 0)
				)
				(= temp0 12)
				(proc0_2)
				(self setScript: enterLeft)
			)
			(else 
				(gLongSong number: 805 vol: 127 loop: -1 playBed:)
				(gEgo init: hide: posn: 20 133)
				(proc0_1)
			)
		)
		(self style: temp0)
		((ScriptID 702 5)
			init:
			setLoop: 13
			posn: 250 114
			setScript: daDripScript
		)
		(super init:)
		((ScriptID 702 2) show:)
		(gEgo show:)
		(self
			setRegions: 702
			addObstacle:
				((Polygon new:)
					type: 2
					init: 0 0 146 0 146 120 139 130 0 130
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 164 0 319 0 319 130 168 130 164 120
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 0 136 319 136 319 189 0 189
					yourself:
				)
		)
	)
	
	(method (doit)
		(cond 
			(script 0)
			((== (gEgo edgeHit?) 1) (proc0_2) (self setScript: exitScript))
			(
			(or (== (gEgo edgeHit?) 4) (== (gEgo edgeHit?) 2))
				(if (== (sewer location?) 95)
					(sewer status: 0 location: 0)
				)
				(if
					(and
						(== (sewer status?) 3)
						(or
							(== ((ScriptID 702 2) y?) 1000)
							(< ((ScriptID 702 2) y?) 50)
						)
					)
					(sewer status: 0 location: 0)
				)
			)
			(
				(and
					(== (sewer status?) 3)
					(> (sewer rmTimer?) 11)
					(!= (sewer location?) 110)
				)
				(sewer location: 0 status: 0)
			)
			(
			(and (== (sewer location?) 95) (> (sewer rmTimer?) 6)) (sewer status: 0 location: 0))
		)
		(super doit: &rest)
		(if
			(and
				(== (sewer status?) 3)
				(== (sewer location?) 115)
				(< (gEgo x?) 245)
				(< (sewer rmTimer?) 12)
			)
			(sewer location: 110)
			((ScriptID 702 2)
				init:
				setLoop: 2
				moveSpeed: (- global199 2)
				posn: 346 125
				setCycle: Fwd
				cycleSpeed: 6
				setScript: (ScriptID 702 4)
			)
			(gLongSong2 vol: 127 playBed:)
			(gLongSong vol: 0 fade: 0 10 10 0)
		)
		(if
			(and
				(> (gEgo x?) 85)
				(== (sewer status?) 3)
				(== (sewer location?) 105)
			)
			(sewer location: 110)
			((ScriptID 702 2)
				init:
				setLoop: 2
				moveSpeed: (- global199 2)
				posn: -39 125
				setCycle: Fwd
				cycleSpeed: 6
				setScript: (ScriptID 702 4)
			)
			(gLongSong2 vol: 127 playBed:)
			(gLongSong vol: 0 fade: 0 10 10 0)
		)
		(if (< (gEgo y?) 63)
			(gEgo setPri: 4)
		else
			(gEgo setPri: -1)
		)
	)
	
	(method (doVerb)
		(sewer doVerb: &rest)
	)
)

(instance exitScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(if
					(and
						(== ((ScriptID 702 2) loop?) 3)
						(> (sewer distance?) 29)
					)
					((ScriptID 702 2) setScript: 0 posn: 1000 1000)
					(sewer location: 95)
				)
				(gEgo
					ignoreHorizon: 1
					setMotion: MoveTo (gEgo x?) -26 self
				)
			)
			(1
				(if (== ((ScriptID 702 2) loop?) 3)
					((ScriptID 702 2) hide:)
				)
				(if (== (sewer location?) 110)
					(gLongSong2 vol: 0 fade: 0 10 10 0)
					(gLongSong vol: 127 playBed:)
					(if
						(and
							(or
								(< ((ScriptID 702 2) x?) 90)
								(> ((ScriptID 702 2) x?) 240)
							)
							(== ((ScriptID 702 2) loop?) 2)
						)
						(sewer location: 0 status: 0)
					)
				)
				(if (== (sewer location?) 115)
					(sewer status: 0 location: 0)
				)
				(global2 newRoom: 95)
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
					setMotion: MoveTo 25 133 self
				)
				(cond 
					(
						(and
							(== (sewer status?) 6)
							(== (sewer location?) 110)
						)
						(Load rsSOUND 818)
						(Load rsVIEW 76)
						(gLongSong2 vol: 127 playBed:)
						(gLongSong vol: 0 fade: 0 10 10 0)
						((ScriptID 702 2)
							init:
							hide:
							posn: 57 127
							moveSpeed: (- global199 2)
							setLoop: 2
							setScript: (ScriptID 702 4)
						)
						(sewer status: 4)
					)
					(
						(and
							(== (sewer status?) 3)
							(== (sewer location?) 110)
						)
						(gLongSong2 vol: 127 playBed:)
						(gLongSong vol: 0 fade: 0 10 10 0)
						(if (> (sewer oldDistance?) 109)
							(sewer oldDistance: 109)
						)
						((ScriptID 702 2)
							init:
							hide:
							moveSpeed: (- global199 2)
							setLoop: 2
						)
						(sewer status: 4)
						(if (not (Random 0 2))
							((ScriptID 702 2)
								posn: (sewer oldDistance?) 127
								setScript: (ScriptID 702 4)
							)
						else
							((ScriptID 702 2)
								posn: (Random 310 334) 127
								setScript: slimeLeavingR
							)
						)
					)
					(
						(and
							(== (sewer status?) 3)
							(== (sewer location?) 105)
							(< (sewer prevDistance?) 40)
						)
						(gLongSong2 vol: 127 playBed:)
						(gLongSong vol: 0 fade: 0 10 10 0)
						((ScriptID 702 2)
							init:
							hide:
							posn: -39 125
							setLoop: 2
							moveSpeed: (- global199 2)
							setScript: (ScriptID 702 4)
						)
						(sewer location: 110)
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

(instance enterRight of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					init:
					hide:
					posn: 309 134
					setMotion: MoveTo 297 134 self
				)
				(if
					(and
						(== (sewer status?) 3)
						(== (sewer location?) 110)
					)
					(gLongSong2 vol: 127 playBed:)
					(gLongSong vol: 0 fade: 0 10 10 0)
					((ScriptID 702 2)
						init:
						hide:
						moveSpeed: (- global199 2)
						setLoop: 2
						setScript: (ScriptID 702 4)
					)
					(sewer status: 4)
					(if (not (Random 0 2))
						((ScriptID 702 2)
							posn: (- 320 (sewer oldDistance?)) 125
							setScript: (ScriptID 702 4)
						)
					else
						((ScriptID 702 2)
							posn: (Random -21 12) 127
							setScript: slimeLeavingL
						)
					)
				)
				(if
					(and
						(== (sewer status?) 3)
						(== (sewer location?) 115)
						(< (sewer prevDistance?) 40)
					)
					((ScriptID 702 2)
						init:
						hide:
						posn: 359 125
						setLoop: 2
						moveSpeed: (- global199 2)
						setScript: (ScriptID 702 4)
					)
					(sewer location: 110)
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

(instance enterNorth of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(sewer rmTimer: 0)
				(gEgo init: posn: 161 76)
				(if (== (sewer status?) 3)
					(switch (sewer location?)
						(95
							(if (< (sewer prevDistance?) 60)
								(sewer prevDistance: 60)
							)
							((ScriptID 702 2)
								posn: 158 (- 30 (sewer prevDistance?))
							)
							((ScriptID 702 2)
								init:
								hide:
								setLoop: 3
								setCycle: Fwd
								setScript: (ScriptID 702 4)
							)
							(sewer cantDie: 1 location: 110)
						)
						(110
							((ScriptID 702 2)
								init:
								hide:
								posn: 157 108
								setLoop: 3
								setCycle: Fwd
								setScript: (ScriptID 702 4)
							)
							(sewer status: 4)
						)
					)
				)
				(= seconds 2)
			)
			(1
				(proc0_3)
				(proc0_1)
				(sewer rmTimer: 0)
				(self dispose:)
			)
		)
	)
)

(instance slimeLeavingR of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(sewer status: 8)
				((ScriptID 702 2)
					setCycle: Fwd
					setMotion: MoveTo 370 127 self
				)
			)
			(1
				((ScriptID 702 2) dispose:)
				(sewer location: 115 status: 6)
			)
		)
	)
)

(instance slimeLeavingL of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(sewer status: 8)
				((ScriptID 702 2)
					setCycle: Fwd
					setMotion: MoveTo -45 127 self
				)
			)
			(1
				((ScriptID 702 2) dispose:)
				(sewer location: 105 status: 6)
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

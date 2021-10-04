;;; Sierra Script 1.0 - (do not remove this comment)
(script# 85)
(include sci.sh)
(use Main)
(use sewer)
(use SQRoom)
(use Sq4Feature)
(use Polygon)
(use Cycle)
(use Obj)

(public
	rm085 0
)

(instance rm085 of SQRoom
	(properties
		picture 85
		south 100
		west 80
		picAngle 70
		vanishingX 0
		vanishingY -40
	)
	
	(method (init)
		(sewer roomVer: 22891)
		(Load rsVIEW 85)
		(Load rsVIEW 80)
		(Load rsSOUND 810)
		(Load rsSOUND 811)
		(switch global12
			(west
				(proc0_3)
				(gEgo y: 100)
				(self style: 12)
				((ScriptID 702 3) init: hide: setScript: dripScript)
			)
			(south
				(cond 
					(
						(and
							(!= global12 100)
							(== (sewer location?) 0)
							(== (sewer status?) 0)
							(> (Random 0 100) 50)
						)
						((ScriptID 702 3) init: hide: setScript: dripScript)
					)
					((== (sewer location?) 85)
						(if (== (sewer status?) 6)
							(Load rsSOUND 818)
							(Load rsVIEW 76)
							((ScriptID 702 2)
								init:
								hide:
								setLoop: 1
								posn: 190 109
								setScript: (ScriptID 702 4)
							)
							(sewer status: 4)
						)
						(if (== (sewer status?) 8)
							(if (> (Random 0 100) 50)
								((ScriptID 702 2)
									init:
									hide:
									setLoop: 2
									posn: -15 91
									setScript: slimeLeaving
								)
							else
								((ScriptID 702 2)
									init:
									hide:
									setLoop: 1
									posn: 176 97
									setScript: (ScriptID 702 4)
								)
								(sewer status: 4)
							)
						)
					)
				)
				(self setScript: enterScript style: 10)
			)
			(else 
				((ScriptID 702 3) init: hide: setScript: dripScript)
				(gEgo view: 0)
				(gLongSong flags: 1)
				(gLongSong2 flags: 1)
				(self setScript: enterDoor)
			)
		)
		(door init: setPri: 10)
		(gEgo init: setPri: -1)
		((ScriptID 702 5)
			init:
			setLoop: 5
			posn: 311 144
			setScript: daDripScript
		)
		((ScriptID 702 6)
			init:
			setLoop: 4
			posn: 177 69
			setScript: daDripScript2
		)
		(super init:)
		(gEgo show:)
		((ScriptID 702 2) show:)
		(self
			setRegions: 702
			addObstacle:
				((Polygon new:)
					type: 2
					init: 0 100 160 100 271 189 0 189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 0 0 319 0 319 189 286 189 181 102 165 92 151 89 0 89
					yourself:
				)
		)
	)
	
	(method (doit)
		(cond 
			(script 0)
			((== (gEgo edgeHit?) 3) (proc0_2) (self setScript: exitSouth))
		)
		(super doit: &rest)
	)
)

(instance door of Sq4Prop
	(properties
		x 277
		y 134
		sightAngle 90
		view 85
		signal $6800
		lookStr 1
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(4 (gSq4GlobalNarrator say: 2))
			(2 (gSq4GlobalNarrator say: 3))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					illegalBits: 0
					x: 334
					y: 240
					setLoop: 7
					setMotion: MoveTo 280 186 self
				)
			)
			(1
				(proc0_1)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance dripScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0 (= seconds (Random 2 5)))
			(1
				(if (> (gEgo y?) 162)
					(sewer location: 85 status: 2 distance: 300)
					(gLongSong vol: 0 fade: 0 10 10 0)
					(gLongSong2 vol: 127 number: 806 loop: 1 play:)
					((ScriptID 702 3)
						show:
						setLoop: 6
						posn: 238 91
						cel: 0
						cycleSpeed: 12
						setCycle: CT 9 1 self
					)
				else
					(self init:)
				)
			)
			(2
				((ScriptID 702 3) setCycle: End)
				((ScriptID 702 2)
					init:
					setLoop: 8
					cycleSpeed: 12
					setCycle: End self
					posn: 214 124
				)
			)
			(3
				(sewer status: 3)
				(gLongSong2 vol: 127 number: 819 loop: -1 playBed:)
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

(instance exitSouth of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setLoop: -1 setHeading: 130 self)
			)
			(1
				(gEgo setLoop: 4 setMotion: MoveTo 327 237 self)
			)
			(2
				(if (== (sewer location?) 80)
					(sewer status: 0 location: 0)
				)
				(if
					(and
						(> (Random 0 100) 60)
						(== (sewer location?) 85)
						(== (sewer status?) 3)
						(< ((ScriptID 702 2) y?) 135)
					)
					(sewer status: 8)
				)
				(global2 newRoom: 100)
			)
		)
	)
)

(instance enterDoor of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLongSong vol: 127 number: 805 loop: -1 playBed:)
				(gEgo
					init:
					hide:
					posn: 240 158
					setCycle: 0
					setLoop: -1
					setHeading: 270
				)
				(door setCel: 255 cycleSpeed: 12)
				(= cycles 1)
			)
			(1
				(gLongSong2 vol: 127 number: 810 loop: 1 play:)
				(= cycles 5)
			)
			(2 (door setCycle: Beg self))
			(3
				(proc0_1)
				(gLongSong2 vol: 127 number: 811 play: self)
			)
			(4
				(gSq4GlobalNarrator say: 4 self)
			)
			(5 (proc0_3) (self dispose:))
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

(instance daDripScript2 of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				((ScriptID 702 6) setCycle: End self)
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
				((ScriptID 702 2) setMotion: MoveTo -39 91 self)
			)
			(1
				(sewer location: 80 status: 6)
				((ScriptID 702 2) posn: 1000 1000 dispose:)
				(self dispose:)
			)
		)
	)
)

;;; Sierra Script 1.0 - (do not remove this comment)
(script# 90)
(include sci.sh)
(use Main)
(use sewer)
(use SQRoom)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use Rev)
(use Cycle)
(use Obj)

(public
	rm090 0
)

(instance rm090 of SQRoom
	(properties
		picture 90
		horizon 47
		north 75
		east 95
		south 105
		west 105
		picAngle 70
		vanishingX 319
		vanishingY -50
	)
	
	(method (init)
		(sewer roomVer: 3591)
		(proc0_2)
		(Load rsVIEW 80)
		(Load rsVIEW 0)
		(Load rsVIEW 100)
		(switch global12
			(72
				(self setScript: climbDOWNscript)
			)
			(95
				(gEgo posn: 309 96)
				(if
				(and (== (sewer status?) 3) (== (sewer location?) 90))
					(if (> (sewer oldDistance?) 87)
						(sewer oldDistance: 87)
					)
					((ScriptID 702 2)
						posn: (- 271 (sewer oldDistance?)) 89
					)
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
				(self style: 11 setScript: enterRight)
			)
			(105
				(if
				(or (== (sewer status?) 1) (== (sewer status?) 2))
					(sewer status: 0 location: 0)
				)
				(if
				(and (== (sewer location?) 90) (== (sewer status?) 6))
					(Load rsSOUND 818)
					(Load rsVIEW 76)
					(sewer status: 3 prevDistance: 20)
				)
				(if
					(and
						(== (sewer status?) 3)
						(== (sewer location?) 105)
						(== ((ScriptID 702 2) loop?) 2)
					)
					(if (> ((ScriptID 702 2) x?) 180)
						(sewer status: 0 location: 0)
					else
						(sewer status: 6 rmTimer: 0)
					)
					(gLongSong2 vol: 0 fade: 0 10 10 0)
					(gLongSong vol: 127 playBed:)
				)
				(self setScript: enterSouth style: 10)
			)
			(north
				(if
				(and (== (sewer status?) 3) (== (sewer location?) 75))
					(cond 
						((> (sewer prevDistance?) 70) ((ScriptID 702 2) posn: 305 -32))
						((> (sewer prevDistance?) 50) ((ScriptID 702 2) posn: 300 -24))
						((> (sewer prevDistance?) 20) ((ScriptID 702 2) posn: 280 -10))
						(else ((ScriptID 702 2) posn: 274 -8))
					)
					((ScriptID 702 2)
						init:
						hide:
						setLoop: 0
						setCycle: Fwd
						cycleSpeed: 6
						moveSpeed: (- global199 2)
						setScript: (ScriptID 702 4)
					)
					(gEgo init: hide: posn: 244 29)
					(sewer location: 90)
				else
					(gEgo init: hide: posn: 283 -8)
				)
				(self setScript: enterNorth style: 10)
			)
			(else 
				(gLongSong number: 805 vol: 127 loop: -1 playBed:)
				(gEgo init: hide: posn: 283 -8)
				(self setScript: enterNorth style: 10)
			)
		)
		(super init:)
		((ScriptID 702 5)
			init:
			setLoop: 6
			posn: 229 44
			setPri: 5
			ignoreActors: 1
			cycleSpeed: 12
			setCycle: Fwd
		)
		((ScriptID 702 6)
			init:
			setLoop: 7
			posn: 27 130
			setScript: daDripScript
		)
		(gEgo show:)
		((ScriptID 702 2) show:)
		(theLadder init:)
		(self
			setRegions: 702
			addObstacle:
				((Polygon new:)
					type: 2
					init: 0 189 0 0 263 0 38 189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 48 189 150 105 163 101 319 101 319 189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 319 0 319 94 179 94 170 88 181 78 275 0
					yourself:
				)
		)
	)
	
	(method (doit)
		(cond 
			(script 0)
			((== (gEgo edgeHit?) 2)
				(if (== (sewer location?) 105)
					(sewer status: 0 location: 0)
				)
				(if
					(and
						(== (sewer location?) 90)
						(== (sewer status?) 3)
						(> ((ScriptID 702 2) y?) 135)
					)
					(sewer status: 8)
				)
				(if (> (sewer distance?) 30)
					(gLongSong2 vol: 0 fade: 0 10 10 0)
					(gLongSong vol: 127 playBed:)
				)
			)
			((== (gEgo edgeHit?) 1) (proc0_2) (self setScript: exitUp))
			((== (gEgo edgeHit?) 3) (proc0_2) (self setScript: exitDown))
			(
				(and
					(== (sewer status?) 6)
					(== (sewer location?) 105)
				)
				(Load rsSOUND 818)
				(Load rsVIEW 76)
				(if
				(or (< (gEgo y?) 143) (> (sewer rmTimer?) 7))
					(sewer location: 0 status: 0)
				)
			)
		)
		(if
			(and
				(& (gEgo onControl: 1) $0002)
				(== ((ScriptID 702 2) loop?) 0)
			)
			(sewer cantDie: 1)
		else
			(sewer cantDie: 0)
		)
		(if (< (gEgo y?) 50)
			(gEgo setPri: 4)
		else
			(gEgo setPri: -1)
		)
		(super doit: &rest)
	)
)

(instance exitUp of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setLoop: 6
					setMotion: PolyPath 283 -8 self
				)
			)
			(1
				(if (== (sewer location?) 105)
					(sewer status: 0 location: 0)
				)
				(if
				(and (== (sewer location?) 90) (== (sewer status?) 3))
					(sewer status: 6)
					(gLongSong2 vol: 0 fade: 0 10 10 0)
					(gLongSong vol: 127 playBed:)
				)
				(global2 newRoom: 75)
			)
		)
	)
)

(instance theLadder of Sq4Feature
	(properties
		x 75
		y 107
		nsTop 18
		nsLeft 73
		nsBottom 121
		nsRight 100
		sightAngle 45
		lookStr 1
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(4
				(proc0_2)
				(cond 
					((!= (sewer status?) 4) (global2 setScript: climbUPscript))
					(
						(and
							(> ((ScriptID 702 2) y?) 100)
							(== ((ScriptID 702 2) loop?) 0)
							(== (sewer status?) 3)
						)
						(gSq4GlobalNarrator say: 2)
					)
					(else (global2 setScript: climbUPscript))
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance climbUPscript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 98 129 self)
			)
			(1
				(gEgo
					posn: 98 129
					view: 100
					setLoop: 1
					setCel: 0
					cycleSpeed: 6
					ignoreActors: 1
					setCycle: Fwd
					setMotion: MoveTo 98 72 self
				)
				(gLongSong fade:)
				(gLongSong2 fade:)
			)
			(2
				(gLongSong number: 0)
				(gLongSong2 number: 0)
				(gEgo setCel: 255 ignoreActors: 0)
				(global2 newRoom: 72)
			)
		)
	)
)

(instance climbDOWNscript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gLongSong vol: 127 number: 805 loop: -1 playBed:)
				(gEgo
					init:
					view: 100
					posn: 98 69
					illegalBits: 0
					ignoreActors: 1
					setCel: 255
					setLoop: 1
					cycleSpeed: 6
				)
				(= cycles 1)
			)
			(1
				(gEgo setCycle: Rev setMotion: MoveTo 98 129 self)
			)
			(2
				(gEgo view: 0)
				(proc0_1)
				(= cycles 1)
			)
			(3
				(gEgo setLoop: -1 setHeading: 90 self)
			)
			(4
				(gEgo
					setMotion: MoveTo (+ (gEgo x?) 15) (gEgo y?) self
				)
			)
			(5 (proc0_3) (self dispose:))
		)
	)
)

(instance enterRight of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo init: hide: setMotion: MoveTo 290 96 self)
				(if
					(and
						(== (sewer status?) 3)
						(== (sewer location?) 95)
						(< (sewer prevDistance?) 30)
					)
					((ScriptID 702 2)
						init:
						hide:
						posn: 357 89
						setLoop: 2
						moveSpeed: (- global199 2)
						setScript: (ScriptID 702 4)
					)
					(gLongSong2 vol: 127 loop: -1 playBed:)
					(gLongSong vol: 0 fade: 0 10 10 0)
					(sewer location: 90)
				)
				(if
				(and (== (sewer location?) 90) (== (sewer status?) 8))
					((ScriptID 702 2)
						init:
						hide:
						posn: 53 173
						setLoop: 0
						moveSpeed: (- global199 2)
						setScript: slimeLeaving
					)
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

(instance enterSouth of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					init:
					hide:
					posn: -9 246
					setLoop: 6
					setMotion: PolyPath 53 180 self
				)
				(if
				(and (== (sewer status?) 3) (== (sewer location?) 90))
					((ScriptID 702 2) posn: 75 156)
					(if (> (sewer prevDistance?) 30)
						((ScriptID 702 2) posn: 90 144)
					)
					(if (> (sewer prevDistance?) 50)
						((ScriptID 702 2) posn: 107 128)
					)
					(if (> (sewer prevDistance?) 70)
						((ScriptID 702 2) posn: 140 100)
					)
					(if (> (sewer prevDistance?) 90)
						((ScriptID 702 2) posn: 176 72)
					)
					(if (> (sewer prevDistance?) 110)
						((ScriptID 702 2) posn: 239 21)
					)
					((ScriptID 702 2)
						init:
						hide:
						setLoop: 0
						moveSpeed: (- global199 2)
						setScript: (ScriptID 702 4)
					)
					(sewer status: 4)
					(gLongSong2 vol: 127 playBed:)
					(gLongSong vol: 0 fade: 0 10 10 0)
				)
			)
			(1
				(if
					(and
						(== (sewer location?) 105)
						(!= ((ScriptID 702 2) loop?) 2)
					)
					((ScriptID 702 2)
						init:
						posn: 22 199
						setLoop: 0
						setScript: (ScriptID 702 4)
					)
					(sewer location: 90)
				)
				(if
					(and
						(== (sewer location?) 90)
						(== (sewer status?) 3)
						(== ((ScriptID 702 2) loop?) 0)
					)
					((ScriptID 702 2) moveSpeed: (- global199 2))
				)
				(proc0_1)
				(proc0_3)
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
				(gEgo setLoop: 5 setMotion: PolyPath 208 56 self)
				(if
				(and (== (sewer status?) 6) (== (sewer location?) 90))
					(Load rsSOUND 818)
					(Load rsVIEW 76)
					((ScriptID 702 2)
						init:
						hide:
						posn: 171 79
						setLoop: 0
						setCycle: Fwd
						cycleSpeed: 6
						setScript: (ScriptID 702 4)
					)
					(sewer status: 4)
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

(instance exitDown of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gEgo setHeading: 225 self setMotion: 0)
			)
			(1
				(gEgo setLoop: 5 setMotion: PolyPath -9 246 self)
			)
			(2
				(if (< ((ScriptID 702 2) y?) 105)
					(sewer location: 0 status: 0)
					(gLongSong2 vol: 0 fade: 0 10 10 0)
					(gLongSong vol: 127 playBed:)
				)
				(global2 newRoom: 105)
			)
		)
	)
)

(instance daDripScript of Script
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
				((ScriptID 702 2)
					setCycle: Fwd
					setMotion: MoveTo 19 207 self
				)
			)
			(1
				(sewer location: 105 status: 3)
				((ScriptID 702 2) posn: 1000 1000 dispose:)
				(self dispose:)
			)
		)
	)
)

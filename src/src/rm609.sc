;;; Sierra Script 1.0 - (do not remove this comment)
(script# 609)
(include sci.sh)
(use Main)
(use ulence)
(use SQRoom)
(use Sq4Narrator)
(use Sq4Feature)
(use Polygon)
(use Cycle)
(use Obj)

(public
	rm609 0
)

(instance rm609 of SQRoom
	(properties
		picture 609
		horizon 92
		north 612
		east 610
	)
	
	(method (init)
		(switch gWest
			(610
				(if (< (gEgo y?) 147) (gEgo y: 147))
				(if (== (ulence status?) 99)
					(gEgo posn: 84 100)
					(self setScript: hideEgo)
				else
					(gLongSong2 number: 0 vol: 0 stop:)
				)
			)
			(612
				(cond 
					((< (gEgo x?) 175) (gEgo x: 151))
					((> (gEgo x?) 263) (gEgo x: 294))
					(else (gEgo x: 248))
				)
			)
			(else  (gEgo x: 247 y: 110))
		)
		(gEgo init: illegalBits: 0 ignoreActors: 1)
		(ship1 init:)
		(hole init:)
		(super init:)
		(self
			setRegions: 706
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						131
						87
						124
						98
						93
						98
						90
						103
						150
						103
						161
						110
						65
						131
						13
						132
						18
						163
						18
						189
						0
						189
						0
						0
						319
						0
						319
						85
						219
						85
						232
						101
						170
						100
						162
						87
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						166
						137
						185
						147
						185
						154
						175
						159
						156
						164
						122
						164
						93
						157
						94
						144
						122
						136
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 294 151 294 161 238 161 238 151
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 319 105 287 105 287 94 319 94
					yourself:
				)
		)
		(ship2 init:)
		(tinysHut init:)
		(theSign init:)
		((ScriptID 706 8)
			init:
			nsLeft: 0
			nsTop: 0
			nsBottom: 71
			nsRight: 319
		)
		((ScriptID 706 7)
			init:
			nsLeft: 0
			nsTop: 72
			nsBottom: 189
			nsRight: 318
		)
	)
	
	(method (doit)
		(cond 
			(script 0)
			(
			(and (== (gEgo edgeHit?) 2) (< (gEgo y?) 100)) (self setScript: exitRight))
		)
		(super doit: &rest)
	)
)

(instance hideEgo of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				((ScriptID 706 6) init: play:)
				((ScriptID 706 1)
					init:
					posn: 329 173
					setLoop: 1
					setMotion: MoveTo -20 173 self
				)
			)
			(1
				((ScriptID 706 6) fade:)
				((ScriptID 706 1)
					hide:
					view: 633
					setLoop: 1
					posn: 343 83
				)
				(= seconds (Random 2 4))
			)
			(2
				((ScriptID 706 6) play:)
				((ScriptID 706 1)
					show:
					setPri: 4
					setMotion: MoveTo 247 83 self
				)
			)
			(3
				((ScriptID 706 1)
					posn: 244 85
					setLoop: 2
					setMotion: MoveTo 244 235 self
				)
			)
			(4
				((ScriptID 706 6) fade:)
				(gLongSong2 fade:)
				(proc0_1 0 0)
				(gEgo setMotion: MoveTo 160 101 self)
			)
			(5
				(gEgo setMotion: MoveTo 187 125 self)
			)
			(6 (tROG say: 1 self))
			(7
				(proc0_3)
				(ulence status: 1)
				(self dispose:)
			)
		)
	)
)

(instance exitRight of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					setMotion: MoveTo (+ (gEgo x?) 10) (gEgo y?) self
				)
			)
			(1 (global2 newRoom: 613))
		)
	)
)

(instance ship1 of Sq4View
	(properties
		x 136
		y 155
		sightAngle 90
		view 609
		priority 11
		signal $6010
		lookStr 1
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(4 (gSq4GlobalNarrator say: 2))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hole of Sq4View
	(properties
		x 268
		y 158
		nsTop 150
		nsLeft 243
		nsBottom 166
		nsRight 294
		sightAngle 90
		view 609
		loop 1
		signal $6010
		lookStr 3
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(4 (gSq4GlobalNarrator say: 4))
			(7 (gSq4GlobalNarrator say: 5))
			(6 (gSq4GlobalNarrator say: 6))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theSign of Sq4Feature
	(properties
		y 44
		nsLeft 100
		nsBottom 44
		nsRight 191
		sightAngle 90
		onMeCheck $0004
		lookStr 7
	)
)

(instance ship2 of Sq4Feature
	(properties
		x 319
		y 101
		nsTop 72
		nsLeft 292
		nsBottom 101
		nsRight 319
		sightAngle 90
		onMeCheck $0010
		lookStr 8
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(4 (gSq4GlobalNarrator say: 2))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tinysHut of Sq4Feature
	(properties
		y 128
		nsTop 32
		nsLeft 3
		nsBottom 128
		nsRight 136
		sightAngle 90
		onMeCheck $0002
		lookStr 9
	)
)

(instance tROG of Sq4Talker
	(properties
		z 400
		noun 7
		view 1008
		talkerNum 7
		mouthOffsetX 22
		mouthOffsetY 31
		eyeOffsetX 27
		eyeOffsetY 21
	)
)

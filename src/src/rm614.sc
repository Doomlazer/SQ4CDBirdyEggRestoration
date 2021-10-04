;;; Sierra Script 1.0 - (do not remove this comment)
(script# 614)
(include sci.sh)
(use Main)
(use ulence)
(use SQRoom)
(use Sq4Feature)
(use Polygon)
(use Cycle)
(use Obj)

(public
	rm614 0
)

(local
	local0
)
(instance rm614 of SQRoom
	(properties
		picture 614
		south 611
		west 613
	)
	
	(method (init)
		(switch gWest
			(611
				(cond 
					((> (gEgo x?) 245) (proc0_2) (gEgo posn: 254 241 setMotion: MoveTo 320 174))
					((> (gEgo x?) 230) (gEgo x: (Random 202 302)))
					((> (gEgo x?) 195) (gEgo x: (Random 85 201)))
					(else (gEgo x: (Random 20 84)))
				)
			)
			(else  (gEgo x: 24 y: 181))
		)
		(gEgo init: ignoreActors: 1 illegalBits: 0)
		(super init:)
		(self
			setRegions: 706
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						0
						319
						0
						319
						189
						317
						189
						317
						152
						266
						161
						206
						161
						179
						153
						86
						153
						83
						161
						0
						161
					yourself:
				)
		)
		(sign1 init:)
		(sign2 init:)
		(gate init:)
		(building init:)
		(if
		(and (> (Random 0 100) 20) (== (ulence status?) 1))
			(ulence status: 2 bikerComing: 1)
			(Load rsVIEW 634)
			(Load rsVIEW 635)
			(Load rsSOUND 50)
		else
			(ulence bikerComing: 0)
		)
		((ScriptID 706 7)
			init:
			nsLeft: 0
			nsTop: 86
			nsBottom: 189
			nsRight: 319
		)
		((ScriptID 706 8)
			init:
			nsLeft: 0
			nsTop: 0
			nsBottom: 86
			nsRight: 319
		)
	)
	
	(method (doit)
		(if
			(and
				(== (ulence status?) 4)
				(< ((ScriptID 706 1) distanceTo: gEgo) 15)
			)
			(proc0_2)
			(ulence status: 6)
			(gEgo setScript: 0)
			(ulence deathLoop: 0)
			(self setScript: (ScriptID 706 3))
		)
		(cond 
			(script 0)
			(
				(and
					(== (ulence status?) 2)
					(gEgo inRect: 20 171 46 182)
					local0
				)
				(proc0_2)
				(ulence status: 3)
				((ScriptID 706 1)
					init:
					view: 634
					hide:
					posn: 308 217
					setScript: runOverScript
				)
				(= local0 0)
				(gEgo setScript: (ScriptID 706 4))
			)
		)
		(super doit: &rest)
		(if (> (gEgo x?) 60) (= local0 1))
	)
)

(instance runOverScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(ulence egoBusy: 1)
				(gLongSong
					vol: 25
					number: 50
					loop: -1
					playBed:
					fade: 127 10 10 0
				)
				(= seconds 3)
			)
			(1
				((ScriptID 706 6) init: fade:)
				((ScriptID 706 1)
					show:
					setLoop: 7
					setMotion: MoveTo 246 (- (gEgo y?) 5) self
				)
			)
			(2
				(ulence status: 4)
				(proc0_3)
				((ScriptID 706 1)
					setLoop: 1
					setPri: (+ (gEgo priority?) 1)
					setMotion: MoveTo -51 (- (gEgo y?) 5) self
				)
			)
			(3
				(gLongSong fade:)
				((ScriptID 706 6) fade:)
				((ScriptID 706 1) hide:)
				(= seconds 3)
			)
			(4
				(if (!= (ulence status?) 6)
					(ulence status: 1 fieldOff: 0 bikerComing: 0 egoBusy: 0)
					(gEgo setScript: 0)
					(gSq4GlobalNarrator modNum: 611 say: 1 self)
				)
				(= cycles 2)
			)
			(5 (proc0_3) (self dispose:))
		)
	)
)

(instance building of Sq4Feature
	(properties
		x 155
		y 84
		nsTop 7
		nsBottom 161
		nsRight 311
		sightAngle 45
		onMeCheck $0002
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 2))
			(6 (gSq4GlobalNarrator say: 1))
			(7 (gSq4GlobalNarrator say: 2))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gate of Sq4Feature
	(properties
		x 125
		y 115
		nsTop 76
		nsLeft 60
		nsBottom 154
		nsRight 191
		sightAngle 45
		onMeCheck $0008
		lookStr 3
	)
)

(instance sign1 of Sq4Feature
	(properties
		x 125
		y 59
		nsTop 45
		nsLeft 37
		nsBottom 73
		nsRight 214
		sightAngle 45
		onMeCheck $0010
		lookStr 4
	)
)

(instance sign2 of Sq4Feature
	(properties
		x 126
		y 130
		nsTop 122
		nsLeft 108
		nsBottom 138
		nsRight 145
		sightAngle 45
		onMeCheck $0004
		lookStr 5
	)
)

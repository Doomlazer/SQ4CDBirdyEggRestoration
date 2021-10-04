;;; Sierra Script 1.0 - (do not remove this comment)
(script# 330)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Feature)
(use n958)
(use Sound)
(use Cycle)
(use User)
(use View)
(use Obj)

(public
	rm330 0
)

(instance rm330 of SQRoom
	(properties
		picture 330
		style $000c
	)
	
	(method (init)
		(proc958_0 128 330 324 331)
		(gLongSong number: 60 vol: 127 loop: -1 flags: 1)
		(proc958_0 132 126 133)
		(super init:)
		(theArea init:)
		(pillar init:)
		(guard init:)
		(proc0_14 10)
		(self setScript: subScript)
	)
)

(instance subScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(sub setCycle: Fwd init: setMotion: MoveTo 106 101)
				(subTop init: setMotion: MoveTo 103 103 self)
			)
			(1
				(sub setLoop: 3)
				(gLongSong2 stop:)
				(soundFX play:)
				(= seconds 3)
			)
			(2
				(soundFX number: 133 play:)
				(hatch
					init:
					posn: (+ (subTop x?) 23) (+ (subTop y?) 1)
					cycleSpeed: 15
					setCycle: End self
				)
			)
			(3
				(hatch stopUpd:)
				(= cycles 10)
			)
			(4
				(proc0_3)
				(User canControl: 0)
				(gIconBar disable: 0)
				(anEgo
					init:
					view: 324
					x: (- (hatch x?) 8)
					y: (+ (hatch y?) 4)
					loop: 8
					cel: 0
					cycleSpeed: 12
					setPri: 6
					illegalBits: 0
					setCycle: End self
				)
			)
			(5 (= ticks 10))
			(6
				(anEgo
					view: 0
					posn: 134 104
					setPri: 6
					setSpeed: global199
					setCycle: Walk
				)
				(= ticks 10)
			)
			(7
				(anEgo setMotion: MoveTo 202 91 self)
			)
			(8
				(gLongSong playBed: hold: 1)
				(zondra
					posn: (+ (subTop x?) 10) (- (subTop y?) 18)
					init:
					setSpeed: global199
					setCycle: End self
				)
				(anEgo setMotion: MoveTo 338 96)
			)
			(9
				(zondra
					view: 331
					setLoop: 2
					setCycle: Walk
					setPri: 6
					posn: 137 99
					setMotion: MoveTo 205 87
				)
				(anEgo setMotion: MoveTo 338 96)
				(= seconds 3)
			)
			(10
				(zondra setMotion: MoveTo 340 88)
				(guard
					view: 331
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 345 96
				)
				(= seconds 5)
			)
			(11 (global2 newRoom: 335))
		)
	)
)

(instance sub of Sq4Actor
	(properties
		x -22
		y 101
		sightAngle 180
		yStep 1
		view 330
		priority 2
		signal $4810
		illegalBits $0000
		xStep 2
		lookStr 1
	)
)

(instance subTop of Sq4Actor
	(properties
		x -25
		y 103
		sightAngle 180
		yStep 1
		view 330
		loop 1
		cel 4
		priority 3
		signal $4810
		illegalBits $0000
		xStep 2
		lookStr 1
	)
)

(instance hatch of Sq4Prop
	(properties
		x 125
		y 104
		sightAngle 180
		view 330
		loop 2
		priority 5
		signal $4810
		cycleSpeed 12
		lookStr 2
	)
)

(instance guard of Sq4Actor
	(properties
		x 235
		y 103
		yStep 3
		view 331
		priority 6
		xStep 4
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 3))
			(4 (gSq4GlobalNarrator say: 4))
			(2 (gSq4GlobalNarrator say: 5))
			(6 (gSq4GlobalNarrator say: 6))
			(7 (gSq4GlobalNarrator say: 6))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance zondra of Sq4Actor
	(properties
		x 114
		y 85
		sightAngle 180
		yStep 3
		view 324
		loop 9
		priority 7
		signal $0010
		illegalBits $0000
		xStep 4
		lookStr 7
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gSq4GlobalNarrator say: 8))
			(2 (gSq4GlobalNarrator say: 9))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance soundFX of Sound
	(properties
		number 126
	)
)

(instance theArea of Sq4Feature
	(properties
		x 156
		y 10
		nsBottom 200
		nsRight 320
		sightAngle 180
		lookStr 10
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (gSq4GlobalNarrator say: 11))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance pillar of Sq4Feature
	(properties
		x 292
		y 110
		nsTop 28
		nsLeft 275
		nsBottom 125
		nsRight 319
		sightAngle 180
		lookStr 12
	)
)

(instance anEgo of Actor
	(properties
		view 324
	)
)

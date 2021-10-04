;;; Sierra Script 1.0 - (do not remove this comment)
(script# 153)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Narrator)
(use Sq4Feature)
(use Osc)
(use n958)
(use Sound)
(use Cycle)
(use User)
(use Obj)

(public
	rm153 0
)

(local
	[local0 2]
	local2
	local3 =  10
	local4 =  15
	[local5 53] = [161 189 186 154 120 91 87 118 119 107 80 67 61 79 107 126 2 2 122 99 2 3 122 99 2 2 122 99 2 3 122 99 2 2 122 99 2 3 122 99 2 2 122 99 2 3 122 99 2 2 122 99 -32768]
)
(instance rm153 of SQRoom
	(properties
		picture 150
	)
	
	(method (init)
		(proc958_0 128 522 520 521)
		(proc958_0 132 49 118 119 120 121)
		(gEgo setCycle: 0)
		(super init:)
		(lOrb init:)
		(rOrb init:)
		(self setScript: captiveScript)
	)
	
	(method (doit)
		(super doit:)
		(if
		(and (not local2) (== (gLongSong prevSignal?) 10))
			(= local2 1)
		)
	)
)

(instance captiveScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLongSong number: 49 playBed:)
				(vohaul init:)
				(police
					init:
					setCycle: Walk
					setMotion: MoveTo 200 158 self
				)
			)
			(1 (= seconds 3))
			(2
				(police ignoreActors: 0 setLoop: 7 setCel: 0)
				(gesturingPolice
					ignoreActors: 0
					init:
					posn: (- (police x?) 9) (- (police y?) 1)
					setPri: (+ (police priority?) 1)
				)
				(policeMouth
					ignoreActors: 0
					init:
					posn: (- (police x?) 13) (- (police y?) 37)
					setPri: (+ (police priority?) 1)
				)
				(theMouth init:)
				(theEyes init:)
				(tSLUDGE
					init: 0 theEyes theMouth
					say: 1 self 2 64 10 10 25 global135 26 global129 67 300
				)
			)
			(3
				(gesturingPolice
					ignoreActors: 0
					init:
					posn: (- (police x?) 9) (- (police y?) 1)
					setPri: (+ (police priority?) 1)
				)
				(policeMouth
					ignoreActors: 0
					init:
					posn: (- (police x?) 13) (- (police y?) 37)
					setPri: (+ (police priority?) 1)
				)
				(tCOPS
					init: 0 gesturingPolice policeMouth
					say:
						1
						self
						2
						64
						10
						160
						25
						(proc0_18 global153 global152)
						26
						global129
						67
						300
				)
			)
			(4
				(tCOPS
					say:
						2
						self
						2
						64
						10
						160
						25
						(proc0_18 global153 global152)
						26
						global129
						67
						300
				)
			)
			(5
				(tCOPS
					say:
						3
						self
						2
						64
						10
						160
						25
						(proc0_18 global153 global152)
						26
						global129
						67
						300
				)
			)
			(6
				(tSLUDGE
					say: 2 self 2 64 10 10 25 global135 26 global129 67 300
				)
			)
			(7
				(tSLUDGE
					say: 3 self 2 64 10 10 25 global135 26 global129 67 300
				)
			)
			(8
				(tSLUDGE
					say: 4 self 2 64 10 10 25 global135 26 global129 67 300
				)
			)
			(9
				(= register 0)
				(User canControl: 0)
				(theEyes dispose:)
				(= cycles 1)
			)
			(10
				(theMouth dispose:)
				(= seconds 2)
			)
			(11
				(global2 drawPic: 803 6)
				(global2 newRoom: 365)
			)
		)
	)
)

(instance police of Sq4Actor
	(properties
		x 349
		y 218
		view 521
		loop 1
		priority 6
		signal $0010
	)
)

(instance gesturingPolice of Sq4Prop
	(properties
		x 336
		y 181
		view 521
		loop 3
		priority 6
		signal $0010
	)
)

(instance policeMouth of Sq4Prop
	(properties
		x 340
		y 217
		view 521
		loop 5
		priority 6
		signal $0010
	)
)

(instance vohaul of Sq4Prop
	(properties
		x 121
		y 84
		view 520
		priority 10
		signal $0010
	)
)

(instance theEyes of Sq4Prop
	(properties
		x 132
		y 69
		view 520
		loop 1
		cel 1
		priority 12
		signal $0010
		cycleSpeed 18
	)
)

(instance theMouth of Sq4Prop
	(properties
		x 144
		y 117
		view 520
		loop 2
		priority 11
		signal $0010
	)
)

(instance lOrbZap of Sound
	(properties)
)

(instance rOrbZap of Sound
	(properties)
)

(instance lOrb of Sq4Prop
	(properties
		x 47
		y 123
		view 151
		priority 8
		lookStr 1
	)
	
	(method (doit)
		(super doit:)
		(if (and local3 (not (-- local3)))
			(if (< (Random 1 10) 5) (= loop 0) else (= loop 2))
			(if (< (Random 1 10) 5)
				(if (and local2 (not (captiveScript state?)))
					(lOrbZap number: (if loop 120 else 118) play:)
				)
				(self setCycle: Osc 1 self)
			else
				(if (and local2 (not (captiveScript state?)))
					(lOrbZap number: (if loop 120 else 118) play:)
				)
				(self setCycle: End self)
			)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(else  (super doVerb: theVerb))
		)
	)
	
	(method (cue)
		(= local3 (Random 20 50))
		(self stopUpd:)
		(super cue:)
	)
)

(instance rOrb of Sq4Prop
	(properties
		x 230
		y 87
		view 151
		loop 1
		priority 8
		lookStr 1
	)
	
	(method (doit)
		(super doit:)
		(if (and local4 (not (-- local4)))
			(if (< (Random 1 10) 5) (= loop 1) else (= loop 3))
			(if (< (Random 1 10) 5)
				(if (and local2 (not (captiveScript state?)))
					(rOrbZap number: (if (== loop 3) 121 else 119) play:)
				)
				(self setCycle: Osc 1 self)
			else
				(if (and local2 (not (captiveScript state?)))
					(rOrbZap number: (if (== loop 3) 121 else 119) play:)
				)
				(self setCycle: End self)
			)
		)
	)
	
	(method (doVerb theVerb)
		(lOrb doVerb: theVerb &rest)
	)
	
	(method (cue)
		(= local4 (Random 20 50))
		(rOrbZap stop:)
		(self stopUpd:)
		(super cue:)
	)
)

(instance tSLUDGE of FaceTalker
	(properties
		talkerNum 6
	)
)

(instance tCOPS of FaceTalker
	(properties
		talkerNum 17
	)
)

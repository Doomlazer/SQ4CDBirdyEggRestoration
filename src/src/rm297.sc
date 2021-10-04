;;; Sierra Script 1.0 - (do not remove this comment)
(script# 297)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Narrator)
(use Sq4Feature)
(use MCyc)
(use PolyPath)
(use Polygon)
(use n958)
(use StopWalk)
(use Sound)
(use Cycle)
(use User)
(use Obj)

(public
	rm297 0
)

(local
	[local0 41] = [0 2 202 19 0 2 198 28 0 3 194 35 0 2 191 55 0 3 188 69 0 2 185 90 0 3 182 104 0 2 178 125 0 3 175 141 0 6 169 106 -32768]
	[local41 21] = [0 6 166 88 0 5 159 99 0 4 158 132 0 5 156 124 0 6 157 127 -32768]
	[local62 29] = [0 0 75 9 0 0 77 32 0 0 78 56 0 0 78 77 0 1 84 79 0 2 89 103 0 3 89 98 -32768]
	local91
)
(instance rm297 of SQRoom
	(properties
		picture 297
	)
	
	(method (init &tmp [temp0 50])
		(proc958_0 132 129 130 131 134)
		(proc958_0 128 392 304)
		(Load rsSCRIPT 942)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						189
						0
						0
						319
						0
						319
						189
						233
						189
						220
						154
						227
						133
						191
						124
						152
						118
						112
						121
						92
						128
						79
						129
						93
						154
						206
						154
						218
						189
					yourself:
				)
		)
		(hole init:)
		(theSkulls init:)
		(theNest init:)
		(theRoom init:)
		(gEgo
			init:
			view: 392
			normal: 0
			setLoop: 1
			x: 202
			y: -20
			setPri: 6
		)
		(if (proc0_6 37)
			(sp init: loop: 4 cel: 0 posn: 89 98 stopUpd:)
		)
		(super init:)
		(self setScript: fallScript)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script (script doit:))
			(
				(and
					(not local91)
					(not (gEgo mover?))
					(proc0_6 37)
					(== (Random 1 3000) 50)
				)
				(= local91 1)
				(maharg init:)
			)
			((proc0_5 gEgo 1024) (proc0_2) (global2 setScript: exitNest))
		)
	)
	
	(method (newRoom newRoomNumber)
		(if
			(and
				(== script exitNest)
				(< (exitNest state?) 3)
				(== (gEgo edgeHit?) 3)
			)
			(= newRoomNumber 0)
		else
			(super newRoom: newRoomNumber)
		)
	)
)

(instance maharg of Sq4Prop
	(properties
		y 50
		view 304
		loop 3
		signal $0800
		lookStr 1
	)
	
	(method (init)
		(super init: &rest)
		(self setCycle: Fwd doit:)
	)
	
	(method (doit)
		(super doit:)
		(if (<= x 320)
			(self x: (+ x 3) y: (- y 1))
		else
			(self dispose:)
		)
	)
)

(instance fallScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLongSong stop:)
				(aSound number: 131 loop: 1 play:)
				(gEgo setCycle: MCyc @local0 self)
			)
			(1
				(aSound number: 129 play:)
				(gEgo setCycle: MCyc @local41 self)
			)
			(2
				(aSound number: 130 play:)
				(= cycles 10)
			)
			(3
				(gEgo
					view: 0
					normal: 1
					setLoop: -1
					loop: 2
					x: 157
					y: 127
					setCycle: StopWalk 4
					setPri: -1
					setStep: 3 2
				)
				(gLongSong number: 53 loop: -1 vol: 127 playBed:)
				(= cycles 1)
			)
			(4
				(if (not (proc0_6 32)) (gSq4GlobalNarrator say: 2))
				(= cycles 1)
			)
			(5
				(if (not (proc0_6 37))
					(sp init: setScript: spFallScript)
				)
				(= cycles 1)
			)
			(6 (proc0_3) (self dispose:))
		)
	)
)

(instance spFallScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (proc0_6 32) (self cue:) else (= cycles 75))
			)
			(1
				(proc0_7 37)
				(spSound play:)
				(= cycles 3)
			)
			(2
				(sp setCycle: MCyc @local62 self)
			)
			(3
				(spSound number: 134 vol: 127 play:)
				(sp stopUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance searchBody of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo illegalBits: 0 setMotion: PolyPath 105 130 self)
			)
			(1
				(gEgo
					normal: 0
					view: 304
					loop: 1
					cel: 0
					x: (- (gEgo x?) 5)
					cycleSpeed: 18
					setCycle: End
				)
				(= cycles 20)
			)
			(2
				(gEgo setCycle: Beg)
				(= cycles 20)
			)
			(3
				(gSq4GlobalNarrator say: 3)
				(proc0_11 55 5)
				(gEgo
					normal: 1
					view: 0
					cycleSpeed: 6
					setCycle: StopWalk 4
					setMotion: MoveTo (gEgo x?) (+ (gEgo y?) 2) self
				)
			)
			(4
				(proc0_3)
				(gEgo illegalBits: -32768)
				(client setScript: 0)
			)
		)
	)
)

(instance exitNest of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo illegalBits: 0 setMotion: PolyPath 212 158 self)
			)
			(1
				(gEgo
					normal: 0
					view: 304
					setLoop: 2
					cel: 0
					cycleSpeed: 12
					setCycle: CT 10 1 self
				)
			)
			(2
				(gEgo setPri: 14 setCycle: End self)
			)
			(3
				(gLongSong2 number: 131 vol: 127 loop: 1 play:)
				(gEgo yStep: 20 setMotion: MoveTo (gEgo x?) 240 self)
			)
			(4 (= seconds 3))
			(5
				(gLongSong2 number: 143 loop: 0 setVol: 127 play: self)
			)
			(6 (gLongSong fade: self))
			(7
				(gEgo illegalBits: -32768)
				(global2 newRoom: 320)
			)
		)
	)
)

(instance sp of Sq4Prop
	(properties
		x 75
		y -20
		sightAngle 45
		view 304
		priority 6
		signal $4010
		lookStr 4
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 4))
			(4
				(if (== ((gInv at: 6) owner?) 297)
					(gEgo get: 6)
					(proc0_2)
					(global2 setScript: searchBody)
				else
					(gSq4GlobalNarrator say: 5)
				)
			)
			(2
				(tRogNar say: 1)
				(gSq4GlobalNarrator say: 6)
			)
			(6 (gSq4GlobalNarrator say: 7))
			(7 (gSq4GlobalNarrator say: 8))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance hole of Sq4Feature
	(properties
		x 211
		y 152
		nsTop 146
		nsLeft 200
		nsBottom 158
		nsRight 223
		sightAngle 45
		lookStr 9
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(proc0_2)
				(global2 setScript: exitNest)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theRoom of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		sightAngle 45
		lookStr 10
	)
	
	(method (doVerb theVerb)
		(self
			x: ((User curEvent?) x?)
			y: ((User curEvent?) y?)
		)
		(switch theVerb
			(2
				(if (not (global2 script?))
					(global2 setScript: sEcho)
				else
					(super doVerb: theVerb)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance sEcho of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 3])
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: 0 setCycle: 0)
				(= cycles 2)
			)
			(1
				(gEgo view: 297 cel: 0)
				(= ticks 30)
			)
			(2 (gEgo setCycle: End self))
			(3 (tRogNar say: 2 self))
			(4 (gEgo setCycle: Beg self))
			(5
				(proc0_1 3 0)
				(proc0_3)
				(client setScript: 0)
			)
		)
	)
)

(instance theSkulls of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck $4000
		lookStr 11
	)
	
	(method (doVerb theVerb)
		(self
			x: ((User curEvent?) x?)
			y: ((User curEvent?) y?)
		)
		(switch theVerb
			(2 (gSq4GlobalNarrator say: 12))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theNest of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck $0020
		lookStr 13
	)
)

(instance aSound of Sound
	(properties)
)

(instance spSound of Sound
	(properties
		number 131
		vol 85
	)
)

(instance tRogNar of Sq4Narrator
	(properties
		noun 7
		modNum 297
		disposeWhenDone 0
		talkerNum 7
	)
)

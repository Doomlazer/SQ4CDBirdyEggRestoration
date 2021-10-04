;;; Sierra Script 1.0 - (do not remove this comment)
(script# 540)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Narrator)
(use Sq4Feature)
(use IconI)
(use MCyc)
(use PolyPath)
(use Polygon)
(use n958)
(use StopWalk)
(use Sound)
(use Cycle)
(use InvI)
(use Obj)

(public
	rm540 0
)

(local
	[local0 37] = [0 0 155 138 0 1 155 138 0 1 155 138 0 1 155 138 0 2 155 138 0 3 155 138 0 4 155 138 0 5 155 138 0 6 155 138 -32768]
	[local37 33] = [0 0 0 0 1 0 145 108 1 1 145 108 1 2 145 108 1 3 145 108 1 4 145 107 1 5 149 101 0 0 0 0 -32768]
	local70
)
(procedure (localproc_0062 param1 param2 param3 param4 &tmp temp0 temp1 temp2)
	(aSound number: 105 loop: 1 vol: 127 play:)
	(if (< param1 param3)
		(= temp0 (- param1 1))
		(= temp1 (+ param3 1))
	else
		(= temp0 (- param3 1))
		(= temp1 (+ param1 1))
	)
	(= temp2
		(Graph
			grSAVE_BOX
			temp0
			(- param2 1)
			temp1
			(+ param4 1)
			1
		)
	)
	(Graph
		grDRAW_LINE
		param1
		param2
		param3
		param4
		global143
		-1
		-1
	)
	(Graph
		grREDRAW_BOX
		temp0
		(- param2 1)
		temp1
		(+ param4 1)
	)
	(Wait 1)
	(Wait 4)
	(Graph grRESTORE_BOX temp2)
	(Graph
		grREDRAW_BOX
		temp0
		(- param2 1)
		temp1
		(+ param4 1)
	)
)

(instance aSound of Sound
	(properties)
)

(instance rm540 of SQRoom
	(properties
		picture 540
		north 541
		west 535
		vanishingX 0
		vanishingY -60
	)
	
	(method (init)
		(proc958_0 128 515 300 7 13 511)
		(if (!= gWest 556)
			(proc958_0 132 105 131 124 154 155 820 825)
		)
		(tunnel init:)
		(switch gWest
			(541
				(self setScript: enterScript)
			)
			(556
				(proc958_0 128 558 556)
				(proc958_0 132 821 871)
				(gEgo moveHead: 0 setLoop: 0 x: 115 y: 142 init:)
				(proc0_1 0 0 4)
				(proc0_9 4)
				(rogerJr init:)
				(gLongSong2 number: 871 vol: 127 loop: -1 flags: 1)
				(self setScript: endScript)
			)
			(west
				(self style: 12 setScript: enterFromWest 0 (proc0_6 32))
			)
			(else  (gEgo x: 160 y: 160))
		)
		(if (!= gWest 541)
			(drBottom init: stopUpd:)
			(drTop init: stopUpd:)
		)
		(gEgo
			view: 0
			headView: 4
			normal: 1
			moveHead: 1
			setCycle: StopWalk 4
			init:
		)
		(super init:)
		(self setRegions: 709)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init: 0 151 53 151 59 189 0 189
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						0
						0
						319
						0
						319
						189
						241
						135
						254
						135
						231
						121
						271
						108
						210
						56
						193
						56
						215
						86
						163
						86
						159
						78
						136
						78
						147
						88
						87
						88
						62
						53
						0
						53
					yourself:
				)
		)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script)
			((< (gEgo x?) 28) (global2 newRoom: 535))
		)
	)
)

(instance police of Sq4Actor
	(properties
		x 259
		y 147
		view 7
		loop 2
		cel 2
	)
	
	(method (init)
		(super init:)
		(= local70 75)
	)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(not (-- local70))
				(!= (global2 script?) (ScriptID 709 1))
			)
			(global2 setScript: 0)
			(self setScript: policeScript)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 1))
			(2 (= local70 1))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance drTop of Sq4Actor
	(properties
		x 141
		y 77
		z 22
		sightAngle 90
		view 515
		priority 3
		signal $6810
		illegalBits $0000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (proc0_6 7)
					(gSq4GlobalNarrator say: 2)
				else
					(gSq4GlobalNarrator say: 3)
				)
			)
			(4
				(proc0_2)
				(global2 setScript: drScript)
			)
			(13
				(cond 
					(
					(and (== ((Inv at: 5) cel?) 2) (not (proc0_6 7))) (proc0_2) (global2 setScript: acidScript))
					((== ((Inv at: 5) cel?) 2) (gSq4GlobalNarrator say: 4))
					(else (super doVerb: theVerb))
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance drBottom of Sq4Actor
	(properties
		x 141
		y 76
		view 515
		cel 1
		priority 2
		signal $6810
		illegalBits $0000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (proc0_6 7)
					(gSq4GlobalNarrator say: 2)
				else
					(gSq4GlobalNarrator say: 3)
				)
			)
		)
	)
)

(instance enterFromWest of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo x: 5 setMotion: MoveTo 50 (gEgo y?) self)
				(if (not register) (police init:))
			)
			(1 (proc0_3) (self dispose:))
		)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 4])
		(switch (= state newState)
			(0
				(proc0_2)
				(gLongSong2 number: 535 loop: -1 playBed:)
				(gEgo
					x: 129
					y: 70
					setLoop: 4
					illegalBits: 0
					setMotion: PolyPath 165 96 self
				)
			)
			(1
				(blopSound init: number: 154 vol: 127 loop: -1 play:)
				(drTop init: y: 35 setMotion: MoveTo (drTop x?) 77 self)
				(drBottom init: y: 95 setMotion: MoveTo (drBottom x?) 76)
			)
			(2
				(blopSound number: 155 vol: 127 loop: 0 play:)
				(proc0_3)
				(gEgo setLoop: -1)
				(client setScript: 0)
			)
		)
	)
)

(instance policeScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(police setHeading: 315)
				(= cycles 4)
			)
			(1
				(gSq4GlobalNarrator say: 5)
				(police view: 13 setLoop: 1 setCel: 0)
				(= cycles 1)
			)
			(2
				(police setCycle: End self)
				(localproc_0062
					(- (gEgo y?) 32)
					(gEgo x?)
					(- (police y?) 27)
					(police x?)
				)
			)
			(3
				(gEgo
					view: 511
					setLoop: 0
					setMotion: 0
					setCel: 0
					setCycle: End self
				)
			)
			(4 (proc0_10 8))
		)
	)
)

(instance drScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 155 78 self)
			)
			(1 (= cycles 5))
			(2
				(if (proc0_6 7)
					(= cycles 1)
				else
					(gSq4GlobalNarrator say: 6)
					(proc0_3)
					(self dispose:)
				)
			)
			(3
				(gLongSong number: 124 loop: 0 play: self)
			)
			(4
				(blopSound init: number: 154 vol: 127 loop: -1 play:)
				(drTop setMotion: MoveTo (drTop x?) 37 self)
				(drBottom setMotion: MoveTo (drBottom x?) 107 self)
			)
			(5 0)
			(6
				(blopSound stop: loop: 0)
				(gEgo setMotion: MoveTo 148 73 self)
			)
			(7
				(gEgo setMotion: MoveTo 90 35 self)
			)
			(8
				(blopSound number: 154 vol: 127 loop: -1 play:)
				(drBottom setMotion: MoveTo (drBottom x?) 76)
				(drTop setMotion: MoveTo (drTop x?) 77 self)
			)
			(9
				(blopSound number: 155 vol: 127 loop: 0 play: self)
			)
			(10
				(gLongSong2 fade:)
				(global2 newRoom: 541)
			)
		)
	)
)

(instance acidScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 155 78 self)
			)
			(1
				(gLongSong number: 825 loop: 1 play:)
				(blopSound init: vol: 127 loop: 0 play: self)
				(gEgo normal: 0 view: 515 loop: 1 cel: 0 cycleSpeed: 12)
			)
			(2 (gEgo setCycle: End self))
			(3 (= local70 1) (= cycles 5))
			(4
				(gLongSong stop:)
				(blopSound dispose:)
				(proc0_1 3 0)
				(= cycles 2)
			)
			(5
				(gSq4GlobalNarrator say: 7)
				(proc0_11 7 10)
				((Inv at: 5) cel: 1 cursor: 952)
				((IconBar at: 6) cursor: 952)
				(proc0_3)
				(client setScript: 0)
			)
		)
	)
)

(instance endScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong fade:)
				(= cycles 10)
			)
			(1
				(proc0_2)
				(gLongSong2 playBed:)
				(rogerJr setCycle: MCyc @local0)
				(= cycles 2)
			)
			(2
				(blast init: setCycle: MCyc @local37)
				(= seconds 1)
			)
			(3
				(gLongSong number: 821 vol: 127 loop: -1 play:)
				(rip init: setCycle: End self)
			)
			(4
				(blast dispose:)
				(rip setLoop: 4 setCycle: Fwd)
				(= cycles 1)
			)
			(5
				(gEgo moveSpeed: 6 setMotion: MoveTo 101 124 self)
			)
			(6
				(if (& global90 $0001)
					(tROGJR
						modNum: 557
						say: 18 self 2 64 2 2 25 global150 26 global129 27 1 67 315
					)
				else
					(tROGJR2 modNum: 557 say: 18 self)
				)
			)
			(7 (proc0_13 gEgo 115 130 self))
			(8
				(gEgo moveHead: 0)
				(= seconds 1)
			)
			(9
				(if (& global90 $0001)
					(tROGJR
						modNum: 557
						say: 19 self 2 64 2 2 25 global150 26 global129 27 1 67 315
					)
				else
					(tROGJR2 modNum: 557 say: 19 self)
				)
				(= seconds 10)
			)
			(10
				(gEgo moveHead: 1)
				(proc0_13 gEgo 101 115 self)
			)
			(11
				(gEgo setLoop: 3)
				(= cycles 1)
			)
			(12
				(gEgo
					view: 558
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(13
				(gLongSong stop:)
				(= seconds 1)
			)
			(14 (global2 newRoom: 21))
		)
	)
)

(instance rogerJr of Sq4Prop
	(properties
		x 155
		y 139
		view 556
	)
)

(instance blast of Sq4Prop
	(properties
		x 156
		y 110
		view 556
		loop 1
	)
)

(instance rip of Sq4Prop
	(properties
		x 99
		y 93
		view 556
		loop 3
	)
)

(instance tunnel of Sq4Feature
	(properties
		nsBottom 189
		nsRight 319
		sightAngle 180
		onMeCheck $0010
		lookStr 8
	)
)

(instance blopSound of Sound
	(properties
		number 820
		priority 5
	)
)

(instance tROGJR2 of Sq4Talker
	(properties
		noun 31
		modNum 557
		view 1524
		disposeWhenDone 0
		modeless 1
		talkerNum 31
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 25
		eyeOffsetY 20
		tStyle 1
	)
)

(instance tROGJR of Sq4Narrator
	(properties
		noun 31
		modNum 557
		modeless 1
		talkerNum 31
	)
)

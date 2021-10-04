;;; Sierra Script 1.0 - (do not remove this comment)
(script# 320)
(include sci.sh)
(use Main)
(use rssScript_703)
(use SQRoom)
(use Sq4Narrator)
(use Sq4Feature)
(use MCyc)
(use PolyPath)
(use Polygon)
(use n958)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm320 0
)

(local
	[local0 7]
	[local7 25] = [5 0 124 82 5 1 116 90 5 2 110 93 5 3 112 95 5 4 112 95 5 5 113 95 -32768]
	[local32 37] = [6 0 295 110 6 1 277 113 6 2 265 118 6 3 258 132 6 4 259 132 6 5 259 132 6 6 259 132 6 7 259 132 6 8 259 132 -32768]
	[local69 17] = [1 0 131 152 1 1 131 150 1 2 131 148 1 0 131 146 -32768]
	[local86 17] = [3 1 135 152 3 2 135 150 3 3 135 148 3 4 135 146 -32768]
)
(instance rm320 of SQRoom
	(properties
		picture 320
		horizon 15
		north 310
	)
	
	(method (init)
		(proc958_0 128 0 300)
		(proc958_0 132 143 51 57 132 133 115 883 884 887 889)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						319
						189
						0
						189
						0
						0
						165
						0
						245
						126
						218
						147
						174
						145
						171
						133
						142
						144
						191
						158
						193
						170
						297
						146
						315
						132
						310
						116
						294
						115
						295
						110
						304
						106
						298
						94
						310
						90
						299
						59
						303
						52
						298
						49
						303
						47
						308
						38
						319
						29
					yourself:
				)
				((Polygon new:)
					type: 1
					init: 319 26 307 33 270 5 272 0 319 0
					yourself:
				)
				((Polygon new:)
					type: 1
					init: 200 0 226 29 252 46 271 83 247 123 176 0
					yourself:
				)
		)
		(gLongSong2 number: 133 loop: 1)
		(gLongSong number: 57 flags: 1 loop: -1)
		(if (> (butte policeLanded?) 0)
			(Load rsVIEW 305)
			(Load rsPIC 300)
		else
			(proc958_0 128 7 5)
		)
		(if (and (== global12 297) (not (proc0_6 32)))
			(babe2 init: z: 1000)
			(babe3 init: z: 1000)
			(landSFX init:)
			(Load rsSCRIPT 810)
		)
		(self setRegions: 703)
		(theSea init:)
		(theRoom init:)
		(if
			(or
				(and (== global12 north) (butte egoSwims?))
				(== global12 297)
			)
			(proc0_2)
			(Load rsVIEW 323)
			(butte egoSwims: 0)
			(gEgo
				view: 323
				normal: 0
				loop: 1
				posn:
					(cond 
						((< (gEgo x?) 51) 45)
						((> (gEgo x?) 128) 128)
						(else (gEgo x?))
					)
					150
			)
			(if (== global12 north) (self style: 13))
			(self setScript: swimScript)
		else
			(proc0_2)
			(gEgo illegalBits: -32752)
			(self style: 13 setScript: enterScript)
		)
		(gEgo setPri: 8 init:)
		(super init:)
		(if
			(or
				(== (butte curPolice1Room?) 320)
				(== (butte curPolice2Room?) 320)
			)
			(butte junctioned: 1)
			((ScriptID 703 4)
				posn: 255 153
				init:
				setScript: copEnters
			)
		else
			(butte junctioned: 0)
		)
	)
	
	(method (doit &tmp temp0)
		(cond 
			(script)
			(
			(and (== script fallScript) (== (gEgo edgeHit?) 3)) 0)
			((and (not script) (== (gEgo edgeHit?) 1))
				(proc0_2)
				(gEgo illegalBits: -32768)
				(self setScript: exitScript)
			)
		)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond 
			(script)
			(
				(and
					(butte junctioned?)
					(not ((ScriptID 703 4) script?))
				)
				(if (== (butte oldPoliceRoom?) 310)
					((ScriptID 703 4) posn: 270 -5 init:)
				)
				((ScriptID 703 4) setScript: copEnters)
			)
			((or (& temp0 $0004) (& temp0 $0040)) (proc0_2) (self setScript: fallScript 0 temp0))
		)
	)
)

(instance fallScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					((& register $0004) (gEgo setPri: 3))
					((& register $0040) (gEgo setPri: 3))
				)
				(global2 setScript: (ScriptID 703 1))
				(self dispose:)
			)
		)
	)
)

(instance exitScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (gEgo x?) -2 self)
			)
			(1
				(global2 newRoom: (global2 north?))
			)
		)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					x:
						(cond 
							((< (gEgo x?) 250) 250)
							((> (gEgo x?) 291) 291)
							(else (gEgo x?))
						)
					y: 50
				)
				(= cycles 1)
			)
			(1 (proc0_3) (self dispose:))
		)
	)
)

(instance copEnters of Script
	(properties)
	
	(method (doit)
		(if (and (not (global2 script?)) (== state 0))
			(self cue:)
		)
		(if
			(and
				(not (global2 script?))
				(< ((ScriptID 703 4) distanceTo: gEgo) 80)
			)
			((ScriptID 703 4) setScript: (ScriptID 703 5))
			(self dispose:)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				((ScriptID 703 4)
					setCycle: Walk
					setMotion: MoveTo 300 100 self
				)
			)
			(2
				((ScriptID 703 4)
					setMotion: PolyPath (gEgo x?) (gEgo y?) self
				)
			)
		)
	)
)

(instance swimScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 1))
			(1
				(gLongSong2 number: 883 loop: -1 vol: 127 flags: 0 play:)
				(gEgo
					illegalBits: 0
					setCycle: Walk
					setLoop: -1
					setMotion: MoveTo 160 154 self
				)
			)
			(2
				(gLongSong2 number: 0 stop:)
				(gEgo
					setLoop: 1
					cel: 0
					setCycle: End
					xStep: 2
					setMotion: MoveTo 185 (gEgo y?) self
				)
			)
			(3 (proc0_1 0 0) (= cycles 30))
			(4
				(gEgo
					setPri: 8
					xStep: 3
					yStep: 2
					setMotion: MoveTo 205 (gEgo y?) self
				)
			)
			(5
				(cond 
					((!= global12 297) (proc0_3) (client setScript: 0))
					((not (proc0_6 32)) (proc0_7 32) (gLongSong play:) (= seconds 3))
					(else (proc0_3) (client setScript: 0))
				)
			)
			(6
				(global2 setScript: subRiseScript)
			)
		)
	)
)

(instance subRiseScript of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(if (> state 2)
			(if (> (gEgo x?) 206)
				(proc0_2)
				(global2 setScript: shootScript)
			)
			(if (!= (gEgo y?) 154)
				(proc0_2)
				(global2 setScript: shootScript)
			)
			(if (< (gEgo x?) 204)
				(proc0_2)
				(global2 setScript: enterSubScript)
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo moveHead: 0 setHeading: 270)
				(babe2 z: 0 setCycle: MCyc @local7)
				(babe3 z: 0 setCycle: MCyc @local32 self)
			)
			(1 (= seconds 4))
			(2
				(sub
					setLoop: 1
					setCycle: Fwd
					init:
					setMotion: MoveTo 131 154 self
				)
			)
			(3
				(gLongSong2 number: 884 loop: 1 vol: 127 play:)
				(sub setCycle: MCyc @local69)
				(subTop init: setCycle: MCyc @local86 self)
			)
			(4
				(sub setCycle: Fwd)
				(= seconds 4)
			)
			(5
				(hatch
					init:
					x: (subTop x?)
					y: (subTop y?)
					setPri: (+ (subTop priority?) 1)
					setCycle: End
				)
				(hatchSnd number: 133 loop: 1 init: play:)
				(= seconds 3)
			)
			(6
				(babeLeader init: cycleSpeed: 12 setCycle: CT 5 1 self)
			)
			(7
				(babeLeader setCycle: CT 8 1)
				(= cycles 9)
			)
			(8
				(gIconBar disable:)
				(= cycles 1)
			)
			(9
				(bubble z: 2000)
				(global5 eachElementDo: #hide)
				(global2 drawPic: 325 10)
				(arm init:)
				(theMouth init:)
				(theEyes init:)
				(zondraTalker init: 0 theEyes theMouth)
				(= cycles 1)
			)
			(10
				(gIconBar enable:)
				(= seconds 2)
			)
			(11
				(arm setCel: 1 stopUpd:)
				(= seconds 2)
			)
			(12
				(zondraTalker
					say:
						1
						self
						2
						64
						2
						2
						25
						(proc0_18 global153 global137)
						26
						global129
						27
						1
						67
						315
				)
			)
			(13
				(zondraTalker
					say:
						2
						self
						2
						64
						2
						2
						25
						(proc0_18 global153 global137)
						26
						global129
						27
						1
						67
						315
				)
			)
			(14
				(zondraTalker
					say:
						3
						self
						2
						64
						2
						2
						25
						(proc0_18 global153 global137)
						26
						global129
						27
						1
						67
						315
				)
			)
			(15
				(thoreenTalker
					init: 0 0 0
					say: 1 self 2 64 270 125 25 global130 26 global129 27 0 67 48
				)
				(if (& global90 $0001)
					(vibraTalker
						init: 0 0 0
						say: 1 0 2 64 3 160 25 global150 26 global129 27 0 67 315
					)
				)
			)
			(16
				(if (& global90 $0001) (vibraTalker dispose:))
				(zondraTalker
					say:
						4
						self
						2
						64
						2
						2
						25
						(proc0_18 global153 global137)
						26
						global129
						27
						1
						67
						315
				)
			)
			(17
				(rogerTalker
					init: 0 0 0
					say: 1 self 2 64 48 155 25 global140 26 global129 27 0 67 270
				)
			)
			(18
				(zondraTalker
					say:
						5
						self
						2
						64
						2
						2
						25
						(proc0_18 global153 global137)
						26
						global129
						27
						1
						67
						315
				)
			)
			(19
				(rogerTalker
					say: 2 self 2 64 48 155 25 global140 26 global129 27 0 67 270
				)
			)
			(20
				(zondraTalker
					say:
						6
						self
						2
						64
						2
						2
						25
						(proc0_18 global153 global137)
						26
						global129
						27
						1
						67
						315
				)
			)
			(21
				(thoreenTalker
					say: 2 self 2 64 270 125 25 global130 26 global129 27 0 67 48
				)
				(if (& global90 $0001)
					(vibraTalker
						modNum: 322
						say: 2 0 2 64 3 160 25 global150 26 global129 27 0 67 315
					)
				)
			)
			(22
				(if (& global90 $0001) (vibraTalker dispose:))
				(zondraTalker
					say:
						7
						self
						2
						64
						2
						2
						25
						(proc0_18 global153 global137)
						26
						global129
						27
						1
						67
						315
				)
			)
			(23
				(gIconBar disable:)
				(zondraTalker dispose:)
				(= cycles 1)
			)
			(24
				(global5 eachElementDo: #show)
				(global2 drawPic: 320 10)
				(babeLeader loop: 0 cel: 0 setPri: 14 posn: 117 144)
				(theMouth dispose:)
				(arm dispose:)
				(theEyes dispose:)
				(= cycles 1)
			)
			(25
				(proc0_1 2 0 4)
				(proc0_9 4)
				(gIconBar enable:)
				(proc0_3)
			)
		)
	)
)

(instance shootScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong2 number: 887 vol: 127 loop: 1 play:)
				(babeLeader
					loop: 0
					cel: 0
					x: 117
					y: 144
					setCycle: End self
				)
			)
			(1
				(gLongSong2 number: 889 vol: 127 loop: 1 play:)
				(gEgo
					normal: 0
					view: 321
					loop: 1
					cel: 0
					setCycle: End self
				)
			)
			(2
				(Animate (global5 elements?) 0)
				(proc0_10 2 21)
			)
		)
	)
)

(instance enterSubScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					illegalBits: 0
					setCycle: Walk
					setMotion: PolyPath 179 145
				)
				(= cycles 1)
			)
			(1
				(gEgo
					normal: 0
					view: 321
					loop: 2
					cel: 0
					posn: 179 144
					setPri: 15
					setCycle: End
				)
				(= cycles 7)
			)
			(2
				(landSFX play:)
				(gEgo
					illegalBits: 0
					loop: 3
					cel: 0
					posn: 143 144
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(gEgo normal: 1 dispose:)
				(babeLeader
					loop: 4
					cel: 0
					posn: 130 144
					setPri: 15
					setCycle: End self
				)
			)
			(4
				(babeLeader dispose:)
				(hatch setCycle: Beg self)
			)
			(5
				(hatchSnd number: 132 play:)
				(hatch dispose:)
				(= cycles 1)
			)
			(6
				(gLongSong number: 51 loop: -1 flags: 1 play:)
				(subTop setCycle: Beg)
				(subTop dispose:)
				(sub setMotion: MoveTo 131 200)
				(= seconds 3)
			)
			(7 (sub dispose:) (= cycles 1))
			(8
				(global2 newRoom: 321)
				(self dispose:)
			)
		)
	)
)

(instance babeLeader of Sq4Actor
	(properties
		x 142
		y 122
		sightAngle 90
		view 321
		loop 7
		priority 15
		signal $0010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 1))
			(4 (gSq4GlobalNarrator say: 2))
			(2 (gSq4GlobalNarrator say: 3))
			(6 (gSq4GlobalNarrator say: 4))
			(7 (gSq4GlobalNarrator say: 5))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance landSFX of Sound
	(properties
		number 115
		priority 15
	)
)

(instance babe2 of Sq4Prop
	(properties
		x 126
		y 92
		view 321
		loop 5
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 6))
			(4 (gSq4GlobalNarrator say: 7))
			(2 (gSq4GlobalNarrator say: 3))
			(6 (gSq4GlobalNarrator say: 8))
			(7 (gSq4GlobalNarrator say: 9))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance babe3 of Sq4Prop
	(properties
		x 298
		y 121
		view 321
		loop 6
		priority 14
		signal $0010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 10))
			(4 (gSq4GlobalNarrator say: 11))
			(2 (gSq4GlobalNarrator say: 12))
			(6 (gSq4GlobalNarrator say: 8))
			(7 (gSq4GlobalNarrator say: 13))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance sub of Sq4Actor
	(properties
		x 120
		y 200
		sightAngle 90
		yStep 3
		view 320
		loop 1
		priority 12
		signal $4000
		cycleSpeed 12
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 14))
			(4
				(global2 setScript: enterSubScript)
			)
			(6 (gSq4GlobalNarrator say: 15))
			(7 (gSq4GlobalNarrator say: 16))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance subTop of Sq4Actor
	(properties
		x 135
		y 154
		sightAngle 90
		view 320
		loop 3
		priority 13
		signal $4010
		cycleSpeed 12
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 14))
			(4
				(global2 setScript: enterSubScript)
			)
			(2)
			(6 (gSq4GlobalNarrator say: 15))
			(7 (gSq4GlobalNarrator say: 16))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance hatch of Sq4Prop
	(properties
		sightAngle 90
		view 320
		loop 2
		signal $4000
		cycleSpeed 12
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 17))
			(4
				(global2 setScript: enterSubScript)
			)
			(6 (gSq4GlobalNarrator say: 15))
			(7 (gSq4GlobalNarrator say: 18))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance bubble of Sq4Prop
	(properties
		x 130
		y 184
		sightAngle 90
		view 320
		priority 15
		signal $0010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 19))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance arm of Sq4Prop
	(properties
		x 171
		y 104
		view 1325
	)
)

(instance theMouth of Sq4Prop
	(properties
		x 171
		y 60
		view 1325
		loop 2
		signal $4000
	)
)

(instance theEyes of Sq4Prop
	(properties
		x 172
		y 42
		view 1325
		loop 4
		signal $4000
	)
)

(instance zCode of Code
	(properties)
	
	(method (doit param1)
		(param1 z: (- (param1 z?) 1000))
	)
)

(instance theRoom of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2
				((ScriptID 703 6) doVerb: theVerb)
			)
			(1 (gSq4GlobalNarrator say: 20))
			(else  (super doVerb:))
		)
	)
)

(instance theSea of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		onMeCheck $0010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 21))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hatchSnd of Sound
	(properties)
)

(instance zondraTalker of FaceTalker
	(properties
		noun 19
		modNum 322
		talkerNum 19
	)
)

(instance rogerTalker of Sq4Narrator
	(properties
		noun 7
		modNum 322
		disposeWhenDone 0
		talkerNum 7
	)
)

(instance thoreenTalker of Sq4Narrator
	(properties
		noun 20
		modNum 322
		disposeWhenDone 0
		modeless 1
		talkerNum 20
	)
)

(instance vibraTalker of Sq4Narrator
	(properties
		noun 20
		modNum 322
		disposeWhenDone 0
		modeless 1
		talkerNum 20
	)
)

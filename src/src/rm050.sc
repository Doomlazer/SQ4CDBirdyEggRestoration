;;; Sierra Script 1.0 - (do not remove this comment)
(script# 50)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use n958)
(use Sound)
(use Jump)
(use Cycle)
(use Obj)

(public
	rm050 0
	grateScript 1
)

(local
	[local0 26] = [108 0 140 69 139 88 121 145 147 170 182 164 161 98 160 76 271 0 190 0 158 40 153 37 145]
	[local26 30] = [0 42 45 38 32 11 41 0 72 0 115 30 122 31 136 62 136 66 140 69 140 73 69 84 55 84 32 78 0 51]
	[local56 6] = [251 59 170 70 229 29]
	[local62 38] = [141 189 109 157 109 143 122 137 120 145 147 170 183 165 172 129 238 118 240 120 226 126 244 137 244 144 255 153 272 157 293 154 288 173 295 185 304 189]
	[local100 26] = [0 51 31 78 55 83 72 84 139 73 140 87 123 136 111 141 104 150 94 157 94 165 117 189 0 189]
	[local126 16] = [249 60 223 85 252 92 236 118 173 128 162 98 161 78 170 70]
	[local142 10] = [0 56 5 56 21 70 9 71 0 62]
)
(instance rm050 of SQRoom
	(properties
		picture 50
		style $000a
		horizon 37
		north 35
		south 65
		west 45
		vanishingX 2
		vanishingY -25
	)
	
	(method (init)
		(proc958_0 128 50)
		(proc958_0 132 131 808 809 103 123 147)
		(if (gEgo has: 2) (Load rsVIEW 66) (Load rsSCRIPT 991))
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init: 106 140 166 140 200 165 140 176
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 0 25 60 25 72 40 0 49
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 319 0 319 40 111 40 67 0
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						319
						91
						319
						189
						291
						189
						284
						185
						278
						170
						286
						164
						286
						159
						250
						158
						233
						146
						232
						136
						248
						136
						255
						106
					yourself:
				)
		)
		(switch global12
			(north
				(proc0_2)
				(self setScript: enterScript)
			)
			(south (gEgo x: 255))
			(else  (gEgo x: 100 y: 160))
		)
		(gEgo init:)
		(theGrate init:)
		(otherGrate init:)
		(grateSnd init:)
		(supportPoly points: @local0 size: 13)
		(sidewalk1Poly points: @local26 size: 15)
		(sidewalk2Poly points: @local56 size: 3)
		(sidewalk3Poly points: @local62 size: 19)
		(street1Poly points: @local100 size: 13)
		(street2Poly points: @local126 size: 8)
		(otherGratePoly points: @local142 size: 4)
		(self setRegions: 701)
		(super init:)
		(self setRegions: 705)
		(theHole init:)
		(theLiquid init:)
		(theSupports init:)
		(theSmallSupports init:)
		(theRedBldg init:)
		(street1 init:)
		(street2 init:)
		(sidewalk1 init:)
		(sidewalk2 init:)
		(sidewalk3 init:)
		(theArea init:)
	)
	
	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(cond 
			((global2 script?) 0)
			(
				(or
					(& temp0 $0004)
					(& temp0 $0008)
					(& temp0 $0010)
					(& temp0 $0002)
					(& temp0 $4000)
				)
				(proc0_2)
				(self setScript: fallScript 0 temp0)
			)
			((== (gEgo edgeHit?) 1) (proc0_2) (self setScript: exitScript 0 1))
		)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript 991)
		(super dispose:)
	)
	
	(method (newRoom newRoomNumber)
		(if
			(and
				(== (gEgo edgeHit?) 3)
				(< (gEgo x?) 133)
				(!= (global2 script?) (ScriptID 701 3))
				(!= ((ScriptID 701 1) script?) (ScriptID 701 4))
			)
			(super newRoom: 60)
		else
			(if (== newRoomNumber 70)
				(gLongSong fade: 0 10 10 1)
				(Lock 132 116 0)
				(Lock 128 105 0)
			)
			(super newRoom: newRoomNumber)
		)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 50 -1 setMotion: MoveTo 85 47 self)
			)
			(1 (proc0_3) (self dispose:))
		)
	)
)

(instance exitScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 15 -10 self)
			)
			(1
				(= register 0)
				(global2 newRoom: (global2 north?))
			)
		)
	)
)

(instance grateScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 68 85 self)
			)
			(1
				(gEgo setMotion: MoveTo 68 87 self)
			)
			(2
				(if (not (gEgo has: 2)) (proc0_11 42 5))
				(gEgo view: 50 normal: 0 loop: 0 cel: 0 cycleSpeed: 12)
				(= cycles 5)
			)
			(3 (gEgo setCycle: CT 4 1 self))
			(4
				(grateSnd number: 809 loop: 1 play: setVol: 127)
				(= cycles 1)
			)
			(5
				(theGrate hide:)
				(gEgo setCycle: CT 5 1 self)
			)
			(6
				(grateSnd play:)
				(gEgo setCycle: CT 4 -1)
				(= cycles 3)
			)
			(7
				(grateSnd number: 808 loop: 1 play: setVol: 127)
				(gEgo setCycle: End self)
			)
			(8
				(gEgo
					loop: 1
					cel: 0
					x: (+ (gEgo x?) 35)
					y: (- (gEgo y?) 1)
					setCycle: CT 5 1 self
				)
			)
			(9 (gEgo setCycle: End self))
			(10
				(grateSnd number: 809 play:)
				(gEgo x: 500)
				(theGrate show:)
				(= seconds 3)
			)
			(11
				(if (gEgo has: 2)
					(= ticks 60)
				else
					(global2 newRoom: 70)
				)
			)
			(12
				(gLongSong number: 103 setVol: 127 loop: 1 playBed:)
				(theGrate
					yStep: 20
					setMotion: MoveTo (- (theGrate x?) 40) -100
				)
				(explosion
					x: 83
					y: 89
					view: 66
					loop: 0
					cel: 0
					init:
					setCycle: End
					ignoreActors: 1
				)
				(armBit
					init:
					setMotion: JumpTo (- (armBit x?) 15) (+ (armBit y?) 30)
				)
				(legBit
					init:
					setMotion: JumpTo (- (armBit x?) 15) (- (armBit y?) 30)
				)
				(headBit
					init:
					setMotion: JumpTo (+ (armBit x?) 30) (+ (armBit y?) 10)
				)
				(= seconds 5)
			)
			(13
				(theGrate
					setPri: 15
					yStep: 20
					setMotion: MoveTo (- (theGrate x?) 10) 101 self
				)
			)
			(14
				(grateSnd number: 809 loop: 1 play:)
				(theGrate
					setPri: -1
					setMotion: JumpTo (- (theGrate x?) 20) 111 self
				)
			)
			(15
				(grateSnd number: 123 play:)
				(theGrate
					setMotion: JumpTo (- (theGrate x?) 5) 113 self
				)
			)
			(16
				(grateSnd play:)
				(= seconds 3)
			)
			(17
				(gSq4GlobalNarrator say: 1 self)
			)
			(18 (proc0_10 6 4))
		)
	)
)

(instance fallScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					((& register $0008) (gEgo setPri: 0))
					((& register $0010) (gEgo setPri: 1))
					((& register $0004) (gEgo setPri: 2))
					((& register $0002) (gEgo setPri: 3))
					((& register $4000) (gEgo setPri: 4))
				)
				(gEgo
					x: (+ (gEgo x?) 8)
					y: (+ (gEgo y?) 12)
					setLoop: (gEgo loop?)
				)
				(gLongSong number: 131 loop: 1 setVol: 127 play:)
				(= cycles 1)
			)
			(1
				(gEgo
					yStep: 20
					setMotion: MoveTo (gEgo x?) (+ (gEgo y?) 250) self
				)
			)
			(2 (= seconds 2))
			(3
				(gLongSong fade: 0 1 2 1)
				(= seconds 1)
			)
			(4
				(gLongSong number: 147 loop: 1 setVol: 127 play:)
				(gSq4GlobalNarrator say: 2)
				(proc0_10 0 8)
			)
		)
	)
)

(instance theGrate of Sq4Actor
	(properties
		x 84
		y 91
		heading 170
		sightAngle 40
		view 50
		loop 2
		signal $6810
		lookStr 3
	)
	
	(method (doit)
		(super doit:)
		(if (== (global2 curPic?) 31)
			(self z: 1000)
		else
			(self z: 0)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (global2 script?)
					0
				else
					(proc0_2)
					(global2 setScript: grateScript)
				)
			)
			(6 (gSq4GlobalNarrator say: 4))
			(7 (gSq4GlobalNarrator say: 5))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance otherGrate of Sq4Feature
	(properties
		x 10
		y 66
		nsBottom 200
		nsRight 320
		sightAngle 40
		lookStr 6
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: otherGratePoly)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gSq4GlobalNarrator say: 7))
			(6 (gSq4GlobalNarrator say: 4))
			(7 (gSq4GlobalNarrator say: 5))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance otherGratePoly of Polygon
	(properties)
)

(instance theRedBldg of Sq4Feature
	(properties
		x 294
		y 143
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck $0400
		lookStr 8
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gSq4GlobalNarrator say: 9))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theHole of Sq4Feature
	(properties
		x 249
		y 76
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck $001c
		lookStr 10
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (gSq4GlobalNarrator say: 11))
			(7 (gSq4GlobalNarrator say: 12))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theLiquid of Sq4Feature
	(properties
		x 116
		y 174
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck $0040
		lookStr 13
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gSq4GlobalNarrator say: 14))
			(6 (gSq4GlobalNarrator say: 15))
			(7 (gSq4GlobalNarrator say: 16))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theSupports of Sq4Feature
	(properties
		x 154
		y 149
		sightAngle 45
		lookStr 17
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: supportPoly)
	)
)

(instance supportPoly of Polygon
	(properties)
)

(instance theSmallSupports of Sq4Feature
	(properties
		x 10
		y 10
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck $2000
		lookStr 17
	)
)

(instance street1 of Sq4Feature
	(properties
		sightAngle 40
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: street1Poly)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 18))
			(6 (gSq4GlobalNarrator say: 19))
			(7 (gSq4GlobalNarrator say: 20))
			(9
				((ScriptID 705 4) doVerb: theVerb)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance street1Poly of Polygon
	(properties)
)

(instance street2 of Sq4Feature
	(properties
		y 1
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: street2Poly)
	)
	
	(method (doVerb theVerb)
		(street1 doVerb: theVerb)
	)
)

(instance street2Poly of Polygon
	(properties)
)

(instance sidewalk1 of Sq4Feature
	(properties
		y 2
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: sidewalk1Poly)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 21))
			(6 (gSq4GlobalNarrator say: 22))
			(7 (gSq4GlobalNarrator say: 23))
			(9
				((ScriptID 705 4) doVerb: theVerb)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance sidewalk1Poly of Polygon
	(properties)
)

(instance sidewalk2 of Sq4Feature
	(properties
		y 2
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: sidewalk2Poly)
	)
	
	(method (doVerb theVerb)
		(sidewalk1 doVerb: theVerb)
	)
)

(instance sidewalk2Poly of Polygon
	(properties)
)

(instance sidewalk3 of Sq4Feature
	(properties
		y 2
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: sidewalk3Poly)
	)
	
	(method (doVerb theVerb)
		(sidewalk1 doVerb: theVerb)
	)
)

(instance sidewalk3Poly of Polygon
	(properties)
)

(instance theArea of Sq4Feature
	(properties
		y 1
		nsBottom 200
		nsRight 320
		lookStr 21
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(9
				((ScriptID 705 4) doVerb: theVerb)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance explosion of Sq4Prop
	(properties)
)

(instance armBit of Sq4Actor
	(properties
		x 83
		y 89
		view 66
		loop 1
		signal $6800
	)
)

(instance legBit of Sq4Actor
	(properties
		x 83
		y 89
		view 66
		loop 1
		cel 1
		signal $6800
	)
)

(instance headBit of Sq4Actor
	(properties
		x 83
		y 89
		view 66
		loop 1
		cel 2
		signal $6800
	)
)

(instance grateSnd of Sound
	(properties
		number 808
		priority 15
	)
)

;;; Sierra Script 1.0 - (do not remove this comment)
(script# 40)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use n958)
(use Cycle)
(use Obj)

(public
	rm040 0
)

(local
	[local0 24] = [18 0 160 85 161 105 141 164 173 169 199 148 181 99 182 81 224 0 184 0 167 51 123]
	[local24 20] = [78 38 15 0 0 0 0 189 23 189 54 167 51 144 63 144 87 128 74 50]
	[local44 16] = [82 86 108 80 127 81 159 98 158 107 150 130 112 139 86 118]
	[local60 8] = [158 115 144 123 139 120 149 109]
	[local68 18] = [74 77 79 73 162 83 161 99 138 84 114 79 107 79 96 84 81 86]
	[local86 26] = [181 189 214 158 215 148 207 142 198 140 185 99 180 98 181 85 253 94 272 93 294 86 319 68 319 189]
	[local112 32] = [26 189 55 167 52 144 61 144 87 129 86 119 127 151 150 136 139 164 174 169 200 148 198 140 210 144 215 148 214 157 180 189]
	[local144 8] = [152 81 110 76 95 64 106 54]
	[local152 6] = [155 38 171 38 167 52]
	[local158 18] = [241 40 297 0 319 0 319 68 292 87 273 92 255 94 181 84 205 40]
)
(procedure (localproc_0ca1 param1 param2 param3 param4 &tmp temp0 temp1 temp2)
	(gLongSong2 number: 105 vol: 127 loop: 1 play:)
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

(instance rm040 of SQRoom
	(properties
		picture 40
		style $000a
		horizon 48
		north 25
		east 45
		south 55
		vanishingX 319
		vanishingY -35
	)
	
	(method (init)
		(Load rsVIEW 40)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						298
						0
						251
						49
						102
						49
						97
						60
						102
						66
						45
						97
						33
						152
						68
						163
						41
						189
						0
						189
						0
						0
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 103 79 181 120 142 144 113 143 60 100 75 85
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 215 148 179 179 123 169 169 137
					yourself:
				)
		)
		(if (proc0_6 0) (proc958_0 128 7 13) (cop1 init:))
		(switch global12
			(north
				(proc0_2)
				(self setScript: enterScript)
			)
			(south (gEgo x: 89))
			(east)
			(else 
				(proc0_7 0)
				(proc0_1 0 0)
				(gEgo posn: 64 81)
				(self setScript: enterScript)
				(gLongSong
					number: 802
					loop: -1
					vol: 127
					flags: 1
					playBed:
				)
				(cop1 init:)
			)
		)
		(gEgo init:)
		(theTank init:)
		(theSupport init:)
		(thePurpleBldg init:)
		(theLeftBldg init:)
		(theHole init:)
		(street1 init:)
		(street2 init:)
		(sidewalk1 init:)
		(sidewalk2 init:)
		(sidewalk3 init:)
		(sidewalk4 init:)
		(theArea init:)
		(self setRegions: 701)
		(super init:)
		(self setRegions: 705)
		(supportPoly points: @local0 size: 12)
		(buildingPoly points: @local24 size: 10)
		(tankPoly points: @local44 size: 8)
		(holePoly points: @local60 size: 4)
		(street1Poly points: @local68 size: 9)
		(street2Poly points: @local86 size: 13)
		(sidewalk1Poly points: @local112 size: 16)
		(sidewalk2Poly points: @local144 size: 4)
		(sidewalk3Poly points: @local152 size: 3)
		(sidewalk4Poly points: @local158 size: 9)
	)
	
	(method (newRoom newRoomNumber)
		(cond 
			(
				(and
					(== (gEgo edgeHit?) 1)
					(!= script exitScript)
					(!= script (ScriptID 701 3))
					(!= ((ScriptID 701 1) script?) (ScriptID 701 4))
				)
				(proc0_2)
				(self setScript: exitScript 0 1)
			)
			(
			(and (== (gEgo edgeHit?) 1) (not (script register?))) (super newRoom: newRoomNumber))
			(
				(and
					(== (gEgo edgeHit?) 3)
					(> (gEgo x?) 199)
					(not (proc0_6 0))
					(!= (global2 script?) (ScriptID 701 3))
					(!= ((ScriptID 701 1) script?) (ScriptID 701 4))
				)
				(super newRoom: 60)
			)
			(else (super newRoom: newRoomNumber))
		)
	)
)

(instance shootEgo of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(if (and (== state 1) (> (gEgo x?) 205)) (self cue:))
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= ticks register))
			(1
				(if (> (gEgo y?) 100) (cop1 y: 65) (cop2 y: 45))
				(cop1
					setCycle: Walk
					setMotion: MoveTo 275 (cop1 y?) self
				)
				(cop2 setCycle: Walk setMotion: MoveTo 0 (cop2 y?))
			)
			(2
				(proc0_13 cop1 gEgo)
				(= cycles 4)
			)
			(3
				(cop2 setMotion: 0)
				(proc0_13 cop2 gEgo)
				(cop1 view: 13 cel: 0 setMotion: 0 setCycle: CT 2 1 self)
			)
			(4
				(proc0_2)
				(cop1 setCycle: End self)
				(if (< (cop1 x?) (gEgo x?))
					(localproc_0ca1
						(- (cop1 y?) 27)
						(cop1 x?)
						(- (gEgo y?) 32)
						(gEgo x?)
					)
				else
					(localproc_0ca1
						(- (gEgo y?) 32)
						(gEgo x?)
						(- (cop1 y?) 27)
						(cop1 x?)
					)
				)
			)
			(5
				(gEgo
					setMotion: 0
					view: 26
					loop:
						(switch (gEgo loop?)
							(4 0)
							(5 1)
							(6 0)
							(7 1)
							(else  (gEgo loop?))
						)
					cel: 0
					cycleSpeed: 6
					setCycle: CT 2 1 self
				)
			)
			(6
				(gEgo setMotion: 0 setCycle: CT 1 -1 self)
			)
			(7
				(gEgo setMotion: 0 setCycle: End self)
			)
			(8 (= seconds 4) (proc0_10 8))
		)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global12 72)
					(gEgo
						setMotion: MoveTo (+ (gEgo x?) 15) (gEgo y?) self
					)
				else
					(gEgo
						posn: 333 1
						setLoop: 5
						setMotion: MoveTo 272 49 self
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

(instance exitScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 310 -1 self)
			)
			(1
				(= register 0)
				(global2 newRoom: (global2 north?))
			)
		)
	)
)

(instance theTank of Sq4Feature
	(properties
		x 125
		y 110
		sightAngle 45
		lookStr 1
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: tankPoly)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if
				(or (global2 script?) (global5 contains: closeup))
					0
				else
					(proc0_2)
					(global2 setScript: tankScript)
				)
			)
			(10
				(proc0_2)
				(global2 setScript: bombScript)
			)
			(6 (gSq4GlobalNarrator say: 2))
			(7 (gSq4GlobalNarrator say: 3))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance tankPoly of Polygon
	(properties)
)

(instance tankScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 154 137 self)
			)
			(1 (gEgo setHeading: 315 self))
			(2
				(if (== global12 72)
					(proc0_2)
					(if (not (shootEgo state?)) (shootEgo ticks: 2))
				else
					(= cycles 2)
				)
			)
			(3
				(if (== ((gInv at: 2) owner?) 40) (theBomb init:))
				(closeup init: stopUpd:)
				(= cycles 1)
			)
			(4
				(proc0_3)
				(client setScript: 0)
			)
		)
	)
)

(instance bombScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 154 137 self)
			)
			(1
				(gEgo setHeading: 315 self)
				(gEgo put: 2 40)
				(proc0_11 44 -20)
			)
			(2
				(gSq4GlobalNarrator say: 4)
				(proc0_3)
				(client setScript: 0)
			)
		)
	)
)

(instance theSupport of Sq4Feature
	(properties
		x 172
		y 154
		sightAngle 45
		lookStr 5
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: supportPoly)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 5))
			(6 (gSq4GlobalNarrator say: 6))
			(7 (gSq4GlobalNarrator say: 7))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance supportPoly of Polygon
	(properties)
)

(instance thePurpleBldg of Sq4Feature
	(properties
		x 198
		y 15
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck $2000
		lookStr 8
	)
)

(instance theLeftBldg of Sq4Feature
	(properties
		x 43
		y 123
		sightAngle 45
		lookStr 9
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: buildingPoly)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gSq4GlobalNarrator say: 10))
			(6 (gSq4GlobalNarrator say: 11))
			(7 (gSq4GlobalNarrator say: 12))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance buildingPoly of Polygon
	(properties)
)

(instance street1 of Sq4Feature
	(properties)
	
	(method (init)
		(super init:)
		(self onMeCheck: street1Poly)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 13))
			(6 (gSq4GlobalNarrator say: 14))
			(7 (gSq4GlobalNarrator say: 15))
			(9
				((ScriptID 705 4) doVerb: theVerb param2)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance street1Poly of Polygon
	(properties)
)

(instance street2 of Sq4Feature
	(properties)
	
	(method (init)
		(super init:)
		(self onMeCheck: street2Poly)
	)
	
	(method (doVerb theVerb param2)
		(street1 doVerb: theVerb param2)
	)
)

(instance street2Poly of Polygon
	(properties)
)

(instance sidewalk1 of Sq4Feature
	(properties)
	
	(method (init)
		(super init:)
		(self onMeCheck: sidewalk1Poly)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 16))
			(6 (gSq4GlobalNarrator say: 17))
			(7 (gSq4GlobalNarrator say: 18))
			(9
				((ScriptID 705 4) doVerb: theVerb param2)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance sidewalk1Poly of Polygon
	(properties)
)

(instance sidewalk2 of Sq4Feature
	(properties)
	
	(method (init)
		(super init:)
		(self onMeCheck: sidewalk2Poly)
	)
	
	(method (doVerb theVerb param2)
		(sidewalk1 doVerb: theVerb param2)
	)
)

(instance sidewalk2Poly of Polygon
	(properties)
)

(instance sidewalk3 of Sq4Feature
	(properties)
	
	(method (init)
		(super init:)
		(self onMeCheck: sidewalk3Poly)
	)
	
	(method (doVerb theVerb param2)
		(sidewalk1 doVerb: theVerb param2)
	)
)

(instance sidewalk3Poly of Polygon
	(properties)
)

(instance sidewalk4 of Sq4Feature
	(properties)
	
	(method (init)
		(super init:)
		(self onMeCheck: sidewalk4Poly)
	)
	
	(method (doVerb theVerb param2)
		(sidewalk1 doVerb: theVerb param2)
	)
)

(instance sidewalk4Poly of Polygon
	(properties)
)

(instance theArea of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		lookStr 19
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(9
				((ScriptID 705 4) doVerb: theVerb param2)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance closeup of Sq4View
	(properties
		x 132
		y 155
		z 77
		sightAngle 90
		view 40
		priority 13
		signal $4010
	)
	
	(method (doit)
		(super doit:)
		(if (or (gEgo mover?) (!= (gEgo loop?) 7))
			(self hide: dispose:)
		)
		(if (== (global2 curPic?) 31)
			(self z: 1000)
		else
			(self z: 77)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (== ((gInv at: 2) owner?) 40)
					(gSq4GlobalNarrator say: 20)
				else
					(gSq4GlobalNarrator say: 21)
				)
			)
			(10 (theTank doVerb: theVerb))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theBomb of Sq4Prop
	(properties
		x 134
		y 156
		z 97
		sightAngle 90
		view 40
		cel 1
		priority 14
		signal $4010
	)
	
	(method (doit)
		(super doit:)
		(if (or (gEgo mover?) (!= (gEgo loop?) 7))
			(self hide: dispose:)
		)
		(if (== (global2 curPic?) 31)
			(self z: 1000)
		else
			(self z: 97)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 22))
			(4
				(theBomb dispose:)
				(gEgo get: 2)
				(proc0_11 69 25)
				(if (and (proc0_6 0) (== (shootEgo state?) 0))
					(shootEgo register: 20)
				)
				(Animate (global5 elements?) 0)
				(gSq4GlobalNarrator say: 23)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theHole of Sq4Feature
	(properties
		x 149
		y 115
		sightAngle 45
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: holePoly)
	)
	
	(method (doVerb theVerb param2)
		(cond 
			((or (== theVerb 1) (== theVerb 4)) (theTank doVerb: 4 param2))
			(10 (theTank doVerb: theVerb))
			(else (super doVerb: theVerb))
		)
	)
)

(instance holePoly of Polygon
	(properties)
)

(instance cop1 of Sq4Actor
	(properties
		x 329
		y 165
		view 7
		loop 2
		lookStr 24
	)
	
	(method (init)
		(cop2 init:)
		(shootEgo register: 900)
		(self setScript: shootEgo)
		(super init:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 24))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cop2 of Sq4Actor
	(properties
		x 340
		y 145
		view 7
		lookStr 24
	)
)

;;; Sierra Script 1.0 - (do not remove this comment)
(script# 65)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Narrator)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use Cycle)
(use Obj)

(public
	rm065 0
)

(local
	[local0 46] = [26 0 27 36 42 48 66 50 86 42 86 89 96 99 133 100 152 87 169 97 192 97 194 116 204 124 201 162 230 160 231 148 241 143 243 148 246 160 271 162 273 155 319 149 319]
	[local46 16] = [0 70 106 173 81 184 75 172 65 168 41 175 40 182 0 183]
	[local62 48] = [0 0 26 0 27 35 43 49 67 51 86 43 86 89 94 100 118 103 138 100 151 86 166 97 191 98 192 115 203 122 199 164 190 167 186 163 151 174 143 167 128 173 111 170 105 172 0 70]
	[local110 32] = [0 70 79 148 78 151 78 152 76 153 74 152 73 150 62 139 57 140 43 126 23 113 15 107 3 93 1 90 1 88 0 87]
)
(instance rm065 of SQRoom
	(properties
		picture 65
		style $000a
		horizon 48
		north 50
		west 60
		vanishingX 0
		vanishingY -65
	)
	
	(method (init)
		(Load rsVIEW 8)
		(switch global12
			(north
				(proc0_2)
				(self setScript: enterScript)
			)
			(west
				(if (> (gEgo y?) 179) (gEgo y: 179))
			)
			(else  (gEgo x: 160 y: 160))
		)
		(gEgo init:)
		(if (== ((gInv at: 1) owner?) 65) (aRope init:))
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						179
						185
						179
						192
						159
						227
						149
						152
						103
						139
						109
						101
						109
						82
						99
						77
						85
						91
						71
						105
						69
						86
						51
						77
						55
						40
						54
						22
						46
						18
						30
						30
						26
						6
						0
						319
						0
						319
						189
						0
						189
					yourself:
				)
		)
		(buildingPoly points: @local0 size: 23)
		(streetPoly points: @local46 size: 8)
		(sidewalkPoly points: @local62 size: 24)
		(liquidPoly points: @local110 size: 16)
		(theRubble init:)
		(theRedBldg init:)
		(theLiquid init:)
		(theGrate init:)
		(theStreet init:)
		(theSidewalk init:)
		(if (not (proc0_6 0)) (self setRegions: 701))
		(self setRegions: 705)
		(super init:)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(9
				((ScriptID 705 4) doVerb: theVerb param2)
			)
			(else  (super doVerb: theVerb))
		)
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
			(else (super newRoom: newRoomNumber))
		)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 4 -1 setMotion: MoveTo 17 49 self)
			)
			(1
				(proc0_3)
				(client setScript: 0)
			)
		)
	)
)

(instance exitScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 5 -10 self)
			)
			(1
				(= register 0)
				(global2 newRoom: (global2 north?))
			)
		)
	)
)

(instance getRope of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 169 177 self)
			)
			(1
				(gEgo
					view: 8
					loop: 0
					cel: 0
					x: 168
					y: 177
					cycleSpeed: 16
					heading: 225
				)
				(= cycles 1)
			)
			(2 (gEgo setCycle: CT 2 1 self))
			(3
				(gSq4GlobalNarrator say: 1 self)
			)
			(4
				(aRope dispose:)
				(proc0_11 39 5)
				(= cycles 1)
			)
			(5
				(gEgo cycleSpeed: 12 setCycle: End self)
			)
			(6
				(proc0_1 2 0)
				(gEgo posn: 169 177 get: 1)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance aRope of Sq4View
	(properties
		x 162
		y 195
		z 10
		sightAngle 45
		view 33
		priority 14
		signal $4010
		lookStr 2
	)
	
	(method (doit)
		(super doit:)
		(if (== (global2 curPic?) 31)
			(self z: 1000)
		else
			(self z: 10)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(proc0_2)
				(global2 setScript: getRope)
			)
			(6 (gSq4GlobalNarrator say: 3))
			(7 (gSq4GlobalNarrator say: 4))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theRubble of Sq4Feature
	(properties
		x 160
		y 188
		nsBottom 200
		nsRight 320
		onMeCheck $0040
		lookStr 5
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (!= ((gInv at: 1) owner?) 65)
					(gSq4GlobalNarrator say: 6)
				else
					(gSq4GlobalNarrator say: 7)
				)
			)
			(6 (gSq4GlobalNarrator say: 8))
			(7 (gSq4GlobalNarrator say: 9))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theRedBldg of Sq4Feature
	(properties
		x 280
		y 180
		sightAngle 40
		lookStr 10
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: buildingPoly)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(gSq4GlobalNarrator modNum: 50 say: 9)
			)
			(6 (gSq4GlobalNarrator say: 11))
			(7 (tRog say: 1))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance buildingPoly of Polygon
	(properties)
)

(instance theLiquid of Sq4Feature
	(properties
		x 39
		y 115
		nsBottom 200
		nsRight 320
		sightAngle 45
		lookStr 12
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: liquidPoly)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (gSq4GlobalNarrator say: 13))
			(7 (gSq4GlobalNarrator say: 14))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance liquidPoly of Polygon
	(properties)
)

(instance theGrate of Sq4Feature
	(properties
		x 85
		y 163
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck $0200
		lookStr 15
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gSq4GlobalNarrator say: 15))
			(6 (gSq4GlobalNarrator say: 16))
			(7 (gSq4GlobalNarrator say: 17))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theStreet of Sq4Feature
	(properties)
	
	(method (init)
		(super init:)
		(self onMeCheck: streetPoly)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 18))
			(6 (gSq4GlobalNarrator say: 19))
			(7
				(gSq4GlobalNarrator modNum: 40 say: 12)
			)
			(9
				((ScriptID 705 4) doVerb: theVerb param2)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance streetPoly of Polygon
	(properties)
)

(instance theSidewalk of Sq4Feature
	(properties)
	
	(method (init)
		(super init:)
		(self onMeCheck: sidewalkPoly)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 20))
			(7 (gSq4GlobalNarrator say: 21))
			(6 (gSq4GlobalNarrator say: 22))
			(9
				((ScriptID 705 4) doVerb: theVerb param2)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance sidewalkPoly of Polygon
	(properties)
)

(instance tRog of Sq4Talker
	(properties
		z 400
		noun 7
		modNum 65
		view 1008
		talkerNum 7
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 27
		eyeOffsetY 21
	)
)

;;; Sierra Script 1.0 - (do not remove this comment)
(script# 35)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Feature)
(use Polygon)
(use Cycle)
(use Obj)

(public
	rm035 0
)

(local
	[local0 10] = [0 85 12 77 10 40 50]
	[local10 12] = [60 36 79 38 109 30 85 9 71 14 60 31]
	[local22 44] = [12 67 11 40 51 0 318 0 319 189 275 189 297 163 226 113 193 151 201 167 141 187 121 169 198 93 147 56 121 91 126 104 75 124 57 107 124 39 80 5 57 34 65 50]
	[local66 16] = [0 84 10 79 11 70 14 68 140 187 156 186 164 189 0 189]
	[local82 18] = [13 67 24 64 26 60 65 51 61 38 78 39 111 32 124 38 57 108]
	[local100 16] = [75 125 86 124 88 119 128 105 120 90 147 58 198 93 122 168]
	[local116 16] = [164 189 156 185 157 183 202 166 194 151 226 114 297 165 273 189]
)
(instance rm035 of SQRoom
	(properties
		picture 35
		style $000a
		south 50
		west 30
		vanishingX -125
		vanishingY -112
	)
	
	(method (init)
		(switch global12
			(45
				(gEgo init: x: 48 y: 245)
				(proc0_2)
				(self setScript: enterScript)
			)
			(south (gEgo x: 245))
			(east 0)
			(else  (gEgo x: 160 y: 130))
		)
		(rubblePoly1 points: @local0 size: 5)
		(rubblePoly2 points: @local10 size: 6)
		(buildingPoly points: @local22 size: 22)
		(streetPoly points: @local66 size: 8)
		(sidewalk1Poly points: @local82 size: 9)
		(sidewalk2Poly points: @local100 size: 8)
		(sidewalk3Poly points: @local116 size: 8)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init: 238 152 230 163 163 189 126 189 110 174 129 155 209 144
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 38 110 126 79 158 103 71 135
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 0 0 319 0 319 189 306 189 298 173 108 35 86 39 92 43 81 51 0 80
					yourself:
				)
		)
		(gEgo init:)
		(theRubble1 init:)
		(theRubble2 init:)
		(theWhiteBldg init:)
		(theStreet init:)
		(sidewalk1 init:)
		(sidewalk2 init:)
		(sidewalk3 init:)
		(theArea init:)
		(self setRegions: 701)
		(super init:)
		(self setRegions: 705)
	)
	
	(method (newRoom newRoomNumber)
		(if
			(and
				(!= (global2 script?) (ScriptID 701 3))
				(!= ((ScriptID 701 1) script?) (ScriptID 701 4))
				(== (gEgo edgeHit?) 3)
				(< (gEgo x?) 124)
			)
			(= newRoomNumber 45)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 78 188 self)
			)
			(1
				(proc0_3)
				(client setScript: 0)
			)
		)
	)
)

(instance theRubble1 of Sq4Feature
	(properties
		x 11
		y 18
		sightAngle 45
		lookStr 1
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: rubblePoly1)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gSq4GlobalNarrator say: 1))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance rubblePoly1 of Polygon
	(properties)
)

(instance theRubble2 of Sq4Feature
	(properties
		x 82
		y 22
		sightAngle 45
		lookStr 1
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: rubblePoly2)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gSq4GlobalNarrator say: 1))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance rubblePoly2 of Polygon
	(properties)
)

(instance theWhiteBldg of Sq4Feature
	(properties
		x 350
		y 180
		lookStr 2
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: buildingPoly)
	)
)

(instance buildingPoly of Polygon
	(properties)
)

(instance theStreet of Sq4Feature
	(properties
		lookStr 3
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: streetPoly)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(7
				(gSq4GlobalNarrator modNum: 25 say: 13)
			)
			(6
				(gSq4GlobalNarrator modNum: 25 say: 12)
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

(instance sidewalk1 of Sq4Feature
	(properties)
	
	(method (init)
		(super init:)
		(self onMeCheck: sidewalk1Poly)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 25 say: 9)
			)
			(7
				(gSq4GlobalNarrator modNum: 25 say: 10)
			)
			(6
				(gSq4GlobalNarrator modNum: 25 say:)
			)
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

(instance theArea of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		lookStr 4
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

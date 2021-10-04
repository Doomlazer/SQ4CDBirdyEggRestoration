;;; Sierra Script 1.0 - (do not remove this comment)
(script# 25)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Feature)
(use Polygon)
(use n958)
(use DPath)
(use Cycle)
(use Obj)

(public
	rm025 0
)

(local
	[local0 30] = [32 189 54 172 72 168 91 154 99 141 101 101 106 97 147 100 170 83 189 75 201 67 212 49 211 0 0 0 0 189]
	[local30 14] = [319 87 289 88 244 74 199 69 212 51 212 0 319]
	[local44 38] = [33 189 55 172 71 168 82 162 94 151 99 143 102 128 102 115 100 102 105 97 148 100 171 82 185 78 199 71 258 78 267 82 280 82 287 88 182 189]
	[local82 8] = [181 189 285 89 319 92 319 189]
)
(procedure (localproc_0411 param1 param2 param3 param4 &tmp temp0 temp1 temp2)
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

(instance rm025 of SQRoom
	(properties
		picture 25
		style $000a
		east 30
		south 40
		vanishingX 319
		vanishingY -35
	)
	
	(method (init)
		(switch global12
			(south (gEgo x: 103))
			(45
				(proc0_2)
				(gEgo init: x: 272 y: 245)
				(self setScript: enterScript)
			)
			(else 
				(proc0_3)
				(gEgo view: 0 posn: 160 160)
			)
		)
		(if (proc0_6 0)
			(proc958_0 128 7 13)
			(cop1 init:)
			(cop2 init:)
		)
		(gEgo init:)
		(theRubble init:)
		(theGreenBuilding init:)
		(theStreet init:)
		(theSidewalk init:)
		(theArea init:)
		(self setRegions: 701)
		(super init:)
		(self setRegions: 705)
		(global2
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
						89
						299
						92
						266
						85
						246
						79
						211
						77
						195
						73
						153
						104
						111
						101
						62
						146
						69
						169
						45
						189
					yourself:
				)
		)
		(buildingPoly points: @local0 size: 15)
		(rubblePoly points: @local30 size: 7)
		(sidewalkPoly points: @local44 size: 19)
		(streetPoly points: @local82 size: 4)
	)
	
	(method (newRoom newRoomNumber)
		(if
			(and
				(!= (global2 script?) (ScriptID 701 3))
				(!= ((ScriptID 701 1) script?) (ScriptID 701 4))
				(== (gEgo edgeHit?) 3)
				(> (gEgo x?) 199)
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
				(gEgo setLoop: 7 setMotion: MoveTo 242 188 self)
			)
			(1
				(proc0_1)
				(if (not (proc0_6 0)) (proc0_3))
				(client setScript: 0)
			)
		)
	)
)

(instance cop1 of Sq4Actor
	(properties
		x 241
		y 110
		view 7
		loop 2
	)
	
	(method (doit)
		(super doit: &rest)
		(if (not (self script?)) (self setScript: shootEgo))
	)
)

(instance cop2 of Sq4Actor
	(properties
		x 88
		y 126
		view 7
	)
)

(instance shootEgo of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cop1 setCycle: Walk setMotion: MoveTo 200 140 self)
				(cop2 setCycle: Walk setMotion: DPath 120 126 120 136)
			)
			(1
				(cop1 view: 13 cel: 0 setMotion: 0 setCycle: CT 4 1 self)
			)
			(2
				(proc0_2)
				(cop1 setCycle: End self)
				(if (< (cop1 x?) (gEgo x?))
					(localproc_0411
						(- (cop1 y?) 27)
						(cop1 x?)
						(- (gEgo y?) 32)
						(gEgo x?)
					)
				else
					(localproc_0411
						(- (gEgo y?) 32)
						(gEgo x?)
						(- (cop1 y?) 27)
						(cop1 x?)
					)
				)
			)
			(3
				(gEgo
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
			(4
				(gEgo setCycle: CT 1 -1 self)
			)
			(5 (gEgo setCycle: End self))
			(6 (= seconds 4))
			(7 (proc0_10 8))
		)
	)
)

(instance theRubble of Sq4Feature
	(properties
		x 270
		y 33
		sightAngle 40
		lookStr 1
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: rubblePoly)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 1))
			(4 (gSq4GlobalNarrator say: 2))
			(6 (gSq4GlobalNarrator say: 3))
			(7 (gSq4GlobalNarrator say: 4))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance rubblePoly of Polygon
	(properties)
)

(instance theGreenBuilding of Sq4Feature
	(properties
		y 180
		sightAngle 40
		lookStr 5
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: buildingPoly)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 5))
			(4 (gSq4GlobalNarrator say: 6))
			(6 (gSq4GlobalNarrator say: 7))
			(7 (gSq4GlobalNarrator say: 8))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance buildingPoly of Polygon
	(properties)
)

(instance theSidewalk of Sq4Feature
	(properties
		x 100
		y 150
		sightAngle 40
		lookStr 9
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: sidewalkPoly)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 9))
			(7 (gSq4GlobalNarrator say: 10))
			(6 (gSq4GlobalNarrator say: 11))
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

(instance theStreet of Sq4Feature
	(properties
		x 300
		y 150
		sightAngle 40
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: streetPoly)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (theArea doVerb: 1))
			(9
				((ScriptID 705 4) doVerb: theVerb param2)
			)
			(6 (gSq4GlobalNarrator say: 12))
			(7 (gSq4GlobalNarrator say: 13))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance streetPoly of Polygon
	(properties)
)

(instance theArea of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 14))
			(9
				((ScriptID 705 4) doVerb: theVerb param2)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

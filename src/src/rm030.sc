;;; Sierra Script 1.0 - (do not remove this comment)
(script# 30)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Feature)
(use Polygon)
(use ForwardCounter)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm030 0
)

(local
	[local0 28] = [0 172 22 177 36 174 64 174 80 181 120 173 149 179 168 174 205 180 232 180 256 185 319 184 319 189 0 189]
)
(instance rm030 of SQRoom
	(properties
		picture 30
		style $000a
		east 35
		south 45
		west 25
	)
	
	(method (init)
		(Load rsSOUND 148)
		(Load rsSCRIPT 956)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						0
						319
						0
						319
						185
						293
						185
						251
						187
						220
						181
						156
						182
						120
						176
						81
						183
						59
						176
						32
						180
						0
						175
					yourself:
				)
		)
		(switch global12
			(east
				(gEgo y: 186 setHeading: 270)
			)
			(west
				(gEgo y: 179 setHeading: 90)
			)
			(south 0)
			(else  (gEgo posn: 160 185))
		)
		(gEgo init:)
		(lightningScript start: 1)
		(lightning1 init: hide: setScript: lightningScript)
		(thunder init:)
		(theRubble init:)
		(theBackBldgs init:)
		(streetPoly points: @local0 size: 14)
		(theStreet init:)
		(opening init:)
		(superComputer init:)
		(theArea init:)
		(if (not (proc0_6 0)) (self setRegions: 701))
		(super init:)
		(self setRegions: 705)
	)
)

(instance lightningScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 10 20)))
			(1
				(self start: 0)
				(= seconds (Random 3 6))
			)
			(2
				(client show: setCel: 0 setCycle: Fwd)
				(= cycles 1)
			)
			(3
				(thunder play:)
				(client setCycle: ForwardCounter (Random 1 3) self)
			)
			(4 (client hide:) (self init:))
		)
	)
)

(instance thunder of Sound
	(properties
		number 150
		priority 15
	)
)

(instance lightning1 of Sq4Prop
	(properties
		x 240
		y 38
		view 32
	)
)

(instance theRubble of Sq4Feature
	(properties
		x 160
		y 5
		nsBottom 200
		nsRight 320
		onMeCheck $2000
		lookStr 1
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gSq4GlobalNarrator say: 2))
			(6 (gSq4GlobalNarrator say: 3))
			(7 (gSq4GlobalNarrator say: 4))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theBackBldgs of Sq4Feature
	(properties
		x 160
		y 5
		nsBottom 200
		nsRight 320
		onMeCheck $0040
		lookStr 5
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(7 (gSq4GlobalNarrator say: 6))
			(6 (gSq4GlobalNarrator say: 7))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theStreet of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		lookStr 8
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: streetPoly)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (gSq4GlobalNarrator say: 9))
			(7 (gSq4GlobalNarrator say: 10))
			(9
				((ScriptID 705 4) doVerb: theVerb)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance streetPoly of Polygon
	(properties)
)

(instance superComputer of Sq4Feature
	(properties
		x 160
		y 20
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck $0400
		lookStr 11
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(7 (gSq4GlobalNarrator say: 12))
			(6 (gSq4GlobalNarrator say: 13))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance opening of Sq4Feature
	(properties
		x 160
		y 22
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck $0800
		lookStr 14
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theArea of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		lookStr 15
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(9
				((ScriptID 705 4) doVerb: theVerb)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

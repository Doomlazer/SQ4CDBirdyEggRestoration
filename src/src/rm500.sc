;;; Sierra Script 1.0 - (do not remove this comment)
(script# 500)
(include sci.sh)
(use Main)
(use brain)
(use SQRoom)
(use Sq4Feature)
(use PolyPath)
(use Cycle)
(use Obj)

(public
	rm500 0
)

(instance rm500 of SQRoom
	(properties
		picture 500
		style $000a
		east 505
		south 515
		vanishingX 380
		vanishingY -75
	)
	
	(method (init)
		(Load rsVIEW 508)
		(if (== global12 515)
			(self setScript: enterScript)
		else
			(proc0_3)
		)
		(gEgo init:)
		(self setRegions: 704)
		(super init:)
		(brain
			makePolygon: 0 189 0 0 319 0 319 108 165 104 59 189
		)
		(brain makePolygon: 110 189 174 125 319 125 319 189)
		((ScriptID 704 5)
			x: 237
			y: 90
			nsLeft: 230
			nsTop: 85
			nsBottom: 96
			nsRight: 244
			sightAngle: 90
			init:
		)
		(light init: setCycle: Fwd)
		(roomFeature init:)
	)
	
	(method (doit)
		(super doit:)
		(if (proc0_5 gEgo 8) (brain exitDir: 225))
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo x: 52 y: 229 setMotion: PolyPath 98 183 self)
			)
			(1 (proc0_3) (self dispose:))
		)
	)
)

(instance light of Sq4Prop
	(properties
		x 110
		y 49
		view 508
		lookStr 1
	)
)

(instance roomFeature of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 2))
			(2 (gSq4GlobalNarrator say: 3))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

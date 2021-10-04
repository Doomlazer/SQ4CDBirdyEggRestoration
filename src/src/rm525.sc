;;; Sierra Script 1.0 - (do not remove this comment)
(script# 525)
(include sci.sh)
(use Main)
(use brain)
(use SQRoom)
(use Sq4Feature)
(use PolyPath)
(use Obj)

(public
	rm525 0
)

(instance rm525 of SQRoom
	(properties
		picture 525
		style $000a
		north 510
		south 541
		west 520
		vanishingX -200
		vanishingY -280
	)
	
	(method (init)
		(switch global12
			(north
				(self setScript: enterScript 0 (brain level?))
			)
			(541
				(self setScript: enterScript 0 0)
			)
			(else  (proc0_3))
		)
		(gEgo init:)
		(self setRegions: 704)
		(super init:)
		(switch (brain level?)
			(2
				(brain
					makePolygon: 0 132 57 132 91 189 0 189
					makePolygon: -80 38 46 112 -80 112
					makePolygon: 0 0 319 0 319 189 135 189
				)
			)
			(3
				(brain
					makePolygon: 0 0 102 0 117 24 0 24
					makePolygon: 120 0 319 0 319 82 227 22 143 22
					makePolygon: -50 37 227 37 390 164 208 164 128 79 -50 76
					makePolygon: 0 97 124 97 194 183 319 183 319 189 0 189
				)
			)
		)
		((ScriptID 704 4)
			x: 6
			y: 106
			nsLeft: 2
			nsTop: 103
			nsBottom: 109
			nsRight: 11
			sightAngle: 90
			init:
		)
		((ScriptID 704 5)
			x: 70
			y: 63
			nsLeft: 63
			nsTop: 58
			nsBottom: 69
			nsRight: 77
			sightAngle: 90
			init:
		)
		(roomFeature init:)
	)
	
	(method (doit)
		(super doit:)
		(if (== (brain level?) 3)
			(if (gEgo inRect: 0 0 64 40)
				(gEgo setPri: 4)
			else
				(gEgo setPri: -1)
			)
		)
		(cond 
			(script)
			((proc0_5 gEgo 4) (self setScript: oSS 0 4))
			((proc0_5 gEgo 16) (self setScript: oSS 0 16))
			((and (proc0_5 gEgo 32) (== (brain level?) 2)) (self setScript: exitScript))
			((proc0_5 gEgo 8)
				(if (== (brain level?) 3)
					(brain exitDir: 315)
				else
					(brain exitDir: 150)
				)
			)
		)
	)
)

(instance exitScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: PolyPath -8 -1 self)
			)
			(1
				(global2 newRoom: 510)
				(self dispose:)
			)
		)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2] temp2 temp3 temp4 temp5)
		(switch (= state newState)
			(0
				(proc0_2)
				(switch register
					(0
						(= temp2 150)
						(= temp3 240)
						(= temp4 113)
						(= temp5 174)
					)
					(3
						(= temp2 95)
						(= temp3 -8)
						(= temp4 134)
						(= temp5 24)
					)
					(else 
						(= temp2 -8)
						(= temp3 -1)
						(= temp4 32)
						(= temp5 48)
					)
				)
				(gEgo
					x: temp2
					y: temp3
					setMotion: PolyPath temp4 temp5 self
				)
			)
			(1 (proc0_3) (self dispose:))
		)
	)
)

(instance oSS of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (gEgo mover?)
					(= temp0 ((gEgo mover?) x?))
					(= temp1 ((gEgo mover?) y?))
				else
					(= temp0 (= temp1 0))
				)
				(proc0_2)
				(if (or (> temp0 319) (== temp0 0))
					(if (== register 16)
						(gEgo setMotion: PolyPath 294 173 self)
					else
						(gEgo setMotion: PolyPath 308 87 self)
					)
				else
					(gEgo setMotion: PolyPath temp0 temp1 self)
				)
			)
			(1 (proc0_3) (self dispose:))
		)
	)
)

(instance roomFeature of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 500 say: 2)
			)
			(2
				(gSq4GlobalNarrator modNum: 500 say: 3)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

;;; Sierra Script 1.0 - (do not remove this comment)
(script# 975)
(include sci.sh)
(use Scaler)


(class ScaleTo of Scaler
	(properties
		client 0
		frontY 190
		backY 0
		frontSize 100
		backSize 0
		slopeNum 0
		slopeDen 0
		const 0
		caller 0
		endScale 0
		step 1
		adjustValue 0
		repCount 0
	)
	
	(method (init theClient theEndScale theCaller theCaller_2 &tmp temp0)
		(if argc
			(= client theClient)
			(if (>= argc 2)
				(= endScale theEndScale)
				(if (>= argc 3)
					(if (IsObject theCaller)
						(= caller theCaller)
					else
						(= step theCaller)
					)
					(if (>= argc 4) (= caller theCaller_2))
				)
			)
		)
		(= adjustValue
			(*
				step
				(= temp0 (- (* (> endScale (client maxScale?)) 2) 1))
			)
		)
		(= repCount
			(/ (Abs (- endScale (client maxScale?))) step)
		)
	)
	
	(method (doit &tmp temp0)
		(if repCount
			(if (!= (-- repCount) 0)
				(client maxScale: (+ (client maxScale?) adjustValue))
			else
				(client maxScale: endScale)
			)
		)
		(client
			scaleX: (client maxScale?)
			scaleY: (client maxScale?)
		)
		(if (not repCount) (self dispose:))
	)
	
	(method (dispose &tmp theCaller)
		(= endScale 0)
		(= step 1)
		(client scaler: 0)
		(if caller
			(= theCaller caller)
			(= caller 0)
			(theCaller cue:)
		)
		(super dispose:)
	)
)

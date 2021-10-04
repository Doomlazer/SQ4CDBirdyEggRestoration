;;; Sierra Script 1.0 - (do not remove this comment)
(script# 765)
(include sci.sh)
(use Main)
(use Obj)


(class AudioScript of Script
	(properties
		client 0
		state $ffff
		start 0
		timer 0
		cycles 0
		seconds 0
		lastSeconds 0
		ticks 0
		lastTicks 0
		register 0
		script 0
		caller 0
		next 0
		waitForCue 0
	)
	
	(method (doit)
		(super doit: &rest)
		(if
			(and
				waitForCue
				global82
				(u>=
					(& (global82 prevCue?) $fff0)
					(& waitForCue $fff0)
				)
			)
			(= cycles 1)
			(= waitForCue 0)
		)
	)
)

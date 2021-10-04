;;; Sierra Script 1.0 - (do not remove this comment)
(script# 810)
(include sci.sh)
(use Main)
(use Obj)


(class rmnScript of Script
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
		save1 0
		DTimer 10
		counter 0
	)
	
	(method (init)
		(if (not (gSq4KeyDownHandler contains: self))
			(gSq4KeyDownHandler addToFront: self)
		)
		(if (not (gSq4MouseDownHandler contains: self))
			(gSq4MouseDownHandler addToFront: self)
		)
		(if (not (gSq4DirectionHandler contains: self))
			(gSq4DirectionHandler addToFront: self)
		)
		(= counter DTimer)
		(super init: &rest)
	)
	
	(method (doit)
		(super doit:)
		(if save1 (-- counter))
	)
	
	(method (dispose)
		(gSq4KeyDownHandler delete: self)
		(gSq4MouseDownHandler delete: self)
		(gSq4DirectionHandler delete: self)
		(super dispose: &rest)
	)
	
	(method (handleEvent pEvent)
		(cond 
			((and save1 (<= counter 0))
				(pEvent claimed: 1)
				(self restore:)
				(= seconds 0)
				(= cycles 1)
			)
			(save1 (pEvent claimed: 1))
			(else (super handleEvent: pEvent))
		)
	)
	
	(method (restore)
		(if save1
			(Display 810 0 108 save1)
			(= save1 0)
			(= counter DTimer)
		)
	)
)

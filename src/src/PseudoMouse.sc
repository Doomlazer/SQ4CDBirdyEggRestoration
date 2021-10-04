;;; Sierra Script 1.0 - (do not remove this comment)
(script# 933)
(include sci.sh)
(use Main)
(use Obj)


(class PseudoMouse of Code
	(properties
		cursorInc 2
		minInc 2
		maxInc 20
		prevDir 0
		joyInc 5
	)
	
	(method (doit &tmp temp0 temp1)
		(= temp0 (global24 x?))
		(= temp1 (global24 y?))
		(switch prevDir
			(1
				(= temp1 (- temp1 cursorInc))
			)
			(2
				(= temp0 (+ temp0 cursorInc))
				(= temp1 (- temp1 cursorInc))
			)
			(3
				(= temp0 (+ temp0 cursorInc))
			)
			(4
				(= temp0 (+ temp0 cursorInc))
				(= temp1 (+ temp1 cursorInc))
			)
			(5
				(= temp1 (+ temp1 cursorInc))
			)
			(6
				(= temp0 (- temp0 cursorInc))
				(= temp1 (+ temp1 cursorInc))
			)
			(7
				(= temp0 (- temp0 cursorInc))
			)
			(8
				(= temp0 (- temp0 cursorInc))
				(= temp1 (- temp1 cursorInc))
			)
		)
		(global1 setCursor: gCursorNumber 1 temp0 temp1)
	)
	
	(method (handleEvent pEvent &tmp pEventType thePrevDir pEventModifiers)
		(= pEventType (pEvent type?))
		(= thePrevDir (pEvent message?))
		(= pEventModifiers (pEvent modifiers?))
		(return
			(if (& pEventType evJOYSTICK)
				(if
					(or
						(not gIconBar)
						(!= (gIconBar curIcon?) (gIconBar walkIconItem?))
					)
					(= prevDir thePrevDir)
				else
					(return 0)
				)
				(= cursorInc
					(if (& pEventType evKEYBOARD)
						(if (& pEventModifiers emSHIFT) minInc else maxInc)
					else
						joyInc
					)
				)
				(cond 
					((& pEventType evKEYBOARD)
						(if prevDir
							(self doit:)
						else
							(return (pEvent claimed: 0))
						)
					)
					(prevDir (self start:))
					(else (self stop:))
				)
				(return (pEvent claimed: 1))
			else
				0
			)
		)
	)
	
	(method (start thePrevDir)
		(if argc (= prevDir thePrevDir))
		(global78 add: self)
	)
	
	(method (stop)
		(= prevDir 0)
		(global78 delete: self)
	)
)

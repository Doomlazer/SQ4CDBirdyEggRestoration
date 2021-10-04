;;; Sierra Script 1.0 - (do not remove this comment)
(script# 809)
(include sci.sh)
(use Main)
(use PolyPath)
(use Cycle)
(use User)
(use Obj)


(local
	[local0 18] = [359 338 22 0 67 23 112 68 157 113 202 158 247 203 292 248 337 293]
	[theXOff 18] = [0 -1 0 -1 1 -1 1 0 1 1 0 1 -1 1 -1 0 -1 -1]
	theGTixCnt
)
(class Inertia of Code
	(properties
		client 0
		inertia 0
		maxInertia 0
		oldDir 0
		oldSpeed 0
		oldMover 0
		swimCnt 0
		xOff 0
		yOff 0
		inertizing 0
	)
	
	(method (init theClient)
		(if argc (= client theClient) else (= client gEgo))
		(= xOff
			(= yOff
				(= inertia (= swimCnt (= inertizing (= oldMover 0))))
			)
		)
		(= oldDir (client heading?))
		(if (client mover?) (= oldMover (client mover?)))
		(if (== client gEgo) (client setScript: inertiaScript))
		(client code: self)
	)
	
	(method (doit &tmp temp0)
		(cond 
			((client isBlocked:) (self moveDone:))
			(inertizing
				(cond 
					(
					(and (== (client heading?) oldDir) (client mover?)) (self moveDone:))
					((> swimCnt 0) (self doMove:) (-- swimCnt))
					((> inertia 0) (self doMove:) (-- inertia) (= swimCnt inertia))
					(else (self moveDone:))
				)
			)
			(
				(and
					(< inertia maxInertia)
					(>= (++ swimCnt) (client moveSpeed?))
					(client mover?)
				)
				(= oldMover (client mover?))
				(= swimCnt 0)
				(++ inertia)
			)
			(
				(or
					(!= (client heading?) oldDir)
					(and (not (client mover?)) oldMover)
				)
				(= temp0 0)
				(while (< temp0 17)
					(if
						(and
							(>= [local0 temp0] oldDir)
							(>= oldDir [local0 (+ temp0 1)])
						)
						(= xOff [theXOff temp0])
						(= yOff [theXOff (+ temp0 1)])
						(= temp0 17)
					)
					(= temp0 (+ temp0 2))
				)
				(= inertizing 1)
				(= swimCnt inertia)
				(= oldSpeed (client moveSpeed?))
				(self doMove:)
			)
		)
	)
	
	(method (dispose)
		(client moveSpeed: oldSpeed code: 0)
		(if (== client gEgo) (client setScript: 0))
		(= client 0)
		(super dispose:)
	)
	
	(method (doMove)
		(if (< (Abs (- gTixCnt theGTixCnt)) global199)
			0
		else
			(= theGTixCnt gTixCnt)
			(client
				moveSpeed: inertia
				x: (+ (client x?) (* (client xStep?) xOff))
				y: (+ (client y?) (* (client yStep?) yOff))
			)
		)
	)
	
	(method (moveDone)
		(client moveSpeed: oldSpeed)
		(= oldDir (client heading?))
		(= xOff
			(= yOff
				(= inertia (= swimCnt (= inertizing (= oldMover 0))))
			)
		)
	)
)

(class Swim of Fwd
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
	)
	
	(method (doit)
		(if
		(and (client mover?) (not (client isBlocked:)))
			(super doit:)
		)
	)
)

(instance InertTo of Motion
	(properties)
	
	(method (doit &tmp temp0)
		(if (self onTarget:)
			(self moveDone:)
		else
			(if
				(!=
					(client heading?)
					(GetAngle (client x?) (client y?) x y)
				)
				(InitBresen self)
			)
			(super doit:)
		)
	)
	
	(method (onTarget)
		(return
			(if
				(and
					(>= (+ x 10) (client x?))
					(>= (client x?) (- x 10))
					(>= (+ y 10) (client y?))
				)
				(>= (client y?) (- y 10))
			else
				0
			)
		)
	)
)

(instance inertiaScript of Script
	(properties)
	
	(method (handleEvent pEvent)
		(cond 
			((pEvent claimed?) (return))
			(
				(or
					(!= (gIconBar curIcon?) (gIconBar at: 0))
					(not (User controls?))
					(!= (pEvent type?) evVERB)
					(pEvent modifiers?)
				)
				(super handleEvent: pEvent)
			)
			(else
				(client
					setMotion: (if global67 PolyPath else InertTo) (pEvent x?) (pEvent y?)
				)
				(User prevDir: 0)
				(pEvent claimed: 1)
			)
		)
	)
)

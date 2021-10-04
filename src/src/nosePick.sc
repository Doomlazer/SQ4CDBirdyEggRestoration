;;; Sierra Script 1.0 - (do not remove this comment)
(script# 808)
(include sci.sh)
(use Main)
(use SQRoom)
(use StopWalk)
(use Cycle)
(use User)
(use Obj)

(public
	nosePick 0
)

(local
	local0
	local1
	local2
	gEgoSignal
	gEgoPriority
	gEgoIllegalBits
	gEgoCycleSpeed
)
(instance nosePick of Code
	(properties)
	
	(method (doit)
		(if
			(and
				(User canControl:)
				(User canInput:)
				(IsObject global2)
				(global2 isKindOf: SQRoom)
				(not (global2 script?))
				(gEgo normal?)
				(not (& (gEgo signal?) $0008))
				(gEgo isStopped:)
				(IsObject (gEgo cycler?))
				((gEgo cycler?) isKindOf: StopWalk)
				(== (gEgo view?) ((gEgo cycler?) vStopped?))
				(== ((gEgo cycler?) vStopped?) 4)
			)
			(if (!= local0 (GetTime 1))
				(= local0 (GetTime 1))
				(if (> (++ local1) 120)
					(proc0_2)
					(global2 setScript: nPS)
				)
			)
		else
			(= local1 0)
		)
	)
)

(instance nPS of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(Load rsVIEW 65)
				(if (!= (gEgo loop?) 2)
					(gEgo setHeading: 180 self)
				else
					(= cycles 1)
				)
			)
			(1
				(= temp0 (Random 0 2))
				(= gEgoSignal (gEgo signal?))
				(= gEgoPriority (gEgo priority?))
				(= gEgoIllegalBits (gEgo illegalBits?))
				(= gEgoCycleSpeed (gEgo cycleSpeed?))
				(gEgo
					view: 65
					setLoop: temp0
					cycleSpeed: 12
					cel: 0
					setCycle: End self
				)
				(Animate (global5 elements?) 0)
			)
			(2
				(proc0_1 2 0 4)
				(gEgo
					signal: gEgoSignal
					priority: gEgoPriority
					illegalBits: gEgoIllegalBits
					cycleSpeed: gEgoCycleSpeed
				)
				(= local0 (= start 0))
				(= local1 0)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

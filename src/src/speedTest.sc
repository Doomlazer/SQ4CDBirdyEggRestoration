;;; Sierra Script 1.0 - (do not remove this comment)
(script# 803)
(include sci.sh)
(use Main)
(use Cycle)
(use Game)
(use View)
(use Obj)

(public
	speedTest 0
)

(local
	local0
	local1
	local2
	local3
)
(instance fred of Actor
	(properties)
)

(instance speedTest of Rm
	(properties
		picture 803
		style $0064
	)
	
	(method (init)
		(= local2 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING global27 6 local2)
		(FileIO fiCLOSE local2)
		(super init:)
		(global8 eachElementDo: #stop)
		(while (u> (GetTime) -1024)
		)
		(fred
			view: 803
			setLoop: 0
			illegalBits: 0
			posn: 20 99
			setStep: 1 1
			setMotion: MoveTo 300 100
			setCycle: Fwd
			init:
		)
		(= global170 (Random 0 9))
		(= global185 3417)
		(= global199 0)
		(= local1 0)
		(= local3 (if (proc0_6 21) 90 else 40))
	)
	
	(method (doit)
		(super doit:)
		(if (== (++ local1) 1) (= local0 (+ 60 (GetTime))))
		(if
		(and (u< local0 (GetTime)) (not (self script?)))
			(if (< local1 local3)
				(= global87 0)
				(global1 detailLevel: 1)
			else
				(= global87 2)
			)
			(self setScript: speedScript)
		)
	)
	
	(method (dispose)
		(super dispose:)
	)
)

(instance speedScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 1))
			(1
				(= global199 6)
				(= cycles 1)
			)
			(2
				(= register 1)
				(while (<= register 5)
					(= [gNewTheDisplayCel register] (Random 0 14))
					(++ register)
				)
				(global2 newRoom: global107)
			)
		)
	)
)

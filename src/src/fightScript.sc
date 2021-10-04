;;; Sierra Script 1.0 - (do not remove this comment)
(script# 151)
(include sci.sh)
(use Main)
(use brain)
(use Sq4Narrator)
(use Sq4Feature)
(use PolyPath)
(use n958)
(use StopWalk)
(use Rev)
(use Cycle)
(use Obj)

(public
	fightScript 0
	endFightScript 1
)

(local
	local0
	local1
	local2
	local3 =  50
	local4
	local5
	local6
	[local7 8] = [161 189 186 154 120 91 89 118]
	[local15 8] = [119 107 80 67 61 79 107 126]
	[local23 10] = [361 353 307 267 246 173 126 85 64]
	[local33 9] = [5 4 3 2 1 0 7 6 5]
	[local42 9] = [1 0 7 6 5 4 3 2 1]
	[local51 8] = [2 2 1 1 3 3]
	[local59 8] = [6 6 5 5 7 7 4 4]
	[local67 8] = [5 -5 0 0 -5 5 5]
	[local75 8] = [5 5 0 -5 -5 -5]
)
(procedure (localproc_0038 param1 param2)
	(if (not ((ScriptID 150 1) mover?))
		(gEgo view: 526 setCycle: Walk)
		((ScriptID 150 1) view: 527 setCycle: Walk)
		(cond 
			((== param1 0) (if (> (++ local5) 7) (= local5 0)))
			((< (-- local5) 0) (= local5 7))
		)
		(param2 cue:)
	)
)

(instance fightScript of Script
	(properties)
	
	(method (init)
		(super init: &rest)
		(gSq4DirectionHandler addToFront: self)
		(gSq4MouseDownHandler
			addToFront: self
			addToFront: (ScriptID 150 1)
		)
		(= local1 1)
		(= local5 0)
		(= local6 4)
		(proc958_0 128 523 524 525 526 527 528)
		(gLongSong number: 868 vol: 127 loop: -1 play:)
		(global1 setCursor: gWalkCursor 1)
	)
	
	(method (doit &tmp temp0 temp1)
		(super doit:)
		(cond 
			(script)
			(
				(and
					(< (gEgo distanceTo: (ScriptID 150 1)) 15)
					(< state 4)
				)
				(self setScript: struggleScript self)
			)
			((== (gEgo view?) 526)
				(if (gEgo mover?)
					(= temp0 (GetAngle (gEgo x?) (gEgo y?) 137 89))
					(= temp1 0)
					(while (< temp0 [local23 temp1])
						(++ temp1)
					)
					(gEgo setLoop: [local33 (-- temp1)])
					((ScriptID 150 1) setLoop: [local42 temp1])
				)
				(if (< (-- local3) 1)
					(= register 0)
					(self changeState: 3)
				)
			)
		)
	)
	
	(method (dispose)
		(gSq4DirectionHandler delete: self)
		(gSq4MouseDownHandler
			delete: self
			delete: (ScriptID 150 1)
		)
		(super dispose:)
		(DisposeScript (ScriptID 151))
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 526 setLoop: 3)
				(= cycles 1)
			)
			(1
				(= local0 1)
				(global1 setCursor: gWalkCursor 1)
				(global2 notify: local0)
			)
			(2
				((ScriptID 150 1)
					setMotion:
						MoveTo
						[local7 local6]
						[local15 (gEgo
							setMotion:
								MoveTo
								[local7 local5]
								[local15 (if (> (= local6 (+ local5 4)) 7)
									(= local6 (- local6 8))
								)]
						)]
				)
				(self changeState: 1)
			)
			(3
				(if register
					(gEgo
						view: 524
						setMotion: MoveTo ((ScriptID 150 1) x?) ((ScriptID 150 1) y?)
					)
				)
				((ScriptID 150 1)
					view: 525
					setMotion: MoveTo (gEgo x?) (gEgo y?)
				)
			)
			(4
				(if (== local4 5)
					(= cycles 1)
				else
					(= local3 (Random 50 100))
					(self changeState: 1)
				)
			)
			(5 (self dispose:))
		)
	)
	
	(method (handleEvent pEvent &tmp temp0 temp1)
		(if local0
			(cond 
				((== (pEvent type?) evMOUSEBUTTON)
					(= temp0 (OnControl 4 (pEvent x?) (pEvent y?)))
					(= temp1 (OnControl 4 (gEgo x?) (gEgo y?)))
					(cond 
						(
							(or
								(== temp0 (* temp1 2))
								(and (== temp0 8) (== temp1 1024))
							)
							(localproc_0038 0 self)
						)
						(
							(or
								(== temp0 (/ temp1 2))
								(and (== temp0 1024) (== temp1 8))
							)
							(localproc_0038 1 self)
						)
					)
				)
				(
					(and
						(& (pEvent type?) evJOYSTICK)
						(== (gEgo view?) 526)
						(not (gEgo mover?))
					)
					(switch (pEvent message?)
						(JOY_UP
							(= register 1)
							(self changeState: 3)
							(= local1 0)
						)
						(JOY_RIGHT
							(localproc_0038 0 self)
						)
						(JOY_LEFT
							(localproc_0038 1 self)
						)
					)
				)
			)
		)
	)
)

(instance struggleScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(= local0 0)
				(global2 notify: local0)
				(global1 setCursor: (ScriptID 0 19) 1)
				(= temp0 (+ (gEgo x?) [local67 (gEgo loop?)]))
				(= temp1 (+ (gEgo y?) [local75 (gEgo loop?)]))
				(gEgo
					view: 523
					posn: temp0 temp1
					setCel: 0
					setCycle: CT (Random 3 7) 1 self
					setMotion: 0
				)
				((ScriptID 150 1) setMotion: 0 hide:)
			)
			(1 (= cycles (Random 1 5)))
			(2
				(gEgo setCycle: CT (Random 0 2) -1 self)
			)
			(3
				(if (== (++ local4) 5)
					(gEgo setLoop: 4)
					((ScriptID 150 1) setLoop: 0)
					(= local5 0)
					(= local6 4)
				)
				(= cycles (Random 1 5))
			)
			(4
				(gEgo setCycle: CT (Random 3 7) 1 self)
			)
			(5
				(= register (if (== local4 5) 0 else (Random 0 1)))
				(= temp0 (- (gEgo x?) [local67 (gEgo loop?)]))
				(= temp1 (- (gEgo y?) [local75 (gEgo loop?)]))
				(if register
					((ScriptID 150 1)
						view: 525
						setLoop: [local42 (+ local5 1)]
						show:
					)
					(gEgo
						view: 528
						posn: temp0 temp1
						setLoop: [local51 (gEgo loop?)]
						setCel: 0
						cycleSpeed: 12
						setCycle: CT 2 1 self
					)
				else
					(gEgo
						view: 524
						setLoop: (if (== local4 5) 4 else [local33 (+ local5 1)])
					)
					((ScriptID 150 1)
						view: 528
						setLoop: [local59 ((ScriptID 150 1) loop?)]
						setCel: 0
						show:
						cycleSpeed: 12
						setCycle: CT 2 1 self
					)
				)
			)
			(6
				(if local1
					(if register
						(if local2
							(gSq4DirectionHandler delete: client)
							(gSq4MouseDownHandler
								delete: client
								delete: (ScriptID 150 1)
							)
							(client setScript: fallScript)
						else
							(= local2 1)
							(gSq4GlobalNarrator modNum: 151 say: 1 self)
						)
					else
						(= cycles 1)
					)
				else
					(= cycles 1)
				)
			)
			(7
				(if register
					((ScriptID 150 1)
						view: 525
						setLoop: [local42 (+ local5 1)]
						show:
						setCycle: Rev
						setMotion: MoveTo [local7 local6] [local15 local6] self
					)
				else
					(= temp2 (if (== local4 5) 0 else local5))
					(gEgo
						view: 524
						setLoop: (if (== local4 5) 4 else [local33 (+ local5 1)])
						setCycle: Rev
						setMotion: MoveTo [local7 temp2] [local15 temp2] self
					)
				)
			)
			(8
				(if register
					((ScriptID 150 1)
						view: 525
						setLoop: [local42 (+ local5 1)]
						setCycle: 0
					)
					(gEgo setCycle: End self)
				else
					(gEgo
						view: 524
						setLoop: (if (== local4 5) 4 else [local33 (+ local5 1)])
						setCycle: 0
					)
					((ScriptID 150 1) setCycle: End self)
				)
			)
			(9
				(if register
					(gEgo
						view: 524
						setLoop: [local33 (+ local5 1)]
						cycleSpeed: 6
						setCycle: Rev
						setMotion:
							MoveTo
							[local7 local5]
							[local15 ((ScriptID 150 1) view: 527 setCycle: Walk)]
							self
					)
				else
					(gEgo view: 526 setCycle: Walk)
					((ScriptID 150 1)
						view: 525
						setLoop: [local42 (+ local5 1)]
						cycleSpeed: 6
						setMotion: 0
					)
					(if (not (== local4 5))
						((ScriptID 150 1)
							setCycle: Rev
							setMotion: MoveTo [local7 local6] [local15 local6] self
						)
					else
						((ScriptID 150 1)
							setCycle: Walk
							setMotion: MoveTo 145 105 self
						)
					)
				)
			)
			(10
				(if (not (== local4 5))
					(if register
						(gEgo view: 526 setCycle: Walk)
					else
						((ScriptID 150 1) view: 527 setCycle: Walk)
					)
					(= local1 1)
				)
				(global1 setCursor: gWalkCursor 1)
				(self dispose:)
			)
		)
	)
)

(instance endFightScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				((ScriptID 150 2)
					setMotion: MoveTo 120 98 (ScriptID 150 2)
				)
				(= local3 1000)
			)
			(1
				(gLongSong2 number: 848 vol: 127 loop: -1 play:)
				(beam init: setCycle: Fwd)
				(brain
					makePolygon:
						127
						101
						121
						103
						112
						96
						111
						91
						111
						87
						113
						80
						115
						2
						169
						2
						162
						81
						160
						88
						158
						95
						149
						100
						142
						102
				)
				(= cycles 6)
			)
			(2
				((ScriptID 150 1)
					setCycle: Walk
					setMotion: MoveTo 145 105 self
				)
			)
			(3 (tVOHAULJR say: 1 self))
			(4
				(gEgo
					setCycle: Walk
					setMotion:
						PolyPath
						((ScriptID 150 1) x?)
						(+ ((ScriptID 150 1) y?) 7)
						self
				)
			)
			(5
				((ScriptID 150 1) hide:)
				(gEgo view: 523 setCycle: Fwd)
				(= seconds 2)
			)
			(6
				(gEgo view: 524 setCycle: Walk)
				((ScriptID 150 1)
					view: 528
					posn: 139 91
					setLoop: 6
					setCel: 0
					show:
					cycleSpeed: 12
					setCycle: CT 2 1 self
				)
			)
			(7
				((ScriptID 150 1)
					view: 522
					setLoop: 1
					setCel: 5
					setCycle: Beg self
				)
			)
			(8
				((ScriptID 150 1)
					setLoop: 0
					setPri: 4
					posn: 127 39
					cycleSpeed: 6
					setCycle: Fwd
				)
				(beam dispose:)
				(gLongSong2 stop:)
				(gEgo
					view: 3
					setCycle: StopWalk 510
					headView: 510
					setLoop: -1
					setPri: -1
					normal: 1
				)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance fallScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(cond 
					((< (gEgo y?) 95) (= temp0 1))
					((< (gEgo x?) 95) (= temp0 12))
					(else (= temp0 3))
				)
				(gEgo
					setStep: (gEgo xStep?) 19
					setPri: temp0
					setMotion: MoveTo (gEgo x?) 300 self
				)
			)
			(1 (proc0_10))
		)
	)
)

(instance beam of Sq4Prop
	(properties
		x 127
		y 39
		view 522
		loop 5
		priority 4
		signal $4010
	)
)

(instance tVOHAULJR of Sq4Talker
	(properties
		z 400
		noun 32
		modNum 151
		view 1523
		talkerNum 32
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 25
		eyeOffsetY 20
	)
)

;;; Sierra Script 1.0 - (do not remove this comment)
(script# 700)
(include sci.sh)
(use Main)
(use RegionPath)
(use Inertia)
(use Sq4Narrator)
(use Sq4Feature)
(use Print)
(use PolyPath)
(use StopWalk)
(use Cycle)
(use Game)
(use Obj)

(public
	mall 0
	enS 1
	exS 2
	proc700_3 3
	eSwimCode 4
	proc700_5 5
	sp1 6
	sp2 7
	proc700_8 8
	shopper3 9
	newSpeedCode 10
)

(local
	[local0 43] = [32767 400 324 90 -5 90 32767 370 78 231 324 87 32767 375 78 233 324 87 32767 380 -5 142 324 127 32767 385 -5 142 324 158 32767 390 -5 89 239 233 32767 395 -5 88 230 238 -32768]
	[local43 43] = [32767 400 -5 145 324 145 32767 395 324 179 -5 3 32767 390 324 173 -5 0 32767 385 324 116 -5 100 32767 380 324 87 -5 101 32767 375 324 -3 -5 169 32767 370 324 -3 -5 169 -32768]
	[theLoop 8] = [3 6 0 4 2 5 1 7]
)
(procedure (proc700_3 param1 param2 param3)
	(return
		(if (& (param1 param2?) param3)
			(return 1)
		else
			(return 0)
		)
	)
)

(procedure (proc700_5 param1)
	(if param1
		(= global67 1)
		(gEgo illegalBits: 0)
		(if (IsObject (gEgo mover?))
			(gEgo
				setMotion: PolyPath ((gEgo mover?) x?) ((gEgo mover?) y?)
			)
		)
	else
		(= global67 0)
		(gEgo illegalBits: -32768)
	)
)

(procedure (proc700_8)
	(asm
		bnot    
		send     6
		pushi    #z
		pushi    1
		pushi    20000
		lofsa    shopper3
		send     6
		lsg      global11
		ldi      387
		ne?     
		bnt      code_042f
		pushi    2
		pushi    1
		pushi    1
		pushi    30
		callb    proc0_6,  2
		bnt      code_03d1
		ldi      7
		jmp      code_03d4
code_03d1:
		ldi      384
code_03d4:
		push    
		pushi    161
		pushi    1
		class    Walk
		push    
		pushi    315
		pushi    2
		pushi    4
		pushi    2
		pushi    317
		pushi    1
		lsg      global199
		pushi    110
		pushi    0
		pushi    290
		pushi    1
		lofsa    shopperPath2
		push    
		lofsa    shopper2
		send     36
		pushi    2
		pushi    1
		pushi    1
		pushi    30
		callb    proc0_6,  2
		bnt      code_0407
		ldi      7
		jmp      code_040a
code_0407:
		ldi      388
code_040a:
		push    
		pushi    161
		pushi    1
		class    Walk
		push    
		pushi    315
		pushi    2
		pushi    5
		pushi    2
		pushi    317
		pushi    1
		lsg      global199
		pushi    110
		pushi    0
		pushi    290
		pushi    1
		lofsa    shopperPath3
		push    
		lofsa    shopper3
		send     36
code_042f:
		lsg      gWest
		ldi      396
		ne?     
		bnt      code_0486
		pushi    5
		lsg      global11
		pushi    405
		pushi    406
		pushi    410
		pushi    411
		calle    proc999_5,  10
		not     
		bnt      code_0486
		pushi    #view
		pushi    0
		lag      gEgo
		send     4
		push    
		dup     
		ldi      0
		eq?     
		bnt      code_0461
		ldi      4
		jmp      code_0476
code_0461:
		dup     
		ldi      402
		eq?     
		bnt      code_046c
		ldi      14
		jmp      code_0476
code_046c:
		dup     
		ldi      373
		eq?     
		bnt      code_0476
		ldi      374
code_0476:
		toss    
		sat      temp0
		pushi    #setCycle
		pushi    2
		class    StopWalk
		push    
		lst      temp0
		lag      gEgo
		send     8
code_0486:
		pushi    8
		lsg      global11
		pushi    370
		pushi    375
		pushi    380
		pushi    385
		pushi    390
		pushi    395
		pushi    400
		calle    proc999_5,  16
		bnt      code_04c3
		pushi    #init
		pushi    0
		lofsa    belts
		send     4
		pushi    #init
		pushi    0
		lofsa    restOfMall
		send     4
		pushi    #setScript
		pushi    1
		lofsa    nearScript
		push    
		lag      gEgo
		send     6
code_04c3:
		ret     
	)
)

(procedure (localproc_0640 param1)
	(if
		(and
			(gEgo mover?)
			(not (param1 z?))
			(& (param1 signal?) $0400)
			(< (gEgo distanceTo: param1) 35)
		)
		(gEgo setMotion: 0)
	)
)

(instance newSpeedCode of Code
	(properties)
	
	(method (doit param1 &tmp temp0 temp1 temp2)
		(if argc
			(= global199 param1)
			(= temp0 (FirstNode (global5 elements?)))
			(while temp0
				(= temp2 (NextNode temp0))
				(if
					(or
						(not (IsObject (= temp1 (NodeValue temp0))))
						(not (temp1 respondsTo: #setSpeed))
					)
				else
					(temp1 setSpeed: param1 &rest)
				)
				(= temp0 temp2)
			)
		)
		(return global199)
	)
)

(class mall of Rgn
	(properties
		script 0
		number 0
		modNum -1
		noun 0
		timer 0
		keep 0
		initialized 0
		enterBelt 0
		whichBelt 0
		rFlag1 0
		rFlag2 0
		rFlag3 0
		rFlag4 0
	)
	
	(method (init &tmp temp0)
		(super init: &rest)
		(Load rsVIEW 370)
		(Load rsVIEW 7)
		(newSpeedCode doit: global199)
		(if (and (proc0_6 22) (not (proc0_6 30)))
			(if (!= global11 390)
				(proc0_7 30)
				(shopperPath2
					x: 239
					y: 233
					dx: 3
					dy: 1
					b-moveCnt: 0
					b-i1: 258
					b-i2: -78
					b-di: 138
					b-xAxis: 1
					b-incr: 1
					completed: 0
					xLast: 92
					yLast: 146
					currentRoom: 390
					value: 35
					intermediate: 0
				)
				(shopperPath3
					x: -5
					y: 0
					dx: -2
					dy: -1
					b-moveCnt: 0
					b-i1: 34
					b-i2: -624
					b-di: -523
					b-xAxis: 1
					b-incr: -1
					completed: 0
					xLast: 262
					yLast: 140
					currentRoom: 390
					value: 17
					intermediate: 0
				)
				(shopper2
					x: 95
					y: 148
					z: 1000
					heading: 120
					xLast: 95
					yLast: 148
				)
				(shopper3
					x: 260
					y: 139
					z: 1000
					heading: 298
					xLast: 260
					yLast: 139
				)
			else
				(shopper2 z: 20000)
				(shopper3 z: 20000)
			)
		)
		(if (!= global11 387)
			(shopper2
				view: (if (proc0_6 30) 7 else 384)
				setCycle: Walk
				setStep: 4 2
				setSpeed: global199
				init:
				setMotion: shopperPath2
			)
			(shopper3
				view: (if (proc0_6 30) 7 else 388)
				setCycle: Walk
				setStep: 5 2
				setSpeed: global199
				init:
				setMotion: shopperPath3
			)
		)
		(if
			(and
				(!= gWest 396)
				(not (proc999_5 global11 405 406 410 411))
			)
			(= temp0
				(switch (gEgo view?)
					(0 4)
					(402 14)
					(373 374)
				)
			)
			(gEgo setCycle: StopWalk temp0)
		)
		(if (proc999_5 global11 370 375 380 385 390 395 400)
			(belts init:)
			(restOfMall init:)
			(gEgo setScript: nearScript)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (proc0_6 24)
			(++ global110)
			(if (and (proc0_6 25) (> global110 2)) (proc0_8 25))
		)
		(= keep
			(proc999_5
				newRoomNumber
				370
				371
				375
				376
				380
				381
				385
				386
				387
				390
				391
				395
				396
				397
				398
				399
				400
				405
				406
				410
				411
				290
			)
		)
		(= initialized 0)
		(super newRoom: newRoomNumber &rest)
	)
	
	(method (offScreen)
		(return
			(if
				(or
					(< (gEgo nsRight?) 0)
					(> (gEgo nsLeft?) 319)
					(< (gEgo nsBottom?) 0)
				)
			else
				(> ((gEgo _head?) nsTop?) 189)
			)
		)
	)
)

(instance enS of Script
	(properties)
	
	(method (init)
		(gEgo illegalBits: 0)
		(super init: &rest)
	)
	
	(method (doit)
		(super doit: &rest)
		(if
			(or
				(not (gEgo onControl:))
				(<= (gEgo x?) 0)
				(>= (gEgo x?) 319)
				(<= (gEgo y?) (global2 horizon?))
				(>= (gEgo y?) 189)
			)
			0
		else
			(gEgo illegalBits: -32768)
			(self dispose:)
			(proc0_3)
		)
		(register who: gEgo doit:)
	)
)

(instance exS of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(gEgo setMotion: 0)
		(if (mall offScreen:)
			(global2 newRoom: register)
		else
			((mall enterBelt?) who: gEgo doit:)
		)
	)
)

(instance moveNear of Motion
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
)

(instance nearScript of Script
	(properties)
	
	(method (handleEvent pEvent)
		(cond 
			((pEvent claimed?) (return))
			(
				(or
					(!= (gIconBar curIcon?) (gIconBar at: 0))
					(not (global80 controls?))
					(!= (pEvent type?) evVERB)
					(pEvent modifiers?)
				)
				(super handleEvent: pEvent)
			)
			(else
				(client
					setMotion: (if global67 PolyPath else moveNear) (pEvent x?) (pEvent y?)
				)
				(global80 prevDir: 0)
				(pEvent claimed: 1)
			)
		)
	)
)

(instance eSwimCode of Inertia
	(properties
		maxInertia 5
	)
)

(instance spSwimCode of Inertia
	(properties
		maxInertia 4
	)
)

(instance shopper2 of Sq4Actor
	(properties
		z 1000
		view 367
		signal $2000
		illegalBits $0000
	)
	
	(method (doit)
		(super doit:)
		(localproc_0640 self)
		(cond 
			(script)
			((proc0_5 self 1)
				(if (not cycler)
					(self
						view: (if (proc0_6 30) 7 else 384)
						setCycle: Walk
						setCel: -1
						setStep: 4 2
					)
					(InitBresen mover)
				)
			)
			(else
				(if cycler
					(self
						view: (if (proc0_6 30) 13 else 367)
						setCycle: 0
						setCel: 0
						setStep: 2 2
					)
					(InitBresen mover)
				)
				(= loop
					[theLoop (/
						(proc999_1 (+ heading (/ 180 (NumLoops self))) 360)
						(/ 360 (NumLoops self))
					)]
				)
			)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (proc0_6 30)
					(gSq4GlobalNarrator modNum: 376 say: 17)
				else
					(gSq4GlobalNarrator modNum: 700 say: 6)
				)
			)
			(4
				(gSq4GlobalNarrator modNum: 700 say: 2)
			)
			(2
				(gSq4GlobalNarrator modNum: 700 say: 7)
			)
			(6
				(gSq4GlobalNarrator modNum: 700 say: 8)
			)
			(7
				(gSq4GlobalNarrator modNum: 700 say: 1)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shopper3 of Sq4Actor
	(properties
		z 1000
		view 368
		signal $2000
		illegalBits $0000
	)
	
	(method (doit)
		(super doit:)
		(localproc_0640 self)
		(cond 
			(script)
			((proc0_5 self 1)
				(if (not cycler)
					(self
						view: (if (proc0_6 30) 7 else 388)
						setCycle: Walk
						setCel: -1
						setStep: 5 2
					)
					(InitBresen mover)
				)
			)
			(else
				(if cycler
					(self
						view: (if (proc0_6 30) 13 else 368)
						setCycle: 0
						setCel: 0
						setStep: 2 2
					)
					(InitBresen mover)
				)
				(= loop
					[theLoop (/
						(proc999_1 (+ heading (/ 180 (NumLoops self))) 360)
						(/ 360 (NumLoops self))
					)]
				)
			)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (proc0_6 30)
					(gSq4GlobalNarrator modNum: 376 say: 17)
				else
					(gSq4GlobalNarrator modNum: 700 say: 9)
				)
			)
			(4
				(gSq4GlobalNarrator modNum: 700 say: 2)
			)
			(2
				(switch (Random 1 20)
					(19
						(wierdNar say: 1)
						(proc921_0
							{"Mr. Carlos sent me. I want to know about the sheep."}
						)
					)
					(else 
						(gSq4GlobalNarrator modNum: 700 say: 10)
					)
				)
			)
			(6
				(gSq4GlobalNarrator modNum: 700 say: 11)
			)
			(7
				(gSq4GlobalNarrator modNum: 700 say: 1)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sp1 of Sq4Actor
	(properties
		view 7
		signal $6000
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 376 say: 17)
			)
			(2
				(gSq4GlobalNarrator modNum: 376 say: 1)
			)
			(6
				(gSq4GlobalNarrator modNum: 376 say: 2)
			)
			(7
				(gSq4GlobalNarrator modNum: 700 say: 3)
			)
			(4
				(gSq4GlobalNarrator modNum: 376 say: 2)
			)
			(8
				(gSq4GlobalNarrator modNum: 376 say: 5)
			)
			(9
				(gSq4GlobalNarrator modNum: 376 say: 6)
			)
			(11
				(gSq4GlobalNarrator modNum: 700 say: 4)
			)
			(12
				(gSq4GlobalNarrator modNum: 700 say: 12)
			)
			(14
				(gSq4GlobalNarrator modNum: 376 say: 7)
			)
			(17
				(gSq4GlobalNarrator modNum: 700 say: 5)
			)
			(18
				(gSq4GlobalNarrator modNum: 376 say: 5)
			)
			((proc999_5 theVerb 20 21 22 23)
				(gSq4GlobalNarrator modNum: 376 say: 4)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance sp2 of Sq4Actor
	(properties
		view 7
		signal $6000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 376 say: 17)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shopperPath2 of RegionPath
	(properties
		value 17
		theRegion 700
	)
	
	(method (doit)
		(super doit: &rest)
		(if
			(and
				(== currentRoom global11)
				(!= (client script?) spOnBelt)
				(not (spOnBelt client?))
				(proc0_6 30)
			)
			(client setScript: spOnBelt)
		)
	)
	
	(method (at param1)
		(return [local0 param1])
	)
)

(instance shopperPath3 of RegionPath
	(properties
		value 17
		theRegion 700
	)
	
	(method (doit)
		(super doit: &rest)
		(if
			(and
				(== currentRoom global11)
				(!= (client script?) spOnBelt)
				(not (spOnBelt client?))
				(proc0_6 30)
			)
			(client setScript: spOnBelt)
		)
	)
	
	(method (at param1)
		(return [local43 param1])
	)
)

(instance egoBumpScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(proc0_2)
				(= temp1
					(GetAngle
						(register x?)
						(register y?)
						(gEgo x?)
						(gEgo y?)
					)
				)
				(= temp1 (proc999_1 (+ temp1 45) 360))
				(gEgo
					view: 370
					cel: 0
					setMotion: 0
					x: temp0
					setCycle: End self
				)
			)
			(1
				(global80 canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance egoStandScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo view: 0 setCycle: Walk)
				(self dispose:)
				(proc0_3)
			)
		)
	)
)

(instance spOnBelt of Script
	(properties)
	
	(method (init)
		(super init: &rest)
		(proc0_7 3)
	)
	
	(method (doit)
		(cond 
			((global2 script?) (client setCel: 0) (proc0_13 client gEgo))
			(
				(and
					(== state 0)
					(< 40 (client y?))
					(< (client y?) 170)
					(< 20 (client x?))
					(< (client x?) 300)
					(not (global2 script?))
				)
				(self cue:)
			)
			((!= global11 ((client mover?) currentRoom?)) (proc0_3) (self dispose:))
		)
		(super doit: &rest)
	)
	
	(method (changeState newState &tmp [temp0 4])
		(switch (= state newState)
			(0 0)
			(1
				(proc0_2)
				(proc0_8 30)
				(proc0_13 client gEgo self)
			)
			(2
				(client setCel: 0 view: 13 setCycle: End)
				(gEgo view: 26 cel: 0 setCycle: End self)
			)
			(3 (proc0_10 8 17))
		)
	)
)

(instance belts of Sq4Feature
	(properties
		sightAngle 180
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 700 say: 13)
			)
			(4
				(gSq4GlobalNarrator modNum: 700 say: 14)
			)
			(6
				(gSq4GlobalNarrator modNum: 700 say: 15)
			)
			(7
				(gSq4GlobalNarrator modNum: 700 say: 16)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (onMe param1)
		(return (& (OnControl 4 (param1 x?) (param1 y?)) $0006))
	)
)

(instance restOfMall of Sq4Feature
	(properties
		sightAngle 180
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 700 say: 17)
			)
			(6
				(gSq4GlobalNarrator modNum: 380 say: 11)
			)
			(7
				(gSq4GlobalNarrator modNum: 380 say: 12)
			)
			(else  (super doVerb: theVerb))
		)
	)
	
	(method (onMe)
		(return 1)
	)
)

(instance wierdNar of Sq4Narrator
	(properties
		modNum 700
		talkerNum 13
	)
)

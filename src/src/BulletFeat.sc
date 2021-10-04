;;; Sierra Script 1.0 - (do not remove this comment)
(script# 708)
(include sci.sh)
(use Main)
(use Sq4Feature)
(use Obj)

(public
	hintBookScript 0
)

(local
	local0 =  -1
	local1
	[local2 4]
	[local6 12] = [99 1 10 19 27 35 42 50 57 62 64 69]
	local18
	local19 =  1
	[local20 14]
	local34 =  -1
	local35
	[local36 275]
)
(procedure (localproc_028e param1 param2 &tmp temp0 temp1)
	(while
		(and
			(= temp0 (FirstNode (param1 elements?)))
			(IsObject
				(= temp1
					(NodeValue (= temp0 (FirstNode (param1 elements?))))
				)
			)
		)
		(param2 add: temp1)
		(param1 delete: temp1)
	)
)

(procedure (localproc_02c3 param1 param2 &tmp temp0)
	(if
		(proc999_5
			param1
			1
			6
			12
			18
			24
			29
			34
			39
			41
			46
			50
			55
			57
			63
			65
			67
		)
		(localproc_06c8 param1 param2 local18)
		(= temp0 0)
	else
		(Message msgGET 708 2 0 param1 1 @local36)
		(TextSize @local2 @local36 30 140)
		(localproc_0627
			(- (+ local18 [local2 0]) 3)
			(- (+ param2 [local2 1]) 3)
			(+ local18 [local2 2])
			(+ param2 [local2 3])
		)
		(Display {} 105 30 100 (- param2 12) (- local18 1))
		(= [local20 (++ local34)]
			((bulletFeat new:)
				x: (- param2 9)
				y: (+ local18 2)
				nsLeft: (- param2 13)
				nsTop: (- local18 1)
				nsRight: (- param2 5)
				nsBottom: (+ local18 5)
				who: param1
				whoX: param2
				whoY: local18
				yourself:
			)
		)
		([local20 local34] init:)
		(if
			(&
				[global163 (/ param1 16)]
				(>> $8000 (mod param1 16))
			)
			(localproc_06c8 param1 param2 local18)
		)
		(= temp0 2)
	)
	(TextSize @local2 @local36 30 140)
	(= local18 (+ local18 [local2 2] 3 temp0))
)

(procedure (localproc_0416 &tmp temp0 temp1 [temp2 22])
	(= temp0 0)
	(while (< temp0 14)
		(if (IsObject [local20 temp0])
			([local20 temp0] dispose:)
		)
		(= [local20 temp0] 0)
		(++ temp0)
	)
	(= local34 -1)
	(Graph grFILL_BOX 0 0 189 320 3 gBack 15)
	(Graph grUPDATE_BOX 0 0 189 320 1)
	(Graph grDRAW_LINE 0 159 189 159 gColor -1 -1)
	(Graph grUPDATE_BOX 0 159 190 160 1)
	(Display 708 0 105 30 100 50 3)
	(Display 708 0 105 30 100 200 3)
	(Display 708 1 105 30 100 5 3)
	(Display 708 1 105 30 100 290 3)
	(if (> local19 9)
		(Format @temp2 708 2 local19)
	else
		(Format @temp2 708 3 local19)
	)
	(Display @temp2 105 30 103 gBack 100 25 3)
	(if (> local19 8)
		(Format @temp2 708 2 (+ local19 1))
	else
		(Format @temp2 708 3 (+ local19 1))
	)
	(Display @temp2 105 30 103 gBack 100 310 3)
	(localproc_0690
		exitBut
		(+ (exitBut nsLeft?) 1)
		(+ (exitBut nsTop?) 2)
		{exit}
	)
	(localproc_0690
		nextBut
		(+ (nextBut nsLeft?) 1)
		(+ (nextBut nsTop?) 2)
		{next}
	)
	(localproc_0690
		prevBut
		(+ (prevBut nsLeft?) 1)
		(+ (prevBut nsTop?) 2)
		{prev}
	)
	(= local18 14)
	(= temp0 [local6 local19])
	(while (< temp0 [local6 (+ local19 1)])
		(localproc_02c3 temp0 14)
		(++ temp0)
	)
	(++ local19)
	(= local18 14)
	(= temp0 [local6 local19])
	(while (< temp0 [local6 (+ local19 1)])
		(localproc_02c3 temp0 174)
		(++ temp0)
	)
)

(procedure (localproc_0627 param1 param2 param3 param4)
	(Graph
		grDRAW_LINE
		param1
		param2
		param1
		param4
		gColor
		-1
		-1
	)
	(Graph
		grDRAW_LINE
		param1
		param4
		param3
		param4
		gColor
		-1
		-1
	)
	(Graph
		grDRAW_LINE
		param3
		param2
		param3
		param4
		gColor
		-1
		-1
	)
	(Graph
		grDRAW_LINE
		param1
		param2
		param3
		param2
		gColor
		-1
		-1
	)
	(Graph
		grUPDATE_BOX
		param1
		param2
		(+ param3 1)
		(+ param4 1)
		1
	)
)

(procedure (localproc_0690 param1 param2 param3 param4)
	(localproc_0627
		(param1 nsTop?)
		(param1 nsLeft?)
		(param1 nsBottom?)
		(param1 nsRight?)
	)
	(Display param4 105 30 100 param2 param3)
)

(procedure (localproc_06c8 param1 param2 param3)
	(if (== param1 33)
		(StrCpy @local36 {  })
	else
		(Message msgGET 708 2 0 param1 1 @local36)
	)
	(Display @local36 105 30 106 140 100 param2 param3)
)

(instance hintBookScript of Script
	(properties)
	
	(method (doit)
		(if (GameIsRestarting)
			(= start 2)
			(-- local19)
			(self init:)
		)
		(super doit:)
	)
	
	(method (dispose &tmp temp0)
		(global32 release:)
		(global2 drawPic: register 10)
		(if (!= (= global36 local0) -1)
			(DrawPic global36 dpOPEN_FADEPALETTE dpNO_CLEAR)
		)
		(= temp0 0)
		(while (< temp0 14)
			(if (IsObject [local20 temp0])
				([local20 temp0] dispose:)
			)
			(= [local20 temp0] 0)
			(++ temp0)
		)
		(if (== local35 999)
			(localproc_028e aList global10)
			(localproc_028e fList global32)
			(localproc_028e cList global5)
			(global10 doit:)
		)
		(aList
			eachElementDo: #dispose
			eachElementDo: #delete
			release:
			dispose:
		)
		(fList eachElementDo: #perform fdc release: dispose:)
		(cList
			eachElementDo: #dispose
			eachElementDo: #delete
			dispose:
		)
		(global80 canControl: local1)
		(if (== global11 391) (gIconBar enable: 0))
		(super dispose:)
		(DisposeScript 708)
	)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= local19 1)
				(= local18 0)
				(gEgo setMotion: 0)
				(= local1 (global80 controls?))
				(global80 canControl: 0)
				(= cycles 2)
			)
			(1
				(if (== global11 391) (gIconBar disable: 0))
				(= register (global2 picture?))
				(= local0 global36)
				(localproc_028e global10 aList)
				(localproc_028e global32 fList)
				(localproc_028e global5 cList)
				(global2 drawPic: 699 10)
				(= cycles 2)
			)
			(2
				(= temp1 (GetPort))
				(SetPort temp1)
				(exitBut init:)
				(nextBut init:)
				(prevBut init:)
				(localproc_0416)
				(global1 setCursor: ((gInv curIcon?) cursor?) 1)
			)
			(3
				(= local35 999)
				(self dispose:)
			)
		)
	)
)

(instance fdc of Code
	(properties)
	
	(method (doit param1)
		(if (param1 respondsTo: #delete)
			(param1
				signal: (& (param1 signal?) $ffdf)
				dispose:
				delete:
			)
		else
			(param1 dispose:)
		)
	)
)

(instance aList of Collect
	(properties)
)

(instance fList of Collect
	(properties)
)

(instance cList of Collect
	(properties)
)

(instance exitBut of Sq4Feature
	(properties
		x 14
		y 183
		nsTop 178
		nsLeft 4
		nsBottom 188
		nsRight 24
		sightAngle 180
		lookStr 1
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= temp0 0)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 708 say: 1)
			)
			(4 (= temp0 1))
			(else  (= temp0 1))
		)
		(if temp0 (hintBookScript cue:))
	)
)

(instance prevBut of Sq4Feature
	(properties
		x 41
		y 183
		nsTop 178
		nsLeft 29
		nsBottom 188
		nsRight 49
		sightAngle 180
		lookStr 2
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= temp0 0)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 708 say: 2)
			)
			(4 (= temp0 1))
			(else  (= temp0 1))
		)
		(if (and temp0 (> local19 3))
			(= local19 (- local19 3))
			(localproc_0416)
		)
	)
)

(instance nextBut of Sq4Feature
	(properties
		x 54
		y 183
		nsTop 178
		nsLeft 54
		nsBottom 188
		nsRight 74
		sightAngle 180
		lookStr 3
	)
	
	(method (doVerb theVerb &tmp temp0)
		(= temp0 0)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 708 say: 3)
			)
			(4 (= temp0 1))
			(else  (= temp0 1))
		)
		(if (and temp0 (< local19 10))
			(++ local19)
			(localproc_0416)
		)
	)
)

(class BulletFeat of Sq4Feature
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 0
		modNum -1
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		sightAngle 26505
		actions 0
		onMeCheck $6789
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 0
		lookStr 0
		who 0
		whoX 0
		whoY 0
	)
)

(instance bulletFeat of BulletFeat
	(properties)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 708 say: 4)
			)
			(4
				(gSq4GlobalNarrator modNum: 708 say: 5)
			)
			(17
				(cond 
					((> global168 100) (gSq4GlobalNarrator modNum: 708 say: 6))
					(
					(& [global163 (/ who 16)] (>> $8000 (mod who 16))) 0)
					(else
						(= [global163 (/ who 16)]
							(| [global163 (/ who 16)] (>> $8000 (mod who 16)))
						)
						(localproc_06c8 who whoX whoY)
						(if (== who 33)
							(Animate (global5 elements?) 0)
							(gSq4GlobalNarrator modNum: 708 say: 7)
						)
						(++ global168)
					)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

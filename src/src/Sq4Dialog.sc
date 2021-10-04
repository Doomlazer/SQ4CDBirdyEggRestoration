;;; Sierra Script 1.0 - (do not remove this comment)
(script# 816)
(include sci.sh)
(use Main)
(use Class_255_0)
(use DIcon)
(use Obj)

(public
	proc816_0 0
	proc816_1 1
	proc816_2 2
	proc816_3 3
)

(procedure (proc816_0 param1 param2 param3 &tmp [temp0 4])
	(if
		(proc816_1
			(if (>= argc 3) param3 else {})
			38
			param1
			param2
			&rest
		)
		(StrLen param1)
	)
)

(procedure (proc816_1 param1 &tmp newSq4Dialog newDText newDIcon newDEdit temp4 temp5 temp6 temp7 temp8 theNewSq4Dialog temp10 temp11 [newDButton 6] temp18 temp19 temp20 [temp21 1002] temp1023 theNewDText temp1025 temp1026 temp1027 temp1028 temp1029 temp1030 [temp1031 100])
	(= temp1026 0)
	(= temp1027 0)
	(= temp6 (= temp7 -1))
	(= temp1030
		(= theNewSq4Dialog
			(= temp8
				(= temp18
					(= newDIcon
						(= newDEdit
							(= temp1023 (= temp1028 (= temp19 (= temp1025 0))))
						)
					)
				)
			)
		)
	)
	((= newSq4Dialog (Sq4Dialog new:))
		window: gSq4Win
		name: {PrintD}
	)
	(cond 
		((u< [param1 0] 1000) (GetFarText [param1 0] [param1 1] @temp21) (= temp5 2))
		([param1 0] (StrCpy @temp21 [param1 0]) (= temp5 1))
		(else (= temp21 0) (= temp5 0))
	)
	((= newDText (DText new:)) text: @temp21 font: global22)
	((= theNewDText newDText) moveTo: 4 4 setSize:)
	(newSq4Dialog add: theNewDText setSize:)
	(if temp1025
		(temp1025
			setSize:
			moveTo: (theNewDText nsLeft?) (+ 4 (theNewDText nsBottom?))
		)
		(newSq4Dialog add: temp1025 setSize:)
	)
	(= temp5 temp5)
	(while (< temp5 argc)
		(switch [param1 temp5]
			(27
				(++ temp5)
				(if (and newDText (not temp1025))
					(newDText mode: [param1 temp5])
				)
			)
			(30
				(++ temp5)
				(if newDText
					(newDText font: [param1 temp5] setSize: temp8)
				)
			)
			(67
				(= temp1026 1)
				(= temp8 [param1 (++ temp5)])
				(theNewDText setSize: temp8)
				(if temp1025
					(temp1025
						setSize: temp8
						moveTo: (theNewDText nsLeft?) (+ 4 (theNewDText nsBottom?))
					)
				)
			)
			(22
				(newSq4Dialog time: [param1 (++ temp5)])
			)
			(77
				(newSq4Dialog text: [param1 (++ temp5)])
			)
			(64
				(= temp6 [param1 (++ temp5)])
				(= temp7 [param1 (++ temp5)])
			)
			(80
				(Animate (global5 elements?) 0)
			)
			(38
				((= newDEdit (DEdit new:)) text: [param1 (++ temp5)])
				(newDEdit max: [param1 (++ temp5)] setSize:)
			)
			(78
				((= [newDButton temp19] (DButton new:))
					text: [param1 (++ temp5)]
					value: [param1 (++ temp5)]
					setSize:
				)
				(= temp18 (+ temp18 ([newDButton temp19] nsRight?) 4))
				(++ temp19)
			)
			(79
				(= temp1027 1)
				(if (IsObject [param1 (+ temp5 1)])
					((= newDIcon ([param1 (+ temp5 1)] new:)) setSize:)
					(= temp5 (+ temp5 1))
				else
					(= newDIcon (DIcon new:))
					(newDIcon
						view: [param1 (+ temp5 1)]
						loop: [param1 (+ temp5 2)]
						cel: [param1 (+ temp5 3)]
						setSize:
					)
					(= temp5 (+ temp5 3))
				)
			)
			(111
				(if
					(and
						(< (+ temp5 1) argc)
						(IsObject [param1 (+ temp5 1)])
					)
					(newSq4Dialog caller: [param1 (+ temp5 1)])
					(++ temp5)
				)
				(if gTheNewSq4Dialog (gTheNewSq4Dialog dispose:))
				(= theNewSq4Dialog newSq4Dialog)
			)
			(32
				(newSq4Dialog window: [param1 (++ temp5)])
			)
			(124 (= temp1030 1))
		)
		(++ temp5)
	)
	(if temp1030 (= theNewSq4Dialog 0))
	(if
		(and
			(not (if temp1026 else temp1027))
			(>
				(- (newSq4Dialog nsBottom?) (newSq4Dialog nsTop?))
				100
			)
		)
		(theNewDText setSize: 300)
		(if temp1025
			(temp1025
				setSize: 300
				moveTo: (theNewDText nsLeft?) (+ 4 (theNewDText nsBottom?))
			)
		)
	)
	(if newDIcon
		(newDIcon moveTo: 4 4)
		(if
		(or (== theNewDText temp1023) (== temp1025 temp1023))
			(= temp1028 8)
		)
		(if (& (newDIcon state?) $0010)
			(theNewDText
				moveTo: (+ 4 temp1028) (+ (newDIcon nsBottom?) (theNewDText nsTop?))
				setSize:
			)
		else
			(theNewDText
				moveTo: (+ 4 (newDIcon nsRight?) temp1028) (theNewDText nsTop?)
				setSize:
			)
		)
		(if temp1025
			(temp1025
				moveTo: (theNewDText nsLeft?) (+ 4 (theNewDText nsBottom?))
			)
		)
		(newSq4Dialog add: newDIcon)
	)
	(newSq4Dialog setSize:)
	(if newDEdit
		(newDEdit
			moveTo:
				((if temp1025 else theNewDText) nsLeft?)
				(+ 4 ((if temp1025 else theNewDText) nsBottom?))
		)
		(newSq4Dialog add: newDEdit setSize:)
	)
	(= temp20
		(if (> temp18 (newSq4Dialog nsRight?))
			4
		else
			(- (newSq4Dialog nsRight?) temp18)
		)
	)
	(= temp5 0)
	(while (< temp5 temp19)
		([newDButton temp5]
			moveTo: temp20 (newSq4Dialog nsBottom?)
		)
		(newSq4Dialog add: [newDButton temp5])
		(= temp20 (+ 4 ([newDButton temp5] nsRight?)))
		(++ temp5)
	)
	(newSq4Dialog setSize: center:)
	(if
		(or
			(and newDIcon (& (newDIcon state?) $0010))
			(and newDIcon (not (StrLen @temp21)))
		)
		(newDIcon
			moveTo:
				(/
					(-
						(- (newSq4Dialog nsRight?) (newSq4Dialog nsLeft?))
						(- (newDIcon nsRight?) (newDIcon nsLeft?))
					)
					2
				)
				4
		)
	)
	(newSq4Dialog
		moveTo:
			(if (== -1 temp6) (newSq4Dialog nsLeft?) else temp6)
			(if (== -1 temp7) (newSq4Dialog nsTop?) else temp7)
	)
	(= temp11 (GetPort))
	(newSq4Dialog
		open:
			(if (newSq4Dialog text?) 4 else 0)
			(if theNewSq4Dialog 15 else -1)
	)
	(if theNewSq4Dialog
		(= global41 (GetPort))
		(SetPort temp11)
		(return (= gTheNewSq4Dialog theNewSq4Dialog))
	else
		(global8 pause: 1)
	)
	(if
		(and
			(= temp10 (newSq4Dialog firstTrue: #checkState 1))
			(not (newSq4Dialog firstTrue: #checkState 2))
		)
		(temp10 state: (| (temp10 state?) $0002))
	)
	(if (== (= temp4 (newSq4Dialog doit: temp10)) -1)
		(= temp4 0)
	)
	(= temp5 0)
	(while (< temp5 temp19)
		(breakif (== temp4 [newDButton temp5]))
		(++ temp5)
	)
	(if (not (newSq4Dialog theItem?)) (= temp4 1))
	(newSq4Dialog dispose:)
	(global8 pause: 0)
	(return temp4)
)

(procedure (proc816_2 &tmp [temp0 500])
	(Format @temp0 &rest)
	(proc816_1 @temp0)
)

(procedure (proc816_3 param1 &tmp temp0 newSq4Dialog newDText newDTextNsRight temp4 newDTextNsBottom temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14)
	(= temp10 (= temp11 -1))
	(= newDTextNsRight
		(= temp4 (= newDTextNsBottom (= temp6 0)))
	)
	(= temp12 0)
	(= temp14 0)
	((= newSq4Dialog (Sq4Dialog new:)) window: gSq4Win)
	(= temp0 0)
	(while (< temp0 argc)
		(switch (= temp8 [param1 temp0])
			(109
				(= newDTextNsBottom (newDText nsBottom?))
				(= newDTextNsRight 0)
			)
			(64
				(= temp10 [param1 (++ temp0)])
				(= temp11 [param1 (++ temp0)])
			)
			(77
				(= temp12 [param1 (++ temp0)])
			)
			(124
				(= temp14 [param1 (++ temp0)])
			)
			(else 
				(++ temp0)
				(switch temp8
					(23
						((= newDText (DText new:)) text: [param1 temp0])
					)
					(78
						((= newDText (DButton new:))
							text: [param1 temp0]
							value: [param1 (++ temp0)]
						)
					)
					(79
						((= newDText (DIcon new:))
							view: [param1 temp0]
							loop: [param1 (++ temp0)]
							cel: [param1 (++ temp0)]
						)
					)
					(38
						((= newDText (DEdit new:))
							text: [param1 temp0]
							max: [param1 (++ temp0)]
						)
					)
					(else 
						((= newDText (DText new:)) text: [param1 (-- temp0)])
					)
				)
				(if
				(and (< (+ temp0 1) argc) (== [param1 (+ temp0 1)] 1))
					(++ temp0)
					(= newDTextNsRight
						(+ newDTextNsRight [param1 (++ temp0)])
					)
				)
				(if
				(and (< (+ temp0 1) argc) (== [param1 (+ temp0 1)] 0))
					(++ temp0)
					(= newDTextNsBottom
						(+ newDTextNsBottom [param1 (++ temp0)])
					)
				)
				(newDText
					setSize:
					moveTo: (+ newDTextNsRight 4) (+ newDTextNsBottom 4)
				)
				(newSq4Dialog add: newDText)
				(= newDTextNsRight (newDText nsRight?))
			)
		)
		(++ temp0)
	)
	(newSq4Dialog setSize: center:)
	(newSq4Dialog
		moveTo:
			(if (== -1 temp10) (newSq4Dialog nsLeft?) else temp10)
			(if (== -1 temp11) (newSq4Dialog nsTop?) else temp11)
	)
	(if temp12 (newSq4Dialog text: temp12))
	(= temp13 (newSq4Dialog at: temp14))
	(if (not (& $0001 (temp13 state?))) (= temp13 0))
	(= temp7
		(newSq4Dialog open: (if temp12 4 else 0) -1 doit: temp13)
	)
	(if (IsObject temp7)
		(if (temp7 isKindOf: DButton)
			(= temp7 (temp7 value?))
		else
			(= temp7 1)
		)
	)
	(newSq4Dialog dispose:)
	(return temp7)
)

(class Sq4Dialog of List
	(properties
		elements 0
		size 0
		text 0
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		busy 0
		caller 0
		seconds 0
		lastSeconds 0
	)
	
	(method (doit param1 &tmp temp0 temp1 temp2 theGEatTheMice temp4)
		(= temp0 0)
		(= busy 1)
		(self eachElementDo: #init)
		(if theItem (theItem select: 0))
		(= theItem
			(if (and argc param1)
				param1
			else
				(self firstTrue: #checkState 1)
			)
		)
		(if theItem (theItem select: 1))
		(if (not theItem)
			(= theGEatTheMice gEatTheMice)
			(= temp4 (GetTime))
		else
			(= theGEatTheMice 0)
		)
		(= temp2 0)
		(while (not temp2)
			(self eachElementDo: #cycle)
			(= temp1 ((Event new:) localize:))
			(if theGEatTheMice
				(-- theGEatTheMice)
				(if (== (temp1 type?) 1) (temp1 type: 0))
				(while (== temp4 (GetTime))
				)
				(= temp4 (GetTime))
			)
			(= temp2 (self handleEvent: temp1))
			(temp1 dispose:)
			(self check:)
			(breakif (or (== temp2 -1) (not busy)))
			(Wait 1)
		)
		(= busy 0)
		(return temp2)
	)
	
	(method (dispose &tmp theCaller)
		(self eachElementDo: #dispose 1 release:)
		(if (== self gTheNewSq4Dialog)
			(SetPort global41)
			(= gTheNewSq4Dialog 0)
			(= global41 0)
		)
		(if window (window dispose:))
		(= theItem (= window 0))
		(= theCaller caller)
		(super dispose:)
		(if theCaller (theCaller cue:))
	)
	
	(method (open param1 param2)
		(if (and (PicNotValid) global5)
			(Animate (global5 elements?) 0)
		)
		(= window (window new:))
		(window
			top: nsTop
			left: nsLeft
			bottom: nsBottom
			right: nsRight
			title: text
			type: param1
			priority: param2
			open:
		)
		(= seconds time)
		(self draw:)
	)
	
	(method (draw)
		(self eachElementDo: #draw)
	)
	
	(method (cue)
		(if (not busy) (self dispose:) else (= busy 0))
	)
	
	(method (advance &tmp temp0 sq4DialogFirst)
		(if theItem
			(theItem select: 0)
			(= sq4DialogFirst (self contains: theItem))
			(repeat
				(if
				(not (= sq4DialogFirst (self next: sq4DialogFirst)))
					(= sq4DialogFirst (self first:))
				)
				(= theItem (NodeValue sq4DialogFirst))
				(breakif (& (theItem state?) $0001))
			)
			(theItem select: 1)
			(global1
				setCursor:
					gCursorNumber
					1
					(+
						(theItem nsLeft?)
						(/ (- (theItem nsRight?) (theItem nsLeft?)) 2)
					)
					(- (theItem nsBottom?) 3)
			)
		)
	)
	
	(method (retreat &tmp temp0 sq4DialogLast)
		(if theItem
			(theItem select: 0)
			(= sq4DialogLast (self contains: theItem))
			(repeat
				(if
				(not (= sq4DialogLast (self prev: sq4DialogLast)))
					(= sq4DialogLast (self last:))
				)
				(= theItem (NodeValue sq4DialogLast))
				(breakif (& (theItem state?) $0001))
			)
			(theItem select: 1)
			(global1
				setCursor:
					gCursorNumber
					1
					(+
						(theItem nsLeft?)
						(/ (- (theItem nsRight?) (theItem nsLeft?)) 2)
					)
					(- (theItem nsBottom?) 3)
			)
		)
	)
	
	(method (move param1 param2)
		(= nsRight (+ nsRight param1))
		(= nsLeft (+ nsLeft param1))
		(= nsTop (+ nsTop param2))
		(= nsBottom (+ nsBottom param2))
	)
	
	(method (moveTo param1 param2)
		(self move: (- param1 nsLeft) (- param2 nsTop))
	)
	
	(method (center)
		(self
			moveTo:
				(+
					(window brLeft?)
					(/
						(-
							(- (window brRight?) (window brLeft?))
							(- nsRight nsLeft)
						)
						2
					)
				)
				(+
					(window brTop?)
					(/
						(-
							(- (window brBottom?) (window brTop?))
							(- nsBottom nsTop)
						)
						2
					)
				)
		)
	)
	
	(method (setSize &tmp sq4DialogFirst temp1 [theNsTop 4])
		(if text
			(TextSize @[theNsTop 0] text 0 -1 0)
			(= nsTop [theNsTop 0])
			(= nsLeft [theNsTop 1])
			(= nsBottom [theNsTop 2])
			(= nsRight [theNsTop 3])
		else
			(= nsRight (= nsBottom (= nsLeft (= nsTop 0))))
		)
		(= sq4DialogFirst (self first:))
		(while sq4DialogFirst
			(if
				(<
					((= temp1 (NodeValue sq4DialogFirst)) nsLeft?)
					nsLeft
				)
				(= nsLeft (temp1 nsLeft?))
			)
			(if (< (temp1 nsTop?) nsTop) (= nsTop (temp1 nsTop?)))
			(if (> (temp1 nsRight?) nsRight)
				(= nsRight (temp1 nsRight?))
			)
			(if (> (temp1 nsBottom?) nsBottom)
				(= nsBottom (temp1 nsBottom?))
			)
			(= sq4DialogFirst (self next: sq4DialogFirst))
		)
		(= nsRight (+ nsRight 4))
		(= nsBottom (+ nsBottom 4))
		(self moveTo: 0 0)
	)
	
	(method (handleEvent pEvent &tmp theTheItem)
		(if (& (pEvent type?) evJOYSTICK)
			(pEvent type: 4)
			(switch (pEvent message?)
				(JOY_DOWN
					(pEvent message: 20480)
				)
				(JOY_UP (pEvent message: 18432))
				(JOY_LEFT
					(pEvent message: 19200)
				)
				(JOY_RIGHT
					(pEvent message: 19712)
				)
				(else  (pEvent type: 64))
			)
		)
		(if
			(or
				(pEvent claimed?)
				(== (pEvent type?) evNULL)
				(and
					(!= evMOUSEBUTTON (pEvent type?))
					(!= evKEYBOARD (pEvent type?))
					(!= evJOYSTICK (pEvent type?))
					(!= evJOYDOWN (pEvent type?))
				)
			)
			(EditControl theItem pEvent)
			(return 0)
		)
		(if
		(= theTheItem (self firstTrue: #handleEvent pEvent))
			(EditControl theItem 0)
			(if (not (theTheItem checkState: 2))
				(if theItem (theItem select: 0))
				((= theItem theTheItem) select: 1)
				(theTheItem doit:)
				(= theTheItem 0)
			)
		else
			(= theTheItem 0)
			(cond 
				(
					(and
						(or
							(== (pEvent type?) evJOYDOWN)
							(and
								(== evKEYBOARD (pEvent type?))
								(== KEY_RETURN (pEvent message?))
							)
						)
						theItem
						(theItem checkState: 1)
					)
					(= theTheItem theItem)
					(EditControl theItem 0)
					(pEvent claimed: 1)
				)
				(
					(or
						(and
							(not (self firstTrue: #checkState 1))
							(or
								(and
									(== evKEYBOARD (pEvent type?))
									(== KEY_RETURN (pEvent message?))
								)
								(== evMOUSEBUTTON (pEvent type?))
								(== evJOYDOWN (pEvent type?))
							)
						)
						(and
							(== evKEYBOARD (pEvent type?))
							(== KEY_ESCAPE (pEvent message?))
						)
					)
					(pEvent claimed: 1)
					(= theTheItem -1)
				)
				(
					(and
						(IsObject theItem)
						(theItem isType: 3)
						(== (pEvent type?) evKEYBOARD)
						(== (pEvent message?) KEY_RIGHT)
					)
					(if
					(>= (theItem cursor?) (StrLen (theItem text?)))
						(self advance:)
					else
						(EditControl theItem pEvent)
					)
				)
				(
					(and
						(IsObject theItem)
						(theItem isType: 3)
						(== (pEvent type?) evKEYBOARD)
						(== (pEvent message?) KEY_NUMPAD4)
					)
					(if (<= (theItem cursor?) 0)
						(self retreat:)
					else
						(EditControl theItem pEvent)
					)
				)
				(
					(and
						(== evKEYBOARD (pEvent type?))
						(proc999_5 (pEvent message?) 9 19712 20480)
					)
					(pEvent claimed: 1)
					(self advance:)
				)
				(
					(and
						(== evKEYBOARD (pEvent type?))
						(proc999_5 (pEvent message?) 3840 19200 18432)
					)
					(pEvent claimed: 1)
					(self retreat:)
				)
				(else (EditControl theItem pEvent))
			)
		)
		(return theTheItem)
	)
	
	(method (check &tmp theLastSeconds)
		(if
			(and
				seconds
				(!= lastSeconds (= theLastSeconds (GetTime 1)))
			)
			(= lastSeconds theLastSeconds)
			(if (not (-- seconds)) (self cue:))
		)
	)
)

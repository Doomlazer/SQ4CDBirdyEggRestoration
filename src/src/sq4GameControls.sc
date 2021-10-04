;;; Sierra Script 1.0 - (do not remove this comment)
(script# 818)
(include sci.sh)
(use Main)
(use Slider)
(use BorderWindow)
(use IconI)
(use GameControls)

(public
	sq4GameControls 0
	gcWin 1
)

(instance sq4GameControls of GameControls
	(properties)
	
	(method (init)
		(= gGameControls self)
		(self
			add:
				iconOk
				(detailSlider
					theObj: global1
					selector: 299
					topValue: 3
					bottomValue: 0
					yourself:
				)
				(volumeSlider
					theObj: global1
					selector: 380
					topValue: (if (> global106 1) 15 else 1)
					bottomValue: 0
					yourself:
				)
				(speedSlider
					theObj: gEgo
					selector: 317
					topValue: 1
					bottomValue: 15
					yourself:
				)
				(iconSave theObj: global1 selector: 75 yourself:)
				(iconRestore theObj: global1 selector: 76 yourself:)
				(iconRestart theObj: global1 selector: 101 yourself:)
				(iconQuit theObj: global1 selector: 100 yourself:)
				(iconAbout
					theObj: (ScriptID 811 0)
					selector: 57
					yourself:
				)
				iconHelp
				(iconTextSwitch
					theObj: iconTextSwitch
					selector: 57
					yourself:
				)
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor global157
			helpIconItem: iconHelp
			curIcon: iconSave
			window: gcWin
		)
		(gcWin
			color: 0
			back: global158
			topBordColor: gBack
			lftBordColor: global161
			rgtBordColor: global157
			botBordColor: global156
		)
	)
)

(instance gcWin of BorderWindow
	(properties)
	
	(method (open &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 theGBack temp9 temp10 temp11 temp12 [temp13 20] [temp33 20] [temp53 34])
		(self
			top: (/ (- 200 (+ (CelHigh 947 1 1) 6)) 2)
			left: (/ (- 320 (+ 151 (CelWide 947 0 1))) 2)
			bottom:
				(+
					(CelHigh 947 1 1)
					6
					(/ (- 200 (+ (CelHigh 947 1 1) 6)) 2)
				)
			right:
				(+
					151
					(CelWide 947 0 1)
					(/ (- 320 (+ 151 (CelWide 947 0 1))) 2)
				)
			priority: 15
		)
		(super open:)
		(DrawCel
			947
			0
			5
			(+
				(/
					(-
						(- (+ 151 (CelWide 947 0 1)) (+ 4 (CelWide 947 1 1)))
						(CelWide 947 0 5)
					)
					2
				)
				4
				(CelWide 947 1 1)
			)
			6
			15
		)
		(DrawCel 947 1 1 4 3 15)
		(DrawCel 947 1 0 94 38 15)
		(DrawCel 947 1 0 135 38 15)
		(DrawCel 947 0 4 63 (- 37 (+ (CelHigh 947 0 4) 3)) 15)
		(DrawCel 947 0 3 101 (- 37 (+ (CelHigh 947 0 4) 3)) 15)
		(DrawCel 947 0 2 146 (- 37 (+ (CelHigh 947 0 4) 3)) 15)
		(= temp4 (+ (= temp1 (+ 49 (CelHigh 947 0 1))) 26))
		(= temp3
			(+
				(= temp2 (+ 10 (CelWide 947 1 1)))
				(-
					(+ 151 (CelWide 947 0 1))
					(+ 10 (CelWide 947 1 1) 6)
				)
			)
		)
		(= temp11 15)
		(= temp5 0)
		(= temp7 global156)
		(= temp10 global157)
		(= temp9 global161)
		(= theGBack gBack)
		(= temp0 3)
		(= temp6 3)
		(Graph
			grFILL_BOX
			temp1
			temp2
			(+ temp4 1)
			(+ temp3 1)
			temp6
			temp5
			temp11
		)
		(= temp1 (- temp1 temp0))
		(= temp2 (- temp2 temp0))
		(= temp3 (+ temp3 temp0))
		(= temp4 (+ temp4 temp0))
		(Graph
			grFILL_BOX
			temp1
			temp2
			(+ temp1 temp0)
			temp3
			temp6
			temp7
			temp11
		)
		(Graph
			grFILL_BOX
			(- temp4 temp0)
			temp2
			temp4
			temp3
			temp6
			theGBack
			temp11
		)
		(= temp12 0)
		(while (< temp12 temp0)
			(Graph
				grDRAW_LINE
				(+ temp1 temp12)
				(+ temp2 temp12)
				(- temp4 (+ temp12 1))
				(+ temp2 temp12)
				temp10
				temp11
				-1
			)
			(Graph
				grDRAW_LINE
				(+ temp1 temp12)
				(- temp3 (+ temp12 1))
				(- temp4 (+ temp12 1))
				(- temp3 (+ temp12 1))
				temp9
				temp11
				-1
			)
			(++ temp12)
		)
		(Graph
			grUPDATE_BOX
			temp1
			temp2
			(+ temp4 1)
			(+ temp3 1)
			1
		)
		(Message msgGET 818 97 0 2 1 @temp33)
		(Format @temp13 @temp33 global15)
		(TextSize @temp53 @temp13 999 0)
		(Display
			@temp13
			105
			999
			102
			global161
			100
			(+
				10
				(CelWide 947 1 1)
				(/
					(-
						(-
							(+ 151 (CelWide 947 0 1))
							(+ 10 (CelWide 947 1 1) 6)
						)
						[temp53 3]
					)
					2
				)
			)
			(+ 49 (CelHigh 947 0 1) 3 10)
		)
	)
)

(instance detailSlider of Slider
	(properties
		view 947
		loop 0
		cel 1
		nsLeft 67
		nsTop 37
		signal $0080
		noun 98
		modNum 818
		helpVerb 44
		sliderView 947
		topValue 3
	)
)

(instance volumeSlider of Slider
	(properties
		view 947
		loop 0
		cel 1
		nsLeft 107
		nsTop 37
		signal $0080
		noun 98
		modNum 818
		helpVerb 51
		sliderView 947
		topValue 15
	)
)

(instance speedSlider of Slider
	(properties
		view 947
		loop 0
		cel 1
		nsLeft 147
		nsTop 37
		signal $0080
		noun 98
		modNum 818
		helpVerb 50
		sliderView 947
		bottomValue 15
	)
	
	(method (doit)
		(= global199 (super doit: &rest))
	)
	
	(method (show)
		(if (not (global80 controls?))
			(= sliderCel 8)
			(= signal 132)
		else
			(= sliderCel 0)
			(= signal 128)
		)
		(super show: &rest)
	)
	
	(method (mask)
	)
	
	(method (move)
		(if (global80 controls?) (super move: &rest))
	)
)

(instance iconSave of ControlIcon
	(properties
		view 947
		loop 2
		cel 0
		nsLeft 8
		nsTop 6
		signal $01c3
		noun 98
		modNum 818
		helpVerb 49
	)
)

(instance iconRestore of ControlIcon
	(properties
		view 947
		loop 3
		cel 0
		nsLeft 8
		nsTop 26
		signal $01c3
		noun 98
		modNum 818
		helpVerb 48
	)
)

(instance iconRestart of ControlIcon
	(properties
		view 947
		loop 4
		cel 0
		nsLeft 8
		nsTop 46
		signal $01c3
		noun 98
		modNum 818
		helpVerb 47
	)
)

(instance iconQuit of ControlIcon
	(properties
		view 947
		loop 5
		cel 0
		nsLeft 8
		nsTop 66
		signal $01c3
		noun 98
		modNum 818
		helpVerb 46
	)
)

(instance iconAbout of ControlIcon
	(properties
		view 947
		loop 6
		cel 0
		nsLeft 8
		nsTop 86
		signal $01c3
		noun 98
		modNum 818
		helpVerb 43
	)
)

(instance iconHelp of IconI
	(properties
		view 947
		loop 7
		cel 0
		nsLeft 34
		nsTop 86
		cursor 856
		signal $0183
		noun 98
		modNum 818
		helpVerb 42
	)
)

(instance iconTextSwitch of ControlIcon
	(properties
		view 947
		loop 9
		cel 0
		nsLeft 8
		nsTop 106
		signal $0183
		noun 98
		modNum 818
		helpVerb 54
	)
	
	(method (doit)
		(switch gOldMsgType
			(1 (= gOldMsgType 2))
			(2 (= gOldMsgType 1))
		)
		(self show:)
	)
	
	(method (show &tmp [temp0 25] [temp25 4] [temp29 20] [temp49 10])
		(switch gOldMsgType
			(1
				(= global83 0)
				(self loop: 10)
				(Message msgGET 818 97 0 3 1 @temp49)
			)
			(2
				(= global83 1)
				(self loop: 9)
				(Message msgGET 818 97 0 4 1 @temp49)
			)
			(3
				(= global83 1)
				(self loop: 9)
				(Message msgGET 818 97 0 5 1 @temp49)
			)
		)
		(Graph grFILL_BOX 114 73 121 164 gColor)
		(Graph grUPDATE_BOX 114 73 121 164 1)
		(super show: &rest)
		(Message msgGET 818 97 0 1 1 @temp29)
		(Format @temp0 @temp29 @temp49)
		(TextSize @temp25 @temp0 999 0)
		(Display
			@temp0
			105
			999
			102
			global161
			100
			(+
				10
				(CelWide 947 1 1)
				(/
					(-
						(-
							(+ 151 (CelWide 947 0 1))
							(+ 10 (CelWide 947 1 1) 6)
						)
						[temp25 3]
					)
					2
				)
			)
			(+ 49 (CelHigh 947 0 1) 3)
		)
	)
)

(instance iconOk of IconI
	(properties
		view 947
		loop 8
		cel 0
		nsLeft 8
		nsTop 126
		cursor 999
		signal $01c3
		noun 98
		modNum 818
		helpVerb 45
	)
)

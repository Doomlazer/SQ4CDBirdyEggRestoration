;;; Sierra Script 1.0 - (do not remove this comment)
(script# 514)
(include sci.sh)
(use Main)
(use Class_255_0)
(use KeyPadButton_541)
(use brain)
(use SQRoom)
(use Sq4Feature)
(use MCyc)
(use PolyPath)
(use n958)
(use Sound)
(use Cycle)
(use User)
(use Obj)

(public
	rm514 0
)

(local
	local0 =  26229
	[local1 4] = [13 23 33 50]
	[local5 4] = [23 33 43 55]
	[local9 7]
	local16
	[local17 29] = [1 0 161 77 1 0 161 82 1 0 161 87 1 0 161 92 1 0 161 97 1 0 161 102 1 0 161 109 -32768]
)
(procedure (localproc_0180)
	(Display
		{8888888888}
		100
		(+ (keyPad x?) 18)
		(+ (keyPad y?) 9)
		102
		global129
		101
		0
		105
		30
	)
)

(procedure (localproc_01af param1 param2 param3)
	(param1
		nsLeft: (param1 x?)
		nsTop: (param1 y?)
		nsRight: (+ (param1 x?) param2)
		nsBottom: (+ (param1 y?) param3)
	)
)

(instance rm514 of SQRoom
	(properties
		picture 514
		style $000a
		east 515
		lookStr 1
	)
	
	(method (init)
		(proc958_0 128 500 502)
		(proc958_0 132 102 124 154 155 101)
		(gEgo init:)
		(alarm1 init:)
		(alarm2 init:)
		(alarm3 init:)
		(if (not (proc0_6 68))
			(smallKeyPad init:)
			(doorTop init:)
			(doorBottom init:)
		else
			(chamber init: addToPic:)
		)
		(self setRegions: 704)
		(super init:)
		(brain
			makePolygon:
				0
				0
				319
				0
				319
				113
				178
				113
				173
				78
				165
				78
				165
				70
				152
				70
				152
				78
				140
				78
				136
				126
				319
				126
				319
				189
				0
				189
		)
		(self setScript: enterScript 0 (== global12 515))
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script)
			((proc0_5 gEgo 16) (global2 newRoom: 544))
			((proc0_5 gEgo 8) (brain exitDir: 90))
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance alarm1 of Sq4Prop
	(properties
		x 251
		y 70
		view 505
		lookStr 2
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance alarm2 of Sq4Prop
	(properties
		x 152
		y 77
		z 60
		view 505
		loop 1
		priority 9
		signal $4010
		lookStr 3
	)
	
	(method (doit)
		(super doit:)
		(if (and cycler (== cel 0))
			(gLongSong2 number: 101 loop: 1 play:)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance alarm3 of Sq4Prop
	(properties
		x 85
		y 61
		view 505
		loop 2
		lookStr 4
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance enterDown of Sq4Prop
	(properties
		view 502
		loop 1
		cel 11
		priority 15
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local1 0])
			y: (+ (keyPad y?) [local5 3])
		)
	)
)

(instance doorTop of Sq4Prop
	(properties
		x 139
		y 9
		view 500
		lookStr 5
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doorBottom of Sq4Prop
	(properties
		x 161
		y 72
		view 500
		loop 1
		priority 2
		signal $4010
		lookStr 5
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (onMe)
		(return
			(if (super onMe: &rest)
				(not (smallKeyPad onMe: &rest))
			else
				0
			)
		)
	)
)

(instance lightTop of Sq4Prop
	(properties
		x 159
		y 30
		view 500
		loop 3
		lookStr 6
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lightBottom of Sq4Prop
	(properties
		x 159
		y 75
		view 500
		loop 4
		signal $4000
		lookStr 6
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chamber of Sq4View
	(properties
		x 161
		y 76
		view 500
		loop 2
		priority 2
		signal $4010
		lookStr 7
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance droid of SecurityDroid
	(properties
		x 320
		y 122
		z 44
		view 506
		cycleSpeed 12
		room 514
		level 2
	)
	
	(method (init)
		(= body droidBody)
		(super init: &rest)
		(self setCycle: Fwd)
	)
	
	(method (doit &tmp temp0)
		(super doit:)
		(self setPri: 13)
		(if script
		else
			(= temp0 (self distanceTo: gEgo))
			(cond 
				((== attacks 3) (self attack: 1))
				((< temp0 50) (self attack: 1))
				((< temp0 100) (self attack: 0))
			)
		)
	)
)

(instance droidBody of Sq4Prop
	(properties
		view 506
		loop 1
	)
	
	(method (doit)
		(super doit:)
		(self
			x: (droid x?)
			y: (droid y?)
			setPri: (droid priority?)
			signal: (| (droid signal?) $4000)
		)
	)
)

(instance smallKeyPad of Sq4Feature
	(properties
		x 160
		y 56
		nsTop 52
		nsLeft 154
		nsBottom 61
		nsRight 166
		sightAngle 90
		lookStr 8
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(global2 setScript: keyPadScript)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hand of Sq4View
	(properties
		view 502
		cel 2
		priority 15
		signal $0010
	)
	
	(method (doit &tmp userCurEvent userCurEventX temp2)
		(= userCurEvent (User curEvent?))
		(if
			(and
				(not (& signal $8000))
				(not (& (userCurEvent type?) $0047))
			)
			(GlobalToLocal userCurEvent)
			(= userCurEventX (userCurEvent x?))
			(= temp2 (+ (userCurEvent y?) 10))
			(if
				(proc999_4
					(keyPad x?)
					(keyPad y?)
					(+
						(keyPad x?)
						(CelWide (keyPad view?) (keyPad loop?) (keyPad cel?))
					)
					(+
						(keyPad y?)
						(CelHigh (keyPad view?) (keyPad loop?) (keyPad cel?))
					)
					userCurEventX
					temp2
				)
				(global1 setCursor: 69 1)
				(self show: x: userCurEventX y: temp2)
			else
				(global1 setCursor: gWalkCursor 1)
				(self hide:)
			)
		)
		(super doit:)
	)
)

(instance keyPad of Sq4View
	(properties
		x 220
		y 40
		view 502
		cel 1
		priority 8
	)
	
	(method (init)
		(super init: &rest)
		(self signal: 273)
		(gSq4MouseDownHandler addToFront: self)
		(gSq4KeyDownHandler addToFront: self)
		(User mapKeyToDir: 0)
		(gIconBar disable:)
		(oneBut init: @local9 who: oneDown)
		(twoBut init: @local9 who: twoDown)
		(threeBut init: @local9 who: threeDown)
		(fourBut init: @local9 who: fourDown)
		(fiveBut init: @local9 who: fiveDown)
		(sixBut init: @local9 who: sixDown)
		(sevenBut init: @local9 who: sevenDown)
		(eightBut init: @local9 who: eightDown)
		(nineBut init: @local9 who: nineDown)
		(enterBut init:)
		(quitBut init:)
		(oneDown init: hide:)
		(twoDown init: hide:)
		(threeDown init: hide:)
		(fourDown init: hide:)
		(fiveDown init: hide:)
		(sixDown init: hide:)
		(sevenDown init: hide:)
		(eightDown init: hide:)
		(nineDown init: hide:)
		(enterDown init: hide:)
		(hand
			init:
			hide:
			x: (+ (keyPad x?) 50)
			y: (+ (keyPad y?) 20)
		)
		(self doit:)
		(gIconBar curIcon: (gIconBar at: 1))
		(super init:)
	)
	
	(method (doit &tmp temp0)
		(asm
			lag      gPseudoMouse
			bnt      code_0840
			pushi    #joyInc
			pushi    1
			pushi    2
			send     6
code_0840:
			pushi    #new
			pushi    0
			pushi    #curEvent
			pushi    0
			lag      global80
			send     4
			send     4
			sat      temp0
			sag      global24
			pushi    #localize
			pushi    0
			lat      temp0
			send     4
			lag      gPseudoMouse
			bnt      code_086e
			pushi    #contains
			pushi    1
			push    
			lag      global78
			send     6
			bnt      code_086e
			pushi    #doit
			pushi    0
			lag      gPseudoMouse
			send     4
code_086e:
			pushi    1
			lst      temp0
			callk    MapKeyToDir,  2
			pushi    3
			pushi    #type
			pushi    0
			lat      temp0
			send     4
			push    
			pushi    1
			pushi    256
			calle    proc999_5,  6
			bnt      code_0896
			pushi    #handleEvent
			pushi    1
			lst      temp0
			lag      gSq4MouseDownHandler
			send     6
			jmp      code_08ad
code_0896:
			pushi    #type
			pushi    0
			lat      temp0
			send     4
			push    
			ldi      4
			and     
			bnt      code_08ad
			pushi    #handleEvent
			pushi    1
			lst      temp0
			lag      gSq4KeyDownHandler
			send     6
code_08ad:
			pTos     signal
			ldi      32768
			and     
			bnt      code_08b7
			jmp      code_08f9
code_08b7:
			lag      gPseudoMouse
			bnt      code_08c3
			pushi    #handleEvent
			pushi    1
			lst      temp0
			send     6
code_08c3:
			lsg      global86
			pushi    0
			callk    GetTime,  0
			add     
			sag      global88
			pushi    #eachElementDo
			pushi    1
			pushi    174
			lag      global8
			send     6
			pushi    2
			pushi    #elements
			pushi    0
			lag      global5
			send     4
			push    
			pushi    1
			callk    Animate,  4
			lag      global37
			bnt      code_0840
			ldi      0
			sag      global37
			pushi    #eachElementDo
			pushi    1
			pushi    246
			lag      global5
			send     6
			jmp      code_0840
code_08f9:
			lag      gPseudoMouse
			bnt      code_0905
			pushi    #joyInc
			pushi    1
			pushi    5
			send     6
code_0905:
			ret     
		)
	)
	
	(method (dispose)
		(super dispose: &rest)
		(User mapKeyToDir: 1)
		(global1 setCursor: ((gIconBar curIcon?) cursor?) 1)
		(gSq4KeyDownHandler delete: self)
		(gSq4MouseDownHandler delete: self)
		(oneBut dispose:)
		(twoBut dispose:)
		(threeBut dispose:)
		(fourBut dispose:)
		(fiveBut dispose:)
		(sixBut dispose:)
		(sevenBut dispose:)
		(eightBut dispose:)
		(nineBut dispose:)
		(enterBut dispose:)
		(quitBut dispose:)
		(oneDown dispose:)
		(twoDown dispose:)
		(threeDown dispose:)
		(fourDown dispose:)
		(fiveDown dispose:)
		(sixDown dispose:)
		(sevenDown dispose:)
		(eightDown dispose:)
		(nineDown dispose:)
		(enterDown dispose:)
		(hand dispose:)
		(gIconBar enable:)
	)
	
	(method (handleEvent pEvent)
		(if (proc255_2 self pEvent) (pEvent claimed: 1))
	)
)

(class KeyPadButton of Sq4Feature
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
		theString 0
		strToCat 0
		keyEquiv 0
		maxLen 0
		who 0
		tone 0
	)
	
	(method (init theTheString)
		(super init:)
		(= theString theTheString)
		(gSq4MouseDownHandler addToFront: self)
		(gSq4KeyDownHandler addToFront: self)
	)
	
	(method (doit)
		(who setScript: (Clone keyFlashScript) 0 tone)
		(if (< (StrLen theString) maxLen)
			(localproc_0180)
			(StrCat theString strToCat)
			(++ local16)
			(Display
				theString
				100
				(+ (keyPad x?) 18 (* (- maxLen (StrLen theString)) 4))
				(+ (keyPad y?) 9)
				102
				global142
				101
				0
				105
				30
			)
		)
	)
	
	(method (dispose)
		(gSq4KeyDownHandler delete: self)
		(gSq4MouseDownHandler delete: self)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(cond 
			((& (pEvent type?) evKEYBOARD)
				(if (== (pEvent message?) keyEquiv)
					(pEvent claimed: 1)
					(self doit:)
				)
			)
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(proc999_4 nsLeft nsTop nsRight nsBottom pEvent)
				)
				(pEvent claimed: 1)
				(self doit:)
			)
			(
				(and
					(== (pEvent type?) evJOYDOWN)
					(not (pEvent modifiers?))
					(proc999_4 nsLeft nsTop nsRight nsBottom pEvent)
				)
				(pEvent claimed: 1)
				(self doit:)
			)
		)
	)
)

(instance beep of Sound
	(properties)
)

(instance keyFlashScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client show:)
				(beep number: register play:)
				(= cycles 2)
			)
			(1 (client hide: setScript: 0))
		)
	)
)

(instance enterBut of Sq4Feature
	(properties)
	
	(method (init)
		(super init: &rest)
		(gSq4MouseDownHandler addToFront: self)
		(gSq4KeyDownHandler addToEnd: self)
		(self
			x: (+ (keyPad x?) [local1 3])
			y: (+ (keyPad y?) [local5 0])
		)
		(localproc_01af self 8 33)
	)
	
	(method (dispose)
		(super dispose: &rest)
		(gSq4MouseDownHandler delete: self)
		(gSq4KeyDownHandler delete: self)
	)
	
	(method (handleEvent pEvent &tmp temp0 temp1 temp2)
		(cond 
			((super handleEvent: pEvent))
			(
				(or
					(and
						(== (pEvent type?) evKEYBOARD)
						(== (pEvent message?) KEY_RETURN)
					)
					(proc255_2 self pEvent)
				)
				(pEvent claimed: 1)
				(enterDown setScript: (Clone keyFlashScript) 0 864)
				(= temp0 (ReadNumber @local9))
				(= temp2 (StrLen @local9))
				(= local9 0)
				(keyPad dispose:)
				(if (== temp0 local0)
					(global2 setScript: openDoorScript)
				else
					(global2 setScript: alarmScript)
				)
			)
		)
	)
)

(instance quitBut of Sq4Feature
	(properties)
	
	(method (init)
		(super init: &rest)
		(gSq4MouseDownHandler addToFront: self)
		(gSq4KeyDownHandler addToFront: self)
		(self
			x: (+ (keyPad x?) [local1 0])
			y: (+ (keyPad y?) [local5 3])
		)
		(localproc_01af self 19 8)
	)
	
	(method (dispose)
		(super dispose: &rest)
		(beep number: 865 play:)
		(gSq4MouseDownHandler delete: self)
		(gSq4KeyDownHandler delete: self)
	)
	
	(method (handleEvent pEvent)
		(cond 
			((super handleEvent: pEvent))
			(
				(or
					(and
						(== (pEvent type?) evKEYBOARD)
						(proc999_5 (pEvent message?) 88 120)
					)
					(proc255_2 self pEvent)
					(proc999_4 nsLeft nsTop nsRight nsBottom pEvent)
				)
				(pEvent claimed: 1)
				(= local9 0)
				(keyPad dispose:)
			)
		)
	)
)

(instance oneBut of KeyPadButton
	(properties
		strToCat {1}
		keyEquiv 49
		maxLen 10
		tone 854
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local1 0])
			y: (+ (keyPad y?) [local5 0])
		)
		(localproc_01af self 8 8)
	)
)

(instance twoBut of KeyPadButton
	(properties
		strToCat {2}
		keyEquiv 50
		maxLen 10
		tone 855
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local1 1])
			y: (+ (keyPad y?) [local5 0])
		)
		(localproc_01af self 8 8)
	)
)

(instance threeBut of KeyPadButton
	(properties
		strToCat {3}
		keyEquiv 51
		maxLen 10
		tone 856
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local1 2])
			y: (+ (keyPad y?) [local5 0])
		)
		(localproc_01af self 8 8)
	)
)

(instance fourBut of KeyPadButton
	(properties
		strToCat {4}
		keyEquiv 52
		maxLen 10
		tone 857
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local1 0])
			y: (+ (keyPad y?) [local5 1])
		)
		(localproc_01af self 8 8)
	)
)

(instance fiveBut of KeyPadButton
	(properties
		strToCat {5}
		keyEquiv 53
		maxLen 10
		tone 858
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local1 1])
			y: (+ (keyPad y?) [local5 1])
		)
		(localproc_01af self 8 8)
	)
)

(instance sixBut of KeyPadButton
	(properties
		strToCat {6}
		keyEquiv 54
		maxLen 10
		tone 859
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local1 2])
			y: (+ (keyPad y?) [local5 1])
		)
		(localproc_01af self 8 8)
	)
)

(instance sevenBut of KeyPadButton
	(properties
		strToCat {7}
		keyEquiv 55
		maxLen 10
		tone 860
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local1 0])
			y: (+ (keyPad y?) [local5 2])
		)
		(localproc_01af self 8 8)
	)
)

(instance eightBut of KeyPadButton
	(properties
		strToCat {8}
		keyEquiv 56
		maxLen 10
		tone 861
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local1 1])
			y: (+ (keyPad y?) [local5 2])
		)
		(localproc_01af self 8 8)
	)
)

(instance nineBut of KeyPadButton
	(properties
		strToCat {9}
		keyEquiv 57
		maxLen 10
		tone 862
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local1 2])
			y: (+ (keyPad y?) [local5 2])
		)
		(localproc_01af self 8 8)
	)
)

(instance oneDown of Sq4Prop
	(properties
		view 502
		loop 1
		priority 15
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local1 0])
			y: (+ (keyPad y?) [local5 0])
		)
	)
)

(instance twoDown of Sq4Prop
	(properties
		view 502
		loop 1
		cel 1
		priority 15
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local1 1])
			y: (+ (keyPad y?) [local5 0])
		)
	)
)

(instance threeDown of Sq4Prop
	(properties
		view 502
		loop 1
		cel 2
		priority 15
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local1 2])
			y: (+ (keyPad y?) [local5 0])
		)
	)
)

(instance fourDown of Sq4Prop
	(properties
		view 502
		loop 1
		cel 3
		priority 15
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local1 0])
			y: (+ (keyPad y?) [local5 1])
		)
	)
)

(instance fiveDown of Sq4Prop
	(properties
		view 502
		loop 1
		cel 4
		priority 15
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local1 1])
			y: (+ (keyPad y?) [local5 1])
		)
	)
)

(instance sixDown of Sq4Prop
	(properties
		view 502
		loop 1
		cel 5
		priority 15
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local1 2])
			y: (+ (keyPad y?) [local5 1])
		)
	)
)

(instance sevenDown of Sq4Prop
	(properties
		view 502
		loop 1
		cel 6
		priority 15
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local1 0])
			y: (+ (keyPad y?) [local5 2])
		)
	)
)

(instance eightDown of Sq4Prop
	(properties
		view 502
		loop 1
		cel 7
		priority 15
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local1 1])
			y: (+ (keyPad y?) [local5 2])
		)
	)
)

(instance nineDown of Sq4Prop
	(properties
		view 502
		loop 1
		cel 8
		priority 15
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local1 2])
			y: (+ (keyPad y?) [local5 2])
		)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(proc0_2)
				(if register
					(= temp0 318)
					(= temp1 122)
					(= temp2 288)
					(= temp3 122)
				else
					(= temp0 164)
					(= temp1 75)
					(= temp2 164)
					(= temp3 100)
					(gLongSong setVol: 127)
					(gLongSong2 setVol: 127)
				)
				(gEgo
					setPri: -1
					posn: temp0 temp1
					setMotion: PolyPath temp2 temp3 self
				)
			)
			(1
				(proc0_3)
				(if (global5 contains: doorTop)
					(gEgo observeControl: 2)
				)
				(proc0_11 88 10)
				(self dispose:)
			)
		)
	)
)

(instance openDoorScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(proc0_11 89 10)
				(gLongSong2 number: 124 loop: 1 vol: 127 play: self)
			)
			(1
				(gLongSong2 number: 154 loop: -1 play:)
				(doorTop cycleSpeed: 12 setCycle: End)
				(doorBottom
					setPri: 2
					cycleSpeed: 12
					setCycle: MCyc @local17 self
				)
				(smallKeyPad dispose:)
			)
			(2
				(gLongSong2 number: 155 loop: 1 play:)
				(doorTop dispose:)
				(doorBottom dispose:)
				(lightTop init: cycleSpeed: 12 setCycle: End)
				(lightBottom init: cycleSpeed: 12 setCycle: End self)
			)
			(3
				(proc0_3)
				(chamber init: addToPic:)
				(lightTop dispose:)
				(lightBottom dispose:)
				(gEgo ignoreControl: 2)
				(proc0_7 68)
				(self dispose:)
			)
		)
	)
)

(instance keyPadScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(if (> (gEgo distanceTo: smallKeyPad) 30)
					(gEgo setMotion: PolyPath 164 77 self)
				else
					(= cycles 1)
				)
			)
			(1
				(proc0_3)
				(keyPad init:)
				(self dispose:)
			)
		)
	)
)

(instance alarmScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(alarm1 setCycle: Fwd)
				(alarm2 setCycle: Fwd)
				(alarm3 setCycle: Fwd)
				(= seconds 5)
			)
			(1
				(droid init: setMotion: PolyPath (gEgo x?) (gEgo y?))
				(self dispose:)
			)
		)
	)
)

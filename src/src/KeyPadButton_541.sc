;;; Sierra Script 1.0 - (do not remove this comment)
(script# 541)
(include sci.sh)
(use Main)
(use Class_255_0)
(use brain)
(use MoveToY)
(use SQRoom)
(use Sq4Feature)
(use PolyPath)
(use n958)
(use Sound)
(use Cycle)
(use User)
(use Obj)

(public
	rm541 0
)

(local
	[local0 3] = [9 20 31]
	[local3 3] = [7 17 27]
	[local6 5] = [6 16 26 36 48]
	local11
	[local12 4]
)
(procedure (localproc_01aa)
	(Display
		{888}
		100
		(+ (keyPad x?) 54)
		(+ (keyPad y?) [local0 local11])
		102
		global129
		101
		0
		105
		30
	)
)

(procedure (localproc_01db param1 param2 param3)
	(param1
		nsLeft: (param1 x?)
		nsTop: (param1 y?)
		nsRight: (+ (param1 x?) param2)
		nsBottom: (+ (param1 y?) param3)
	)
)

(instance rm541 of SQRoom
	(properties
		picture 541
		north 525
		south 540
		vanishingX 0
		vanishingY -30
	)
	
	(method (init &tmp temp0 temp1 temp2)
		(proc958_0 128 516 502 517 515)
		(Load
			rsSOUND
			854
			855
			856
			857
			858
			859
			860
			861
			862
			863
			885
			153
		)
		(gEgo init:)
		(self setRegions: 704)
		(super init:)
		(gLongSong number: 885 loop: -1 vol: 127 playBed:)
		(brain
			makePolygon: 0 0 33 0 215 189 0 189
			makePolygon: 40 0 318 0 319 189 241 189 219 165 192 157
			level: 2
		)
		(global1 setCursor: 69 1)
		(smallKeyPad init:)
		(= temp1 0)
		(if (>= (= temp2 global185) 4096)
			(= temp1 1)
			(= temp2 (- temp2 4096))
		)
		(if temp1
			(smoke0 setCel: 3 init: stopUpd:)
			(smoke1 setCel: 3 init: stopUpd:)
			(smoke2 setCel: 3 init: stopUpd:)
		)
		(= temp0 (mod temp2 16))
		(beam0 cycleSpeed: 1 setLoop: temp1 setCel: temp0 init:)
		(= temp0 (mod (= temp2 (/ temp2 16)) 16))
		(beam1 cycleSpeed: 1 setLoop: temp1 setCel: temp0 init:)
		(= temp0 (= temp2 (/ temp2 16)))
		(beam2 cycleSpeed: 1 setLoop: temp1 setCel: temp0 init:)
		(switch gWest
			(north
				(self setScript: enterScript 0 1)
			)
			(else 
				(self setScript: enterScript 0 3)
			)
		)
		(roomFeature init:)
	)
	
	(method (doit)
		(super doit: &rest)
		(cond 
			(script)
			((== ((gInv at: 12) state?) 1) (self setScript: smokeScript) ((gInv at: 12) state: 0))
			((proc0_5 gEgo 8) (brain exitDir: (if (> (gEgo y?) 100) 135 else 315)))
		)
	)
	
	(method (newRoom newRoomNumber)
		(if
			(and
				(== newRoomNumber (global2 south?))
				(brain formatting?)
			)
			(proc0_10 0 19)
		else
			(gLongSong fade:)
			(if (global5 contains: smoke0)
				(= global185 4096)
			else
				(= global185 0)
			)
			(= global185
				(+
					(= global185
						(+
							(= global185 (+ global185 (* (beam2 cel?) 256)))
							(* (beam1 cel?) 16)
						)
					)
					(beam0 cel?)
				)
			)
			(super newRoom: newRoomNumber)
		)
	)
)

(instance smallKeyPad of Sq4Feature
	(properties
		x 248
		y 147
		nsTop 136
		nsLeft 240
		nsBottom 158
		nsRight 256
		sightAngle 90
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(global2 setScript: startKeyPadScript)
			)
			(1
				(global2 setScript: startKeyPadScript)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance beam0 of Sq4Prop
	(properties
		x 190
		y 157
		sightAngle 90
		view 516
		cel 9
		signal $4000
	)
	
	(method (init)
		(super init: &rest)
		(if loop (= noun 0) else (= noun 0))
	)
	
	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not (global2 script?))
				(!= cel 7)
				(<
					(GetDistance (self x?) (self y?) (gEgo x?) (gEgo y?))
					5
				)
			)
			(global2 setScript: egoFryScript)
		)
	)
	
	(method (cue)
		(rotate stop:)
		(super cue:)
		(gIconBar enable: 0)
		(self setScript: 0)
	)
)

(instance beam1 of Sq4Prop
	(properties
		x 151
		y 117
		sightAngle 90
		view 516
		cel 5
		signal $4000
	)
	
	(method (init)
		(super init: &rest)
		(if loop (= noun 0) else (= noun 0))
	)
	
	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not (global2 script?))
				(!= cel 7)
				(<
					(GetDistance (self x?) (self y?) (gEgo x?) (gEgo y?))
					5
				)
			)
			(global2 setScript: egoFryScript)
		)
	)
	
	(method (cue)
		(rotate stop:)
		(super cue:)
		(gIconBar enable: 0)
		(self setScript: 0)
	)
)

(instance beam2 of Sq4Prop
	(properties
		x 110
		y 77
		sightAngle 90
		view 516
		cel 13
		signal $4000
	)
	
	(method (init)
		(super init: &rest)
		(if loop (= noun 0) else (= noun 0))
	)
	
	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not (global2 script?))
				(!= cel 7)
				(<
					(GetDistance (self x?) (self y?) (gEgo x?) (gEgo y?))
					5
				)
			)
			(global2 setScript: egoFryScript)
		)
	)
	
	(method (cue)
		(rotate stop:)
		(super cue:)
		(gIconBar enable: 0)
		(self setScript: 0)
		(if
			(and
				(== cel 7)
				(== (beam0 cel?) 7)
				(== (beam1 cel?) 7)
			)
			(proc0_11 59 15)
		)
	)
)

(instance smoke0 of Sq4Prop
	(properties
		x 191
		y 122
		view 517
		priority 1
		signal $4000
		cycleSpeed 18
	)
)

(instance smoke1 of Sq4Prop
	(properties
		x 168
		y 94
		view 517
		loop 1
		priority 1
		signal $4000
		cycleSpeed 18
	)
)

(instance smoke2 of Sq4Prop
	(properties
		x 130
		y 54
		view 517
		loop 2
		priority 1
		signal $4000
		cycleSpeed 18
	)
)

(instance blinker of Sq4Prop
	(properties
		view 502
		loop 2
		priority 14
		signal $4010
	)
	
	(method (doit)
		(super doit:)
		(self
			x: (+ (keyPad x?) 53)
			y: (+ (keyPad y?) [local0 local11] 4)
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
				(global1 setCursor: 852 1)
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
	)
	
	(method (init)
		(super init: &rest)
		(self signal: 257)
		(gSq4MouseDownHandler addToFront: self)
		(gSq4KeyDownHandler addToFront: self)
		(User mapKeyToDir: 0)
		(gIconBar disable:)
		(oneBut init: @local12 who: oneDown)
		(twoBut init: @local12 who: twoDown)
		(threeBut init: @local12 who: threeDown)
		(fourBut init: @local12 who: fourDown)
		(fiveBut init: @local12 who: fiveDown)
		(sixBut init: @local12 who: sixDown)
		(sevenBut init: @local12 who: sevenDown)
		(eightBut init: @local12 who: eightDown)
		(nineBut init: @local12 who: nineDown)
		(zeroBut init: @local12 who: zeroDown)
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
		(zeroDown init: hide:)
		(enterDown init: hide:)
		(hand
			init:
			hide:
			x: (+ (keyPad x?) 50)
			y: (+ (keyPad y?) 20)
		)
		(blinker init: setCycle: Fwd)
		(self doit:)
	)
	
	(method (doit &tmp temp0)
		(asm
			lag      gPseudoMouse
			bnt      code_0a59
			pushi    #joyInc
			pushi    1
			pushi    2
			send     6
code_0a59:
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
			bnt      code_0a87
			pushi    #contains
			pushi    1
			push    
			lag      global78
			send     6
			bnt      code_0a87
			pushi    #doit
			pushi    0
			lag      gPseudoMouse
			send     4
code_0a87:
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
			bnt      code_0aaf
			pushi    #handleEvent
			pushi    1
			lst      temp0
			lag      gSq4MouseDownHandler
			send     6
			jmp      code_0ac6
code_0aaf:
			pushi    #type
			pushi    0
			lat      temp0
			send     4
			push    
			ldi      4
			and     
			bnt      code_0ac6
			pushi    #handleEvent
			pushi    1
			lst      temp0
			lag      gSq4KeyDownHandler
			send     6
code_0ac6:
			pTos     signal
			ldi      32768
			and     
			bnt      code_0ad0
			jmp      code_0b12
code_0ad0:
			lag      gPseudoMouse
			bnt      code_0adc
			pushi    #handleEvent
			pushi    1
			lst      temp0
			send     6
code_0adc:
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
			bnt      code_0a59
			ldi      0
			sag      global37
			pushi    #eachElementDo
			pushi    1
			pushi    246
			lag      global5
			send     6
			jmp      code_0a59
code_0b12:
			lag      gPseudoMouse
			bnt      code_0b1e
			pushi    #joyInc
			pushi    1
			pushi    5
			send     6
code_0b1e:
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
		(zeroBut dispose:)
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
		(zeroDown dispose:)
		(enterDown dispose:)
		(blinker dispose:)
		(hand dispose:)
		(proc0_3)
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
			(localproc_01aa)
			(StrCat theString strToCat)
			(Display
				theString
				100
				(+ (keyPad x?) 54 (* (- maxLen (StrLen theString)) 4))
				(+ (keyPad y?) [local0 local11])
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

(instance rotate of Sound
	(properties
		number 153
	)
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

(class CA of Cycle
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
		celCnt 0
	)
	
	(method (init param1 param2 theCaller)
		(super init: param1)
		(= celCnt (if (< param2 1) 1 else param2))
		(if (== argc 3) (= caller theCaller))
	)
	
	(method (doit &tmp cANextCel clientLastCel)
		(= clientLastCel (client lastCel:))
		(= cANextCel (self nextCel:))
		(client
			cel: (if (> cANextCel clientLastCel) 0 else cANextCel)
		)
		(-- celCnt)
		(if (not celCnt) (self cycleDone:))
	)
	
	(method (cycleDone)
		(= completed 1)
		(if caller (= global37 1) else (self motionCue:))
	)
)

(instance enterBut of Sq4Feature
	(properties)
	
	(method (init)
		(super init: &rest)
		(gSq4MouseDownHandler addToFront: self)
		(gSq4KeyDownHandler addToFront: self)
		(self
			x: (+ (keyPad x?) [local3 0])
			y: (+ (keyPad y?) [local6 3])
		)
		(localproc_01db self 19 8)
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
						(& (pEvent type?) evKEYBOARD)
						(== (pEvent message?) KEY_RETURN)
					)
					(and
						(== (pEvent type?) evMOUSEBUTTON)
						(proc999_4 nsLeft nsTop nsRight nsBottom pEvent)
					)
					(and
						(== (pEvent type?) evJOYDOWN)
						(not (pEvent modifiers?))
						(proc999_4 nsLeft nsTop nsRight nsBottom pEvent)
					)
				)
				(pEvent claimed: 1)
				(enterDown setScript: (Clone keyFlashScript) 0 864)
				(localproc_01aa)
				(= temp0 (ReadNumber @local12))
				(= temp2 (StrLen @local12))
				(= local12 0)
				(if (or (> temp0 360) (< temp0 1) (< temp2 3))
					0
				else
					(gIconBar disable:)
					(= temp1 (/ temp0 12))
					(switch local11
						(0
							(if (not temp1)
								(beam0 cue:)
							else
								(rotate play:)
								(beam0 setCycle: CA temp1 beam0)
							)
						)
						(1
							(if (not temp1)
								(beam1 cue:)
							else
								(rotate play:)
								(beam1 setCycle: CA temp1 beam1)
							)
						)
						(2
							(if (not temp1)
								(beam2 cue:)
							else
								(rotate play:)
								(beam2 setCycle: CA temp1 beam2)
							)
						)
					)
				)
				(if (> (++ local11) 2) (= local11 0))
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
			x: (+ (keyPad x?) [local3 0])
			y: (+ (keyPad y?) [local6 4])
		)
		(localproc_01db self 19 8)
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
						(& (pEvent type?) evKEYBOARD)
						(proc999_5 (pEvent message?) 88 120)
					)
					(proc255_2 self pEvent)
					(and
						(== (pEvent type?) evJOYDOWN)
						(not (pEvent modifiers?))
						(proc999_4 nsLeft nsTop nsRight nsBottom pEvent)
					)
				)
				(pEvent claimed: 1)
				(= local12 0)
				(keyPad dispose:)
				(gIconBar enable:)
			)
		)
	)
)

(instance oneBut of KeyPadButton
	(properties
		strToCat {1}
		keyEquiv 49
		maxLen 3
		tone 854
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local3 0])
			y: (+ (keyPad y?) [local6 0])
		)
		(localproc_01db self 8 8)
	)
)

(instance twoBut of KeyPadButton
	(properties
		strToCat {2}
		keyEquiv 50
		maxLen 3
		tone 855
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local3 1])
			y: (+ (keyPad y?) [local6 0])
		)
		(localproc_01db self 8 8)
	)
)

(instance threeBut of KeyPadButton
	(properties
		strToCat {3}
		keyEquiv 51
		maxLen 3
		tone 856
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local3 2])
			y: (+ (keyPad y?) [local6 0])
		)
		(localproc_01db self 8 8)
	)
)

(instance fourBut of KeyPadButton
	(properties
		strToCat {4}
		keyEquiv 52
		maxLen 3
		tone 857
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local3 0])
			y: (+ (keyPad y?) [local6 1])
		)
		(localproc_01db self 8 8)
	)
)

(instance fiveBut of KeyPadButton
	(properties
		strToCat {5}
		keyEquiv 53
		maxLen 3
		tone 858
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local3 1])
			y: (+ (keyPad y?) [local6 1])
		)
		(localproc_01db self 8 8)
	)
)

(instance sixBut of KeyPadButton
	(properties
		strToCat {6}
		keyEquiv 54
		maxLen 3
		tone 859
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local3 2])
			y: (+ (keyPad y?) [local6 1])
		)
		(localproc_01db self 8 8)
	)
)

(instance sevenBut of KeyPadButton
	(properties
		strToCat {7}
		keyEquiv 55
		maxLen 3
		tone 860
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local3 0])
			y: (+ (keyPad y?) [local6 2])
		)
		(localproc_01db self 8 8)
	)
)

(instance eightBut of KeyPadButton
	(properties
		strToCat {8}
		keyEquiv 56
		maxLen 3
		tone 861
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local3 1])
			y: (+ (keyPad y?) [local6 2])
		)
		(localproc_01db self 8 8)
	)
)

(instance nineBut of KeyPadButton
	(properties
		strToCat {9}
		keyEquiv 57
		maxLen 3
		tone 862
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local3 2])
			y: (+ (keyPad y?) [local6 2])
		)
		(localproc_01db self 8 8)
	)
)

(instance zeroBut of KeyPadButton
	(properties
		strToCat {0}
		keyEquiv 48
		maxLen 3
		tone 863
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local3 2])
			y: (+ (keyPad y?) [local6 3])
		)
		(localproc_01db self 8 8)
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
			x: (+ (keyPad x?) [local3 0])
			y: (+ (keyPad y?) [local6 0])
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
			x: (+ (keyPad x?) [local3 1])
			y: (+ (keyPad y?) [local6 0])
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
			x: (+ (keyPad x?) [local3 2])
			y: (+ (keyPad y?) [local6 0])
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
			x: (+ (keyPad x?) [local3 0])
			y: (+ (keyPad y?) [local6 1])
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
			x: (+ (keyPad x?) [local3 1])
			y: (+ (keyPad y?) [local6 1])
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
			x: (+ (keyPad x?) [local3 2])
			y: (+ (keyPad y?) [local6 1])
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
			x: (+ (keyPad x?) [local3 0])
			y: (+ (keyPad y?) [local6 2])
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
			x: (+ (keyPad x?) [local3 1])
			y: (+ (keyPad y?) [local6 2])
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
			x: (+ (keyPad x?) [local3 2])
			y: (+ (keyPad y?) [local6 2])
		)
	)
)

(instance zeroDown of Sq4Prop
	(properties
		view 502
		loop 1
		cel 9
		priority 15
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local3 2])
			y: (+ (keyPad y?) [local6 3])
		)
	)
)

(instance enterDown of Sq4Prop
	(properties
		view 502
		loop 1
		cel 10
		priority 15
	)
	
	(method (init)
		(super init: &rest)
		(self
			x: (+ (keyPad x?) [local3 0])
			y: (+ (keyPad y?) [local6 3])
		)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(proc0_2)
				(if (== register 1)
					(= temp0 47)
					(= temp1 7)
					(= temp2 33)
					(= temp3 135)
				else
					(= temp0 277)
					(= temp1 242)
					(= temp2 (- 189 (* (gEgo yStep?) 4)))
					(= temp3 315)
				)
				(gEgo
					illegalBits: 0
					x: temp0
					y: temp1
					setHeading: temp3
					setMotion: MoveToY temp2 self
				)
			)
			(1
				(gEgo illegalBits: -32768 setPri: -1)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance egoFryScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(beam0 setPri: 9)
				(beam1 setPri: 7)
				(beam2 setPri: 3)
				(gEgo view: 515 setLoop: 4 setCycle: Fwd)
				(gLongSong2 number: 139 vol: 127 loop: 1 play:)
				(= cycles 8)
			)
			(1
				(gEgo setLoop: 5 setCel: 0 cycleSpeed: 12 setCycle: End)
				(= seconds 5)
			)
			(2 (proc0_10 8))
		)
	)
)

(instance smokeScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: PolyPath 216 181 self)
			)
			(1
				(gEgo
					view: 515
					setLoop: 2
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(2
				(gEgo setLoop: 3 setCel: 0 setCycle: End self)
				(gLongSong2 number: 846 vol: 127 loop: 1 play:)
			)
			(3
				(smoke0 init: setCycle: End)
				(= cycles 2)
			)
			(4
				(proc0_1 7 0)
				(beam0 setLoop: 1 noun: 0 lookStr: 1)
				(smoke1 init: setCycle: End)
				(= cycles 2)
			)
			(5
				(beam1 setLoop: 1 noun: 0 lookStr: 1)
				(smoke2 init: setCycle: End self)
			)
			(6
				(smoke0 stopUpd:)
				(smoke1 stopUpd:)
				(smoke2 stopUpd:)
				(beam2 setLoop: 1 noun: 0 lookStr: 1)
				(= cycles 6)
			)
			(7
				(gSq4GlobalNarrator say: 3)
				(gEgo put: 12 global11)
				(proc0_11 58 10)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance startKeyPadScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					setMotion: PolyPath (smallKeyPad x?) (smallKeyPad y?) self
				)
			)
			(1 (gEgo setHeading: 90 self))
			(2
				(proc0_3)
				(keyPad init:)
				(self dispose:)
			)
		)
	)
)

(instance roomFeature of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (>= global185 4096)
					(gSq4GlobalNarrator say: 4)
				else
					(gSq4GlobalNarrator say: 5)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

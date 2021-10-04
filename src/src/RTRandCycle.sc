;;; Sierra Script 1.0 - (do not remove this comment)
(script# 928)
(include sci.sh)
(use Main)
(use Sq4Dialog)
(use Sync)
(use RandCycle)
(use Cycle)
(use View)
(use Obj)


(class RTRandCycle of RandCycle
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
		count -1
		reset 0
	)
	
	(method (init param1 param2 theCaller)
		(super init: param1)
		(client cel: 0)
		(= cycleCnt (GetTime))
		(if (>= argc 2)
			(if (!= param2 -1)
				(= count (+ (GetTime) param2))
			else
				(= count -1)
			)
			(if (>= argc 3) (= caller theCaller))
		else
			(= count -1)
		)
	)
	
	(method (doit &tmp temp0)
		(if
		(or (> count (= temp0 (GetTime))) (== count -1))
			(if (> (- temp0 cycleCnt) (client cycleSpeed?))
				(client cel: (self nextCel:))
				(= cycleCnt (GetTime))
			)
		else
			(client cel: 0)
			(self cycleDone:)
		)
	)
)

(class Blink of Cycle
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
		waitCount 0
		lastCount 0
		waitMin 0
		waitMax 0
	)
	
	(method (init param1 param2)
		(if argc
			(= waitMin (/ param2 2))
			(= waitMax (+ param2 waitMin))
			(super init: param1)
		else
			(super init:)
		)
	)
	
	(method (doit &tmp blinkNextCel)
		(cond 
			(waitCount
				(if (> (- gTixCnt waitCount) 0)
					(= waitCount 0)
					(self init:)
				)
			)
			(
				(or
					(> (= blinkNextCel (self nextCel:)) (client lastCel:))
					(< blinkNextCel 0)
				)
				(= cycleDir (- cycleDir))
				(self cycleDone:)
			)
			(else (client cel: blinkNextCel))
		)
	)
	
	(method (cycleDone)
		(if (== cycleDir -1)
			(self init:)
		else
			(= waitCount (+ (Random waitMin waitMax) gTixCnt))
		)
	)
)

(class Narrator of Prop
	(properties
		x -1
		y -1
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
		yStep 2
		view -1
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $0000
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		scaleSignal $0000
		scaleX 128
		scaleY 128
		maxScale 128
		cycleSpeed 6
		script 0
		cycler 0
		timer 0
		detailLevel 0
		scaler 0
		caller 0
		disposeWhenDone 1
		ticks 0
		talkWidth 0
		keepWindow 0
		modeless 0
		font 0
		talkerNum 99
		cueVal 0
		initialized 0
		showTitle 0
		msgList 0
		curVolume -1
		saveCursor 0
		voiceRate 0
		tVerb 0
		tSequence 1
		oldIconBarState 0
	)
	
	(method (init)
		(= initialized 1)
	)
	
	(method (doit)
		(if (and (!= ticks -1) (> (- gTixCnt ticks) 0))
			(if
				(and
					(if (& voiceRate $0002) (== (DoAudio 6) -1) else 1)
					(not keepWindow)
				)
				(self dispose: disposeWhenDone)
				(return 0)
			)
		)
		(return 1)
	)
	
	(method (dispose param1 &tmp theCaller temp1)
		(= ticks -1)
		(cond 
			(modeless
				(gSq4KeyDownHandler delete: self)
				(gSq4MouseDownHandler delete: self)
				(global78 delete: self)
			)
			(
			(and gNewEventHandler (gNewEventHandler contains: self))
				(gNewEventHandler delete: self)
				(if (gNewEventHandler isEmpty:)
					(gNewEventHandler dispose:)
					(= gNewEventHandler 0)
				)
			)
		)
		(if (& voiceRate $0002) (DoAudio 3))
		(if (or (not argc) param1) (= modNum -1))
		(= initialized 0)
		(if (and (not modeless) (not oldIconBarState))
			(gIconBar enable:)
		)
		(if gTheNewSq4Dialog (gTheNewSq4Dialog dispose:))
		(if (and (& voiceRate $0002) (> curVolume -1))
			(global1 masterVolume: curVolume)
		)
		(if (not modeless) (global1 setCursor: saveCursor 1))
		(if caller
			(= theCaller caller)
			(= caller 0)
			(theCaller cue: cueVal)
		)
		(= y (= x -1))
		(= talkWidth 0)
		(DisposeClone self)
	)
	
	(method (handleEvent pEvent)
		(return
			(cond 
				((super handleEvent: pEvent) (return (super handleEvent: pEvent)))
				((== ticks -1) (return 0))
				(else
					(switch (pEvent type?)
						(evJOYDOWN (= cueVal 0))
						(evMOUSEBUTTON
							(= cueVal (& (pEvent modifiers?) emSHIFT))
						)
						(evKEYBOARD
							(= cueVal (== (pEvent message?) KEY_ESCAPE))
						)
					)
					(if
						(or
							(& (pEvent type?) $4101)
							(and
								(& (pEvent type?) evKEYBOARD)
								(proc999_5 (pEvent message?) 13 27)
							)
						)
						(if (and cueVal msgList)
							(msgList eachElementDo: #delete dispose:)
							(= msgList 0)
						)
						(pEvent claimed: 1)
						(self dispose: disposeWhenDone)
					)
				)
			)
		)
	)
	
	(method (say param1 param2 &tmp newEvent)
		(= voiceRate gOldMsgType)
		(if
			(and
				(not modeless)
				(not (= oldIconBarState (& (gIconBar state?) $0004)))
			)
			(gIconBar disable:)
		)
		(if (not initialized) (self init:))
		(if (== modNum -1) (= modNum gNumber))
		(= caller (if (and (> argc 1) param2) param2 else 0))
		(= curVolume -1)
		(if (& voiceRate $0002)
			(self curVolume: (global1 masterVolume:))
			(if (>= (global1 masterVolume:) 4)
				(global1 masterVolume: (- curVolume 4))
			)
		)
		(if (not modeless)
			(if (!= gCursorNumber 996)
				(= saveCursor (global1 setCursor: gWaitC 1))
			else
				(= saveCursor 996)
			)
		)
		(if (& voiceRate $0001)
			(self startText: modNum noun tVerb param1 tSequence &rest)
		)
		(if (& voiceRate $0002) (self startAudio: param1))
		(cond 
			(modeless
				(gSq4MouseDownHandler addToFront: self)
				(gSq4KeyDownHandler addToFront: self)
				(global78 add: self)
			)
			((IsObject gNewEventHandler) (gNewEventHandler add: self))
			(else
				((= gNewEventHandler (EventHandler new:))
					name: {fastCast}
					add: self
				)
			)
		)
		(= ticks (+ ticks 60 gTixCnt))
		(if (and (not modeless) gNewEventHandler)
			(while gNewEventHandler
				(gNewEventHandler eachElementDo: #doit)
				(if
					(and
						((= newEvent (Event new:)) type?)
						gNewEventHandler
					)
					(gNewEventHandler firstTrue: #handleEvent newEvent)
				)
				(newEvent dispose:)
				(= gTixCnt (+ global86 (GetTime)))
				(global8 eachElementDo: #check)
			)
		)
		(return 1)
	)
	
	(method (startText param1 param2 param3 param4 param5 &tmp [temp0 1000] temp1000)
		(Message
			msgGET
			param1
			talkerNum
			param3
			param4
			param5
			@temp0
		)
		(if (not (& voiceRate $0002))
			(= ticks
				(proc999_3 240 (* 6 (= temp1000 (StrLen @temp0))))
			)
		)
		(if gTheNewSq4Dialog (gTheNewSq4Dialog dispose:))
		(self display: @temp0 &rest)
		(return temp1000)
	)
	
	(method (display &tmp temp0)
		(proc816_1 &rest 111)
	)
	
	(method (startAudio param1 &tmp [temp0 100])
		(= ticks
			(DoAudio 2 modNum talkerNum tVerb param1 tSequence)
		)
	)
)

(class Talker of Narrator
	(properties
		x -1
		y -1
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
		yStep 2
		view -1
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $0000
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		scaleSignal $0000
		scaleX 128
		scaleY 128
		maxScale 128
		cycleSpeed 6
		script 0
		cycler 0
		timer 0
		detailLevel 0
		scaler 0
		caller 0
		disposeWhenDone 1
		ticks 0
		talkWidth 318
		keepWindow 0
		modeless 0
		font 0
		talkerNum 99
		cueVal 0
		initialized 0
		showTitle 0
		msgList 0
		curVolume -1
		saveCursor 0
		voiceRate 0
		tVerb 0
		tSequence 1
		oldIconBarState 0
		bust 0
		eyes 0
		mouth 0
		viewInPrint 0
		textX 0
		textY 0
		useFrame 0
		blinkSpeed 100
	)
	
	(method (init theBust theEyes theMouth)
		(if argc
			(= bust theBust)
			(if (>= argc 2)
				(= eyes theEyes)
				(if (>= argc 3) (= mouth theMouth))
			)
		)
		(self setSize:)
		(super init:)
	)
	
	(method (doit)
		(if (and (super doit:) mouth) (self cycle: mouth))
		(if eyes (self cycle: eyes))
	)
	
	(method (dispose param1)
		(if (and mouth underBits)
			(mouth cel: 0)
			(DrawCel
				(mouth view?)
				(mouth loop?)
				0
				(+ (mouth nsLeft?) nsLeft)
				(+ (mouth nsTop?) nsTop)
				-1
			)
		)
		(if (and mouth (mouth cycler?))
			(if ((mouth cycler?) respondsTo: #cue)
				((mouth cycler?) cue:)
			)
			(mouth setCycle: 0)
		)
		(if (or (not argc) param1)
			(if (and eyes underBits)
				(eyes setCycle: 0 cel: 0)
				(DrawCel
					(eyes view?)
					(eyes loop?)
					0
					(+ (eyes nsLeft?) nsLeft)
					(+ (eyes nsTop?) nsTop)
					-1
				)
			)
			(self hide:)
		)
		(super dispose: param1)
	)
	
	(method (hide)
		(Graph grRESTORE_BOX underBits)
		(= underBits 0)
		(Graph grREDRAW_BOX nsTop nsLeft nsBottom nsRight)
	)
	
	(method (show &tmp temp0)
		(if (not underBits)
			(= underBits
				(Graph grSAVE_BOX nsTop nsLeft nsBottom nsRight 1)
			)
		)
		(= temp0 (PicNotValid))
		(PicNotValid 1)
		(if bust
			(DrawCel
				(bust view?)
				(bust loop?)
				(bust cel?)
				(+ (bust nsLeft?) nsLeft)
				(+ (bust nsTop?) nsTop)
				-1
			)
		)
		(if eyes
			(DrawCel
				(eyes view?)
				(eyes loop?)
				(eyes cel?)
				(+ (eyes nsLeft?) nsLeft)
				(+ (eyes nsTop?) nsTop)
				-1
			)
		)
		(if mouth
			(DrawCel
				(mouth view?)
				(mouth loop?)
				(mouth cel?)
				(+ (mouth nsLeft?) nsLeft)
				(+ (mouth nsTop?) nsTop)
				-1
			)
		)
		(DrawCel view loop cel nsLeft nsTop -1)
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		(PicNotValid temp0)
	)
	
	(method (say)
		(if
		(or (== modNum -1) (and (> view 0) (not underBits)))
			(self init:)
			(if (== modNum -1) (= modNum gNumber))
		)
		(super say: &rest)
	)
	
	(method (startText param1 param2 param3 param4 param5 &tmp temp0)
		(if (not viewInPrint) (self show:))
		(= temp0
			(super
				startText: param1 param2 param3 param4 param5 &rest
			)
		)
		(if (and mouth (not (& voiceRate $0002)))
			(mouth setCycle: RTRandCycle (* 3 temp0))
		)
		(if (and eyes (not (eyes cycler?)))
			(eyes setCycle: Blink blinkSpeed)
		)
	)
	
	(method (display &tmp [temp0 3])
		(proc816_1 &rest 111)
	)
	
	(method (startAudio param1)
		(self show:)
		(if mouth
			(mouth
				setCycle: MouthSync modNum talkerNum tVerb param1 1
			)
			(if (not (mouth cycler?))
				(mouth setCycle: RTRandCycle)
			)
		)
		(super startAudio: param1 &rest)
		(if (and eyes (not (eyes cycler?)))
			(eyes setCycle: Blink blinkSpeed)
		)
	)
	
	(method (cycle param1 &tmp temp0 [temp1 100])
		(if (and param1 (param1 cycler?))
			(= temp0 (param1 cel?))
			((param1 cycler?) doit:)
			(if (!= temp0 (param1 cel?))
				(DrawCel
					(param1 view?)
					(param1 loop?)
					(param1 cel?)
					(+ (param1 nsLeft?) nsLeft)
					(+ (param1 nsTop?) nsTop)
					-1
				)
				(param1
					nsRight:
						(+
							(param1 nsLeft?)
							(CelWide (param1 view?) (param1 loop?) (param1 cel?))
						)
				)
				(param1
					nsBottom:
						(+
							(param1 nsTop?)
							(CelHigh (param1 view?) (param1 loop?) (param1 cel?))
						)
				)
				(Graph
					grUPDATE_BOX
					(+ (param1 nsTop?) nsTop)
					(+ (param1 nsLeft?) nsLeft)
					(+ (param1 nsBottom?) nsTop)
					(+ (param1 nsRight?) nsLeft)
					1
				)
			)
		)
	)
	
	(method (setSize)
		(= nsLeft x)
		(= nsTop y)
		(= nsRight
			(+
				nsLeft
				(proc999_3
					(if view (CelWide view loop cel) else 0)
					(if (IsObject bust)
						(+
							(bust nsLeft?)
							(CelWide (bust view?) (bust loop?) (bust cel?))
						)
					else
						0
					)
					(if (IsObject eyes)
						(+
							(eyes nsLeft?)
							(CelWide (eyes view?) (eyes loop?) (eyes cel?))
						)
					else
						0
					)
					(if (IsObject mouth)
						(+
							(mouth nsLeft?)
							(CelWide (mouth view?) (mouth loop?) (mouth cel?))
						)
					else
						0
					)
				)
			)
		)
		(= nsBottom
			(+
				nsTop
				(proc999_3
					(if view (CelHigh view loop cel) else 0)
					(if (IsObject bust)
						(+
							(bust nsTop?)
							(CelHigh (bust view?) (bust loop?) (bust cel?))
						)
					else
						0
					)
					(if (IsObject eyes)
						(+
							(eyes nsTop?)
							(CelHigh (eyes view?) (eyes loop?) (eyes cel?))
						)
					else
						0
					)
					(if (IsObject mouth)
						(+
							(mouth nsTop?)
							(CelHigh (mouth view?) (mouth loop?) (mouth cel?))
						)
					else
						0
					)
				)
			)
		)
	)
)

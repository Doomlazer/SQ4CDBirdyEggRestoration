;;; Sierra Script 1.0 - (do not remove this comment)
(script# 817)
(include sci.sh)
(use Main)
(use Sq4Dialog)
(use RTRandCycle)
(use Sync)
(use View)
(use Obj)


(class Sq4Narrator of Narrator
	(properties
		x -1
		y -1
		z 0
		heading 0
		noun 100
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
		returnVal 0
		returnVal1 0
		returnVal2 0
		returnVal3 0
		nMsgType -1
		oldMsgType 0
		tpType 0
	)
	
	(method (dispose)
		(if
		(and (> nMsgType -1) (== nMsgType gOldMsgType))
			(= gOldMsgType oldMsgType)
		)
		(switch tpType
			(1
				(if returnVal
					(Display 817 0 108 returnVal)
					(if returnVal1
						(Display 817 0 108 returnVal1)
						(if returnVal2
							(Display 817 0 108 returnVal2)
							(if returnVal3 (Display 817 0 108 returnVal3))
						)
					)
				)
			)
			(2
				(if returnVal
					(proc0_12 returnVal)
					(if returnVal1
						(proc0_12 returnVal1)
						(if returnVal2
							(proc0_12 returnVal2)
							(if returnVal3 (proc0_12 returnVal3))
						)
					)
				)
			)
		)
		(super dispose: &rest)
	)
	
	(method (say)
		(if (> nMsgType -1)
			(= oldMsgType gOldMsgType)
			(= gOldMsgType (if (== oldMsgType 1) 1 else nMsgType))
		)
		(super say: &rest)
	)
	
	(method (startText param1 param2 param3 param4 param5 theTpType)
		(if (< argc 2) (= theTpType 0))
		(super
			startText: param1 param2 param3 param4 param5 (= tpType theTpType) &rest
		)
	)
	
	(method (display &tmp [temp0 100])
		(switch tpType
			(1
				(= returnVal (Display &rest 107 114))
			)
			(2
				(= returnVal (proc0_12 &rest 111))
			)
			(else  (proc816_1 &rest 111))
		)
	)
	
	(method (default)
		(self
			returnVal:
				0
				returnVal1
				0
				returnVal2
				0
				returnVal3
				0
				nMsgType
				-1
				oldMsgType
				0
				x
				-1
				y
				-1
				caller
				0
				modNum
				-1
				disposeWhenDone
				1
				ticks
				0
				talkWidth
				0
				keepWindow
				0
				modeless
				0
				font
				0
				talkerNum
				99
				cueVal
				0
				initialized
				0
				showTitle
				0
				msgList
				0
				curVolume
				0
				saveCursor
				0
				voiceRate
				0
		)
	)
)

(class FaceTalker of Sq4Narrator
	(properties
		x -1
		y -1
		z 0
		heading 0
		noun 100
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
		disposeWhenDone 0
		ticks 0
		talkWidth 318
		keepWindow 0
		modeless 1
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
		returnVal 0
		returnVal1 0
		returnVal2 0
		returnVal3 0
		nMsgType -1
		oldMsgType 0
		tpType 0
		bust 0
		eyes 0
		mouth 0
		viewInPrint 0
		textX 0
		textY 0
		blinkSpeed 100
		finalMouth 4
		sChannel 0
	)
	
	(method (init theBust theEyes theMouth)
		(if argc
			(= bust theBust)
			(if (>= argc 2)
				(= eyes theEyes)
				(if (>= argc 3) (= mouth theMouth))
			)
		)
		(super init:)
	)
	
	(method (dispose param1)
		(if (and mouth (!= finalMouth -1)) (mouth cel: 4))
		(if (and mouth (mouth cycler?))
			(if ((mouth cycler?) respondsTo: #cue)
				((mouth cycler?) cue:)
			)
			(mouth setCycle: 0)
		)
		(if eyes (eyes setCycle: 0 cel: 0))
		(if (or (not argc) param1) (self hide:))
		(super dispose: param1)
	)
	
	(method (hide)
		(if bust (bust hide:))
		(if eyes (eyes hide:))
		(if mouth (mouth hide:))
	)
	
	(method (show)
		(if bust (bust show:))
		(if eyes (eyes show:))
		(if mouth (mouth show:))
	)
	
	(method (startText param1 param2 param3 param4 param5 param6 &tmp temp0)
		(if (not viewInPrint) (self show:))
		(= temp0
			(super
				startText: param1 param2 param3 param4 param5 param6 &rest
			)
		)
		(if mouth (mouth setCycle: RTRandCycle (* 3 temp0)))
		(if (and eyes (not (eyes cycler?)))
			(eyes setCycle: Blink blinkSpeed)
		)
		(return temp0)
	)
	
	(method (startAudio param1)
		(self show:)
		(if mouth
			(mouth setCycle: MouthSync modNum talkerNum 0 param1 1)
		)
		(super startAudio: param1 &rest)
		(if (and eyes (not (eyes cycler?)))
			(eyes setCycle: Blink blinkSpeed)
		)
	)
)

(class Sq4Talker of Talker
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
		cycleSpeed 30
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
		bust 0
		eyes 0
		mouth 0
		viewInPrint 0
		textX 0
		textY 0
		useFrame 0
		blinkSpeed 100
		bustLoop 0
		mouthLoop 1
		eyeLoop 2
		number 0
		mouthOffsetX 0
		mouthOffsetY 0
		eyeOffsetX 0
		eyeOffsetY 0
		client 0
		limitToScreen 1
		sChannel 0
		tStyle 0
		returnVal 0
		returnVal1 0
		returnVal2 0
		returnVal3 0
		nMsgType -1
		oldMsgType 0
		tpType 0
	)
	
	(method (init param1)
		(if argc (self client: param1))
		(super init: &rest)
		(self loop: bustLoop initTopLeft:)
		(if (> bustLoop -1)
			((= bust (Prop new:))
				name: {bust}
				view: view
				loop: bustLoop
				nsLeft: 0
				nsTop: 0
			)
		)
		(if (> eyeLoop -1)
			((= eyes (Prop new:))
				name: {eyes}
				view: view
				loop: eyeLoop
				nsLeft: eyeOffsetX
				nsTop: eyeOffsetY
			)
		)
		(if (> mouthLoop -1)
			((= mouth (Prop new:))
				name: {mouth}
				view: view
				loop: mouthLoop
				nsLeft: mouthOffsetX
				nsTop: mouthOffsetY
			)
		)
		(self setSize:)
		(self modifyNS:)
		(= initialized 1)
	)
	
	(method (dispose &tmp temp0)
		(if
		(and (> nMsgType -1) (== nMsgType gOldMsgType))
			(= gOldMsgType oldMsgType)
		)
		(switch tpType
			(1
				(if returnVal
					(Display returnVal)
					(if returnVal1
						(Display returnVal1)
						(if returnVal2
							(Display returnVal2)
							(if returnVal3 (Display returnVal3))
						)
					)
				)
			)
			(2
				(if returnVal
					(proc0_12 returnVal)
					(if returnVal1
						(proc0_12 returnVal1)
						(if returnVal2
							(proc0_12 returnVal2)
							(if returnVal3 (proc0_12 returnVal3))
						)
					)
				)
			)
		)
		(if disposeWhenDone
			(if bust (bust dispose: delete:) (= bust 0))
			(if eyes (eyes dispose: delete:) (= eyes 0))
			(if mouth (mouth dispose: delete:) (= mouth 0))
		)
		(super dispose: &rest)
	)
	
	(method (say)
		(if (> nMsgType -1)
			(= gOldMsgType
				(if (not (& (= oldMsgType gOldMsgType) $0002))
					(& $fffd nMsgType)
				else
					nMsgType
				)
			)
		)
		(super say: &rest)
	)
	
	(method (startText param1 param2 param3 param4 param5 theTpType &tmp temp0)
		(if (< argc 2) (= theTpType 0))
		(= talkWidth
			(super
				startText: param1 param2 param3 param4 param5 (= tpType theTpType) &rest
			)
		)
	)
	
	(method (display &tmp theTalkWidth temp1)
		(cond 
			((proc999_5 tStyle 0 4 2)
				(= temp1 (= textX (+ nsRight 10)))
				(= textY (+ nsTop 3))
			)
			((proc999_5 tStyle 1 5 3)
				(= textX 3)
				(= temp1 (+ (- nsRight nsLeft) 10))
				(= textY (+ nsTop 3))
			)
		)
		(if (> (+ temp1 talkWidth) 320)
			(= theTalkWidth (- 320 temp1))
		else
			(= theTalkWidth talkWidth)
		)
		(proc816_1 &rest 67 theTalkWidth 64 textX textY 111)
	)
	
	(method (initTopLeft)
		(cond 
			((< tStyle 6)
				(switch tStyle
					(0 (self x: 0 y: 0))
					(1 (self x: 319 y: 0))
					(2 (self x: 0 y: 189))
					(3 (self x: 319 y: 189))
					(4 (self x: 0 y: 94))
					(5 (self x: 319 y: 94))
				)
			)
			((not (if nsTop else nsLeft)) (self x: 159 y: 0))
		)
	)
	
	(method (modifyNS &tmp temp0 temp1 temp2)
		(= temp0 (- nsBottom nsTop))
		(= temp1 (- nsRight nsLeft))
		(cond 
			((< tStyle 666)
				(self
					nsLeft: (proc999_2 (proc999_3 10 nsLeft) (- 319 (+ 10 temp1)))
					nsTop:
						(if (or (== tStyle 5) (== tStyle 4))
							(- (self nsTop?) (/ temp0 2))
						else
							(proc999_2 (proc999_3 10 nsTop) (- 189 (+ 10 temp0)))
						)
				)
			)
			(limitToScreen
				(self
					nsLeft: (proc999_2 (proc999_3 0 nsLeft) (- 319 temp1))
					nsTop: (proc999_2 (proc999_3 0 nsTop) (- 189 temp0))
				)
			)
		)
		(self
			nsRight: (+ nsLeft temp1)
			nsBottom: (+ nsTop temp0)
		)
	)
)

(class Sq4GlobalNarrator of Sq4Narrator
	(properties
		x -1
		y -1
		z 0
		heading 0
		noun 100
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
		returnVal 0
		returnVal1 0
		returnVal2 0
		returnVal3 0
		nMsgType -1
		oldMsgType 0
		tpType 0
		defaultOnDispose 1
	)
	
	(method (dispose)
		(super dispose: &rest)
		(if defaultOnDispose (self default:))
	)
)

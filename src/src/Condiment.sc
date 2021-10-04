;;; Sierra Script 1.0 - (do not remove this comment)
(script# 387)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Dialog)
(use Sq4Narrator)
(use Sq4Feature)
(use n958)
(use Sound)
(use Cycle)
(use User)
(use Obj)

(public
	rm387 0
)

(local
	local0
	local1 =  68
	local2 =  3
	local3
	local4
	local5
	local6
	local7
	[local8 7] = [41 42 43 44 45 46 47]
	local15 =  3
	local16 =  1
	local17
	theGPseudoMouse
)
(procedure (localproc_01c2 param1)
	(if
		(or
			(== (lettuce followWho?) 1)
			(== (pickle followWho?) 1)
			(== (bun followWho?) 1)
			(== (mayo followWho?) 1)
			(== (must followWho?) 1)
			(== (cats followWho?) 1)
			(param1 followWho?)
		)
		0
	else
		(param1 follow: 1)
	)
)

(procedure (localproc_040c param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 [temp11 5])
	(= temp2 (proc0_18 global158 global155))
	(= temp8 14)
	(= temp4 (proc0_18 global130 global130))
	(= temp7 (proc0_18 global161 global130))
	(= temp6 (proc0_18 global157 global156))
	(= temp5 (proc0_18 global156 global156))
	(= temp1 3)
	(= temp9 2)
	(= temp3 3)
	(= temp0 (GetPort))
	(SetPort 0)
	(Graph
		grFILL_BOX
		param1
		param2
		(+ param3 1)
		(+ param4 1)
		temp3
		temp2
		temp8
	)
	(= param1 (- param1 temp1))
	(= param2 (- param2 temp1))
	(= param4 (+ param4 temp1))
	(= param3 (+ param3 temp1))
	(Graph
		grFILL_BOX
		param1
		param2
		(+ param1 temp1)
		param4
		temp3
		temp4
		temp8
	)
	(Graph
		grFILL_BOX
		(- param3 temp1)
		param2
		param3
		param4
		temp3
		temp5
		temp8
	)
	(= temp10 0)
	(while (< temp10 temp1)
		(Graph
			grDRAW_LINE
			(+ param1 temp10)
			(+ param2 temp10)
			(- param3 (+ temp10 1))
			(+ param2 temp10)
			temp7
			temp8
		)
		(Graph
			grDRAW_LINE
			(+ param1 temp10)
			(- param4 (+ temp10 1))
			(- param3 (+ temp10 1))
			(- param4 (+ temp10 1))
			temp6
			temp8
		)
		(++ temp10)
	)
	(Graph
		grFILL_BOX
		(+ param1 temp9)
		param4
		(+ param3 temp9)
		(+ param4 temp9)
		temp3
		0
		temp8
	)
	(Graph
		grFILL_BOX
		param3
		(+ param2 temp9)
		(+ param3 temp9)
		param4
		temp3
		0
		temp8
	)
	(Graph
		grUPDATE_BOX
		param1
		param2
		(+ param3 2)
		(+ param4 2)
		1
	)
	(SetPort temp0)
)

(instance rm387 of SQRoom
	(properties
		picture 387
	)
	
	(method (init)
		(self setRegions: 700)
		(= theGPseudoMouse gPseudoMouse)
		(proc958_0 132 41 101 122)
		(HandsOnCode doit:)
		(super init:)
		(gEgo setCycle: 0)
		(burger init:)
		(lettuce init: rePosn: condoList: cList)
		(pickle init: rePosn: condoList: cList)
		(bun init: rePosn: condoList: cList)
		(mayo init: rePosn: mySound: squirtSound condoList: cList)
		(cats init: rePosn: mySound: squirtSound condoList: cList)
		(must init: rePosn: mySound: squirtSound condoList: cList)
		(keyHandler
			add: lettuceBay pickleBay mayoBay mustBay catsBay bunBay
			target: burger
			init:
		)
		(dr init:)
		(rejectSign init: stopUpd:)
		(if (> (global1 detailLevel:) 1)
			(conveyor init: setCycle: Fwd)
		)
		(grabber init: stopUpd:)
		(lettuceBay init:)
		(pickleBay init:)
		(bunBay init:)
		(belt init:)
		(topCounter init:)
		(bottomCounter init:)
		(upperPipes init:)
		(redTube init:)
		(lowerPipes init:)
		(hood init:)
		(readSignFeat init:)
		(self setScript: instructScript)
	)
	
	(method (doit)
		(if (GameIsRestarting) (restoreCode doit:))
		(super doit:)
	)
	
	(method (dispose)
		(if global25 (global25 dispose:))
		(cList delete: dispose:)
		(keyHandler delete: dispose:)
		(= gPseudoMouse theGPseudoMouse)
		(super dispose:)
	)
)

(instance HandsOnCode of Code
	(properties)
	
	(method (doit)
		(User canControl: 1 canInput: 1)
		(gIconBar enable: 0 1 2 3 4 5 6 7)
		(if (not (gIconBar curInvIcon?)) (gIconBar disable: 6))
		(global1 setCursor: ((gIconBar curIcon?) cursor?))
		(gIconBar disable: 0)
	)
)

(instance HandsOffCode of Code
	(properties)
	
	(method (doit)
		(User canControl: 0 canInput: 0)
		(gIconBar disable: 0 1 2 3 4 5 6 7)
	)
)

(instance restoreCode of Code
	(properties)
	
	(method (doit &tmp [temp0 15] [temp15 5])
		(localproc_040c 170 7 184 87)
		(= local5
			(proc0_12 {Pay:} 64 9 173 25 global132 26 global129 27 0)
		)
		(= local4
			(proc0_12
				(Format @temp15 387 0 local3)
				64
				43
				173
				25
				global137
				26
				global129
				27
				0
			)
		)
		(localproc_040c 170 222 184 312)
		(= local6
			(proc0_12
				{'R' to Read Sign}
				64
				225
				173
				25
				global135
				26
				global129
				27
				0
			)
		)
	)
)

(class Condiment of Sq4View
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
		yStep 2
		view -1
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $0101
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
		lookStr 0
		myX 0
		myY 0
		myPri 0
		mySound 0
		staticLoop 0
		staticCel 0
		cursorLoop 0
		cursorCel 0
		targetLoop 0
		targetCel 0
		followWho 0
		condoList 0
	)
	
	(method (doit &tmp userCurEvent)
		(cond 
			((not followWho) 0)
			((IsObject followWho) (self x: (followWho x?) y: (- (followWho y?) 14)))
			((!= gCursorNumber 68) (self rePosn:))
			(
				(not
					(& ((= userCurEvent (User curEvent?)) type?) $0007)
				)
				(GlobalToLocal userCurEvent)
				(self x: (userCurEvent x?) y: (+ (userCurEvent y?) 10))
			)
		)
		(super doit:)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(4 (localproc_01c2 self))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (rePosn)
		(self
			x: myX
			y: myY
			loop: staticLoop
			cel: staticCel
			setPri: myPri
			followWho: 0
		)
	)
	
	(method (follow theFollowWho)
		(= followWho theFollowWho)
		(if (IsObject followWho)
			(condoList addToFront: self)
			(if mySound (mySound play:))
			(self
				setPri: (+ (condoList size?) 1)
				followWho: theFollowWho
				loop: targetLoop
				cel: targetCel
			)
			(keyHandler setTarget: 0)
		else
			(self loop: cursorLoop cel: cursorCel setPri: 15)
			(= local1 (global1 setCursor: 68 1))
		)
	)
)

(class BurgerKeys of Set
	(properties
		elements 0
		size 0
		curFeat 0
		curLevel 0
		target 0
	)
	
	(method (init)
		(gSq4DirectionHandler addToFront: self)
		(self restart:)
	)
	
	(method (dispose)
		(gSq4DirectionHandler delete: self)
		(super dispose: &rest)
	)
	
	(method (handleEvent pEvent &tmp pEventMessage)
		(= pEventMessage (pEvent message?))
		(pEvent claimed: 1)
		(cond 
			(
				(or
					(not (& (pEvent type?) evJOYSTICK))
					(not (User canInput:))
				)
				(pEvent claimed: 0)
			)
			((proc999_5 pEventMessage 1 5 18432 20480) (self changeLevel:))
			((proc999_5 pEventMessage 3 19712) (self advance:))
			((proc999_5 pEventMessage 7 19200) (self retreat:))
		)
	)
	
	(method (advance &tmp theCurFeat)
		(= theCurFeat (self at: (+ 1 (self indexOf: curFeat))))
		(if (not (IsObject theCurFeat))
			(= theCurFeat (NodeValue (self first:)))
		)
		(= curFeat theCurFeat)
		(self changeLevel: 0)
	)
	
	(method (retreat &tmp theCurFeat)
		(= theCurFeat (self at: (- (self indexOf: curFeat) 1)))
		(if (not (IsObject theCurFeat))
			(= theCurFeat (NodeValue (self last:)))
		)
		(= curFeat theCurFeat)
		(self changeLevel: 0)
	)
	
	(method (changeLevel param1)
		(if
		(= curLevel (if argc param1 else (not curLevel)))
			(= curLevel 1)
			(self setTarget: followTarget)
		else
			(= curLevel 0)
			(self setTarget: 0)
			(global1
				setCursor: gCursorNumber 1 (curFeat x?) (curFeat y?)
			)
		)
	)
	
	(method (setTarget param1)
		(if (not argc) (= param1 0))
		(target code: param1)
		(if param1 (param1 doit:))
	)
	
	(method (restart)
		(= curFeat (NodeValue (self first:)))
		(self changeLevel: 0)
	)
)

(instance followTarget of Code
	(properties)
	
	(method (doit &tmp temp0)
		(if (User canInput:)
			(= temp0 ((keyHandler target?) x?))
			(if (> ((keyHandler target?) xStep?) 5)
				(= temp0 (+ temp0 5))
			)
			(global1
				setCursor: gCursorNumber 1 temp0 (- ((keyHandler target?) y?) 14)
			)
		else
			(keyHandler restart:)
		)
	)
)

(instance instructScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 1))
			(1
				(restoreCode doit:)
				(tPig say: 1 self)
			)
			(2 (tPig say: 2 self))
			(3
				(burgerMusic number: [local8 local7] changeState: play:)
				(client setScript: burgerScript)
				(gIconBar curIcon: (gIconBar at: 2))
				(global1 setCursor: ((gIconBar curIcon?) cursor?))
			)
		)
	)
)

(instance readSignCode of Code
	(properties)
	
	(method (doit)
		(proc816_1 387 1)
		(proc816_1 387 2)
		(proc816_1 387 3)
	)
)

(instance burgerScript of Script
	(properties)
	
	(method (changeState newState &tmp gIconBarCurIcon)
		(switch (= state newState)
			(0 (= cycles 1))
			(1
				(if (not (HaveMouse))
					(global1
						setCursor:
							gCursorNumber
							1
							((keyHandler curFeat?) x?)
							((keyHandler curFeat?) y?)
					)
				)
				(= cycles 1)
			)
			(2
				(grabSound number: 160 play:)
				(dr setCycle: End self)
			)
			(3
				(dr cel: 0)
				(burger
					show:
					setLoop: 0
					cel: 0
					posn: 14 109
					setMotion: MoveTo 266 109 self
				)
			)
			(4
				(gEgo setMotion: 0)
				(= gIconBarCurIcon (gIconBar curIcon?))
				(HandsOffCode doit:)
				(gIconBar curIcon: gIconBarCurIcon)
				(global1 setCursor: gWaitC 1)
				(keyHandler restart:)
				(burger hide:)
				(= register
					(if
						(and
							(== (cList indexOf: bun) 0)
							(!= (cList indexOf: lettuce) -1)
							(!= (cList indexOf: pickle) -1)
							(!= (cList indexOf: mayo) -1)
							(!= (cList indexOf: must) -1)
						)
						(!= (cList indexOf: cats) -1)
					else
						0
					)
				)
				(lettuce rePosn:)
				(pickle rePosn:)
				(bun rePosn:)
				(mayo rePosn:)
				(must rePosn:)
				(cats rePosn:)
				(cList release:)
				(global1 setCursor: local1 1)
				(grabber setLoop: 2 cel: 0 setCycle: End self)
				(grabSound number: 136 play:)
				(grabSound2 play:)
			)
			(5
				(grabSound number: 138 play:)
				(grabSound2 stop:)
				(burger setLoop: 5 cel: 0 posn: 266 27 show:)
				(grabber setLoop: 3 cel: 0 setCycle: End self)
			)
			(6
				(grabber stopUpd:)
				(if register
					(self setScript: goodBurgerScript self)
				else
					(self setScript: rejectScript self)
				)
			)
			(7
				(cond 
					((or (== local0 10) (== local17 5)) (client setScript: yurHistoryScript))
					((not (-- local2))
						(= local2 (++ local15))
						(if (burger moveSpeed?)
							(burger moveSpeed: (- (burger moveSpeed?) 1))
						else
							(burger xStep: (+ (burger xStep?) 1))
						)
						(if (< (++ local7) 7)
							(burgerMusic number: [local8 local7] changeState: play:)
							(UnLoad 132 [local8 (- local7 1)])
						)
						(= cycles 1)
					)
					(else (= cycles 1))
				)
			)
			(8
				(HandsOnCode doit:)
				(global1 setCursor: ((gIconBar curIcon?) cursor?))
				(gIconBar disable: 0)
				(self start: 2 init:)
			)
		)
	)
)

(instance goodBurgerScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 5])
		(switch (= state newState)
			(0
				(proc0_12 local4)
				(proc0_12 local5)
				(proc0_12 local6)
				(= local3 (+ local3 local16))
				(restoreCode doit:)
				(gEgo get: 0)
				(= global159 (+ global159 local16))
				(= global172 (+ global172 local16))
				(= register (burger moveSpeed?))
				(= local17 0)
				(burger
					moveSpeed: 0
					setMotion: MoveTo (burger x?) -10 self
				)
			)
			(1
				(burger moveSpeed: register)
				(self dispose:)
			)
		)
	)
)

(instance rejectScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 2))
			(1
				(rejectSign startUpd: setScript: signScript)
				(= seconds 2)
			)
			(2
				(burger setCycle: End)
				(grabSound number: 139 play:)
				(= seconds 3)
			)
			(3
				(rejectSign setScript: 0 setCycle: 0 cel: 0 stopUpd:)
				(= seconds 2)
			)
			(4
				(++ local0)
				(++ local17)
				(self dispose:)
			)
		)
	)
)

(instance signScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 2)
				(rejectSound play:)
				(= cycles 5)
			)
			(1
				(client cel: 0)
				(= cycles 5)
			)
			(2 (self init:))
		)
	)
)

(instance yurHistoryScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (global2 newRoom: 385))
			(1 (self dispose:))
		)
	)
)

(instance burgerMusic of Sound
	(properties
		priority 1
		loop -1
	)
)

(instance rejectSound of Sound
	(properties
		number 101
		priority 2
	)
)

(instance squirtSound of Sound
	(properties
		number 122
		priority 3
	)
)

(instance grabSound of Sound
	(properties
		number 136
		priority 3
	)
)

(instance grabSound2 of Sound
	(properties
		number 137
		priority 3
	)
)

(instance readSignFeat of Sq4Feature
	(properties
		nsTop 168
		nsLeft 230
		nsBottom 187
		nsRight 315
	)
	
	(method (init)
		(gSq4KeyDownHandler add: self)
		(super init:)
	)
	
	(method (dispose)
		(gSq4KeyDownHandler delete: self)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		(if
			(and
				(not (pEvent claimed?))
				(& (pEvent type?) evKEYBOARD)
				(proc999_5 (pEvent message?) 114 82)
			)
			(readSignCode doit:)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (tButton say: 1))
			(else  (readSignCode doit:))
		)
	)
)

(instance cList of List
	(properties)
)

(instance keyHandler of BurgerKeys
	(properties)
)

(instance lettuceBay of Sq4Feature
	(properties
		x 70
		y 131
		nsTop 118
		nsLeft 55
		nsBottom 146
		nsRight 85
		lookStr {Lettuce.}
	)
	
	(method (doVerb theVerb)
		(lettuce doVerb: theVerb)
	)
)

(instance pickleBay of Sq4Feature
	(properties
		x 111
		y 131
		nsTop 118
		nsLeft 95
		nsBottom 146
		nsRight 126
		lookStr 14
	)
	
	(method (doVerb theVerb)
		(pickle doVerb: theVerb)
	)
)

(instance mayoBay of Sq4Feature
	(properties
		x 153
		y 129
	)
)

(instance mustBay of Sq4Feature
	(properties
		x 185
		y 129
	)
)

(instance catsBay of Sq4Feature
	(properties
		x 218
		y 129
	)
)

(instance bunBay of Sq4Feature
	(properties
		x 258
		y 126
		nsTop 118
		nsLeft 245
		nsBottom 146
		nsRight 275
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 16))
			(7 (gSq4GlobalNarrator say: 5))
			(6 (gSq4GlobalNarrator say: 6))
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance mayo of Condiment
	(properties
		noun 26
		view 387
		signal $6010
		lookStr {Squeeze me for a plop of mayonnaise.}
		myX 153
		myY 129
		myPri 10
		staticLoop 8
		cursorLoop 9
		targetCel 3
	)
	
	(method (doVerb theVerb param2)
		(tCONDIM
			noun: 26
			modNum: 387
			view: 3876
			z: 400
			mouthOffsetX: 17
			mouthOffsetY: 52
			eyeOffsetX: 17
			eyeOffsetY: 39
			talkerNum: 26
		)
		(switch theVerb
			(1
				(if (Random 0 10)
					(tCONDIM say: 2)
				else
					(tCONDIM say: 4)
				)
			)
			(7 (tCONDIM say: 3))
			(6 (tCONDIM say: 5))
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance must of Condiment
	(properties
		view 387
		signal $6010
		lookStr {Squeeze me for a plop of mustard.}
		myX 185
		myY 129
		myPri 10
		staticLoop 8
		staticCel 1
		cursorLoop 9
		cursorCel 1
		targetCel 4
	)
	
	(method (doVerb theVerb param2)
		(tCONDIM
			noun: 27
			modNum: 387
			view: 3875
			z: 400
			mouthOffsetX: 25
			mouthOffsetY: 53
			eyeOffsetX: 19
			eyeOffsetY: 41
			talkerNum: 27
		)
		(switch theVerb
			(1 (tCONDIM say: 2))
			(7 (tCONDIM say: 3))
			(6 (tCONDIM say: 4))
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance cats of Condiment
	(properties
		noun 28
		view 387
		signal $6010
		lookStr {Squeeze me for a plop of catsup.}
		myX 218
		myY 129
		myPri 10
		staticLoop 8
		staticCel 2
		cursorLoop 9
		cursorCel 2
		targetCel 5
	)
	
	(method (doVerb theVerb param2)
		(tCONDIM
			noun: 28
			modNum: 387
			view: 3874
			z: 400
			mouthOffsetX: 23
			mouthOffsetY: 55
			eyeOffsetX: 19
			eyeOffsetY: 40
			talkerNum: 28
		)
		(switch theVerb
			(1 (tCONDIM say: 2))
			(7 (tCONDIM say: 3))
			(6 (tCONDIM say: 4))
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance lettuce of Condiment
	(properties
		noun 101
		view 387
		signal $6010
		lookStr 13
		myX 71
		myY 131
		myPri 10
		staticCel 1
		cursorCel 1
		targetCel 1
	)
	
	(method (doVerb theVerb param2)
		(tCONDIM
			noun: 101
			modNum: 387
			view: 3873
			z: 400
			mouthOffsetX: 25
			mouthOffsetY: 36
			eyeOffsetX: 30
			eyeOffsetY: 26
			talkerNum: 37
		)
		(switch theVerb
			(1 (tCONDIM say: 2))
			(7 (tCONDIM say: 3))
			(6 (tCONDIM say: 4))
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance pickle of Condiment
	(properties
		noun 102
		view 387
		signal $6010
		lookStr 14
		myX 111
		myY 131
		myPri 10
		staticCel 2
		cursorCel 2
		targetCel 2
	)
	
	(method (doVerb theVerb param2)
		(tCONDIM
			noun: 102
			modNum: 387
			view: 3872
			z: 400
			mouthOffsetX: 13
			mouthOffsetY: 36
			eyeOffsetX: 23
			eyeOffsetY: 18
			talkerNum: 36
		)
		(switch theVerb
			(1 (tCONDIM say: 2))
			(7 (tCONDIM say: 3))
			(6 (tCONDIM say: 4))
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance bun of Condiment
	(properties
		noun 100
		view 387
		signal $6010
		myX 259
		myY 127
		myPri 10
		staticCel 6
		cursorCel 6
		targetCel 6
	)
	
	(method (doVerb theVerb param2)
		(tCONDIM
			noun: 100
			modNum: 387
			view: 3871
			z: 400
			mouthOffsetX: 10
			mouthOffsetY: 23
			eyeOffsetX: 19
			eyeOffsetY: 11
			talkerNum: 35
		)
		(switch theVerb
			(1 (tCONDIM say: 2))
			(7 (tCONDIM say: 3))
			(6 (tCONDIM say: 4))
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance burger of Sq4Actor
	(properties
		x 14
		y 109
		view 387
		priority 1
		signal $6810
		lookStr 17
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 17))
			(4
				(cond 
					((== (lettuce followWho?) 1) (lettuce follow: self) (global1 setCursor: local1 1))
					((== (pickle followWho?) 1) (pickle follow: self) (global1 setCursor: local1 1))
					((== (bun followWho?) 1) (bun follow: self) (global1 setCursor: local1 1))
					((== (mayo followWho?) 1) (mayo follow: self) (global1 setCursor: local1 1))
					((== (must followWho?) 1) (must follow: self) (global1 setCursor: local1 1))
					((== (cats followWho?) 1) (cats follow: self) (global1 setCursor: local1 1))
				)
			)
			(7 (gSq4GlobalNarrator say: 18))
			(6 (gSq4GlobalNarrator say: 19))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dr of Sq4Prop
	(properties
		x 60
		y 115
		view 387
		loop 7
		priority 1
		signal $0010
	)
)

(instance grabber of Sq4Prop
	(properties
		x 255
		y 46
		view 387
		loop 3
		cel 6
		priority 8
		signal $4010
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 29))
			(7 (gSq4GlobalNarrator say: 20))
			(6 (gSq4GlobalNarrator say: 23))
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance conveyor of Sq4Prop
	(properties
		x 287
		y 108
		view 387
		loop 6
		priority 1
		signal $0010
	)
)

(instance rejectSign of Sq4Prop
	(properties
		x 186
		y 33
		sightAngle 180
		view 387
		loop 4
		priority 1
		signal $0010
		lookStr 21
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 21))
			(7 (gSq4GlobalNarrator say: 22))
			(6 (gSq4GlobalNarrator say: 23))
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance belt of Sq4Feature
	(properties
		x 165
		y 91
		nsTop 69
		nsLeft 32
		nsBottom 113
		nsRight 298
		lookStr 24
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 24))
			(7 (gSq4GlobalNarrator say: 25))
			(6 (gSq4GlobalNarrator say: 26))
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance topCounter of Sq4Feature
	(properties
		x 213
		y 22
		nsLeft 107
		nsBottom 44
		nsRight 319
		lookStr 27
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 27))
			(7 (gSq4GlobalNarrator say: 28))
			(6 (gSq4GlobalNarrator say: 28))
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance bottomCounter of Sq4Feature
	(properties
		x 163
		y 10
		nsTop 114
		nsLeft 42
		nsBottom 159
		nsRight 285
		lookStr 27
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 27))
			(7 (gSq4GlobalNarrator say: 28))
			(6 (gSq4GlobalNarrator say: 28))
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance upperPipes of Sq4Feature
	(properties
		x 18
		y 53
		nsTop 38
		nsBottom 69
		nsRight 37
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 33))
			(7 (gSq4GlobalNarrator say: 29))
			(6 (gSq4GlobalNarrator say: 30))
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance redTube of Sq4Feature
	(properties
		x 5
		y 91
		nsTop 69
		nsBottom 114
		nsRight 11
		lookStr 31
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 31))
			(7 (gSq4GlobalNarrator say: 29))
			(6 (gSq4GlobalNarrator say: 30))
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance lowerPipes of Sq4Feature
	(properties
		x 18
		y 132
		nsTop 115
		nsBottom 149
		nsRight 36
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 70 say: 19)
			)
			(7 (gSq4GlobalNarrator say: 29))
			(6 (gSq4GlobalNarrator say: 30))
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance hood of Sq4Feature
	(properties
		x 21
		y 92
		nsTop 70
		nsLeft 11
		nsBottom 114
		nsRight 31
		lookStr 32
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 32))
			(7 (gSq4GlobalNarrator say: 33))
			(6 (gSq4GlobalNarrator say: 34))
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance tROGER of Sq4Talker
	(properties
		z 400
		noun 7
		view 1008
		talkerNum 7
		mouthOffsetX 26
		mouthOffsetY 32
		eyeOffsetX 25
		eyeOffsetY 21
	)
)

(instance tCONDIM of Sq4Talker
	(properties
		z 400
		noun 26
		view 3876
		talkerNum 7
		mouthOffsetX 26
		mouthOffsetY 32
		eyeOffsetX 25
		eyeOffsetY 21
	)
)

(instance tButton of Sq4Narrator
	(properties
		noun 25
		talkerNum 25
	)
)

(instance tPig of Sq4Narrator
	(properties
		noun 24
		talkerNum 24
	)
)

;;; Sierra Script 1.0 - (do not remove this comment)
(script# 398)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Dialog)
(use Sq4Narrator)
(use Sq4Feature)
(use User)
(use Obj)

(public
	rm398 0
)

(local
	local0
	local1
	theBoxProp
	theTheBoxProp
	local4
	boxPropBoxID
	local6
	local7
	local8
	theBoxProp_2
	local10
	local11
	[local12 100]
	[local112 30]
	[local142 30]
	[local172 30]
	[local202 30]
	[local232 40]
	[local272 40]
)
(instance rm398 of SQRoom
	(properties
		picture 398
	)
	
	(method (init)
		(myIcon init:)
		(super init:)
		(proc0_3)
		(theRoom init:)
		(= local10 global34)
		(= global34 0)
		(box1 posn: 218 125 init: stopUpd:)
		(box2 posn: 175 123 init: stopUpd:)
		(box3 posn: 50 150 init: stopUpd:)
		(box5 posn: 130 143 init: stopUpd:)
		(box6 posn: 216 83 init: stopUpd:)
		(box7 posn: 142 94 init: stopUpd:)
		(box9 posn: 152 164 init: stopUpd:)
		(if (not (proc0_6 31))
			(box10 posn: 186 128 init: stopUpd:)
		)
		(= local4 11)
		(global5 eachElementDo: #perform syncPriority)
		(= local11 global199)
		(= global199 0)
		(gIconBar disable: 0 3 4 5 6)
	)
	
	(method (dispose)
		(gIconBar enable:)
		(= global34 local10)
		(= global199 local11)
		(super dispose:)
	)
)

(instance showBox of Script
	(properties)
	
	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if
			(and
				(or
					(== (= temp0 ((User curEvent?) type?)) 1)
					(== temp0 4)
				)
				state
			)
			(= temp0 0)
			(self cue:)
		)
	)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gIconBar disable:)
				(global2 drawPic: (+ 699 boxPropBoxID) 100)
				(global5 eachElementDo: #hide)
				(scriptHandleEvent init:)
				(= cycles 1)
			)
			(1
				(switch boxPropBoxID
					(1
						(salesPitch talkWidth: 160 x: 160 y: 10 say: 1 self)
					)
					(2
						(salesPitch talkWidth: 160 x: 160 y: 10 say: 2 self)
					)
					(3
						(salesPitch talkWidth: 160 x: 160 y: 10 say: 3 self)
					)
					(4
						(salesPitch talkWidth: 170 x: 150 y: 1 say: 4 self)
					)
					(5
						(salesPitch talkWidth: 160 x: 160 y: 10 say: 5 self)
					)
					(6
						(salesPitch talkWidth: 160 x: 160 y: 10 say: 6 self)
					)
					(7
						(salesPitch talkWidth: 160 x: 160 y: 5 say: 7 self)
					)
					(8
						(salesPitch talkWidth: 160 x: 160 y: 5 say: 8 self)
					)
					(9
						(salesPitch talkWidth: 160 x: 160 y: 5 say: 9 self)
					)
					(10
						(salesPitch talkWidth: 160 x: 160 y: 5 say: 10 self)
					)
				)
			)
			(2
				(Message msgGET 398 97 0 1 1 @local12)
				(Message msgGET 398 97 0 2 1 @local112)
				(Message msgGET 398 97 0 3 1 @local142)
				(Message msgGET 398 97 0 4 1 @local172)
				(Message msgGET 398 97 0 13 1 @local202)
				(switch
					(proc816_1
						@local12
						27
						0
						78
						@local112
						0
						78
						@local142
						1
						78
						@local172
						2
						78
						@local202
						3
					)
					(0
						(Message msgGET 398 99 0 14 1 @local272)
						(Format @local232 @local272 (theBoxProp_2 myPrice?))
						(= temp0
							(Display @local232 100 20 180 106 120 102 global132 107)
						)
						(= state (- state 1))
						(= cycles 1)
					)
					(1
						(if (!= boxPropBoxID 4)
							(gSq4GlobalNarrator say: 12)
							(= state (- state 1))
							(= cycles 1)
						else
							(gEgo get: 8)
							(gEgo get: 9)
							(= theBoxProp 0)
							(= gBoxPropBoxID boxPropBoxID)
							(box10 dispose:)
						)
					)
					(2 0)
					(3
						(gIconBar enable:)
						(global2 newRoom: 397)
					)
				)
				(scriptHandleEvent dispose:)
				(= cycles 1)
			)
			(3
				(gIconBar disable:)
				(Display 398 0 108 temp0)
				(= cycles 1)
			)
			(4
				(global5 eachElementDo: #show)
				(global2 drawPic: 398)
				(= cycles 1)
			)
			(5
				(gIconBar enable:)
				(client setScript: 0)
			)
		)
	)
)

(instance syncPriority of Code
	(properties)
	
	(method (doit param1)
		(param1 setPri: (-- local4))
	)
)

(class boxProp of Sq4Prop
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
		lookStr 0
		boxID 0
		pIndex -1
		tooHigh 0
		myPrice 0
	)
	
	(method (init)
		(super init:)
		(if (== boxID 4)
			(self myPrice: 5)
		else
			(self myPrice: (+ global159 (Random 1 15)))
		)
		(if (== gBoxPropBoxID (self boxID?))
			(self delete:)
			(self dispose:)
		)
	)
	
	(method (doit &tmp userCurEvent [temp1 2])
		(super doit:)
		(if
			(and
				(== theBoxProp self)
				(== ((gIconBar curIcon?) message?) 4)
			)
			(= local0 ((= userCurEvent (User curEvent?)) x?))
			(= local1 (+ (userCurEvent y?) 10))
			(if (> local0 235) (= local0 235))
			(if (< local0 50) (= local0 50))
			(if (> local1 155) (= local1 155))
			(self x: local0 y: local1)
		)
		(if (== (self tooHigh?) 1)
			(if (< (self y?) (Random 110 160))
				(self y: (+ (self y?) 15) startUpd:)
			else
				(self stopUpd:)
				(= tooHigh 0)
			)
		)
	)
	
	(method (doVerb theVerb)
		(cond 
			((== theVerb 4)
				(cond 
					((== theBoxProp 0)
						(self startUpd:)
						(= theBoxProp self)
						(self doit:)
						(global5 delete: self)
						(global5 addToFront: self)
						(self pIndex: 12)
					)
					((== theBoxProp self)
						(if (!= theBoxProp theTheBoxProp)
							(= theTheBoxProp theBoxProp)
							(= local4 11)
							(global5 eachElementDo: #perform syncPriority)
						)
						(= theBoxProp 0)
						(self pIndex: 11 stopUpd:)
						(if (< (self y?) 90) (= tooHigh 1))
					)
				)
				(self setPri: pIndex)
			)
			((== theVerb 1)
				(if (and (!= theBoxProp 0) (!= theBoxProp self))
					0
				else
					(= boxPropBoxID (self boxID?))
					(= theBoxProp_2 self)
					(global2 setScript: showBox)
				)
			)
			(else (super doVerb: theVerb))
		)
	)
	
	(method (onMe param1 param2 &tmp temp0 temp1 temp2 temp3)
		(if (IsObject param1)
			(= temp0 (param1 x?))
			(= temp1 (param1 y?))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(= temp3
			(if
				(or
					(not (super onMe: temp0 temp1))
					(== theBoxProp self)
				)
			else
				(&
					(= temp2 (OnControl 2 temp0 temp1))
					(<< $0001 priority)
				)
			)
		)
	)
)

(instance box1 of boxProp
	(properties
		view 399
		boxID 1
	)
)

(instance box2 of boxProp
	(properties
		view 399
		cel 1
		boxID 2
	)
)

(instance box3 of boxProp
	(properties
		view 399
		cel 2
		boxID 3
	)
)

(instance box10 of boxProp
	(properties
		view 399
		cel 3
		boxID 4
	)
)

(instance box5 of boxProp
	(properties
		view 399
		cel 4
		boxID 5
	)
)

(instance box6 of boxProp
	(properties
		view 399
		cel 5
		boxID 6
	)
)

(instance box7 of boxProp
	(properties
		view 399
		cel 6
		boxID 7
	)
)

(instance box9 of boxProp
	(properties
		view 399
		cel 8
		boxID 9
	)
)

(instance theRoom of Sq4Feature
	(properties
		x 159
		y 94
		nsTop -1
		nsBottom 189
		nsRight 319
		sightAngle 90
	)
)

(instance myIcon of Sq4Prop
	(properties
		x 280
		y 30
		view 399
		loop 1
	)
	
	(method (doVerb)
		(self setScript: doneWasClicked)
	)
)

(instance doneWasClicked of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(myIcon setCel: 1)
				(= cycles 3)
			)
			(1
				(myIcon setCel: 0)
				(= cycles 1)
			)
			(2
				(global2 newRoom: 397)
				(self dispose:)
			)
		)
	)
)

(instance salesPitch of Sq4Narrator
	(properties
		noun 99
		modNum 398
		modeless 1
		nMsgType 3
	)
	
	(method (dispose)
		(Display 398 0 108 local6)
		(super dispose: &rest)
	)
	
	(method (display theText)
		(= local6
			(Display
				theText
				106
				talkWidth
				100
				x
				y
				101
				0
				105
				68
				102
				global132
				107
			)
		)
	)
)

(instance scriptHandleEvent of Sq4Feature
	(properties)
	
	(method (handleEvent pEvent)
		(pEvent claimed: 1)
		(= local8 1)
	)
)

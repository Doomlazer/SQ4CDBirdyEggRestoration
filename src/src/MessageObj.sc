;;; Sierra Script 1.0 - (do not remove this comment)
(script# 925)
(include sci.sh)
(use Main)
(use Print)
(use Obj)


(class MessageObj of Obj
	(properties
		modNum -1
		noun 0
		verb 0
		case 0
		sequence 0
		whoSays 0
		client 0
		caller 0
		font 0
		x 0
		y 0
	)
	
	(method (showSelf &tmp [temp0 40])
		(= whoSays
			(global91
				findTalker: (Message
					msgGET
					modNum
					noun
					verb
					case
					(if sequence else 1)
				)
			)
		)
		(if (not (IsObject whoSays))
			(Print
				addTextF:
					{<MessageObj> Message not found: %d - %d, %d, %d, %d}
					modNum
					noun
					verb
					case
					sequence
				init:
			)
			(= global4 1)
		else
			(if font (whoSays font: font))
			(if (or x y) (whoSays x: x y: y))
			(global91 say: noun verb case sequence caller modNum)
		)
	)
)

(class Conversation of List
	(properties
		elements 0
		size 0
		script 0
		curItem -1
		caller 0
	)
	
	(method (init theCaller)
		(= curItem -1)
		(if (and argc (IsObject theCaller))
			(= caller theCaller)
		)
		(global78 add: self)
		(self cue:)
	)
	
	(method (doit)
		(if script (script doit:))
	)
	
	(method (dispose &tmp theCaller)
		(self eachElementDo: #perform cleanCode)
		(global78 delete: self)
		(if gTheNewSq4Dialog (gTheNewSq4Dialog dispose:))
		(if script (= script 0))
		(= theCaller caller)
		(super dispose:)
		(if theCaller (theCaller cue:))
	)
	
	(method (add theTheGNumber &tmp theGNumber theTheTheGNumber theTheTheGNumber_2 theTheTheGNumber_3 theTheTheGNumber_4 theTheTheGNumber_5 theTheTheGNumber_6 theTheTheGNumber_7)
		(= theGNumber
			(= theTheTheGNumber
				(= theTheTheGNumber_2
					(= theTheTheGNumber_3 (= theTheTheGNumber_4 0))
				)
			)
		)
		(= theTheTheGNumber_5
			(= theTheTheGNumber_6 (= theTheTheGNumber_7 0))
		)
		(if (and argc (not (IsObject [theTheGNumber 0])))
			(if (== (= theGNumber [theTheGNumber 0]) -1)
				(= theGNumber gNumber)
			)
			(if (> argc 1)
				(= theTheTheGNumber [theTheGNumber 1])
				(if (> argc 2)
					(= theTheTheGNumber_2 [theTheGNumber 2])
					(if (> argc 3)
						(= theTheTheGNumber_3 [theTheGNumber 3])
						(if (> argc 4)
							(= theTheTheGNumber_4 [theTheGNumber 4])
							(if (> argc 5)
								(= theTheTheGNumber_5 [theTheGNumber 5])
								(if (> argc 6)
									(= theTheTheGNumber_6 [theTheGNumber 6])
									(if (> argc 7) (= theTheTheGNumber_7 [theTheGNumber 7]))
								)
							)
						)
					)
				)
			)
			(if (not (IsObject [theTheGNumber 0]))
				(super
					add:
						((MessageObj new:)
							modNum: theGNumber
							noun: theTheTheGNumber
							verb: theTheTheGNumber_2
							case: theTheTheGNumber_3
							sequence: theTheTheGNumber_4
							x: theTheTheGNumber_5
							y: theTheTheGNumber_6
							font: theTheTheGNumber_7
							yourself:
						)
				)
			)
		else
			(super add: theTheGNumber &rest)
		)
	)
	
	(method (cue param1 &tmp temp0 temp1)
		(if (or (and argc param1) (== (++ curItem) size))
			(self dispose:)
		else
			(= temp0 (self at: curItem))
			(cond 
				((temp0 isKindOf: MessageObj) (temp0 caller: self showSelf:))
				((temp0 isKindOf: Script) (self setScript: temp0 self))
				((IsObject temp0) (temp0 doit: self))
				(else (self cue:))
			)
		)
	)
	
	(method (setScript theScript)
		(if (IsObject script) (script dispose:))
		(if theScript (theScript init: self &rest))
	)
	
	(method (load param1 &tmp theGNumber temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= theGNumber (proc999_6 param1 0))
		(= temp1 (proc999_6 param1 1))
		(= temp2 (proc999_6 param1 2))
		(= temp3 (proc999_6 param1 3))
		(= temp4 (proc999_6 param1 4))
		(= temp5 (proc999_6 param1 5))
		(= temp6 (proc999_6 param1 6))
		(= temp7 (proc999_6 param1 7))
		(= temp8 7)
		(while theGNumber
			(if (== theGNumber -1) (= theGNumber gNumber))
			(self
				add: theGNumber temp1 temp2 temp3 temp4 temp5 temp6 temp7
			)
			(= theGNumber (proc999_6 param1 (++ temp8)))
			(= temp1 (proc999_6 param1 (++ temp8)))
			(= temp2 (proc999_6 param1 (++ temp8)))
			(= temp3 (proc999_6 param1 (++ temp8)))
			(= temp4 (proc999_6 param1 (++ temp8)))
			(= temp5 (proc999_6 param1 (++ temp8)))
			(= temp6 (proc999_6 param1 (++ temp8)))
			(= temp7 (proc999_6 param1 (++ temp8)))
		)
	)
)

(instance cleanCode of Code
	(properties)
	
	(method (doit param1 &tmp temp0)
		(if (param1 isKindOf: Script) (param1 caller: 0))
		(if
			(and
				(param1 isKindOf: MessageObj)
				(IsObject (= temp0 (param1 whoSays?)))
				(temp0 underBits?)
			)
			(temp0 dispose: 1)
		)
	)
)

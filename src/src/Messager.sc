;;; Sierra Script 1.0 - (do not remove this comment)
(script# 924)
(include sci.sh)
(use Main)
(use Print)
(use Game)
(use Obj)


(class Messager of Obj
	(properties
		caller 0
		talkerList 0
		disposeWhenDone 1
		oneOnly 0
		killed 0
		oldIconBarState 0
		curSequence 0
		lastSequence 0
	)
	
	(method (dispose)
		(if talkerList
			(talkerList
				eachElementDo: #caller 0
				eachElementDo: #dispose 1
				dispose:
			)
			(= talkerList 0)
		)
		(if gIconBar
			(gIconBar state: oldIconBarState)
			(= oldIconBarState 0)
		)
		(if caller
			(if (not gNewSet) (= gNewSet (Set new:)))
			(gNewSet
				add: ((Cue new:)
					cuee: caller
					cuer: self
					register: killed
					yourself:
				)
			)
		)
		(super dispose:)
	)
	
	(method (cue param1)
		(if (and argc param1) (= killed 1))
		(if (or oneOnly killed)
			(if global84
				(global84 release: dispose:)
				(= global84 0)
			)
			(self dispose:)
		else
			(self sayNext:)
		)
	)
	
	(method (say theCaller &tmp theTheCaller theTheCaller_2 theTheCaller_3 temp3 [temp4 20] temp24)
		(= theTheCaller
			(= theTheCaller_2 (= theTheCaller_3 (= curSequence 0)))
		)
		(= caller (= oneOnly (= killed 0)))
		(if (and gIconBar (not oldIconBarState))
			(= oldIconBarState (gIconBar state?))
		)
		(if (not talkerList) ((= talkerList (Set new:)) add:))
		(if (== (= theTheCaller [theCaller 0]) -1)
			(if (and (> argc 1) (IsObject [theCaller 1]))
				(= caller [theCaller 1])
			)
			(self sayNext:)
		else
			(if (and (> argc 1) [theCaller 1])
				(= theTheCaller_2 [theCaller 1])
			)
			(if (and (> argc 2) [theCaller 2])
				(= theTheCaller_3 [theCaller 2])
			)
			(if (and (> argc 3) [theCaller 3])
				(= oneOnly 1)
				(= curSequence [theCaller 3])
			else
				(= curSequence 1)
			)
			(if
				(and
					(> argc (= temp24 4))
					[theCaller temp24]
					(not (IsObject [theCaller temp24]))
				)
				(= lastSequence [theCaller temp24])
				(++ temp24)
				(= oneOnly 0)
			else
				(= lastSequence 0)
			)
			(if (and (> argc temp24) [theCaller temp24])
				(= caller [theCaller temp24])
			else
				(= caller 0)
			)
			(= temp3
				(if (> argc (++ temp24))
					[theCaller temp24]
				else
					gNumber
				)
			)
			(if
				(or
					(and
						(& gOldMsgType $0001)
						(Message
							msgGET
							temp3
							theTheCaller
							theTheCaller_2
							theTheCaller_3
							curSequence
						)
					)
					0
				)
				(self
					sayNext: temp3 theTheCaller theTheCaller_2 theTheCaller_3 curSequence
				)
			else
				(Print
					addTextF:
						{<Messager>\n\tmsgType set to 0 or\n\t%d: %d, %d, %d, %d not found}
						temp3
						theTheCaller
						theTheCaller_2
						theTheCaller_3
						curSequence
					init:
				)
				(self dispose:)
			)
		)
	)
	
	(method (sayFormat param1 param2 theCaller &tmp temp0 temp1 temp2)
		(if (and gIconBar (not oldIconBarState))
			(= oldIconBarState (gIconBar state?))
		)
		(= temp2 (self findTalker: param1))
		(= temp0 (proc921_3 param2 theCaller &rest))
		(if (IsObject [theCaller (- argc 2)])
			(= caller [theCaller (- argc 2)])
		)
		(= temp1 (Memory memALLOC_CRIT temp0))
		(Format temp1 param2 theCaller &rest)
		(temp2 say: temp1 0 0 0 self)
		(Memory memFREE temp1)
	)
	
	(method (sayNext param1 param2 param3 param4 param5 &tmp temp0 [temp1 200])
		(if argc
			(= temp0
				(Message msgGET param1 param2 param3 param4 param5 @temp1)
			)
		else
			(= temp0 (Message msgNEXT @temp1))
		)
		(if
			(and
				temp0
				(or
					(not lastSequence)
					(and lastSequence (<= curSequence lastSequence))
				)
			)
			(if (!= (= temp0 (self findTalker: temp0)) -1)
				(talkerList add: temp0)
				(temp0 modNum: param1 say: @temp1 self)
				(++ curSequence)
			else
				(if global84
					(global84 release: dispose:)
					(= global84 0)
				)
				(self dispose:)
			)
		else
			(if global84
				(global84 release: dispose:)
				(= global84 0)
			)
			(self dispose:)
		)
	)
	
	(method (findTalker)
		(Print
			width: 200
			addText:
				{<Messager findTalker:>\n\tCan't find talker or\n\tfindTalker method not over-ridden}
			init:
		)
		(return gSq4GlobalNarrator)
	)
)

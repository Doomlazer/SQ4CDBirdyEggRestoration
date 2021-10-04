;;; Sierra Script 1.0 - (do not remove this comment)
(script# 800)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sq4Dialog)
(use Sq4Feature)
(use Print)
(use DIcon)
(use ClickMenu)
(use Class_948_0)
(use InvI)
(use User)
(use View)
(use Obj)

(public
	debugHandler 0
)

(local
	newDButton
)
(procedure (localproc_001e)
	(if (proc999_5 (global2 style?) 11 12 13 14)
		(global2 drawPic: (global2 picture?) 100 style: 100)
	)
)

(instance debugHandler of Sq4Feature
	(properties
		x -1
		y -1
	)
	
	(method (handleEvent pEvent &tmp [temp0 301] temp301 newEvent temp303 temp304 temp305 temp306 temp307 temp308 temp309 temp310 temp311 temp312)
		(switch (pEvent type?)
			(evKEYBOARD
				(pEvent claimed: 1)
				(switch (pEvent message?)
					(KEY_ALT_k
						(= temp301 (GetPort))
						(SetPort 0)
						(= temp311 5)
						(= temp312 16)
						(= temp307 15)
						(= temp308 80)
						(= temp310 (+ temp307 (* 34 temp311)))
						(= temp309 (+ temp308 (* 10 temp312)))
						(= temp305
							(Graph grSAVE_BOX temp307 temp308 temp310 temp309 1)
						)
						(Graph grFILL_BOX temp307 temp308 temp310 temp309 1 255)
						(= temp306 0)
						(while (< temp306 256)
							(Graph
								grFILL_BOX
								(+ temp307 temp311 (* temp311 (/ temp306 8)))
								(+ temp308 temp312 (* 16 (mod temp306 8)))
								(+ temp307 temp311 temp311 (* temp311 (/ temp306 8)))
								(+ temp308 temp312 temp312 (* temp312 (mod temp306 8)))
								1
								temp306
							)
							(++ temp306)
						)
						(Graph grUPDATE_BOX temp307 temp308 temp310 temp309 1)
						(repeat
							(breakif
								(or
									(== ((= newEvent (Event new:)) type?) 1)
									(== (newEvent type?) 4)
								)
							)
							(newEvent dispose:)
						)
						(newEvent dispose:)
						(Graph grRESTORE_BOX temp305)
						(Graph grUPDATE_BOX temp307 temp308 temp310 temp309 1)
						(SetPort temp301)
					)
					(KEY_ALT_f (global1 showMem:))
					(KEY_ALT_g
						(= temp0 0)
						(proc816_0 @temp0 6 {Variable No.})
						(= temp303 (ReadNumber @temp0))
						(= temp0 0)
						(proc816_0 @temp0 6 {Value})
						(= [gEgo temp303] (ReadNumber @temp0))
						(= temp0 0)
					)
					(KEY_ALT_h
						(= temp0 0)
						(proc816_0 @temp0 6 {Variable No.})
						(= temp303 (ReadNumber @temp0))
						(if (IsObject [gEgo temp303])
							(proc816_2 800 0 temp303 ([gEgo temp303] name?))
						else
							(proc816_2 800 1 temp303 [gEgo temp303])
						)
						(= temp0 0)
					)
					(KEY_ALT_v (Show 1))
					(KEY_ALT_m
						(proc816_2 800 2 (= global159 (+ global159 20)))
					)
					(KEY_ALT_p
						(localproc_001e)
						(Show 2)
					)
					(KEY_ALT_c
						(localproc_001e)
						(Show 4)
						(Animate (global5 elements?))
						(while (== 0 ((= pEvent (Event new: 32765)) type?))
							(pEvent dispose:)
						)
						(pEvent dispose:)
						(Show 1)
					)
					(KEY_ALT_e
						(proc816_2
							800
							3
							(gEgo view?)
							(gEgo loop?)
							(gEgo cel?)
							(gEgo x?)
							(gEgo y?)
							(gEgo z?)
							(gEgo heading?)
							(gEgo priority?)
							(gEgo signal?)
							(gEgo illegalBits?)
							(gEgo normal?)
							((gEgo _head?) view?)
							(gEgo onControl:)
							(gEgo onControl: 1)
						)
					)
					(KEY_ALT_a
						(= temp303 (global5 first:))
						(while temp303
							(= temp304 (NodeValue temp303))
							(proc816_2
								800
								4
								((temp304 -super-?) name?)
								(temp304 view?)
								(temp304 loop?)
								(temp304 cel?)
								(temp304 x?)
								(temp304 y?)
								(temp304 z?)
								(temp304 heading?)
								(temp304 priority?)
								(temp304 signal?)
								(if (temp304 isKindOf: Actor)
									(temp304 illegalBits?)
								else
									-1
								)
							)
							(= temp303 (global5 next: temp303))
						)
					)
					(KEY_ALT_t
						(if global25 (global25 dispose:))
						(if (> (= temp303 (proc255_1 {Teleport to:})) 0)
							(gLongSong stop:)
							(++ global171)
							(global2 newRoom: temp303)
						)
					)
					(KEY_ALT_d
						(if (= global14 (not global14))
							(proc921_0 800 5)
						else
							(proc921_0 800 6)
						)
					)
					(KEY_ALT_r
						(proc816_2
							800
							7
							global11
							(global2 name?)
							(if (IsObject (global2 script?))
								((global2 script?) name?)
							else
								{..none..}
							)
							(global2 horizon?)
							(global2 vanishingX?)
							(global2 vanishingY?)
							(global2 picAngle?)
							(global2 north?)
							(global2 south?)
							(global2 east?)
							(global2 west?)
							(global2 style?)
							(global2 curPic?)
						)
					)
					(KEY_ALT_y
						(proc816_2
							800
							8
							(global2 vanishingX?)
							(global2 vanishingY?)
						)
						(= temp303 (proc255_1 {vanishingX:}))
						(if (proc999_5 temp303 -1 0)
						else
							(global2 vanishingX: temp303)
						)
						(= temp303 (proc255_1 {vanishingY:}))
						(if (proc999_5 temp303 -1 0)
						else
							(global2 vanishingY: temp303)
						)
						(proc816_2
							800
							8
							(global2 vanishingX?)
							(global2 vanishingY?)
						)
					)
					(KEY_ALT_w (Class_948_0 doit:))
					(KEY_ALT_u
						(User canInput: 1 canControl: 1)
						(gIconBar enable: 0 1 2 3 4 5 6 7)
					)
					(KEY_ALT_z (= global4 1))
					(KEY_ALT_i (dInvD doit:))
					(KEY_ALT_b (PolyEdit doit:))
					(else  (pEvent claimed: 0))
				)
			)
			(evMOUSEBUTTON
				(cond 
					((== (pEvent modifiers?) emALT)
						(pEvent claimed: 1)
						(= temp301
							(proc816_2
								@temp0
								800
								9
								(pEvent x?)
								(pEvent y?)
								64
								(cond 
									((< (pEvent x?) 23) 3)
									((> (pEvent x?) 292) 273)
									(else (- (pEvent x?) 20))
								)
								(cond 
									((< (pEvent y?) 9) 3)
									((> (pEvent y?) 175) 170)
									(else (- (pEvent y?) 6))
								)
								30
								999
								111
							)
						)
						(while (!= 2 ((= newEvent (Event new:)) type?))
							(newEvent dispose:)
						)
						(newEvent dispose:)
						(temp301 dispose:)
					)
					((== (pEvent modifiers?) 12)
						(pEvent claimed: 1)
						(while (!= 2 ((= newEvent (Event new:)) type?))
							((User alterEgo?)
								posn: (newEvent x?) (- (newEvent y?) 10)
								setMotion: 0
							)
							(Animate (global5 elements?) 0)
							(newEvent dispose:)
						)
						(newEvent dispose:)
					)
				)
			)
		)
	)
)

(instance dInvD of Dialog
	(properties)
	
	(method (init &tmp temp0 temp1 temp2 temp3 newDText gInvFirst temp6)
		(= temp2 (= temp0 (= temp1 4)))
		(= temp3 0)
		(= gInvFirst (gInv first:))
		(while gInvFirst
			(= temp6 (NodeValue gInvFirst))
			(++ temp3)
			(if (temp6 isKindOf: InvI)
				(self
					add:
						((= newDText (DText new:))
							value: temp6
							text: (temp6 name?)
							nsLeft: temp0
							nsTop: temp1
							state: 3
							font: global23
							setSize:
							yourself:
						)
				)
			)
			(if
			(< temp2 (- (newDText nsRight?) (newDText nsLeft?)))
				(= temp2 (- (newDText nsRight?) (newDText nsLeft?)))
			)
			(if
				(>
					(= temp1
						(+ temp1 (- (newDText nsBottom?) (newDText nsTop?)) 1)
					)
					140
				)
				(= temp1 4)
				(= temp0 (+ temp0 temp2 10))
				(= temp2 0)
			)
			(= gInvFirst (gInv next: gInvFirst))
		)
		(= window gSq4Win)
		(self setSize:)
		(= newDButton (DButton new:))
		(newDButton
			text: {Outta here!}
			setSize:
			moveTo: (- nsRight (+ 4 (newDButton nsRight?))) nsBottom
		)
		(newDButton
			move: (- (newDButton nsLeft?) (newDButton nsRight?)) 0
		)
		(self add: newDButton setSize: center:)
		(return temp3)
	)
	
	(method (doit &tmp theNewDButton)
		(self init:)
		(self open: 4 15)
		(= theNewDButton newDButton)
		(repeat
			(breakif
				(or
					(not (= theNewDButton (super doit: theNewDButton)))
					(== theNewDButton -1)
					(== theNewDButton newDButton)
				)
			)
			((theNewDButton value?) owner: gEgo)
		)
		(self eachElementDo: #dispose 1 dispose:)
	)
	
	(method (handleEvent pEvent &tmp pEventMessage pEventType)
		(= pEventMessage (pEvent message?))
		(switch (= pEventType (pEvent type?))
			(4
				(switch pEventMessage
					(KEY_UP (= pEventMessage 3840))
					(KEY_NUMPAD2
						(= pEventMessage 9)
					)
				)
			)
			(64
				(switch pEventMessage
					(JOY_UP
						(= pEventMessage 3840)
						(= pEventType 4)
					)
					(JOY_DOWN
						(= pEventMessage 9)
						(= pEventType 4)
					)
				)
			)
		)
		(pEvent type: pEventType message: pEventMessage)
		(super handleEvent: pEvent)
	)
)

;;; Sierra Script 1.0 - (do not remove this comment)
(script# 531)
(include sci.sh)
(use Main)
(use AudioScript)
(use SQRoom)
(use Sq4Dialog)
(use Sq4Feature)
(use Sync)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm531 0
)

(local
	local0
	local1
	local2
	local3
	theGWalkCursor
	local5
	local6
	newButn_2
	[newButn 12]
	[newTheDisplay 7]
	[local27 30] = [245 129 255 129 265 129 275 129 285 129 245 139 255 139 265 139 275 139 285 139 245 149 255 149 265 149 275 149 285 149]
	[newTheDisplayCel 37] = [5 4 3 2 1 0 20 20 20 20 20 20 2 20 20 20 20 20 10 10 10 10 10 10 6 11 1 7 13 9 4 14 6 9 1 11]
	[local94 18] = [2 0 9 6 8 3 4 4 6 8 5 2 6]
	local112
	local113
	local114
	gLongSong2Number
	gLongSong2Vol
)
(procedure (localproc_1291 param1)
	(return
		(if
			(and
				(== ([newTheDisplay 0] cel?) [newTheDisplayCel param1])
				(==
					([newTheDisplay 1] cel?)
					[newTheDisplayCel (++ param1)]
				)
				(==
					([newTheDisplay 2] cel?)
					[newTheDisplayCel (++ param1)]
				)
				(==
					([newTheDisplay 3] cel?)
					[newTheDisplayCel (++ param1)]
				)
				(==
					([newTheDisplay 4] cel?)
					[newTheDisplayCel (++ param1)]
				)
			)
			(==
				([newTheDisplay 5] cel?)
				[newTheDisplayCel (++ param1)]
			)
		else
			0
		)
	)
)

(procedure (localproc_12fb param1)
	(return
		(if
			(and
				(== ([newTheDisplay 0] cel?) [local94 (+ 0 param1)])
				(== ([newTheDisplay 1] cel?) [local94 (+ 1 param1)])
				(== ([newTheDisplay 2] cel?) [local94 (+ 2 param1)])
				(== ([newTheDisplay 3] cel?) [local94 (+ 3 param1)])
				(== ([newTheDisplay 4] cel?) [local94 (+ 4 param1)])
			)
			(== ([newTheDisplay 5] cel?) [local94 (+ 5 param1)])
		else
			0
		)
	)
)

(procedure (localproc_1374 param1 &tmp temp0)
	(global2
		overlay:
			(switch param1
				(305
					(windshield noun: 0 lookStr: 31)
					(proc0_14 10)
					(= local2 6)
					533
				)
				(376
					(windshield noun: 0 lookStr: 32)
					(proc0_14 10)
					(= local2 12)
					534
				)
				(530
					(windshield noun: 0 lookStr: 33)
					(proc0_14 12)
					(= local2 18)
					532
				)
				(613
					(windshield noun: 0 lookStr: 34)
					(proc0_14 1)
					(= local2 24)
					631
				)
				(650
					(windshield noun: 0 lookStr: 35)
					(proc0_14 3)
					(= local2 0)
					651
				)
				(271
					(windshield noun: 0)
					(proc0_14 3)
					(= local2 0)
					529
				)
				(else 
					(windshield noun: 0 lookStr: 36)
					(proc0_14 12)
					(= global12 530)
					(= local2 18)
					532
				)
			)
	)
)

(instance rm531 of SQRoom
	(properties
		picture 531
	)
	
	(method (init &tmp temp0 temp1 temp2)
		(= theGWalkCursor gWalkCursor)
		(= gWalkCursor 852)
		(Load rsPIC 529)
		(if (not (proc0_6 21)) (Load rsPIC 602))
		(gEgo view: 0)
		(super init:)
		(windshield init:)
		(localproc_1374 (= local3 global12))
		(= temp1 0)
		(while (<= temp1 5)
			(= [newTheDisplayCel (+ 18 temp1)]
				[gNewTheDisplayCel temp1]
			)
			(++ temp1)
		)
		(if (proc0_6 35)
			(= temp1 0)
			(while (<= temp1 5)
				(= [newTheDisplayCel (+ 12 temp1)]
					[gNewTheDisplayCel_2 temp1]
				)
				(++ temp1)
			)
		)
		(if
		(and (proc999_5 global12 305 376 530) (proc0_6 2))
			(proc0_8 2)
		)
		(if (>= global128 1)
			(= temp1 0)
			(while (<= temp1 5)
				(= [newTheDisplayCel (+ 6 temp1)]
					[gNewTheDisplayCel_3 temp1]
				)
				(++ temp1)
			)
		)
		(= temp1 0)
		(while (<= temp1 14)
			((= [newButn temp1] (butn new:))
				posn: [local27 (= temp2 (* temp1 2))] [local27 (++ temp2)]
				cel: temp1
				init:
				setPri: 0
				stopUpd:
			)
			(++ temp1)
		)
		(= temp1 0)
		(while (<= temp1 5)
			((= [newTheDisplay temp1] (theDisplay new:))
				posn: (- 289 (* temp1 7)) 114
				cel: [newTheDisplayCel (+ local2 temp1)]
				init:
			)
			(++ temp1)
		)
		((= newButn_2 (butn new:))
			noun: 0
			lookStr: 1
			posn: 295 148
			cel: 15
			init:
			setPri: 0
			stopUpd:
		)
		(hand init:)
		(rogerHead init:)
		(keyDisplay init:)
		(mainScreen init:)
		(smallCompartment init:)
		(largeCompartment init:)
		(headRest init:)
		(cables init:)
		(entryPad init:)
		(soundFX init:)
		(exitButn init:)
		(restOfPod init:)
		(proc0_3)
		(global80 canControl: 0)
		(gIconBar disable: 0 4 5)
		(global1 setCursor: 852 1)
		(gIconBar curIcon: (gIconBar at: 2))
	)
	
	(method (newRoom)
		(if (global8 contains: soundFX) (soundFX dispose:))
		(= gWalkCursor theGWalkCursor)
		(super newRoom: &rest)
	)
)

(instance raiseHandS of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(global1 setCursor: 996 1 local5 local6)
				(hand setMotion: MoveTo local5 local6 self)
			)
			(1 (= local1 1) (= cycles 2))
			(2
				(global1 setCursor: 996 1 local5 local6)
				(self dispose:)
			)
		)
	)
)

(instance hand of Sq4Actor
	(properties
		x 300
		y 200
		yStep 15
		view 531
		priority 14
		signal $6810
		illegalBits $0000
		xStep 15
	)
	
	(method (doit &tmp temp0 temp1)
		(cond 
			(
				(and
					(not script)
					(== ((gIconBar curIcon?) message?) 4)
				)
				(if
				(not (& ((= temp0 (global80 curEvent?)) type?) $0003))
					(temp0 localize:)
					(= local5 (temp0 x?))
					(= local6 (temp0 y?))
					(= temp1 (proc999_4 230 118 308 170 local5 local6))
					(cond 
						((and (not local1) temp1) (self setScript: raiseHandS))
						(temp1 (self posn: local5 local6))
						(local1
							(if (> local6 170)
								(self setScript: lowerHandS 0 2)
							else
								(if (< local6 118) (= local6 118))
								(= local5
									(cond 
										((> local5 308) 308)
										((< local5 230) 230)
										(else local5)
									)
								)
								(global1 setCursor: 996 1 local5 local6)
								(self posn: local5 local6)
							)
						)
					)
				)
			)
			((and (not script) local1) (self setScript: lowerHandS 0 1))
		)
		(super doit:)
	)
)

(instance lowerHandS of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(hand setMotion: MoveTo 270 204 self)
			)
			(1
				(= local1 0)
				(if register
					(switch register
						(1
							(global1 setCursor: gCursorNumber 1 local5 local6)
						)
						(2
							(global1 setCursor: gWalkCursor 1 local5 175)
						)
					)
					(self dispose:)
				else
					(global1 setCursor: gWalkCursor 1 local5 175)
					(caller cue:)
				)
			)
		)
	)
)

(instance pushAndBackS of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(hand posn: (+ (hand x?) 1) (+ (hand y?) 1))
				(= cycles 6)
			)
			(1
				(hand posn: (- (hand x?) 1) (- (hand y?) 1))
				(global1 setCursor: 996 1 (hand x?) (hand y?))
				(self dispose:)
			)
		)
	)
)

(instance displayMeS of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(global80 canInput: 0)
				(soundFX number: 102 loop: 0 play:)
				(client setPri: 10)
				(= cycles 1)
			)
			(1
				(if (!= ([newTheDisplay 5] loop?) 4)
					(= temp0 5)
					(while (>= temp0 0)
						([newTheDisplay temp0] loop: 4)
						(-- temp0)
					)
				else
					(= temp0 4)
					(while (>= temp0 0)
						(if (!= ([newTheDisplay temp0] loop?) 4)
							([newTheDisplay (+ temp0 1)] loop: 2)
							([newTheDisplay (+ temp0 1)]
								cel: ([newTheDisplay temp0] cel?)
							)
						)
						(-- temp0)
					)
				)
				([newTheDisplay 0] loop: 2 cel: (client cel?))
				(= cycles 7)
			)
			(2
				(client setPri: 0)
				(global80 canInput: 1)
				(self dispose:)
			)
		)
	)
)

(instance dudScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(lowerHandS caller: 0)
				(hand setScript: 0)
				(if local0
					(gSq4GlobalNarrator say: 5 self)
				else
					(gSq4GlobalNarrator say: 6 self)
				)
			)
			(1
				(= temp0 0)
				(while (<= temp0 5)
					([newTheDisplay temp0] loop: 4)
					(++ temp0)
				)
				(= cycles 1)
			)
			(2
				(if (!= (gLongSong prevSignal?) -1)
					(gLongSong fade: 0 0 0 1)
				)
				(proc0_2)
				(= cycles 1)
			)
			(3
				(if (!= (gLongSong prevSignal?) -1) (-- state))
				(= cycles 1)
			)
			(4 (= seconds 2))
			(5
				(global1 setCursor: 852 1)
				(gIconBar curIcon: (gIconBar at: 2))
				(global80 canInput: 1)
				(gIconBar enable: 2 3 1)
				(= cycles 2)
			)
			(6
				(if (proc999_5 gLongSong2Number 15 14 535 19)
					(gLongSong2
						number: gLongSong2Number
						loop: -1
						vol: gLongSong2Vol
						flags: 1
						prevSignal: 0
						play:
					)
				)
				(= cycles 1)
			)
			(7 (self dispose:))
		)
	)
)

(instance timeToTimeWarpS of AudioScript
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(if register (Palette palANIMATE 190 220 -2))
	)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= register 0)
				(= gLongSong2Number (gLongSong2 number?))
				(= gLongSong2Vol (gLongSong2 vol?))
				(proc0_2)
				(soundFX number: 102 loop: 0 playBed:)
				(newButn_2 setPri: 10)
				(if (localproc_1291 30)
					(heart init: setScript: ILoveLunacyScript)
					(self dispose:)
				else
					(= cycles 2)
				)
			)
			(1
				(cond 
					(
						(and
							(localproc_12fb 0)
							(not local112)
							(not local113)
							(not local114)
						)
						(= local112 1)
					)
					(
						(and
							(localproc_12fb 6)
							local112
							(not local113)
							(not local114)
						)
						(= local113 1)
					)
					(
						(and
							(localproc_12fb 12)
							local112
							local113
							(not local114)
						)
						(= local114 1)
					)
					(else (= local112 0) (= local113 0) (= local114 0))
				)
				(= local0
					(cond 
						((localproc_1291 0) 650)
						((localproc_1291 12) 376)
						((localproc_1291 18) 530)
						((localproc_1291 24) (proc0_11 86 5) 613)
						((and local112 local113 local114) 271)
						((and (== global128 1) (localproc_1291 6))
							(= temp0 0)
							(while (<= temp0 5)
								([newTheDisplay temp0] loop: 4)
								(++ temp0)
							)
							0
						)
						(
						(and (== global128 1) (!= ([newTheDisplay 5] loop?) 4))
							(= global128 2)
							(= temp0 0)
							(while (<= temp0 5)
								(= [gNewTheDisplayCel_3 temp0]
									(= [newTheDisplayCel (+ 6 temp0)]
										([newTheDisplay temp0] cel?)
									)
								)
								(++ temp0)
							)
							(proc0_7 35)
							(if (> gNewTheDisplayCel_3 10)
								(= gNewTheDisplayCel_2 2)
							else
								(= gNewTheDisplayCel_2 13)
							)
							(= temp0 1)
							(while (<= temp0 5)
								(= [gNewTheDisplayCel_2 temp0] (Random 0 14))
								(++ temp0)
							)
							305
						)
						(
						(and (== global128 0) (!= ([newTheDisplay 5] loop?) 4))
							(= global128 1)
							(= temp0 0)
							(while (<= temp0 5)
								(= [gNewTheDisplayCel_3 temp0]
									(= [newTheDisplayCel (+ 6 temp0)]
										([newTheDisplay temp0] cel?)
									)
								)
								(++ temp0)
							)
							(= temp0 0)
							(while (<= temp0 5)
								([newTheDisplay temp0] loop: 4)
								(++ temp0)
							)
							0
						)
						((localproc_1291 6) 305)
						(else
							(= temp0 0)
							(while (<= temp0 5)
								([newTheDisplay temp0] loop: 4)
								(++ temp0)
							)
							0
						)
					)
				)
				(hand setScript: lowerHandS self 0)
			)
			(2
				(= seconds 1)
				(gLongSong2 stop:)
			)
			(3
				(proc0_2)
				(newButn_2 setPri: 0)
				(gSq4GlobalNarrator modeless: 1 say: 2 self)
			)
			(4
				(if (& global90 $0002)
					(= waitForCue 256)
					(dummy init: 531 99 0 3 1)
					(gSq4GlobalNarrator modeless: 1 say: 3 self)
				else
					(gSq4GlobalNarrator modeless: 1 say: 3 self)
				)
			)
			(5
				(if (and local0 (!= local0 local3))
					(gLongSong
						number: 17
						loop: 0
						vol: 127
						flags: 1
						prevSignal: 0
						play:
					)
				else
					(gLongSong
						number: 16
						loop: 0
						vol: 127
						flags: 1
						prevSignal: 0
						play:
					)
				)
				(= cycles 1)
			)
			(6
				(if (!= (gSq4GlobalNarrator ticks?) -1) (-- state))
				(= cycles 1)
			)
			(7
				(gSq4GlobalNarrator modeless: 0 say: 4 self)
			)
			(8
				(= seconds 0)
				(if global25 (global25 dispose:))
				(if (and local0 (!= local0 local3))
					(= temp0 0)
					(while (<= temp0 5)
						([newTheDisplay temp0] hide:)
						(++ temp0)
					)
					(= cycles 2)
					(if (proc0_6 22)
						(proc0_8 22)
						(proc0_7 8)
						(proc0_8 10)
						(proc0_8 11)
						(proc0_8 13)
						(proc0_8 12)
						(proc0_8 20)
						(proc0_8 19)
						(proc0_8 30)
						(proc0_8 23)
						(proc0_8 30)
						(proc0_7 36)
					)
				else
					(global2 setScript: dudScript)
					(self dispose:)
				)
			)
			(9
				(global2 overlay: 529)
				(= cycles 2)
			)
			(10
				(= temp1 529)
				(= register 1)
				(gLongSong prevSignal: 0)
				(= cycles 1)
			)
			(11
				(if (!= (gLongSong prevSignal?) -1) (-- state))
				(= cycles 1)
			)
			(12
				(= register 0)
				(proc0_8 16)
				(lowerHandS caller: 0)
				(hand setScript: 0)
				(switch local0
					(650
						(gLongSong2 number: 15 loop: -1 vol: 90 flags: 1 playBed:)
					)
					(613
						(gLongSong2 number: 14 vol: 127 loop: 1 flags: 1 playBed:)
					)
					(530
						(gLongSong2
							number: 535
							vol: 80
							loop: -1
							flags: 1
							playBed:
						)
					)
					(271
						(gLongSong2 stop:)
						(gLongSong stop:)
					)
					(376
						(gLongSong2 number: 19 loop: -1 vol: 80 flags: 1 playBed:)
					)
				)
				(if (and local112 local113 local114)
					(global2 newRoom: local0)
				)
				(if (proc999_5 local0 305 376 530)
					(proc0_7 2)
					(proc0_7 26)
					(global2 newRoom: local0)
				else
					(= local3 local0)
					(localproc_1374 local0)
					(proc0_3)
					(global80 canControl: 0)
					(gIconBar disable: 0 4 5)
					(= temp0 0)
					(while (<= temp0 5)
						([newTheDisplay temp0] show:)
						(++ temp0)
					)
					(global80 canInput: 1)
					(self dispose:)
				)
			)
		)
	)
)

(instance exitScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(hand
					x: 55
					y: 189
					setLoop: 1
					setMotion: MoveTo 37 151 self
				)
			)
			(1 (= cycles 3))
			(2
				(soundFX number: 812 loop: 0 play:)
				(hand setMotion: MoveTo 41 151 self)
			)
			(3 (= cycles 3))
			(4
				(hand setMotion: MoveTo 55 189 self)
			)
			(5 (global2 newRoom: local3))
		)
	)
)

(instance butn of Sq4Prop
	(properties
		x 247
		y 128
		view 531
		loop 3
		priority 10
		signal $4000
		lookStr 7
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2 (gSq4GlobalNarrator say: 8))
			(4
				(if
					(and
						(not script)
						(not (hand script?))
						(not (global2 script?))
					)
					(if (== cel 15)
						(global2 setScript: timeToTimeWarpS)
					else
						(hand setScript: pushAndBackS)
						(self setScript: displayMeS)
					)
				)
			)
			(
				(proc999_5
					theVerb
					8
					9
					10
					11
					12
					13
					14
					15
					16
					17
					18
					19
					20
					21
					22
					23
				)
				0
			)
			(else  (super doVerb: theVerb))
		)
	)
	
	(method (cue)
		(super cue: &rest)
	)
)

(instance theDisplay of Sq4View
	(properties
		view 531
		loop 2
		priority 10
		lookStr 9
	)
)

(instance windshield of Sq4Feature
	(properties)
	
	(method (onMe param1)
		(return (== (OnControl 4 (param1 x?) (param1 y?)) 2))
	)
)

(instance rogerHead of Sq4Feature
	(properties
		lookStr 10
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2 (gSq4GlobalNarrator say: 11))
			(4 (gSq4GlobalNarrator say: 12))
			(else  (super doVerb: theVerb))
		)
	)
	
	(method (onMe param1)
		(return (== (OnControl 4 (param1 x?) (param1 y?)) 4))
	)
)

(instance mainScreen of Sq4Feature
	(properties
		lookStr 13
	)
	
	(method (onMe param1)
		(return (== (OnControl 4 (param1 x?) (param1 y?)) 8))
	)
)

(instance keyDisplay of Sq4Feature
	(properties
		lookStr 14
	)
	
	(method (onMe param1)
		(return (== (OnControl 4 (param1 x?) (param1 y?)) 16))
	)
)

(instance smallCompartment of Sq4Feature
	(properties)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 15))
			(4 (gSq4GlobalNarrator say: 16))
			(
				(proc999_5
					theVerb
					8
					9
					10
					11
					12
					13
					14
					15
					16
					17
					18
					19
					20
					21
					22
					23
				)
				0
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (onMe param1)
		(return (== (OnControl 4 (param1 x?) (param1 y?)) 32))
	)
)

(instance largeCompartment of Sq4Feature
	(properties)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 17))
			(4 (gSq4GlobalNarrator say: 18))
			(
				(proc999_5
					theVerb
					8
					9
					10
					11
					12
					13
					14
					15
					16
					17
					18
					19
					20
					21
					22
					23
				)
				0
			)
			(else  (super doVerb: theVerb))
		)
	)
	
	(method (onMe param1)
		(return (== (OnControl 4 (param1 x?) (param1 y?)) 64))
	)
)

(instance headRest of Sq4Feature
	(properties)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 19))
			(4 (gSq4GlobalNarrator say: 20))
			(
				(proc999_5
					theVerb
					8
					9
					10
					11
					12
					13
					14
					15
					16
					17
					18
					19
					20
					21
					22
					23
				)
				0
			)
			(else  (super doVerb: theVerb))
		)
	)
	
	(method (onMe param1)
		(return (== (OnControl 4 (param1 x?) (param1 y?)) 128))
	)
)

(instance cables of Sq4Feature
	(properties)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 21))
			(4 (gSq4GlobalNarrator say: 22))
			(
				(proc999_5
					theVerb
					8
					9
					10
					11
					12
					13
					14
					15
					16
					17
					18
					19
					20
					21
					22
					23
				)
				0
			)
			(else  (super doVerb: theVerb))
		)
	)
	
	(method (onMe param1)
		(return (== (OnControl 4 (param1 x?) (param1 y?)) 256))
	)
)

(instance entryPad of Sq4Feature
	(properties
		lookStr 24
	)
	
	(method (onMe param1)
		(return (== (OnControl 4 (param1 x?) (param1 y?)) 512))
	)
)

(instance exitButn of Sq4Feature
	(properties)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 25))
			(4
				(if (or (hand script?) (global2 script?))
				else
					(proc0_2)
					(= local1 1)
					(hand setScript: exitScript)
				)
			)
			(6 (gSq4GlobalNarrator say: 26))
			(7 (gSq4GlobalNarrator say: 27))
			(else  (super doVerb: theVerb))
		)
	)
	
	(method (onMe param1)
		(return (== (OnControl 4 (param1 x?) (param1 y?)) 1024))
	)
)

(instance restOfPod of Sq4Feature
	(properties)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 28))
			(4 (gSq4GlobalNarrator say: 29))
			(6 (gSq4GlobalNarrator say: 30))
			(else  (super doVerb: theVerb))
		)
	)
	
	(method (onMe)
		(return 1)
	)
)

(instance soundFX of Sound
	(properties
		number 102
		priority 5
	)
)

(instance frog of Sq4Feature
	(properties
		nsTop 183
		nsLeft 27
		nsBottom 189
		nsRight 62
		lookStr 37
	)
	
	(method (doVerb &tmp temp0)
		(= local2
			(proc816_1
				{Where To?}
				27
				1
				77
				{Time-O-Matic}
				109
				78
				{Estros}
				6
				109
				78
				{Mall}
				12
				109
				78
				{Xenon}
				18
				109
				78
				{Ulence}
				24
				109
				78
				{Ortega}
				0
				109
			)
		)
		(cond 
			((and (< global128 2) (== local2 6)) (proc816_1 531 0))
			((and (< global128 2) (== local2 12)) (proc816_1 531 1))
			(else
				(= temp0 0)
				(while (<= temp0 5)
					([newTheDisplay temp0]
						loop: 2
						cel: [newTheDisplayCel (+ local2 temp0)]
					)
					(++ temp0)
				)
				(hand posn: 180 180)
				(global2 setScript: timeToTimeWarpS)
			)
		)
	)
)

(instance heart of Sq4Prop
	(properties
		x 194
		y 131
		view 888
		cel 1
		priority 10
		signal $4010
	)
)

(instance ILoveLunacy of Sq4View
	(properties
		x 194
		y 131
		view 888
		loop 1
		priority 11
		signal $4010
	)
)

(instance ILoveLunacyScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(heart cycleSpeed: 30 setCycle: Fwd)
				(= cycles 2)
			)
			(1
				(newButn_2 setPri: 0)
				(= seconds 3)
			)
			(2
				(ILoveLunacy init:)
				(= seconds 5)
			)
			(3
				(ILoveLunacy dispose:)
				(= cycles 3)
			)
			(4 (heart hide:) (= cycles 2))
			(5
				(gSq4GlobalNarrator say: 39)
				(global80 canInput: 1)
				(gIconBar enable: 2 3 1)
				(heart dispose:)
			)
		)
	)
)

(instance musicDummy of Script
	(properties)
	
	(method (cue)
		(if (proc999_5 (gLongSong2 number?) 19 535 15)
			(gLongSong2 vol: 80 loop: -1 flags: 1 play:)
		)
	)
)

(instance dummy of ScriptSync
	(properties)
)

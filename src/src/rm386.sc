;;; Sierra Script 1.0 - (do not remove this comment)
(script# 386)
(include sci.sh)
(use Main)
(use mall)
(use SQRoom)
(use Sq4Dialog)
(use Sq4Narrator)
(use Sq4Feature)
(use Polygon)
(use SysWindow)
(use Obj)

(public
	rm386 0
)

(local
	local0
	theGSq4Win
	[local2 22] = [268 99 246 130 86 129 61 105 61 90 110 61 118 32 127 16 162 5 206 27 214 66]
)
(procedure (localproc_0b32 &tmp temp0 [temp1 100] [temp101 30] [temp131 30])
	(Message msgGET 386 24 0 1 1 @temp1)
	(Message msgGET 386 97 0 1 1 @temp101)
	(Message msgGET 386 97 0 2 1 @temp131)
	(= temp0
		(proc816_3
			@temp1
			64
			100
			100
			109
			78
			@temp101
			0
			109
			78
			@temp131
			1
		)
	)
)

(instance rm386 of SQRoom
	(properties
		picture 386
		style $000a
	)
	
	(method (init)
		(Load rsVIEW 386)
		(Load rsSOUND 4)
		(= theGSq4Win gSq4Win)
		(proc0_2)
		(bottomCigar init:)
		(redStuff init:)
		(yellowStuff init:)
		(microwave init:)
		(theMouth init:)
		(arm init:)
		(gLongSong number: 0 stop:)
		(gLongSong2 vol: 127 changeState:)
		(thePig init:)
		(pigPoly points: @local2 size: 11)
		(theRoom init:)
		(self setScript: talkScript 0 0)
		(super init:)
		(self setRegions: 700)
		(gEgo setCycle: 0)
		(tPig init: 0 0 theMouth)
	)
	
	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 387) (gLongSong2 fade:))
		(super newRoom: newRoomNumber)
	)
)

(instance sJob of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(arm setCel: 0)
				(= seconds 2)
			)
			(1
				(theMouth setLoop: 0 posn: 155 39)
				(arm setCel: 2)
				(= seconds 1)
			)
			(2
				(theMouth setLoop: 0 posn: 155 39)
				(tPig
					modNum: 386
					talkerNum: 24
					say: 1 self 2 64 5 150 67 310 27 1
				)
			)
			(3
				(switch (localproc_0b32)
					(0 (global2 newRoom: 385))
				)
				(= cycles 2)
			)
			(4
				(if (== (gEgo view?) 373)
					(tRogette say: 2 self)
				else
					(= cycles 2)
				)
			)
			(5 (client setScript: 0))
		)
	)
)

(instance theRoom of Sq4Feature
	(properties
		x 160
		y 100
		nsBottom 200
		nsRight 320
		lookStr 1
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3 (global2 newRoom: 385))
			(6 (proc816_1 386 0))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance thePig of Sq4Feature
	(properties
		x 160
		y 100
		sightAngle 180
		lookStr 2
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: pigPoly)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 2))
			(2
				(if (not (global2 script?))
					(proc0_2)
					(talkScript register: (+ (talkScript register?) 1))
					(global2 setScript: talkScript)
				)
			)
			(8 (gSq4GlobalNarrator say: 3))
			(7 (gSq4GlobalNarrator say: 4))
			(6 (gSq4GlobalNarrator say: 5))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance pigPoly of Polygon
	(properties)
)

(instance arm of Sq4Prop
	(properties
		x 94
		y 134
		sightAngle 180
		view 386
		loop 2
		cel 1
		priority 2
		signal $0810
		lookStr 2
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 2))
			(2
				(if (not (global2 script?))
					(proc0_2)
					(talkScript register: (+ (talkScript register?) 1))
					(global2 setScript: talkScript)
				)
			)
			(8 (gSq4GlobalNarrator say: 3))
			(7 (gSq4GlobalNarrator say: 4))
			(6 (gSq4GlobalNarrator say: 5))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theMouth of Sq4Prop
	(properties
		x 158
		y 63
		view 1386
		loop 1
		priority 1
		signal $0810
	)
	
	(method (doVerb)
		(arm doVerb:)
	)
)

(instance talkScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: 0)
				(if register (= cycles 1) else (= seconds 1))
			)
			(1
				(switch register
					(0 (= cycles 1))
					(1
						(if (== (gEgo view?) 373)
							(tRogette modNum: 388 say: 1 self)
						else
							(tRog modNum: 388 say: 1 self)
						)
					)
					(2 (self setScript: sJob self))
				)
			)
			(2
				(arm setCel: 0)
				(theMouth setLoop: 0 posn: 155 39)
				(= seconds 2)
			)
			(3
				(switch register
					(0
						(if (== (gEgo view?) 373)
							(tPig modNum: 388 say: 2 self 2 64 5 150 67 310 27 1)
						else
							(tPig say: 3 self 2 64 5 150 67 310 27 1)
						)
						(arm setCel: 2)
					)
					(1
						(tPig
							modNum:
								(if
									(and
										(proc0_6 70)
										(not (proc999_5 (gEgo view?) 373 374))
									)
									global11
								else
									388
								)
							say:
								(if
									(and
										(proc0_6 70)
										(not (proc999_5 (gEgo view?) 373 374))
									)
									4
								else
									10
								)
								self
								2
								64
								5
								150
								67
								310
								27
								1
						)
						(arm setCel: 2)
					)
					(2
						(arm setCel: 2)
						(cond 
							((and (>= global172 34) (!= (gEgo view?) 373)) (tPig say: 6 self 2 64 5 150 67 310 27 1))
							((== (gEgo view?) 373) (tPig modNum: 388 say: 7 self 2 64 5 150 67 310 27 1))
							((proc0_6 70) (tPig say: 8 self 2 64 5 150 67 310 27 1))
							(else (tPig modNum: 388 say: 9 self 2 64 5 150 67 310 27 1))
						)
						(proc0_2)
						(cond 
							((and (>= global172 34) (!= (gEgo view?) 373)) (tPig say: 6 self 2 64 5 150 67 310 27 1))
							((== (gEgo view?) 373) (tPig modNum: 388 say: 7 self 2 64 5 150 67 310 27 1))
							((proc0_6 70) (tPig say: 8 self 2 64 5 150 67 310 27 1))
							(else (tPig say: 9 self 2 64 5 150 67 310 27 1))
						)
						(arm setCel: 2)
					)
				)
			)
			(4
				(if
					(and
						(>= register 2)
						(>= global172 34)
						(!= (gEgo view?) 373)
					)
					(global2 newRoom: 385)
				else
					(= cycles 2)
				)
			)
			((arm setCel: 0) (= cycles 5))
			((arm setCel: 1) (= cycles 5))
			(5
				(arm setCel: 0)
				(if (== register 2)
					(cond 
						((== (gEgo view?) 373) (tRogette modNum: 388 say: 4 self))
						((proc0_6 70) (tRog say: 5 self))
						(else (tRog say: 6 self))
					)
				else
					(= seconds 2)
				)
			)
			(6
				(if (== register 2) (arm setCel: 0))
				(theMouth setLoop: 1 cel: 0 posn: 158 63)
				(if (< register 2)
					(proc0_3)
					(global80 canControl: 0)
					(gIconBar disable: 0 2)
				)
				(if (== register 2) (= cycles 6) else (self dispose:))
			)
			(7
				(arm setCel: 1)
				(if (== (gEgo view?) 373)
					(global2 newRoom: 385)
				else
					(global2 setScript: warningScript)
				)
			)
		)
	)
)

(instance warningScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 3))
			(1
				(global5 eachElementDo: #hide)
				(global2 drawPic: 803)
				(= seconds 2)
			)
			(2
				(gIconBar curIcon: (gIconBar at: 2))
				(global1 setCursor: ((gIconBar curIcon?) cursor?))
				(gIconBar disable:)
				(= gSq4Win BlackWindow)
				(BlackWindow color: global131 back: global129)
				(switch
					(narratorWarning
						x: 60
						y: 36
						say: 6 0 0 64 (narratorWarning x?) (narratorWarning y?)
					)
					(0
						(if
							(and
								(< global172 34)
								(not (proc700_3 (ScriptID 700 0) 680 4))
								(not (proc0_6 29))
							)
							(gEgo get: 0)
							(= global159 (+ global159 (- 34 global172)))
							(= global172 34)
							(mall rFlag4: (| (mall rFlag4?) $0001))
							(proc0_11 52 -3)
							(gSq4GlobalNarrator say: 7 self)
						else
							(gSq4GlobalNarrator say: 8 self)
						)
						(= cycles 1)
					)
					(1
						(= local0 1)
						(proc0_11 51 3)
						(= cycles 1)
					)
				)
			)
			(3
				(= gSq4Win theGSq4Win)
				(gIconBar enable:)
				(= cycles 2)
			)
			(4
				(if local0
					(global2 newRoom: 387)
				else
					(global2 newRoom: 385)
				)
			)
		)
	)
)

(instance BlackWindow of SysWindow
	(properties)
)

(instance redStuff of Sq4Feature
	(properties
		x 306
		y 105
		nsTop 75
		nsLeft 294
		nsBottom 135
		nsRight 318
		sightAngle 180
		lookStr 9
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(7 (gSq4GlobalNarrator say: 10))
			(6 (gSq4GlobalNarrator say: 11))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance yellowStuff of Sq4Feature
	(properties
		x 282
		y 104
		nsTop 75
		nsLeft 272
		nsBottom 134
		nsRight 293
		sightAngle 180
		lookStr 12
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(7 (gSq4GlobalNarrator say: 13))
			(6 (gSq4GlobalNarrator say: 11))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance microwave of Sq4Feature
	(properties
		x 24
		y 106
		nsTop 84
		nsBottom 128
		nsRight 49
		sightAngle 180
		lookStr 14
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gSq4GlobalNarrator say: 15))
			(6 (gSq4GlobalNarrator say: 16))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance bottomCigar of Sq4Feature
	(properties
		x 93
		y 150
		nsTop 93
		nsLeft 79
		nsBottom 110
		nsRight 108
		sightAngle 180
		lookStr 14
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1)
			(4 (gSq4GlobalNarrator say: 17))
			(6 (gSq4GlobalNarrator say: 18))
			(7
				(if (== (gEgo view?) 373)
					(tRogette say: 7)
				else
					(tRog say: 7)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance narratorWarning of Sq4Narrator
	(properties
		noun 99
		modNum 386
		modeless 1
		nMsgType 3
	)
	
	(method (dispose &tmp temp0)
		(if returnVal (proc0_12 returnVal))
		(super dispose: &rest)
	)
	
	(method (say param1 &tmp temp0 [temp1 100] [temp101 30] [temp131 30])
		(super say: param1 &rest)
		(Message msgGET 386 99 0 param1 1 @temp1)
		(Message msgGET 386 97 0 3 1 @temp101)
		(Message msgGET 386 97 0 4 1 @temp131)
		(= temp0
			(proc816_3
				@temp1
				109
				64
				x
				y
				109
				78
				@temp101
				1
				109
				78
				@temp131
				0
			)
		)
		(self dispose:)
		(return temp0)
	)
	
	(method (display)
	)
)

(instance tPig of FaceTalker
	(properties
		noun 24
		modNum 386
		talkerNum 24
		tpType 2
	)
)

(instance tRog of Sq4Talker
	(properties
		z 400
		noun 7
		view 1008
		talkerNum 7
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 27
		eyeOffsetY 21
	)
)

(instance tRogette of Sq4Talker
	(properties
		z 400
		noun 7
		view 1009
		talkerNum 7
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 26
		eyeOffsetY 21
	)
)

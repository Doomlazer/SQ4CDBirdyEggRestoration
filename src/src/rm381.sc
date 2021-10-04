;;; Sierra Script 1.0 - (do not remove this comment)
(script# 381)
(include sci.sh)
(use Main)
(use mall)
(use rmnScript)
(use SQRoom)
(use Sq4Narrator)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use StopWalk)
(use Grooper)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm381 0
)

(local
	local0
	local1
	local2
	local3
	local4 =  1
	[local5 8] = [314 68 235 67 157 64 220 90]
	[theRoboBrBottom 8]
	local21
)
(procedure (localproc_19f0 &tmp theTheRoboBrBottom theTheRoboBrBottom_2 theTheRoboBrBottom_3 roboBrBottom)
	(= theTheRoboBrBottom (- (robo brLeft?) 5))
	(= theTheRoboBrBottom_2 (- (robo brTop?) 5))
	(= theTheRoboBrBottom_3 (+ (robo brRight?) 6))
	(= roboBrBottom (robo brBottom?))
	(= [theRoboBrBottom 0]
		(= [theRoboBrBottom 6] theTheRoboBrBottom)
	)
	(= [theRoboBrBottom 1]
		(= [theRoboBrBottom 3] theTheRoboBrBottom_2)
	)
	(= [theRoboBrBottom 2]
		(= [theRoboBrBottom 4] theTheRoboBrBottom_3)
	)
	(= [theRoboBrBottom 5]
		(= [theRoboBrBottom 7] roboBrBottom)
	)
	(roboPoly points: @theRoboBrBottom size: 4)
	(global2 addObstacle: roboPoly)
)

(instance rm381 of SQRoom
	(properties
		picture 381
		style $000a
		south 380
		picAngle 60
	)
	
	(method (init)
		(proc958_0 128 0 4 402 383 381 920)
		(proc958_0 135 68 69)
		(proc958_0 132 832 833)
		(gEgo posn: 192 222 loop: 3 illegalBits: -32768 init:)
		(if
			(and
				(>= global159 1000)
				(!= (gEgo view?) 373)
				(not (proc700_3 (ScriptID 700 0) 679 8))
				((ScriptID 700 0)
					rFlag2: (| ((ScriptID 700 0) rFlag2?) $0008)
				)
			)
			(bobA cycleSpeed: 12 init: setScript: bobScript)
			(global2
				addObstacle:
					((Polygon new:)
						type: 2
						init: 107 150 152 150 176 158 176 170 152 180 116 180 90 174 80 163
						yourself:
					)
					((Polygon new:)
						type: 2
						init:
							268
							56
							238
							61
							201
							57
							159
							62
							142
							65
							119
							65
							118
							73
							102
							89
							46
							89
							7
							106
							7
							172
							78
							172
							69
							189
							0
							189
							0
							0
							319
							0
							319
							55
						yourself:
					)
					((Polygon new:)
						type: 2
						init: 319 189 242 189 221 148 159 115 197 91 241 91 251 77 319 77
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: 2
						init: 107 150 152 150 176 158 176 170 152 180 116 180 90 174 80 163
						yourself:
					)
					((Polygon new:)
						type: 2
						init:
							268
							56
							238
							61
							201
							57
							159
							62
							125
							59
							111
							73
							118
							73
							102
							89
							46
							89
							7
							106
							7
							172
							78
							172
							69
							189
							0
							189
							0
							0
							319
							0
							319
							55
						yourself:
					)
					((Polygon new:)
						type: 2
						init: 319 189 242 189 221 148 159 115 197 91 241 91 251 77 319 77
						yourself:
					)
			)
		)
		(super init:)
		(global32
			add:
				light1
				light2
				CashRegister
				shelves
				alienSuit1
				alienSuit2
				alienSuit3
				alienSuit4
				alienSuit5
				BargainShelf
				dressingRoom
				theShop
			eachElementDo: #init
			doit:
		)
		(gLongSong number: 0 stop:)
		(gLongSong2 vol: 127 changeState:)
		(rmnProp init:)
		(robo setLoop: Grooper setCycle: Walk setHeading: 0 init:)
		(self setScript: EnterShop)
		(self setRegions: 700)
	)
	
	(method (doit &tmp temp0)
		(cond 
			(script (script doit:))
			(
				(and
					(= temp0
						(switch ((global80 alterEgo?) edgeHit?)
							(3 south)
						)
					)
					local2
					local4
				)
				(global2 setScript: ExitScript)
			)
		)
		(super doit:)
	)
	
	(method (dispose)
		(if (and local2 local4)
			((ScriptID 700 0)
				rFlag1: (| ((ScriptID 700 0) rFlag1?) $0080)
			)
		)
		(if
			(and
				(not (proc700_3 (ScriptID 700 0) 679 4))
				(proc700_3 (ScriptID 700 0) 679 2)
				(proc700_3 (ScriptID 700 0) 678 128)
			)
			((ScriptID 700 0)
				rFlag2: (| ((ScriptID 700 0) rFlag2?) $0004)
			)
		)
		(if
		(and (not (proc700_3 (ScriptID 700 0) 679 2)) local0)
			((ScriptID 700 0)
				rFlag2: (| ((ScriptID 700 0) rFlag2?) $0002)
			)
		)
		(super dispose:)
	)
)

(instance bobScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(bobA setCycle: Fwd)
				(= seconds 10)
			)
			(1
				(bobA setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2 (= seconds 3))
			(3 (bobA setCycle: Beg self))
			(4
				(bobA setLoop: 0 setCycle: Fwd)
				(self dispose:)
			)
		)
	)
)

(instance EnterShop of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: MoveTo 192 185 self)
			)
			(1
				(robo setScript: roboClerkWelcome)
				(self dispose:)
			)
		)
	)
)

(instance bobLookScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (tBob say: 2 self))
			(1 (tBob say: 2 self))
			(2 (tBob say: 3 self))
			(3
				(tBob say: 2 self)
				(bobA setScript: bobScript)
			)
		)
	)
)

(instance ExitScript of rmnScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					setMotion: MoveTo (gEgo x?) (+ (gEgo y?) 10) self
				)
			)
			(1 (proc0_13 gEgo robo self))
			(2
				(tClerk modNum: 381 say: 12 self)
			)
			(4
				(proc0_3)
				(global2 newRoom: 380)
			)
			(else  (= cycles 1))
		)
	)
)

(instance roboClerkWelcome of rmnScript
	(properties)
	
	(method (doit)
		(super doit:)
		(if
		(and (== state 4) (global80 canInput:) (gEgo mover?))
			(= seconds 0)
			(proc0_2)
			(proc0_13 gEgo robo self)
		)
	)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if
					(or
						(proc999_5 (gEgo view?) 373 374)
						(not (proc0_6 17))
					)
					(robo
						illegalBits: 0
						xStep: 5
						yStep: 3
						setMotion: MoveTo 203 85 self
					)
				else
					(self changeState: 7)
				)
			)
			(1 (proc0_13 robo gEgo self))
			(2
				(gEgo moveHead: 0)
				(cond 
					((proc999_5 (gEgo view?) 373 374) (tClerk modNum: 381 say: 14 self) (= state 5))
					((proc700_3 (ScriptID 700 0) 679 4) (tClerk modNum: 381 say: 12 self) (= state 5))
					(else (tClerk modNum: 381 say: 1 self))
				)
			)
			(4 (proc0_3) (= seconds 15))
			(5
				(tClerk modNum: 381 say: 2 self)
			)
			(7
				(gEgo moveHead: 1)
				(proc0_3)
				(= cycles 1)
			)
			(8
				(= temp0 (Random 0 3))
				(robo
					setMotion:
						PolyPath
						[local5 (= temp0 (* temp0 2))]
						[local5 (+ temp0 1)]
						self
				)
				(= seconds 10)
			)
			(9
				(= state 7)
				(robo
					setHeading: (Random (Random 0 180) (Random 180 360))
				)
				(= cycles (Random 8 15))
			)
			(10 (self changeState: 7))
			(else  (= cycles 1))
		)
	)
)

(instance measureEgo of rmnScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(robo
					view: 383
					loop: 3
					cel: 0
					heading: 270
					setCycle: CT 1 1 self
					cycleSpeed: 12
				)
			)
			(1
				(robo setCycle: End self)
				(roboSound number: 832 loop: 0 play:)
			)
			(2 (= cycles 3))
			(3
				(robo setCycle: Beg self)
				(roboSound number: 833 loop: 0 play:)
			)
			(4
				(roboSound stop:)
				(robo
					view: 381
					setLoop: Grooper
					setCycle: Walk
					cycleSpeed: 6
					setMotion: MoveTo 163 99 self
				)
			)
			(5
				(robo setMotion: MoveTo 138 99 self)
			)
			(6 (robo setHeading: 90 self))
			(7
				(robo
					view: 383
					setLoop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
				(roboSound number: 832 loop: 0 play:)
			)
			(8 (= cycles 3))
			(9
				(robo setCycle: Beg self)
				(roboSound number: 833 loop: 0 play:)
			)
			(10
				(robo setLoop: 1 cel: 0 setCycle: End self)
				(roboSound number: 832 loop: 0 play:)
			)
			(11 (= cycles 3))
			(12
				(roboSound number: 833 loop: 0 play:)
				(robo setCycle: Beg self)
			)
			(13
				(roboSound stop:)
				(tClerk modNum: 381 say: 3 self)
			)
			(14 (= cycles 1))
			(15
				((ScriptID 700 0)
					rFlag2: (| ((ScriptID 700 0) rFlag2?) $0001)
				)
				(self dispose:)
			)
		)
	)
)

(instance getPants of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo moveHead: 0)
				(if (proc700_3 (ScriptID 700 0) 679 1) (= state 7))
				(robo stopUpd:)
				(gEgo stopUpd:)
				(= cycles 2)
			)
			(1
				(tClerk modNum: 381 say: 13 self)
			)
			(2
				((gEgo _head?) startUpd:)
				(robo startUpd:)
				(if
					(= local1
						(<=
							(GetDistance (robo x?) (robo y?) 140 90 0)
							(GetDistance (gEgo x?) (gEgo y?) 140 90 0)
						)
					)
					(robo ignoreActors: 1 setMotion: PolyPath 180 85 robo)
				else
					(gEgo ignoreActors: 1 setMotion: PolyPath 140 90 self)
				)
			)
			(3
				(if local1
					(= local1 0)
					(gEgo setMotion: PolyPath 140 90 self)
				else
					(= cycles 1)
				)
			)
			(4
				((global2 obstacles?) delete: roboPoly)
				(robo setMotion: MoveTo 163 90 self)
				(gEgo setHeading: 180)
			)
			(5
				(if (not (proc700_3 (ScriptID 700 0) 679 1))
					(self setScript: measureEgo self)
				else
					(= cycles 1)
				)
			)
			(6
				(gEgo illegalBits: -32768 ignoreActors: 0)
				(robo
					view: 381
					setLoop: Grooper
					setCycle: Walk
					cycleSpeed: 6
					setMotion: PolyPath 65 89 self
				)
			)
			(7
				(robo setLoop: 3)
				(= cycles 6)
			)
			(8
				(tClerk modNum: 381 say: 16 self)
			)
			(9 (= cycles 2))
			(10
				(robo
					view: 383
					setLoop: 7
					cel: 0
					setMotion: MoveTo 48 93 self
				)
			)
			(11
				(robo setLoop: 8 heading: 180)
				(= cycles 2)
			)
			(12
				(tClerk modNum: 381 say: 4 self)
			)
			(13
				(gEgo ignoreActors: 1 setMotion: PolyPath 48 100 self)
			)
			(14
				(gEgo ignoreActors: 0 setHeading: 0)
				(robo view: 381 setLoop: Grooper)
				(= cycles 5)
			)
			(15
				(robo setLoop: -1 setMotion: PolyPath 314 68 self)
				(gEgo illegalBits: 0 setMotion: MoveTo -5 (gEgo y?))
			)
			(16 (= cycles 5))
			(17
				(robo posn: 314 100 setMotion: MoveTo 243 117 self)
			)
			(18
				(roboSound stop:)
				(= cycles 2)
			)
			(19
				(gSq4GlobalNarrator modNum: 381 say: 4 self)
			)
			(20
				(gSq4GlobalNarrator modNum: 381 say: 5 self)
			)
			(21
				(gEgo
					view: 0
					setCycle: StopWalk 4
					headView: 4
					setMotion: MoveTo 48 100 self
				)
			)
			(22
				(gEgo illegalBits: -32768)
				(= local2 1)
				(tClerk modNum: 383 say: 5 self)
			)
			(23
				(if (and (>= global159 20) local3)
					(gSq4GlobalNarrator modNum: 381 say: 6)
					(gEgo setMotion: PolyPath 188 135 self)
				else
					(proc0_3)
					(gEgo moveHead: 1)
					(self dispose:)
				)
			)
			(24 (if local3 (= cycles 1)))
			(25
				(proc0_3)
				(robo doVerb: 8)
				(= seconds 30)
			)
			(26
				(robo setMotion: MoveTo 330 (robo y?) self)
			)
			(27
				(roboClerkWelcome start: 6)
				(robo posn: 314 68 setScript: roboClerkWelcome)
			)
		)
	)
)

(instance roboVerbTalkStuff of rmnScript
	(properties)
	
	(method (dispose)
		(if
		(and (not (& (gEgo signal?) $0002)) (gEgo _head?))
			((gEgo _head?) startUpd:)
		)
		(super dispose:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (proc0_6 17))
					(cond 
						((and local2 local4) (self changeState: 21))
						((proc700_3 (ScriptID 700 0) 679 4) (self changeState: 18))
						((proc700_3 (ScriptID 700 0) 679 2) (self changeState: 7))
						(else (= cycles 1))
					)
				else
					(gSq4GlobalNarrator modNum: 381 say: 7)
					(self dispose:)
				)
			)
			(2
				(robo setMotion: 0)
				(switch local0
					(1
						(if (== (robo script?) roboClerkWelcome)
							(roboClerkWelcome dispose:)
						)
						(proc0_13 gEgo robo)
						(proc0_13 robo gEgo)
						(= cycles 4)
					)
					(else  (self dispose:))
				)
			)
			(3
				(robo stopUpd:)
				(gEgo moveHead: 0 stopUpd:)
				(= cycles 2)
			)
			(4
				(tRog modNum: 383 say: 1 self)
			)
			(6
				(robo setScript: getPants)
				(self dispose:)
			)
			(7
				(robo setMotion: 0)
				(if (== (robo script?) roboClerkWelcome)
					(roboClerkWelcome dispose:)
				)
				(if (not local3)
					(= local3 1)
					(proc0_13 robo gEgo 0)
					(= cycles 2)
				else
					(self dispose:)
				)
			)
			(8
				(robo stopUpd:)
				(gEgo moveHead: 0 stopUpd:)
				(= cycles 2)
			)
			(9
				(tRog modNum: 383 say: 2 self)
			)
			(11
				(tClerk modNum: 383 say: 6 self)
			)
			(13
				(tRog modNum: 383 say: 3 self)
			)
			(15
				(tClerk modNum: 383 say: 7 self)
			)
			(17
				(robo setScript: getPants)
				(self dispose:)
			)
			(18
				(tClerk modNum: 381 say: 10 self)
			)
			(20
				(if (>= global159 20)
					(self changeState: 11)
				else
					(self dispose:)
				)
			)
			(21
				(gEgo mover: 0 stopUpd:)
				(= cycles 2)
			)
			(22
				(tClerk modNum: 383 say: 5 self)
			)
			(24 (self dispose:))
			(else  (= cycles 1))
		)
	)
)

(instance roboVerbUseStuff of rmnScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(1
				(switch register
					(8
						(cond 
							(
								(or
									(proc0_6 17)
									(not local4)
									(not local2)
									(not (proc999_5 (gEgo view?) 0 4))
								)
								(Feature doVerb: 8)
								(self dispose:)
							)
							((>= global159 20) (proc0_2) (gEgo setMotion: PolyPath 188 135 self))
							(else
								(if (== (robo script?) getPants) (getPants dispose:))
								(tClerk modNum: 381 say: 9 self)
								(= state 4)
							)
						)
					)
					(18
						(if
							(or
								(proc0_6 17)
								(not local4)
								(not local2)
								(not (proc999_5 (gEgo view?) 0 4))
							)
							(Feature doVerb: 18)
							(self dispose:)
						else
							(tClerk modNum: 381 say: 15 self)
							(= state 7)
						)
					)
					(else 
						(Feature doVerb: register)
						(self dispose:)
					)
				)
			)
			(3 (proc0_13 gEgo robo self))
			(4
				(proc0_11 82 5)
				(tClerk modNum: 381 say: 8 self)
				(proc0_7 17)
				(= local4 0)
				(if (< (= global159 (- global159 20)) 1)
					(gEgo put: 0)
				)
				(proc0_3)
			)
			(6 (self dispose:))
			(7
				((ScriptID 700 0)
					rFlag1: (| ((ScriptID 700 0) rFlag1?) $0080)
				)
				(global2 newRoom: 380)
			)
			(9 (self dispose:))
			(else  (= cycles 1))
		)
	)
)

(instance robo of Sq4Actor
	(properties
		x 235
		y 67
		sightAngle 90
		view 381
		loop 1
		illegalBits $0000
		lookStr 8
	)
	
	(method (init)
		(super init: &rest)
		(aSound prevSignal: -1)
	)
	
	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not local21)
				(not mover)
				(!= (aSound prevSignal?) -1)
			)
			(aSound prevSignal: -1)
			(aSound hold: 0)
		)
		(if local21 (= local21 0))
		(if (and mover (== (aSound prevSignal?) -1))
			(= local21 1)
			(aSound number: 830 loop: 0 play: prevSignal: 0 hold: 1)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if
					(and
						(not (proc999_5 (gEgo view?) 373 374))
						(or
							(and
								(robo script?)
								(or
									((robo script?) isMemberOf: rmnScript)
									(== (robo script?) getPants)
								)
							)
							(not (robo script?))
						)
						(!= (self script?) getPants)
						(!= (rmnProp script?) roboVerbTalkStuff)
					)
					(++ local0)
					(rmnProp setScript: roboVerbTalkStuff)
				else
					(super doVerb: theVerb)
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
				(if (not (rmnProp script?))
					(rmnProp setScript: roboVerbUseStuff theVerb theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
	
	(method (cue)
		(localproc_19f0)
		(getPants cycles: 2)
	)
)

(instance rmnProp of Sq4Prop
	(properties
		x -20
		y -20
		view 920
	)
)

(instance poly1 of Polygon
	(properties
		type $0002
	)
)

(instance poly2 of Polygon
	(properties
		type $0002
	)
)

(instance poly3 of Polygon
	(properties
		type $0002
	)
)

(instance theShop of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		sightAngle 500
		lookStr 9
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gSq4GlobalNarrator modNum: 381 say: 10)
			)
			(else  0)
		)
	)
)

(instance dressingRoom of Sq4Feature
	(properties
		x 28
		y 58
		nsTop 33
		nsLeft 24
		nsBottom 84
		nsRight 33
		sightAngle 90
		lookStr 11
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gSq4GlobalNarrator modNum: 381 say: 12)
			)
			(7
				(gSq4GlobalNarrator modNum: 381 say: 13)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance BargainShelf of Sq4Feature
	(properties
		x 59
		y 48
		nsTop 23
		nsLeft 37
		nsBottom 73
		nsRight 81
		sightAngle 90
		lookStr 14
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if
					(and
						(not (proc0_6 17))
						(== (robo script?) roboClerkWelcome)
					)
					(robo doVerb: 2)
				else
					(super doVerb: theVerb)
				)
			)
			(6
				(gSq4GlobalNarrator modNum: 381 say: 15)
			)
			(7 (gSq4GlobalNarrator say: 30))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance alienSuit1 of Sq4Feature
	(properties
		x 36
		y 130
		nsTop 85
		nsLeft 5
		nsBottom 176
		nsRight 68
		sightAngle 90
		lookStr 16
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gSq4GlobalNarrator modNum: 381 say: 2)
			)
			(7
				(gSq4GlobalNarrator modNum: 381 say: 3)
			)
			(4
				(gSq4GlobalNarrator modNum: 381 say: 1)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance alienSuit2 of Sq4Feature
	(properties
		x 133
		y 116
		nsTop 72
		nsLeft 108
		nsBottom 161
		nsRight 158
		sightAngle 90
		lookStr 17
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gSq4GlobalNarrator modNum: 381 say: 2)
			)
			(7
				(gSq4GlobalNarrator modNum: 381 say: 3)
			)
			(4
				(gSq4GlobalNarrator modNum: 381 say: 1)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance alienSuit3 of Sq4Feature
	(properties
		x 283
		y 130
		nsTop 85
		nsLeft 256
		nsBottom 175
		nsRight 311
		sightAngle 90
		lookStr 18
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gSq4GlobalNarrator modNum: 381 say: 2)
			)
			(7
				(gSq4GlobalNarrator modNum: 381 say: 3)
			)
			(4
				(gSq4GlobalNarrator modNum: 381 say: 1)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance alienSuit4 of Sq4Feature
	(properties
		x 157
		y 31
		nsTop 10
		nsLeft 135
		nsBottom 53
		nsRight 180
		sightAngle 90
		lookStr 19
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gSq4GlobalNarrator modNum: 381 say: 2)
			)
			(7
				(gSq4GlobalNarrator modNum: 381 say: 3)
			)
			(4
				(gSq4GlobalNarrator modNum: 381 say: 1)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance alienSuit5 of Sq4Feature
	(properties
		x 236
		y 32
		nsTop 10
		nsLeft 214
		nsBottom 54
		nsRight 258
		sightAngle 90
		lookStr 20
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gSq4GlobalNarrator modNum: 381 say: 2)
			)
			(7
				(gSq4GlobalNarrator modNum: 381 say: 3)
			)
			(4
				(gSq4GlobalNarrator modNum: 381 say: 1)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance shelves of Sq4Feature
	(properties
		x 109
		y 31
		nsTop 10
		nsLeft 100
		nsBottom 53
		nsRight 119
		sightAngle 90
		lookStr 21
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(gSq4GlobalNarrator modNum: 381 say: 22)
			)
			(6
				(gSq4GlobalNarrator modNum: 381 say: 15)
			)
			(7
				(gSq4GlobalNarrator modNum: 381 say: 23)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance CashRegister of Sq4Feature
	(properties
		x 205
		y 129
		z 32
		nsTop 90
		nsLeft 189
		nsBottom 105
		nsRight 221
		sightAngle 90
		lookStr 24
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(gSq4GlobalNarrator modNum: 381 say: 25)
			)
			(6
				(gSq4GlobalNarrator modNum: 381 say: 26)
			)
			(7
				(gSq4GlobalNarrator modNum: 381 say: 27)
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
				(if (not (rmnProp script?))
					(rmnProp setScript: roboVerbUseStuff theVerb)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance light1 of Sq4Feature
	(properties
		x 23
		y 189
		z 174
		nsTop 10
		nsLeft 9
		nsBottom 20
		nsRight 37
		sightAngle 90
		lookStr 28
	)
)

(instance light2 of Sq4Feature
	(properties
		x 295
		y 189
		z 174
		nsTop 10
		nsLeft 282
		nsBottom 21
		nsRight 309
		sightAngle 90
		lookStr 28
	)
)

(instance bobA of Prop
	(properties
		x 109
		y 27
		sightAngle 40
		approachX 149
		approachY 67
		view 103
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (self loop?)
					(tBob say: 1)
				else
					(self setScript: bobLookScript)
				)
			)
			(2
				(if (self loop?) (tBob say: 5) else (tBob say: 6))
			)
			(else  (tBob say: 4))
		)
	)
)

(instance roboPoly of Polygon
	(properties
		type $0002
	)
)

(instance roboSound of Sound
	(properties)
)

(instance aSound of Sound
	(properties)
)

(instance tBob of Sq4Narrator
	(properties
		noun 38
		modNum 381
		talkerNum 38
	)
)

(instance tRog of Sq4Talker
	(properties
		noun 7
		modNum 383
		view 1008
		talkerNum 7
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 27
		eyeOffsetY 21
	)
)

(instance tClerk of Sq4Talker
	(properties
		noun 23
		view 1707
		talkerNum 23
		mouthOffsetX 9
		mouthOffsetY 33
		eyeOffsetX 18
		eyeOffsetY 16
		tStyle 1
	)
)

;;; Sierra Script 1.0 - (do not remove this comment)
(script# 395)
(include sci.sh)
(use Main)
(use mall)
(use BeltWay)
(use SQRoom)
(use Sq4Dialog)
(use Sq4Narrator)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use n958)
(use StopWalk)
(use Wander)
(use Cycle)
(use User)
(use Obj)

(public
	rm395 0
)

(local
	[local0 2]
	local2
	local3
	local4
	local5
	local6
	local7
	local8 =  245
	local9 =  27
	local10 =  1
	local11
)
(procedure (localproc_1146 param1 &tmp temp0)
	(= temp0 1)
	(switch param1
		(2
			(if (not (global2 script?))
				(if (gEgo inRect: 192 64 239 96)
					(global2 setScript: talkCrowd)
				else
					(gSq4GlobalNarrator say: 12)
				)
			)
		)
		(6 (gSq4GlobalNarrator say: 13))
		(7 (gSq4GlobalNarrator say: 14))
		(else  (= temp0 0))
	)
	(return temp0)
)

(instance rm395 of SQRoom
	(properties
		picture 395
		style $000a
		north 390
		east 400
		south 400
		west 390
	)
	
	(method (init &tmp temp0 temp1)
		(cond 
			((not (proc0_6 24))
				(freak1 init:)
				(freak2 init:)
				(freak3 init:)
				(freak4 init:)
				(freak5 init:)
				(freak6 init:)
				(freak7 init:)
				(freak8 init:)
				(freak1 setScript: freaksComeOut)
				(proc0_7 24)
				(proc0_7 25)
			)
			((proc0_6 25)
				(freak1 init:)
				(freak2 init:)
				(freak3 init:)
				(freak4 init:)
				(freak5 init:)
				(freak6 init:)
				(freak7 init:)
				(freak8 init:)
				(freak1 x: 225 y: 64 stopUpd:)
				(freak5 x: 239 y: 72 stopUpd:)
			)
		)
		(atm init:)
		(letters init:)
		(bush1 init:)
		(bush2 init:)
		(zapper init:)
		(zapper2 init:)
		(b1 init: setStep: 1 1 setMotion: Wander)
		(b2 init: setStep: 1 1 setMotion: Wander)
		(b7 init: setStep: 1 1 setMotion: Wander)
		(if (== (global1 detailLevel:) 0)
			(b1 setMotion: 0 stopUpd:)
			(b2 setMotion: 0 stopUpd:)
			(b7 setMotion: 0 stopUpd:)
		)
		(cond 
			((and (!= global12 397) (not (proc0_6 13))) (gLongSong2 number: 59 loop: -1 flags: 1 play: 95))
			((proc0_6 13) (gLongSong2 number: 0 vol: 0 stop:))
		)
		(if (and (!= global12 397) (!= global160 0))
			(proc0_7 13)
		)
		(= local6 global34)
		(= global34 0)
		(proc0_2)
		(switch global12
			(west
				(if (== ((ScriptID 700 0) whichBelt?) 1)
					(= temp0 -12)
					(= temp1 81)
				else
					(= temp0 -18)
					(= temp1 -2)
				)
				(gEgo
					x: temp0
					y: temp1
					setLoop: gStopGroop
					illegalBits: -32768
				)
				(self setScript: (ScriptID 700 1) 0 egoBwGreen)
			)
			(east
				(if (== ((ScriptID 700 0) whichBelt?) 1)
					(= temp0 232)
					(= temp1 245)
				else
					(= temp0 331)
					(= temp1 173)
				)
				(gEgo
					x: temp0
					y: temp1
					setLoop: gStopGroop
					illegalBits: -32768
				)
				(self setScript: (ScriptID 700 1) 0 egoBwBlue)
			)
			(396
				(gLongSong setVol: 95)
				(= local5 1)
				(gEgo view: 396)
				(useCard start: 9)
				(global2 setScript: useCard)
				(useCard start: 0)
			)
			(397
				(gLongSong number: 405 loop: -1 flags: 1 play: 95)
				(self setScript: fromStoreScript)
			)
			(else 
				(if (== ((ScriptID 700 0) whichBelt?) 1)
					(= temp0 232)
					(= temp1 245)
				else
					(= temp0 331)
					(= temp1 173)
				)
				(gEgo
					x: temp0
					y: temp1
					setLoop: gStopGroop
					illegalBits: -32768
				)
				(self setScript: (ScriptID 700 1) 0 egoBwBlue)
			)
		)
		(if (!= global12 396)
			(gEgo
				view: (if (== global12 396) 396 else (gEgo view?))
				illegalBits: 0
			)
		)
		(if (== global12 396) (gEgo view: 396))
		(gEgo
			setPri: -1
			code: beltwayCode
			init:
			setCycle: SyncWalk
		)
		(super init:)
		(if (proc0_6 13)
			(global10 add: door eachElementDo: #init doit:)
			(global2
				addObstacle:
					((Polygon new:)
						type: 2
						init: 0 129 120 189 0 189
						yourself:
					)
					((Polygon new:)
						type: 2
						init: 0 35 142 110 105 132 0 78
						yourself:
					)
					((Polygon new:)
						type: 2
						init: 294 189 221 189 154 154 188 132
						yourself:
					)
					((Polygon new:)
						type: 2
						init:
							14
							0
							231
							0
							319
							43
							319
							164
							203
							106
							213
							94
							183
							78
							175
							88
							173
							82
							111
							55
							100
							54
							112
							45
							91
							33
							76
							34
						yourself:
					)
			)
		else
			(global2
				addObstacle:
					((Polygon new:)
						type: 2
						init: 0 129 120 189 0 189
						yourself:
					)
					((Polygon new:)
						type: 2
						init: 0 35 142 110 105 132 0 78
						yourself:
					)
					((Polygon new:)
						type: 2
						init: 294 189 221 189 154 154 188 132
						yourself:
					)
					((Polygon new:)
						type: 2
						init: 14 0 247 0 235 54 170 89 99 52 108 45 89 35 76 34
						yourself:
					)
					((Polygon new:)
						type: 2
						init: 319 171 199 101 319 7
						yourself:
					)
			)
		)
		(store init:)
		(self setRegions: 700)
		(= local11 14)
	)
	
	(method (doit &tmp temp0 temp1)
		(if (not (-- local10))
			(cond 
				(
					(<
						(= temp0
							(GetDistance (gEgo x?) (gEgo y?) local8 local9)
						)
						0
					)
					(= temp0 0)
				)
				((> temp0 300) (= temp0 300))
			)
			(gLongSong2 setVol: (- 127 (/ temp0 3)))
			(= local10 60)
		)
		(cond 
			(script 0)
			(
			(and (gEgo edgeHit?) (proc999_5 (gEgo edgeHit?) 2 3 4))
				(cond 
					((proc999_5 (gEgo edgeHit?) 2 3)
						(proc0_2)
						((ScriptID 700 0) enterBelt: egoBwGreen)
						(self setScript: (ScriptID 700 2) 0 east)
					)
					((== (gEgo edgeHit?) 4)
						(proc0_2)
						((ScriptID 700 0) enterBelt: egoBwBlue)
						(self setScript: (ScriptID 700 2) 0 west)
					)
				)
			)
		)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript 804)
		(DisposeScript 970)
		(= global34 local6)
		(super dispose:)
	)
)

(instance beltwayCode of Code
	(properties)
	
	(method (doit &tmp temp0 temp1)
		(cond 
			((global2 script?) 0)
			((& (gEgo onControl:) $4000)
				(if (not local4)
					(= local4 1)
					(proc700_5 1)
					(gEgo setMotion: MoveTo 105 45)
				)
			)
			((& (= temp1 (gEgo onControl: 1)) local11)
				(cond 
					((& temp1 $0008)
						(if (global5 contains: freak1)
							(if (!= (gEgo illegalBits?) -32768)
								(gEgo illegalBits: -32768)
							)
						else
							(global2 newRoom: 397)
						)
					)
					((& temp1 $0004)
						(egoBwGreen who: gEgo doit:)
						((ScriptID 700 0) whichBelt: 1)
						(proc700_5 0)
						(gLongSong fade: 127 10 5 0)
					)
					((& temp1 $0002)
						(= local4 0)
						(egoBwBlue who: gEgo doit:)
						((ScriptID 700 0) whichBelt: 2)
						(proc700_5 0)
						(gLongSong fade: 95 10 5 0)
					)
				)
			)
			((| (egoBwGreen onCon?) (egoBwBlue onCon?))
				(egoBwGreen onCon: 0)
				(egoBwBlue onCon: 0)
				(gEgo xStep: 3 yStep: 2 setPri: -1 illegalBits: -32704)
				(proc700_5 1)
			)
		)
	)
)

(instance useCard of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(sq4 setCursor: gCursorNumber 1 304 172)
				(gEgo setMotion: MoveTo 105 45 self)
			)
			(1 (= cycles 3))
			(2
				(cond 
					((== (gEgo view?) 374) (= local5 1))
					((or (== (gEgo view?) 4) (== (gEgo view?) 0)) (= local5 0))
					(else (= local5 2))
				)
				(gEgo setHeading: 45)
				(= cycles 2)
			)
			(3
				(gEgo
					view: 396
					loop:
					(switch local5
						(0 0)
						(1 2)
						(2 1)
					)
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(4
				(flash
					init:
					posn: 116 22
					loop: 9
					cycleSpeed: 48
					cel: 0
					setCycle: End self
				)
			)
			(5
				(flash loop: 7 cycleSpeed: 6 setCycle: Fwd)
				(= seconds 3)
			)
			(6
				(if (!= local5 1) (flash loop: 8))
				(= seconds 3)
			)
			(7
				(flash dispose:)
				(Animate (global5 elements?) 0)
				(if (== local5 1)
					(proc0_11 83 10)
					(= cycles 2)
				else
					(proc0_7 33)
					(= state 9)
					(gSq4GlobalNarrator modNum: 395 say: 1 self)
				)
			)
			(8
				(if (== local5 1)
					(gLongSong setVol: 30)
					(global2 newRoom: 396)
				else
					(= cycles 2)
				)
			)
			(9
				(gEgo
					view: 396
					setLoop: 2
					setCel: 255
					x: 105
					y: 45
					setHeading: 45
					illegalBits: -32768
					init:
				)
				(= cycles 1)
			)
			(10 (gEgo setCycle: Beg self))
			(11
				(gEgo setSpeed: global199 loop: 6)
				(switch local5
					(0 (proc0_1 6 0))
					(1
						(gEgo
							view: 373
							setCycle: StopWalk 374
							setLoop: -1
							setLoop: gStopGroop
						)
						(proc0_9 374)
					)
					(2
						(gEgo
							view: 402
							setCycle: StopWalk 14
							setLoop: -1
							setLoop: gStopGroop
						)
						(proc0_9 14)
					)
				)
				(= cycles 1)
			)
			(12 (proc0_3) (self dispose:))
		)
	)
)

(class rssScript of Script
	(properties
		client 0
		state $ffff
		start 0
		timer 0
		cycles 0
		seconds 0
		lastSeconds 0
		ticks 0
		lastTicks 0
		register 0
		script 0
		caller 0
		next 0
	)
	
	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if local3
			(if (= temp0 ((User curEvent?) type?))
				(Display 395 0 108 local3)
				(Event dispose:)
				(= local3 0)
				(= seconds 0)
				(= cycles 1)
			)
			(= temp0 0)
		)
	)
)

(instance talkCrowd of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(tROG say: 1 self)
			)
			(1
				(switch local2
					(0
						(tAlien say: 1 self)
						(= local2 1)
					)
					(1
						(= local2 2)
						(tAlien say: 2 self)
					)
					(2
						(tAlien say: 3 self)
						(= local2 3)
					)
					(3
						(gSq4GlobalNarrator say: 4 self)
					)
				)
			)
			(2 (proc0_3) (self dispose:))
		)
	)
)

(instance freaksComeOut of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_2) (= cycles 1))
			(1
				(proc0_2)
				(freak1
					ignoreActors: 1
					setCycle: Walk
					setStep: 4 3
					setMotion: PolyPath 225 64
				)
				(freak5
					ignoreActors: 1
					setCycle: Walk
					setStep: 4 3
					setMotion: PolyPath 239 72 self
				)
			)
			(2 (= cycles 10))
			(3
				(freak1 stopUpd: ignoreActors: 0)
				(freak5 stopUpd: ignoreActors: 0)
				(proc0_3)
				(client setScript: 0)
			)
		)
	)
)

(instance fromStoreScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1 theRegister)
		(switch (= state newState)
			(0
				(proc958_0 128 993 992 26)
				(proc0_2)
				(gEgo
					x: 233
					y: 61
					illegalBits: 0
					setMotion: PolyPath 209 85 self
				)
			)
			(1
				(if (or (not global160) (proc0_6 31))
					(proc0_3)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(2
				(zap init: posn: 208 100 setCycle: Fwd)
				(= cycles 5)
			)
			(3
				(gLongSong2 number: 838 play:)
				(cond 
					((proc999_5 (gEgo view?) 373 374) (= register 993) (= temp0 0))
					((proc999_5 (gEgo view?) 402 14) (= register 992) (= temp0 0))
					((proc999_5 (gEgo view?) 0 4) (= register 26) (= temp0 1))
				)
				(gEgo view: register cel: 0 setLoop: temp0)
				(= cycles 2)
			)
			(4
				(switch register
					(993
						(= theRegister register)
						(= temp1 1)
					)
					(992
						(= theRegister register)
						(= temp1 1)
					)
					(26
						(= theRegister 395)
						(= temp1 5)
					)
				)
				(gEgo view: theRegister setLoop: temp1 setCycle: Fwd)
				(= seconds 5)
			)
			(5
				(gLongSong2 stop: -1)
				(zap dispose:)
				(gEgo view: register cel: 0 setLoop: temp0)
				(= cycles 1)
			)
			(6 (gEgo setCycle: End self))
			(7 (proc0_10 0 2) (= cycles 1))
			(8 (proc0_3) (self dispose:))
		)
	)
)

(instance egoBwGreen of BeltWay
	(properties
		xStep 2
		yStep -1
		xOff 1
		yOff -1
		xTweak 1
		yTweak -1
		key 315
		head 119
		xDir 1
		yDir -1
	)
)

(instance egoBwBlue of BeltWay
	(properties
		xStep 2
		yStep -1
		xOff 1
		yOff -1
		xTweak 1
		yTweak -1
		key 135
		head 301
		xDir -1
		yDir 1
	)
)

(instance door of Sq4View
	(properties
		x 217
		y 90
		view 395
		loop 1
		priority 3
		signal $4010
	)
)

(instance b1 of Sq4Actor
	(properties
		x 295
		y 104
		view 395
		priority 1
		signal $1810
		lookStr 5
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 7)
			(if (== (++ local7) 18) (proc816_1 395 1))
			(super doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
	
	(method (setSpeed)
	)
)

(instance b2 of Sq4Actor
	(properties
		x 272
		y 91
		view 395
		cel 1
		priority 1
		signal $1810
		lookStr 5
	)
	
	(method (setSpeed)
	)
)

(instance b3 of Sq4Actor
	(properties
		x 156
		y 27
		view 395
		cel 2
		priority 1
		signal $1810
		lookStr 5
	)
	
	(method (setSpeed)
	)
)

(instance b4 of Sq4Actor
	(properties
		x 165
		y 40
		view 395
		cel 3
		priority 1
		signal $1810
		lookStr 5
	)
	
	(method (setSpeed)
	)
)

(instance b5 of Sq4Actor
	(properties
		x 272
		y 91
		view 395
		cel 3
		priority 1
		signal $1810
	)
	
	(method (setSpeed)
	)
)

(instance b6 of Sq4Actor
	(properties
		x 160
		y 34
		view 395
		cel 1
		priority 1
		signal $1810
	)
	
	(method (setSpeed)
	)
)

(instance b7 of Sq4Actor
	(properties
		x 165
		y 34
		view 395
		priority 1
		signal $1810
		lookStr 5
	)
	
	(method (setSpeed)
	)
)

(instance zap of Sq4Prop
	(properties
		view 395
		loop 4
	)
)

(instance letters of Sq4Feature
	(properties
		x 198
		y 16
		z 8
		nsLeft 193
		nsBottom 17
		nsRight 204
		sightAngle 90
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (proc816_1 395 2))
		)
	)
)

(instance atm of Sq4Feature
	(properties
		x 110
		y 19
		nsLeft 102
		nsBottom 39
		nsRight 129
		sightAngle 90
		lookStr 6
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (not (& (gEgo onControl: 1) $4000))
					(gSq4GlobalNarrator say: 7)
				else
					(gSq4GlobalNarrator say: 8)
				)
			)
			(18
				(if (not (& (gEgo onControl: 1) $4000))
					(gSq4GlobalNarrator say: 7)
				else
					(global2 setScript: useCard)
				)
			)
			(6 (gSq4GlobalNarrator say: 9))
			(7 (gSq4GlobalNarrator say: 10))
			(else  (super doVerb: theVerb))
		)
	)
)

(class Crowd of Sq4View
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
		lookStr 11
	)
	
	(method (doVerb theVerb)
		(if (not (localproc_1146 theVerb))
			(super doVerb: theVerb)
		)
	)
)

(instance freak1 of Sq4Actor
	(properties
		x 156
		y 117
		view 382
		illegalBits $0000
		lookStr 11
	)
	
	(method (doVerb theVerb)
		(if (self inRect: 185 25 259 67)
			(if (not (localproc_1146 theVerb))
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance freak2 of Crowd
	(properties
		x 219
		y 54
		view 388
	)
)

(instance freak3 of Crowd
	(properties
		x 254
		y 69
		view 384
	)
)

(instance freak4 of Crowd
	(properties
		x 263
		y 76
		view 401
		loop 3
	)
)

(instance freak5 of Sq4Actor
	(properties
		x 125
		y 133
		view 384
		illegalBits $0000
		lookStr 11
	)
	
	(method (doVerb theVerb)
		(if (self inRect: 185 25 259 67)
			(if (not (localproc_1146 theVerb))
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance freak6 of Crowd
	(properties
		x 202
		y 57
		view 7
		cel 1
	)
)

(instance freak7 of Crowd
	(properties
		x 244
		y 77
		view 395
		loop 6
	)
)

(instance freak8 of Crowd
	(properties
		x 200
		y 60
		view 395
		loop 6
		cel 1
	)
)

(instance flash of Sq4Prop
	(properties
		view 395
		loop 7
	)
)

(instance store of Sq4Feature
	(properties
		x 280
		y 30
		lookStr 15
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (gSq4GlobalNarrator say: 16))
			(7 (gSq4GlobalNarrator say: 17))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (onMe param1)
		(return
			(>=
				-51
				(/ (* 100 (- 154 (param1 y?))) (- (param1 x?) 320))
			)
		)
	)
)

(instance bush1 of Sq4Feature
	(properties
		x 52
		y 60
		nsTop 41
		nsLeft 46
		nsBottom 69
		nsRight 66
		lookStr 18
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (gSq4GlobalNarrator say: 18))
			(7 (gSq4GlobalNarrator say: 18))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush2 of Sq4Feature
	(properties
		x 245
		y 150
		nsTop 140
		nsLeft 238
		nsBottom 167
		nsRight 261
		lookStr 18
	)
	
	(method (doVerb theVerb)
		(bush1 doVerb: theVerb)
	)
)

(instance zapper of Sq4Feature
	(properties
		x 179
		y 58
		nsTop 57
		nsLeft 177
		nsBottom 60
		nsRight 181
		sightAngle 90
		lookStr 19
	)
)

(instance zapper2 of Sq4Feature
	(properties
		x 239
		y 89
		nsTop 88
		nsLeft 238
		nsBottom 91
		nsRight 240
		sightAngle 90
		lookStr 19
	)
)

(instance tROG of Sq4Talker
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

(instance tAlien of Sq4Talker
	(properties
		z 400
		noun 29
		view 1368
		talkerNum 29
		eyeLoop -1
		mouthOffsetX 21
		mouthOffsetY 12
	)
)

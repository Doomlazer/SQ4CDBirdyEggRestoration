;;; Sierra Script 1.0 - (do not remove this comment)
(script# 390)
(include sci.sh)
(use Main)
(use mall)
(use BeltWay)
(use SQRoom)
(use Sq4Narrator)
(use Sq4Feature)
(use MCyc)
(use Polygon)
(use MoveFwd)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm390 0
)

(local
	[local0 18] = [181 5 187 8 197 14 211 16 225 20 235 31 250 36 263 41 274 45]
	[local18 37] = [0 0 181 5 0 1 187 8 0 2 197 14 0 3 211 16 0 4 225 20 0 5 235 31 0 6 250 36 0 7 263 41 0 8 274 45 -32768]
	local55
	local56
	gEgoX_2
	gEgoX
	local59
	local60
	local61
)
(instance rm390 of SQRoom
	(properties
		picture 390
		style $000a
		north 385
		east 395
		south 395
		west 385
	)
	
	(method (init &tmp temp0 temp1)
		(proc0_2)
		(gLongSong2 number: 999 loop: -1 play: 127)
		(switch global12
			(west
				(if (== ((ScriptID 700 0) whichBelt?) 1)
					(= temp0 -12)
					(= temp1 81)
				else
					(= temp0 -9)
					(= temp1 -6)
				)
				(gEgo x: temp0 y: temp1 setLoop: gStopGroop)
				(self setScript: (ScriptID 700 1) 0 egoBwGreen)
			)
			(east
				(if (== ((ScriptID 700 0) whichBelt?) 1)
					(= temp0 256)
					(= temp1 249)
				else
					(= temp0 331)
					(= temp1 173)
				)
				(gEgo x: temp0 y: temp1 setLoop: gStopGroop)
				(self setScript: (ScriptID 700 1) 0 egoBwBlue)
			)
			(410
				(gLongSong number: 405 loop: -1 play:)
				(self setScript: fromElsewhereScript 0 0)
			)
			(else 
				(gIconBar enable:)
				(gLongSong number: 405 play:)
				(self setScript: fromElsewhereScript 0 1)
			)
		)
		(gLongSong setVol: 127 setPri: 7)
		(super init:)
		(gEgo
			setPri: -1
			code: beltwayCode
			init:
			setCycle: SyncWalk
		)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init: 0 113 65 145 64 157 44 170 40 179 13 189 0 189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 0 23 147 99 110 123 0 65
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 235 189 149 144 189 120 319 187 319 189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 150 189 95 189 117 171
					yourself:
				)
		)
		(if (and (proc0_6 23) (not (proc0_6 22)))
			(Load rsSOUND 105)
			((ScriptID 700 7)
				illegalBits: 0
				ignoreActors:
				init:
				posn: -14 79
				setScript: sp2Squeeze
			)
			((ScriptID 700 6) illegalBits: 0 ignoreActors:)
		)
		(self setRegions: 700)
		(store init:)
		(bush1 init:)
		(bush2 init:)
		(steps init:)
		(if (proc0_6 12)
			(global10 add: door eachElementDo: #init doit:)
			(self
				addObstacle:
					((Polygon new:)
						type: 2
						init: 21 0 319 0 319 150 224 101 235 82 181 53 156 69
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: 2
						init: 316 0 163 73 21 0
						yourself:
					)
					((Polygon new:)
						type: 2
						init: 319 152 226 105 319 51
						yourself:
					)
			)
		)
		(= local60 30)
	)
	
	(method (doit &tmp [temp0 2])
		(cond 
			(script 0)
			((gEgo edgeHit?)
				(proc0_2)
				(if (proc999_5 (gEgo edgeHit?) 3 2)
					((ScriptID 700 0) enterBelt: egoBwGreen)
					(self setScript: (ScriptID 700 2) 0 east)
				else
					((ScriptID 700 0) enterBelt: egoBwBlue)
					(self setScript: (ScriptID 700 2) 0 west)
				)
			)
		)
		(Palette palANIMATE 225 236 6)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript 804)
		(super dispose:)
	)
	
	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 391) (gLongSong fade: 40 10 10 0))
		(cond 
			((proc999_5 newRoomNumber 391 410 900) (super newRoom: newRoomNumber))
			((!= script (ScriptID 700 2)) (proc0_2) (self setScript: (ScriptID 700 2) 0 1))
			((and script (not (script register?))) (super newRoom: newRoomNumber))
			(else (super newRoom: newRoomNumber))
		)
	)
)

(instance beltwayCode of Code
	(properties)
	
	(method (doit &tmp temp0 temp1)
		(cond 
			((global2 script?) 0)
			((& (= temp1 (gEgo onControl: 1)) local60)
				(cond 
					((& temp1 $0010) (proc0_2) (global2 setScript: goToRamaScript))
					((& temp1 $0008) (global2 newRoom: 391))
					((& temp1 $0004)
						(egoBwGreen who: gEgo doit:)
						((ScriptID 700 0) whichBelt: 1)
						(proc700_5 0)
						(gLongSong fade: 127 10 5 0)
					)
					((& temp1 $0002)
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
				(gEgo xStep: 3 yStep: 2 setPri: -1)
				(proc700_5 1)
			)
		)
	)
)

(instance fromElsewhereScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(if register
					(= temp0 224)
					(= temp1 54)
					(= temp2 196)
					(= temp3 82)
				else
					(= temp0 -3)
					(= temp1 244)
					(= temp2 71)
					(= temp3 170)
				)
				(gEgo
					x: temp0
					y: temp1
					setMotion: MoveTo temp2 temp3 self
				)
			)
			(1
				(proc700_5 1)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance goToRamaScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 225 setMotion: MoveFwd 80 self)
			)
			(1 (global2 newRoom: 410))
		)
	)
)

(instance zapScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					x: [local0 register]
					y: [local0 (+ register 1)]
					cel: (/ register 2)
				)
				(if (and (< register 3) (> global106 1))
					(signSound play:)
				)
				(= cycles 1)
			)
			(1
				(if (> (= register (+ register 2)) 16) (= register 0))
				(= cycles 3)
			)
			(2 (self init:))
		)
	)
)

(instance sZap of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(client setCycle: MCyc @local18 self)
			)
			(1 1 (signSound play: self))
			(2 2 (self changeState: 0))
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
		tixCnt 6
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
		tixCnt 6
	)
)

(instance door of Sq4View
	(properties
		x 181
		y 28
		view 390
		loop 1
		priority 3
		signal $4010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 375 say: 1)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sp2Squeeze of Script
	(properties)
	
	(method (doit &tmp temp0)
		(super doit: &rest)
		(cond 
			(
				(and
					(not state)
					(or (< (gEgo x?) 219) (proc0_5 gEgo 8192))
				)
				(self cue:)
			)
			((global2 script?))
			(
				(and
					(< (gEgo y?) (- ((ScriptID 700 7) y?) 12))
					(not (proc0_5 gEgo 8192))
				)
				(client setScript: sp2ShootEgo)
			)
			((& (= temp0 (gEgo onControl: 1)) $0001) (client setScript: sp2ShootDown))
			((& temp0 $2000) (global2 setScript: hideEgoInStore))
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				((ScriptID 700 7)
					view: 7
					setLoop: 2
					setCel: 5
					setStep: 2 2
					setMotion: MoveTo 89 133 self
				)
			)
			(2
				((ScriptID 700 6) init: setScript: sp1Squeeze)
				((ScriptID 700 7)
					setStep: 3 2
					setCycle: Walk
					setLoop: -1
					setCel: -1
					setMotion: MoveTo 134 122 self
				)
			)
			(3
				((ScriptID 700 7) view: 13 loop: 3 cel: 0 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance sp1Squeeze of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(cond 
			((global2 script?))
			(
				(and
					(< ((ScriptID 700 6) x?) 310)
					(not (& (gEgo onControl: 1) $2000))
				)
				(client setScript: sp1ShootEgo)
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 700 6)
					setStep: 2 2
					posn: 330 182
					view: 13
					setLoop: 1
					setCel: 0
					init:
					setMotion: MoveTo 199 112 self
				)
			)
			(1
				((ScriptID 700 6)
					setStep: 3 2
					view: 7
					setCycle: Walk
					setLoop: -1
					setCel: -1
					setMotion: MoveTo 159 116 self
				)
			)
			(2
				((ScriptID 700 6) view: 13 loop: 1 cel: 0 stopUpd:)
				(= seconds 3)
			)
			(3 (tSP1 say: 1))
			(4
				(tSP2 say: 1 self 2 64 175 70 67 140)
			)
			(5
				(tSP1 say: 2 self 2 64 175 80 67 140)
			)
			(6
				(tSP2 say: 2 self 2 64 175 70 67 140)
			)
			(7
				(tSP1 say: 3 self 2 64 175 80 67 140)
			)
			(8
				(tSP2 say: 3 self 2 64 175 70 67 140)
			)
			(9
				(tSP2 say: 4 self 2 64 175 70 67 140)
			)
			(10
				(tSP1 say: 4 self 2 64 175 80 67 140)
			)
			(11
				((ScriptID 700 6) view: 7 setMotion: MoveTo 148 85 self)
			)
			(12
				((ScriptID 700 6)
					view: 13
					setLoop: 1
					setCel: 0
					setStep: 2 2
					setMotion: MoveTo 1 1
				)
				(= cycles 10)
			)
			(13
				((ScriptID 700 7) view: 7 setMotion: MoveTo 143 156 self)
			)
			(14
				((ScriptID 700 7)
					view: 13
					setLoop: 0
					setCel: 0
					setStep: 2 2
					setMotion: MoveTo 267 236 self
				)
			)
			(15
				(hideEgoInStore cue:)
				(self dispose:)
			)
		)
	)
)

(instance sp1ShootEgo of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				((ScriptID 700 6) setLoop: 3 cel: 0 setCycle: End self)
			)
			(1
				(= local55 (- (gEgo y?) 33))
				(= local56 (- ((ScriptID 700 6) y?) 34))
				(= gEgoX (gEgo x?))
				(= gEgoX_2 (- ((ScriptID 700 6) x?) 8))
				(= local59
					(Graph
						grSAVE_BOX
						(- local55 1)
						(- gEgoX 1)
						(+ local56 1)
						(+ gEgoX_2 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local56
					gEgoX_2
					local55
					gEgoX
					(proc0_18 global133 global143)
					(- (gEgo priority?) 1)
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local55 1)
					(- gEgoX 1)
					(+ local56 1)
					(+ gEgoX_2 1)
				)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(2
				(Graph grRESTORE_BOX local59)
				(Graph
					grREDRAW_BOX
					(- local55 1)
					(- gEgoX 1)
					(+ local56 1)
					(+ gEgoX_2 1)
				)
				(blast
					init:
					cel: 0
					posn: gEgoX local55
					setPri: (+ (gEgo priority?) 1)
					setCycle: End
				)
				(gEgo
					view: 26
					cel: 0
					cycleSpeed: 12
					ignoreActors:
					setCycle: End self
				)
			)
			(3 (proc0_10 8 3))
		)
	)
)

(instance sp2ShootDown of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				((ScriptID 700 7)
					view: 13
					setLoop: 4
					setCel: 0
					setPri: (gEgo priority?)
				)
				(= cycles 4)
			)
			(1
				((ScriptID 700 7) setCycle: CT 1 1 self)
			)
			(2
				(= local56 (- (gEgo y?) 33))
				(= local55 (- ((ScriptID 700 7) y?) 20))
				(= gEgoX_2 (gEgo x?))
				(= gEgoX (+ ((ScriptID 700 7) x?) 11))
				(= local59
					(Graph
						grSAVE_BOX
						(- local55 1)
						(- gEgoX 1)
						(+ local56 1)
						(+ gEgoX_2 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local55
					gEgoX
					local56
					gEgoX_2
					(proc0_18 global133 global143)
					(- (gEgo priority?) 1)
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local55 1)
					(- gEgoX 1)
					(+ local56 1)
					(+ gEgoX_2 1)
				)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(3
				((ScriptID 700 7) setCel: 0)
				(Graph grRESTORE_BOX local59)
				(Graph
					grREDRAW_BOX
					(- local55 1)
					(- gEgoX 1)
					(+ local56 1)
					(+ gEgoX_2 1)
				)
				(blast
					init:
					cel: 0
					posn: gEgoX_2 local56
					setPri: (+ (gEgo priority?) 1)
					setCycle: End
				)
				(gEgo
					view: 26
					cel: 0
					cycleSpeed: 12
					ignoreActors:
					setCycle: End self
				)
			)
			(4 (proc0_10 8 3))
		)
	)
)

(instance sp2ShootEgo of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				((ScriptID 700 7) view: 13 setLoop: 0 setCel: 0)
				(= cycles 2)
			)
			(1
				((ScriptID 700 7) setCycle: CT 1 1 self)
			)
			(2
				(= local55 (- (gEgo y?) 33))
				(= local56 (- ((ScriptID 700 7) y?) 28))
				(= gEgoX_2 (gEgo x?))
				(= gEgoX (+ ((ScriptID 700 7) x?) 16))
				(= local59
					(Graph
						grSAVE_BOX
						(- local55 1)
						(- gEgoX 1)
						(+ local56 1)
						(+ gEgoX_2 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local56
					gEgoX
					local55
					gEgoX_2
					(proc0_18 global133 global143)
					(- (gEgo priority?) 1)
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local55 1)
					(- gEgoX 1)
					(+ local56 1)
					(+ gEgoX_2 1)
				)
				((ScriptID 700 7) setCycle: End)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(3
				(Graph grRESTORE_BOX local59)
				(Graph
					grREDRAW_BOX
					(- local55 1)
					(- gEgoX 1)
					(+ local56 1)
					(+ gEgoX_2 1)
				)
				(blast
					init:
					cel: 0
					posn: gEgoX_2 local55
					setPri: (+ (gEgo priority?) 1)
					setCycle: End
				)
				(gEgo
					view: 26
					cel: 0
					cycleSpeed: 12
					ignoreActors:
					setCycle: End self
				)
			)
			(4 (proc0_10 8 3))
		)
	)
)

(instance hideEgoInStore of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo illegalBits: 0 setMotion: MoveTo 192 49 self)
			)
			(1
				(gEgo setPri: 1 setMotion: MoveTo 171 47)
			)
			(2
				(gEgo setMotion: MoveTo 192 49 self)
			)
			(3
				(gEgo setPri: -1 setMotion: MoveTo 199 86 self)
			)
			(4 (= cycles 4))
			(5
				(gSq4GlobalNarrator say: 1)
				(proc0_3)
				(gEgo illegalBits: -32768)
				(self dispose:)
			)
		)
	)
)

(instance blast of Sq4Prop
	(properties
		view 28
		signal $4000
	)
)

(instance signSound of Sound
	(properties
		number 391
		priority 1
	)
)

(instance store of Sq4Feature
	(properties
		x 280
		y 30
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gSq4GlobalNarrator say: 3))
			(7 (gSq4GlobalNarrator say: 5))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (onMe param1)
		(return
			(>=
				-51
				(/ (* 100 (- 151 (param1 y?))) (- (param1 x?) 320))
			)
		)
	)
)

(instance steps of Sq4Feature
	(properties
		y 185
		lookStr 1
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 1))
			(6 (gSq4GlobalNarrator say: 6))
			(7
				(if
				(or (== (gEgo view?) 374) (== (gEgo view?) 373))
					(tRogette say: 1)
				else
					(tRog say: 1)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (onMe param1)
		(return (== (OnControl 4 (param1 x?) (param1 y?)) 2048))
	)
)

(instance bush1 of Sq4Feature
	(properties
		x 60
		y 45
		nsTop 32
		nsLeft 49
		nsBottom 62
		nsRight 70
		lookStr 7
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (gSq4GlobalNarrator say: 8))
			(7 (gSq4GlobalNarrator say: 9))
			(4 (gSq4GlobalNarrator say: 10))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush2 of Sq4Feature
	(properties
		x 245
		y 140
		nsTop 129
		nsLeft 239
		nsBottom 157
		nsRight 261
		lookStr 7
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (gSq4GlobalNarrator say: 8))
			(7 (gSq4GlobalNarrator say: 9))
			(4 (gSq4GlobalNarrator say: 10))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
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

(instance tSP1 of Sq4Talker
	(properties
		z 400
		noun 22
		view 1015
		talkerNum 22
		mouthOffsetX 22
		mouthOffsetY 35
	)
)

(instance tSP2 of Sq4Talker
	(properties
		z 400
		noun 14
		view 1016
		talkerNum 14
		mouthOffsetX 21
		mouthOffsetY 34
		eyeOffsetX 1
		eyeOffsetY 1
	)
)

(instance aSound of Sound
	(properties)
)

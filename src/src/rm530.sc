;;; Sierra Script 1.0 - (do not remove this comment)
(script# 530)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Narrator)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use n958)
(use StopWalk)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm530 0
)

(local
	local0
	local1
	[local2 48] = [131 40 143 42 157 41 168 36 175 30 180 23 184 16 255 15 260 24 262 50 248 63 240 64 224 79 219 79 203 80 187 80 187 79 172 79 171 80 146 80 146 78 123 78 129 52 124 37]
)
(procedure (localproc_0d1b param1 param2 param3 param4 &tmp temp0 temp1 temp2)
	(aSound number: 105 loop: 1 vol: 127 play:)
	(if (< param1 param3)
		(= temp0 (- param1 1))
		(= temp1 (+ param3 1))
	else
		(= temp0 (- param3 1))
		(= temp1 (+ param1 1))
	)
	(= temp2
		(Graph
			grSAVE_BOX
			temp0
			(- param2 1)
			temp1
			(+ param4 1)
			1
		)
	)
	(Graph
		grDRAW_LINE
		param1
		param2
		param3
		param4
		global143
		-1
		-1
	)
	(Graph
		grREDRAW_BOX
		temp0
		(- param2 1)
		temp1
		(+ param4 1)
	)
	(Wait 1)
	(Wait 4)
	(Graph grRESTORE_BOX temp2)
	(Graph
		grREDRAW_BOX
		temp0
		(- param2 1)
		temp1
		(+ param4 1)
	)
)

(instance rm530 of SQRoom
	(properties
		picture 530
		east 535
		vanishingX 319
		vanishingY -60
	)
	
	(method (init)
		(proc0_2)
		(proc958_0 128 0 378 530 300 26)
		(proc958_0 132 124 125 131 838)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init: 257 172 270 152 319 152 319 172
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						31
						170
						0
						170
						0
						0
						319
						0
						319
						52
						267
						52
						254
						65
						246
						67
						230
						83
						133
						83
						117
						81
						71
						114
						77
						117
						111
						112
						144
						119
						158
						126
						181
						114
						205
						115
						228
						134
						216
						140
						180
						144
						143
						151
						128
						150
						119
						138
						85
						149
						69
						150
						60
						145
					yourself:
				)
				((Polygon new:)
					type: 0
					init: 167 165 167 189 127 189 127 166
					yourself:
				)
		)
		(timePod0 init:)
		(terminal init:)
		(switch global12
			(531
				(self
					setScript:
						(if (proc0_6 2)
							egoArrives
						else
							(if (not (proc0_6 26))
								(proc958_0 128 7 13)
								(Load rsSOUND 105)
								(sp1 loop: 2 init:)
								(sp2 view: 7 loop: 2 x: 185 y: 91 init:)
							)
							(gEgo
								view: 378
								loop: 0
								cel: 0
								posn: 188 149
								setPri: 11
								ignoreActors:
								illegalBits: 0
								cycleSpeed: 12
								normal: 0
								moveHead: 0
								init:
							)
							egoExits
						)
				)
			)
			(else 
				(proc958_0 128 7 13)
				(Load rsSOUND 105)
				(self style: 11)
				(if (proc0_6 1)
					(proc0_2)
					(hatch init: cel: (if (proc0_6 26) 0 else 0))
					(pod init:)
					(if (not (proc0_6 26))
						(sp1 loop: 0 init:)
						(sp2 view: 7 loop: 0 x: 185 y: 91 init:)
					)
					(gEgo
						x: 282
						y:
							(cond 
								((not (proc0_6 26)) 130)
								((> (gEgo y?) 152) 152)
								(else (gEgo y?))
							)
						init:
					)
					(proc0_9)
					(self setScript: enterScript)
				else
					(sp1 init:)
					(gEgo x: 284 y: 130 init:)
					(sp1 setScript: policeArrive)
				)
			)
		)
		(proc0_7 1)
		(global32
			add: theRedBall theRailView1 theRailView2 building
			eachElementDo: #init
			doit:
		)
		(super init:)
		(self setRegions: 709)
		(buildingPoly points: @local2 size: 24)
	)
	
	(method (doit)
		(super doit: &rest)
		(if (> (gEgo x?) 300)
			(proc0_2)
			(global2 newRoom: 535)
		)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 0 (= cycles 1))
			(1
				(gEgo
					setCycle: StopWalk 4
					setMotion: MoveTo (if (< (gEgo y?) 85) 273 else 255) (gEgo y?) self
				)
			)
			(2
				(if (proc0_6 26)
					(proc0_3)
					(client setScript: 0)
				else
					(policeArrive start: 18)
					(client setScript: policeArrive)
				)
			)
		)
	)
)

(instance egoArrives of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 8))
			(1
				(sparks init: setCycle: Fwd)
				(= cycles 10)
			)
			(2
				(pod cel: 0 init: setCycle: CT 6 1 self)
			)
			(3 (= cycles 12))
			(4
				(sparks dispose:)
				(= cycles 1)
			)
			(5
				(gLongSong2 fade: 80 15 10 0)
				(global2 newRoom: 531)
			)
		)
	)
)

(instance policeArrive of Script
	(properties)
	
	(method (init)
		(super init: &rest)
		(= register 200)
	)
	
	(method (doit)
		(super doit: &rest)
		(if (and (> 18 state) (> (super doit: &rest) 13))
			(-- register)
		)
		(if
			(or
				(== register 0)
				(and (< (gEgo y?) 128) (< state 18))
			)
			(= register -1)
			(= state 17)
			(= cycles (= seconds 0))
			(if (not local1) (self cue:) else (self dispose:))
		)
		(if (== (global2 script?) (ScriptID 709 1))
			(self dispose:)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 8))
			(1
				(sparks init: setCycle: Fwd)
				(= cycles 10)
			)
			(2
				(proc0_13 sp1 pod)
				(pod cel: 0 init: setCycle: CT 6 1 self)
			)
			(3
				(hatch init: cel: 0 setPri: (+ (hatch priority?) 2))
				(pod setCel: 7)
				(= cycles 12)
			)
			(4
				(sp1 stopUpd:)
				(sparks dispose:)
				(pod stopUpd:)
				(= cycles 1)
			)
			(5
				(gLongSong number: 124 loop: 1 vol: 127 play: self)
			)
			(6
				(hatch setCycle: End self)
				(sp2 view: 378 loop: 2 cel: 0 x: 198 y: 148 init:)
			)
			(7
				(hatch stopUpd:)
				(sp2 cycleSpeed: 4 setCycle: End self)
			)
			(8 (= cycles 2))
			(9
				(sp2
					view: 7
					loop: 0
					x: (+ (sp2 x?) 13)
					y: (+ (sp2 y?) 5)
					moveSpeed: 5
					cycleSpeed: 5
					setCycle: Walk
					setMotion: PolyPath 185 91 self
				)
			)
			(10
				(proc0_3)
				(sp2 setCel: 5)
				(gEgo setMotion: MoveTo 262 130)
				(sp1 setHeading: 90 self)
			)
			(11
				(sp1 stopUpd:)
				(= cycles 5)
			)
			(12
				(sp2 stopUpd:)
				(tSP1 say: 1 self)
			)
			(13 (tSP1 say: 2 self))
			(14
				(proc0_3)
				(tSP1 say: 3 self)
			)
			(15 (tSP2 say: 4 self))
			(16 (tSP2 say: 5 self))
			(17)
			(18
				(proc0_2)
				(proc0_13 sp1 gEgo)
				(= cycles 3)
			)
			(19
				(proc0_13 sp2 gEgo)
				(sp1 view: 13 cel: 0 setCycle: End self)
			)
			(20
				(if (< (sp1 x?) (gEgo x?))
					(localproc_0d1b
						(- (sp1 y?) 27)
						(sp1 x?)
						(- (gEgo y?) 32)
						(gEgo x?)
					)
				else
					(localproc_0d1b
						(- (gEgo y?) 32)
						(gEgo x?)
						(- (sp1 y?) 27)
						(sp1 x?)
					)
				)
				(gEgo
					view: 26
					loop:
						(switch (gEgo loop?)
							(4 0)
							(5 1)
							(6 0)
							(7 1)
							(else  (gEgo loop?))
						)
					cel: 0
					cycleSpeed: 6
					setCycle: CT 2 1 self
				)
			)
			(21
				(gEgo setCycle: CT 1 -1 self)
			)
			(22 (gEgo setCycle: End self))
			(23 (= seconds 2))
			(24 (tSP1 say: 6 self))
			(25 (tSP1 say: 7 self))
			(26 (proc0_10 8))
		)
	)
)

(instance egoExits of Script
	(properties)
	
	(method (init)
		(super init: &rest)
		(if
			(and
				(global5 contains: sp1)
				(== (sp1 script?) policeArrive)
			)
			(sp1 setScript: 0)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLongSong2 number: 535 loop: -1 vol: 127 changeState:)
				(pod setCel: 7 init: stopUpd:)
				(hatch
					init:
					cel: 0
					setPri: (+ (hatch priority?) 2)
					setCycle: End self
				)
			)
			(1 (= cycles 4))
			(2 (gEgo setCycle: End self))
			(3
				(gEgo loop: 1 normal: 1 moveHead: 1 view: 0)
				(proc0_1)
				(= cycles 1)
			)
			(4
				(if (proc0_6 26)
					(hatch setPri: 10 setCycle: Beg self)
				else
					(policeArrive start: 18)
					(client setScript: policeArrive)
				)
			)
			(5
				(proc0_3)
				(client setScript: 0)
			)
		)
	)
)

(instance egoEntersPod of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= local1 1)
				(gEgo setMotion: PolyPath 188 150 self)
			)
			(1
				(if (not (hatch cel?))
					(hatch setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(2
				(= global67 0)
				(gEgo
					view: 378
					loop: 1
					cel: 0
					setPri: 11
					posn: 191 126
					ignoreActors:
					illegalBits: 0
					cycleSpeed: 18
					normal: 0
					moveHead: 0
					setCycle: End self
				)
			)
			(3 (= cycles 4))
			(4
				(hatch cel: 5 setPri: 12 setCycle: Beg self)
			)
			(5
				(gLongSong number: 125 loop: 0 play: self)
				(proc0_11 56 10)
				(= global67 1)
			)
			(6
				(gLongSong2 fade: 80 15 10 0)
				(global2 newRoom: 531)
			)
		)
	)
)

(instance pod of Sq4Prop
	(properties
		x 127
		y 129
		view 530
		loop 1
		cel 7
		priority 10
		signal $4010
		cycleSpeed 8
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (not (hatch cel?))
					(gSq4GlobalNarrator say: 1)
				else
					(gSq4GlobalNarrator say: 1)
				)
			)
			(4
				(global2 setScript: egoEntersPod)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance hatch of Sq4Prop
	(properties
		x 162
		y 131
		z 18
		view 530
		loop 2
		cel 9
		priority 10
		signal $4010
	)
	
	(method (doVerb theVerb)
		(pod doVerb: theVerb)
	)
	
	(method (motionCue)
		(hatchSound stop: loop: 0)
		(super motionCue: &rest)
	)
	
	(method (setCycle)
		(super setCycle: &rest)
		(hatchSound init: play:)
	)
)

(instance hatchSound of Sound
	(properties
		number 142
	)
)

(instance sparks of Sq4Prop
	(properties
		x 145
		y 108
		view 530
		priority 13
		signal $4010
	)
	
	(method (init)
		(super init: &rest)
		(aSound number: 838 loop: 1 play:)
	)
	
	(method (dispose)
		(aSound stop:)
		(super dispose:)
	)
)

(instance sp1 of Sq4Actor
	(properties
		x 156
		y 91
		view 7
		loop 3
		signal $4000
		lookStr 2
	)
)

(instance sp2 of Sq4Actor
	(properties
		signal $4000
		lookStr 2
	)
)

(instance terminal of Sq4Feature
	(properties
		x 159
		y 61
		heading 180
		nsTop 43
		nsLeft 148
		nsBottom 80
		nsRight 170
		sightAngle 150
		lookStr 3
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(proc0_2)
				(global2 setScript: doTerminal)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance doTerminal of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: PolyPath (terminal x?) (terminal y?) self
				)
			)
			(1
				(gSq4GlobalNarrator say: 4)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance theRedBall of Sq4Feature
	(properties
		x 147
		y 141
		z 120
		nsBottom 200
		nsRight 320
		onMeCheck $0010
		lookStr 5
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theRailView1 of Sq4Feature
	(properties
		x 59
		y 68
		nsBottom 200
		nsRight 320
		onMeCheck $0020
		lookStr 6
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theRailView2 of Sq4Feature
	(properties
		x 270
		y 33
		nsBottom 200
		nsRight 320
		sightAngle 180
		onMeCheck $0040
		lookStr 6
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(else  (super doVerb: theVerb))
		)
	)
)

(instance timePod0 of Sq4Feature
	(properties
		lookStr 1
	)
	
	(method (onMe param1)
		(return (& (OnControl 4 (param1 x?) (param1 y?)) $0002))
	)
)

(instance building of Sq4Feature
	(properties
		sightAngle 45
		lookStr 7
	)
	
	(method (init)
		(super init: &rest)
		(self onMeCheck: buildingPoly)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gSq4GlobalNarrator say: 8))
			(6 (gSq4GlobalNarrator say: 9))
			(7 (gSq4GlobalNarrator say: 10))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance buildingPoly of Polygon
	(properties)
)

(instance aSound of Sound
	(properties)
)

(instance tROGER of Sq4Talker
	(properties
		z 400
		noun 7
		view 1008
		talkerNum 7
		mouthOffsetX 22
		mouthOffsetY 31
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
		mouthOffsetX 24
		mouthOffsetY 34
		eyeOffsetX 1
		eyeOffsetY 1
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

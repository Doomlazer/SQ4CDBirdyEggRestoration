;;; Sierra Script 1.0 - (do not remove this comment)
(script# 376)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Narrator)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm376 0
)

(local
	local0
	local1
	local2
	gEgoX
	local4
	local5
	local6
	[theKid 7]
	local14
	local15
)
(instance rm376 of SQRoom
	(properties
		picture 376
		style $000a
		south 375
	)
	
	(method (init)
		(= local15 (global1 detailLevel:))
		(proc0_3)
		(if (not (proc0_6 2))
			(self setRegions: 700)
		else
			(DisposeScript 700)
		)
		(if (and local0 (proc0_6 29)) (Load rsSOUND 105))
		(Load rsVIEW 376)
		(if (>= global191 5) (screen1 setCel: 2))
		(screen1 init:)
		(screen2 init: setCycle: Fwd)
		(screen3 init: setCycle: Fwd)
		(screen4 init: setCycle: Fwd)
		(screen5 init: setPri: 12 setCycle: Fwd)
		(screen6 init:)
		(screen7 init:)
		(if (> (global1 detailLevel:) 2)
			(screen6 setCycle: Fwd)
			(screen7 setCycle: Fwd)
		)
		(screen10 init: setCycle: Fwd)
		(= [theKid 0] kid)
		((= [theKid 1] (kid new:))
			loop: 8
			x: 197
			y: 175
			cycleSpeed: 12
			init:
		)
		((= [theKid 2] (kid new:))
			loop: 9
			x: 240
			y: 134
			cycleSpeed: 18
			init:
		)
		((= [theKid 3] (kid new:))
			loop: 10
			x: 97
			y: 114
			cycleSpeed: 24
			init:
		)
		((= [theKid 4] (kid new:))
			loop: 11
			x: 80
			y: 128
			cycleSpeed: 6
			priority: 7
			signal: 16400
			init:
		)
		((= [theKid 5] (kid new:))
			loop: 12
			x: 118
			y: 172
			cycleSpeed: 12
			init:
		)
		((= [theKid 6] (kid new:))
			loop: 13
			x: 285
			y: 137
			cycleSpeed: 24
			init:
		)
		(kid init:)
		(basket init: addToPic:)
		(gLongSong number: 0 stop:)
		(gLongSong2 vol: 127 changeState:)
		(switch (global1 detailLevel:)
			(0 (kid setScript: aniKids 0 1))
			(1 (kid setScript: aniKids 0 2))
			(2 (kid setScript: aniKids 0 3))
			(3 (kid setScript: aniKids 0 4))
		)
		(if (proc0_6 5)
			(pod cel: 7 init: stopUpd:)
			(hatch init: stopUpd:)
		else
			(= local0 1)
			(blast init: stopUpd:)
		)
		(global32
			add: changeMachine sushiBar arcadeRoom
			eachElementDo: #init
			doit:
		)
		(super init:)
		(tCanTalker init: 0 0 basket)
		(switch global12
			(531
				(gLongSong2 number: 19 vol: 127 loop: -1 flags: 1)
				(self
					setScript:
						(if (proc0_6 2)
							egoArrives
						else
							(gEgo
								view: 377
								loop: 3
								cel: 0
								posn: 27 156
								setPri: 12
								ignoreActors:
								illegalBits: 0
								normal: 0
								moveHead: 0
								init:
							)
							egoExitsPod
						)
				)
			)
			(375
				(gEgo
					posn: (if (> (gEgo y?) 57) 100 else 220) 188
					init:
				)
				(if
					(or
						(proc0_6 3)
						(and (proc0_6 19) (not (proc0_6 22)))
					)
					(Load rsSOUND 105)
					(sp2 init: setPri: -1 posn: (gEgo x?) 143)
					(blast init: stopUpd:)
					(proc0_2)
					(self setScript: shootDown)
				)
				(global2
					addObstacle:
						((Polygon new:)
							type: 2
							init:
								0
								189
								0
								0
								319
								0
								319
								188
								257
								189
								239
								181
								233
								175
								234
								168
								236
								161
								256
								151
								289
								149
								267
								132
								257
								132
								255
								138
								226
								138
								219
								126
								238
								123
								213
								108
								132
								107
								130
								109
								118
								109
								110
								114
								96
								117
								86
								127
								73
								132
								61
								132
								41
								145
								43
								148
								59
								156
								80
								158
								69
								172
								59
								172
								49
								177
								10
								189
							yourself:
						)
						((Polygon new:)
							type: 2
							init:
								206
								185
								175
								185
								175
								189
								143
								189
								143
								185
								115
								185
								119
								176
								91
								170
								96
								162
								128
								162
								140
								123
								118
								116
								118
								112
								202
								111
								202
								116
								175
								123
								194
								162
								219
								162
								225
								180
								202
								180
							yourself:
						)
				)
			)
			(290
				(gLongSong2
					number: 19
					vol: 127
					loop: -1
					flags: 1
					playBed:
				)
				(gEgo posn: 58 143 init:)
				(if (proc0_6 22)
					(Load rsSOUND 105)
					(bogusSP init:)
					(sp2 init: setPri: -1 posn: (+ (gEgo x?) 20) (gEgo y?))
					(blast init: stopUpd:)
					(proc0_2)
					(self setScript: shootDown)
				)
				(if
				(and (== (++ global191) 5) (not (proc0_6 22)))
					(global2 setScript: zapMsChickenS)
				)
				(proc0_3)
				(global2
					addObstacle:
						((Polygon new:)
							type: 2
							init:
								0
								189
								0
								0
								319
								0
								319
								188
								257
								189
								239
								181
								233
								175
								234
								168
								236
								161
								256
								151
								289
								149
								267
								132
								257
								132
								255
								138
								226
								138
								219
								126
								238
								123
								213
								108
								132
								107
								130
								109
								118
								109
								110
								114
								96
								117
								86
								127
								73
								132
								61
								132
								41
								145
								43
								148
								59
								156
								80
								158
								69
								172
								59
								172
								49
								177
								10
								189
							yourself:
						)
						((Polygon new:)
							type: 2
							init:
								206
								185
								175
								185
								175
								189
								143
								189
								143
								185
								115
								185
								119
								176
								91
								170
								96
								162
								128
								162
								140
								123
								118
								116
								118
								112
								202
								111
								202
								116
								175
								123
								194
								162
								219
								162
								225
								180
								202
								180
							yourself:
						)
				)
			)
			(else 
				(proc0_1)
				(gEgo posn: 107 184 init:)
				(global2
					addObstacle:
						((Polygon new:)
							type: 2
							init:
								0
								189
								0
								0
								319
								0
								319
								188
								257
								189
								239
								181
								233
								175
								234
								168
								236
								161
								256
								151
								289
								149
								267
								132
								257
								132
								255
								138
								226
								138
								219
								126
								238
								123
								213
								108
								132
								107
								130
								109
								118
								109
								110
								114
								96
								117
								86
								127
								73
								132
								61
								132
								41
								145
								43
								148
								59
								156
								80
								158
								69
								172
								59
								172
								49
								177
								10
								189
							yourself:
						)
						((Polygon new:)
							type: 2
							init:
								206
								185
								175
								185
								175
								189
								143
								189
								143
								185
								115
								185
								119
								176
								91
								170
								96
								162
								128
								162
								140
								123
								118
								116
								118
								112
								202
								111
								202
								116
								175
								123
								194
								162
								219
								162
								225
								180
								202
								180
							yourself:
						)
				)
			)
		)
	)
	
	(method (doit)
		(super doit: &rest)
		(if (!= local15 (global1 detailLevel:))
			(if (> (= local15 (global1 detailLevel:)) 1)
				(screen6 setCycle: Fwd)
				(screen7 setCycle: Fwd)
			else
				(screen6 stopUpd:)
				(screen7 stopUpd:)
			)
		)
		(if
			(and
				local0
				(== (gEgo onControl: 1) 2)
				(== (gEgo view?) 0)
				(global5 contains: gEgo)
			)
			(gEgo setScript: spArrive)
		)
	)
)

(instance spArrive of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(if
		(and (== state 4) (== (gLongSong prevSignal?) -1))
			(self cue:)
		)
	)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gLongSong number: 838 vol: 127 loop: 1 play:)
				(proc0_2)
				(proc0_7 5)
				(proc0_7 19)
				(proc0_7 8)
				(kid setScript: 0)
				(= temp0 0)
				(while (<= temp0 6)
					([theKid temp0] addToPic:)
					(++ temp0)
				)
				(= local0 0)
				(sparks init: setCycle: Fwd)
				(= cycles 10)
			)
			(1
				(gLongSong fade:)
				(pod init: setCycle: CT 6 1 self)
			)
			(2
				(gEgo setHeading: 230)
				(hatch init:)
				(pod cel: 7)
				(= cycles 1)
			)
			(3
				(pod stopUpd:)
				(sp1 init:)
				(= cycles 6)
			)
			(4
				(gLongSong number: 124 loop: 1 play:)
				(sparks dispose:)
			)
			(5
				(gLongSong number: 142 play:)
				(hatch setCycle: End self)
			)
			(6
				(gLongSong number: 0 stop:)
				(sp1 setCycle: End self)
			)
			(7
				(sp1
					view: 7
					setCycle: Walk
					setLoop: -1
					setCel: -1
					setPri: -1
					setStep: 2 3
				)
				(sp2 init: posn: 3 159 setMotion: MoveTo 27 156 self)
			)
			(8
				(sp1 setMotion: MoveTo 68 155)
				(sp2 posn: 27 156 setCycle: End self)
			)
			(9
				(sp2
					view: 7
					setCycle: Walk
					setLoop: -1
					setCel: -1
					setPri: -1
					setStep: 2 3
					stopUpd:
				)
				(hatch setCycle: Beg self)
			)
			(10
				(hatch stopUpd:)
				(sp1 setMotion: MoveTo 89 160 self)
			)
			(11
				(sp1 setMotion: MoveTo 69 237 self)
			)
			(12
				(sp1 dispose:)
				(proc0_3)
				(sp2 setMotion: MoveTo 60 145 self)
			)
			(13
				(sp2 setMotion: MoveTo 112 119 self)
			)
			(14
				(sp2 setPri: 7 setMotion: MoveTo 203 119 self)
			)
			(15
				(sp2 setPri: -1 setMotion: MoveTo 242 188 self)
			)
			(16
				(sp2 setMotion: MoveTo 242 220 self)
			)
			(17 (proc0_3) (self dispose:))
		)
	)
)

(instance shootDown of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setScript: 0)
				(sp2 setMotion: 0 view: 13 setLoop: 2 cel: 0)
				(= cycles 6)
			)
			(1
				(tSP2 say: 1)
				(gEgo setMotion: 0)
				(sp2 setPri: -1 stopUpd:)
				(= cycles 7)
			)
			(2
				(proc0_12 local14)
				(sp2 setCycle: CT 2 1 self)
			)
			(3
				(if (< (gEgo distanceTo: sp2) 50)
					(self changeState: 8)
				else
					(= local2 (- (sp2 y?) 31))
					(= local4 155)
					(= local5 (- (sp2 x?) 4))
					(= gEgoX 248)
					(= local1
						(Graph
							grSAVE_BOX
							local2
							(- local5 1)
							local4
							(+ gEgoX 1)
							1
						)
					)
					(Graph
						grDRAW_LINE
						local2
						local5
						local4
						gEgoX
						(proc0_18 global133 global132)
						(- (gEgo priority?) 1)
						-1
					)
					(Graph
						grREDRAW_BOX
						local2
						(- local5 1)
						local4
						(+ gEgoX 1)
					)
					(aSound number: 105 loop: 1 vol: 127 play:)
					(= cycles 1)
				)
			)
			(4
				(sp2 cel: 0)
				(blast setCycle: End)
				(= cycles 2)
			)
			(5
				(Graph grRESTORE_BOX local1)
				(Graph
					grREDRAW_BOX
					local2
					(- local5 1)
					local4
					(+ gEgoX 1)
				)
				(= cycles 12)
			)
			(6 (sp2 setCycle: CT 2 1 self))
			(7 (sp2 stopUpd:) (= cycles 1))
			(8
				(proc0_2)
				(gEgo setMotion: 0)
				(= local2 (- (sp2 y?) 31))
				(= local4 (- (gEgo y?) 28))
				(= local5 (- (sp2 x?) 4))
				(= gEgoX (gEgo x?))
				(= local1
					(Graph
						grSAVE_BOX
						local2
						(- local5 1)
						local4
						(+ gEgoX 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local2
					local5
					local4
					gEgoX
					(proc0_18 global133 global132)
					(- (gEgo priority?) 1)
					-1
				)
				(Graph
					grREDRAW_BOX
					local2
					(- local5 1)
					local4
					(+ gEgoX 1)
				)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(9
				(blast
					cel: 0
					posn: gEgoX local4
					setPri: 15
					setCycle: End self
				)
			)
			(10 (proc0_10 8 1))
		)
	)
)

(instance shootOther of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setScript: 0)
				(sp2 setMotion: 0 view: 13 setLoop: register cel: 0)
				(= cycles 2)
			)
			(1
				(tSP2 say: 1)
				(gEgo setMotion: 0)
				(sp2 stopUpd:)
				(= cycles 7)
			)
			(2
				(proc0_12 local14)
				(sp2 setCycle: CT 1 1 self)
			)
			(3
				(if (== register 3)
					(= local5 (+ (sp2 x?) 6))
					(= local4 (- (sp2 y?) 33))
				else
					(= local5 (+ (sp2 x?) 27))
					(= local4 (- (sp2 y?) 29))
				)
				(= gEgoX (+ (gEgo x?) 2))
				(= local2 (- (gEgo y?) 34))
				(= local1
					(Graph
						grSAVE_BOX
						local2
						(- local5 1)
						local4
						(+ gEgoX 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local4
					local5
					local2
					gEgoX
					(proc0_18 global133 global132)
					(- (gEgo priority?) 1)
					-1
				)
				(Graph
					grREDRAW_BOX
					local2
					(- local5 1)
					local4
					(+ gEgoX 1)
				)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(4
				(blast
					cel: 0
					posn: gEgoX local2
					setPri: 15
					setCycle: End self
				)
			)
			(5 (proc0_10 8 1))
		)
	)
)

(instance egoArrives of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_2) (= cycles 8))
			(1
				(pod init: setCycle: CT 2 1 self)
			)
			(2
				(gLongSong number: 838 loop: 1 vol: 127 play:)
				(sparks init: setCycle: Fwd)
				(pod setCycle: CT 6 1 self)
			)
			(3
				(pod setCel: 7 setPri: -1 stopUpd:)
				(hatch init: stopUpd:)
				(= cycles 12)
			)
			(4
				(gLongSong number: 0 stop:)
				(sparks dispose:)
				(= cycles 1)
			)
			(5
				(proc0_3)
				(gLongSong2 fade: 80 15 10 0)
				(global2 newRoom: 531)
			)
		)
	)
)

(instance egoExitsPod of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(if
		(and (== state 0) (== (gLongSong prevSignal?) -1))
			(self cue:)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLongSong number: 124 vol: 127 loop: 1 play:)
				(proc0_7 5)
				(= local0 0)
				(pod setCel: 7 init: stopUpd:)
				(hatch init:)
			)
			(1
				(gLongSong number: 142 play:)
				(hatch setCycle: End self)
			)
			(2
				(gLongSong stop:)
				(= cycles 4)
			)
			(3 (gEgo setCycle: End self))
			(4
				(gLongSong play:)
				(hatch setCycle: Beg self)
			)
			(5
				(gLongSong number: 125 play:)
				(hatch stopUpd:)
				(gEgo loop: 0 normal: 1 moveHead: 1 view: 0)
				(proc0_1)
				(gEgo setMotion: PolyPath 51 146 self)
			)
			(6
				(gLongSong number: 0)
				(global2
					addObstacle:
						((Polygon new:)
							type: 2
							init:
								0
								189
								0
								0
								319
								0
								319
								188
								257
								189
								239
								181
								233
								175
								234
								168
								236
								161
								256
								151
								289
								149
								267
								132
								257
								132
								255
								138
								226
								138
								219
								126
								238
								123
								213
								108
								132
								107
								130
								109
								118
								109
								110
								114
								96
								117
								86
								127
								73
								132
								61
								132
								41
								145
								43
								148
								59
								156
								80
								158
								69
								172
								59
								172
								49
								177
								10
								189
							yourself:
						)
						((Polygon new:)
							type: 2
							init:
								206
								185
								175
								185
								175
								189
								143
								189
								143
								185
								115
								185
								119
								176
								91
								170
								96
								162
								128
								162
								140
								123
								118
								116
								118
								112
								202
								111
								202
								116
								175
								123
								194
								162
								219
								162
								225
								180
								202
								180
							yourself:
						)
				)
				(proc0_3)
				(self dispose:)
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
				(gEgo setMotion: PolyPath 27 156 self)
			)
			(1
				(gLongSong number: 142 loop: 1 vol: 127 play:)
				(hatch setCycle: End self)
			)
			(2
				(gLongSong stop:)
				(gEgo
					view: 377
					loop: 3
					cel: 5
					posn: 27 156
					setPri: 13
					ignoreActors:
					illegalBits: 0
					normal: 0
					moveHead: 0
					setCycle: Beg self
				)
			)
			(3
				(if (proc0_6 22)
					(proc0_11 87 15)
					(= cycles 12)
				else
					(= cycles 4)
				)
			)
			(4
				(gLongSong play:)
				(hatch setCycle: Beg self)
			)
			(5
				(gLongSong number: 125 play:)
				(= cycles 2)
			)
			(6
				(gLongSong number: 0 stop:)
				(proc0_8 5)
				(gLongSong2 fade: 80 15 10 0)
				(global2 newRoom: 531)
			)
		)
	)
)

(instance playChicken of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 58 143 self)
			)
			(1 (gEgo setHeading: 270 self))
			(2
				(gLongSong2 fade:)
				(global2 newRoom: 290)
			)
		)
	)
)

(instance changeMachineDeathS of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					view: 26
					cel: 0
					setMotion: 0
					cycleSpeed: 12
					setCycle: CT 1 1 self
				)
			)
			(1 (gEgo setCycle: Beg self))
			(2 (proc0_10 8 29))
		)
	)
)

(instance zapMsChickenS of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(blast
					view: 28
					init:
					setPri: 2
					posn: 35 113
					cel: 0
					setCycle: End self
				)
			)
			(1
				(blast posn: 25 84 cel: 0 setCycle: End self)
			)
			(2
				(screen1 setCel: 2)
				(blast posn: 0 121 cel: 0 setCycle: End self)
			)
			(3
				(blast posn: 22 103 cel: 0 setCycle: End self)
			)
			(4
				(blast posn: 47 109 cel: 0 setCycle: End self)
			)
			(5
				(gSq4GlobalNarrator say: 13)
				(blast view: 499 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance pod of Sq4Prop
	(properties
		x 26
		y 161
		view 377
		priority 12
		signal $4010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 14))
			(4
				(proc0_2)
				(if (not (shootDown client?))
					(global2 setScript: egoEntersPod)
				)
			)
			(6 (gSq4GlobalNarrator say: 15))
			(7 (gSq4GlobalNarrator say: 16))
			(else  (super doVerb: theVerb))
		)
	)
	
	(method (onMe param1)
		(return
			(if (super onMe: param1)
				(& (OnControl 2 (param1 x?) (param1 y?)) $1000)
			else
				0
			)
		)
	)
)

(instance sparks of Sq4Prop
	(properties
		x 32
		y 140
		view 377
		loop 1
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

(instance hatch of Sq4Prop
	(properties
		x 2
		y 132
		view 377
		loop 2
		priority 14
		signal $4010
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

(instance sp1 of Sq4Actor
	(properties
		x 27
		y 156
		sightAngle 90
		view 377
		loop 4
		priority 13
		signal $4810
		illegalBits $0000
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 17))
			(2 (gSq4GlobalNarrator say: 1))
			(6 (gSq4GlobalNarrator say: 2))
			(7 (gSq4GlobalNarrator say: 3))
			(4 (gSq4GlobalNarrator say: 2))
			(11
				(gSq4GlobalNarrator modNum: 700 say: 4)
			)
			(9 (gSq4GlobalNarrator say: 6))
			(14 (gSq4GlobalNarrator say: 7))
			(17 (gSq4GlobalNarrator say: 8))
			(12 (gSq4GlobalNarrator say: 8))
			((proc999_5 theVerb 8 10 13 15 16 19 18)
				(gSq4GlobalNarrator say: 5)
			)
			((proc999_5 theVerb 20 21 22 23)
				(gSq4GlobalNarrator say: 4)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance sp2 of Sq4Actor
	(properties
		sightAngle 90
		view 377
		loop 4
		priority 13
		signal $4810
		illegalBits $0000
		xStep 2
	)
	
	(method (doit)
		(super doit: &rest)
		(cond 
			(script)
			(
				(and
					(> x 203)
					(< y (gEgo y?))
					(& (gEgo onControl: 1) $0004)
				)
				(self setScript: shootDown)
			)
			(
				(and
					(== y 119)
					(or
						(& (gEgo onControl: 1) $0002)
						(gEgo inRect: 146 104 247 125)
					)
				)
				(self setScript: shootOther 0 0)
			)
			((and (> y (gEgo y?)) (< (gEgo x?) 148)) (self setScript: shootOther 0 3))
			((and (> y (+ (gEgo y?) 4)) (> x 170)) (self setScript: shootOther 0 3))
		)
	)
	
	(method (doVerb)
		(sp1 doVerb: &rest)
	)
)

(instance blast of Sq4Prop
	(properties
		x 248
		y 155
		view 499
		loop 1
		priority 12
		signal $4010
	)
)

(instance bogusSP of Sq4View
	(properties
		x 63
		y 103
		view 376
		loop 15
		priority 12
		signal $4010
	)
)

(instance screen1 of Sq4Prop
	(properties
		x 25
		y 108
		view 376
		priority 2
		signal $0010
		cycleSpeed 2
	)
	
	(method (doVerb theVerb param2)
		(if (or (== theVerb 4) (== theVerb 8))
			(cond 
				((>= global191 5) (gSq4GlobalNarrator say: 19))
				(global159
					(if (not (-- global159)) (gEgo put: 0))
					(proc0_2)
					(global2 setScript: playChicken)
				)
				(else (gSq4GlobalNarrator say: 20))
			)
		else
			(switch theVerb
				(1 (gSq4GlobalNarrator say: 12))
				(6 (gSq4GlobalNarrator say: 9))
				(7 (gSq4GlobalNarrator say: 10))
				(else 
					(super doVerb: theVerb param2)
				)
			)
		)
	)
)

(instance screen2 of Sq4Prop
	(properties
		x 60
		y 99
		view 376
		loop 1
		signal $4000
		cycleSpeed 2
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 21))
			(4 (gSq4GlobalNarrator say: 11))
			(6 (gSq4GlobalNarrator say: 9))
			(7 (gSq4GlobalNarrator say: 10))
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
				(gSq4GlobalNarrator say: 11)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance screen3 of Sq4Prop
	(properties
		x 82
		y 91
		sightAngle 90
		view 376
		loop 2
		cel 1
		signal $4000
		cycleSpeed 2
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 22))
			(4 (gSq4GlobalNarrator say: 11))
			(6 (gSq4GlobalNarrator say: 9))
			(7 (gSq4GlobalNarrator say: 10))
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
				(gSq4GlobalNarrator say: 11)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance screen4 of Sq4Prop
	(properties
		x 261
		y 84
		sightAngle 90
		view 376
		loop 3
		cel 1
		signal $4000
		cycleSpeed 2
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 23))
			(6 (gSq4GlobalNarrator say: 9))
			(7 (gSq4GlobalNarrator say: 10))
			(
				(proc999_5
					theVerb
					4
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
				(gSq4GlobalNarrator say: 11)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance screen5 of Sq4Prop
	(properties
		x 294
		y 151
		view 376
		loop 4
		cel 1
		signal $4000
		cycleSpeed 2
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 24))
			(6 (gSq4GlobalNarrator say: 9))
			(7 (gSq4GlobalNarrator say: 10))
			(
				(proc999_5
					theVerb
					4
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
				(gSq4GlobalNarrator say: 11)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance screen6 of Sq4Prop
	(properties
		x 82
		y 29
		view 376
		loop 5
		cel 1
		signal $4000
		cycleSpeed 2
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 25))
			(4 (gSq4GlobalNarrator say: 26))
			(6 (gSq4GlobalNarrator say: 27))
			(7 (gSq4GlobalNarrator say: 28))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance screen7 of Sq4Prop
	(properties
		x 240
		y 28
		view 376
		loop 6
		signal $4000
		cycleSpeed 2
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 29))
			(4 (gSq4GlobalNarrator say: 26))
			(6 (gSq4GlobalNarrator say: 27))
			(7 (gSq4GlobalNarrator say: 28))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance screen10 of Sq4Prop
	(properties
		x 310
		y 114
		view 376
		loop 14
		signal $4000
		cycleSpeed 2
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 30))
			(6 (gSq4GlobalNarrator say: 9))
			(7 (gSq4GlobalNarrator say: 10))
			(
				(proc999_5
					theVerb
					4
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
				(gSq4GlobalNarrator say: 11)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance basket of Sq4Prop
	(properties
		x 160
		y 187
		view 1376
		loop 1
		signal $4000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 31))
			(4 (gSq4GlobalNarrator say: 32))
			(2 (self setScript: sBasket))
			(6 (gSq4GlobalNarrator say: 34))
			(
				(proc999_5
					theVerb
					4
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
				(gSq4GlobalNarrator say: 35)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sBasket of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gSq4GlobalNarrator say: 33 self)
			)
			(1 (tCanTalker say: 1 self))
			(2
				(proc0_3)
				(client setScript: 0)
			)
		)
	)
)

(instance kid of Sq4Prop
	(properties
		x 266
		y 172
		view 376
		loop 7
		signal $4001
		cycleSpeed 2
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 36))
			(4 (gSq4GlobalNarrator say: 37))
			(2 (gSq4GlobalNarrator say: 38))
			(6 (gSq4GlobalNarrator say: 39))
			(else  (super doVerb: theVerb))
		)
	)
	
	(method (isNotHidden)
		(return 1)
	)
)

(instance aniKids of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0 0)
				(while (<= temp0 register)
					([theKid (Random 0 6)] setCycle: Fwd)
					(++ temp0)
				)
				(= seconds (Random 4 7))
			)
			(1
				(= temp0 0)
				(while (<= temp0 6)
					(if (not (& ([theKid temp0] signal?) $0004))
						([theKid temp0] stopUpd:)
					)
					(++ temp0)
				)
				(= seconds (Random 3 5))
			)
			(2
				(self register: (global1 detailLevel:) changeState: 0)
			)
		)
	)
)

(instance changeMachine of Sq4Feature
	(properties
		x 159
		y 117
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 40))
			(4
				(cond 
					((not (gEgo inRect: 116 102 206 124)) (gSq4GlobalNarrator say: 41))
					((proc999_5 (gEgo view?) 373 374) (gSq4GlobalNarrator say: 42))
					((and local6 (not (global2 script?))) (global2 setScript: changeMachineDeathS))
					(else (gSq4GlobalNarrator say: 43) (= local6 1))
				)
			)
			(8 (gSq4GlobalNarrator say: 44))
			(else  (super doVerb: theVerb))
		)
	)
	
	(method (onMe param1)
		(return (& (OnControl 4 (param1 x?) (param1 y?)) $2000))
	)
)

(instance sushiBar of Sq4Feature
	(properties)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 45))
			(4 (gSq4GlobalNarrator say: 46))
			(8 (gSq4GlobalNarrator say: 47))
			(6 (gSq4GlobalNarrator say: 48))
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
	
	(method (onMe param1)
		(return (& (OnControl 4 (param1 x?) (param1 y?)) $0200))
	)
)

(instance arcadeRoom of Sq4Feature
	(properties
		sightAngle 180
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 49))
			(4 (gSq4GlobalNarrator say: 50))
			(else  (super doVerb: theVerb))
		)
	)
	
	(method (onMe)
		(return 1)
	)
)

(instance aSound of Sound
	(properties)
)

(instance hatchSound of Sound
	(properties
		number 142
	)
)

(instance tCanTalker of FaceTalker
	(properties
		modNum 376
		talkerNum 15
	)
)

(instance tRog of Sq4Talker
	(properties
		z 400
		noun 7
		view 1008
		talkerNum 14
		mouthOffsetX 26
		mouthOffsetY 32
		eyeOffsetX 25
		eyeOffsetY 21
		tStyle 2
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
	)
)

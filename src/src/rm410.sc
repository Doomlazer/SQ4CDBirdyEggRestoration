;;; Sierra Script 1.0 - (do not remove this comment)
(script# 410)
(include sci.sh)
(use Main)
(use mall)
(use MoveToY)
(use Inertia)
(use SQRoom)
(use Sq4Feature)
(use MCyc)
(use PolyPath)
(use Polygon)
(use MoveFwd)
(use n958)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm410 0
)

(local
	[local0 149] = [0 0 -100 -100 1 0 117 -4 1 0 107 9 1 0 99 20 1 0 91 29 1 0 86 39 1 1 79 47 1 2 71 54 1 2 66 63 1 3 62 72 1 4 63 78 1 4 70 84 1 5 75 87 1 5 84 91 1 5 93 95 1 6 105 97 1 7 117 98 1 7 129 98 1 7 143 95 1 8 157 91 1 8 166 82 1 8 168 73 1 9 167 67 1 10 161 62 1 10 151 59 1 11 143 56 1 11 132 55 1 12 120 53 1 12 108 51 1 12 96 48 1 12 87 44 1 12 76 39 1 12 65 34 1 12 43 23 1 12 32 15 1 12 23 0 0 0 -100 -100 -32768]
	[local149 133] = [0 0 -100 -100 2 0 169 -3 2 0 169 9 2 0 170 21 2 0 170 33 2 0 172 45 2 0 173 56 2 0 175 67 2 0 177 78 2 1 179 86 2 1 182 93 2 2 185 100 2 3 190 106 2 4 196 111 2 5 201 113 2 6 206 117 2 7 210 123 2 8 220 129 2 9 228 127 2 10 237 125 2 11 243 121 2 12 249 119 2 13 256 116 2 14 263 108 2 14 267 94 2 14 270 80 2 14 271 65 2 14 271 48 2 14 273 32 2 14 274 14 2 14 277 0 2 14 280 -14 0 0 -100 -100 -32768]
	local282
	local283
	local284
	local285
	local286
	local287
	local288
	local289
	local290
	local291
	local292
	local293
	local294
)
(instance rm410 of SQRoom
	(properties
		picture 410
		horizon 8
		north 411
		east 390
		west 405
	)
	
	(method (init)
		(proc0_2)
		(proc958_0 128 400 403)
		(switch (gEgo view?)
			(0 (proc958_0 128 406 407))
			(402 (proc958_0 128 398 411))
		)
		(proc958_0 132 0 105 401 406)
		(skate1Snd init:)
		(skate2Snd init:)
		(switch global12
			(north
				(self setScript: enterScript 0 north style: 10)
			)
			(west
				(self setScript: enterScript 0 west style: 12)
			)
			(else 
				(gLongSong
					number: 406
					loop: -1
					vol: 127
					flags: 1
					playBed:
				)
				(gLongSong2 number: 0 stop:)
				(self setScript: enterScript 0 east style: 10)
			)
		)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init: 319 167 319 189 259 189 302 165
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 319 113 272 126 250 126 250 0 319 0
					yourself:
				)
		)
		(gEgo init:)
		(super init:)
		(skater1 init: setScript: (Clone skaterScript))
		(skater2 init: setScript: (Clone skaterScript))
		(cond 
			(
			(or (proc0_6 20) (and (== global12 390) (proc0_6 22)))
				(proc958_0 128 408 409 28)
				((ScriptID 700 6) init: hide: setScript: swimAfterEgo)
			)
			((not (proc0_6 19)))
			((== global12 390)
				(proc958_0 128 7 13 28 409)
				((ScriptID 700 7)
					init:
					hide:
					setScript: enterAndShootEgo
				)
			)
			(else
				(proc958_0 128 13 28 409)
				((ScriptID 700 7) init: setScript: shootEgo)
			)
		)
		(self setRegions: 700)
		(global32
			add: skateorama light steps wall restOfMall
			eachElementDo: #init
			doit:
		)
	)
	
	(method (doit)
		(cond 
			(script 0)
			(
				(or
					(== (gEgo view?) 409)
					(>= local282 8)
					(and
						(== ((ScriptID 700 6) script?) swimAfterEgo)
						(swimAfterEgo state?)
					)
				)
				(gEgo edgeHit: 0)
			)
			((proc0_5 gEgo 2)
				(proc0_2)
				(cond 
					((proc999_5 (gEgo view?) 373 374)
						(gEgo x: (+ (gEgo x?) 4) setMotion: 0)
						(gSq4GlobalNarrator modNum: 405 say: 1)
						(proc0_3)
					)
					((proc999_5 (gEgo view?) 406 398) (self setScript: endSwimScript))
					(else (self setScript: startSwimScript))
				)
			)
			((proc0_5 gEgo 4) (proc0_2) (self setScript: landScript))
			((== (gEgo edgeHit?) 1) (proc0_2) (self setScript: exitScript 0 north))
			((== (gEgo edgeHit?) 4) (proc0_2) (self setScript: exitScript 0 west))
			((== (gEgo edgeHit?) 3) (proc0_2) (self setScript: stayInScript))
		)
		(super doit: &rest)
	)
	
	(method (dispose)
		(if (global8 contains: skate1Snd) (skate1Snd dispose:))
		(if (global8 contains: skate2Snd) (skate2Snd dispose:))
		(super dispose: &rest)
	)
	
	(method (newRoom newRoomNumber)
		(if
		(and (!= newRoomNumber west) (!= newRoomNumber north))
			(gLongSong fade:)
		)
		(if (and (proc0_6 20) (not (proc0_6 22)))
			(proc0_7 22)
			(proc0_7 8)
			(proc0_7 10)
			(proc0_7 11)
			(proc0_7 13)
			(proc0_7 12)
			(proc0_8 9)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(switch register
					((global2 east?)
						(gEgo x: 331 y: 124 setMotion: MoveTo 297 142 self)
					)
					((global2 north?)
						(= temp0
							(CelHigh (gEgo view?) (gEgo loop?) (gEgo cel?))
						)
						((ScriptID 700 4) init: gEgo)
						(gEgo
							setCycle: Swim
							setHeading: 180
							x: (if (> (gEgo x?) 240) 240 else (gEgo x?))
							y: (- (global2 horizon?) temp0)
						)
						(Animate (global5 elements?) 0)
						(gEgo setMotion: MoveTo (gEgo x?) 10 self)
					)
					((global2 west?)
						(= temp0
							(CelWide (gEgo view?) (gEgo loop?) (gEgo cel?))
						)
						((ScriptID 700 4)
							init: gEgo
							inertizing: 1
							inertia: 5
							oldDir: 90
							xOff: 1
						)
						(gEgo
							normal: 0
							setHeading: 90
							setCycle: Swim
							x: (+ 0 (/ temp0 2) 1)
							y: (gEgo y?)
						)
						(= cycles 1)
					)
				)
			)
			(1
				(cond 
					((proc999_5 (gEgo view?) 373 374) (= local294 0))
					((proc999_5 (gEgo view?) 402 14 398) (= local294 1))
					((proc999_5 (gEgo view?) 0 4 406) (= local294 2))
				)
				(switch register
					((global2 east?)
						(switch local294
							(0 (proc0_1 1 373 374))
							(1 (proc0_1 1 402 14))
							(2 (proc0_1 1 0 4))
						)
						(proc700_5 1)
					)
					(else  (proc700_5 0))
				)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance exitScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				((ScriptID 700 4) dispose:)
				(if (== register (global2 north?))
					(= temp0 0)
				else
					(= temp0 270)
				)
				(gEgo setHeading: temp0 self cel: 0)
			)
			(1
				(switch register
					((global2 north?)
						(gEgo setMotion: MoveToY -30 self)
					)
					((global2 west?)
						(gEgo setMotion: MoveToX -30 self)
					)
				)
			)
			(2 (global2 newRoom: register))
		)
	)
)

(instance startSwimScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (== local294 1) (= temp1 3) else (= temp1 1))
				(gEgo
					normal: 0
					view: 403
					setLoop: temp1
					cycleSpeed: 24
					cel: 0
					setCycle: End self
				)
			)
			(1
				(if (== local294 2) (= temp0 406) else (= temp0 398))
				((ScriptID 700 4) init: gEgo)
				(gEgo
					normal: 0
					loop: 1
					setLoop: -1
					view: temp0
					posn: (- (gEgo x?) 40) (- (gEgo y?) 6) 0
					setStep: 3 2
					setCycle: Swim
					setSpeed: global199
					setHeading: 270
					setMotion: MoveFwd 20 self
				)
			)
			(2
				(proc700_5 0)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance endSwimScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (== local294 2) (= register 0) else (= register 2))
				(gEgo
					view: 403
					setLoop: register
					setMotion: 0
					setCycle: 0
					cel: 1
					posn: (- (gEgo x?) 25) (+ (gEgo y?) 6)
				)
				((ScriptID 700 4) dispose:)
				(= cycles 3)
			)
			(1
				(gEgo
					setLoop: register
					cel: 0
					posn: (+ (gEgo x?) 20) (gEgo y?)
				)
				(= cycles 3)
			)
			(2
				(if (== local294 2)
					(= temp0 0)
					(= temp1 4)
				else
					(= temp0 402)
					(= temp1 14)
				)
				(proc0_1 0 temp0 temp1)
				(proc700_5 1)
				(gEgo
					posn: (+ (gEgo x?) 13) (+ (gEgo y?) 3)
					setMotion: PolyPath 298 135 self
				)
			)
			(3 (proc0_3) (self dispose:))
		)
	)
)

(instance landScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (== local294 2) (= register 0) else (= register 2))
				(gEgo
					view: 403
					setMotion: 0
					setCycle: 0
					setLoop: register
					cel: 1
					posn: (- (gEgo x?) 25) (+ (gEgo y?) 6)
				)
				((ScriptID 700 4) dispose:)
				(= cycles 2)
			)
			(1
				(gEgo
					setLoop: register
					cel: 0
					posn: (+ (gEgo x?) 20) (gEgo y?)
				)
				(= cycles 2)
			)
			(2
				(if (== local294 2) (= temp0 0) else (= temp0 402))
				(proc0_1 0 temp0)
				(gEgo
					setLoop: 0
					setStep: 6 4
					setCycle: 0
					setMotion: MoveTo 298 135 self
				)
			)
			(3
				(if (== local294 2) (= temp1 4) else (= temp1 14))
				(proc0_1 0 (gEgo view?) temp1)
				(proc700_5 1)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance skaterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 2 10)))
			(1
				(switch client
					(skater1
						(skate1Snd play:)
						(client setCycle: MCyc @local0 self)
					)
					(skater2
						(skate2Snd play:)
						(client setCycle: MCyc @local149 self)
					)
				)
			)
			(2
				(switch client
					(skater1 (skate1Snd stop:))
					(skater2 (skate2Snd stop:))
				)
				(self init:)
			)
		)
	)
)

(instance skater1 of Sq4Prop
	(properties
		x -100
		y -100
		view 400
		loop 1
		priority 2
		signal $6010
	)
	
	(method (doit)
		(if
			(and
				(not (global2 script?))
				(proc999_5 (gEgo view?) 406 398)
				(self onMe: gEgo)
			)
			(global2 setScript: spinEgo self)
		)
		(super doit: &rest)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 405 say: 2)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance skater2 of Sq4Actor
	(properties
		x -100
		y -100
		view 400
		loop 2
		priority 2
		signal $6010
	)
	
	(method (doit)
		(if
			(and
				(not (global2 script?))
				(proc999_5 (gEgo view?) 323 398)
				(self onMe: gEgo)
			)
			(global2 setScript: spinEgo self)
		)
		(if (> x 204) (self setPri: 10) else (self setPri: 2))
		(super doit: &rest)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 405 say: 2)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance spinEgo of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(if (or (proc0_5 gEgo 4) (proc0_5 gEgo 2))
			(gEgo setMotion: 0)
			((ScriptID 700 4) inertia: 0)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= register (if (> (caller x?) (gEgo x?)) 1 else -1))
				(= caller 0)
				(gEgo
					view:
					(switch (gEgo view?)
						(406 407)
						(398 411)
						(else  407)
					)
					loop: 0
					cel:
						(switch (gEgo loop?)
							(0 0)
							(1 2)
							(2 1)
							(3 4)
							(4 0)
							(5 2)
							(6 5)
							(7 3)
						)
					cycleSpeed: 6
					setCycle: CT (gEgo cel?) register self
				)
			)
			(1
				(gEgo
					setCycle: CT (gEgo cel?) register self
					cycleSpeed: 12
				)
			)
			(2
				(gEgo
					setCycle: CT (gEgo cel?) register self
					cycleSpeed: 18
				)
			)
			(3
				(gEgo
					view:
					(switch (gEgo view?)
						(407 406)
						(411 398)
					)
					loop:
						(switch (gEgo cel?)
							(0 0)
							(2 1)
							(1 2)
							(4 3)
							(0 4)
							(2 5)
							(5 6)
							(3 7)
						)
					setSpeed: global199
					setCycle: Swim
				)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance enterAndShootEgo of Script
	(properties)
	
	(method (doit)
		(cond 
			((global2 script?))
			(
			(and (>= (gEgo x?) 298) (proc999_5 state 0 3 6)) (self changeState: 7))
			(
				(and
					(proc999_5 (gEgo view?) 406 407)
					(proc999_5 state 0 3 6)
				)
				(self changeState: 9)
			)
		)
		(super doit: &rest)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 5))
			(1
				(= local284 259)
				(= local286 319)
				(= local285 125)
				(= local287 110)
				(= local283
					(Graph
						grSAVE_BOX
						(- local287 1)
						(- local284 1)
						(+ local285 1)
						local286
						1
					)
				)
				(Graph
					grDRAW_LINE
					local285
					local286
					local287
					local284
					(proc0_18 global133 global143)
					1
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local287 1)
					(- local284 1)
					(+ local285 1)
					local286
				)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(2
				(blast init: posn: local284 local287 setCycle: End)
				(Graph grRESTORE_BOX local283)
				(Graph
					grREDRAW_BOX
					(- local287 1)
					(- local284 1)
					(+ local285 1)
					local286
				)
				(= cycles 1)
			)
			(3 (= cycles 16))
			(4
				(= local284 273)
				(= local285 137)
				(= local286 319)
				(= local287 110)
				(= local283
					(Graph
						grSAVE_BOX
						(- local287 1)
						(- local284 1)
						(+ local285 1)
						local286
						1
					)
				)
				(Graph
					grDRAW_LINE
					local285
					local286
					local287
					local284
					(proc0_18 global133 global143)
					1
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local287 1)
					(- local284 1)
					(+ local285 1)
					local286
				)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(5
				(blast cel: 0 posn: local284 local287 setCycle: End)
				(Graph grRESTORE_BOX local283)
				(Graph
					grREDRAW_BOX
					(- local287 1)
					(- local284 1)
					(+ local285 1)
					local286
				)
				(= cycles 1)
			)
			(6 (= cycles 14))
			(7
				(if (proc999_5 (gEgo view?) 406 407 403)
					(self changeState: (+ state 2))
				else
					(proc0_2)
					(gEgo setMotion: 0)
					(= local286 319)
					(= local287 100)
					(= local284 (+ (gEgo x?) 3))
					(= local285 (- (gEgo y?) 30))
					(Graph
						grDRAW_LINE
						local285
						local284
						local287
						local286
						(proc0_18 global133 global143)
						1
						-1
					)
					(Graph
						grREDRAW_BOX
						(- local287 1)
						(- local284 1)
						(+ local285 1)
						local286
					)
					(aSound number: 105 loop: 1 vol: 127 play:)
					(= cycles 4)
				)
			)
			(8 (proc0_10 8 12))
			(9 (= cycles 20))
			(10
				((ScriptID 700 7)
					show:
					setLoop: -1
					setCel: -1
					view: 7
					setCycle: Walk
					posn: 326 118
					setMotion: MoveTo 299 127 self
				)
			)
			(11
				(client setScript: shootEgo)
			)
		)
	)
)

(instance shootEgo of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not state)
				(> (gEgo x?) 154)
				(> (gEgo y?) 6)
				(< local282 8)
			)
			(= local282 8)
			(gEgo setMotion: 0)
			((ScriptID 700 4) inertia: 0)
			(self cue:)
		)
	)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= register (<= (gEgo y?) 111))
				((ScriptID 700 7)
					view: 13
					setMotion: 0
					loop: (if register 1 else 5)
					cel: 0
					posn: 299 127
					init:
				)
				(= seconds 3)
			)
			(1
				(= register (<= (gEgo y?) 111))
				((ScriptID 700 7)
					loop: (if register 1 else 5)
					cel: 0
					cycleSpeed: 12
					setCycle: CT 1 1 self
				)
			)
			(2
				(++ local282)
				(if register
					(= local288 283)
					(= local289
						(if
						(and (<= 95 (gEgo y?)) (<= (= local288 283) 111))
							102
						else
							98
						)
					)
					(= local290 (proc999_3 (+ (gEgo x?) 6) 1))
					(= local291 (proc999_3 (- (gEgo y?) 12) 1))
				else
					(= local288 292)
					(= local289 105)
					(= local290 (proc999_3 (+ (gEgo x?) 6) 2))
					(= local291 (proc999_2 (- (gEgo y?) 10) 188))
				)
				(cond 
					((>= local282 8) (= local292 local290) (= local293 local291))
					(
						(= temp0
							(/ (* (- local291 local289) 100) (- local290 local288))
						)
						(if
							(<
								(= temp0
									(/ (* (- local291 local289) 100) (- local290 local288))
								)
								0
							)
							(= local293 188)
						else
							(= local293 2)
						)
						(= local292
							(proc999_3
								2
								(+ (/ (* (- local293 local289) 100) temp0) local288)
							)
						)
					)
					(else (= local292 2) (= local293 local289))
				)
				(if (and (< local292 0) temp0)
					(= local292 2)
					(= local293
						(proc999_3
							(+ (/ (* temp0 (- local292 local288)) 100) local289)
						)
					)
				)
				(if (< local293 local289)
					(= local287 local293)
					(= local285 local289)
				else
					(= local287 local289)
					(= local285 local293)
				)
				(= local283
					(Graph
						grSAVE_BOX
						(- local287 1)
						(- local292 1)
						(+ local285 1)
						(+ local288 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local289
					local288
					local293
					local292
					(proc0_18 global133 global143)
					0
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local287 1)
					(- local292 1)
					(+ local285 1)
					(+ local288 1)
				)
				((ScriptID 700 7) setCycle: End)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(3
				((ScriptID 700 7) cel: 0 stopUpd:)
				(Graph grRESTORE_BOX local283)
				(Graph
					grREDRAW_BOX
					(- local287 1)
					(- local292 1)
					(+ local285 1)
					(+ local288 1)
				)
				(if (>= local282 8)
					(blast init: cel: 0 posn: local290 local291 setCycle: End)
					(gEgo
						view: 409
						setLoop: 4
						cel: 0
						setCycle: End self
						setMotion: 0
					)
				else
					(= state 0)
					(= cycles (Random 16 24))
				)
			)
			(4 (proc0_10 8 18))
		)
	)
)

(instance swimAfterEgo of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles
					(if (and (== global12 390) (proc0_6 22)) 16 else 120)
				)
			)
			(1
				(if
					(or
						(and
							(not (global2 script?))
							(> (gEgo x?) 85)
							(> (gEgo y?) 70)
						)
						(and (== global12 390) (proc0_6 22))
					)
					(gEgo setMotion: 0)
					((ScriptID 700 4) inertia: 0)
					((ScriptID 700 6)
						show:
						view: 408
						setLoop: 0
						cel: 0
						setCycle: End
						setStep: 2 2
						posn:
							(if (and (== global12 390) (proc0_6 22)) 0 else -38)
							(- (gEgo y?) 18)
						setMotion: MoveTo 10 (- (gEgo y?) 10) self
					)
				else
					(self changeState: 0)
				)
			)
			(2
				(proc0_2)
				((ScriptID 700 6)
					view: 409
					setLoop: 0
					cel: 0
					setCycle: CT 1 1 self
				)
			)
			(3
				(= local289 (- ((ScriptID 700 6) y?) 4))
				(= local288 (+ ((ScriptID 700 6) x?) 46))
				(= local291
					(proc999_3 2 (proc999_2 188 (- (gEgo y?) 10)))
				)
				(= local290 (proc999_3 2 (gEgo x?)))
				(if (< local291 local289)
					(= local287 local291)
					(= local285 local289)
				else
					(= local287 local289)
					(= local285 local291)
				)
				(= local283
					(Graph
						grSAVE_BOX
						(- local287 1)
						(- local288 1)
						(+ local285 1)
						(+ local290 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local289
					local288
					local291
					local290
					(proc0_18 global133 global143)
					1
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local287 1)
					(- local288 1)
					(+ local285 1)
					(+ local290 1)
					1
				)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(4
				(Graph grRESTORE_BOX local283)
				(Graph
					grREDRAW_BOX
					(- local287 1)
					(- local288 1)
					(+ local285 1)
					(+ local290 1)
					1
				)
				(blast init: cel: 0 posn: local290 local285 setCycle: End)
				((ScriptID 700 6) cel: 0)
				(if
					(or
						(gEgo script?)
						(proc999_5 (global2 script?) landScript endSwimScript)
					)
					(gEgo view: 409 setLoop: 5)
				else
					(gEgo view: 26)
				)
				(gEgo cel: 0 setCycle: End self setMotion: 0)
			)
			(5 (proc0_10 8 18))
		)
	)
)

(instance stayInScript of Script
	(properties)
	
	(method (changeState newState &tmp gEgoX temp1)
		(switch (= state newState)
			(0
				((gEgo code?) xOff: 0 yOff: 0 inertia: 0)
				(= gEgoX (gEgo x?))
				(= temp1 220)
				(gEgo illegalBits: 0 setMotion: MoveTo gEgoX temp1 self)
			)
			(1
				((gEgo code?) xOff: 0 yOff: 0 inertia: 0)
				(if (> (gEgo x?) 238) (gEgo x: 238))
				(if (< (gEgo x?) 20) (gEgo x: 20))
				(Animate (global5 elements?) 0)
				(= gEgoX (gEgo x?))
				(= temp1 185)
				(gEgo setMotion: MoveTo gEgoX temp1 self)
			)
			(2
				(gEgo illegalBits: -32768)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance blast of Sq4Prop
	(properties
		view 28
	)
)

(instance skateorama of Sq4Feature
	(properties
		x 275
		y 100
		sightAngle 180
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 405 say: 3)
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

(instance light of Sq4Feature
	(properties
		x 319
		y 189
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 405 say: 4)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (onMe param1)
		(return (== (OnControl 4 (param1 x?) (param1 y?)) 1024))
	)
)

(instance steps of Sq4Feature
	(properties
		x 40
		y 90
		sightAngle 180
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 405 say: 5)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (onMe param1)
		(return (& (OnControl 4 (param1 x?) (param1 y?)) $1002))
	)
)

(instance wall of Sq4Feature
	(properties
		x 110
		y 80
		sightAngle 180
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 405 say: 6)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (onMe param1)
		(return
			(if
				(and
					(not (& (OnControl 4 (param1 x?) (param1 y?)) $e000))
					(& (OnControl 4 (param1 x?) (param1 y?)) $0004)
				)
				(> (param1 y?) 71)
			else
				0
			)
		)
	)
)

(instance restOfMall of Sq4Feature
	(properties
		x 110
		y 80
		sightAngle 180
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 405 say: 7)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (onMe)
		(return 1)
	)
)

(instance skate1Snd of Sound
	(properties
		number 401
		priority 15
		loop -1
	)
)

(instance skate2Snd of Sound
	(properties
		number 401
		priority 15
		loop -1
	)
)

(instance aSound of Sound
	(properties)
)

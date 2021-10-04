;;; Sierra Script 1.0 - (do not remove this comment)
(script# 400)
(include sci.sh)
(use Main)
(use mall)
(use BeltWay)
(use SQRoom)
(use Sq4Narrator)
(use Sq4Feature)
(use MCyc)
(use PolyPath)
(use Polygon)
(use n958)
(use StopWalk)
(use Rev)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm400 0
)

(local
	[local0 93] = [0 0 -100 -100 0 0 241 5 0 0 227 12 0 0 212 16 0 0 194 22 0 0 174 27 0 0 148 32 0 1 123 36 0 2 98 35 0 3 83 38 0 4 71 40 0 5 60 45 0 6 50 46 0 7 42 50 0 8 38 50 0 9 46 49 0 10 57 43 0 10 69 38 0 10 80 32 0 10 93 25 0 10 108 15 0 10 115 6 0 0 -100 -100 -32768]
	[local93 109] = [0 0 -100 -100 1 0 184 -6 1 0 179 4 1 0 172 16 1 0 160 24 1 1 149 29 1 1 141 36 1 2 133 43 1 2 129 50 1 3 125 59 1 4 128 66 1 4 139 70 1 4 152 72 1 5 161 73 1 6 176 74 1 6 191 73 1 7 203 71 1 7 216 65 1 7 228 58 1 7 239 53 1 7 250 47 1 7 262 40 1 7 275 32 1 7 288 23 1 7 302 13 1 7 314 7 0 0 -100 -100 -32768]
	[local202 81] = [0 0 -100 -100 4 0 26 7 4 0 30 17 4 0 31 26 4 0 33 34 4 1 39 38 4 1 47 39 4 2 55 40 4 3 64 41 4 4 71 41 4 5 78 40 4 6 85 38 4 0 92 36 4 1 97 32 4 2 104 29 4 2 113 25 4 2 121 18 4 2 129 10 4 2 136 4 0 0 -100 -100 -32768]
	local283
	local284
	gEgoX_2
	gEgoX_3
	gEgoX
	local288
	theGEgoX_3
	local290
	local291
	local292
	local293
	local294
	local295
)
(instance rm400 of SQRoom
	(properties
		picture 400
		style $000a
		east 395
		west 370
	)
	
	(method (init)
		(= global34 0)
		(proc0_2)
		(proc958_0 128 7 400 401)
		(proc958_0 132 400 401 405)
		(gLongSong
			number: 405
			vol: 127
			loop: -1
			priority: 1
			play:
		)
		(gLongSong2 number: 0 vol: 0 stop:)
		(switch global12
			(west
				(if (== ((ScriptID 700 0) whichBelt?) 1)
					(= theGEgoX_3 -12)
					(= local290 93)
				else
					(= theGEgoX_3 -12)
					(= local290 151)
				)
				(gEgo
					x: theGEgoX_3
					y: local290
					setLoop: gStopGroop
					observeControl: 64
				)
				(self setScript: (ScriptID 700 1) 0 egoBwBlue)
			)
			(east
				(if (== ((ScriptID 700 0) whichBelt?) 1)
					(= theGEgoX_3 331)
					(= local290 93)
				else
					(= theGEgoX_3 331)
					(= local290 151)
				)
				(gEgo
					x: theGEgoX_3
					y: local290
					setLoop: gStopGroop
					observeControl: 64
				)
				(self setScript: (ScriptID 700 1) 0 egoBwCyan)
			)
			(else 
				(gLongSong vol: 20 flags: 1 play:)
				(escSnd setVol: 127)
				(self setScript: fromCarScript)
			)
		)
		(if ((gInv at: 12) ownedBy: 400) (cigar init:))
		(if
			(and
				(proc700_3 (ScriptID 700 0) 678 64)
				(not (gEgo has: 10))
			)
			(card init: setCel: 6)
		)
		(super init:)
		(if (!= global12 365)
			(gEgo
				setPri: -1
				code: beltwayCode
				init:
				setCycle: SyncWalk
			)
		)
		(if (or (== global12 east) (== global12 west))
			(skater0 init: setScript: (Clone skaterScript))
			(if (> (global1 detailLevel:) 1)
				(skater1 init: setScript: (Clone skaterScript))
				(if (>= (global1 detailLevel:) 3)
					(skater2 init: setScript: (Clone skaterScript))
				)
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init: 209 189 209 176 219 176 219 171 318 171 319 189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 319 131 237 134 232 130 220 130 213 114 219 112 222 108 319 98
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 319 81 224 88 205 93 126 93 88 87 0 78 0 0 319 0
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 0 98 92 107 93 112 97 115 91 130 81 130 75 137 0 134
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 0 170 95 170 95 176 101 176 101 189 0 189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 131 189 131 175 181 175 181 189
					yourself:
				)
		)
		((ScriptID 700 6)
			view: 7
			loop: 3
			cel: 0
			x: 196
			y: 248
			init:
			stopUpd:
		)
		(cond 
			((or (proc0_6 22) (proc0_6 23))
				(Load rsSOUND 105)
				(proc958_0 128 28 13 26)
				(Load rsFONT 68 69)
				((ScriptID 700 6) setScript: plugEgo)
			)
			((proc0_6 19)
				(Load rsSOUND 105)
				(proc958_0 128 28 13 26)
				(Load rsFONT 68 69)
				(proc0_7 23)
				(proc0_7 13)
				(if (== global12 370)
					((ScriptID 700 6) setScript: twoSPright)
				else
					((ScriptID 700 6) setScript: twoSPleft)
				)
			)
		)
		(lator1 init:)
		(lator2 init:)
		(if (or (== global12 east) (== global12 west))
			(lator1 setScript: escScript setCycle: Fwd)
			(lator2 setCycle: Rev)
			(escSnd init:)
			(escSnd setVol: 80)
		)
		(self setRegions: 700)
		(= local294 30)
		(= local295 96)
		(bush1 init:)
		(bush2 init:)
		(belts init:)
		(skateorama init:)
		(island1 init:)
		(island2 init:)
	)
	
	(method (doit &tmp [temp0 3])
		(cond 
			(script 0)
			(
				(and
					(gEgo edgeHit?)
					(proc999_5 (gEgo edgeHit?) 2 4)
					(not ((ScriptID 700 7) script?))
					(!= (gEgo view?) 26)
				)
				(proc0_2)
				((ScriptID 700 0)
					enterBelt: (if (== (gEgo edgeHit?) 2) egoBwRed else egoBwGreen)
				)
				(self
					setScript:
						(ScriptID 700 2)
						0
						(if (== (gEgo edgeHit?) 2) east else west)
				)
			)
		)
		(if
			(and
				(not ((ScriptID 700 7) script?))
				(!= (gEgo view?) 26)
			)
			(super doit:)
		)
	)
	
	(method (dispose)
		(= global34 1)
		(DisposeScript 804)
		(super dispose:)
	)
)

(instance beltwayCode of Code
	(properties)
	
	(method (doit &tmp temp0 temp1 temp2)
		(cond 
			((global2 script?) 0)
			((& (= temp1 (gEgo onControl: 1)) local294)
				(cond 
					((& temp1 $0004)
						(egoBwGreen who: gEgo doit:)
						((ScriptID 700 0) whichBelt: 1)
					)
					((& temp1 $0002)
						(egoBwBlue who: gEgo doit:)
						((ScriptID 700 0) whichBelt: 2)
					)
					((& temp1 $0008)
						(egoBwCyan who: gEgo doit:)
						((ScriptID 700 0) whichBelt: 1)
					)
					((& temp1 $0010)
						(egoBwRed who: gEgo doit:)
						((ScriptID 700 0) whichBelt: 2)
					)
				)
				(proc700_5 0)
			)
			(
				(|
					(egoBwGreen onCon?)
					(egoBwBlue onCon?)
					(egoBwCyan onCon?)
					(egoBwRed onCon?)
				)
				(egoBwGreen onCon: 0)
				(egoBwBlue onCon: 0)
				(egoBwCyan onCon: 0)
				(egoBwRed onCon: 0)
				(gEgo xStep: 3 yStep: 2 setPri: -1)
				(proc700_5 1)
			)
			((& temp1 local295)
				(global2
					setScript: (if (& temp1 $0020) downLatorScript else joyRiding)
				)
			)
		)
	)
)

(instance egoBwGreen of BeltWay
	(properties
		xStep 2
		xOff 2
		yOff -1
		xTweak 2
		key 90
		head 277
		xDir -1
		yDir 1
	)
)

(instance egoBwCyan of BeltWay
	(properties
		xStep 2
		xOff 2
		yOff 1
		xTweak 2
		key 90
		head 262
		xDir -1
		yDir 1
	)
)

(instance egoBwBlue of BeltWay
	(properties
		xStep 2
		xOff 2
		yOff -1
		xTweak 2
		key 270
		head 96
		xDir 1
		yDir -1
	)
)

(instance egoBwRed of BeltWay
	(properties
		xStep 2
		xOff 2
		yOff 1
		xTweak 2
		key 270
		head 86
		xDir 1
		yDir -1
		tixCnt 6
	)
)

(instance skater0 of Sq4Prop
	(properties
		x -100
		y -100
		view 400
		priority 2
		signal $6010
		lookStr 1
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
		lookStr 1
	)
)

(instance skater2 of Sq4Prop
	(properties
		x -100
		y -100
		view 400
		loop 2
		priority 2
		signal $6010
		lookStr 1
	)
)

(instance lator1 of Sq4Prop
	(properties
		x 116
		y 189
		view 401
		priority 4
		signal $4010
		lookStr 2
	)
)

(instance escScript of Script
	(properties)
	
	(method (doit &tmp temp0)
		(if (not (lator1 cel?)) (escSnd play:))
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 0)
		)
	)
)

(instance escSnd of Sound
	(properties
		number 400
	)
)

(instance lator2 of Sq4Prop
	(properties
		x 196
		y 189
		view 401
		priority 4
		signal $4010
		lookStr 3
	)
)

(instance blast of Sq4Prop
	(properties
		view 28
	)
)

(instance cigar of Sq4View
	(properties
		x 220
		y 114
		view 401
		loop 5
		signal $4010
		lookStr 4
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(proc0_2)
				(proc700_5 1)
				(global2 setScript: getSomethingScript 0 self)
			)
			(6 (gSq4GlobalNarrator say: 5))
			(7 (gSq4GlobalNarrator say: 6))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance card of Sq4Prop
	(properties
		x 167
		y 151
		sightAngle 90
		view 401
		loop 4
		priority 1
		signal $4810
		lookStr 7
	)
	
	(method (init)
		(super init: &rest)
		(self doit:)
	)
	
	(method (doit)
		(super doit:)
		(if (!= (self cel?) 6)
			(self setPri: -1 x: (+ (self x?) 2))
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(proc0_2)
				(proc700_5 1)
				(global2 setScript: getSomethingScript 0 self)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance getSomethingScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (& (gEgo signal?) $0400)
			(gSq4GlobalNarrator say: 8)
			(proc0_3)
			(self dispose:)
		)
	)
	
	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(proc0_13 gEgo register)
				(= temp0
					(-
						(GetDistance
							(gEgo x?)
							(gEgo y?)
							(register x?)
							(register y?)
						)
						10
					)
				)
				(= temp1
					(+ (gEgo x?) (SinMult (gEgo heading?) temp0))
				)
				(= temp2
					(- (gEgo y?) (CosMult (gEgo heading?) temp0))
				)
				(gEgo
					ignoreActors: 1
					setMotion: PolyPath temp1 temp2 self
				)
			)
			(1
				(switch register
					(card
						(gSq4GlobalNarrator say: 9)
						(gEgo get: 10)
						(proc0_11 80 2)
					)
					(cigar
						(gSq4GlobalNarrator say: 10)
						(gEgo get: 12)
						(proc0_11 81 5)
					)
				)
				(proc0_3)
				(gEgo ignoreActors: 0)
				(register dispose:)
				(self dispose:)
			)
		)
	)
)

(instance joyRiding of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_2) (= ticks 10))
			(1
				(= local292 ((gEgo cycler?) vStopped?))
				(gEgo setMotion: MoveTo (gEgo x?) (+ (gEgo y?) 3) self)
			)
			(2
				(gEgo setHeading: 180 setCycle: Fwd)
				(= seconds 3)
			)
			(3
				(gEgo
					setHeading: 90
					setCycle: StopWalk local292
					setMotion: MoveTo (gEgo x?) (- (gEgo y?) 5) self
				)
			)
			(4
				(gSq4GlobalNarrator say: 11)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance babe1 of Sq4Actor
	(properties
		x 195
		y 248
		view 401
		loop 1
		signal $6800
		illegalBits $0000
	)
	
	(method (init)
		(super init: &rest)
		(self setCycle: 0 setMotion: MoveTo (self x?) 158)
	)
)

(instance babe2 of Sq4Actor
	(properties
		x 186
		y 255
		view 401
		loop 1
		cel 1
		signal $6800
		illegalBits $0000
	)
	
	(method (init)
		(super init: &rest)
		(self setCycle: 0 setMotion: MoveTo (self x?) 166)
	)
)

(instance babe3 of Sq4Actor
	(properties
		x 204
		y 255
		view 401
		loop 1
		cel 2
		signal $6800
		illegalBits $0000
	)
	
	(method (init)
		(super init: &rest)
		(self setCycle: 0 setMotion: MoveTo (self x?) 167)
	)
)

(instance fromCarScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local293 global199)
				(gEgo
					x: 196
					y: 262
					setPri: -1
					code: beltwayCode
					init:
					setCycle: SyncWalk
				)
				(= cycles 2)
			)
			(1
				(gLongSong fade: 127 10 5 0)
				(proc0_1 0 402)
				(gEgo setSpeed: 6)
				(proc0_9 14)
				(gEgo x: -100 y: -100)
				(= cycles 10)
			)
			(2
				(lator1 setScript: escScript init: setCycle: Fwd)
				(lator2 init: setCycle: Rev)
				(escSnd init:)
				(escSnd setVol: 127)
				(babe1 init:)
				(babe2 init:)
				(babe3 init:)
				(gEgo
					x: 196
					y: 262
					init:
					setCycle: 0
					setMotion: MoveTo 196 172 self
				)
			)
			(3
				(proc0_1 3 402)
				(gEgo setSpeed: global199)
				(gEgo observeControl: 64 setCycle: StopWalk 14)
				(proc700_5 1)
				(= cycles 3)
			)
			(4
				(skater0 init: setScript: (Clone skaterScript))
				(= seconds 2)
			)
			(5
				(babe1 setLoop: 2 setCycle: End self)
			)
			(6 (= seconds 1))
			(7
				(tBabes say: 1 self 2 64 190 100 27 1)
			)
			(8
				(babe1
					setLoop: 3
					setCel: -1
					setStep: 5 3
					setCycle: Walk
					setMotion: PolyPath 80 109 self
				)
				(babe2 dispose:)
				(babe3 dispose:)
				(= cycles 3)
			)
			(9
				(card
					init:
					setCycle: End
					x: (- (babe1 x?) 23)
					y: (babe1 y?)
				)
				(mall rFlag1: (| (mall rFlag1?) $0040))
			)
			(10
				(card setPri: 1)
				(babe1 setStep: 7 3 setMotion: MoveTo -40 111 self)
			)
			(11
				(gEgo setSpeed: local293)
				(babe1 dispose:)
				(escSnd setVol: 80)
				(if (> (global1 detailLevel:) 1)
					(skater1 init: setScript: (Clone skaterScript))
					(if (>= (global1 detailLevel:) 3)
						(skater2 init: setScript: (Clone skaterScript))
					)
				)
				(proc0_3)
				(global1 setCursor: 850 1)
				(gIconBar curIcon: (gIconBar at: 0))
				(gEgo setSpeed: global199)
				(self dispose:)
			)
		)
	)
)

(instance plugEgo of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 700 6) posn: 160 (gEgo y?) loop: 2 cel: 2)
				(= cycles 10)
			)
			(1
				(= register (< (gEgo x?) ((ScriptID 700 6) x?)))
				((ScriptID 700 6)
					view: 13
					loop: (if register 1 else 0)
					cel: 0
					setCycle: CT 1 1 self
				)
			)
			(2
				(proc0_2)
				(gEgo setMotion: 0)
				(= local290 (- ((ScriptID 700 6) y?) 28))
				(= theGEgoX_3 (if register 144 else 176))
				(= local288 (- (gEgo y?) 31))
				(if (< (= gEgoX (gEgo x?)) theGEgoX_3)
					(= gEgoX_2 gEgoX)
					(= gEgoX_3 theGEgoX_3)
				else
					(= gEgoX_2 theGEgoX_3)
					(= gEgoX_3 gEgoX)
				)
				(if (< local288 local290)
					(= local283 local288)
					(= local284 local290)
				else
					(= local283 local290)
					(= local284 local288)
				)
				(= local291
					(Graph
						grSAVE_BOX
						(- local283 1)
						(- gEgoX_2 1)
						(+ local284 1)
						(+ gEgoX_3 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local290
					theGEgoX_3
					local288
					gEgoX
					(proc0_18 global133 global143)
					(- (gEgo priority?) 1)
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local283 1)
					(- gEgoX_2 1)
					(+ local284 1)
					(+ gEgoX_3 1)
				)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(3
				(Graph grRESTORE_BOX local291)
				(Graph
					grREDRAW_BOX
					(- local283 1)
					(- gEgoX_2 1)
					(+ local284 1)
					(+ gEgoX_3 1)
				)
				(blast
					init:
					posn: gEgoX local288
					cel: 0
					setPri: (+ (gEgo priority?) 1)
					setCycle: End self
				)
				(gEgo view: 26 cel: 0 cycleSpeed: 12 setCycle: End)
				((ScriptID 700 6) cel: 0)
			)
			(4 (proc0_10 8 25))
		)
	)
)

(instance twoSPright of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(cond 
			((and (not state) (> (gEgo x?) 90)) (self cue:))
			(
				(and
					(< state 10)
					(or
						(and (> (gEgo y?) 174) ((ScriptID 700 6) loop: 2))
						(> (gEgo x?) 118)
					)
				)
				(= cycles 0)
				(self changeState: 10)
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 700 7)
					posn: 229 163
					loop: 2
					cel: 2
					init:
					stopUpd:
				)
				((ScriptID 700 6)
					posn: 213 106
					view: 13
					loop: 0
					cel: 0
					stopUpd:
				)
			)
			(1
				((ScriptID 700 7) loop: 1 forceUpd:)
				((ScriptID 700 6) loop: 3 forceUpd:)
				(= cycles 6)
			)
			(2
				(tSP1
					say:
						1
						self
						2
						64
						-1
						100
						25
						global130
						26
						(proc0_18 global139 global149)
						27
						1
				)
				((ScriptID 700 6) loop: 1 forceUpd:)
				((ScriptID 700 7) setScript: uStayIGo)
				(= seconds 2)
			)
			(3 (= cycles 5))
			(4
				((ScriptID 700 6) setCycle: CT 1 1 self)
			)
			(5
				(= local283 74)
				(= local284 95)
				(= gEgoX_2 4)
				(= gEgoX_3 186)
				(= local291
					(Graph
						grSAVE_BOX
						(- local283 1)
						(- gEgoX_2 1)
						(+ local284 1)
						(+ gEgoX_3 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local283
					gEgoX_3
					local284
					gEgoX_2
					(proc0_18 global133 global143)
					3
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local283 1)
					(- gEgoX_2 1)
					(+ local284 1)
					(+ gEgoX_3 1)
				)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(6
				((ScriptID 700 6) setCycle: End)
				(blast init: posn: 4 95 setCycle: End)
				(Graph grRESTORE_BOX local291)
				(Graph
					grREDRAW_BOX
					(- local283 1)
					(- gEgoX_2 1)
					(+ local284 1)
					(+ gEgoX_3 1)
				)
				(= local291 0)
				(= cycles 18)
			)
			(7
				((ScriptID 700 6) cel: 0 setCycle: CT 1 1 self)
			)
			(8
				(= local283 74)
				(= local284 78)
				(= gEgoX_2 74)
				(= gEgoX_3 186)
				(= local291
					(Graph
						grSAVE_BOX
						(- local283 1)
						(- gEgoX_2 1)
						(+ local284 1)
						(+ gEgoX_3 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local284
					gEgoX_3
					local283
					gEgoX_2
					(proc0_18 global133 global143)
					3
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local283 1)
					(- gEgoX_2 1)
					(+ local284 1)
					(+ gEgoX_3 1)
				)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(9
				((ScriptID 700 6) setCycle: End)
				(blast posn: 73 74 setPri: 6 setCycle: End)
				(Graph grRESTORE_BOX local291)
				(Graph
					grREDRAW_BOX
					(- local283 1)
					(- gEgoX_2 1)
					(+ local284 1)
					(+ gEgoX_3 1)
				)
				(= local291 0)
				(= cycles 15)
			)
			(10
				((ScriptID 700 6) cel: 0 setCycle: CT 1 1 self)
			)
			(11
				(proc0_2)
				(gEgo setMotion: 0)
				(= local283 (proc999_2 (- (gEgo y?) 31) 75))
				(= local284 (proc999_3 (- (gEgo y?) 31) 75))
				(= gEgoX_2 (gEgo x?))
				(= gEgoX_3 186)
				(= local291
					(Graph
						grSAVE_BOX
						(- local283 1)
						(- gEgoX_2 1)
						(+ local284 1)
						(+ gEgoX_3 1)
						1
					)
				)
				(if (== local283 75)
					(Graph
						grDRAW_LINE
						local283
						gEgoX_3
						local284
						gEgoX_2
						(proc0_18 global133 global143)
						(- (gEgo priority?) 1)
						-1
					)
				else
					(Graph
						grDRAW_LINE
						local284
						gEgoX_3
						local283
						gEgoX_2
						(proc0_18 global133 global143)
						(- (gEgo priority?) 1)
						-1
					)
				)
				(Graph
					grREDRAW_BOX
					(- local283 1)
					(- gEgoX_2 1)
					(+ local284 1)
					(+ gEgoX_3 1)
				)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(12
				(Graph grRESTORE_BOX local291)
				(Graph
					grREDRAW_BOX
					(- local283 1)
					(- gEgoX_2 1)
					(+ local284 1)
					(+ gEgoX_3 1)
				)
				(gEgo view: 26 cel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(13 (proc0_10 8 3))
		)
	)
)

(instance twoSPleft of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(cond 
			((and (not state) (< (gEgo x?) 228)) (self cue:))
			((and (< (gEgo x?) 202) (< state 10)) (= cycles 0) (self changeState: 10))
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 700 7)
					posn: 84 161
					loop: 2
					cel: 2
					init:
					stopUpd:
				)
				((ScriptID 700 6)
					posn: 102 141
					view: 13
					loop: 1
					cel: 0
					stopUpd:
				)
			)
			(1
				((ScriptID 700 7) loop: 0 forceUpd:)
				((ScriptID 700 6) loop: 3 forceUpd:)
				(= cycles 4)
			)
			(2
				((ScriptID 700 7) stopUpd:)
				((ScriptID 700 6) loop: 0 forceUpd:)
				(tSP1
					say:
						1
						self
						2
						64
						-1
						100
						25
						global130
						26
						(proc0_18 global139 global149)
						27
						1
				)
				((ScriptID 700 7) setScript: uStayIGo)
			)
			(3 (= cycles 8))
			(4
				((ScriptID 700 6) setCycle: CT 1 1 self)
			)
			(5
				(= local283 109)
				(= local284 111)
				(= gEgoX_2 124)
				(= gEgoX_3 254)
				(= local291
					(Graph
						grSAVE_BOX
						(- local283 1)
						(- gEgoX_2 1)
						(+ local284 1)
						(+ gEgoX_3 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local284
					gEgoX_2
					local283
					gEgoX_3
					(proc0_18 global133 global143)
					3
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local283 1)
					(- gEgoX_2 1)
					(+ local284 1)
					(+ gEgoX_3 1)
				)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(6
				((ScriptID 700 6) setCycle: End)
				(blast init: posn: 254 109 setPri: 7 setCycle: End)
				(Graph grRESTORE_BOX local291)
				(Graph
					grREDRAW_BOX
					(- local283 1)
					(- gEgoX_2 1)
					(+ local284 1)
					(+ gEgoX_3 1)
				)
				(= local291 0)
				(= cycles 24)
			)
			(7
				((ScriptID 700 6) cel: 0 setCycle: CT 1 1 self)
			)
			(8
				(= local283 107)
				(= local284 111)
				(= gEgoX_2 124)
				(= gEgoX_3 279)
				(= local291
					(Graph
						grSAVE_BOX
						(- local283 1)
						(- gEgoX_2 1)
						(+ local284 1)
						(+ gEgoX_3 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local284
					gEgoX_2
					local283
					gEgoX_3
					(proc0_18 global133 global143)
					3
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local283 1)
					(- gEgoX_2 1)
					(+ local284 1)
					(+ gEgoX_3 1)
				)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(9
				((ScriptID 700 6) setCycle: End)
				(blast posn: 279 107 setPri: 6 setCycle: End self)
				(Graph grRESTORE_BOX local291)
				(Graph
					grREDRAW_BOX
					(- local283 1)
					(- gEgoX_2 1)
					(+ local284 1)
					(+ gEgoX_3 1)
				)
				(= local291 0)
				(= cycles 16)
			)
			(10
				((ScriptID 700 6)
					loop: (if (> (gEgo x?) 161) 0 else 3)
					cel: 0
					setCycle: CT 1 1 self
				)
			)
			(11
				(proc0_2)
				(gEgo setMotion: 0)
				(= local283 (proc999_2 (- (gEgo y?) 31) 108))
				(= local284 (proc999_3 (- (gEgo y?) 31) 108))
				(= gEgoX_3 (gEgo x?))
				(= gEgoX_2 119)
				(= local291
					(Graph
						grSAVE_BOX
						(- local283 1)
						(- gEgoX_2 1)
						(+ local284 1)
						(+ gEgoX_3 1)
						1
					)
				)
				(if (== local283 108)
					(Graph
						grDRAW_LINE
						local283
						gEgoX_2
						local284
						gEgoX_3
						(proc0_18 global133 global143)
						(- (gEgo priority?) 1)
						-1
					)
				else
					(Graph
						grDRAW_LINE
						local284
						gEgoX_2
						local283
						gEgoX_3
						(proc0_18 global133 global143)
						(- (gEgo priority?) 1)
						-1
					)
				)
				(Graph
					grREDRAW_BOX
					(- local283 1)
					(- gEgoX_2 1)
					(+ local284 1)
					(+ gEgoX_3 1)
				)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(12
				(Graph grRESTORE_BOX local291)
				(Graph
					grREDRAW_BOX
					(- local283 1)
					(- gEgoX_2 1)
					(+ local284 1)
					(+ gEgoX_3 1)
				)
				(gEgo view: 26 cel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(13 (proc0_10 8 3))
		)
	)
)

(instance uStayIGo of Script
	(properties)
	
	(method (doit)
		(if
		(and (not state) (gEgo edgeHit?) (!= (gEgo view?) 26))
			(self cue:)
		)
		(super doit: &rest)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local291
					(Graph grRESTORE_BOX local291)
					(Graph
						grREDRAW_BOX
						(- local283 1)
						(- gEgoX_2 1)
						(+ local284 1)
						(+ gEgoX_3 1)
					)
				)
				((ScriptID 700 6) cel: 0)
			)
			(1
				(proc0_2)
				(gEgo hide:)
				((ScriptID 700 6) view: 7 loop: 2 cel: 2 setScript: 0)
				((ScriptID 700 7) forceUpd: loop: 3)
				(= seconds 3)
			)
			(2
				(tSP2
					say:
						1
						self
						2
						64
						-1
						40
						25
						global130
						26
						(proc0_18 global139 global149)
						27
						1
				)
			)
			(3 (= cycles 2))
			(4
				(tSP1
					say:
						3
						self
						2
						64
						-1
						40
						25
						global130
						26
						(proc0_18 global139 global149)
						27
						1
				)
			)
			(5
				((ScriptID 700 6)
					setCycle: Walk
					setMotion: MoveTo 160 ((ScriptID 700 6) y?) self
				)
			)
			(6
				(global2 setScript: 0)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance downLatorScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(proc0_2)
				(= temp0
					(CelHigh (gEgo view?) (gEgo loop?) (gEgo cel?))
				)
				(gEgo setCycle: 0 looper: 0)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo (gEgo x?) 250 self)
			)
			(2 (= seconds 2))
			(3
				(if global25 (global25 dispose:))
				(gEgo
					setLoop: 2
					posn: 196 248
					ignoreControl: 64
					setMotion: MoveTo 196 177 self
				)
			)
			(4
				((ScriptID 700 6)
					illegalBits: 0
					setCycle: 0
					setLoop: 3
					setMotion: MoveTo 196 172 self
				)
				(gEgo setCycle: Rev setMotion: MoveTo 196 155 self)
			)
			(5 (gEgo setCycle: 0) 0)
			(6 (proc0_10 8 26))
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
					(skater0
						(client setCycle: MCyc @local0 self)
					)
					(skater1
						(client setCycle: MCyc @local93 self)
					)
					(skater2
						(client setCycle: MCyc @local202 self)
					)
				)
			)
			(2 (self init:))
		)
	)
)

(instance skateorama of Sq4Feature
	(properties
		x 159
		y 64
		z 24
		lookStr 12
	)
	
	(method (onMe param1)
		(return (== (OnControl 4 (param1 x?) (param1 y?)) 8192))
	)
)

(instance island1 of Sq4Feature
	(properties
		x 41
		y 123
		z 10
		nsTop 96
		nsBottom 130
		nsRight 82
		lookStr 14
	)
)

(instance island2 of Sq4Feature
	(properties
		x 278
		y 112
		nsTop 95
		nsLeft 238
		nsBottom 130
		nsRight 319
		lookStr 14
	)
)

(instance belts of Sq4Feature
	(properties
		sightAngle 180
		lookStr 15
	)
	
	(method (onMe param1)
		(return (& (OnControl 4 (param1 x?) (param1 y?)) $001e))
	)
)

(instance bush1 of Sq4Feature
	(properties
		x 17
		y 100
		nsTop 96
		nsLeft 13
		nsBottom 108
		nsRight 26
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 370 say: 12)
			)
			(6
				(gSq4GlobalNarrator modNum: 370 say: 13)
			)
			(7
				(gSq4GlobalNarrator modNum: 370 say: 14)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush2 of Sq4Feature
	(properties
		x 294
		y 102
		nsTop 94
		nsLeft 288
		nsBottom 108
		nsRight 304
	)
	
	(method (doVerb theVerb)
		(bush1 doVerb: theVerb &rest)
	)
)

(instance aSound of Sound
	(properties)
)

(instance tSP1 of Sq4Talker
	(properties
		z 400
		noun 22
		view 1016
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
		mouthOffsetX 22
		mouthOffsetY 34
	)
)

(instance tBabes of Sq4Narrator
	(properties
		noun 30
		talkerNum 30
	)
)

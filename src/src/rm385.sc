;;; Sierra Script 1.0 - (do not remove this comment)
(script# 385)
(include sci.sh)
(use Main)
(use mall)
(use BeltWay)
(use SQRoom)
(use Sq4Narrator)
(use Sq4Feature)
(use MCyc)
(use Polygon)
(use n958)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm385 0
)

(local
	[local0 53] = [0 0 164 69 0 0 165 75 0 1 167 82 0 1 168 90 0 2 169 99 0 2 170 108 0 3 171 115 0 3 173 125 0 4 174 129 0 4 176 128 0 5 177 122 0 5 178 127 0 6 178 129 -32768]
	[local53 53] = [1 0 164 69 1 0 165 75 1 0 167 82 1 1 168 90 1 1 169 99 1 2 170 108 1 2 171 115 1 3 173 125 1 3 174 129 1 4 176 128 1 4 177 122 1 5 178 127 1 5 178 129 -32768]
	[local106 29] = [5 3 180 93 5 4 177 103 5 5 171 99 5 6 165 94 5 0 161 105 5 1 156 123 5 2 156 140 -32768]
	local135
	local136
	local137
	local138
	local139
	local140
	local141 =  175
	local142 =  1
	[local143 30] = [262 -1 272 27 231 91 193 97 188 87 198 50 168 50 137 46 138 84 131 94 123 94 92 81 84 60 74 33 71]
)
(instance rm385 of SQRoom
	(properties
		picture 385
		style $000a
		east 390
		west 380
	)
	
	(method (init &tmp temp0 temp1)
		(proc0_2)
		(cond 
			((and (!= global12 386) (not (proc0_6 11)))
				(groundCigarSFX init:)
				(tossedSFX init:)
				(egoLandsSFX init:)
				(gLongSong2 number: 4 loop: -1 flags: 1 play: 65)
			)
			((proc0_6 11) (gLongSong2 number: 0 vol: 0 stop:))
		)
		(switch global12
			(west
				(if (== ((ScriptID 700 0) whichBelt?) 1)
					(= temp0 -12)
					(= temp1 139)
				else
					(= temp0 -12)
					(= temp1 99)
				)
				(gEgo x: temp0 y: temp1 setLoop: gStopGroop)
				(self setScript: (ScriptID 700 1) 0 egoBwGreen)
			)
			(east
				(if (== ((ScriptID 700 0) whichBelt?) 1)
					(= temp0 334)
					(= temp1 149)
				else
					(= temp0 334)
					(= temp1 119)
				)
				(gEgo x: temp0 y: temp1 setLoop: gStopGroop)
				(self setScript: (ScriptID 700 1) 0 egoBwBlue)
			)
			(387
				(gLongSong number: 405 loop: -1 flags: 1 play:)
				(gEgo x: -100 y: -100)
				(self setScript: egoTossedOut 0 0)
			)
			(else 
				(gLongSong number: 405 loop: -1 flags: 1 play: 95)
				(gEgo x: -100 y: -100)
				(if (proc700_3 (ScriptID 700 0) 681 1)
					(self setScript: egoTossedOut 0)
					(mall rFlag4: (& (mall rFlag4?) $fffe))
				else
					(self setScript: fromStoreScript)
				)
			)
		)
		(burgerPoly points: @local143 size: 15)
		(super init:)
		(if (proc0_6 11)
			(global10 add: door eachElementDo: #init doit:)
			(self
				addObstacle:
					((Polygon new:)
						type: 2
						init: 319 108 191 101 185 93 136 92 134 98 0 91 0 0 319 0
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: 2
						init: 153 65 152 75 138 97 0 91 0 55
						yourself:
					)
					((Polygon new:)
						type: 2
						init: 170 65 319 66 319 108 183 100
						yourself:
					)
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init: 319 165 319 189 0 189 0 149
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 0 105 124 110 139 114 130 133 0 128
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 319 122 319 144 189 136 181 116 190 114
					yourself:
				)
		)
		(if (and (proc0_6 23) (not (proc0_6 22)))
			(Load rsSOUND 105)
			((ScriptID 700 7)
				posn: 168 118
				view: 13
				setLoop: 0
				setCel: 0
				init:
				setScript: shootEgo
			)
		)
		(gEgo
			setPri: -1
			code: beltwayCode
			init:
			setCycle: SyncWalk
		)
		(self setRegions: 700)
		(store init:)
		(bush1 init:)
		(bush2 init:)
	)
	
	(method (doit &tmp temp0)
		(if (not (-- local142))
			(cond 
				(
					(<
						(= temp0 (GetDistance (gEgo x?) (gEgo y?) local141 0))
						0
					)
					(= temp0 0)
				)
				((> temp0 300) (= temp0 300))
			)
			(gLongSong2 setVol: (- 127 (/ temp0 3)))
			(= local142 60)
		)
		(cond 
			((global2 script?) 0)
			((== (gEgo edgeHit?) 2)
				(proc0_2)
				((ScriptID 700 0) enterBelt: egoBwGreen)
				(global2 setScript: (ScriptID 700 2) 0 east)
			)
			((== (gEgo edgeHit?) 4)
				(proc0_2)
				((ScriptID 700 0) enterBelt: egoBwBlue)
				(global2 setScript: (ScriptID 700 2) 0 west)
			)
		)
		(super doit:)
	)
	
	(method (dispose)
		(DisposeScript 804)
		(super dispose:)
	)
)

(instance fromStoreScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 167 y: 74 setMotion: MoveTo 167 96 self)
			)
			(1
				(proc700_5 1)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance beltwayCode of Code
	(properties)
	
	(method (doit)
		(cond 
			((global2 script?) 0)
			((proc0_5 gEgo 8)
				(if (== (gEgo view?) 402)
					(global2 setScript: egoTossedOut 0 1)
				else
					(global2 newRoom: 386)
				)
			)
			((proc0_5 gEgo 4)
				(egoBwGreen who: gEgo doit:)
				((ScriptID 700 0) whichBelt: 1)
				(proc700_5 0)
				(gLongSong fade: 127 10 5 0)
			)
			((proc0_5 gEgo 2)
				(egoBwBlue who: gEgo doit:)
				((ScriptID 700 0) whichBelt: 2)
				(proc700_5 0)
				(gLongSong fade: 95 10 5 0)
			)
			((or (egoBwGreen onCon?) (egoBwBlue onCon?))
				(egoBwGreen onCon: 0)
				(egoBwBlue onCon: 0)
				(gEgo xStep: 3 yStep: 2)
				(proc700_5 1)
			)
		)
	)
)

(instance sDS of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 10))
			(1
				(if
					(and
						(< 130 ((ScriptID 700 9) x?))
						(< ((ScriptID 700 9) x?) 220)
					)
					(self init:)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance egoTossedOut of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc958_0 128 392 385)
				(proc958_0 132 836 873 874 134)
				(proc0_2)
				(if (== register 1)
					(gEgo illegalBits: 0 setMotion: MoveTo 160 42 self)
				else
					(= cycles 1)
				)
			)
			(1
				(if
					(and
						(< 130 ((ScriptID 700 9) x?))
						(< ((ScriptID 700 9) x?) 220)
					)
					(self setScript: sDS self)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo view: 392 setLoop: register)
				(if (== register 1)
					(tossedSFX play:)
					(gEgo setCycle: MCyc @local53)
					(= cycles 10)
				else
					(tossedSFX play:)
					(gEgo setCycle: MCyc @local0)
					(= cycles 10)
				)
			)
			(3
				(egoLandsSFX play:)
				(boss
					init:
					setLoop: 0
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 155 95 self
				)
			)
			(4
				(boss view: 385 loop: 4)
				(pighead
					ignoreActors: 1
					setPri: 7
					x: (+ (boss x?) 2)
					y: (- (boss y?) 48)
					z: 0
					init:
				)
				(if (== register 1)
					(tPighead init: 0 0 pighead say: 1 self 2)
				else
					(tPighead
						init: 0 0 pighead
						say: 2 self 2 64 5 5 67 310 27 1
					)
					(proc0_7 70)
				)
			)
			(5
				(pighead dispose:)
				(if
					(and
						(== register 0)
						(not ((gInv at: 12) ownedBy: 400))
						(not (gEgo has: 12))
					)
					(boss view: 385 loop: 2 cel: 0 setCycle: CT 3 1 self)
					((gInv at: 12) owner: 400)
					(= register 2)
				else
					(= cycles 1)
				)
				(pighead dispose:)
			)
			(6
				(if (== register 2)
					(boss cel: 4)
					(cigar
						z: 0
						illegalBits: 0
						ignoreActors: 1
						init:
						setCycle: MCyc @local106 self
					)
					(headCigarSFX init: play:)
				else
					(= cycles 1)
				)
			)
			(7
				(if (== register 2)
					(groundCigarSFX play:)
					(cigar
						setLoop: 5
						setSpeed: global199
						setMotion: MoveTo 321 148 self
					)
				else
					(= cycles 1)
				)
				(boss
					loop: 1
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 160 42 self
				)
			)
			(8 0)
			(9
				(boss dispose:)
				(if (== register 2) (cigar dispose:))
				(= cycles 1)
			)
			(10 (gEgo setCycle: End self))
			(11
				(proc0_1
					2
					(if (== (gEgo loop?) 1) 402 else 0)
					(if (== (gEgo loop?) 1) 14 else 4)
				)
				(= cycles 1)
			)
			(12
				(proc0_3)
				(proc700_5 1)
				(self dispose:)
			)
		)
	)
)

(instance shootEgo of Script
	(properties)
	
	(method (doit)
		(if (and (not state) (not (global2 script?)))
			(self cue:)
		)
		(super doit: &rest)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(proc0_2)
				((ScriptID 700 7) setCycle: CT 1 1 self)
			)
			(2
				(= local135 (= local136 89))
				(= local138 (- (gEgo x?) 3))
				(= local137 194)
				(= local139
					(Graph
						grSAVE_BOX
						(- local135 1)
						(- local137 1)
						(+ local136 1)
						(+ local138 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local136
					local137
					local135
					local138
					(proc0_18 global133 global143)
					(- (gEgo priority?) 1)
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local135 1)
					(- local137 1)
					(+ local136 1)
					(+ local138 1)
				)
				(aSound number: 105 loop: 1 play:)
				(= cycles 1)
			)
			(3
				(blast
					init:
					cel: 0
					posn: local138 local135
					setPri: (+ (gEgo priority?) 1)
					setCycle: End
				)
				(gEgo view: 26 cel: 0 cycleSpeed: 12 setCycle: End self)
				(Graph grRESTORE_BOX local139)
				(Graph
					grREDRAW_BOX
					(- local135 1)
					(- local137 1)
					(+ local136 1)
					(+ local138 1)
				)
			)
			(4 (proc0_10 8 24))
		)
	)
)

(instance egoBwGreen of BeltWay
	(properties
		xStep 2
		xOff 8
		yOff 1
		xTweak 2
		key 270
		head 90
		xDir 1
		yDir 1
	)
)

(instance egoBwBlue of BeltWay
	(properties
		xStep 2
		xOff 8
		yOff -1
		xTweak 2
		key 90
		head 270
		xDir -1
		yDir 1
	)
)

(instance tossedSFX of Sound
	(properties
		number 836
	)
)

(instance headCigarSFX of Sound
	(properties
		number 873
	)
)

(instance groundCigarSFX of Sound
	(properties
		number 874
	)
)

(instance egoLandsSFX of Sound
	(properties
		number 134
	)
)

(instance door of Sq4View
	(properties
		x 168
		y 91
		sightAngle 90
		view 385
		loop 6
		priority 1
		signal $4010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 375 say: 1)
			)
			(4 (gSq4GlobalNarrator say: 2))
			(6 (gSq4GlobalNarrator say: 1))
			(7 (gSq4GlobalNarrator say: 11))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance boss of Sq4Actor
	(properties
		x 160
		y 42
		sightAngle 90
		view 385
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 2))
			(6 (gSq4GlobalNarrator say: 3))
			(7 (gSq4GlobalNarrator say: 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pighead of Sq4Prop
	(properties
		z 1000
		view 1385
		loop 3
	)
)

(instance cigar of Sq4Actor
	(properties
		z 1000
		sightAngle 90
		yStep 1
		view 385
		loop 5
		xStep 2
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 5))
			(6 (gSq4GlobalNarrator say: 6))
			(7 (gSq4GlobalNarrator say: 6))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance blast of Sq4Prop
	(properties
		view 28
	)
)

(instance store of Sq4Feature
	(properties
		x 131
		y 94
		sightAngle 90
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: burgerPoly)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 7))
			(6 (gSq4GlobalNarrator say: 8))
			(7 (gSq4GlobalNarrator say: 4))
			(4 (gSq4GlobalNarrator say: 9))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush1 of Sq4Feature
	(properties
		x 55
		y 90
		nsTop 81
		nsLeft 44
		nsBottom 106
		nsRight 63
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 370 say: 12)
			)
			(6 (gSq4GlobalNarrator say: 10))
			(7 (gSq4GlobalNarrator say: 11))
			(4
				(gSq4GlobalNarrator modNum: 380 say: 1)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush2 of Sq4Feature
	(properties
		x 262
		y 110
		nsTop 93
		nsLeft 256
		nsBottom 118
		nsRight 274
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 370 say: 12)
			)
			(6 (gSq4GlobalNarrator say: 10))
			(7 (gSq4GlobalNarrator say: 11))
			(4
				(gSq4GlobalNarrator modNum: 380 say: 1)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance burgerPoly of Polygon
	(properties)
)

(instance aSound of Sound
	(properties)
)

(instance tPighead of FaceTalker
	(properties
		noun 24
		talkerNum 24
	)
)

(instance tROG of Sq4Talker
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

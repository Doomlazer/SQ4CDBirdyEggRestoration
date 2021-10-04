;;; Sierra Script 1.0 - (do not remove this comment)
(script# 45)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use ForwardCounter)
(use n958)
(use DPath)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm045 0
)

(local
	local0 =  250
	[local1 56] = [18 115 42 97 92 85 119 55 130 51 151 66 159 65 163 58 175 52 193 61 211 60 256 67 275 84 274 95 261 104 249 104 230 120 217 119 215 131 184 137 182 146 162 148 107 142 93 134 80 131 63 110 48 119 18 125]
	[local57 10] = [127 122 153 112 159 123 149 131 129 132]
	[local67 12] = [219 120 218 131 206 136 197 132 197 122 205 116]
)
(procedure (localproc_0bb2 param1 param2 param3 param4 &tmp temp0 temp1 temp2)
	(gLongSong2 number: 105 vol: 127 loop: 1 play:)
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

(instance rm045 of SQRoom
	(properties
		style $000a
		horizon 150
		north 30
		east 50
		south 60
		west 40
	)
	
	(method (init)
		(proc958_0 128 4 27 46)
		(proc958_0 132 149)
		(Load rsSCRIPT 956)
		(switch global12
			(25
				(gEgo x: 20 y: (+ horizon (gEgo yStep?)))
			)
			(30
				(gEgo
					loop: 2
					x:
						(cond 
							((< (gEgo x?) 80) 80)
							((> (gEgo x?) 240) 240)
							(else (gEgo x?))
						)
					y: 162
				)
			)
			(35
				(gEgo x: 300 y: (+ horizon (gEgo yStep?)))
			)
			(40 (gEgo x: 5 y: 160))
			(50 (gEgo x: 315 y: 160))
			(60
				(gEgo y: 189 setMotion: MoveTo (gEgo x?) 188)
			)
			(72
				(gear1 init: stopUpd:)
				(gear2 init: stopUpd:)
				(flap init: stopUpd:)
				(proc0_2)
				(self setScript: egoClimbsDown)
			)
			(else 
				(gEgo loop: 2 posn: 160 162)
			)
		)
		(lightningScript start: 1)
		(lightning1 init: hide: setScript: lightningScript)
		(if (proc0_6 0)
			(Load rsPIC 46)
			(Load rsSCRIPT 964)
			(proc958_0 128 7 13)
			(proc958_0 132 109 158 136 105 159 888)
			(shipPoly points: @local1 size: 27)
			(compartmentPoly points: @local57 size: 5)
			(cockpitPoly points: @local67 size: 6)
			(shipFeature init:)
			(compartmentFeature init:)
			(cockpitFeature init:)
			(self horizon: 140)
			(global2
				addObstacle:
					((Polygon new:)
						type: 2
						init:
							207
							0
							207
							148
							276
							153
							273
							164
							251
							165
							246
							175
							206
							175
							193
							171
							147
							172
							141
							178
							103
							178
							81
							170
							89
							165
							45
							154
							0
							154
							0
							0
						yourself:
					)
			)
			(gEgo setLoop: -1 illegalBits: 0)
			(proc958_0 128 7 45)
			(gear1 init: stopUpd:)
			(gear2 init: stopUpd:)
			(flap init: stopUpd:)
		)
		(self drawPic: 45)
		(if (or (proc0_6 0) (== global12 72))
			(self overlay: 46 0)
		)
		(theRubble init:)
		(theRightBldg init:)
		(theLeftBldg init:)
		(theBackBldgs init:)
		(theStreet init:)
		(theArea init:)
		(self setRegions: 701)
		(thunder init:)
		(super init:)
		(self setRegions: 705)
		(gEgo init:)
		(= picture 45)
		(if (!= global12 72) (proc0_3))
	)
	
	(method (doit)
		(super doit:)
		(cond 
			((or (not (proc0_6 0)) (global2 script?)) 0)
			(
				(or
					(not (if (< 155 (gEgo y?)) (< (gEgo y?) 185)))
					(> (gEgo x?) 250)
					(< local0 0)
				)
				(global2 setScript: shootEgo)
			)
			(else (= local0 (- local0 1)))
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 30)
			(cond 
				((< (gEgo x?) 80) (= newRoomNumber 25))
				((> (gEgo x?) 240) (= newRoomNumber 35))
			)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo x: -5 y: 160 setMotion: MoveTo 10 160 self)
			)
			((proc0_3) (self dispose:))
		)
	)
)

(instance lightningScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 10 20)))
			(1
				(self start: 0)
				(= seconds (Random 3 6))
			)
			(2
				(if (== (global2 script?) egoHides)
					(self init:)
				else
					(client
						show:
						setCel: 0
						setCycle: ForwardCounter (Random 1 3) self
					)
				)
			)
			(3
				(thunder play:)
				(client hide:)
				(= cycles 15)
			)
			(4 (self init:))
		)
	)
)

(instance thunder of Sound
	(properties
		number 149
		priority 13
	)
)

(instance egoHides of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(global2 horizon: 0)
				(gEgo setMotion: PolyPath 132 150 self)
			)
			(1
				(gSq4GlobalNarrator say: 18)
				(gEgo
					posn: 137 142
					view: 45
					loop: 3
					cel: 0
					setCycle: End self
				)
			)
			(2
				(proc0_11 43 5)
				(gEgo hide: dispose:)
				(= seconds 4)
			)
			(3
				(gLongSong number: 107 loop: 1 vol: 127 play:)
				(= seconds 3)
			)
			(4
				(gLongSong2 number: 158 loop: -1 setVol: 127 play:)
				(gear1
					setPri: 1
					cycleSpeed: 12
					setMotion: MoveTo (gear1 x?) 104
					setCycle: End flap
				)
				(gear2
					setPri: 1
					setMotion: DPath 188 134 174 120 174 78 self
				)
			)
			(5
				(gLongSong number: 109 loop: -1 play: setVol: 127)
				(= seconds 3)
			)
			(6
				(global2 newRoom: 72)
				(client setScript: 0)
			)
		)
	)
)

(instance egoClimbsDown of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					normal: 0
					view: 45
					loop: 3
					cel: 8
					x: 137
					y: 142
					setCycle: Beg self
				)
			)
			(1
				(proc0_9)
				(gEgo
					normal: 1
					view: 0
					x: 135
					y: 164
					setCycle: Walk
					setMotion: MoveTo 157 172 self
				)
			)
			(2
				(gEgo setMotion: PolyPath 160 250 self)
			)
			(3
				(gEgo dispose:)
				(egoHides start: 2)
				(global2 setScript: egoHides)
			)
		)
	)
)

(instance shootEgo of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cop1
					init:
					setCycle: Walk
					setMotion: MoveTo 310 (cop1 y?) self
				)
				(cop2
					init:
					setCycle: Walk
					setMotion: PolyPath 0 (cop2 y?)
				)
			)
			(1
				(cop1 view: 13 cel: 0 setMotion: 0 setCycle: CT 4 1 self)
			)
			(2
				(proc0_2)
				(cop2 setMotion: 0)
				(cop1 setCycle: End self)
				(if (< (cop1 x?) (gEgo x?))
					(localproc_0bb2
						(- (cop1 y?) 27)
						(cop1 x?)
						(- (gEgo y?) 32)
						(gEgo x?)
					)
				else
					(localproc_0bb2
						(- (gEgo y?) 32)
						(gEgo x?)
						(- (cop1 y?) 27)
						(cop1 x?)
					)
				)
			)
			(3
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
			(4
				(gEgo setCycle: CT 1 -1 self)
			)
			(5 (gEgo setCycle: End self))
			(6 (= seconds 4))
			(7 (proc0_10 8))
		)
	)
)

(instance deathScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(global2 horizon: 0)
				(gEgo setMotion: PolyPath 210 175 self)
			)
			(1
				(gEgo setMotion: MoveTo (gEgo x?) 165 self)
			)
			(2
				(gEgo
					view: 45
					loop: 4
					cel: 0
					x: (+ (gEgo x?) 5)
					y: (- (gEgo y?) 13)
					setCycle: End self
				)
			)
			(3
				(gEgo hide: dispose:)
				(= seconds 3)
			)
			(4
				(gSq4GlobalNarrator say: 1)
				(gLongSong2 number: 105 loop: 1 vol: 127 play:)
				(= cycles 4)
			)
			(5
				(gLongSong2 vol: 85 play:)
				(= cycles 2)
			)
			(6
				(gLongSong2 vol: 55 play:)
				(= cycles 6)
			)
			(7
				(gLongSong2 vol: 25 play:)
				(= cycles 4)
			)
			(8
				(gLongSong2 vol: 5 play:)
				(= cycles 10)
			)
			(9
				(gLongSong2 stop:)
				(gSq4GlobalNarrator say: 2)
				(proc0_10 8 28)
			)
		)
	)
)

(instance lightning1 of Sq4Prop
	(properties
		x 150
		y 48
		view 46
		lookStr 3
	)
)

(instance gear1 of Sq4Actor
	(properties
		x 132
		y 120
		view 45
		priority 13
		signal $6810
		lookStr 4
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 4))
			(4
				(if (and (proc0_6 0) (not (global2 script?)))
					(if (not script)
						(proc0_2)
						(global2 setScript: egoHides)
					else
						(gSq4GlobalNarrator say: 5)
					)
				else
					(super doVerb: theVerb)
				)
			)
			(9 (gSq4GlobalNarrator say: 6))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance gear2 of Sq4Actor
	(properties
		x 194
		y 134
		view 45
		loop 1
		priority 9
		signal $6810
		lookStr 4
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 4))
			(4 (gSq4GlobalNarrator say: 7))
			(9 (gSq4GlobalNarrator say: 6))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance flap of Sq4Prop
	(properties
		x 141
		y 111
		view 45
		loop 2
		priority 13
		signal $6010
		lookStr 8
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 8))
			(4
				(if (proc0_6 0)
					(if (not script)
						(proc0_2)
						(global2 setScript: egoHides)
					else
						(gSq4GlobalNarrator say: 5)
					)
				else
					(super doVerb: theVerb)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
	
	(method (cue)
		(if cel
			(flapSound number: 159 loop: 1 vol: 127 play:)
		else
			(self setCycle: End self)
		)
	)
)

(instance flapSound of Sound
	(properties)
)

(instance cop1 of Sq4Actor
	(properties
		x 319
		y 175
		view 7
		loop 2
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 703 say: 3)
			)
			(else  (super doVerb: &rest))
		)
	)
)

(instance cop2 of Sq4Actor
	(properties
		x 330
		y 185
		view 7
	)
	
	(method (doVerb theVerb)
		(cop1 doVerb: theVerb)
	)
)

(instance theRubble of Sq4Feature
	(properties
		x 144
		y 99
		z 12
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck $0040
		lookStr 9
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 9))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theRightBldg of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		onMeCheck $0080
		lookStr 10
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 10))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theLeftBldg of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		onMeCheck $2000
		lookStr 11
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 11))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theBackBldgs of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		onMeCheck $0010
		lookStr 12
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 12))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theArea of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		lookStr 13
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 13))
			(24
				((ScriptID 705 4) doVerb: theVerb param2)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance shipFeature of Sq4Feature
	(properties
		x 160
		y 100
		sightAngle 25
		lookStr 14
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: shipPoly)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 14))
			(4 (gSq4GlobalNarrator say: 15))
			(9 (gSq4GlobalNarrator say: 6))
			(6 (gSq4GlobalNarrator say: 16))
			(7 (gSq4GlobalNarrator say: 17))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance shipPoly of Polygon
	(properties)
)

(instance compartmentFeature of Sq4Feature
	(properties
		x 160
		y 189
		z 89
		sightAngle 25
		lookStr 18
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: compartmentPoly)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 18))
			(4
				(gear1 doVerb: theVerb param2)
			)
			(9 (gSq4GlobalNarrator say: 19))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance compartmentPoly of Polygon
	(properties)
)

(instance cockpitFeature of Sq4Feature
	(properties
		x 207
		y 189
		z 64
		sightAngle 25
		lookStr 20
	)
	
	(method (init)
		(super init:)
		(self onMeCheck: cockpitPoly)
	)
	
	(method (doVerb theVerb)
		(cond 
			((== theVerb 1) (gSq4GlobalNarrator say: 20))
			((== theVerb 4) (proc0_2) (global2 setScript: deathScript))
			(else (super doVerb: theVerb))
		)
	)
)

(instance cockpitPoly of Polygon
	(properties)
)

(instance theStreet of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		onMeCheck $0002
		lookStr 21
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 21))
			(6 (gSq4GlobalNarrator say: 22))
			(7 (gSq4GlobalNarrator say: 23))
			(24
				((ScriptID 705 4) doVerb: theVerb param2)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

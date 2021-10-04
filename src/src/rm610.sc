;;; Sierra Script 1.0 - (do not remove this comment)
(script# 610)
(include sci.sh)
(use Main)
(use ulence)
(use SQRoom)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use n958)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm610 0
)

(instance rm610 of SQRoom
	(properties
		picture 610
		horizon 110
		north 613
		east 611
		west 609
	)
	
	(method (init)
		(switch gWest
			(615
				(gEgo posn: 206 135)
				(self setScript: exitBar)
			)
			(620
				(gEgo
					posn: 192 113
					z: 1000
					view: 615
					setLoop: 0
					cel: 0
					setPri: 9
					looper: 0
					normal: 0
					setStep: 14 14
					cycleSpeed: 6
				)
				(self setScript: flyOut)
			)
			(613 (gEgo x: 87 y: 124))
			(else  (gEgo x: 24 y: 165))
		)
		(if (not (proc999_5 gWest 615 620))
			(gLongSong2 vol: 70 number: 804 loop: -1 playBed:)
		)
		(if (not (proc0_6 75))
			(bike1 init:)
			(bike2 init:)
			(bike3 init:)
			((ScriptID 706 1) init:)
			(biker2 init:)
			(biker3 init:)
		)
		(theSign init: setCycle: Fwd)
		(gEgo init: ignoreActors: 1 illegalBits: 0)
		(super init:)
		(self
			setRegions: 706
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						0
						319
						0
						319
						158
						295
						158
						295
						162
						283
						162
						253
						162
						253
						158
						225
						158
						225
						148
						207
						148
						207
						142
						176
						142
						176
						135
						214
						135
						214
						132
						149
						132
						131
						126
						123
						121
						94
						103
						68
						103
						73
						123
						63
						131
						44
						136
						0
						136
					yourself:
				)
		)
		(ship1 init:)
		(ship3 init:)
		(building init:)
		(door init:)
		(if (not (proc0_6 75))
			(self
				addObstacle:
					((Polygon new:)
						type: 2
						init:
							129
							153
							177
							151
							210
							165
							249
							185
							191
							187
							170
							180
							153
							170
							136
							171
							124
							160
						yourself:
					)
			)
		)
		(Load rsSOUND 804)
		(Load rsVIEW 630)
		(Load rsVIEW 631)
		(Load rsVIEW 615)
		(Load rsVIEW 610)
		(Load rsSOUND 147)
		(Load rsSOUND 836)
		(if (== (ulence status?) 1)
			(ulence status: 2 bikerComing: 1)
			(Load rsVIEW 632)
			(Load rsVIEW 634)
			(Load rsVIEW 633)
			(Load rsVIEW 635)
			(Load rsSOUND 50)
			(Load rsSOUND 837)
			(Load rsSOUND 841)
			(ulence status: 2)
		else
			(ulence bikerComing: 0)
		)
		((ScriptID 706 8)
			init:
			nsLeft: 0
			nsTop: -1
			nsBottom: 86
			nsRight: 319
		)
		((ScriptID 706 7)
			init:
			nsLeft: 0
			nsTop: 88
			nsBottom: 189
			nsRight: 319
		)
	)
	
	(method (doit)
		(if
			(and
				(== (ulence status?) 4)
				(< ((ScriptID 706 1) distanceTo: gEgo) 20)
			)
			(proc0_2)
			(ulence status: 6)
			(gEgo setScript: 0)
			(ulence deathLoop: 1)
			(self setScript: (ScriptID 706 3))
		)
		(cond 
			(script 0)
			((== (gEgo edgeHit?) 1) (gLongSong2 fade: 0 30 5 0))
			((== (gEgo edgeHit?) 2) (gLongSong2 fade: 0 30 5 0))
			((== (gEgo edgeHit?) 4) (gLongSong2 fade: 0 30 5 0))
			((gEgo inRect: 192 122 221 137)
				(if (not (== (global2 script?) enterBar))
					(global2 setScript: enterBar)
				)
			)
			(
				(and
					(> (Random 0 100) 85)
					(== (ulence status?) 2)
					(gEgo inRect: 116 154 146 164)
				)
				(proc0_2)
				(ulence status: 3)
				((ScriptID 706 1)
					view: 633
					init:
					hide:
					posn: -30 127
					setLoop: 0
					setScript: runOverScript1
				)
				(gEgo setScript: (ScriptID 706 5))
			)
			(
				(and
					(> (Random 0 100) 85)
					(== (ulence status?) 2)
					(gEgo inRect: 196 175 222 185)
				)
				(proc0_2)
				(ulence status: 3)
				((ScriptID 706 1)
					view: 632
					init:
					hide:
					posn: -28 (- (gEgo y?) 5)
					setLoop: 0
					setStep: 15 15
					setScript: runOverScript2
				)
				(gEgo setScript: (ScriptID 706 5))
			)
			(
				(and
					(> (Random 0 100) 85)
					(== (ulence status?) 2)
					(gEgo inRect: 100 143 130 152)
				)
				(proc0_2)
				(ulence status: 3)
				((ScriptID 706 1)
					view: 634
					init:
					hide:
					posn: 347 176
					setLoop: 1
					setScript: runOverScript3
				)
				(gEgo setScript: (ScriptID 706 4))
			)
		)
		(super doit: &rest)
	)
)

(instance flyOut of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gLongSong stop: number: 127 vol: 127)
				(= cycles 2)
			)
			(1
				(thumpSound vol: 127 loop: 1 number: 836 play:)
				(= ticks 40)
			)
			(2
				(gEgo
					z: 0
					setLoop: 0
					cel: 0
					setCycle: CT 3 1
					setMotion: MoveTo 130 127 self
				)
			)
			(3
				(thumpSound number: 134 play:)
				(= seconds 2)
			)
			(4 (gEgo setCycle: End self))
			(5
				(gEgo
					view: 0
					setLoop: 1
					heading: 270
					posn: (- (gEgo x?) 25) (+ (gEgo y?) 25)
				)
				(= cycles 1)
			)
			(6
				(proc0_1 (gEgo loop?) 0)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance bikesFall of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gLongSong loop: 1 number: 140 play:)
				(bike1 setCycle: End self)
			)
			(1 (bike2 setCycle: End self))
			(2 (bike3 setCycle: End self))
			(3 (self dispose:))
		)
	)
)

(instance exitBar of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: PolyPath 150 135 self)
			)
			(1
				(proc0_1 (gEgo loop?) 0)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance bikerScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				((ScriptID 706 1)
					setLoop: 0
					setCycle: Fwd
					setStep: 4 4
					setMotion: MoveTo 159 134 self
				)
			)
			(1
				((ScriptID 706 1) setMotion: MoveTo 133 146 self)
			)
			(2
				((ScriptID 706 1)
					setLoop: 1
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(3 (= seconds 2))
			(4
				(biker2 setScript: biker2Script)
				((ScriptID 706 1)
					setPri: 12
					setLoop: 2
					cel: 0
					posn: 121 147
					cycleSpeed: 3
					setCycle: End self
					setMotion: MoveTo 133 156
				)
				(= cycles 3)
			)
			(5
				(bike1Sound init: play:)
				(bike2Sound init:)
				(bike3Sound init:)
				(bike1 setCel: 0)
			)
			(6
				(bike1 dispose:)
				((ScriptID 706 1)
					view: 634
					setLoop: 1
					setStep: 10 10
					setMotion: MoveTo -50 (- (gEgo y?) 40) self
				)
			)
			(7 (self dispose:))
		)
	)
)

(instance biker2Script of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(biker2
					view: 630
					cycleSpeed: 6
					setLoop: 0
					posn: 213 133
					setCycle: Fwd
					setStep: 4 4
					setPri: 9
					setMotion: MoveTo 167 133 self
				)
			)
			(1
				(biker2 setMotion: MoveTo 134 162 self)
			)
			(2
				(biker2
					setLoop: 1
					cycleSpeed: 12
					cel: 0
					posn: 138 163
					setCycle: End self
				)
			)
			(3
				(biker2 setPri: 12)
				(= seconds 2)
			)
			(4
				(biker3 setScript: biker3Script)
				(biker2 setLoop: 2 setCel: 0 posn: 146 162)
				(= cycles 2)
			)
			(5
				(biker2 setCel: 1 posn: 149 162)
				(= cycles 2)
			)
			(6
				(biker2 setCel: 2 posn: 155 162)
				(= cycles 2)
			)
			(7
				(biker2 setCel: 3 posn: 164 172)
				(= cycles 2)
			)
			(8
				(biker2 setCel: 4 posn: 176 172)
				(= cycles 2)
			)
			(9
				(biker2 setCel: 5 posn: 176 178)
				(bike2 setCel: 0)
				(= cycles 2)
			)
			(10
				(bike2Sound play:)
				(bike2 dispose:)
				(biker2
					view: 633
					setLoop: 7
					setStep: 10 10
					setPri: -1
					setMotion: MoveTo 44 83 self
				)
			)
			(11
				(biker2 hide:)
				(self dispose:)
			)
		)
	)
)

(instance biker3Script of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(biker3
					view: 631
					posn: 217 133
					setLoop: 0
					setPri: 9
					cycleSpeed: 10
					setCycle: Fwd
					setMotion: MoveTo 161 133 self
				)
			)
			(1
				(biker3 setMotion: MoveTo 133 161 self)
			)
			(2
				(biker3
					setLoop: 1
					posn: 132 163
					cel: 0
					cycleSpeed: 13
					setCycle: End self
				)
			)
			(3
				(biker3 setPri: 12)
				(= seconds 2)
			)
			(4
				(biker3 setLoop: 2 setCel: 0 posn: 145 167)
				(= cycles 3)
			)
			(5
				(biker3 setCel: 1 posn: 168 168)
				(= cycles 3)
			)
			(6
				(biker3 setCel: 2 posn: 176 170)
				(= cycles 3)
			)
			(7
				(biker3 setCel: 3 posn: 194 170)
				(= cycles 3)
			)
			(8
				(bike3Sound play:)
				(biker3
					view: 632
					setLoop: 5
					posn: 205 173
					setStep: 10 10
					setMotion: MoveTo 126 225 self
				)
				(bike3 dispose:)
			)
			(9 (= seconds 2))
			(10 (global2 newRoom: 609))
		)
	)
)

(instance enterBar of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: PolyPath 214 135 self)
			)
			(1
				(if (or (proc0_6 75) (not (proc0_6 15)))
					(gLongSong2 fade: 85 10 10 0)
					(global2 newRoom: 615)
				else
					(gEgo
						view: 615
						setLoop: 0
						setCel: 3
						setPri: 9
						posn: 227 114
					)
					(= seconds 2)
				)
			)
			(2
				(thumpSound vol: 127 loop: 1 number: 836 play:)
				(gEgo posn: 205 104)
				(= cycles 1)
			)
			(3
				(gEgo posn: 188 95)
				(= cycles 1)
			)
			(4
				(gEgo posn: 160 87)
				(= cycles 1)
			)
			(5
				(gEgo posn: 146 88)
				(= cycles 1)
			)
			(6
				(gEgo posn: 128 99)
				(= cycles 1)
			)
			(7
				(gEgo posn: 116 112)
				(= cycles 1)
			)
			(8
				(gEgo posn: 88 123)
				(thumpSound number: 147 play:)
				(= seconds 2)
			)
			(9 (gEgo setCycle: End self))
			(10
				(gEgo
					view: 0
					setLoop: 1
					setHeading: 270
					posn: (- (gEgo x?) 25) (+ (gEgo y?) 25)
				)
				(= cycles 1)
			)
			(11
				(proc0_1 (gEgo loop?) 0)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance runOverScript1 of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(ulence egoBusy: 1)
				(gLongSong2
					vol: 25
					number: 50
					loop: -1
					playBed:
					fade: 127 10 10 0
				)
				(= seconds 2)
			)
			(1
				((ScriptID 706 6) init: play:)
				((ScriptID 706 1) show: setMotion: MoveTo 40 127 self)
			)
			(2
				(ulence status: 4)
				(proc0_3)
				((ScriptID 706 1)
					setLoop: 4
					posn: 57 129
					setPri: (+ (gEgo priority?) 1)
					setMotion: MoveTo 192 174 self
				)
			)
			(3
				((ScriptID 706 1)
					setLoop: 0
					posn: 209 177
					setMotion: MoveTo 369 177 self
				)
			)
			(4
				(gLongSong2 fade: 0 10 10 0)
				((ScriptID 706 6) fade:)
				(= seconds 3)
			)
			(5
				(gLongSong2 vol: 70 number: 804 loop: -1 playBed:)
				((ScriptID 706 1) hide:)
				(= seconds 3)
			)
			(6
				(if (!= (ulence status?) 6)
					(ulence status: 1 fieldOff: 0 bikerComing: 0 egoBusy: 0)
					(gEgo setScript: 0)
					(gSq4GlobalNarrator modNum: 611 say: 1 self)
				)
				(= cycles 2)
			)
			(7 (proc0_3) (self dispose:))
		)
	)
)

(instance runOverScript2 of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(ulence egoBusy: 1)
				(gLongSong2
					vol: 25
					number: 50
					loop: -1
					playBed:
					fade: 127 10 10 0
				)
				(= seconds 2)
			)
			(1
				((ScriptID 706 6) init: play:)
				((ScriptID 706 1)
					show:
					setMotion: MoveTo 132 (- (gEgo y?) 7) self
				)
			)
			(2
				(ulence status: 4)
				(proc0_3)
				((ScriptID 706 1)
					setPri: (+ (gEgo priority?) 1)
					setMotion: MoveTo 372 (- (gEgo y?) 7) self
				)
			)
			(3
				(gLongSong2 fade: 0 10 10 0)
				((ScriptID 706 6) fade:)
				(= seconds 3)
			)
			(4
				(gLongSong2 vol: 70 number: 804 loop: -1 playBed:)
				((ScriptID 706 1) hide:)
				(= seconds 3)
			)
			(5
				(if (!= (ulence status?) 6)
					(ulence status: 1 fieldOff: 0 bikerComing: 0 egoBusy: 0)
					(gEgo setScript: 0)
					(gSq4GlobalNarrator modNum: 611 say: 1 self)
				)
				(= cycles 2)
			)
			(6 (proc0_3) (self dispose:))
		)
	)
)

(instance runOverScript3 of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(ulence egoBusy: 1)
				(gLongSong2
					vol: 25
					number: 50
					loop: -1
					playBed:
					fade: 127 10 10 0
				)
				(= seconds 2)
			)
			(1
				((ScriptID 706 6) init: play:)
				((ScriptID 706 1)
					show:
					setPri: 15
					setMotion: MoveTo 167 176 self
				)
			)
			(2
				(ulence status: 4)
				(proc0_3)
				((ScriptID 706 1)
					setPri: (+ (gEgo priority?) 1)
					setLoop: 7
					setMotion: MoveTo 60 106 self
				)
			)
			(3
				((ScriptID 706 1)
					setPri: -1
					setMotion: MoveTo 33 91 self
				)
			)
			(4
				((ScriptID 706 1) hide:)
				(gLongSong2 fade: 0 10 10 0)
				((ScriptID 706 6) init: play:)
				(= seconds 3)
			)
			(5
				(gLongSong2 vol: 70 number: 804 loop: -1 playBed:)
				(if (!= (ulence status?) 6)
					(ulence status: 1 fieldOff: 0 bikerComing: 0 egoBusy: 0)
					(gEgo setScript: 0)
					(gSq4GlobalNarrator modNum: 611 say: 1 self)
				)
				(= cycles 2)
			)
			(6 (proc0_3) (self dispose:))
		)
	)
)

(instance kickScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(ulence status: 99)
				(proc958_0 128 615 616 632 633 634 50)
				(proc0_11 75 5)
				(gEgo setMotion: PolyPath 130 169 self)
			)
			(1 (gEgo setHeading: 90 self))
			(2
				(gEgo view: 615 setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(self setScript: bikesFall self)
			)
			(4 (gEgo setCycle: Beg self))
			(5
				(proc0_1 (gEgo loop?) 0)
				(gEgo posn: (- (gEgo x?) 2) (gEgo y?) setLoop: 0)
				(= cycles 1)
			)
			(6
				(gEgo setLoop: -1 setHeading: 270 self)
			)
			(7
				(ulence fieldOff: 1)
				(gEgo
					view: 615
					setLoop: 5
					setCycle: Walk
					setStep: 6 4
					setMotion: MoveTo 25 (+ (gEgo y?) 20) self
				)
			)
			(8
				(gLongSong number: 0 vol: 0 stop:)
				(gLongSong2 vol: 127 number: 50 loop: -1 playBed:)
				(= seconds 1)
			)
			(9
				((ScriptID 706 1)
					init:
					view: 616
					posn: 210 134
					setScript: bikerScript
				)
				(gEgo setMotion: MoveTo -30 (+ (gEgo y?) 20) self)
			)
			(10
				(ulence fieldOff: 0)
				(gEgo dispose:)
			)
		)
	)
)

(instance biker2 of Sq4Actor
	(properties
		x 223
		y 134
		yStep 4
		view 630
		priority 9
		signal $6011
		illegalBits $0000
		xStep 4
	)
)

(instance biker3 of Sq4Actor
	(properties
		x 223
		y 134
		yStep 4
		view 631
		priority 9
		signal $6011
		illegalBits $0000
		xStep 4
	)
)

(instance theSign of Sq4Prop
	(properties
		x 209
		y 75
		sightAngle 45
		view 610
		priority 12
		signal $6010
		lookStr 1
	)
)

(instance bike1 of Sq4Prop
	(properties
		x 159
		y 150
		view 615
		loop 4
		priority 12
		signal $4011
		lookStr 2
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 2))
			(4
				(cond 
					((not (proc0_6 15)) (gSq4GlobalNarrator say: 3))
					((not (proc0_6 75)) (global2 setScript: kickScript))
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bike2 of Sq4Prop
	(properties
		x 187
		y 160
		view 615
		loop 3
		priority 13
		signal $4011
		lookStr 2
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 2))
			(4
				(cond 
					((not (proc0_6 15)) (gSq4GlobalNarrator say: 3))
					((not (proc0_6 75)) (global2 setScript: kickScript))
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bike3 of Sq4Prop
	(properties
		x 211
		y 168
		view 615
		loop 2
		priority 14
		signal $4011
		lookStr 2
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 2))
			(4
				(cond 
					((not (proc0_6 15)) (gSq4GlobalNarrator say: 3))
					((not (proc0_6 75)) (global2 setScript: kickScript))
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ship1 of Sq4Feature
	(properties
		x 34
		y 88
		nsTop 49
		nsBottom 128
		nsRight 69
		sightAngle 45
		onMeCheck $0010
		lookStr 4
	)
)

(instance ship3 of Sq4Feature
	(properties
		x 150
		y 85
		nsTop 52
		nsLeft 105
		nsBottom 118
		nsRight 196
		sightAngle 45
		onMeCheck $0008
		lookStr 5
	)
)

(instance door of Sq4Feature
	(properties
		x 178
		y 111
		nsTop 85
		nsLeft 162
		nsBottom 138
		nsRight 194
		sightAngle 45
		onMeCheck $0004
		lookStr 6
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 6))
			(4
				(if (not (== (global2 script?) enterBar))
					(global2 setScript: enterBar)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance building of Sq4Feature
	(properties
		x 225
		y 93
		nsTop 23
		nsLeft 132
		nsBottom 164
		nsRight 319
		sightAngle 45
		onMeCheck $0002
		lookStr 1
	)
)

(instance thumpSound of Sound
	(properties
		flags $0001
		number 147
	)
)

(instance bike1Sound of Sound
	(properties
		flags $0001
		number 837
	)
)

(instance bike2Sound of Sound
	(properties
		flags $0001
		number 837
	)
)

(instance bike3Sound of Sound
	(properties
		flags $0001
		number 837
	)
)

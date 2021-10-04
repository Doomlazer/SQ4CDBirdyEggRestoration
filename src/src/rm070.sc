;;; Sierra Script 1.0 - (do not remove this comment)
(script# 70)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Feature)
(use RTRandCycle)
(use RandCycle)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Sound)
(use Cycle)
(use User)
(use Obj)

(public
	rm070 0
)

(local
	local0
	local1
	[local2 26] = [5 0 45 127 5 0 53 122 5 0 61 117 5 0 69 112 5 0 77 107 5 0 85 102 -32768]
	local28
)
(procedure (localproc_0e7f param1)
	(= local0
		(Display
			param1
			106
			300
			100
			6
			1
			101
			0
			105
			69
			102
			global129
			107
		)
	)
	(Display
		param1
		106
		300
		100
		6
		1
		101
		0
		105
		68
		102
		global130
	)
)

(procedure (localproc_0ebc)
	(if local0 (Display 70 0 108 local0) (= local0 0))
)

(instance rm070 of SQRoom
	(properties
		picture 70
	)
	
	(method (init)
		(Load rsVIEW 70)
		(super init:)
		(aSound init:)
		(if (== ((gInv at: 5) owner?) 70) (theJar init:))
		(blotter init:)
		(dr init: stopUpd:)
		(grid init:)
		(euroTrip init:)
		(theShadow init:)
		(theDesk init:)
		(theWires init:)
		(thePipes init:)
		(theRoom init:)
		(gEgo
			init:
			normal: 0
			view: 70
			loop: 0
			cel: 0
			illegalBits: -32766
			x: 223
			y: -2
			xStep: 3
			yStep: 15
		)
		(proc0_2)
		(self setScript: fallScript)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init: 166 126 264 129 265 160 137 160
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 275 82 319 10 319 183 296 162
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 9 189 29 174 298 174 316 189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 0 162 43 162 49 171 0 171
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 166 73 144 0 319 0 272 77
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 138 0 162 74 87 127 71 127 46 144 56 144 47 151 45 160 0 160 0 0
					yourself:
				)
		)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script)
			((and local28 (proc0_5 gEgo 2)) (global2 setScript: enterSewer))
		)
	)
)

(instance fallScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(gLongSong number: 815 vol: 127 loop: -1 playBed:)
				(gEgo
					setLoop: 0
					setCycle: 0
					setMotion: MoveTo 223 89 self
				)
			)
			(2
				(aSound init: number: 115 loop: 1 play:)
				(gEgo cycleSpeed: 12 setCycle: End self)
			)
			(3
				(proc0_1 0 0)
				(gEgo illegalBits: -32766 setHeading: 180)
				(= seconds 2)
			)
			(4
				(proc0_3)
				(client setScript: 0)
			)
		)
	)
)

(instance drScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo illegalBits: 0 setMotion: PolyPath 50 150 self)
			)
			(1
				(gEgo setPri: 13 setHeading: 270 self)
			)
			(2
				(aSound number: 816 play:)
				(gEgo
					view: 70
					normal: 0
					setLoop: 4
					cel: 0
					illegalBits: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(aSound play:)
				(gEgo cel: 0 setCycle: End self)
			)
			(4
				(aSound play:)
				(gEgo cel: 0 setCycle: End self)
			)
			(5
				(gEgo view: 0 setLoop: 1)
				(= cycles 1)
			)
			(6
				(aSound number: 810 loop: 1 play:)
				(dr setCycle: MCyc @local2 self)
			)
			(7
				(dr setPri: 3 stopUpd:)
				(= local28 1)
				(aSound number: 811 play:)
				(= seconds 1)
			)
			(8
				(proc0_3)
				(proc0_1 1)
				(gEgo illegalBits: -32768)
				(global32
					addToFront: drOpening
					eachElementDo: #init
					doit:
				)
				(self dispose:)
			)
		)
	)
)

(instance buttonScript of Script
	(properties)
	
	(method (init)
		(if (not (gSq4KeyDownHandler contains: self))
			(gSq4KeyDownHandler addToFront: self)
		)
		(if (not (gSq4MouseDownHandler contains: self))
			(gSq4MouseDownHandler addToFront: self)
		)
		(if (not (gSq4DirectionHandler contains: self))
			(gSq4DirectionHandler addToFront: self)
		)
		(super init: &rest)
	)
	
	(method (dispose)
		(gSq4KeyDownHandler delete: self)
		(gSq4MouseDownHandler delete: self)
		(gSq4DirectionHandler delete: self)
		(super dispose: &rest)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: PolyPath 195 159 self)
			)
			(1
				(gEgo
					setPri: (+ (gEgo priority?) 1)
					setMotion: MoveTo (gEgo x?) (- (gEgo y?) 2) self
				)
			)
			(2
				(gEgo view: 70 normal: 0 setLoop: 7 setCycle: Beg self)
			)
			(3
				(if (not (proc0_6 34)) (gSq4GlobalNarrator say: 1))
				(proc0_11 54 10)
				(gEgo view: 70 setLoop: 7 setCycle: End self)
				(if (not local28)
					(gEgo illegalBits: -32766)
				else
					(gEgo illegalBits: -32768)
				)
			)
			(4
				(aSound number: 812 loop: 1 play:)
				(= seconds 2)
			)
			(5 (gEgo setCycle: Beg self))
			(6 (= seconds 1))
			(7
				(proc0_1 3 0)
				(gEgo y: (+ (gEgo y?) 2) setHeading: 0 self)
				(if (not local28)
					(gEgo illegalBits: -32766)
				else
					(gEgo illegalBits: -32768)
				)
			)
			(8
				(if (not (proc0_6 34))
					(proc0_7 34)
					(aSound init: number: 813 loop: 1 play:)
					(if (== ((gInv at: 5) owner?) global11)
						(theJar stopUpd:)
					)
					(gEgo stopUpd:)
					(hologram init: cycleSpeed: 12 setCycle: End)
					(= seconds 3)
				else
					(gSq4GlobalNarrator say: 2)
					(proc0_3)
					(self dispose:)
				)
			)
			(9
				(hologramHead init: cycleSpeed: 12 setCycle: RandCycle)
				(hologram setLoop: 2 posn: 170 83 setCycle: RandCycle)
				(= cycles 1)
			)
			(10
				(gLongSong number: 814 loop: -1 play:)
				(theProfessor say: 1 self)
			)
			(11 (theProfessor say: 2 self))
			(12 (theProfessor say: 3 self))
			(13 (theProfessor say: 4 self))
			(14 (theProfessor say: 5 self))
			(15 (theProfessor say: 6 self))
			(16 (theProfessor say: 7 self))
			(17 (theProfessor say: 8 self))
			(18 (theProfessor say: 9 self))
			(19 (theProfessor say: 10 self))
			(20 (theProfessor say: 11 self))
			(21 (theProfessor say: 12 self))
			(22 (theProfessor say: 13 self))
			(23 (theProfessor say: 14 self))
			(24
				(gLongSong fade:)
				(hologram setCycle: 0)
				(hologramHead setCycle: 0)
				(= seconds 2)
			)
			(25
				(aSound play:)
				(hologramHead dispose:)
				(hologram
					setLoop: 1
					setCel: 4
					posn: 160 81
					setCycle: Beg self
				)
			)
			(26
				(gLongSong number: 815 vol: 127 play:)
				(hologram dispose:)
				(proc0_3)
				((gEgo _head?) startUpd:)
				(client setScript: 0)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(if local0
			(pEvent claimed: 1)
			(= seconds 0)
		else
			(super handleEvent: pEvent)
		)
	)
)

(instance jarScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: PolyPath 197 165 self)
			)
			(1
				(if (not local28)
					(gEgo illegalBits: -32766)
				else
					(gEgo illegalBits: -32768)
				)
				(proc0_13 gEgo theJar self)
			)
			(2
				(gSq4GlobalNarrator say: 3)
				(proc0_11 53 5)
				(gEgo get: 5)
				(theJar dispose:)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance enterSewer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: PolyPath 63 136 self)
			)
			(1 (gEgo setHeading: 270 self))
			(2
				(gEgo view: 70 setLoop: 8 cel: 0 setCycle: End self)
			)
			(3
				(proc0_3)
				(global2 newRoom: 85)
			)
		)
	)
)

(instance tripShow of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(proc0_13 gEgo theShadow self)
			)
			(1
				(gSq4GlobalNarrator
					modeless: 1
					returnVal: 0
					nMsgType: 1
					say: 21 self 2 64 63 20 67 315 25 global132 26 global129 27 1 30 310
				)
			)
			(2
				(screen init: setMotion: MoveTo 75 0 self)
			)
			(3 (= seconds 1))
			(4
				(screen view: 651)
				(gSq4GlobalNarrator say: 26 self)
			)
			(5
				(screen view: 652)
				(gSq4GlobalNarrator say: 27 self)
			)
			(6
				(screen view: 653)
				(gSq4GlobalNarrator say: 28 self)
			)
			(7
				(screen view: 650)
				(gSq4GlobalNarrator say: 29 self)
			)
			(8
				(screen view: 650 setMotion: MoveTo 75 -110 self)
			)
			(9
				(gSq4GlobalNarrator
					returnVal: 0
					nMsgType: 1
					say: 22 self 2 64 63 20 67 315 25 global132 26 global129 27 1 30 310
				)
			)
			(10 (= cycles 2))
			(11
				(gSq4GlobalNarrator
					returnVal: 0
					nMsgType: 1
					say: 23 self 2 64 63 20 67 315 25 global132 26 global129 27 1 30 310
				)
			)
			(12 (= cycles 2))
			(13
				(gSq4GlobalNarrator
					returnVal: 0
					nMsgType: 1
					say: 24 self 2 64 63 20 67 315 25 global132 26 global129 27 1 30 310
				)
			)
			(14 (= cycles 2))
			(15
				(gSq4GlobalNarrator
					returnVal: 0
					nMsgType: 1
					say: 25 self 2 64 63 20 67 315 25 global132 26 global129 27 1 30 310
				)
			)
			(16
				(proc0_3)
				(gSq4GlobalNarrator nMsgType: -1 modeless: 0)
				(self dispose:)
			)
		)
	)
)

(instance screen of Sq4Actor
	(properties
		x 75
		y -110
		yStep 4
		view 650
		priority 14
		signal $6010
	)
)

(instance euroTrip of Sq4Feature
	(properties
		x 18
		y 155
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(8
				(if (and (> (gEgo y?) 170) (< (gEgo x?) 60))
					(global2 setScript: tripShow)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (onMe param1)
		(proc999_4 0 180 8 190 param1)
	)
)

(instance dr of Sq4Actor
	(properties
		x 45
		y 127
		z -16
		sightAngle 45
		view 70
		loop 5
		priority 9
		signal $4810
		illegalBits $0000
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (not local28)
					(proc0_2)
					(global2 setScript: drScript)
				else
					(gSq4GlobalNarrator say: 5)
				)
			)
			(1
				(if local28
					(gSq4GlobalNarrator say: 6)
				else
					(super doVerb: theVerb)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance drOpening of Sq4Feature
	(properties
		x 49
		y 137
		z 33
		nsTop 85
		nsLeft 36
		nsBottom 123
		nsRight 63
		sightAngle 45
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 0)
			(1
				(if (not local28) 0 else (gSq4GlobalNarrator say: 7))
			)
			(6 (gSq4GlobalNarrator say: 8))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theJar of Sq4View
	(properties
		x 197
		y 150
		z 22
		sightAngle 45
		view 70
		loop 6
		priority 12
		signal $4010
		lookStr 9
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (== ((gInv at: 5) owner?) 70)
					(gEgo illegalBits: 0)
					(global2 setScript: jarScript)
				else
					(super doVerb: theVerb)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance hologram of Sq4Prop
	(properties
		x 160
		y 81
		view 70
		loop 1
		signal $4000
	)
)

(instance hologramHead of Sq4Prop
	(properties
		x 167
		y 45
		view 70
		loop 3
		signal $4000
	)
)

(instance theRoom of Sq4Feature
	(properties
		x 152
		z -82
		nsBottom 189
		nsRight 319
		sightAngle 180
		lookStr 10
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (gSq4GlobalNarrator say: 11))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance blotter of Sq4Feature
	(properties
		x 230
		y 155
		z 31
		nsTop 115
		nsLeft 211
		nsBottom 133
		nsRight 249
		sightAngle 45
		lookStr 12
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(proc0_2)
				(gEgo illegalBits: 0)
				(global2 setScript: buttonScript)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance grid of Sq4Feature
	(properties
		x 166
		y 83
		nsTop 76
		nsLeft 145
		nsBottom 91
		nsRight 188
		sightAngle 45
		onMeCheck $4040
		lookStr 13
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gSq4GlobalNarrator say: 14))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theDesk of Sq4Feature
	(properties
		x 212
		y 123
		z 30
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck $0080
		lookStr 15
	)
)

(instance theWires of Sq4Feature
	(properties
		x 155
		y 75
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck $0020
		lookStr 16
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gSq4GlobalNarrator say: 17))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theShadow of Sq4Feature
	(properties
		x 227
		y 10
		nsLeft 198
		nsBottom 30
		nsRight 246
		sightAngle 45
		lookStr 18
	)
)

(instance thePipes of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck $0010
		lookStr 19
	)
	
	(method (doVerb theVerb)
		(self
			x: ((User curEvent?) x?)
			y: ((User curEvent?) y?)
		)
		(switch theVerb
			(4 (gSq4GlobalNarrator say: 20))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance aSound of Sound
	(properties)
)

(instance theProfessor of Narrator
	(properties
		noun 8
		modeless 1
		talkerNum 8
	)
	
	(method (dispose)
		(localproc_0ebc)
		(super dispose: &rest)
	)
	
	(method (display &tmp temp0 theTalkWidth)
		(localproc_0ebc)
		(if (> (+ x talkWidth) 318)
			(= theTalkWidth (- 318 x))
		else
			(= theTalkWidth talkWidth)
		)
		(if (not x) (= x (+ (- nsRight nsLeft) 5)))
		(localproc_0e7f &rest 64 x y 111 77 name 67 theTalkWidth)
	)
)

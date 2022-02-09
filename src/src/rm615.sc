;;; Sierra Script 1.0 - (do not remove this comment)
(script# 615)
(include sci.sh)
(use Main)
(use ulence)
(use SQRoom)
(use Sq4Narrator)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use n958)
(use Cycle)
(use Obj)

(public
	rm615 0
)

(local
	local0
	local1
	local2
	local3
)
(instance rm615 of SQRoom
	(properties
		picture 615
	)
	
	(method (init)
		(switch gWest
			(610
				(gEgo x: -5 y: 127)
				(gLongSong stop:)
				(gLongSong2 fade: 127 10 10 0)
				(self setScript: climbDOWNstairs)
			)
			(else 
				(gEgo x: -5 y: 127)
				(gLongSong2 vol: 127 number: 804 loop: -1 playBed:)
				(self setScript: climbDOWNstairs)
			)
		)
		(gEgo init: show: illegalBits: 0 ignoreActors: 1)
		(theWindow init:)
		(stairs init:)
		(door init:)
		(bar init:)
		(stage init:)
		(barTender
			init:
			setPri: 14
			posn: (Random 104 210) 183
			setLoop: (Random 2 3)
			setScript: barTenderScript
		)
		(band init: setCycle: Fwd)
		(if (not (gEgo has: 13)) (theMatches init:))
		(self setRegions: 706)
		(daFloor init:)
		(daRoom init:)
		(writing init:)
		(super init:)
		(if (not (proc0_6 75))
			(self
				addObstacle:
					((Polygon new:)
						type: 2
						init:
							0
							118
							21
							167
							8
							174
							74
							183
							86
							168
							232
							168
							242
							182
							299
							160
							269
							147
							259
							148
							218
							128
							203
							144
							121
							144
							105
							127
							77
							149
							63
							141
							39
							155
							28
							150
							0
							104
							0
							0
							319
							0
							319
							189
							0
							189
						yourself:
					)
			)
			(mono1 init:)
			(mono2 init:)
			(mono3 init:)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: 2
						init:
							0
							118
							22
							161
							21
							169
							68
							183
							248
							183
							299
							160
							269
							147
							259
							148
							218
							128
							203
							144
							161
							144
							121
							144
							105
							127
							77
							149
							65
							144
							35
							157
							0
							104
							0
							0
							319
							0
							319
							189
							0
							189
						yourself:
					)
			)
		)
		(proc958_0 128 618 620 619)
	)
	
	(method (doit)
		(cond 
			(script 0)
			(
			(and (not (proc0_6 75)) (gEgo inRect: 87 155 210 180)) (self setScript: lookMonoGuys))
			((& (gEgo onControl: 1) $0008) (proc0_2) (= local2 1) (self setScript: exitScript))
		)
		(super doit: &rest)
		(if (> (gEgo y?) 176)
			(gEgo setPri: 13)
		else
			(gEgo setPri: -1)
		)
	)
)

(instance climbDOWNstairs of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0 (proc0_2) (= cycles 1))
			(1
				(gEgo setMotion: MoveTo 27 159 self)
			)
			(2 (= seconds 2))
			(3
				(if (not (ulence beenInBar?))
					(gSq4GlobalNarrator say: 1)
					(ulence beenInBar: 1)
				)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance lookMonoGuys of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(if local1
					(= local1 0)
					(self cue:)
				else
					(gEgo setMotion: PolyPath 117 159 self)
				)
			)
			(1 (gEgo setHeading: 135 self))
			(2
				(mono1 setCycle: End)
				(mono2 setCycle: End)
				(mono3 setCycle: End)
				(= seconds 4)
			)
			(3
				(gLongSong2 fade: 85 10 10 0)
				(global2 newRoom: 620)
			)
		)
	)
)

(instance exitScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(if local2
					(self cue:)
				else
					(gEgo setMotion: PolyPath 34 160 self)
				)
			)
			(1
				(gEgo setMotion: MoveTo -5 127 self)
			)
			(2
				(gLongSong2 fade: 70 10 10 0)
				(global2 newRoom: 610)
			)
		)
	)
)

(instance barTenderScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0 (= seconds (Random 2 5)))
			(1
				(barTender
					setCycle: Walk
					setLoop: -1
					setMotion: MoveTo (Random 104 210) 183 self
				)
			)
			(2
				(if (> (Random 0 100) 80)
					(self init:)
				else
					(= cycles (Random 2 6))
				)
			)
			(3
				(if (> (Random 0 100) 50)
					(barTender setLoop: 3)
				else
					(barTender setLoop: 2)
				)
				(self init:)
			)
		)
	)
)

(instance getMatches of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(if (proc0_6 75)
					(gEgo setMotion: PolyPath 89 181 self)
				else
					(gEgo setMotion: PolyPath 102 174 self)
				)
			)
			(1
				(if (proc0_6 75)
					(gEgo setHeading: 180 self)
				else
					(= local1 1)
					(gSq4GlobalNarrator say: 2)
					(global2 setScript: lookMonoGuys)
					(self dispose:)
				)
			)
			(2
				(proc0_11 76 5)
				(gEgo get: 13)
				(theMatches dispose:)
				(gSq4GlobalNarrator say: 3)
				(proc0_1 (gEgo loop?) 0)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance talkToBartender of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: PolyPath 152 184 self)
			)
			(1
				(gEgo setLoop: 2)
				(barTender setScript: 0)
				(cond 
					((< (barTender x?) 147)
						(barTender
							setLoop: 0
							setCycle: Fwd
							moveSpeed: 1
							cycleSpeed: 6
							setMotion: MoveTo 152 187 self
						)
					)
					((> (barTender x?) 169)
						(barTender
							setLoop: 1
							setCycle: Fwd
							moveSpeed: 1
							cycleSpeed: 6
							setMotion: MoveTo 152 187 self
						)
					)
					(else (= seconds 1))
				)
			)
			(2
				(barTender setLoop: 3 setCycle: 0 setMotion: 0)
				(= seconds 1)
			)
			(3
				(tBARTENDER tStyle: 1 say: 4 self)
			)
			(4
				(tROGER tStyle: 0 say: 5 self)
			)
			(5
				(proc0_1)
				(proc0_3)
				(barTender setScript: barTenderScript)
				(self dispose:)
			)
		)
	)
)

(instance daFloor of Sq4Feature
	(properties
		x 159
		y 112
		nsTop 36
		nsBottom 189
		nsRight 319
		onMeCheck $0010
		lookStr 6
	)
)

(instance daRoom of Sq4Feature
	(properties
		x 159
		y 112
		nsTop 36
		nsBottom 189
		nsRight 319
		onMeCheck $0020
		lookStr 7
	)
)

(instance writing of Sq4Feature
	(properties
		x 30
		y 117
		nsTop 97
		nsLeft 26
		nsBottom 138
		nsRight 34
		sightAngle 90
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1
				(if (!= (++ local3) 6)
					(gSq4GlobalNarrator say: 8)
				else
					(eggNar say: 30)
					(eggNar say: 31)
;;;					(gSq4GlobalNarrator
;;;						modeless: 0
;;;						;returnVal: 0
;;;						nMsgType: 1
;;;						say: 8 self 2 64 1 160 67 ;318 ;25 ;global135 26 gColor 27 1 30 68
;;;					)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mono1 of Sq4Prop
	(properties
		x 193
		y 180
		z 10
		view 620
		loop 1
		priority 14
		signal $4010
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(global2 setScript: lookMonoGuys)
			)
			(4
				(global2 setScript: lookMonoGuys)
			)
			(6
				(gSq4GlobalNarrator modNum: 702 say: 18)
				(global2 setScript: lookMonoGuys)
			)
			(7
				(gSq4GlobalNarrator modNum: 702 say: 18)
				(global2 setScript: lookMonoGuys)
			)
			(1 (gSq4GlobalNarrator say: 10))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mono2 of Sq4Prop
	(properties
		x 118
		y 180
		z 10
		view 620
		loop 2
		priority 14
		signal $4010
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(4
				(global2 setScript: lookMonoGuys)
			)
			(2
				(global2 setScript: lookMonoGuys)
			)
			(1 (gSq4GlobalNarrator say: 11))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mono3 of Sq4Prop
	(properties
		x 157
		y 182
		z 10
		view 620
		loop 3
		priority 14
		signal $4010
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(4
				(global2 setScript: lookMonoGuys)
			)
			(2
				(global2 setScript: lookMonoGuys)
			)
			(1 (gSq4GlobalNarrator say: 12))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stage of Sq4Feature
	(properties
		x 163
		y 118
		nsTop 99
		nsLeft 117
		nsBottom 138
		nsRight 210
		sightAngle 180
		onMeCheck $0004
		lookStr 13
	)
)

(instance bar of Sq4Feature
	(properties
		x 158
		y 176
		nsTop 164
		nsLeft 73
		nsBottom 188
		nsRight 243
		sightAngle 180
		onMeCheck $0002
		lookStr 14
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(++ local0)
				(if (not (proc0_6 15))
					(gSq4GlobalNarrator say: 19)
					(global2 setScript: lookMonoGuys)
				else
					(switch local0
						(1
							(global2 setScript: talkToBartender)
						)
						(else 
							(gSq4GlobalNarrator say: 20)
						)
					)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door of Sq4Feature
	(properties
		x 29
		y 127
		nsTop 94
		nsLeft 6
		nsBottom 160
		nsRight 53
		sightAngle 180
		onMeCheck $4000
		lookStr 29
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(4
				(global2 setScript: exitScript)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theMatches of Sq4View
	(properties
		x 90
		y 193
		z 20
		nsTop 170
		nsLeft 87
		nsBottom 176
		nsRight 94
		view 620
		priority 14
		signal $4010
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 15))
			(4
				(global2 setScript: getMatches)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance barTender of Sq4Actor
	(properties
		view 618
		signal $4000
		illegalBits $0000
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 17))
			(4 (gSq4GlobalNarrator say: 18))
			(2
				(++ local0)
				(if (not (proc0_6 15))
					(gSq4GlobalNarrator say: 19)
					(global2 setScript: lookMonoGuys)
				else
					(switch local0
						(1
							(global2 setScript: talkToBartender)
						)
						(else 
							(gSq4GlobalNarrator say: 20)
						)
					)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance band of Sq4Prop
	(properties
		x 160
		y 115
		view 619
		signal $6000
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 22))
			(4 (gSq4GlobalNarrator say: 23))
			(2 (gSq4GlobalNarrator say: 24))
			(6 (gSq4GlobalNarrator say: 25))
			(8
				(if global159
					(gSq4GlobalNarrator say: 26)
				else
					(gSq4GlobalNarrator say: 27)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theWindow of Sq4Feature
	(properties
		x 164
		y 61
		nsTop 52
		nsLeft 154
		nsBottom 70
		nsRight 175
		sightAngle 180
		lookStr 28
	)
)

(instance stairs of Sq4Feature
	(properties
		x 26
		y 128
		nsTop 91
		nsLeft 6
		nsBottom 165
		nsRight 46
		sightAngle 180
		onMeCheck $0008
		lookStr 29
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(4
				(global2 setScript: exitScript)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tROGER of Sq4Talker
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

(instance tBARTENDER of Sq4Talker
	(properties
		z 400
		noun 1
		view 1618
		talkerNum 1
		mouthOffsetX 28
		mouthOffsetY 15
		eyeOffsetX 28
		eyeOffsetY 9
	)
)

(instance eggNar of Sq4Narrator
	(properties
		noun 99
		modNum 615
		;modeless 1
		nMsgType 1
	)
	
;;;	(method (dispose)
;;;		(Display 398 0 108 local6)
;;;		(super dispose: &rest)
;;;	)
;;;	
;;;	(method (display theText)
;;;		(= local6
;;;			(Display
;;;				theText
;;;				dsWIDTH
;;;				talkWidth
;;;				dsCOORD
;;;				x
;;;				y
;;;				dsALIGN
;;;				0
;;;				dsFONT
;;;				68
;;;				dsCOLOR
;;;				global132
;;;				dsSAVEPIXELS
;;;			)
;;;		)
;;;	)
)
;;; Sierra Script 1.0 - (do not remove this comment)
(script# 150)
(include sci.sh)
(use Main)
(use Class_255_0)
(use brain)
(use SQRoom)
(use Sq4Narrator)
(use Sq4Feature)
(use Osc)
(use PolyPath)
(use MoveFwd)
(use n958)
(use StopWalk)
(use DPath)
(use Rev)
(use Sound)
(use Cycle)
(use InvI)
(use Obj)

(public
	rm150 0
	RogerJr 1
	diskDrive 2
)

(local
	local0
	local1
	local2 =  10
	local3 =  15
	local4
	[local5 8] = [161 189 186 154 120 91 87 118]
	[local13 45] = [119 107 80 67 61 79 107 126 2 2 122 99 2 3 122 99 2 2 122 99 2 3 122 99 2 2 122 99 2 3 122 99 2 2 122 99 2 3 122 99 2 2 122 99 -32768]
)
(procedure (localproc_00b2 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(laserSound play:)
	(= temp0 (param1 x?))
	(= temp1 (- (param1 y?) 10))
	(= temp2 (- (proc999_2 temp1 param3) 1))
	(= temp3 (+ (proc999_3 temp1 param3) 1))
	(= temp4 (- (proc999_2 temp0 param2) 1))
	(= temp5 (+ (proc999_3 temp0 param2) 1))
	(= temp6 (Graph grSAVE_BOX temp2 temp4 temp3 temp5 1))
	(Graph
		grDRAW_LINE
		temp1
		temp0
		param3
		param2
		global143
		-1
		-1
	)
	(Graph grREDRAW_BOX temp2 temp4 temp3 temp5 1)
	(Wait 1)
	(Wait 5)
	(Graph grRESTORE_BOX temp6)
	(Graph grREDRAW_BOX temp2 temp4 temp3 temp5 1)
	(if
		(or
			(!= param2 (gEgo x?))
			(!= param3 (- (gEgo y?) 15))
		)
		(blast x: param2 y: param3 init: setCycle: End blast)
	)
)

(instance rm150 of SQRoom
	(properties
		picture 150
		south 505
		lookStr 1
	)
	
	(method (init)
		(proc958_0 128 522)
		(proc958_0 128 150 550)
		(Load rsSCRIPT 151)
		(if (not (brain formatting?))
			(proc958_0 132 118 120 119 121)
		else
			(proc958_0 132 152)
		)
		(if (< (gEgo x?) 160)
			(gEgo x: 170 y: 250 init:)
		else
			(gEgo x: 325 y: 235 init:)
		)
		(self setRegions: 704)
		(if (global6 contains: 704) (SetDebug))
		(super init:)
		(brain
			makePolygon: 194 189 199 181 210 176 221 174 233 174 249 178 272 189
			makePolygon: 116 189 138 159 155 159 151 189
			makePolygon: 319 165 220 145 216 140 231 136 319 153
		)
		(diskDrive init: stopUpd:)
		(ladder init:)
		(overhang init:)
		(pedestal init:)
		(lOrb init:)
		(rOrb init:)
		(if (brain formatting?)
			(lOrb addToPic:)
			(rOrb addToPic:)
		)
		(gLongSong fade:)
		(self setScript: rescueScript)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script)
			((proc0_5 gEgo 4) (self setScript: fallScript))
			((proc0_5 gEgo 2) (self setScript: climbScript))
		)
	)
	
	(method (dispose)
		(DisposeScript 151)
		(DisposeScript 152)
		(super dispose:)
	)
	
	(method (notify param1)
		(switch param1
			(-1 (= local4 1))
			(else  (= local1 param1))
		)
	)
)

(instance rescueScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (global5 contains: (ScriptID 704 1))
					(((ScriptID 704 1) body?) dispose:)
					((ScriptID 704 1) dispose:)
				)
				(if (global5 contains: (ScriptID 704 2))
					(((ScriptID 704 2) body?) dispose:)
					((ScriptID 704 2) dispose:)
				)
				(gLongSong2 number: 848 vol: 127 loop: 1 play:)
				(RogerJr init: setCycle: Fwd)
				(gEgo setPri: -1 setLoop: -1)
				(if (== (gEgo x?) 170)
					(gEgo setMotion: PolyPath 170 170 self)
				else
					(gEgo setMotion: PolyPath 260 170 self)
				)
			)
			(1
				(if (not (brain formatting?))
					(lOrb setScript: laserScript)
					(self dispose:)
				else
					(proc0_11 79 5)
					(gLongSong2 stop:)
					(RogerJr
						posn: 133 94
						setLoop: 1
						setCel: 0
						cycleSpeed: 12
						setCycle: End
					)
					(bridge init: setMotion: MoveTo 180 153 self)
					(bridgeSound play:)
				)
			)
			(2
				(bridgeSound stop:)
				(brain
					makePolygon: 123 159 123 127 166 127 180 150 155 159
					makePolygon: 218 145 195 148 175 124 202 109 228 135 216 140
				)
				(gEgo setMotion: PolyPath 156 118 self)
			)
			(3
				(bridge setMotion: MoveTo 193 176 self)
				(bridgeSound play:)
			)
			(4
				(bridge dispose:)
				(bridgeSound stop:)
				(RogerJr setLoop: 2 setCel: 0 setCycle: End self)
				(diskDrive setMotion: MoveTo 120 98 diskDrive)
			)
			(5)
			(6
				(RogerJr
					view: 550
					setLoop: 0
					setCel: 0
					setPri: 9
					posn: 125 94
					setCycle: CT 4 1 self
				)
			)
			(7 (= seconds 2))
			(8
				(tVOHAULJR modNum: 558 say: 1 self)
			)
			(9
				(tVOHAULJR modNum: 558 say: 2 self)
			)
			(10
				(RogerJr setCycle: End self)
			)
			(11
				(disk
					init:
					setCycle: Fwd
					setMotion: DPath 88 61 53 65 20 98 -5 133 self
				)
				(RogHead
					posn: (+ (RogerJr x?) 8) (- (RogerJr y?) 31)
					init:
					setCycle: Fwd
				)
			)
			(12
				(disk dispose:)
				(RogerJr
					view: 525
					setLoop: 0
					setPri: -1
					cycleSpeed: 6
					setCycle: Rev
					setMotion: MoveTo [local5 4] [local13 (RogHead dispose:)] self
				)
				(diskDrive setMotion: MoveTo 120 110 diskDrive)
			)
			(13)
			(14
				(tVOHAULJR modNum: 558 say: 3 self)
			)
			(15
				(tVOHAULJR modNum: 558 say: 4 self)
			)
			(16
				(RogerJr view: 527 setCycle: Walk)
				(gEgo view: 526 setCycle: Walk)
				(self setScript: (ScriptID 151 0) self)
			)
			(17
				(self setScript: (ScriptID 151 1) self)
			)
			(18 (self dispose:))
		)
	)
)

(instance laserSound of Sound
	(properties
		number 106
	)
)

(instance laserScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_3) (= seconds 5))
			(1
				(localproc_00b2 lOrb (- (gEgo x?) 25) 159)
				(= cycles 20)
			)
			(2
				(localproc_00b2 rOrb (+ (gEgo x?) 25) 143)
				(= cycles 20)
			)
			(3
				(localproc_00b2 lOrb (- (gEgo x?) 15) 161)
				(= cycles 20)
			)
			(4
				(localproc_00b2 rOrb (+ (gEgo x?) 15) 150)
				(= cycles 20)
			)
			(5
				(localproc_00b2 lOrb (- (gEgo x?) 5) 160)
				(= cycles 20)
			)
			(6
				(localproc_00b2 rOrb (+ (gEgo x?) 5) 158)
				(= cycles 20)
			)
			(7
				(localproc_00b2 lOrb (gEgo x?) (- (gEgo y?) 15))
				(= cycles 1)
			)
			(8
				(gEgo view: 511 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(9 (proc0_10 8 30))
		)
	)
)

(instance climbScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(if
					(proc999_5
						((Inv at: 14) owner?)
						gEgo
						global11
						diskDrive
					)
					(gSq4GlobalNarrator say: 2)
					(= register 1)
					(gEgo setMotion: MoveTo 100 115 self)
				else
					(gEgo setMotion: MoveTo 84 115 self)
				)
			)
			(1
				(if register
					(proc0_3)
					(self dispose:)
				else
					(gEgo setHeading: 270 self)
				)
			)
			(2
				(gEgo
					view: 551
					setLoop: 2
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(gEgo
					posn: 77 144
					setLoop: 0
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 98 245 self
				)
			)
			(4
				(gEgo get: 14)
				(= seconds 5)
			)
			(5
				(gEgo setCycle: Rev setMotion: MoveTo 77 144 self)
			)
			(6
				(gEgo
					posn: 84 115
					setLoop: 2
					setCel: 2
					setCycle: Beg self
				)
			)
			(7
				(gEgo
					view: 3
					setLoop: -1
					cycleSpeed: 6
					setCycle: StopWalk 510
					setMotion: MoveTo 100 115 self
				)
			)
			(8
				(proc0_3)
				(proc0_11 64 5)
				(self dispose:)
			)
		)
	)
)

(instance fallScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: MoveFwd 12 self)
			)
			(1
				(gEgo setHeading: 180 looper: 0)
				(= cycles 8)
			)
			(2
				(gSq4GlobalNarrator say: 3 self)
				(cond 
					((< (gEgo y?) 95) (= temp0 1))
					((< (gEgo x?) 95) (= temp0 12))
					(else (= temp0 3))
				)
				(gEgo
					setStep: (gEgo xStep?) 19
					setPri: temp0
					setMotion: MoveTo (gEgo x?) 300 self
				)
			)
			(3 0)
			(4 (proc0_10))
		)
	)
)

(instance jrFreeScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(brain formatting: 0)
				(RogerJr
					posn: 133 91
					setLoop: 1
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(proc0_13 gEgo RogerJr self)
				(= seconds 3)
			)
			(2 0)
			(3
				(RogerJr setLoop: 2 setCel: 0 setCycle: End self)
				(gLongSong stop:)
			)
			(4
				(if local4
					(proc0_10 0 11)
				else
					(gLongSong number: 870 vol: 127 loop: -1 flags: 1 play:)
					(= seconds 3)
				)
			)
			(5
				(tROGERJR modNum: 557 say: 1 self)
			)
			(6
				(gLongSong fade: 115 25 1 0)
				(= seconds 2)
			)
			(7 (global2 newRoom: 556))
		)
	)
)

(instance driveScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 111 99 self)
			)
			(1
				((ScriptID 152 0) init:)
				(self dispose:)
			)
		)
	)
)

(instance RogerJr of Sq4Actor
	(properties
		x 127
		y 39
		view 522
		priority 4
		signal $4010
		lookStr 4
	)
	
	(method (init)
		(super init: &rest)
	)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(if (and local1 (proc255_2 self pEvent))
			((ScriptID 151 0)
				handleEvent: (pEvent type: 64 message: 1)
			)
		else
			(super handleEvent: pEvent)
		)
	)
)

(instance RogHead of Sq4Prop
	(properties
		view 550
		loop 1
		priority 14
		signal $4010
	)
)

(instance driveSound of Sound
	(properties)
)

(instance diskDrive of Sq4Actor
	(properties
		x 120
		y 110
		view 522
		loop 3
		priority 5
		signal $4810
		illegalBits $0000
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(22
				(if (global5 contains: (ScriptID 152 0))
					((ScriptID 152 0) doVerb: theVerb param2 &rest)
				else
					((gInv at: 14) owner: self)
					(gEgo put: 14 global11)
					(proc0_11 65 5)
					(self setScript: driveScript)
				)
			)
			(1 (gSq4GlobalNarrator say: 6))
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
					23
				)
				0
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (cue)
		(driveSound number: 877 play:)
		(if (== y 98)
			(self setCycle: Fwd)
		else
			(self stopUpd:)
		)
		(cond 
			((not (global2 script?)) (global2 setScript: jrFreeScript))
			((rescueScript script?) ((rescueScript script?) cue:))
			(else (rescueScript cue:))
		)
	)
	
	(method (setMotion)
		(driveSound number: 876 play:)
		(super setMotion: &rest)
	)
)

(instance ladder of Sq4Feature
	(properties
		x 83
		y 149
		nsTop 109
		nsLeft 66
		nsBottom 189
		nsRight 100
		sightAngle 90
		lookStr 7
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(gEgo setMotion: PolyPath 90 115)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance disk of Sq4Actor
	(properties
		x 88
		y 61
		yStep 7
		view 550
		loop 2
		priority 14
		signal $0810
		xStep 7
	)
	
	(method (cue)
		(self dispose:)
	)
)

(instance bridgeSound of Sound
	(properties
		number 152
	)
)

(instance bridge of Sq4Actor
	(properties
		x 193
		y 176
		view 522
		loop 4
		priority 2
		signal $4810
		illegalBits $0000
	)
)

(instance blast of Sq4Prop
	(properties
		view 28
		signal $6000
	)
	
	(method (cue)
		(super cue:)
		(self dispose:)
	)
)

(instance lOrbZap of Sound
	(properties)
)

(instance rOrbZap of Sound
	(properties)
)

(instance lOrb of Sq4Prop
	(properties
		x 47
		y 123
		sightAngle 90
		view 151
		priority 8
	)
	
	(method (doit)
		(super doit:)
		(if (and local2 (not (-- local2)))
			(= loop (if (< (Random 1 10) 5) 0 else 2))
			(if (< (Random 1 10) 5)
				(lOrbZap number: (if loop 120 else 118) play:)
				(self setCycle: Osc 1 self)
			else
				(lOrbZap number: (if loop 120 else 118) play:)
				(self setCycle: End self)
			)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if cycler
					(gSq4GlobalNarrator say: 8)
				else
					(gSq4GlobalNarrator say: 9)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue)
		(= local2 (Random 20 50))
		(lOrbZap stop:)
		(self stopUpd:)
	)
)

(instance rOrb of Sq4Prop
	(properties
		x 230
		y 87
		sightAngle 90
		view 151
		loop 1
		priority 8
	)
	
	(method (doit)
		(super doit:)
		(if (and local3 (not (-- local3)))
			(= loop (if (< (Random 1 10) 5) 1 else 3))
			(if (< (Random 1 10) 5)
				(rOrbZap number: (if (== loop 3) 121 else 119) play:)
				(self setCycle: Osc 1 self)
			else
				(rOrbZap number: (if (== loop 3) 121 else 119) play:)
				(self setCycle: End self)
			)
		)
	)
	
	(method (doVerb theVerb)
		(lOrb doVerb: theVerb &rest)
	)
	
	(method (cue)
		(= local3 (Random 20 50))
		(rOrbZap stop:)
		(self stopUpd:)
	)
)

(instance overhang of Sq4Feature
	(properties
		lookStr 10
	)
	
	(method (onMe param1)
		(return (== (OnControl 2 (param1 x?) (param1 y?)) 16384))
	)
)

(instance pedestal of Sq4Feature
	(properties
		lookStr 11
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(7 (gSq4GlobalNarrator say: 12))
			(6 (gSq4GlobalNarrator say: 13))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (onMe param1)
		(return (== (OnControl 2 (param1 x?) (param1 y?)) 4))
	)
)

(instance tVOHAULJR of Sq4Talker
	(properties
		z 400
		noun 32
		view 1523
		talkerNum 32
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 25
		eyeOffsetY 20
	)
)

(instance tROGER of Sq4Talker
	(properties
		z 400
		noun 7
		modNum 150
		view 1008
		talkerNum 7
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 27
		eyeOffsetY 21
	)
)

(instance tROGERJR of Sq4Talker
	(properties
		z 400
		noun 31
		view 1524
		talkerNum 31
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 25
		eyeOffsetY 20
	)
)

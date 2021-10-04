;;; Sierra Script 1.0 - (do not remove this comment)
(script# 380)
(include sci.sh)
(use Main)
(use mall)
(use BeltWay)
(use SQRoom)
(use Sq4Feature)
(use Polygon)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm380 0
)

(local
	local0
	[local1 24] = [0 0 0 0 138 40 1 151 43 2 155 51 3 157 57 4 158 59 5 159 63 -1 -1 -1]
	local25 =  151
	local26 =  1
)
(instance rm380 of SQRoom
	(properties
		picture 380
		style $000a
		east 385
		west 375
	)
	
	(method (init &tmp temp0 temp1)
		(Load rsVIEW 380)
		(Load rsSOUND 145)
		(proc0_2)
		(switch global12
			(west
				(if (== ((ScriptID 700 0) whichBelt?) 1)
					(= temp0 -40)
					(= temp1 135)
				else
					(= temp0 -12)
					(= temp1 105)
				)
				(gEgo x: temp0 y: temp1 setLoop: gStopGroop)
				(if (or (proc0_6 6) (proc0_6 10))
					(self setScript: (ScriptID 700 1) 0 egoBwGreen)
				else
					(tallGuy
						x: -1000
						y: -1000
						setSpeed: global199
						init:
						setScript: tallGuyScript 0 egoBwGreen
					)
				)
			)
			(east
				(if (== ((ScriptID 700 0) whichBelt?) 1)
					(= temp0 340)
					(= temp1 123)
				else
					(= temp0 339)
					(= temp1 84)
				)
				(gEgo x: temp0 y: temp1 setLoop: gStopGroop)
				(if (or (proc0_6 6) (proc0_6 10))
					(self setScript: (ScriptID 700 1) 0 egoBwBlue)
				else
					(tallGuy
						x: -1000
						y: -1000
						setSpeed: global199
						init:
						setScript: tallGuyScript 0 egoBwBlue
					)
				)
			)
			(else 
				(gLongSong number: 405 loop: -1 play: 95)
				(gEgo posn: -10 -10)
				(self
					setScript:
						(if (proc700_3 (ScriptID 700 0) 678 128)
							tossScript
						else
							fromStoreScript
						)
				)
			)
		)
		(tallSign cel: (if (proc0_6 6) 4 else 0) init: stopUpd:)
		(gEgo
			setPri: -1
			code: beltwayCode
			init:
			setCycle: SyncWalk
		)
		(super init:)
		(if (proc0_6 10)
			(global10 add: door eachElementDo: #init doit:)
			(self
				addObstacle:
					((Polygon new:)
						type: 2
						init: 319 78 209 83 193 64 114 69 105 88 0 92 0 0 319 0
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: 2
						init: 151 0 110 89 0 94 0 0
						yourself:
					)
					((Polygon new:)
						type: 2
						init: 319 0 319 78 203 84 178 41 175 0
						yourself:
					)
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init: 319 138 319 189 0 189 0 152
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 0 111 133 103 131 123 120 127 0 133
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 319 95 319 116 187 123 179 101
					yourself:
				)
		)
		(self setRegions: 700)
		(bush init:)
		(bush1 init:)
		(BigTallSign init:)
		(store init:)
		(OutsideTheShop init:)
		(cond 
			((and (!= global12 381) (not (proc0_6 10))) (gLongSong2 number: 381 loop: -1 play: 65))
			((proc0_6 10) (gLongSong2 number: 0 vol: 0 stop:))
		)
	)
	
	(method (doit &tmp temp0)
		(if (not (-- local26))
			(cond 
				(
					(<
						(= temp0 (GetDistance (gEgo x?) (gEgo y?) local25 0))
						0
					)
					(= temp0 0)
				)
				((> temp0 300) (= temp0 300))
			)
			(gLongSong2 setVol: (- 127 (/ temp0 3)))
			(= local26 60)
		)
		(cond 
			(script 0)
			((== (gEgo edgeHit?) 2)
				(proc0_2)
				((ScriptID 700 0) enterBelt: egoBwGreen)
				(self setScript: (ScriptID 700 2) 0 east)
			)
			((== (gEgo edgeHit?) 4)
				(proc0_2)
				((ScriptID 700 0) enterBelt: egoBwBlue)
				(gLongSong2 stop:)
				(self setScript: (ScriptID 700 2) 0 west)
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
			(0 (= cycles 1))
			(1
				(gEgo
					x: 151
					y: 56
					illegalBits: 0
					heading: 180
					setMotion: MoveTo 151 80 self
				)
			)
			(2
				(proc700_5 1)
				(proc0_3)
				(gEgo illegalBits: -32768)
				(self dispose:)
			)
		)
	)
)

(instance tossScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= local0 0) (= seconds 5))
			(1
				(if (!= [local1 (= local0 (+ local0 3))] -1)
					(gEgo
						view: 392
						illegalBits: 0
						setLoop: 1
						cel: [local1 local0]
						posn: [local1 (+ (-- state) 1)] [local1 (+ local0 2)]
					)
					(= cycles 1)
				else
					(self cue:)
				)
			)
			(2
				(proc0_3)
				(proc0_1 2 402 14)
				(proc700_5 1)
				((ScriptID 700 0)
					rFlag1: (& ((ScriptID 700 0) rFlag1?) $ff7f)
				)
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
			((proc0_5 gEgo 16) (gEgo setPri: 1))
			((proc0_5 gEgo 4)
				(egoBwGreen who: gEgo doit:)
				((ScriptID 700 0) whichBelt: 1)
				(gEgo setPri: -1)
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
			((proc0_5 gEgo 8) (global2 newRoom: 381))
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
						(< ((ScriptID 700 9) x?) 240)
					)
					(self init:)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance tallGuyScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(< 130 ((ScriptID 700 9) x?))
						(< ((ScriptID 700 9) x?) 240)
					)
					(self setScript: sDS self)
				else
					(= cycles 1)
				)
			)
			(1
				(tallGuy
					setCycle: Walk
					setPri: 1
					setSpeed: global199
					setStep: 3 2
					posn: 148 -58
					setMotion: MoveTo 148 -6 self
				)
			)
			(2
				(soundFX number: 145 loop: 1 play:)
				(tallSign setCycle: CT 2 1 self)
			)
			(3
				(tallSign setCycle: End)
				(tallGuy setMotion: MoveTo 148 14 self)
			)
			(4
				(proc0_7 6)
				(global2 setScript: (ScriptID 700 1) 0 register)
				(tallGuy
					setLoop: 1
					setPri: 6
					setMotion: MoveTo (- (tallGuy x?) 40) 20 self
				)
			)
			(5
				(tallGuy
					setSpeed: global199
					setMotion: MoveTo -18 20 self
				)
			)
			(6
				(proc700_5 1)
				(proc0_3)
				(self dispose:)
			)
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
		head 86
		xDir 1
		yDir -1
	)
)

(instance egoBwBlue of BeltWay
	(properties
		xStep 2
		xOff 8
		yOff 1
		xTweak 2
		key 90
		head 265
		xDir -1
		yDir 1
	)
)

(instance door of Sq4View
	(properties
		x 110
		y 27
		view 380
		loop 3
		priority 1
		signal $4010
		lookStr 13
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tallGuy of Sq4Actor
	(properties
		x 148
		y -58
		view 380
		priority 3
		signal $6810
		illegalBits $0000
		lookStr 4
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (gSq4GlobalNarrator say: 5))
			(7 (gSq4GlobalNarrator say: 6))
			(2 (gSq4GlobalNarrator say: 7))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tallSign of Sq4Prop
	(properties
		x 149
		y 27
		view 380
		loop 2
		priority 5
		signal $0010
		cycleSpeed 12
	)
)

(instance bush of Sq4Feature
	(properties
		x 51
		y 121
		z 32
		nsTop 81
		nsLeft 40
		nsBottom 106
		nsRight 63
		sightAngle 90
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 370 say: 12)
			)
			(4 (gSq4GlobalNarrator say: 1))
			(6 (gSq4GlobalNarrator say: 8))
			(7 (gSq4GlobalNarrator say: 7))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bush1 of Sq4Feature
	(properties
		x 264
		y 109
		z 31
		nsTop 71
		nsLeft 251
		nsBottom 95
		nsRight 275
		sightAngle 90
		lookStr 13
	)
	
	(method (doVerb theVerb)
		(bush doVerb: theVerb)
	)
)

(instance BigTallSign of Sq4Feature
	(properties
		x 152
		y 87
		z 73
		nsTop 1
		nsLeft 60
		nsBottom 27
		nsRight 245
		sightAngle 90
		lookStr 8
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gSq4GlobalNarrator say: 9))
			(6 (gSq4GlobalNarrator say: 2))
			(7 (gSq4GlobalNarrator say: 3))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance OutsideTheShop of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		sightAngle 500
		lookStr 10
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (gSq4GlobalNarrator say: 11))
			(7 (gSq4GlobalNarrator say: 12))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance soundFX of Sound
	(properties)
)

(instance store of Sq4Feature
	(properties
		x 145
		lookStr 13
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6 (gSq4GlobalNarrator say: 2))
			(7 (gSq4GlobalNarrator say: 3))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (onMe param1)
		(return
			(<=
				5
				(/
					(* 100 (- 90 (param1 y?)))
					(proc999_3 1 (param1 x?))
				)
			)
		)
	)
)

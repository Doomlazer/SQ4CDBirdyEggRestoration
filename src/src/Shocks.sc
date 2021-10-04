;;; Sierra Script 1.0 - (do not remove this comment)
(script# 900)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Dialog)
(use Sq4Narrator)
(use Sq4Feature)
(use ForwardCounter)
(use DPath)
(use Cycle)
(use Obj)

(public
	rm900 0
)

(local
	[local0 4]
)
(procedure (localproc_0c67 param1)
	(TextSize @local0 param1 0 122)
	(return (/ (- 180 (- [local0 2] [local0 0])) 2))
)

(procedure (localproc_0c87 param1 &tmp temp0 [temp1 100])
	(= temp0 (localproc_0c67 param1))
	(Display param1 100 168 temp0 106 122 105 0 101 0)
)

(instance rm900 of SQRoom
	(properties
		picture 900
		style $000a
	)
	
	(method (init &tmp temp0 [temp1 1000])
		(proc0_2)
		(global1 setCursor: gWaitC 1)
		(gLongSong2 stop:)
		(gLongSong prevSignal: 0)
		(super init:)
		(= temp0
			(switch global187
				(0 1)
				(1 2)
				(2 3)
				(3 4)
				(4 5)
				(5 6)
				(6 21)
				(7 7)
				(8 8)
				(9 9)
				(10 10)
				(11 11)
				(12 12)
				(13 13)
				(14 14)
				(15 15)
				(16 16)
				(17 17)
				(18 18)
				(19 19)
				(20 10)
				(21 21)
				(22 22)
				(23 23)
				(24 24)
				(25 25)
				(26 26)
				(27 27)
				(28 28)
				(29 29)
				(30 30)
			)
		)
		(Message msgGET 900 99 0 temp0 1 @temp1)
		(switch global186
			(0 (self setScript: deadScript))
			(1
				(self setScript: lightningScript)
			)
			(2
				(self setScript: spearScript)
			)
			(3
				(self setScript: slimeScript)
			)
			(4 (self setScript: slugScript))
			(5
				(self setScript: meltedScript)
			)
			(6
				(self setScript: explodeScript)
			)
			(7
				(self setScript: deadScript 0 4)
			)
			(8
				(self setScript: laserScript)
			)
			(9
				(self setScript: laserScript 0 4)
			)
			(else 
				(self setScript: deadScript)
				(= temp0 0)
			)
		)
		(localproc_0c87 @temp1)
		(gLongSong number: 826 vol: 127 loop: 1 flags: 1 playBed:)
		(if (self script?)
			((self script?) setScript: voiceODeathScript 0 temp0)
		)
	)
	
	(method (cue &tmp [temp0 100])
		(asm
			pushi    #cue
			pushi    0
			super    SQRoom,  4
			pushi    0
			callb    proc0_3,  0
			pushi    #setCursor
			pushi    2
			pushi    999
			pushi    1
			lag      global1
			send     8
code_0387:
			pushi    15
			lofsa    {LOOKUP\_ERROR}
			push    
			pushi    64
			pushi    83
			pushi    144
			pushi    27
			pushi    1
			pushi    78
			lofsa    {Restore}
			push    
			pushi    0
			pushi    78
			lofsa    {Restart}
			push    
			pushi    1
			pushi    78
			lofsa    {Quit}
			push    
			pushi    2
			calle    proc816_1,  30
			push    
			dup     
			ldi      0
			eq?     
			bnt      code_03c2
			pushi    #restore
			pushi    0
			lag      global1
			send     4
			jmp      code_03dd
code_03c2:
			dup     
			ldi      1
			eq?     
			bnt      code_03d1
			pushi    #restart
			pushi    0
			lag      global1
			send     4
			jmp      code_03dd
code_03d1:
			dup     
			ldi      2
			eq?     
			bnt      code_03dd
			ldi      1
			sag      global4
			jmp      code_03e0
code_03dd:
			toss    
			jmp      code_0387
code_03e0:
			ret     
		)
	)
)

(instance voiceODeathScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0 (= seconds 2))
			(1
				(voiceOdeath modeless: 1 say: register self)
			)
			(2
				(global2 cue:)
				(self dispose:)
			)
		)
	)
)

(instance deadScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(egoView
					loop: (+ (egoView loop?) register)
					x: (+ (egoView x?) -2)
					y: (+ (egoView y?) 10)
					init:
				)
				(egosHead
					loop: (+ (egosHead loop?) register)
					x: (+ (egosHead x?) -2)
					y: (+ (egosHead y?) 10)
					init:
				)
				(leftHand
					x: (+ (leftHand x?) -2)
					y: (+ (leftHand y?) 10)
					init:
				)
				(rightHand
					x: (+ (rightHand x?) -2)
					y: (+ (rightHand y?) 10)
					init:
				)
				(= cycles 1)
			)
			(1
				(egosHead setCycle: CT 1 1 self)
				(leftHand setCycle: End)
				(rightHand setCycle: End)
			)
			(2
				(egosHead setCycle: Beg self)
			)
			(3
				(egosHead setCycle: End self)
				(rightHand setCycle: Beg)
			)
			(4
				(rightHand setCycle: End self)
			)
			(5 0)
			(6 (self dispose:))
		)
	)
)

(instance lightningScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoView
					x: (+ (egoView x?) -2)
					y: (+ (egoView y?) 10)
					init:
				)
				(egosHead
					x: (+ (egosHead x?) -2)
					y: (+ (egosHead y?) 10)
					init:
				)
				(leftHand
					x: (+ (leftHand x?) -2)
					y: (+ (leftHand y?) 10)
					init:
				)
				(rightHand
					x: (+ (rightHand x?) -2)
					y: (+ (rightHand y?) 10)
					init:
				)
				((lightningProp new:) init: x: 67 y: 100)
				((lightningProp new:) init: x: 152 y: 99 loop: 1)
				((lightningProp new:) x: 126 y: 90 loop: 1 cel: 2 init:)
				((lightningProp new:) x: 93 y: 86 cel: 2 init:)
				((lightningProp new:) x: 55 y: 87 loop: 1 cel: 4 init:)
				(= seconds 3)
			)
			(1
				(egosHead setCycle: CT 1 1 self)
				(leftHand setCycle: End)
				(rightHand setCycle: End)
			)
			(2
				(egosHead setCycle: Beg self)
			)
			(3
				(egosHead setCycle: End self)
				(rightHand setCycle: Beg)
			)
			(4
				(rightHand setCycle: End self)
			)
		)
	)
)

(instance spearScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoView
					x: (+ (egoView x?) -2)
					y: (+ (egoView y?) 10)
					init:
				)
				(egosHead
					x: (+ (egosHead x?) -2)
					y: (+ (egosHead y?) 10)
					init:
				)
				(leftHand
					x: (+ (leftHand x?) -2)
					y: (+ (leftHand y?) 10)
					init:
				)
				(rightHand
					x: (+ (rightHand x?) -2)
					y: (+ (rightHand y?) 10)
					init:
				)
				(deathProp view: 985 x: 90 y: 85 priority: 12 init:)
				(= cycles 1)
			)
			(1
				(egosHead setCycle: CT 1 1 self)
				(leftHand setCycle: End)
				(rightHand setCycle: End)
			)
			(2
				(egosHead setCycle: Beg self)
			)
			(3
				(egosHead setCycle: End self)
				(rightHand setCycle: Beg)
			)
			(4
				(rightHand cycleSpeed: 6 setCycle: End self)
			)
			(5
				(leftHand cycleSpeed: 6 setCycle: Beg self)
			)
			(6 0)
			(7 (self dispose:))
		)
	)
)

(instance slimeScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(deathProp view: 986 cel: 0 x: 96 y: 127 init:)
				(= cycles 1)
			)
			(1 0)
			(2 (self dispose:))
		)
	)
)

(instance slugScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(deathProp view: 986 cel: 1 x: 96 y: 127 init:)
				(= cycles 1)
			)
			(1 0)
			(2 (self dispose:))
		)
	)
)

(instance meltedScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoView view: 987 x: 106 y: 116 init:)
				(deathProp
					view: 987
					loop: 1
					x: 92
					y: 99
					setCycle: Fwd
					init:
				)
				(= cycles 1)
			)
			(1
				(gLongSong2 number: 90 loop: -1 vol: 105 play:)
				(= cycles 39)
			)
			(2
				(deathProp setCycle: End self)
			)
			(3 0)
			(4 (self dispose:))
		)
	)
)

(instance explodeScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(egosHead x: 83 y: 102 cel: 2 setCycle: End init:)
				(leftHand
					x: 49
					y: 60
					setCycle: Walk
					setMotion: DPath 53 72 39 93 76 80 86 90 self
					init:
				)
				(rightHand
					x: 98
					y: 80
					setCycle: Walk
					setMotion: DPath 118 65 141 78 131 94 157 124 self
					init:
				)
			)
			(1 0)
			(2 (self dispose:))
		)
	)
)

(instance laserScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoView
					loop: (+ (egoView loop?) register)
					x: (+ (egoView x?) -2)
					y: (+ (egoView y?) 10)
					init:
				)
				(egosHead
					loop: (+ (egosHead loop?) register)
					x: (+ (egosHead x?) -2)
					y: (+ (egosHead y?) 10)
					init:
				)
				(leftHand
					x: (+ (leftHand x?) -2)
					y: (+ (leftHand y?) 10)
					init:
				)
				(rightHand
					x: (+ (rightHand x?) -2)
					y: (+ (rightHand y?) 10)
					init:
				)
				(deathProp
					view: 985
					x: 100
					y: 83
					setCel: (+ 1 (if register 1 else 0))
					setPri: 7
					init:
				)
				(smoke
					x: (+ (smoke x?) -2)
					y: (+ (smoke y?) 10)
					setCycle: Fwd
					init:
				)
				(= cycles 1)
			)
			(1
				(egosHead setCycle: CT 1 1 self)
				(leftHand setCycle: End)
				(rightHand setCycle: End)
			)
			(2
				(egosHead setCycle: Beg self)
			)
			(3
				(egosHead setCycle: End self)
				(rightHand setCycle: Beg)
			)
			(4
				(rightHand cycleSpeed: 6 setCycle: End self)
			)
			(5
				(leftHand cycleSpeed: 6 setCycle: Beg self)
			)
			(6 (= cycles 10))
			(7 0)
			(8 (self dispose:))
		)
	)
)

(instance egoView of Sq4View
	(properties
		x 97
		y 115
		view 805
		priority 6
		signal $4010
	)
)

(instance egosHead of Sq4Prop
	(properties
		x 104
		y 80
		view 805
		loop 1
		priority 8
		signal $4010
		cycleSpeed 12
	)
)

(instance rightHand of Sq4Actor
	(properties
		x 84
		y 111
		yStep 1
		view 805
		loop 2
		priority 10
		signal $4810
		cycleSpeed 12
		illegalBits $0000
		xStep 1
	)
)

(instance leftHand of Sq4Actor
	(properties
		x 146
		y 104
		yStep 1
		view 805
		loop 3
		priority 10
		signal $4810
		cycleSpeed 12
		xStep 1
	)
)

(instance deathProp of Sq4Prop
	(properties
		priority 12
		signal $4010
	)
)

(class Shocks of Sq4Prop
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 0
		modNum -1
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		sightAngle 26505
		actions 0
		onMeCheck $6789
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 0
		yStep 2
		view 984
		loop 0
		cel 0
		priority 14
		underBits 0
		signal $4010
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		scaleSignal $0000
		scaleX 128
		scaleY 128
		maxScale 128
		cycleSpeed 6
		script 0
		cycler 0
		timer 0
		detailLevel 0
		scaler 0
		lookStr 0
	)
	
	(method (init)
		(super init:)
		(self setCycle: ForwardCounter 10 self)
	)
	
	(method (cue)
		(self hide: dispose:)
		(gLongSong2 stop:)
		(super cue:)
		(global2 cue:)
	)
)

(instance lightningProp of Shocks
	(properties)
)

(instance smoke of Sq4Prop
	(properties
		x 102
		y 73
		view 985
		loop 1
		priority 14
		signal $4010
	)
)

(instance voiceOdeath of Sq4Narrator
	(properties
		noun 99
		modeless 1
		nMsgType 2
	)
	
	(method (display)
	)
)

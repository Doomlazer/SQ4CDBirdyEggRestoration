;;; Sierra Script 1.0 - (do not remove this comment)
(script# 0)
(include sci.sh)
(use brain)
(use n802)
(use RegionPath)
(use SQEgo)
(use Sq4Dialog)
(use Sq4Narrator)
(use Print)
(use Sync)
(use PseudoMouse)
(use BorderWindow)
(use IconI)
(use RandCycle)
(use CueObj)
(use StopWalk)
(use DCIcon)
(use Timer)
(use Grooper)
(use Sound)
(use Game)
(use InvI)
(use Obj)

(public
	sq4 0
	proc0_1 1
	proc0_2 2
	proc0_3 3
	proc0_4 4
	proc0_5 5
	proc0_6 6
	proc0_7 7
	proc0_8 8
	proc0_9 9
	proc0_10 10
	proc0_11 11
	proc0_12 12
	proc0_13 13
	proc0_14 14
	proc0_15 15
	proc0_16 16
	proc0_17 17
	proc0_18 18
	waitC 19
)

(local
	gEgo
	global1
	global2
	global3
	global4
	global5
	global6
	global7
	global8
	gInv
	global10
	global11
	global12
	global13
	global14
	global15
	global16
	global17
	global18
	gCursorNumber
	gWalkCursor =  999
	gWaitC =  997
	global22 =  1
	global23 =  4
	global24
	global25
	global26 =  1
	global27
	global28
	global29
	global30
	global31
	global32
	global33
	global34
	global35
	global36 =  -1
	global37
	gSq4Win
	global39
	global40
	global41
	global42
	global43
	global44
	global45
	global46
	global47
	global48
	global49
	global50
	global51
	global52
	global53
	global54
	global55
	global56
	global57
	global58
	global59
	global60
	global61
	global62
	global63
	gSq4FtrInit
	gSq4DoVerbCode
	global66
	global67 =  1
	global68
	gIconBar
	global70
	global71
	gSq4KeyDownHandler
	gSq4MouseDownHandler
	gSq4DirectionHandler
	global75
	global76
	gPseudoMouse
	global78
	global79 =  60
	global80
	global81
	global82
	global83
	global84
	global85
	global86
	global87
	global88
	gSq4GlobalNarrator
	global90 =  1
	global91
	global92
	global93
	global94 =  2
	global95
	global96
	global97
	global98
	global99
	gLongSong
	global101 =  1234
	global102
	global103 =  1
	global104
	global105
	global106
	global107
	global108
	global109
	global110
	global111
	gEgoHead
	gStopGroop
	global114
	global115
	global116
	global117
	global118
	global119
	global120
	global121
	global122
	global123
	global124
	global125
	global126
	global127
	global128
	global129
	global130
	global131
	global132
	global133
	global134
	global135
	global136
	global137
	global138
	global139
	global140
	global141
	global142
	global143
	global144
	global145
	global146
	global147
	global148
	global149
	global150
	global151
	global152
	global153
	gLongSong2
	global155
	global156
	global157
	global158
	global159 =  59
	global160
	global161
	global162
	global163
	global164
	global165
	global166
	global167
	global168
	global169 =  2001
	global170
	global171
	global172
	global173 =  10
	global174
	global175
	global176
	global177
	global178
	global179
	global180
	global181
	global182
	global183
	global184
	global185
	global186
	global187
	global188
	global189
	global190
	global191
	global192
	global193
	global194
	gGIconBarCurIcon
	global196
	global197
	global198
	global199 =  6
	global200
	global201
)
(procedure (proc0_1 param1 param2 param3 &tmp temp0)
	(= temp0 0)
	(if (> argc 0)
		(gEgo loop: param1)
		(if (> argc 1)
			(gEgo view: param2)
			(if (> argc 2) (= temp0 param3))
		)
	)
	(if (not temp0) (= temp0 4))
	(gEgo
		normal: 1
		moveHead: 1
		setLoop: -1
		setLoop: stopGroop
		setPri: -1
		setMotion: 0
		setCycle: StopWalk temp0
		setStep: 3 2
		illegalBits: 0
		ignoreActors: 0
		setSpeed: global199
	)
)

(procedure (proc0_2)
	(if (not gGIconBarCurIcon)
		(= gGIconBarCurIcon (gIconBar curIcon?))
	)
	(= global196 (global80 canControl:))
	(= global197 (global80 canInput:))
	(global80 canControl: 0 canInput: 0)
	(gEgo setMotion: 0)
	(= global198 0)
	(gIconBar eachElementDo: #perform checkIcon)
	(gIconBar curIcon: (gIconBar at: 8))
	(gIconBar disable: 0 1 2 3 4 5 6 7)
	(if (not (HaveMouse))
		(global1 setCursor: 996)
	else
		(global1 setCursor: waitC)
	)
)

(procedure (proc0_3 &tmp temp0)
	(global80 canControl: 1 canInput: 1)
	(gIconBar enable: 0 1 2 3 4 5 6 7)
	(if (and argc temp0) (localproc_17df))
	(if (not (gIconBar curInvIcon?)) (gIconBar disable: 6))
	(if gGIconBarCurIcon
		(gIconBar curIcon: gGIconBarCurIcon)
		(global1 setCursor: (gGIconBarCurIcon cursor?))
		(if
			(and
				(== (gIconBar curIcon?) (gIconBar at: 6))
				(not (gIconBar curInvIcon?))
			)
			(gIconBar advanceCurIcon:)
		)
	)
	(= gGIconBarCurIcon 0)
	(global1 setCursor: ((gIconBar curIcon?) cursor?))
)

(procedure (proc0_4 param1)
	(return (u> (MemoryInfo 1) param1))
)

(procedure (proc0_5 param1 param2)
	(return (if (& (param1 onControl: 1) param2) (return 1) else 0))
)

(procedure (proc0_6 param1)
	(return
		(&
			[global114 (/ param1 16)]
			(>> $8000 (mod param1 16))
		)
	)
)

(procedure (proc0_7 param1 &tmp temp0)
	(= temp0 (proc0_6 param1))
	(= [global114 (/ param1 16)]
		(|
			[global114 (/ param1 16)]
			(>> $8000 (mod param1 16))
		)
	)
	(return temp0)
)

(procedure (proc0_8 param1 &tmp temp0)
	(= temp0 (proc0_6 param1))
	(= [global114 (/ param1 16)]
		(&
			[global114 (/ param1 16)]
			(~ (>> $8000 (mod param1 16)))
		)
	)
	(return temp0)
)

(procedure (proc0_9 param1 &tmp temp0)
	(= temp0 0)
	(if argc (= temp0 param1) else (= temp0 4))
	((= gEgoHead egoHead)
		init: gEgo
		view: temp0
		cycleSpeed: 150
	)
)

(procedure (proc0_10 param1 param2)
	(if (> argc 0)
		(= global186 param1)
		(if (proc999_5 (gEgo view?) 373 374 993)
			(if (== global186 0) (= global186 7))
			(if (== global186 8) (= global186 9))
		)
	else
		(= global186 0)
	)
	(if (> argc 1)
		(= global187 param2)
	else
		(= global187 0)
	)
	(global2 newRoom: 900)
)

(procedure (proc0_11 param1 param2)
	(if (not (proc0_6 param1))
		(global1 changeScore: param2)
		(proc0_7 param1)
		(pointsSound play:)
	)
)

(procedure (proc0_12 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
	(return
		(if (== argc 1)
			(Display 0 0 108 [param1 0])
		else
			(= temp4 (= temp5 -1))
			(= temp0 0)
			(= temp1 68)
			(= temp2 69)
			(= temp3 -1)
			(= temp6 global130)
			(= temp7 0)
			(= temp8 1)
			(while (< temp8 argc)
				(switch [param1 temp8]
					(27
						(= temp0 [param1 (++ temp8)])
					)
					(30
						(= temp2 (+ (= temp1 [param1 (++ temp8)]) 1))
					)
					(67
						(= temp3 [param1 (++ temp8)])
					)
					(64
						(= temp4 [param1 (++ temp8)])
						(= temp5 [param1 (++ temp8)])
					)
					(25
						(= temp6 [param1 (++ temp8)])
					)
					(26
						(= temp7 [param1 (++ temp8)])
					)
				)
				(++ temp8)
			)
			(= temp8
				(Display
					[param1 0]
					100
					temp4
					temp5
					102
					temp7
					106
					temp3
					101
					temp0
					105
					temp2
					107
				)
			)
			(Display
				[param1 0]
				100
				temp4
				temp5
				102
				temp6
				106
				temp3
				101
				temp0
				105
				temp1
			)
			(return temp8)
		)
	)
)

(procedure (proc0_13 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(if (IsObject param2)
		(= temp1 (param2 x?))
		(= temp2 (param2 y?))
		(if (== argc 3) (= temp3 param3))
	else
		(= temp1 param2)
		(= temp2 param3)
		(if (== argc 4) (= temp3 param4))
	)
	(= temp0
		(GetAngle (param1 x?) (param1 y?) temp1 temp2)
	)
	(param1
		setHeading: temp0 (if (IsObject temp3) temp3 else 0)
	)
)

(procedure (proc0_14 param1 &tmp temp0 [temp1 25] [temp26 100] [temp126 4] temp130)
	(if (!= param1 -1) (= global188 param1))
	(StrCpy @temp1 {Space Quest_})
	(switch global188
		(1
			(StrCat @temp1 { - The Sarien Encounter})
		)
		(3
			(StrCat @temp1 { - The Pirates of Pestulon})
		)
		(4
			(StrCat @temp1 { - Roger Wilco and The Time Rippers})
		)
		(10
			(StrCat @temp1 { - Latex Babes of Estros})
		)
		(12
			(StrCat @temp1 { - Vohaul's Revenge })
			(= temp0 global148)
		)
	)
	(TextSize @temp126 @temp1 0 -1)
	(StrCpy @temp26 {})
	(= temp130 (/ (- 326 (- [temp126 3] [temp126 1])) 2))
	(while (> temp130 0)
		(StrCat @temp26 {})
		(-- temp130)
	)
	(StrCat @temp26 @temp1)
	(DrawStatus @temp26 0 global158)
)

(procedure (proc0_15 param1 param2)
	(return (if (== (param1 onControl:) param2) (return 1) else 0))
)

(procedure (proc0_16 param1 &tmp temp0)
	(cond 
		((== param1 1)
			(switch (= temp0 (Random 0 1))
				(0
					(gSq4GlobalNarrator modNum: 0 say: 41)
				)
				(1
					(gSq4GlobalNarrator modNum: 65 say: 20)
				)
			)
		)
		((== param1 2)
			(switch (= temp0 (Random 0 3))
				(0
					(gSq4GlobalNarrator modNum: 395 say: 4)
				)
				(1
					(gSq4GlobalNarrator modNum: 500 say: 3)
				)
				(2
					(gSq4GlobalNarrator modNum: 531 say: 11)
				)
				(3
					(gSq4GlobalNarrator modNum: 545 say: 10)
				)
			)
		)
		((== param1 6)
			(switch (= temp0 (Random 0 3))
				(0
					(gSq4GlobalNarrator modNum: 50 say: 15)
				)
				(1
					(gSq4GlobalNarrator modNum: 55 say: 17)
				)
				(2
					(gSq4GlobalNarrator modNum: 65 say: 13)
				)
				(3
					(gSq4GlobalNarrator modNum: 371 say: 41)
				)
			)
		)
		((== param1 7)
			(switch (= temp0 (Random 0 3))
				(0
					(gSq4GlobalNarrator modNum: 40 say: 3)
				)
				(1
					(gSq4GlobalNarrator modNum: 371 say: 30)
				)
				(2
					(gSq4GlobalNarrator modNum: 371 say: 37)
				)
				(3
					(gSq4GlobalNarrator modNum: 530 say: 10)
				)
			)
		)
		((== param1 4)
			(switch (= temp0 (Random 0 2))
				(0
					(gSq4GlobalNarrator modNum: 300 say: 2)
				)
				(1
					(gSq4GlobalNarrator modNum: 371 say: 20)
				)
				(2
					(gSq4GlobalNarrator modNum: 387 say: 29)
				)
			)
		)
		((== param1 3) (gSq4GlobalNarrator modNum: 0 say: 13))
		(else
			(switch (= temp0 (Random 0 2))
				(0
					(gSq4GlobalNarrator modNum: 0 say: 40)
				)
				(1
					(gSq4GlobalNarrator modNum: 50 say: 14)
				)
				(2
					(gSq4GlobalNarrator modNum: 70 say: 2)
				)
			)
		)
	)
	(gSq4GlobalNarrator modNum: -1)
)

(procedure (proc0_17 param1 param2 param3 &tmp [temp0 500])
	(if (u< param2 1000)
		(GetFarText param2 param3 @temp0)
	else
		(StrCpy @temp0 param2)
	)
	(babbleIcon
		view: param1
		cycleSpeed: (* (+ global87 1) 4)
	)
	(if (u< param2 1000)
		(proc921_0 @temp0 &rest 79 babbleIcon 0 0)
	else
		(proc921_0 @temp0 param3 &rest 79 babbleIcon 0 0)
	)
)

(procedure (proc0_18 param1 param2)
	(if (< param1 0) (= param1 0))
	(if (> param1 255) (= param1 255))
	(if (< param2 0) (= param2 0))
	(if (> param2 15) (= param2 15))
	(return (if (proc0_6 21) param1 else param2))
)

(procedure (localproc_17df &tmp temp0)
	(global80 canControl: global196 canInput: global197)
	(= temp0 0)
	(while (< temp0 8)
		(if (& global198 (>> $8000 temp0))
			(gIconBar disable: temp0)
		)
		(++ temp0)
	)
)

(instance ego of SQEgo
	(properties
		sightAngle 180
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 0 say: 1)
			)
			(2
				(gSq4GlobalNarrator modNum: 0 say: 2)
			)
			(4
				(gSq4GlobalNarrator modNum: 0 say: 3)
			)
			(7
				(gSq4GlobalNarrator modNum: 0 say: 4)
			)
			(6
				(gSq4GlobalNarrator modNum: 0 say: 5)
			)
			(20
				(gSq4GlobalNarrator modNum: 0 say: 6)
			)
			(else  (proc0_16 theVerb))
		)
	)
)

(instance egoHead of Head
	(properties
		view 4
	)
	
	(method (doVerb theVerb param2)
		(gEgo doVerb: theVerb param2)
	)
)

(instance longSong of Sound
	(properties
		number 1
	)
)

(instance longSong2 of Sound
	(properties
		number 1
	)
)

(instance pointsSound of Sound
	(properties
		flags $0001
		number 888
		priority 15
	)
)

(instance stopGroop of Grooper
	(properties)
	
	(method (doit)
		(if
			(and
				(IsObject (gEgo cycler?))
				((gEgo cycler?) isKindOf: StopWalk)
			)
			(gEgo view: ((gEgo cycler?) vWalking?))
		)
		(super doit: &rest)
	)
)

(instance babbleIcon of DCIcon
	(properties)
	
	(method (init)
		(super init: &rest)
		(if (== global90 2)
			((= cycler (MouthSync new:))
				init: self 0 99 0 global201 1
			)
			(DoAudio 2 0 99 0 global201 1)
		else
			((= cycler RandCycle) init: self 20)
		)
	)
)

(instance sq4KeyDownHandler of EventHandler
	(properties)
)

(instance sq4MouseDownHandler of EventHandler
	(properties)
)

(instance sq4DirectionHandler of EventHandler
	(properties)
)

(class sq4 of Game
	(properties
		script 0
		printLang 1
		_detailLevel 3
		panelObj 0
		panelSelector 0
		parseLang 1
		subtitleLang 0
	)
	
	(method (init &tmp temp0)
		(= gSq4Win sq4Win)
		(Sq4GlobalNarrator noun: 99)
		(= gSq4GlobalNarrator Sq4GlobalNarrator)
		(proc802_0)
		(= gStopGroop stopGroop)
		(= global34 1)
		(ScriptID 820)
		(super init:)
		(= global90 (if (= global83 1) 2 else 1))
		(DoAudio 9 1)
		(DoAudio 7 11000)
		(StrCpy @global42 {})
		(= gSq4DoVerbCode sq4DoVerbCode)
		(= gSq4FtrInit sq4FtrInit)
		((= gSq4KeyDownHandler sq4KeyDownHandler) add:)
		((= gSq4MouseDownHandler sq4MouseDownHandler) add:)
		((= gSq4DirectionHandler sq4DirectionHandler) add:)
		(= gPseudoMouse PseudoMouse)
		(= global199 6)
		(self setCursor: gCursorNumber 1 304 172)
		((= gEgo ego)
			_head: (= gEgoHead egoHead)
			setSpeed: global199
		)
		((gEgo _head?) client: gEgo)
		(global80 alterEgo: gEgo canControl: 0 canInput: 0)
		((= gLongSong longSong) owner: self init:)
		((= gLongSong2 longSong2) owner: self init:)
		(= gWalkCursor walkCursor)
		(= global16 315)
		(= global22 4)
		(= global27 {x.yyy})
		(= global106 (DoSound sndGET_POLYPHONY))
		(if
			(and
				(>= (= global105 (Graph grGET_COLOURS)) 2)
				(<= global105 16)
			)
			(proc0_8 21)
		else
			(proc0_7 21)
		)
		(sq4Win
			color: 0
			back: global158
			topBordColor: global130
			lftBordColor: global161
			rgtBordColor: global157
			botBordColor: global156
		)
		(invWin
			color: 0
			back: global156
			topBordColor: global158
			lftBordColor: global157
			rgtBordColor: global155
			botBordColor: global129
			insideColor: global155
			topBordColor2: global129
			lftBordColor2: global129
			botBordColor2: global158
			rgtBordColor2: global161
		)
		((= gIconBar IconBar)
			add: icon0 icon1 icon2 icon3 icon6 icon7 icon4 icon5 icon8 icon9
			eachElementDo: #init
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor global158
			curIcon: icon0
			useIconItem: icon4
			helpIconItem: icon9
			disable:
		)
		(icon5 message: (if (HaveMouse) 3840 else 9))
		(= gInv Inv)
		(gInv
			init:
			add:
				buckazoid
				rope
				bomb
				rabbit
				battery
				jar
				gum
				tank
				hintbook
				pen
				atmCard
				plug
				cigar
				matches
				diskette
				laptop
				invLook
				invHand
				invSelect
				invHelp
				ok
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor global155
			eachElementDo: #init
			window: invWin
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
		)
		(buckazoid owner: gEgo)
		(= global107 (if (GameIsRestarting) 60 else 1))
		(gIconBar enable:)
		(self newRoom: 803)
	)
	
	(method (doit)
		(super doit: &rest)
		(if
			(not
				(proc999_5
					global11
					803
					1
					6
					9
					10
					15
					16
					17
					19
					20
					21
					59
					119
					120
					150
					321
					329
					330
					335
					340
					345
					350
					355
					371
					376
					398
					500
					505
					510
					514
					515
					520
					525
					531
					541
					615
				)
			)
			((ScriptID 808 0) doit:)
		)
	)
	
	(method (play)
		(= gCursorNumber (= gWaitC waitC))
		(super play: &rest)
	)
	
	(method (replay &tmp [temp0 21])
		(proc0_14 -1)
		(Palette palSET_INTENSITY 0 255 100)
		(super replay: &rest)
	)
	
	(method (newRoom newRoomNumber)
		(global1 setCursor: gWaitC)
		(gPseudoMouse stop:)
		(if global25 (global25 dispose:))
		(if (and (IsObject global84) (global84 elements?))
			(global84 eachElementDo: #dispose 1)
		)
		(if (== ((gInv at: 12) state?) 1)
			(gSq4GlobalNarrator modNum: 0 say: 9)
			((gInv at: 12) state: 0)
		)
		(gIconBar disable:)
		(super newRoom: newRoomNumber)
	)
	
	(method (startRoom param1)
		((ScriptID 801) doit: param1)
		(cond 
			(
				(proc999_5
					param1
					370
					371
					375
					376
					380
					381
					385
					386
					387
					390
					391
					395
					396
					397
					398
					399
					400
					405
					406
					410
					411
					290
				)
				RegionPath
				(ScriptID 700)
				(= global102 700)
				(if (proc999_5 param1 405 406 410 411) (ScriptID 809))
			)
			((proc999_5 param1 25 30 35 40 45 50 55 60 65)
				RegionPath
				(ScriptID 701)
				(= global102 701)
				(if (proc999_5 param1 25 30 35 40 45 50 55 60 65)
					(ScriptID 705)
				)
			)
			(
			(proc999_5 param1 75 80 85 90 95 100 105 110 115) (ScriptID 702))
			(
			(proc999_5 param1 609 610 611 612 613 614 615 620) (ScriptID 706))
			(
			(proc999_5 param1 299 300 305 306 310 315 320 298) (ScriptID 703))
			(
				(proc999_5
					param1
					150
					500
					505
					510
					514
					515
					520
					525
					541
					544
					545
				)
				RegionPath
				(ScriptID 704)
				(= global102 704)
			)
			((proc999_5 param1 1 6 9 10 15 16 17 19 20 21) (ScriptID 707))
			((proc999_5 param1 530 535 540) (ScriptID 709))
		)
		(if
			(not
				(proc999_5
					param1
					803
					1
					6
					9
					10
					15
					16
					17
					19
					20
					21
					59
					119
					120
					150
					321
					329
					330
					335
					340
					345
					350
					355
					371
					376
					398
					500
					505
					510
					514
					515
					520
					525
					531
					541
					615
				)
			)
			(ScriptID 808)
		)
		(ScriptID 982)
		(gIconBar enable:)
		(super startRoom: param1)
		(if (global5 contains: gEgo)
			(if
				(and
					(!= global12 396)
					(gEgo normal?)
					(not (proc999_5 param1 405 406 410 411))
					(not ((gEgo cycler?) isKindOf: StopWalk))
				)
				(gEgo setCycle: StopWalk 4)
			)
			(if (and (!= global12 396) (not (gEgo looper?)))
				(gEgo setLoop: stopGroop)
			)
			(proc0_9 (egoHead view?))
		)
		(if (== (gIconBar curIcon?) (gIconBar at: 6))
			(gIconBar curIcon: (gIconBar at: 0))
		)
	)
	
	(method (restart &tmp temp0 [temp1 70] [temp71 100] [temp171 70])
		(= temp0 (global1 setCursor: 999 1))
		(babbleIcon view: 946 cycleSpeed: (* (+ global87 1) 4))
		(Message msgGET 0 99 0 8 1 @temp1)
		(Message msgGET 0 97 0 4 1 @temp71)
		(Message msgGET 0 97 0 5 1 @temp171)
		(= global201 8)
		(if
			(proc816_1
				@temp1
				78
				@temp71
				1
				78
				@temp171
				0
				79
				babbleIcon
				0
				0
			)
			(super restart:)
		)
		(= global201 0)
		(global1 setCursor: temp0 1)
	)
	
	(method (save)
		(if
			(and
				(or
					(== global11 150)
					(== global11 151)
					(global6 contains: 704)
				)
				(> (brain formatting?) 0)
			)
			(= global200 1)
		)
		(super save: &rest)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		(if (pEvent claimed?) (return 1))
		(return
			(switch (pEvent type?)
				(evKEYBOARD
					(switch (pEvent message?)
						(KEY_TAB
							(if (not (& (icon5 signal?) $0004))
								(gInv showSelf: gEgo)
							)
						)
						(KEY_SHIFTTAB
							(if (not (& (icon5 signal?) $0004))
								(gInv showSelf: gEgo)
							)
						)
						(KEY_CONTROL
							(global1 quitGame:)
							(pEvent claimed: 1)
						)
						(KEY_F2
							(cond 
								((global1 masterVolume:) (global1 masterVolume: 0))
								((> global106 1) (global1 masterVolume: 15))
								(else (global1 masterVolume: 1))
							)
							(pEvent claimed: 1)
						)
						(KEY_F5
							(global1 save:)
							(pEvent claimed: 1)
						)
						(KEY_F7
							(global1 restore:)
							(pEvent claimed: 1)
						)
						(KEY_F9
							(global1 restart:)
							(pEvent claimed: 1)
						)
					)
				)
			)
		)
	)
	
	(method (setCursor cursorNumber param2 param3 param4 &tmp theGCursorNumber)
		(= theGCursorNumber gCursorNumber)
		(if argc
			(if (IsObject cursorNumber)
				((= gCursorNumber cursorNumber) init:)
			else
				(SetCursor (= gCursorNumber cursorNumber) 0 0)
			)
		)
		(if (and (> argc 1) (not param2)) (SetCursor 996 0 0))
		(if (> argc 2)
			(if (< param3 0) (= param3 0))
			(if (< param4 0) (= param4 0))
			(SetCursor param3 param4)
		)
		(return theGCursorNumber)
	)
	
	(method (quitGame &tmp temp0 [temp1 70] [temp71 100] [temp171 70])
		(= temp0 (global1 setCursor: 999 1))
		(babbleIcon view: 946 cycleSpeed: (* (+ global87 1) 4))
		(Message msgGET 0 99 0 7 1 @temp1)
		(Message msgGET 0 97 0 2 1 @temp71)
		(Message msgGET 0 97 0 5 1 @temp171)
		(= global201 7)
		(super
			quitGame: (proc816_1
				@temp1
				78
				@temp71
				1
				78
				@temp171
				0
				79
				babbleIcon
				0
				0
			)
		)
		(= global201 0)
		(global1 setCursor: temp0 1)
	)
	
	(method (pragmaFail)
		(if (global80 canInput:) (proc0_16))
	)
	
	(method (showControls &tmp temp0 temp1)
		((ScriptID 818 0) init:)
		(= temp1 (global63 at: 3))
		(temp1 theObj: newSpeedCode selector: 57)
		((ScriptID 818 0) show: dispose:)
	)
)

(instance newSpeedCode of Code
	(properties)
	
	(method (doit param1 &tmp temp0 temp1 temp2)
		(if argc
			(= global199 param1)
			(= temp0 (FirstNode (global5 elements?)))
			(while temp0
				(= temp2 (NextNode temp0))
				(if
					(or
						(not (IsObject (= temp1 (NodeValue temp0))))
						(not (temp1 respondsTo: #setSpeed))
					)
				else
					(temp1 setSpeed: param1 &rest)
				)
				(= temp0 temp2)
			)
		)
		(return global199)
	)
)

(instance lookCursor of Cursor
	(properties
		view 851
	)
)

(instance talkCursor of Cursor
	(properties
		view 853
	)
)

(instance doCursor of Cursor
	(properties
		view 852
	)
)

(instance walkCursor of Cursor
	(properties
		view 850
	)
)

(instance waitC of Cursor
	(properties
		view 972
	)
)

(instance helpCursor of Cursor
	(properties
		view 856
	)
)

(instance tasteCursor of Cursor
	(properties
		view 854
	)
)

(instance smellCursor of Cursor
	(properties
		view 855
	)
)

(instance ok of IconI
	(properties
		view 901
		loop 3
		cel 0
		cursor 999
		signal $0043
		noun 98
		helpVerb 40
	)
	
	(method (init)
		(self highlightColor: 0 lowlightColor: global158)
		(super init:)
	)
)

(instance invLook of IconI
	(properties
		view 901
		loop 2
		cel 0
		cursor 851
		message 1
		noun 98
		helpVerb 41
	)
	
	(method (init)
		(= cursor lookCursor)
		(self highlightColor: 0 lowlightColor: global158)
		(super init:)
	)
)

(instance invHand of IconI
	(properties
		view 901
		loop 0
		cel 0
		cursor 852
		message 4
		noun 98
		helpVerb 29
	)
	
	(method (init)
		(self highlightColor: 0 lowlightColor: global158)
		(super init:)
	)
)

(instance invHelp of IconI
	(properties
		view 901
		loop 1
		cel 0
		cursor 856
		message 5
		noun 98
		helpVerb 37
	)
	
	(method (init)
		(super init: &rest)
		(= cursor helpCursor)
		(self highlightColor: 0 lowlightColor: global158)
	)
)

(instance invSelect of IconI
	(properties
		view 901
		loop 4
		cel 0
		cursor 999
		noun 98
		helpVerb 30
	)
	
	(method (init)
		(self highlightColor: 0 lowlightColor: global158)
		(super init:)
	)
)

(instance buckazoid of InvI
	(properties
		view 700
		cursor 951
		message 8
		signal $0002
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gInv hide:)
				((ScriptID 819 0) init:)
			)
			(else  (proc0_16 theVerb))
		)
	)
)

(instance jar of InvI
	(properties
		view 700
		cel 1
		cursor 952
		message 13
		signal $0002
		owner 70
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (== cel 2)
					(gSq4GlobalNarrator modNum: 0 say: 10)
				else
					(gSq4GlobalNarrator modNum: 0 say: 11)
				)
			)
			(else  (proc0_16 theVerb))
		)
	)
)

(instance hintbook of InvI
	(properties
		view 700
		cel 4
		cursor 955
		message 16
		signal $0002
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 0 say: 12)
			)
			(4
				(cond 
					((global2 script?) (gSq4GlobalNarrator modNum: 0 say: 13))
					(
					(and (proc999_5 global11 397 398) (not (proc0_6 31))) (gSq4GlobalNarrator modNum: 0 say: 14))
					((not (proc0_4 6800)) (gSq4GlobalNarrator modNum: 0 say: 15))
					(else
						(gInv curIcon: (gInv at: 9) hide:)
						(global2 setScript: (ScriptID 708 0))
					)
				)
			)
			(else  (proc0_16 theVerb))
		)
	)
)

(instance pen of InvI
	(properties
		view 700
		cel 5
		cursor 956
		message 17
		signal $0002
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 0 say: 16)
			)
			(else  (proc0_16 theVerb))
		)
	)
)

(instance atmCard of InvI
	(properties
		view 700
		cel 6
		cursor 957
		message 18
		signal $0002
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 0 say: 17)
			)
			(else  (proc0_16 theVerb))
		)
	)
)

(instance plug of InvI
	(properties
		view 700
		cel 7
		cursor 958
		message 19
		signal $0002
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 0 say: 18)
			)
			(else  (proc0_16 theVerb))
		)
	)
)

(instance cigar of InvI
	(properties
		view 700
		cel 8
		cursor 959
		message 20
		signal $0002
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(21
				(if state
					(gSq4GlobalNarrator modNum: 0 say: 20)
				else
					(gSq4GlobalNarrator modNum: 0 say: 21)
					(= state 1)
				)
			)
			(else  (proc0_16 theVerb))
		)
	)
)

(instance matches of InvI
	(properties
		view 700
		cel 9
		cursor 960
		message 21
		signal $0002
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 0 say: 22)
			)
			(else  (proc0_16 theVerb))
		)
	)
)

(instance diskette of InvI
	(properties
		view 700
		cel 10
		cursor 961
		message 22
		signal $0002
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 0 say: 23)
			)
			(else  (proc0_16 theVerb))
		)
	)
)

(instance rabbit of InvI
	(properties
		view 700
		cel 11
		cursor 962
		message 11
		signal $0002
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(cond 
					((!= view 700)
						(gInv hide:)
						(self view: 700 loop: 0 cel: 11)
						(gInv show: gEgo)
					)
					((not ((gInv at: 4) owner?))
						(gInv hide:)
						(self view: 701 loop: 0 cel: 0)
						(gInv show: gEgo)
					)
					(else (gSq4GlobalNarrator modNum: 0 say: 24))
				)
			)
			(4
				(if (== view 700)
					0
				else
					(proc0_11 67 3)
					(gSq4GlobalNarrator modNum: 0 say: 25)
					(gInv hide:)
					(gEgo get: 4)
					(self view: 700 loop: 0 cel: 11)
					(gInv show: gEgo)
				)
			)
			(12
				(gSq4GlobalNarrator modNum: 0 say: 26)
				(gInv hide:)
				(gEgo put: 4 0)
				(gInv curIcon: 0 show: gEgo)
			)
			(else  (proc0_16 theVerb))
		)
	)
)

(instance battery of InvI
	(properties
		view 700
		cel 12
		cursor 963
		message 12
		signal $0002
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 0 say: 27)
			)
			(else  (proc0_16 theVerb))
		)
	)
)

(instance tank of InvI
	(properties
		view 700
		cel 13
		cursor 964
		message 15
		signal $0002
		owner 335
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 0 say: 28)
			)
			(else  (proc0_16 theVerb))
		)
	)
)

(instance rope of InvI
	(properties
		view 700
		cel 14
		cursor 965
		message 9
		signal $0002
		owner 65
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 0 say: 29)
			)
			(else  (proc0_16 theVerb))
		)
	)
)

(instance laptop of InvI
	(properties
		view 700
		cel 15
		cursor 966
		message 23
		signal $0002
		owner 55
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(cond 
					((!= view 700)
						(gInv hide:)
						(self view: 700 loop: 0 cel: 15)
						(gInv show: gEgo)
					)
					((== ((gInv at: 4) owner?) 1) (gSq4GlobalNarrator modNum: 0 say: 31))
					(else
						(gInv hide:)
						(self view: 701 loop: 0 cel: 1)
						(gInv show: gEgo)
					)
				)
			)
			(4
				(if (== ((gInv at: 4) owner?) 1)
					(gSq4GlobalNarrator modNum: 0 say: 32)
					(gInv hide:)
					(gEgo get: 4)
					(gInv show: gEgo)
				else
					(gSq4GlobalNarrator modNum: 0 say: 33)
				)
			)
			(12
				(proc0_11 72 3)
				(gSq4GlobalNarrator modNum: 0 say: 34)
				(gInv hide:)
				(self view: 700 loop: 0 cel: 15)
				(gEgo put: 4 1)
				(gInv curIcon: 0 show: gEgo)
			)
			(19
				(proc0_11 71 3)
				(gSq4GlobalNarrator modNum: 0 say: 35)
				(gInv hide:)
				(gEgo put: 11 1)
				(gInv curIcon: 0 show: gEgo)
			)
			(else  (proc0_16 theVerb))
		)
	)
)

(instance gum of InvI
	(properties
		view 700
		loop 2
		cursor 967
		message 14
		signal $0002
		owner 297
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if cel
					(gSq4GlobalNarrator modNum: 0 say: 37)
				else
					(gSq4GlobalNarrator modNum: 0 say: 38)
				)
			)
			(4
				(if (not cel)
					(gInv hide:)
					(self view: 700 loop: 2 cel: 1 cursor: 968)
					(gInv show: gEgo)
				)
			)
			(else  (proc0_16 theVerb))
		)
	)
)

(instance bomb of InvI
	(properties
		view 700
		cel 3
		cursor 954
		message 10
		signal $0002
		owner 40
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 0 say: 39)
			)
			(else  (proc0_16 theVerb))
		)
	)
)

(instance checkIcon of Code
	(properties)
	
	(method (doit param1)
		(if
			(and
				(param1 isKindOf: IconI)
				(& (param1 signal?) $0004)
			)
			(= global198
				(| global198 (>> $8000 (gIconBar indexOf: param1)))
			)
		)
	)
)

(instance speakTimer of Timer
	(properties)
)

(instance icon0 of IconI
	(properties
		view 900
		loop 0
		cel 0
		type $5000
		message 3
		signal $0041
		maskView 900
		maskLoop 14
		maskCel 1
		noun 98
		helpVerb 31
	)
	
	(method (init)
		(= cursor walkCursor)
		(super init:)
	)
	
	(method (select &tmp temp0)
		(return
			(if (super select: &rest)
				(gIconBar hide:)
				(return 1)
			else
				(return 0)
			)
		)
	)
)

(instance icon1 of IconI
	(properties
		view 900
		loop 1
		cel 0
		message 1
		signal $0041
		maskView 900
		maskLoop 14
		maskCel 1
		noun 98
		helpVerb 32
	)
	
	(method (init)
		(= cursor lookCursor)
		(super init:)
	)
)

(instance icon2 of IconI
	(properties
		view 900
		loop 2
		cel 0
		message 4
		signal $0041
		maskView 900
		maskLoop 14
		noun 98
		helpVerb 33
	)
	
	(method (init)
		(= cursor doCursor)
		(super init:)
	)
)

(instance icon3 of IconI
	(properties
		view 900
		loop 3
		cel 0
		message 2
		signal $0041
		maskView 900
		maskLoop 14
		maskCel 3
		noun 98
		helpVerb 34
	)
	
	(method (init)
		(= cursor talkCursor)
		(super init:)
	)
)

(instance icon4 of IconI
	(properties
		view 900
		loop 4
		cel 0
		cursor 999
		message 0
		signal $0041
		maskView 900
		maskLoop 14
		maskCel 4
		noun 98
		helpVerb 35
	)
)

(instance icon5 of IconI
	(properties
		view 900
		loop 5
		cel 0
		cursor 999
		type $0000
		message 0
		signal $0043
		maskView 900
		maskLoop 14
		maskCel 2
		noun 98
		helpVerb 28
	)
	
	(method (select)
		(if (super select:) (gInv showSelf: gEgo))
	)
)

(instance icon6 of IconI
	(properties
		view 900
		loop 10
		cel 0
		message 6
		signal $0041
		maskView 900
		maskLoop 14
		noun 98
		helpVerb 36
	)
	
	(method (init)
		(= cursor smellCursor)
		(super init:)
	)
)

(instance icon7 of IconI
	(properties
		view 900
		loop 11
		cel 0
		message 7
		signal $0041
		maskView 900
		maskLoop 14
		maskCel 1
		noun 98
		helpVerb 38
	)
	
	(method (init)
		(= cursor tasteCursor)
		(super init:)
	)
)

(instance icon8 of IconI
	(properties
		view 900
		loop 7
		cel 0
		cursor 999
		message 8
		signal $0043
		maskView 900
		maskLoop 14
		maskCel 1
		noun 98
		helpVerb 39
	)
	
	(method (select)
		(return
			(if (super select: &rest)
				(gIconBar hide:)
				(global1 showControls:)
				(return 1)
			else
				(return 0)
			)
		)
	)
)

(instance icon9 of IconI
	(properties
		view 900
		loop 9
		cel 0
		type $0000
		message 5
		signal $0003
		maskView 900
		maskLoop 14
		noun 98
		helpVerb 37
	)
	
	(method (init)
		(= cursor helpCursor)
		(super init:)
	)
)

(instance sq4DoVerbCode of Code
	(properties)
	
	(method (doit param1)
		(switch param1
			(1
				(if ((CueObj client?) facingMe: gEgo)
					(if ((CueObj client?) noun?)
						(gSq4GlobalNarrator
							noun: ((CueObj client?) noun?)
							tVerb: 1
							say: 0
						)
						(gSq4GlobalNarrator noun: 99 tVerb: 0)
					else
						(proc0_16 param1)
					)
				)
			)
			(else  (proc0_16 param1))
		)
	)
)

(instance sq4FtrInit of Code
	(properties)
	
	(method (doit param1)
		(if (== (param1 sightAngle?) 26505)
			(param1 sightAngle: 90)
		)
		(if (== (param1 actions?) 26505) (param1 actions: 0))
	)
)

(instance sq4Win of BorderWindow
	(properties)
)

(instance invWin of InsetWindow
	(properties)
)

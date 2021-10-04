;;; Sierra Script 1.0 - (do not remove this comment)
(script# 704)
(include sci.sh)
(use Main)
(use RegionPath)
(use Sq4Dialog)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use MoveFwd)
(use n958)
(use StopWalk)
(use SysWindow)
(use Sound)
(use Cycle)
(use Game)
(use Obj)

(public
	brain 0
	droid1 1
	droid2 2
	terminal1 3
	terminal2 4
	terminal3 5
	proc704_6 6
	timerSound 7
	proc704_8 8
)

(local
	local0
	local1
	gEgoX
	local3
	local4
	local5
	local6
	local7
	local8
	theRegister
	local10
	local11
	[local12 100]
	[local112 100]
	[local212 40]
	[local252 271] = [32767 515 23 170 166 170 207 124 340 124 32767 520 -20 124 53 124 104 143 203 143 255 124 340 124 32767 525 -20 124 69 124 -20 -18 32767 510 158 240 106 161 -20 161 32767 505 340 163 65 163 255 163 271 240 32767 520 230 130 230 172 92 172 49 152 -20 152 32767 515 340 154 135 154 117 166 79 166 61 73 96 73 177 -8 32767 500 63 240 173 120 340 120 32767 505 -20 124 44 124 78 31 44 124 -20 124 32767 500 340 120 173 120 63 240 32767 515 177 -18 136 34 340 34 32767 520 -20 34 91 34 111 22 204 22 233 34 340 34 32767 525 -20 34 140 34 95 -18 32767 510 267 240 147 120 -20 120 32767 505 340 124 271 124 236 31 271 124 340 124 32767 510 -20 120 147 120 267 240 32767 525 105 -18 140 34 227 34 340 111 340 180 203 180 124 91 -20 91 32767 520 340 91 241 91 209 103 103 103 81 91 -20 91 32767 515 340 91 77 91 96 73 61 73 79 166 117 166 135 154 340 154 32767 520 -20 152 78 152 78 124 32767 505 42 240 65 163 340 163 32767 510 -20 161 106 161 158 240 32767 525 -20 -18 69 124 -20 124 32767 520 340 124 255 124 203 143 104 143 53 124 -20 124 32767 515 340 124 207 124 166 170 23 170 -32768]
	local523
)
(procedure (proc704_6)
	(if (== global11 global13)
		(voiceWindow color: global143 back: global129)
		(proc816_1
			&rest
			32
			voiceWindow
			77
			{** WARNING **}
			27
			1
			64
			160
			180
			67
			150
			22
			4
			111
		)
	)
)

(procedure (proc704_8 &tmp brainFormatting)
	(switch (= brainFormatting (brain formatting?))
		(5000
			(StrCpy @local212 {EXCELLENT})
			(= local10 global137)
		)
		(3000
			(StrCpy @local212 {VERY GOOD})
		)
		(2000 (StrCpy @local212 {GOOD}))
		(1500 (StrCpy @local212 {FAIR}))
		(1000
			(StrCpy @local212 {DANGER})
			(= local10 global135)
		)
		(500
			(StrCpy @local212 {CRITICAL})
			(= local10 global143)
		)
	)
	(if
		(and
			(< 0 brainFormatting)
			(<
				(switch (= brainFormatting (brain formatting?))
					(5000
						(StrCpy @local212 {EXCELLENT})
						(= local10 global137)
					)
					(3000
						(StrCpy @local212 {VERY GOOD})
					)
					(2000 (StrCpy @local212 {GOOD}))
					(1500 (StrCpy @local212 {FAIR}))
					(1000
						(StrCpy @local212 {DANGER})
						(= local10 global135)
					)
					(500
						(StrCpy @local212 {CRITICAL})
						(= local10 global143)
					)
				)
				3000
			)
			(not (mod brainFormatting 250))
		)
		(proc704_6
			(Format @local112 704 0 brainFormatting @local212)
		)
		(if (== (DoAudio 6) -1) (alertSound play:))
	)
	(if
		(and
			brainFormatting
			(!= global11 544)
			(!= (global2 curPic?) 699)
		)
		(if (or (not local12) global200)
			(Format @local12 {Time to Format:})
			(proc0_12 @local12 64 0 180 67 100 25 local10)
			(= global200 0)
		)
		(Format @local12 704 1 brainFormatting)
		(if local11 (proc0_12 local11))
		(if (== global13 global11)
			(= local11
				(proc0_12 @local12 64 90 180 67 25 25 local10)
			)
		)
	)
)

(procedure (localproc_017a param1 &tmp temp0 temp1)
	(cond 
		((< (= temp0 ((param1 mover?) value?)) 50) (= temp1 2))
		((< temp0 72) (= temp1 1))
		((< temp0 208) (= temp1 3))
		((< temp0 224) (= temp1 1))
		(else (= temp1 2))
	)
	(return temp1)
)

(procedure (localproc_036b param1)
	(return
		(cond 
			((!= (param1 level?) (brain level?)) 0)
			((proc0_6 38) 0)
			((== (param1 lastRoom?) global11) 0)
			((== (param1 room?) (global2 north?)) 1)
			((== (param1 room?) (global2 south?)) 3)
			((== (param1 room?) (global2 east?)) 2)
			((== (param1 room?) (global2 west?)) 4)
			(else 0)
		)
	)
)

(procedure (localproc_0408 param1)
	(return
		(cond 
			(
			(or (< (gEgo heading?) 45) (> (gEgo heading?) 305))
				(switch param1
					(1 (return 0))
					(3 (return 1))
					(2 (return 2))
					(4 (return 3))
				)
			)
			((< (gEgo heading?) 135)
				(switch param1
					(1 (return 3))
					(3 (return 2))
					(2 (return 0))
					(4 (return 1))
				)
			)
			((< (gEgo heading?) 235)
				(switch param1
					(1 (return 1))
					(3 (return 0))
					(2 (return 3))
					(4 (return 2))
				)
			)
			(else
				(switch param1
					(1 (return 2))
					(3 (return 3))
					(2 (return 1))
					(4 (return 0))
				)
			)
		)
	)
)

(procedure (localproc_04fc param1 &tmp [temp0 40])
	(switch (localproc_0408 param1)
		(0
			(gSq4GlobalNarrator modNum: 704 say: 1)
		)
		(1
			(gSq4GlobalNarrator modNum: 704 say: 2)
		)
		(3
			(gSq4GlobalNarrator modNum: 704 say: 3)
		)
		(2
			(gSq4GlobalNarrator modNum: 704 say: 4)
		)
	)
	(gLongSong2
		number: 845
		vol: 0
		loop: -1
		play:
		fade: 127 1 10 0
	)
)

(instance voiceWindow of SysWindow
	(properties)
)

(class brain of Rgn
	(properties
		script 0
		number 0
		modNum -1
		noun 0
		timer 0
		keep 0
		initialized 0
		level 1
		formatting 0
		lastRoom 0
		exitDir 0
	)
	
	(method (init &tmp temp0 temp1 temp2)
		(proc958_0 128 501 28 506)
		(= local523 global199)
		(super init: &rest)
		(if (and (not (proc0_6 38)) (!= global11 541))
			(droid1 init:)
			(droid2 init:)
		)
		(switch level
			(1 (= temp0 2))
			(2 (= temp0 3))
			(3 (= temp0 -1))
		)
		(if (== global11 541)
			(gEgo
				view: 0
				setCycle: StopWalk 4
				headView: 4
				illegalBits: 0
				setPri: temp0
				normal: 1
			)
		else
			(gEgo
				view: 3
				setCycle: StopWalk 510
				headView: 510
				illegalBits: 0
				setPri: temp0
				normal: 1
			)
		)
		(= local12 0)
		(cond 
			((proc999_5 global11 541 544) (= temp2 0))
			((brain formatting?) (= temp2 869))
			((== global11 520) (= temp2 849))
			((== global11 514) (= temp2 850))
			(else (= temp2 20))
		)
		(cond 
			((not temp2) (gLongSong fade:))
			((!= (gLongSong number?) temp2) (gLongSong number: temp2 vol: 127 loop: -1 playBed:))
		)
		(if (= temp1 (localproc_036b droid1))
			(localproc_04fc (= temp1 (localproc_036b droid1)))
		)
		(if (= temp1 (localproc_036b droid2))
			(localproc_04fc (= temp1 (localproc_036b droid2)))
		)
	)
	
	(method (doit &tmp temp0)
		(super doit:)
		(if formatting
			(if (< (Abs (- global88 local523)) global199)
				0
			else
				(= local523 global88)
				(if (and local12 (== (global2 curPic?) 699))
					(= local12 0)
				)
				(proc704_8)
				(if (not (-- formatting)) (proc0_10 0 5))
			)
		)
		(cond 
			((global2 script?))
			((and (proc0_5 gEgo 8) (!= global11 150)) (global2 setScript: rgnExitScript 0 exitDir))
		)
	)
	
	(method (newRoom newRoomNumber &tmp temp0)
		(if local11 (= local11 0))
		(if (droid1 mover?) (droid1 setMotion: 0))
		(if (droid2 mover?) (droid2 setMotion: 0))
		(if
			(and
				(not
					(= keep
						(proc999_5
							newRoomNumber
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
					)
				)
				(!= newRoomNumber 556)
			)
			(gLongSong fade:)
		)
		(= initialized 0)
		(if global25 (global25 dispose:))
		(gLongSong2 fade:)
	)
	
	(method (makePolygon &tmp newPolygon)
		((= newPolygon (Polygon new:)) init: &rest type: 2)
		(global2 addObstacle: newPolygon)
	)
)

(class SecurityDroid of Sq4Actor
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
		view -1
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $0000
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
		illegalBits $8000
		xLast 0
		yLast 0
		xStep 3
		origStep 770
		moveSpeed 6
		blocks 0
		baseSetter 0
		mover 0
		looper 0
		viewer 0
		avoider 0
		code 0
		lookStr 0
		room 0
		lastRoom 0
		level 0
		path 0
		attacks 0
		body 0
	)
	
	(method (init)
		(= illegalBits 0)
		(= signal 26624)
		(self setCycle: Fwd)
		(if (IsObject path) (self setMotion: path))
		(super init: &rest)
		(if body (body init:))
		(= attacks 0)
		(self doit:)
		(if body (body doit:))
	)
	
	(method (doit &tmp temp0)
		(super doit:)
		(cond 
			(script)
			((not mover) (if (!= global11 545) (self setMotion: path)))
			(else
				(switch level
					(1 (self setPri: 2))
					(2 (self setPri: 3))
					(else  (self setPri: -1))
				)
				(if
					(and
						(proc999_5 room global11 (brain lastRoom?))
						(== level (brain level?))
					)
					(= temp0 (self distanceTo: gEgo))
					(cond 
						((== attacks 3) (self attack: 1))
						((< temp0 50) (self attack: 1))
						((< temp0 100) (self attack: 0))
					)
				)
			)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 704 say: 5)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (onMe)
		(if (super onMe: &rest) else (body onMe: &rest))
	)
	
	(method (attack param1)
		(cond 
			(
			(and (!= room (global2 curPic?)) (!= global11 545)))
			(
			(not (proc999_4 0 0 320 190 (gEgo x?) (gEgo y?))))
			((== global11 545)
				(cond 
					((not mover))
					((mover isKindOf: RegionPath) (self setMotion: PolyPath (mover x?) (mover y?)))
				)
			)
			(else (++ attacks) (self setScript: shootEgo 0 param1))
		)
	)
)

(instance droid1 of SecurityDroid
	(properties
		z 44
		view 506
		cycleSpeed 12
	)
	
	(method (init)
		(= path droidPath1)
		(= body droid1Body)
		(super init: &rest)
	)
	
	(method (doit)
		(super doit:)
		(switch room
			(525
				(if (and (self inRect: 0 0 64 40) (== level 3))
					(self setPri: 4)
				)
			)
			(515
				(if (and (< x 120) (== level 2)) (self setPri: 5))
			)
		)
	)
)

(instance droid2 of SecurityDroid
	(properties
		z 44
		view 506
		cycleSpeed 12
	)
	
	(method (init)
		(= path droidPath2)
		(= body droid2Body)
		(super init: &rest)
	)
	
	(method (doit)
		(super doit:)
		(switch room
			(525
				(if (and (self inRect: 0 0 64 40) (== level 3))
					(self setPri: 4)
				)
			)
			(515
				(if (and (< x 120) (== level 2)) (self setPri: 5))
			)
		)
	)
)

(instance droid1Body of Sq4Prop
	(properties
		view 506
		loop 1
	)
	
	(method (doit)
		(super doit:)
		(if (droid1 loop?)
		else
			(self
				x: (droid1 x?)
				y: (droid1 y?)
				z: (- (droid1 z?) 44)
				setPri: (droid1 priority?)
				signal: (| (droid1 signal?) $4000)
			)
		)
	)
)

(instance droid2Body of Sq4Prop
	(properties
		view 506
		loop 1
	)
	
	(method (doit)
		(super doit:)
		(if (droid2 loop?)
		else
			(self
				x: (droid2 x?)
				y: (droid2 y?)
				z: (- (droid2 z?) 44)
				setPri: (droid2 priority?)
				signal: (| (droid2 signal?) $4000)
			)
		)
	)
)

(instance droidPath1 of RegionPath
	(properties
		theRegion 704
	)
	
	(method (next)
		(if
		(and (proc999_5 value 71 205) (!= global11 515))
			(= value (+ value 2))
			(client
				posn: [local252 (++ value)] [local252 (++ value)]
			)
		)
		(super next:)
	)
	
	(method (nextRoom &tmp temp0)
		(client lastRoom: (client room?))
		(super nextRoom: &rest)
		(if (== (client lastRoom?) global11)
			(gLongSong2 fade:)
		)
		(if (= temp0 (localproc_036b client))
			(localproc_04fc (= temp0 (localproc_036b client)))
		)
	)
	
	(method (at param1)
		(client room: currentRoom level: (localproc_017a client))
		(return [local252 param1])
	)
)

(instance droidPath2 of RegionPath
	(properties
		value 77
		theRegion 704
	)
	
	(method (next)
		(if
		(and (proc999_5 value 71 205) (!= global11 515))
			(= value (+ value 2))
			(client
				posn: [local252 (++ value)] [local252 (++ value)]
			)
		)
		(super next:)
	)
	
	(method (nextRoom &tmp temp0)
		(client lastRoom: (client room?))
		(super nextRoom: &rest)
		(if (== (client lastRoom?) global11)
			(gLongSong2 fade:)
		)
		(if (= temp0 (localproc_036b client))
			(localproc_04fc (= temp0 (localproc_036b client)))
		)
	)
	
	(method (at param1)
		(client room: currentRoom level: (localproc_017a client))
		(return [local252 param1])
	)
)

(instance blast of Sq4Prop
	(properties)
)

(instance timerSound of Sound
	(properties
		number 879
	)
)

(instance laserSound of Sound
	(properties
		number 105
	)
)

(instance alertSound of Sound
	(properties
		number 101
	)
)

(instance shootEgo of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(laserSound play:)
				(client setMotion: 0)
				(if register
					(= gEgoX (gEgo x?))
					(= local3 (- (gEgo y?) 15))
				else
					(= gEgoX (+ (gEgo x?) (- (Random 1 20) 10)))
					(= local3 (+ (gEgo y?) (- (Random 1 20) 10)))
				)
				(= local0 (proc999_2 320 (proc999_3 0 (client x?))))
				(= local1
					(proc999_2 190 (proc999_3 0 (- (client y?) 44)))
				)
				(= local4 (- (proc999_2 local1 local3) 1))
				(= local6 (+ (proc999_3 local1 local3) 1))
				(= local5 (- (proc999_2 local0 gEgoX) 1))
				(= local7 (+ (proc999_3 local0 gEgoX) 1))
				(= local8
					(Graph grSAVE_BOX local4 local5 local6 local7 1)
				)
				(Graph
					grDRAW_LINE
					local1
					local0
					local3
					gEgoX
					global143
					-1
					-1
				)
				(Graph grREDRAW_BOX local4 local5 local6 local7 1)
				(= cycles 1)
			)
			(1
				(Graph grRESTORE_BOX local8)
				(Graph grREDRAW_BOX local4 local5 local6 local7 1)
				(client setMotion: PolyPath (gEgo x?) (gEgo y?))
				(if register
					(gEgo
						view: 511
						setLoop: (if (< (client x?) (gEgo x?)) 0 else 1)
						setCel: 0
						setMotion: 0
						setCycle: End self
					)
				else
					(blast
						view: 28
						x: gEgoX
						y: local3
						signal: 24576
						init:
						setCycle: End self
					)
				)
			)
			(2
				(if register (proc0_10 8 20) else (blast dispose:))
				(self dispose:)
			)
		)
	)
)

(instance terminal1 of Sq4Feature
	(properties
		sightAngle 90
	)
	
	(method (doVerb theVerb param2)
		(if (!= (brain level?) 1)
			(gSq4GlobalNarrator modNum: 704 say: 6)
		else
			(switch theVerb
				(1
					(global2 setScript: pocketPalScript self 0)
				)
				(23
					(global2 setScript: pocketPalScript 0 self)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance terminal2 of Sq4Feature
	(properties
		sightAngle 90
	)
	
	(method (doVerb theVerb param2)
		(if (!= (brain level?) 2)
			(gSq4GlobalNarrator modNum: 704 say: 6)
		else
			(switch theVerb
				(1
					(global2 setScript: pocketPalScript self 0)
				)
				(23
					(global2 setScript: pocketPalScript 0 self)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance terminal3 of Sq4Feature
	(properties
		sightAngle 90
	)
	
	(method (doVerb theVerb param2)
		(if (!= (brain level?) 3)
			(gSq4GlobalNarrator modNum: 704 say: 6)
		else
			(switch theVerb
				(1
					(global2 setScript: pocketPalScript self 0)
				)
				(23
					(global2 setScript: pocketPalScript 0 self)
				)
				(else 
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance pocketPalPanel of Sq4View
	(properties
		x 35
		y 46
		view 501
		priority 14
		signal $0010
	)
	
	(method (doVerb theVerb)
		(pocketPalPlug doVerb: theVerb &rest)
	)
)

(instance pocketPalPlug of Sq4Prop
	(properties
		x 36
		y 41
		view 501
		loop 1
		priority 15
		signal $0010
	)
	
	(method (doit)
		(super doit:)
		(if (> (gEgo distanceTo: theRegister) 30)
			(self dispose:)
		)
	)
	
	(method (dispose)
		(pocketPalPanel dispose:)
		(super dispose:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 704 say: 7)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue)
		(self dispose:)
	)
)

(instance pocketPalScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(= theRegister register)
				else
					(= theRegister caller)
					(= caller 0)
				)
				(proc0_2)
				(if (> (gEgo distanceTo: theRegister) 30)
					(gEgo
						setMotion: PolyPath (theRegister x?) (theRegister y?) self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(if register
					(cond 
						((not (== ((gInv at: 11) owner?) 1)) (gSq4GlobalNarrator modNum: 704 say: 8))
						((not (== ((gInv at: 4) owner?) 1)) (gSq4GlobalNarrator modNum: 704 say: 9))
						((!= ((gInv at: 11) state?) global170) (gSq4GlobalNarrator modNum: 704 say: 10))
						(else (brain lastRoom: global11) (global2 newRoom: 545))
					)
				else
					(pocketPalPanel init:)
					(pocketPalPlug cel: global170 init:)
				)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance rgnExitScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setHeading: register self)
			)
			(1
				(gEgo setMotion: MoveFwd 50 self)
			)
			(2 (proc0_3) (self dispose:))
		)
	)
)

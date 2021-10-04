;;; Sierra Script 1.0 - (do not remove this comment)
(script# 305)
(include sci.sh)
(use Main)
(use rssScript_703)
(use MoveToY)
(use SQRoom)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use n958)
(use Cycle)
(use User)
(use Obj)

(public
	rm305 0
	pod 1
)

(instance rm305 of SQRoom
	(properties
		picture 305
		south 315
		west 300
	)
	
	(method (init)
		(if (proc0_6 16)
			((ScriptID 703 4) init: view: 13 loop: 0 posn: 0 80)
		)
		(if
			(and
				(or
					(== (butte curPolice1Room?) 305)
					(== (butte curPolice2Room?) 305)
				)
				(or (< (butte policeLanded?) 0) (proc0_6 16))
			)
			((ScriptID 703 4) posn: 0 80 init: forceUpd:)
		)
		(if
			(and
				(< (butte policeLanded?) 0)
				(or
					(== (butte curPolice1Room?) 305)
					(== (butte curPolice2Room?) 305)
				)
				(== (gEgo view?) 0)
			)
			(butte junctioned: 1)
			((ScriptID 703 4) init: setScript: copEnters)
		else
			(butte junctioned: 0)
		)
		(proc958_0 128 0 305 300)
		(proc958_0 132 124 125)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						124
						0
						319
						0
						319
						116
						258
						116
						246
						113
						245
						91
						165
						102
						147
						90
						145
						80
						122
						72
					yourself:
				)
				((Polygon new:)
					type: 1
					init: 0 0 112 0 112 71 60 70 0 66
					yourself:
				)
				((Polygon new:)
					type: 1
					init:
						0
						85
						66
						84
						127
						89
						143
						103
						135
						112
						104
						117
						103
						130
						90
						132
						86
						151
						59
						178
						62
						189
						0
						189
					yourself:
				)
				((Polygon new:)
					type: 1
					init: 319 189 186 189 187 165 170 152 165 125 250 125 254 122 319 123
					yourself:
				)
		)
		(if (> (butte policeLanded?) 0)
			(Load rsPIC 300)
		else
			(proc958_0 128 7 5)
		)
		(self setRegions: 703)
		(theStairs init:)
		(theRoom init:)
		(proc0_3)
		(switch global12
			(south
				(gEgo init:)
				(self style: 14)
			)
			(west
				(self style: 12)
				(gEgo
					init:
					y:
						(cond 
							((< (gEgo y?) 67) 67)
							((> (gEgo y?) 88) 88)
							(else (gEgo y?))
						)
					setHeading: 90 self
				)
			)
			(else 
				(proc0_2)
				(gLongSong number: 18 loop: -1 vol: 127 flags: 1 playBed:)
				(if (proc0_6 2)
					(self setScript: egoLands)
				else
					(gEgo
						view: 378
						loop: 0
						cel: 0
						x: 218
						y: 97
						setPri: 7
						normal: 0
						moveHead: 0
						init:
					)
					(self setScript: egoExits)
				)
			)
		)
		(proc0_14 10)
		(super init:)
		(if (or (== global12 300) (== global12 315))
			(gEgo setPri: 8 ignoreActors: 0 illegalBits: 0)
			(pod loop: 1 cel: 10 init: stopUpd:)
			(door init: setPri: 5)
		)
	)
	
	(method (doit &tmp temp0)
		(cond 
			(script 0)
			((== (gEgo edgeHit?) 3) (proc0_2) (self setScript: exitSouthScript))
		)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond 
			(script)
			((== (gEgo edgeHit?) 3) (proc0_2) (self setScript: exitSouthScript))
			(
				(and
					(butte junctioned?)
					(not ((ScriptID 703 4) script?))
				)
				(cond 
					((== (butte oldPoliceRoom?) 300) ((ScriptID 703 4) posn: -5 75))
					((== (butte oldPoliceRoom?) 315) ((ScriptID 703 4) posn: 150 250))
				)
				((ScriptID 703 4) init:)
				((ScriptID 703 4) setScript: copEnters)
			)
			(
				(or
					(& temp0 $0002)
					(& temp0 $0004)
					(& temp0 $0010)
					(& temp0 $0080)
					(& temp0 $0100)
					(& temp0 $0200)
				)
				(proc0_2)
				(self setScript: fallScript 0 temp0)
			)
			((and (& temp0 $4000) (== (gEgo view?) 0)) (gEgo view: 0))
			(
				(and
					(!= script exitSouthScript)
					(not (& temp0 $4000))
					(== (gEgo view?) 0)
				)
				(gEgo view: 0)
			)
		)
		(cond 
			(script)
			((and (< (gEgo y?) 96) (> (gEgo x?) 142)) (gEgo setPri: 5))
			((> (gEgo y?) 113) (gEgo setPri: 15))
			((> (gEgo y?) 86) (gEgo setPri: 13))
			(else (gEgo setPri: 8))
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 531) (gLongSong stop:))
		(if
		(and (== script fallScript) (== (gEgo edgeHit?) 3))
			(= newRoomNumber 0)
		else
			(super newRoom: newRoomNumber)
		)
	)
)

(instance fallScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(cond 
					((& register $0100) (gEgo setPri: 3))
					((& register $0200) (gEgo x: (+ (gEgo x?) 10) setPri: 4))
					((& register $0002) (gEgo x: (- (gEgo x?) 10) setPri: 4))
					((and (& register $0010) (> (gEgo x?) 170)) (gEgo setPri: 6))
					(else (gEgo setPri: 4))
				)
				(global2 setScript: (ScriptID 703 1))
			)
		)
	)
)

(instance exitSouthScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gEgo
					setHeading: (+ 180 (/ (- (gEgo x?) 210) 3)) self
				)
			)
			(1
				(= temp0
					(+ (CelHigh (gEgo view?) (gEgo loop?) (gEgo cel?)) 1)
				)
				(gEgo setMotion: MoveToY (+ 189 temp0) self)
			)
			(2
				(global2 newRoom: (global2 south?))
			)
		)
	)
)

(instance egoLands of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(podFlash init: setCycle: Fwd)
				(= cycles 1)
			)
			(1
				(gLongSong2 number: 838 vol: 127 loop: 1 play:)
				(= cycles 24)
			)
			(2
				(pod init: setCycle: CT 9 1 self)
			)
			(3
				(gLongSong2 fade:)
				(door init: setPri: (+ (pod priority?) 1))
				(pod setCycle: End self)
			)
			(4
				(gLongSong2 stop:)
				(podFlash dispose:)
				(= cycles 3)
			)
			(5
				(proc0_3)
				(global2 newRoom: 531)
			)
		)
	)
)

(instance egoExits of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(if
		(and (== state 1) (== (gLongSong2 prevSignal?) -1))
			(self cue:)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(door init:)
				(pod setCel: 10 init:)
				(if (proc0_6 16) ((ScriptID 703 4) init:))
				(= cycles 1)
			)
			(1
				(gLongSong2 number: 124 loop: 1 vol: 127 play:)
			)
			(2
				(gLongSong2 number: 142 play:)
				(door setCycle: End)
				(= cycles 1)
			)
			(3 (door setCycle: End self))
			(4
				(gLongSong2 stop:)
				(gEgo setCycle: End self)
			)
			(5
				(pod priority: -1 stopUpd:)
				(gEgo view: 0 loop: 1 normal: 1 moveHead: 1 x: 221 y: 97)
				(proc0_1)
				(= cycles 3)
			)
			(6
				(gLongSong2 number: 142 play:)
				(door setPri: 3 setCycle: Beg self)
			)
			(7
				(gLongSong2 stop:)
				(proc0_3)
				(User canControl: 1)
				(client setScript: 0)
			)
		)
	)
)

(instance enterPod of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 221 97 self)
				(= cycles 10)
			)
			(1
				(if (global5 contains: (ScriptID 703 4))
					(gEgo setMotion: 0)
					(proc0_13 gEgo (ScriptID 703 4))
					((ScriptID 703 4) setScript: (ScriptID 703 5))
					(self dispose:)
				else
					(gEgo setMotion: PolyPath 221 97 self)
				)
			)
			(2
				(if (global5 contains: (ScriptID 703 4))
					(gEgo setMotion: 0)
					(proc0_13 gEgo (ScriptID 703 4))
					((ScriptID 703 4) setScript: (ScriptID 703 5))
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(3
				(gLongSong2 number: 142 play:)
				(door setCycle: End self)
			)
			(4
				(gEgo
					view: 378
					normal: 0
					loop: 1
					cel: 0
					x: 224
					y: 75
					illegalBits: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(5
				(door setPri: (+ (gEgo priority?) 1))
				(gLongSong2 number: 142 loop: 1 vol: 127 play:)
				(door cel: 9 init: setCycle: Beg self)
			)
			(6
				(gLongSong2 number: 125 play:)
				(gEgo dispose:)
				(proc0_3)
				(= cycles 2)
			)
			(7
				(if (< (butte policeLanded?) 0) (proc0_7 16))
				(global2 newRoom: 531)
			)
		)
	)
)

(instance copEnters of Script
	(properties)
	
	(method (doit)
		(if (and (not (global2 script?)) (== state 0))
			(self cue:)
		)
		(if
			(and
				(< ((ScriptID 703 4) distanceTo: gEgo) 80)
				(not (global2 script?))
			)
			((ScriptID 703 4) setScript: (ScriptID 703 5))
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				((ScriptID 703 4)
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 146 95 self
				)
			)
			(2
				((ScriptID 703 4)
					setMotion: MoveTo (gEgo x?) (gEgo y?) self
				)
			)
		)
	)
)

(instance podFlash of Sq4Prop
	(properties
		x 186
		y 57
		view 305
		priority 6
		signal $4010
	)
)

(instance pod of Sq4Prop
	(properties
		x 254
		y 85
		view 305
		loop 1
		priority 5
		signal $4010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 1))
			(4
				(proc0_2)
				(global2 setScript: enterPod)
			)
			(6 (gSq4GlobalNarrator say: 2))
			(7 (gSq4GlobalNarrator say: 3))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance door of Sq4Prop
	(properties
		x 194
		y 61
		view 305
		loop 2
		priority 10
		signal $0010
	)
)

(instance theStairs of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		onMeCheck $4000
		lookStr 4
	)
)

(instance theRoom of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2
				((ScriptID 703 6) doVerb: theVerb)
			)
			(1 (gSq4GlobalNarrator say: 5))
			(else  (super doVerb:))
		)
	)
)

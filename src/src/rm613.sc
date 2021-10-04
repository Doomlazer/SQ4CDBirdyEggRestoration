;;; Sierra Script 1.0 - (do not remove this comment)
(script# 613)
(include sci.sh)
(use Main)
(use ulence)
(use SQRoom)
(use Sq4Dialog)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use Cycle)
(use Obj)

(public
	rm613 0
)

(instance rm613 of SQRoom
	(properties
		picture 613
		east 614
		south 610
		west 612
	)
	
	(method (init)
		(Load rsVIEW 305)
		(Load rsVIEW 378)
		(Load rsVIEW 617)
		(Load rsSOUND 124)
		(Load rsSOUND 125)
		(Load rsSOUND 142)
		(switch gWest
			(609 (gEgo x: 14 y: 185))
			(610
				(if (proc0_6 75)
					(ulence status: 2 bikerComing: 1)
					(Load rsVIEW 633)
					(Load rsVIEW 635)
					(Load rsSOUND 50)
					(self setScript: bringInBike)
				)
				(gLongSong2 number: 0 vol: 0 stop:)
			)
			(612
				(if (< (gEgo y?) 146) (gEgo y: 134))
			)
			(614
				(if (> (gEgo y?) 171) (gEgo y: 171))
			)
			(else 
				(gEgo setLoop: 0 setCel: 0 posn: 1000 1000)
				(if (proc0_6 75) (ulence status: 1))
				(gLongSong flags: 1)
				(gLongSong2 flags: 1)
				(self setScript: landShip)
			)
		)
		(door init: setCel: 0)
		(ship init:)
		(gEgo init: illegalBits: 0 ignoreActors: 1)
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
						162
						261
						160
						225
						152
						191
						136
						197
						133
						205
						127
						190
						122
						149
						121
						144
						140
						104
						140
						59
						154
						38
						146
						40
						124
						0
						124
					yourself:
				)
		)
		(building init:)
		(if
		(and (> (Random 0 100) 20) (== (ulence status?) 1))
			(ulence status: 2 bikerComing: 1)
			(Load rsVIEW 633)
			(Load rsVIEW 635)
			(Load rsSOUND 50)
		else
			(ulence bikerComing: 0)
		)
		((ScriptID 706 7)
			init:
			nsLeft: 0
			nsTop: 91
			nsBottom: 189
			nsRight: 319
		)
		((ScriptID 706 8)
			init:
			nsLeft: 0
			nsTop: 0
			nsBottom: 90
			nsRight: 319
		)
	)
	
	(method (doit)
		(if
			(and
				(== (ulence status?) 4)
				(< ((ScriptID 706 1) distanceTo: gEgo) 15)
			)
			(proc0_2)
			(ulence status: 6)
			(gEgo setScript: 0)
			(ulence deathLoop: 1)
			(self setScript: (ScriptID 706 3))
		)
		(cond 
			(script 0)
			(
				(and
					(== (ulence status?) 2)
					(gEgo inRect: 220 170 259 182)
				)
				(proc0_2)
				(ulence status: 3)
				((ScriptID 706 1)
					view: 633
					init:
					hide:
					posn: 0 (- (gEgo y?) 5)
					setLoop: 0
					setScript: runOver1
				)
				(gEgo setScript: (ScriptID 706 5))
			)
		)
		(super doit: &rest)
	)
)

(instance landShip of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(door setPri: 14)
				(gEgo
					view: 378
					posn: 106 143
					illegalBits: 0
					ignoreActors: 1
					normal: 0
				)
				(= cycles 1)
			)
			(1
				(gLongSong2 number: 838 loop: 1 vol: 127 play:)
				(gEgo show:)
				(= seconds 2)
			)
			(2
				(gLongSong2 number: 124 loop: 1 play: self)
			)
			(3
				(gLongSong2 number: 142 loop: 1 play:)
				(door setCycle: End self)
			)
			(4
				(gLongSong2 stop:)
				(= seconds (Random 2 4))
			)
			(5 (gEgo setCycle: End self))
			(6
				(proc0_1 (gEgo loop?) 0)
				(ship priority: -1 stopUpd:)
				(= cycles 1)
			)
			(7 (gEgo setHeading: 135 self))
			(8
				(gEgo
					setLoop: 4
					heading: 135
					setMotion: MoveTo 110 142 self
				)
			)
			(9
				(gLongSong2 play:)
				(door setPri: 5 setCycle: Beg self)
			)
			(10
				(gLongSong2 number: 125 play:)
				(proc0_1 (gEgo loop?) 0)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance enterPod of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: PolyPath 111 147 self
				)
			)
			(1
				(gLongSong2 vol: 127 number: 142 loop: 1 play:)
				(door setCycle: End self)
			)
			(2
				(gLongSong2 stop:)
				(door setPri: 14)
				(gEgo
					setPri: 5
					posn: 110 121
					setCel: 0
					view: 378
					setLoop: 1
					cycleSpeed: 12
				)
				(= cycles 1)
			)
			(3 (gEgo setCycle: End self))
			(4
				(gLongSong2 vol: 127 play:)
				(door setCycle: Beg self)
			)
			(5
				(gLongSong2 number: 125 vol: 127 play:)
				(gLongSong fade:)
				(DrawStatus {_} global146 0)
				(global2 newRoom: 531)
			)
		)
	)
)

(instance runOver1 of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(ulence egoBusy: 1)
				(gLongSong
					vol: 25
					number: 50
					loop: -1
					playBed:
					fade: 127 10 10 0
				)
				(= seconds 3)
			)
			(1
				((ScriptID 706 6) init: play:)
				((ScriptID 706 1)
					show:
					setMotion: MoveTo 65 (- (gEgo y?) 5) self
				)
			)
			(2
				(ulence status: 4)
				(proc0_3)
				((ScriptID 706 1)
					setPri: (+ (gEgo priority?) 1)
					setMotion: MoveTo 338 (- (gEgo y?) 5) self
				)
			)
			(3
				(gLongSong fade:)
				((ScriptID 706 6) fade:)
				((ScriptID 706 1) hide:)
				(= seconds 3)
			)
			(4
				(if (!= (ulence status?) 6)
					(ulence status: 1 fieldOff: 0 bikerComing: 0 egoBusy: 0)
					(gEgo setScript: 0)
					(gSq4GlobalNarrator modNum: 611 say: 1 self)
				)
				(= cycles 2)
			)
			(5 (proc0_3) (self dispose:))
		)
	)
)

(instance bringInBike of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gEgo
					posn: (gEgo x?) 238
					setMotion: MoveTo (gEgo x?) 185 self
				)
			)
			(1
				(proc0_2)
				(ulence status: 3)
				((ScriptID 706 1)
					view: 632
					init:
					hide:
					posn: 364 179
					setLoop: 1
					setScript: runOver2
				)
				(gEgo setScript: (ScriptID 706 4))
				(self dispose:)
			)
		)
	)
)

(instance runOver2 of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(ulence egoBusy: 1)
				(gLongSong
					vol: 25
					number: 50
					loop: -1
					playBed:
					fade: 127 10 10 0
				)
				(= seconds 1)
			)
			(1
				((ScriptID 706 6) init: play:)
				((ScriptID 706 1) show: setMotion: MoveTo 164 179 self)
			)
			(2
				(ulence status: 4)
				(proc0_3)
				((ScriptID 706 1)
					setPri: (+ (gEgo priority?) 1)
					setMotion: MoveTo -56 (- (gEgo y?) 5) self
				)
			)
			(3
				(gLongSong fade:)
				((ScriptID 706 6) fade:)
				((ScriptID 706 1) hide:)
				(= seconds 3)
			)
			(4
				(if (!= (ulence status?) 6)
					(ulence status: 1 fieldOff: 0 bikerComing: 0 egoBusy: 0)
					(gEgo setScript: 0)
					(gSq4GlobalNarrator modNum: 611 say: 1 self)
				)
				(= cycles 2)
			)
			(5 (proc0_3) (self dispose:))
		)
	)
)

(instance ship of Sq4Prop
	(properties
		x 93
		y 146
		view 617
		signal $6000
	)
	
	(method (init)
		(super init:)
		(self setPri: 4 addToPic:)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(7 (gSq4GlobalNarrator say: 1))
			(1 (gSq4GlobalNarrator say: 2))
			(4
				(if (== (ulence egoBusy?) 1)
					(proc816_1 613 0)
				else
					(proc0_2)
					(ulence fieldOff: 1)
					(global2 setScript: enterPod)
				)
			)
			(6 (gSq4GlobalNarrator say: 3))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door of Sq4Prop
	(properties
		x 80
		y 107
		view 617
		loop 1
		priority 5
		signal $6010
	)
)

(instance building of Sq4Feature
	(properties
		y 155
		nsTop 29
		nsLeft 194
		nsBottom 155
		nsRight 319
		sightAngle 180
		onMeCheck $0002
		lookStr 4
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(6 (gSq4GlobalNarrator say: 5))
			(7 (gSq4GlobalNarrator say: 6))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

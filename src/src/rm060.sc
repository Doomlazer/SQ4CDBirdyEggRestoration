;;; Sierra Script 1.0 - (do not remove this comment)
(script# 60)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Feature)
(use RandCycle)
(use Polygon)
(use ForwardCounter)
(use n958)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm060 0
)

(local
	[local0 16] = [0 163 44 163 62 180 247 180 251 184 319 184 319 189 0 189]
)
(instance rm060 of SQRoom
	(properties
		picture 60
		style $000a
		horizon 130
		north 45
		east 65
		west 55
	)
	
	(method (init)
		(global1 setCursor: gWalkCursor 1)
		(proc958_0 128 0 61)
		(proc958_0 132 150 802)
		(Load rsSCRIPT 941)
		(switch global12
			(40
				(proc0_3)
				(gEgo x: 20 y: (+ horizon (gEgo yStep?)))
			)
			(50
				(proc0_3)
				(gEgo x: 300 y: (+ horizon (gEgo yStep?)))
			)
			(59
				(proc958_0 128 62 0 4)
				(proc958_0 132 821 822 115)
				(Load rsSCRIPT 956)
				(gLongSong2
					number: 115
					priority: 15
					vol: 127
					loop: 1
					init:
					changeState:
				)
				(proc0_2)
				(self setScript: ripScript style: 13)
			)
			(55
				(proc0_2)
				(self setScript: enterScript)
				(gEgo
					y:
						(cond 
							((> (gEgo y?) 160) 160)
							((< (gEgo y?) (+ horizon (gEgo yStep?))) (+ horizon (gEgo yStep?)))
							(else (gEgo y?))
						)
				)
				(self setScript: enterScript)
			)
			(65
				(proc0_2)
				(gEgo
					y:
						(cond 
							((> (gEgo y?) 175) 172)
							((< (gEgo y?) (+ horizon (gEgo yStep?))) (+ horizon (gEgo yStep?)))
							(else (gEgo y?))
						)
				)
				(self setScript: enterScript)
			)
			(72
				(gEgo
					x: 160
					y: (+ horizon (gEgo yStep?))
					setHeading: 180
				)
			)
			(45
				(proc0_3)
				(gEgo
					x:
						(cond 
							((> (gEgo x?) 290) 290)
							((< (gEgo x?) 30) 30)
							(else (gEgo x?))
						)
					y: (+ horizon (gEgo yStep?))
				)
			)
			(else 
				(proc0_3)
				(gEgo view: 0 x: 155 y: 160 setHeading: 0)
				(gLongSong
					number: 802
					loop: -1
					vol: 127
					flags: 1
					playBed:
				)
			)
		)
		(if (> (gEgo y?) 175) (gEgo y: 172))
		(if (!= global12 59)
			(lightning1 init: setScript: lightningScript)
			(thunder init:)
		)
		((theBuildings new:) init: onMeCheck: 8192 x: -100)
		((theBuildings new:) init: onMeCheck: 512 x: 160)
		((theBuildings new:) init: onMeCheck: 128 x: 400)
		(theFrontRubble init:)
		(theBackRubble init:)
		(theStreet init:)
		(theSuperComputer init:)
		(theArea init:)
		(thunder init:)
		(poly1 points: @local0 size: 8)
		(if (not (proc0_6 0)) (self setRegions: 701))
		(proc0_14 12)
		(super init:)
		(self setRegions: 705 addObstacle: poly1)
		(if (!= global12 59) (gEgo init:))
		(if (== global12 72)
			(gLongSong
				number: 802
				loop: -1
				vol: 127
				flags: 1
				playBed:
			)
			(proc0_3)
		)
	)
	
	(method (doit)
		(if
			(and
				(!= curPic 31)
				(not (lightning1 script?))
				(!= script ripScript)
			)
			(lightning1 init: setScript: lightningScript)
		)
		(super doit: &rest)
	)
	
	(method (newRoom newRoomNumber)
		(if (!= script ripScript)
			(super newRoom: newRoomNumber)
		)
	)
)

(instance lightningScript of Script
	(properties)
	
	(method (doit)
		(if (== (global2 curPic?) 31) (self dispose:))
		(super doit: &rest)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 10 25)))
			(1 (= seconds 3))
			(2
				(self changeState: (+ (* (Random 0 1) 2) 3) start: 0)
			)
			(3
				(lightning1 setCycle: RandCycle (Random 1 3) self)
			)
			(4
				(lightning1 setCel: 0)
				(= cycles 1)
			)
			(5
				(lightning2 init: setCycle: RandCycle (Random 3 5) self)
			)
			(6
				(lightning1 setCel: 0 setCycle: Beg self)
			)
			(7
				(lightning1 setCel: 0)
				(lightning2 dispose:)
				(= seconds 2)
			)
			(8
				(thunder play:)
				(Animate (global5 elements?) 0)
				(lightning1 dispose:)
				(self init:)
			)
		)
	)
)

(instance ripScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 1))
			(1
				(gLongSong2 number: 821 loop: -1 vol: 127 play:)
				(rip setLoop: 0 cycleSpeed: 3 init:)
				(rip setCycle: ForwardCounter 7 self)
			)
			(2
				(gLongSong2 number: 822 play:)
				(rip y: 66 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(rip setLoop: 2 setCel: 0)
				(rip setCycle: ForwardCounter 4 self)
			)
			(4
				(gEgo
					normal: 0
					x: 155
					y: 75
					yStep: 7
					view: 62
					setLoop: 3
					setCel: 0
					setCycle: 0
					setPri: 3
					ignoreActors: 1
					ignoreHorizon: 1
					init:
					setMotion: MoveTo 155 110 self
				)
			)
			(5
				(gEgo
					setStep: 3 14
					setCel: 0
					setCycle: 0
					setMotion: MoveTo 155 160 self
				)
			)
			(6
				(gLongSong2
					priority: 15
					vol: 127
					number: 115
					loop: 1
					play:
				)
				(rip setLoop: 1 setCel: 15 setCycle: Beg)
				(gEgo cycleSpeed: 0 setCycle: CT 2 1 self)
			)
			(7
				(rip dispose:)
				(= seconds 2)
			)
			(8
				(gEgo cycleSpeed: 12 setCycle: End self)
			)
			(9 (= seconds 2))
			(10
				(gEgo setCycle: CT 5 -1 self)
			)
			(11
				(gLongSong2 number: 0)
				(gEgo setLoop: 4 setCel: 0 setCycle: End self)
			)
			(12
				(gLongSong number: 802 loop: -1 flags: 1 playBed:)
				(proc0_1 2 0)
				(proc0_9)
				(= seconds 3)
			)
			(13
				(gEgo cycleSpeed: 4 setHeading: 0 self)
			)
			(14 (= seconds 1))
			(15
				(gSq4GlobalNarrator
					nMsgType: -1
					modeless: 0
					say: 1 self 0 64 30 35 67 250
				)
			)
			(16
				(gSq4GlobalNarrator say: 2 self 0 64 30 35 67 250)
			)
			(17
				(gSq4GlobalNarrator say: 3 self 0 64 30 30 67 250)
			)
			(18
				(gEgo setSpeed: 6)
				(lightningScript start: 1)
				(lightning1 init: setScript: lightningScript)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch global12
					(55
						(gEgo x: -8 setMotion: MoveTo 10 (gEgo y?) self)
					)
					(else 
						(gEgo x: 328 setMotion: MoveTo 310 (gEgo y?) self)
					)
				)
			)
			(1
				(proc0_3)
				(client setScript: 0)
			)
		)
	)
)

(instance rip of Sq4Prop
	(properties
		x 154
		y 82
		view 62
		loop 2
		cel 1
		priority 2
		signal $0010
	)
)

(instance lightning1 of Sq4Prop
	(properties
		x 124
		y 15
		view 61
	)
	
	(method (doit)
		(super doit:)
		(if (== (global2 curPic?) 31)
			(self z: 1000)
		else
			(self z: 0)
		)
	)
)

(instance lightning2 of Sq4Prop
	(properties
		x 152
		y 24
		view 61
		loop 1
		priority 6
		signal $0010
	)
	
	(method (doit)
		(super doit:)
		(if (== (global2 curPic?) 31)
			(self z: 1000)
		else
			(self z: 0)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type $0002
	)
)

(instance theFrontRubble of Sq4Feature
	(properties
		x 160
		y 300
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck $0040
		lookStr 4
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 4))
			(4 (gSq4GlobalNarrator say: 5))
			(7 (gSq4GlobalNarrator say: 6))
			(6 (gSq4GlobalNarrator say: 7))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theBackRubble of Sq4Feature
	(properties
		x 155
		y 78
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck $0010
		lookStr 8
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 8))
			(7 (gSq4GlobalNarrator say: 9))
			(6 (gSq4GlobalNarrator say: 10))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theBuildings of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		sightAngle 45
		lookStr 11
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 11))
			(7 (gSq4GlobalNarrator say: 12))
			(6 (gSq4GlobalNarrator say: 13))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theStreet of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		onMeCheck $0004
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (theArea doVerb: 1))
			(24
				((ScriptID 705 4) doVerb: 24 param2)
			)
			(7 (gSq4GlobalNarrator say: 14))
			(6 (gSq4GlobalNarrator say: 15))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theSuperComputer of Sq4Feature
	(properties
		x 160
		y 3
		nsBottom 200
		nsRight 320
		sightAngle 45
		onMeCheck $0008
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 30 say: 11)
			)
			(7 (gSq4GlobalNarrator say: 17))
			(6 (gSq4GlobalNarrator say: 17))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theArea of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 18))
			(24
				((ScriptID 705 4) doVerb: 24 param2)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance thunder of Sound
	(properties
		number 148
		priority 15
	)
)

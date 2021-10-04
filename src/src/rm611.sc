;;; Sierra Script 1.0 - (do not remove this comment)
(script# 611)
(include sci.sh)
(use Main)
(use ulence)
(use SQRoom)
(use Sq4Feature)
(use Polygon)
(use Cycle)
(use Obj)

(public
	rm611 0
)

(instance rm611 of SQRoom
	(properties
		picture 611
		horizon 90
		north 614
		west 610
	)
	
	(method (init)
		(switch gWest
			(614 (gEgo x: 195))
			(610
				(if (< (gEgo y?) 166) (gEgo y: 166))
				(gLongSong2 number: 0 vol: 0 stop:)
			)
			(else  (gEgo x: 24 y: 181))
		)
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
						189
						300
						189
						263
						189
						198
						189
						256
						182
						291
						163
						288
						149
						291
						134
						265
						86
						132
						86
						149
						101
						169
						107
						179
						124
						170
						140
						138
						158
						0
						163
					yourself:
				)
		)
		(building1 init:)
		(building2 init:)
		(graffiti init:)
		(if
		(and (== (ulence status?) 1) (> (Random 0 100) 20))
			(ulence status: 2 bikerComing: 1)
			(Load rsVIEW 633)
			(Load rsVIEW 635)
			(Load rsSOUND 50)
		)
		((ScriptID 706 7)
			init:
			nsLeft: 0
			nsTop: 55
			nsBottom: 189
			nsRight: 319
		)
		((ScriptID 706 8)
			init:
			nsLeft: 0
			nsTop: 0
			nsBottom: 55
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
					(gEgo inRect: 155 172 175 183)
				)
				(proc0_2)
				(ulence status: 3)
				((ScriptID 706 1)
					view: 633
					init:
					hide:
					posn: -30 (- (gEgo y?) 5)
					setLoop: 0
					setScript: runOver
				)
				(gEgo setScript: (ScriptID 706 5))
			)
		)
		(super doit: &rest)
	)
)

(instance runOver of Script
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
					setMotion: MoveTo 50 (- (gEgo y?) 5) self
				)
			)
			(2
				(ulence status: 4)
				(proc0_3)
				((ScriptID 706 1)
					setPri: (+ (gEgo priority?) 1)
					setMotion: MoveTo 171 (- (gEgo y?) 5) self
				)
			)
			(3
				((ScriptID 706 1) posn: 202 160 setLoop: 6)
				(= cycles 1)
			)
			(4
				((ScriptID 706 1) setMotion: MoveTo 244 141 self)
			)
			(5
				((ScriptID 706 1) posn: 250 131 setLoop: 3)
				(= cycles 1)
			)
			(6
				((ScriptID 706 1) setMotion: MoveTo 250 99 self)
			)
			(7
				((ScriptID 706 1) posn: 225 87 setLoop: 7)
				(= cycles 1)
			)
			(8
				((ScriptID 706 1) setMotion: MoveTo 179 73 self)
			)
			(9
				((ScriptID 706 1)
					setPri: 4
					setLoop: 1
					setMotion: MoveTo 46 73 self
				)
			)
			(10
				((ScriptID 706 6) fade:)
				(gLongSong fade:)
				((ScriptID 706 1) hide:)
				(= seconds 3)
			)
			(11
				(if (!= (ulence status?) 6)
					(ulence status: 1 fieldOff: 0 bikerComing: 0 egoBusy: 0)
					(gEgo setScript: 0)
					(gSq4GlobalNarrator modNum: 611 say: 1 self)
				)
				(= cycles 2)
			)
			(12 (proc0_3) (self dispose:))
		)
	)
)

(instance graffiti of Sq4Feature
	(properties
		x 30
		y 117
		nsTop 85
		nsBottom 150
		nsRight 60
		sightAngle 45
		lookStr 2
	)
)

(instance building1 of Sq4Feature
	(properties
		x 85
		y 91
		nsTop 32
		nsBottom 151
		nsRight 170
		sightAngle 45
		onMeCheck $0002
		lookStr 3
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(6 (gSq4GlobalNarrator say: 4))
			(7 (gSq4GlobalNarrator say: 5))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance building2 of Sq4Feature
	(properties
		x 137
		y 46
		nsTop 23
		nsLeft 63
		nsBottom 70
		nsRight 212
		sightAngle 45
		onMeCheck $0008
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 6))
			(6 (gSq4GlobalNarrator say: 7))
			(7 (gSq4GlobalNarrator say: 8))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

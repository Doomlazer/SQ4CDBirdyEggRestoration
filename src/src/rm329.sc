;;; Sierra Script 1.0 - (do not remove this comment)
(script# 329)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Feature)
(use MCyc)
(use n958)
(use Cycle)
(use User)
(use Obj)

(public
	rm329 0
)

(local
	[local0 21] = [0 0 164 122 0 1 166 120 0 2 168 118 0 0 170 116 0 1 172 114 -32768]
	[local21 21] = [1 0 161 125 1 1 163 123 1 2 165 121 1 3 167 119 1 4 169 117 -32768]
)
(instance rm329 of SQRoom
	(properties)
	
	(method (init)
		(Load rsPIC 803)
		(UnLoad 129 803)
		(rm329 picture: 329)
		(Load rsVIEW 330)
		(proc958_0 132 127 128)
		(theArea init:)
		(gLongSong fade: 0 2 1 1)
		(gLongSong2
			number: 127
			vol: 1
			loop: -1
			play:
			fade: 127 1 1 0
		)
		(super init:)
		(proc0_14 10)
		(self setScript: rmScript)
	)
)

(instance rmScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(gIconBar disable: 0 3 2 4 5)
				(sub init: setCycle: Fwd setMotion: MoveTo 164 122 self)
			)
			(1
				(sub setCycle: MCyc @local0)
				(gLongSong2 number: 128 vol: 127 play: hold: 1)
				(subTop init: setCycle: MCyc @local21 self)
			)
			(2
				(sub setCycle: Fwd setMotion: MoveTo 345 114)
				(subTop setMotion: MoveTo 345 117 self)
			)
			(3 (= cycles 2))
			(4
				(proc0_2)
				(if global25 (global25 dispose:))
				(global2 drawPic: 803 12)
				(global2 newRoom: 330)
			)
		)
	)
)

(instance sub of Sq4Actor
	(properties
		x 11
		y 126
		yStep 1
		view 330
		priority 2
		signal $4800
		xStep 2
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 321 say: 7)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance subTop of Sq4Actor
	(properties
		x -25
		y 117
		yStep 1
		view 330
		loop 1
		cel 4
		priority 10
		signal $4810
		xStep 2
	)
	
	(method (doVerb theVerb)
		(sub doVerb: theVerb &rest)
	)
)

(instance theArea of Sq4Feature
	(properties
		x 156
		y 88
		nsBottom 200
		nsRight 320
		sightAngle 180
		lookStr 2
	)
)

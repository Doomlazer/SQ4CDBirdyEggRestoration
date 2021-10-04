;;; Sierra Script 1.0 - (do not remove this comment)
(script# 355)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Feature)
(use MCyc)
(use Sound)
(use User)
(use Obj)

(public
	rm355 0
)

(local
	local0
	[local1 149] = [1 0 184 187 1 0 184 181 1 0 184 175 1 0 184 169 1 0 184 163 1 0 184 157 1 0 184 151 1 0 184 145 1 0 184 139 1 0 184 133 1 0 184 127 1 0 184 121 1 0 184 115 1 0 184 109 1 0 184 103 1 0 184 97 1 0 184 91 1 0 184 85 1 0 184 79 1 0 184 73 1 0 184 67 1 0 184 61 1 0 184 55 1 0 184 49 1 0 184 43 1 0 184 37 1 0 184 31 1 0 184 25 1 0 184 19 1 0 184 13 1 0 184 7 1 0 184 1 1 0 184 -5 1 0 184 -10 1 0 184 -20 1 0 184 -30 0 0 -100 -100 -32768]
	[local150 69] = [0 0 111 20 0 0 108 20 0 0 105 20 0 0 102 20 0 0 99 20 0 0 96 20 0 0 93 20 0 0 90 20 0 0 87 20 0 0 84 20 0 0 81 20 0 0 78 20 0 0 75 20 0 0 72 20 0 0 69 20 0 0 66 20 0 0 62 20 -32768]
	[local219 69] = [0 1 146 20 0 1 150 20 0 1 154 20 0 1 158 20 0 1 163 20 0 1 168 20 0 1 173 20 0 1 179 20 0 1 182 20 0 1 189 20 0 1 191 20 0 1 194 20 0 1 197 20 0 1 200 20 0 1 203 20 0 1 206 20 0 1 210 20 -32768]
)
(class mdlScript of Script
	(properties
		client 0
		state $ffff
		start 0
		timer 0
		cycles 0
		seconds 0
		lastSeconds 0
		ticks 0
		lastTicks 0
		register 0
		script 0
		caller 0
		next 0
	)
	
	(method (doit)
		(super doit:)
		(if
		(and local0 (proc999_5 ((User curEvent?) type?) 1 4))
			(proc0_12 local0)
			(= local0 (= seconds 0))
			(= cycles 1)
		)
	)
)

(instance rm355 of SQRoom
	(properties
		picture 355
	)
	
	(method (init &tmp [temp0 50])
		(proc0_2)
		(Load rsVIEW 355)
		(super init:)
		(door0 init:)
		(door1 init:)
		(carSFX init:)
		(gLongSong
			number: 355
			vol: 127
			loop: -1
			flags: 1
			playBed:
		)
		(self setScript: rmScript)
	)
)

(instance rmScript of mdlScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(carSFX play:)
				(ship init: z: 0 setCycle: MCyc @local1 self)
				(= ticks 60)
			)
			(1
				(door0 setCycle: MCyc @local150)
				(door1 setCycle: MCyc @local219)
			)
			(2 (= cycles 14))
			(3
				(carSFX fade:)
				(door0 setCycle: MCyc @local150 -1)
				(door1 setCycle: MCyc @local219 self -1)
			)
			(4
				(gLongSong fade:)
				(global5 eachElementDo: #hide)
				(global2 drawPic: 803 6)
				(= seconds 2)
			)
			(5
				(door0 dispose:)
				(door1 dispose:)
				(= cycles 1)
			)
			(6
				(proc0_14 12)
				(global2 drawPic: 119 7)
				(= cycles 1)
			)
			(7
				(gLongSong number: 48 loop: 1 vol: 127 playBed:)
				(gSq4GlobalNarrator
					modeless: 0
					returnVal: 0
					nMsgType: 3
					modNum: 355
					say: 1 self 2 64 21 40 67 275 25 global137 26 global129 27 1
				)
				(= seconds 3)
			)
			(8
				(gSq4GlobalNarrator nMsgType: -1)
				(= cycles 2)
			)
			(9 (global2 newRoom: 153))
		)
	)
)

(instance carSFX of Sound
	(properties
		number 109
	)
)

(instance door0 of Sq4Prop
	(properties
		x 111
		y 20
		view 355
		priority 4
		signal $6810
	)
	
	(method (cue)
		(super cue:)
		(self hide:)
	)
)

(instance door1 of Sq4Prop
	(properties
		x 146
		y 20
		view 355
		cel 1
		priority 4
		signal $6810
	)
	
	(method (cue)
		(super cue:)
		(self hide:)
	)
)

(instance ship of Sq4Actor
	(properties
		x 184
		y 187
		z 1000
		yStep 5
		view 355
		loop 1
		priority 5
		signal $2810
		xStep 5
	)
)

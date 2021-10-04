;;; Sierra Script 1.0 - (do not remove this comment)
(script# 59)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Feature)
(use MCyc)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm059 0
)

(local
	[local0 65] = [0 0 125 94 0 0 125 93 0 0 125 94 0 0 124 94 0 0 125 94 0 0 125 93 0 0 126 94 0 0 125 94 0 0 125 95 0 0 125 94 0 0 126 94 0 0 125 94 0 0 125 93 0 0 125 94 0 0 124 94 0 0 125 94 -32768]
)
(instance rm059 of SQRoom
	(properties
		picture 59
		style $000a
	)
	
	(method (init &tmp [temp0 50])
		(Load rsVIEW 22)
		(Load rsSOUND 110)
		(Load rsSCRIPT 942)
		(super init:)
		(proc0_2)
		(self setScript: rmScript)
		(shipBlast init:)
		(if (== global12 72)
			(ship posn: 126 256)
		else
			(ship posn: 29 -5)
		)
	)
)

(instance rmScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(proc0_14 12)
				(if (!= global12 72)
					(gLongSong
						number: 801
						loop: 1
						setVol: 127
						flags: 1
						playBed:
					)
				)
				(shipBlast number: 109 loop: 1 setVol: 127 play:)
				(ship init:)
				(= cycles 1)
			)
			(2
				(ship setMotion: MoveTo 126 94 self)
			)
			(3
				(ship setCycle: MCyc @local0 self)
			)
			(4
				(if (== global12 72)
					(ship setCycle: MCyc @local0 self)
				else
					(self cue:)
				)
			)
			(5
				(if (== global12 72) (gEgo view: 0))
				(shipBlast number: 110 loop: 1 flags: 1 play: self)
				(ship
					cycleSpeed: 2
					setCycle: End
					moveSpeed: 3
					setMotion: MoveTo 150 193 self
				)
			)
			(6 0)
			(7
				(shipBlast stop:)
				(if (== global12 72)
					(global2 newRoom: 119)
				else
					(global2 newRoom: 60)
				)
			)
		)
	)
)

(instance ship of Sq4Actor
	(properties
		yStep 4
		view 22
		signal $2000
		cycleSpeed 5
		xStep 4
	)
)

(instance shipBlast of Sound
	(properties)
)

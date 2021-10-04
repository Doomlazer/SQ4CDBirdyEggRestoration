;;; Sierra Script 1.0 - (do not remove this comment)
(script# 650)
(include sci.sh)
(use Main)
(use Sq4Feature)
(use Cycle)
(use Game)
(use Obj)

(public
	rm650 0
)

(instance rm650 of Rm
	(properties
		picture 650
	)
	
	(method (init)
		(Load rsVIEW 410)
		(pod init:)
		(gEgo
			init:
			view: 378
			setLoop: 0
			cel: 0
			posn: 106 143
			illegalBits: 0
			setPri: 13
			ignoreActors: 1
			normal: 0
			moveHead: 0
		)
		(hatch init: setPri: 14)
		(super init:)
		(self setScript: meltRoger)
	)
)

(instance meltRoger of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong2 number: 124 loop: 1 vol: 127 play: self)
			)
			(1 (= seconds 1))
			(2
				(gLongSong2 number: 142 loop: 1 play:)
				(hatch setCycle: End self)
			)
			(3
				(gLongSong2 stop:)
				(= seconds (Random 2 4))
			)
			(4
				(gEgo cel: 0 setCycle: End self)
			)
			(5
				(proc0_1 (gEgo loop?) 0)
				(gEgo setPri: 14)
				(= cycles 1)
			)
			(6 (gEgo setHeading: 135 self))
			(7
				(gEgo
					setLoop: 4
					heading: 135
					setMotion: MoveTo 110 142 self
				)
			)
			(8
				(gLongSong2 play: loop: 1)
				(hatch setCycle: Beg self)
			)
			(9
				(hatch stopUpd:)
				(gLongSong2 number: 886 loop: 1 play: setVol: 127)
				(gEgo view: 410 cel: 0 cycleSpeed: 24 setCycle: End self)
			)
			(10 (= cycles 4))
			(11 (proc0_10 5 16))
		)
	)
)

(instance hatch of Sq4Prop
	(properties
		x 80
		y 107
		view 410
		loop 2
		priority 5
		signal $6010
	)
)

(instance pod of Sq4Prop
	(properties
		x 93
		y 146
		view 410
		loop 1
		signal $6000
	)
	
	(method (init)
		(super init:)
		(self setPri: 4 addToPic:)
	)
)

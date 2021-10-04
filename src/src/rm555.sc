;;; Sierra Script 1.0 - (do not remove this comment)
(script# 555)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Narrator)
(use Sq4Feature)
(use ForwardCounter)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm555 0
)

(instance rm555 of SQRoom
	(properties
		picture 555
	)
	
	(method (init)
		(super init:)
		(Load rsVIEW 557)
		(Load rsSOUND 813)
		(holo init: hide:)
		(self setScript: realyStupidScript)
	)
)

(instance realyStupidScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_2) (= seconds 3))
			(1
				(UnLoad 129 556)
				(= cycles 3)
			)
			(2
				(aSound number: 813 loop: 1 init: play:)
				(holo show: cycleSpeed: 4 setCycle: CT 1 1 self)
			)
			(3
				(holo hide:)
				(hair init: setCycle: ForwardCounter 40)
				(= seconds 2)
			)
			(4
				(aSound stop:)
				(= seconds 1)
			)
			(5
				(tROGJR
					say: 13 self 2 64 5 20 25 global150 26 global129 27 1 67 125
				)
			)
			(6
				(tROGER
					say: 5 self 2 64 5 20 25 global140 26 global129 27 1 67 125
				)
			)
			(7
				(tROGJR
					say: 14 self 2 64 5 20 25 global150 26 global129 27 1 67 125
				)
			)
			(8
				(aSound number: 813 loop: 1 init: play:)
				(hair hide:)
				(holo show:)
				(= cycles 4)
			)
			(9
				(holo setCycle: CT 0 -1 self)
			)
			(10
				(holo dispose:)
				(UnLoad 128 557)
				(= seconds 2)
			)
			(11
				(aSound stop:)
				(global2 newRoom: 556)
			)
		)
	)
)

(instance hair of Sq4Prop
	(properties
		x 176
		y 32
		sightAngle 180
		view 557
		loop 1
		priority 7
		signal $4010
		lookStr 2
	)
)

(instance holo of Sq4Prop
	(properties
		x 167
		y 120
		sightAngle 180
		view 557
		priority 6
		signal $4010
		lookStr 4
	)
)

(instance aSound of Sound
	(properties
		number 813
	)
)

(instance tROGER of Sq4Narrator
	(properties
		noun 7
		modNum 557
		modeless 1
		talkerNum 7
	)
)

(instance tROGJR of Sq4Narrator
	(properties
		noun 31
		modNum 557
		disposeWhenDone 0
		modeless 1
		talkerNum 31
	)
)

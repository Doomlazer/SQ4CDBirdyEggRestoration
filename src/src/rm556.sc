;;; Sierra Script 1.0 - (do not remove this comment)
(script# 556)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Narrator)
(use Sq4Feature)
(use Cycle)
(use Obj)

(public
	rm556 0
)

(local
	local0
)
(instance rm556 of SQRoom
	(properties
		picture 556
		style $000a
	)
	
	(method (init)
		(super init:)
		(Load rsVIEW 1555)
		(switch gWest
			(150
				(rogerHead init:)
				(rogerJrHead init:)
				(rogerJrArm init:)
				(self setScript: holoScript)
			)
			(555
				(rogerHead init:)
				(rogerJrHead init:)
				(rogerJrArm init: show: setCel: 5)
				(self setScript: finaleScript)
			)
			(else 
				(rogerHead init:)
				(rogerJrHead init:)
				(rogerJrArm init:)
				(self setScript: holoScript)
			)
		)
	)
)

(instance holoScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_2) (= seconds 1))
			(1
				(tROGER init: 0 0 rogerHead)
				(tROGJR init: 0 0 rogerJrHead)
				(if (& global90 $0001)
					(tROGER
						say: 7 0 2 64 2 12 25 global140 26 global129 27 1 67 315
					)
					(tROGJR
						say: 20 self 2 64 2 2 25 global150 26 global129 27 1 67 315
					)
				else
					(rogerHead setCycle: End)
					(rogerJrHead setCycle: End)
					(tROGANDROGJR say: 1 self)
				)
			)
			(2
				(tROGER dispose:)
				(rogerHead setCycle: 0 show:)
				(= cycles 2)
			)
			(3
				(tROGER init: 0 0 rogerHead)
				(if (& global90 $0001)
					(tROGER
						modNum: 557
						say: 8 0 2 64 2 12 25 global140 26 global129 27 1 67 315
					)
					(tROGJR
						say: 21 self 2 64 2 2 25 global150 26 global129 27 1 67 315
					)
				else
					(rogerHead setCycle: Beg)
					(rogerJrHead setCycle: Beg)
					(tROGANDROGJR say: 2 self)
				)
			)
			(4
				(tROGER dispose:)
				(rogerHead setCycle: 0 show:)
				(= cycles 2)
			)
			(5
				(tROGER init: 0 0 rogerHead)
				(tROGJR
					say: 2 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(6
				(tROGER
					modNum: 557
					say: 2 self 2 64 2 12 25 global140 26 global129 27 1 67 315
				)
			)
			(7
				(tROGJR
					say: 3 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(8
				(tROGJR
					say: 4 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(9
				(tROGJR
					say: 5 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(10
				(tROGJR
					say: 6 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(11
				(tROGJR
					say: 7 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(12
				(tROGJR
					say: 9 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(13
				(tROGJR
					say: 10 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(14
				(tROGER
					say: 3 self 2 64 2 12 25 global140 26 global129 27 1 67 315
				)
			)
			(15
				(tROGJR
					say: 11 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(16
				(tROGER
					say: 4 self 2 64 2 12 25 global140 26 global129 27 1 67 315
				)
			)
			(17
				(tROGJR
					say: 12 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(18
				(rogerJrArm setCycle: End self)
			)
			(19 (global2 newRoom: 555))
		)
	)
)

(instance finaleScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_2) (= seconds 1))
			(1
				(rogerJrArm setLoop: 5 setCel: 0 show: setCycle: End self)
			)
			(2
				(tROGER
					init: 0 0 rogerHead
					say: 6 self 2 64 2 12 25 global140 26 global129 27 1 67 315
				)
			)
			(3
				(tROGJR
					init: 0 0 rogerJrHead
					say: 15 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(4
				(tROGJR
					say: 16 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(5
				(tROGJR
					say: 17 self 2 64 2 2 25 global150 26 global129 27 1 67 315
				)
			)
			(6
				(rogerJrArm setLoop: 6 setCel: 0 setCycle: End)
				(rogerArm init: setCycle: End)
				(= cycles 1)
			)
			(7
				(if (< (rogerArm cel?) 3) (-- state))
				(= cycles 1)
			)
			(8
				(rogerJrArm dispose:)
				(gLongSong fade:)
				(= seconds 3)
			)
			(9 (global2 newRoom: 540))
		)
	)
)

(instance rogerHead of Sq4Prop
	(properties
		x 198
		y 67
		view 1555
	)
)

(instance rogerJrHead of Sq4Prop
	(properties
		x 113
		y 66
		view 1555
		loop 1
	)
)

(instance rogerJrArm of Sq4Prop
	(properties
		x 114
		y 73
		view 1555
		loop 4
		priority 5
		signal $4010
	)
)

(instance rogerArm of Sq4Prop
	(properties
		x 189
		y 85
		view 1555
		loop 7
		priority 4
		signal $4010
	)
)

(instance tROGER of FaceTalker
	(properties
		noun 7
		modNum 557
		talkerNum 7
	)
)

(instance tROGJR of FaceTalker
	(properties
		noun 31
		modNum 557
		talkerNum 31
	)
)

(instance tROGANDROGJR of Sq4Narrator
	(properties
		noun 7
		modNum 557
		disposeWhenDone 0
		modeless 1
		talkerNum 34
	)
)

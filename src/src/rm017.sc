;;; Sierra Script 1.0 - (do not remove this comment)
(script# 17)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Narrator)
(use Sq4Feature)
(use n958)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm017 0
)

(local
	local0
)
(instance rm017 of SQRoom
	(properties
		picture 17
	)
	
	(method (init &tmp [temp0 50])
		(proc958_0 128 6 12)
		(super init:)
		(rogHead init:)
		(spArm init: stopUpd:)
		(self setScript: rmScript setRegions: 707)
	)
)

(instance rmScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
		(and (>= (gLongSong prevSignal?) 10) (== state 1))
			(self cue:)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 22 loop: -1 vol: 127 play:)
				(= seconds 3)
			)
			(1
				(spArm stopUpd: setCycle: End)
			)
			(2
				(static init: play:)
				(vohaulHolo init: setCycle: End self)
			)
			(3
				(rogHead setCel: 2 stopUpd:)
				(vohaulHolo setLoop: 1 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(4
				(vohaulHolo setLoop: 2 cel: 0)
				(tSLUDGE
					init: 0 0 vohaulHolo
					say: 1 self 2 64 100 15 67 218 25 global136 26 global129 27 1 30 68
				)
			)
			(5
				(vohaulHolo setLoop: 1 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(6
				(rogHead setCel: 1 stopUpd:)
				(vohaulHolo setLoop: 2 cel: 0)
				(tSLUDGE
					say: 2 self 2 64 100 15 67 218 25 global136 26 global129 27 1 30 68
				)
			)
			(7
				(vohaulHolo setLoop: 1 cel: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(8
				(vohaulHolo setLoop: 2 cel: 0)
				(tSLUDGE
					say: 3 self 2 64 100 15 67 218 25 global136 26 global129 27 1 30 68
				)
			)
			(9
				(vohaulHolo setLoop: 1 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(10
				(vohaulHolo setLoop: 2 cel: 0)
				(tSLUDGE
					say: 4 self 2 64 100 15 67 218 25 global136 26 global129 27 1 30 68
				)
			)
			(11
				(vohaulHolo setLoop: 1 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(12
				(vohaulHolo setLoop: 0 setCel: 16 setCycle: Beg self)
			)
			(13
				(static dispose:)
				(vohaulHolo dispose:)
				(= seconds 2)
			)
			(14
				(spArm stopUpd: setCycle: Beg self)
			)
			(15
				(Animate (global5 elements?) 0)
				(global2 newRoom: 15)
			)
		)
	)
)

(instance spArm of Sq4Prop
	(properties
		x 223
		y 109
		view 12
	)
)

(instance rogHead of Sq4Prop
	(properties
		x 61
		y 129
		view 12
		loop 1
		priority 14
		signal $0011
	)
)

(instance vohaulHolo of Sq4Prop
	(properties
		x 173
		y 91
		view 6
		signal $4000
	)
)

(instance static of Sound
	(properties
		number 111
		loop -1
	)
)

(instance tSLUDGE of FaceTalker
	(properties
		talkerNum 6
	)
)

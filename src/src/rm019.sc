;;; Sierra Script 1.0 - (do not remove this comment)
(script# 19)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Narrator)
(use Sq4Feature)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm019 0
)

(local
	[local0 7]
	local7 =  47
	local8 =  255
)
(procedure (localproc_027b param1 param2 param3 param4 &tmp temp0 temp1 temp2)
	(if (< param1 param3)
		(= temp0 (- param1 1))
		(= temp1 (+ param3 1))
	else
		(= temp0 (- param3 1))
		(= temp1 (- param1 1))
	)
	(= temp2
		(Graph
			grSAVE_BOX
			temp0
			(- param2 1)
			temp1
			(+ param4 1)
			1
		)
	)
	(Graph
		grDRAW_LINE
		param1
		param2
		param3
		param4
		(proc0_18 global133 global143)
		-1
		-1
	)
	(Graph
		grREDRAW_BOX
		temp0
		(- param2 1)
		temp1
		(+ param4 1)
	)
	(localproc_031c)
	(Wait 1)
	(Wait 2)
	(Graph grRESTORE_BOX temp2)
	(Graph
		grREDRAW_BOX
		temp0
		(- param2 1)
		temp1
		(+ param4 1)
	)
)

(procedure (localproc_031c)
	(Animate (global5 elements?) 1)
	(egoHead setCel: 1)
	(trHead setLoop: 2 setCel: 1)
	(egoMouth hide:)
	(trMouth hide:)
	(Animate (global5 elements?) 1)
	(egoHead setCel: 0)
	(trHead setCel: 0)
	(egoMouth show:)
	(trMouth show:)
)

(instance rm019 of SQRoom
	(properties
		picture 19
	)
	
	(method (init &tmp [temp0 50])
		(Load rsVIEW 1018)
		(Load rsVIEW 28)
		(Load rsSOUND 105)
		(super init:)
		(shot1 init:)
		(shot2 init:)
		(egoHead init:)
		(egoMouth init:)
		(trHead init:)
		(self setScript: startScript setRegions: 707)
	)
)

(instance startScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 2))
			(1
				(tROGER
					init: 0 0 egoMouth
					say: 1 0 2 64 5 132 67 300 25 global136 26 global129 27 0
				)
				(= seconds 1)
			)
			(2 (trHead setCycle: End self))
			(3
				(trHead setLoop: 2 setCel: 0)
				(trMouth init:)
				(= cycles 10)
			)
			(4
				(if (!= (tROGER ticks?) -1) (-- state))
				(= cycles 1)
			)
			(5
				(if (== global90 1) (egoMouth setCycle: 0))
				(= cycles 2)
			)
			(6
				(tTIMERIPPER
					init: 0 0 trMouth
					say: 1 0 2 64 138 132 67 180 25 global136 26 global129 27 1
				)
				(= seconds 2)
			)
			(7
				(egoMouth setCel: 0)
				(= cycles 1)
			)
			(8
				(if (!= (tTIMERIPPER ticks?) -1) (-- state))
				(= cycles 1)
			)
			(9
				(localproc_027b local7 local8 51 319)
				(shotSound play:)
				(shot1 posn: local8 local7 setCycle: End self)
				(egoMouth cel: 2)
				(= cycles 5)
			)
			(10
				(shot1 dispose:)
				(= cycles 2)
			)
			(11
				(= local8 (- local8 4))
				(= local7 (- local7 3))
				(localproc_027b local7 local8 51 319)
				(shotSound play:)
				(shot2 posn: local8 local7 setCycle: End self)
				(= cycles 5)
			)
			(12
				(shot2 dispose:)
				(Animate (global5 elements?) 0)
				(global2 newRoom: 20)
			)
		)
	)
)

(instance shotSound of Sound
	(properties
		number 105
	)
)

(instance shot1 of Sq4Prop
	(properties
		view 28
		priority 15
		signal $4010
	)
)

(instance shot2 of Sq4Prop
	(properties
		view 28
		priority 15
		signal $4010
	)
)

(instance egoHead of Sq4Prop
	(properties
		x 41
		y 97
		view 1018
	)
)

(instance trHead of Sq4Prop
	(properties
		x 187
		y 109
		view 1018
		loop 4
		priority 14
		signal $0010
	)
)

(instance egoMouth of Sq4Prop
	(properties
		x 53
		y 77
		view 1018
		loop 1
	)
)

(instance trMouth of Sq4Prop
	(properties
		x 181
		y 99
		view 1018
		loop 3
		priority 14
		signal $4010
	)
)

(instance tROGER of FaceTalker
	(properties
		noun 7
		talkerNum 7
		finalMouth -1
	)
)

(instance tTIMERIPPER of FaceTalker
	(properties
		noun 4
		talkerNum 4
	)
)

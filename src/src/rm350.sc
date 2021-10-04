;;; Sierra Script 1.0 - (do not remove this comment)
(script# 350)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Feature)
(use MCyc)
(use ForwardCounter)
(use n958)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm350 0
)

(local
	[local0 41] = [3 3 177 138 3 0 177 138 3 1 177 138 3 1 177 144 3 1 177 148 3 1 177 158 3 1 177 168 3 1 177 178 3 1 177 188 0 0 -100 -100 -32768]
	[local41 41] = [0 0 135 110 0 1 135 110 0 2 135 110 0 3 135 110 0 4 135 110 3 0 162 104 3 1 160 104 3 2 158 104 3 3 156 104 3 4 154 104 -32768]
	[local82 41] = [1 0 135 110 1 1 135 110 1 2 135 110 1 3 135 110 1 4 135 110 2 0 162 104 2 1 160 104 2 2 158 104 2 3 156 104 2 4 154 104 -32768]
)
(instance rm350 of SQRoom
	(properties
		picture 350
	)
	
	(method (init)
		(proc0_14 10)
		(proc958_0 128 350 351 338)
		(proc958_0 132 140 103 840)
		(bSound init:)
		(theMaw init:)
		(switch global12
			(341
				(rogerTongue init:)
				(self setScript: dieScript)
				(theMouth init:)
				(finDrip init: setScript: finDripScript)
			)
			(335
				(if (proc0_6 4)
					(rogerTongue init:)
					(self setScript: dieScript)
					(theMouth init:)
					(finDrip init: setScript: finDripScript)
					(headSwell init:)
					(steam init:)
				else
					(theMouth init:)
					(egoStruggle init: setCycle: Fwd)
					(finDrip init: setScript: finDripScript)
					(eye init: setPri: 13 setScript: grabEgoScript)
					(headSwell init:)
					(steam init:)
				)
			)
			(else 
				(theMouth init:)
				(super init:)
				(egoStruggle init: setCycle: Fwd)
				(finDrip init: setScript: finDripScript)
				(eye init: setPri: 13 setScript: grabEgoScript)
			)
		)
		(super init:)
	)
)

(instance grabEgoScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMouth setCycle: End self)
			)
			(1
				(spit init: setPri: 12 setCycle: MCyc @local0)
				(eye cel: 1)
				(tentacles init: setCycle: Fwd self)
				(= seconds 5)
			)
			(2
				(tentacles dispose:)
				(theMouth setCycle: End self)
			)
			(3
				(spit setCycle: MCyc @local0)
				(eye cel: 0)
				(tongue init: setCycle: End self)
			)
			(4 (global2 newRoom: 341))
		)
	)
)

(instance dieScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
		(and (== (self state?) 2) (== (theMouth cel?) 0))
			(aSound playBed:)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(theMouth setCel: 3)
				(if (== ((gInv at: 7) owner?) gEgo)
					(self setScript: feedSlugScript)
				else
					(proc0_2)
					(rogerTongue setCycle: MCyc @local41 self)
				)
			)
			(1
				(proc0_3)
				(rogerTongue dispose:)
				(= cycles 1)
			)
			(2
				(gLongSong stop:)
				(aSound init:)
				(theMouth setCycle: ForwardCounter 8 self)
			)
			(3
				(theMouth setCycle: Beg self)
			)
			(4
				(aSound dispose:)
				(= cycles 5)
			)
			(5
				(cSound init:)
				(theMouth setCycle: Beg)
				(cSound play:)
				(= seconds 3)
			)
			(6 (proc0_10 4 0))
		)
	)
)

(instance feedSlugScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
		(and (== (self state?) 3) (== (theMouth cel?) 0))
			(aSound playBed:)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(rogerTongue setCycle: MCyc @local82 self)
			)
			(1
				(proc0_3)
				(gIconBar curIcon: (gIconBar at: 6))
				(global1 setCursor: 964 1)
				(rogerTongue setLoop: 2 cel: 0 setCycle: Fwd)
				(= seconds 7)
			)
			(2
				(proc0_2)
				(tongue dispose:)
				(rogerTongue dispose:)
				(= cycles 1)
				(aSound init:)
			)
			(3
				(gLongSong stop:)
				(theMouth setCycle: ForwardCounter 4 self)
			)
			(4
				(theMouth setCycle: Beg self)
			)
			(5
				(aSound dispose:)
				(headSwell z: 0)
				(theMouth dispose:)
				(steam z: 0)
				(= cycles 5)
			)
			(6
				(steam setCycle: ForwardCounter 3 self)
				(bSound play:)
			)
			(7 (proc0_10 4 27))
		)
	)
)

(instance throwTankScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
		(and (== (self state?) 2) (== (theMouth cel?) 0))
			(aSound playBed:)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(rogerTongue
					setCycle: 0
					setLoop: 4
					x: 167
					y: 132
					setCycle: End self
				)
				(gEgo put: 7)
			)
			(1
				(proc0_11 48 5)
				(tongue dispose:)
				(theMouth setCycle: Beg)
				(rogerTongue x: 225 y: 136 setLoop: 5 setCycle: End self)
				(aSound init:)
			)
			(2
				(gLongSong stop:)
				(theMouth setCycle: ForwardCounter 2 self)
			)
			(3
				(aSound dispose:)
				(headSwell z: 0)
				(theMouth dispose:)
				(steam z: 0)
				(= cycles 5)
			)
			(4
				(steam setCycle: ForwardCounter 3 self)
				(bSound play:)
			)
			(5 (global2 newRoom: 335))
		)
	)
)

(instance finDripScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(finDrip setCycle: Fwd)
				(= cycles 5)
			)
		)
	)
)

(instance theMaw of Sq4Feature
	(properties
		x 151
		y 97
		nsTop 63
		nsLeft 121
		nsBottom 131
		nsRight 182
		sightAngle 90
		lookStr 1
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(15
				(global2 setScript: throwTankScript)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance aSound of Sound
	(properties
		number 140
	)
)

(instance bSound of Sound
	(properties
		number 103
		vol 100
	)
)

(instance cSound of Sound
	(properties
		number 840
	)
)

(instance egoStruggle of Sq4Prop
	(properties
		x 292
		y 97
		view 350
	)
)

(instance theMouth of Sq4Prop
	(properties
		x 148
		y 101
		sightAngle 180
		view 350
		loop 1
		lookStr 2
	)
	
	(method (doVerb theVerb)
		(theMaw doVerb: theVerb &rest)
	)
)

(instance finDrip of Sq4Prop
	(properties
		x 13
		y 187
		view 350
		loop 2
		cycleSpeed 18
		lookStr 3
	)
)

(instance spit of Sq4Prop
	(properties
		x 177
		y 138
		view 350
		loop 3
		cycleSpeed 12
		lookStr 4
	)
)

(instance eye of Sq4Prop
	(properties
		x 144
		y 82
		view 350
		loop 4
		priority 13
		lookStr 5
	)
)

(instance tongue of Sq4Prop
	(properties
		x 157
		y 99
		view 350
		loop 6
		lookStr 6
	)
	
	(method (doVerb theVerb)
		(theMaw doVerb: theVerb &rest)
	)
)

(instance tentacles of Sq4Prop
	(properties
		x 157
		y 96
		view 350
		loop 7
		lookStr 6
	)
	
	(method (doVerb theVerb)
		(theMaw doVerb: theVerb &rest)
	)
)

(instance rogerTongue of Sq4Actor
	(properties
		x 135
		y 110
		view 351
		priority 4
		signal $0010
		lookStr 7
	)
	
	(method (doVerb theVerb)
		(theMaw doVerb: theVerb &rest)
	)
)

(instance headSwell of Sq4Prop
	(properties
		x 150
		y 142
		z 1000
		sightAngle 180
		view 338
		priority 13
		signal $4010
		lookStr 8
	)
)

(instance steam of Sq4Prop
	(properties
		x 186
		y 92
		z 1000
		sightAngle 180
		view 338
		loop 1
		priority 13
		signal $4010
		lookStr 9
	)
)

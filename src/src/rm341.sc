;;; Sierra Script 1.0 - (do not remove this comment)
(script# 341)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Feature)
(use IconI)
(use Osc)
(use MCyc)
(use ForwardCounter)
(use Rev)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm341 0
)

(local
	[local0 29] = [5 0 86 157 5 0 82 156 5 0 78 155 5 0 79 151 5 0 80 148 5 0 81 144 5 0 84 144 -32768]
	[local29 29] = [6 0 160 168 6 0 166 167 6 0 173 166 6 0 174 162 6 0 176 158 6 0 177 153 6 0 174 153 -32768]
)
(instance rm341 of SQRoom
	(properties
		picture 341
		south 350
	)
	
	(method (init)
		(proc0_14 10)
		(super init:)
		(rogerFace init:)
		(leftTentacle init: setCycle: Rev)
		(rightTentacle init: setCycle: Osc)
		(egoTorso init:)
		(activator init:)
		(belt init:)
		(lSpark init:)
		(rSpark init:)
		(light1 init:)
		(light2 init:)
		(tray init:)
		(egoLegs init:)
		(theArea init:)
		(self setScript: grabScript)
	)
)

(instance grabScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_3)
				(gIconBar disable: 0)
				(grabScript register: 1)
				(rogerFace setCel: 3)
				(= seconds 5)
			)
			(1
				(belt setCycle: End self)
				(rogerFace setCel: 2)
			)
			(2
				(rightTentacle
					setLoop: 3
					setCel: 0
					x: 182
					y: 86
					cycleSpeed: 6
					setCycle: End
				)
				(leftTentacle
					setLoop: 2
					setCel: 0
					x: 109
					y: 110
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(3
				(grabScript register: 0)
				(= seconds 8)
			)
			(4 (global2 newRoom: 350))
		)
	)
)

(instance escapeScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(rogerFace setCel: 0)
				(hand init:)
				(= seconds 2)
			)
			(1
				(hand dispose:)
				(rightZap init: setCycle: MCyc @local0)
				(leftZap init: setCycle: MCyc @local29 self)
			)
			(2
				(rightZap setCycle: ForwardCounter 7 self)
				(rSpark init: setCycle: ForwardCounter 3)
				(leftZap setCycle: ForwardCounter 7)
				(lSpark init: setCycle: ForwardCounter 3)
			)
			(3
				(proc0_11 46 5)
				(= cycles 1)
			)
			(4
				(rSpark setCel: 0)
				(rightTentacle
					setLoop: 3
					setCel: 0
					x: 182
					y: 86
					setCycle: Beg
				)
				(leftTentacle
					setLoop: 2
					setCel: 0
					x: 109
					y: 110
					setCycle: Beg self
				)
			)
			(5
				(rightTentacle x: 182 y: 89 loop: 1 cel: 0 setCycle: Osc)
				(leftTentacle x: 104 y: 109 loop: 0 cel: 0 setCycle: Fwd)
				(= cycles 3)
			)
			(6 (global2 newRoom: 335))
		)
	)
)

(instance rogerFace of Sq4Prop
	(properties
		x 159
		y 40
		sightAngle 180
		view 340
		loop 3
		cel 4
		lookStr 8
	)
)

(instance aSound of Sound
	(properties
		number 200
	)
)

(instance rightZap of Sq4Prop
	(properties
		x 150
		y 150
		sightAngle 90
		view 340
		loop 6
		priority 7
		signal $0010
		lookStr 1
	)
)

(instance leftZap of Sq4Prop
	(properties
		x 130
		y 150
		sightAngle 90
		view 340
		loop 5
		priority 7
		signal $0010
		lookStr 1
	)
)

(instance belt of Sq4Prop
	(properties
		x 145
		y 82
		sightAngle 90
		view 340
		loop 8
		cycleSpeed 12
		lookStr 2
	)
)

(instance hand of Sq4Prop
	(properties
		x 118
		y 80
		view 340
		loop 4
		priority 8
	)
)

(instance leftTentacle of Sq4Prop
	(properties
		x 104
		y 109
		sightAngle 90
		view 341
		cycleSpeed 12
		lookStr 3
	)
)

(instance rightTentacle of Sq4Prop
	(properties
		x 182
		y 89
		sightAngle 90
		view 341
		loop 1
		cycleSpeed 12
		lookStr 3
	)
)

(instance activator of Sq4Feature
	(properties
		x 87
		y 79
		nsTop 70
		nsLeft 75
		nsBottom 90
		nsRight 98
		sightAngle 180
		lookStr 4
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (grabScript register?)
					(gSq4GlobalNarrator say: 5)
				else
					(proc0_2)
					(global2 setScript: escapeScript)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance light1 of Sq4Feature
	(properties
		x 104
		y 14
		nsLeft 79
		nsBottom 28
		nsRight 130
		sightAngle 180
		lookStr 6
	)
)

(instance light2 of Sq4Feature
	(properties
		x 225
		y 17
		nsLeft 201
		nsBottom 34
		nsRight 250
		sightAngle 180
		lookStr 6
	)
)

(instance tray of Sq4Feature
	(properties
		x 223
		y 71
		nsTop 62
		nsLeft 198
		nsBottom 80
		nsRight 249
		sightAngle 180
		lookStr 7
	)
)

(instance rSpark of Sq4Prop
	(properties
		x 166
		y 136
		view 28
	)
	
	(method (doit)
		(super doit: &rest)
		(if (and (not (IconBar state?)) (== cel 1))
			(aSound play:)
		)
	)
)

(instance lSpark of Sq4Prop
	(properties
		x 94
		y 125
		view 28
		priority 10
		signal $0010
	)
)

(instance egoTorso of Sq4Feature
	(properties
		x 147
		y 69
		nsTop 42
		nsLeft 121
		nsBottom 89
		nsRight 201
		sightAngle 180
		lookStr 8
	)
)

(instance theArea of Sq4Feature
	(properties
		x 156
		nsBottom 200
		nsRight 320
		sightAngle 180
		lookStr 9
	)
)

(instance egoLegs of Sq4Feature
	(properties
		x 130
		y 133
		nsTop 79
		nsLeft 96
		nsBottom 186
		nsRight 168
		sightAngle 180
		lookStr 8
	)
)

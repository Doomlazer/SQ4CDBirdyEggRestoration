;;; Sierra Script 1.0 - (do not remove this comment)
(script# 411)
(include sci.sh)
(use Main)
(use MoveToY)
(use Inertia)
(use SQRoom)
(use Sq4Feature)
(use n958)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm411 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
)
(instance rm411 of SQRoom
	(properties
		picture 411
		south 410
		west 406
	)
	
	(method (init)
		(proc0_2)
		(if (= local1 (proc0_6 20))
			(proc958_0 128 408 409 28)
			(Load rsSOUND 105)
		)
		(if (= local0 (proc0_6 19)) (blast init:))
		(self setRegions: 700)
		(switch global12
			(south
				(self setScript: enterScript 0 south style: 10)
			)
			(else 
				(self setScript: enterScript 0 west style: 12)
			)
		)
		(if (and local1 (== global12 west))
			((ScriptID 700 6) init: hide: setScript: egoFollowed)
			((ScriptID 700 7) init: hide:)
		)
		(gEgo setPri: 6 init:)
		(super init:)
		((ScriptID 700 6) show:)
		((ScriptID 700 7) show:)
		(global32 add: theMall dome eachElementDo: #init doit:)
	)
	
	(method (doit)
		(cond 
			((or script local2 (== (gEgo view?) 409)) (gEgo edgeHit: 0))
			((proc999_5 (gEgo edgeHit?) 1 2)
				(proc0_2)
				(self setScript: stayInScript 0 (gEgo edgeHit?))
			)
			((proc999_5 (gEgo edgeHit?) 3 4) (proc0_2) (self setScript: exitScript 0 (gEgo edgeHit?)))
			(
				(and
					local0
					(> (gEgo x?) 165)
					(< 12 (gEgo y?))
					(< (gEgo y?) 140)
				)
				(if (not ((ScriptID 700 6) script?))
					((ScriptID 700 6) init: setScript: (swimAndShoot new:))
				)
				(if (not ((ScriptID 700 7) script?))
					((ScriptID 700 7) init: setScript: (swimAndShoot new:))
				)
			)
		)
		(super doit: &rest)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(switch register
					((global2 west?)
						(= temp0
							(CelWide (gEgo view?) (gEgo loop?) (gEgo cel?))
						)
						((ScriptID 700 4)
							init: gEgo
							inertizing: 1
							inertia: 5
							oldDir: 90
							xOff: 1
						)
						(gEgo
							setHeading: 90
							setCycle: Swim
							x: (+ (/ temp0 2) 1)
							y: (if (< (gEgo y?) 20) 20 else (gEgo y?))
						)
						(= cycles 1)
					)
					((global2 south?)
						((ScriptID 700 4) init: gEgo)
						(= temp0
							(CelHigh (gEgo view?) (gEgo loop?) (gEgo cel?))
						)
						(gEgo
							setCycle: Swim
							x: (gEgo x?)
							y: (+ 189 temp0)
							setMotion: MoveToY (- 189 temp0) self
						)
					)
				)
			)
			(1
				(if (not ((ScriptID 700 6) script?)) (proc0_3))
				(self dispose:)
			)
		)
	)
)

(instance exitScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0 gEgoX gEgoY)
		(switch (= state newState)
			(0
				((ScriptID 700 4) dispose:)
				(if (== register 3) (= temp0 180) else (= temp0 270))
				(gEgo setHeading: temp0 self)
			)
			(1
				(if (== register 3)
					(= gEgoX (gEgo x?))
					(= gEgoY 220)
				else
					(= gEgoX -30)
					(= gEgoY (gEgo y?))
				)
				(gEgo setMotion: MoveTo gEgoX gEgoY self)
			)
			(2
				(if (== register 3) (= temp0 410) else (= temp0 406))
				(gEgo setPri: -1)
				(global2 newRoom: temp0)
			)
		)
	)
)

(instance stayInScript of Script
	(properties)
	
	(method (changeState newState &tmp gEgoX gEgoY)
		(switch (= state newState)
			(0
				((gEgo code?) xOff: 0 yOff: 0 inertia: 0)
				(if (== register 1)
					(= gEgoX (gEgo x?))
					(= gEgoY -30)
				else
					(= gEgoX 350)
					(= gEgoY (gEgo y?))
				)
				(gEgo setMotion: MoveTo gEgoX gEgoY self)
			)
			(1
				((gEgo code?) xOff: 0 yOff: 0 inertia: 0)
				(if (== register 1)
					(if (> (gEgo x?) 300) (gEgo x: 300))
					(if (< (gEgo x?) 20) (gEgo x: 20))
					(Animate (global5 elements?) 0)
					(= gEgoX (gEgo x?))
					(= gEgoY 30)
				else
					(if (> (gEgo y?) 180) (gEgo y: 180))
					(if (< (gEgo y?) 20) (gEgo y: 20))
					(Animate (global5 elements?) 0)
					(= gEgoX 290)
					(= gEgoY (gEgo y?))
				)
				(gEgo setMotion: MoveTo gEgoX gEgoY self)
			)
			(2 (proc0_3) (self dispose:))
		)
	)
)

(instance swimAndShoot of Script
	(properties)
	
	(method (doit)
		(if
			(and
				(not (global2 script?))
				(< 0 state)
				(< state 3)
				(< (- (gEgo x?) (client x?)) 82)
			)
			(client setMotion: 0 setCycle: 0)
			(= local2 1)
			(self changeState: 3)
		)
		(super doit: &rest)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client y: -1000)
				(= seconds (Random 1 4))
			)
			(1
				(if (not local1) (= local1 1) (proc0_7 20))
				(client
					view: 408
					setLoop: 0
					cel: 0
					setCycle: End
					setStep: 2 2
					x: -34
				)
				(if (== client (ScriptID 700 6))
					(client
						y: (- (gEgo y?) (Random 30 50))
						setMotion: MoveTo 42 (- (gEgo y?) 23) self
					)
				else
					(client
						y: (+ (gEgo y?) (Random 30 50))
						setMotion: MoveTo 32 (+ (gEgo y?) 15) self
					)
				)
			)
			(2 (= cycles 7))
			(3
				(if local3
					(self changeState: (- state 1))
				else
					(= local3 1)
					(client view: 409 setLoop: 0 cel: 0 setCycle: CT 1 1 self)
					(= local2
						(if
							(or
								(not (gEgo mover?))
								(== (gEgo y?) ((gEgo mover?) y?))
							)
							(not
								(if (> (gEgo y?) 180)
									((ScriptID 700 4) inertia?)
								else
									0
								)
							)
						else
							0
						)
					)
				)
			)
			(4
				(= local7 (proc999_3 1 (- (client y?) 4)))
				(= local6 (+ (client x?) 46))
				(= local9 (proc999_2 188 (proc999_3 2 (gEgo y?))))
				(= local8
					(if local2
						(proc999_2 (gEgo x?) 318)
					else
						(Random 312 318)
					)
				)
				(if (< local7 local9)
					(= local4 local7)
					(= local5 local9)
				else
					(= local4 local9)
					(= local5 local7)
				)
				(= local3
					(Graph
						grSAVE_BOX
						(- local4 1)
						(- local6 1)
						(+ local5 1)
						(+ local8 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local7
					local6
					local9
					local8
					(proc0_18 global133 global143)
					1
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local4 1)
					(- local6 1)
					(+ local5 1)
					(+ local8 1)
					1
				)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(5
				(Graph grRESTORE_BOX local3)
				(Graph
					grREDRAW_BOX
					(- local4 1)
					(- local6 1)
					(+ local5 1)
					(+ local8 1)
					1
				)
				(= local3 0)
				(blast cel: 0 posn: local8 local9 setCycle: End)
				(client
					setLoop: 2
					cel: 0
					setCycle: Fwd
					setStep: 2 1
					cycleSpeed: 0
					setMotion: MoveTo -36 (- (client y?) 6) self
				)
				(if local2
					(proc0_2)
					((ScriptID 700 4) inertia: 0)
					(gEgo
						view: 409
						setLoop: 4
						cel: 0
						setMotion: 0
						setCycle: Fwd
					)
				)
			)
			(6
				(if local2 (proc0_10 8 14) else (client dispose:))
			)
		)
	)
)

(instance egoFollowed of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 700 7)
					view: 408
					setLoop: 1
					posn: 280 168
					setStep: 1 1
					setMotion: MoveTo 190 130
					cycleSpeed: 1
					setCycle: Fwd
				)
				((ScriptID 700 6)
					view: 408
					setLoop: 1
					cel: 0
					setCycle: Fwd
					setStep: 2 2
					posn: 210 (- (gEgo y?) 6)
					setMotion: MoveTo 182 (gEgo y?) self
				)
			)
			(1
				((ScriptID 700 7) cycleSpeed: 2 moveSpeed: 1)
				((ScriptID 700 6)
					view: 409
					setLoop: 1
					cel: 0
					setCycle: CT 1 1 self
				)
				(proc0_2)
			)
			(2
				(= local4 (- ((ScriptID 700 6) y?) 4))
				(= local6 (- ((ScriptID 700 6) x?) 46))
				(= local5 (proc999_2 188 (gEgo y?)))
				(= local8 (proc999_3 2 (gEgo x?)))
				(= local3
					(Graph
						grSAVE_BOX
						(- local4 1)
						(- local8 1)
						(+ local5 1)
						(+ local6 1)
						1
					)
				)
				(Graph
					grDRAW_LINE
					local4
					local6
					local5
					local8
					(proc0_18 global133 global143)
					1
					-1
				)
				(Graph
					grREDRAW_BOX
					(- local4 1)
					(- local8 1)
					(+ local5 1)
					(+ local6 1)
					1
				)
				(aSound number: 105 loop: 1 vol: 127 play:)
				(= cycles 1)
			)
			(3
				(Graph grRESTORE_BOX local3)
				(Graph
					grREDRAW_BOX
					(- local4 1)
					(- local8 1)
					(+ local5 1)
					(+ local6 1)
					1
				)
				(blast cel: 0 posn: local8 local5 setCycle: End)
				((ScriptID 700 6)
					setLoop: 2
					cel: 0
					setCycle: Fwd
					setStep: 2 1
					cycleSpeed: 0
					setStep: 4 3
					setMotion: MoveTo 320 (- ((ScriptID 700 6) y?) 6)
				)
				(gEgo view: 409 setLoop: 5 cel: 0 setCycle: Fwd)
				(= cycles 22)
			)
			(4 (proc0_10 8 15))
		)
	)
)

(instance blast of Sq4Prop
	(properties
		view 28
	)
)

(instance dome of Sq4Feature
	(properties
		x 190
		sightAngle 180
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 406 say: 1)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (onMe)
		(return 1)
	)
)

(instance theMall of Sq4Feature
	(properties
		x 110
		y 80
		sightAngle 180
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 405 say: 7)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (onMe param1)
		(return (& (OnControl 4 (param1 x?) (param1 y?)) $0002))
	)
)

(instance aSound of Sound
	(properties)
)

;;; Sierra Script 1.0 - (do not remove this comment)
(script# 709)
(include sci.sh)
(use Main)
(use Sq4Feature)
(use Cycle)
(use Game)
(use Obj)

(public
	rgLanding 0
	fallScript 1
)

(local
	local0
	local1
	local2
	local3
)
(instance rgLanding of Rgn
	(properties)
	
	(method (init)
		(super init:)
		(Load rsVIEW 120)
		(Load rsPIC 120)
		(global32
			add: theCityView turbines theRoom
			eachElementDo: #init
			doit:
		)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			((global2 script?) ((global2 script?) doit:))
			((proc0_5 gEgo 4) (proc0_2) (global2 setScript: fallScript))
		)
	)
	
	(method (newRoom newRoomNumber)
		(= keep (proc999_5 newRoomNumber 530 535 540))
		(= initialized 0)
		(super newRoom: newRoomNumber)
	)
)

(instance fallScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch global11
					(530
						(= local0 236)
						(= local1 26)
						(= local2 56)
						(= local3 43)
					)
					(535
						(= local0 304)
						(= local1 10)
						(= local2 84)
						(= local3 114)
					)
					(540
						(= local0 242)
						(= local1 55)
						(= local2 58)
						(= local3 213)
					)
				)
				(= cycles 1)
			)
			(1
				(gSq4GlobalNarrator modNum: 709 say: 1)
				(proc0_2)
				(gLongSong2 number: 131 vol: 127 loop: 1 play:)
				(gEgo
					view: 300
					setLoop:
					setCycle: 0
					setStep: 3 20
					illegalBits: 0
					setMotion: MoveTo (gEgo x?) 250 self
				)
			)
			(2
				(global5 eachElementDo: #hide)
				(global2 drawPic: 120 100)
				(gEgo
					show:
					view: 120
					x:
						(+
							(/
								(* (/ (* (- (gEgo x?) local1) 100) local0) local2)
								100
							)
							local3
						)
					y: 90
					setLoop: 3
					setCycle: Fwd
					setPri: 15
					cel: 0
					setStep: 2 6
					heading: 180
				)
				(= cycles 1)
			)
			(3
				(gEgo setMotion: MoveTo (gEgo x?) 210 self)
			)
			(4
				(gLongSong2 fade:)
				(= seconds 1)
			)
			(5 (proc0_10 0 22))
		)
	)
)

(instance theCityView of Sq4Feature
	(properties
		x 153
		y 89
		heading 179
		nsTop 166
		nsBottom 189
		nsRight 319
		sightAngle 90
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 709 say: 2)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theRoom of Sq4Feature
	(properties
		x 160
		nsBottom 200
		nsRight 320
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(switch global11
					(530
						(gSq4GlobalNarrator modNum: 709 say: 3)
					)
					(535
						(gSq4GlobalNarrator modNum: 709 say: 4)
					)
					(540
						(gSq4GlobalNarrator modNum: 709 say: 5)
					)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance turbines of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		sightAngle 180
		onMeCheck $0080
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 709 say: 6)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

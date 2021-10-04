;;; Sierra Script 1.0 - (do not remove this comment)
(script# 702)
(include sci.sh)
(use Main)
(use Sq4Feature)
(use IconI)
(use PolyPath)
(use Rev)
(use Cycle)
(use Game)
(use InvI)
(use Obj)

(public
	sewer 0
	theDeathScript 1
	theSlime 2
	theDrip 3
	theSlimeScript 4
	theDrip1 5
	theDrip2 6
)

(local
	local0
	gEgoX_2
	gEgoY_2
	[local3 52]
	local55
	local56
	local57
	local58
	gEgoX
	gEgoY
	local61
	local62
	local63
	local64
	local65
	local66
	local67
)
(procedure (localproc_0406)
	(cond 
		((== (theSlime loop?) 3)
			(= local55 (- (theSlime x?) 9))
			(= local56 (- (theSlime y?) 27))
			(= local57 (- (theSlime x?) 9))
			(= local58 (+ (theSlime y?) 26))
			(sewer distance: (localproc_0922))
			(= local55 (- (theSlime x?) 9))
			(= local56 (- (theSlime y?) 27))
			(= local57 (+ (theSlime x?) 9))
			(= local58 (- (theSlime y?) 27))
			(if
			(< (= local61 (localproc_0922)) (sewer distance?))
				(sewer distance: local61)
			)
			(= local55 (+ (theSlime x?) 9))
			(= local56 (- (theSlime y?) 27))
			(= local57 (+ (theSlime x?) 9))
			(= local58 (+ (theSlime y?) 26))
			(if
			(< (= local61 (localproc_0922)) (sewer distance?))
				(sewer distance: local61)
			)
			(= local55 (- (theSlime x?) 9))
			(= local56 (+ (theSlime y?) 26))
			(= local57 (+ (theSlime x?) 9))
			(= local58 (+ (theSlime y?) 26))
			(if
			(< (= local61 (localproc_0922)) (sewer distance?))
				(sewer distance: local61)
			)
		)
		((== (theSlime loop?) 2)
			(= local55 (- (theSlime x?) 35))
			(= local56 (- (theSlime y?) 5))
			(= local57 (- (theSlime x?) 35))
			(= local58 (+ (theSlime y?) 6))
			(sewer distance: (localproc_0922))
			(= local55 (- (theSlime x?) 35))
			(= local56 (- (theSlime y?) 5))
			(= local57 (+ (theSlime x?) 35))
			(= local58 (- (theSlime y?) 5))
			(if
			(< (= local61 (localproc_0922)) (sewer distance?))
				(sewer distance: local61)
			)
			(= local55 (+ (theSlime x?) 35))
			(= local56 (- (theSlime y?) 5))
			(= local57 (+ (theSlime x?) 35))
			(= local58 (+ (theSlime y?) 6))
			(if
			(< (= local61 (localproc_0922)) (sewer distance?))
				(sewer distance: local61)
			)
			(= local55 (+ (theSlime x?) 35))
			(= local56 (+ (theSlime y?) 6))
			(= local57 (- (theSlime x?) 35))
			(= local58 (+ (theSlime y?) 6))
			(if
			(< (= local61 (localproc_0922)) (sewer distance?))
				(sewer distance: local61)
			)
		)
		((== (theSlime loop?) 0)
			(= local55 (- (theSlime x?) 28))
			(= local56 (+ (theSlime y?) 15))
			(= local57 (+ (theSlime x?) 9))
			(= local58 (- (theSlime y?) 17))
			(sewer distance: (localproc_0922))
			(= local55 (- (theSlime x?) 28))
			(= local56 (+ (theSlime y?) 15))
			(= local57 (- (theSlime x?) 10))
			(= local58 (+ (theSlime y?) 21))
			(if
			(< (= local61 (localproc_0922)) (sewer distance?))
				(sewer distance: local61)
			)
			(= local55 (- (theSlime x?) 10))
			(= local56 (+ (theSlime y?) 21))
			(= local57 (+ (theSlime x?) 23))
			(= local58 (- (theSlime y?) 9))
			(if
			(< (= local61 (localproc_0922)) (sewer distance?))
				(sewer distance: local61)
			)
			(= local55 (+ (theSlime x?) 9))
			(= local56 (- (theSlime y?) 17))
			(= local57 (+ (theSlime x?) 23))
			(= local58 (- (theSlime y?) 9))
			(if
			(< (= local61 (localproc_0922)) (sewer distance?))
				(sewer distance: local61)
			)
		)
		((== (theSlime loop?) 1)
			(= local55 (- (theSlime x?) 24))
			(= local56 (- (theSlime y?) 9))
			(= local57 (+ (theSlime x?) 13))
			(= local58 (+ (theSlime y?) 23))
			(sewer distance: (localproc_0922))
			(= local55 (- (theSlime x?) 24))
			(= local56 (- (theSlime y?) 9))
			(= local57 (- (theSlime x?) 8))
			(= local58 (- (theSlime y?) 17))
			(if
			(< (= local61 (localproc_0922)) (sewer distance?))
				(sewer distance: local61)
			)
			(= local55 (- (theSlime x?) 8))
			(= local56 (- (theSlime y?) 17))
			(= local57 (+ (theSlime x?) 28))
			(= local58 (+ (theSlime y?) 16))
			(if
			(< (= local61 (localproc_0922)) (sewer distance?))
				(sewer distance: local61)
			)
			(= local55 (+ (theSlime x?) 13))
			(= local56 (+ (theSlime y?) 23))
			(= local57 (+ (theSlime x?) 28))
			(= local58 (+ (theSlime y?) 16))
			(if
			(< (= local61 (localproc_0922)) (sewer distance?))
				(sewer distance: local61)
			)
		)
	)
)

(procedure (localproc_0922 &tmp temp0)
	(return
		(if
			(and
				(<=
					0
					(localproc_09cc
						(- local57 local55)
						(- local58 local56)
						(- gEgoX local55)
						(- gEgoY local56)
					)
				)
				(<=
					0
					(localproc_09cc
						(- local55 local57)
						(- local56 local58)
						(- gEgoX local57)
						(- gEgoY local58)
					)
				)
			)
			(return
				(if
				(= temp0 (GetDistance local55 local56 local57 local58))
					(/
						(Abs
							(localproc_09cc
								(- local58 local56)
								(- local55 local57)
								(- gEgoX local55)
								(- gEgoY local56)
							)
						)
						temp0
					)
				else
					0
				)
			)
		else
			(return
				(proc999_2
					(GetDistance gEgoX gEgoY local55 local56)
					(GetDistance gEgoX gEgoY local57 local58)
				)
			)
		)
	)
)

(procedure (localproc_09cc param1 param2 param3 param4)
	(return
		(if (< (sewer distance?) 200)
			(return (+ (* param1 param3) (* param2 param4)))
		else
			(return
				(+
					(* (+ (/ param1 2) 1) (+ (/ param3 2) 1))
					(* (+ (/ param2 2) 1) (+ (/ param4 2) 1))
				)
			)
		)
	)
)

(class sewer of Rgn
	(properties
		script 0
		number 0
		modNum 702
		noun 0
		timer 0
		keep 0
		initialized 0
		regionVer 22891
		roomVer 0
		location 0
		cantDie 0
		status 0
		distance 0
		prevDistance 0
		oldDistance 0
		angle 0
		scoopLoop 0
		rmTimer 0
		dbg 0
	)
	
	(method (init)
		(super init: &rest)
		(Load rsVIEW 75)
		(Load rsVIEW 76)
		(Load rsVIEW 4)
		(Load rsSOUND 806)
		(Load rsSOUND 805)
		(Load rsSOUND 819)
		(sewer cantDie: 0)
		(if (proc999_5 global11 75 80 85 105 115)
			(thePipes init:)
			(theConduit init:)
			(theVent
				init:
				x:
				(switch global11
					(75 77)
					(80 158)
					(85 242)
					(105 131)
					(115 188)
				)
				y:
				(switch global11
					(75 81)
					(80 40)
					(85 80)
					(else  2)
				)
			)
		else
			(thePipes init:)
			(theConduit init:)
		)
		(if (not (sewer location?)) (theSlime posn: 1000 1000))
	)
	
	(method (doit &tmp temp0)
		(super doit:)
		(if (!= local64 (GetTime 1))
			(= local64 (GetTime 1))
			(= local65 1)
		)
		(if local65
			(= local65 0)
			(self rmTimer: (++ local67))
			(if (== (self status?) 4)
				(++ local66)
				(if (and (not (sewer cantDie?)) (> local66 5))
					(proc0_2)
					(gSq4GlobalNarrator modNum: 702 say: 1)
					(global2 setScript: theDeathScript)
				)
			)
		)
		(= gEgoX (gEgo x?))
		(= gEgoY (gEgo y?))
		(if
		(and (!= (theSlime x?) 1000) (!= (theSlime y?) 1000))
			(localproc_0406)
		)
		(sewer
			angle: (GetAngle
				(gEgo x?)
				(gEgo y?)
				(theSlime x?)
				(theSlime y?)
			)
		)
		(if
			(and
				(< (sewer distance?) 5)
				(== (sewer status?) 4)
				(not local0)
				(not (sewer cantDie?))
			)
			(global2 setScript: theDeathScript)
			(sewer status: 6)
		)
		(if
		(and (> (sewer distance?) 17) (== (sewer status?) 4))
			(sewer status: 3)
			(theSlime setScript: theSlimeScript)
			(= local66 0)
		)
		(if
			(and
				(< (sewer status?) 7)
				(> (sewer distance?) 0)
				(< (sewer distance?) 9)
				(== (sewer status?) 3)
				(== (sewer location?) global11)
				(not (sewer cantDie?))
			)
			(sewer status: 4)
			(theSlime setScript: 0 setCycle: Fwd setMotion: 0)
		)
	)
	
	(method (newRoom newRoomNumber)
		(= keep
			(proc999_5 newRoomNumber 75 80 85 90 95 100 105 110 115)
		)
		(= initialized 0)
		(theSlime setCycle: 0 setMotion: 0)
		(super newRoom: newRoomNumber &rest)
		(= local67 0)
		(self
			oldDistance: (sewer prevDistance?)
			prevDistance: (sewer distance?)
		)
	)
)

(instance theDrip of Sq4Actor
	(properties
		yStep 1
		view 75
		signal $6800
		illegalBits $0000
		xStep 1
		lookStr 2
	)
	
	(method (init)
		(super init:)
		(Load rsSCRIPT 969)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 702 say: 2)
			)
			(else  (super doVerb: &rest))
		)
	)
)

(instance theDeathScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(== (self state?) 4)
				(<= (gLongSong prevSignal?) -1)
			)
			(self cue:)
		)
	)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(sewer status: 7)
				(gLongSong2 vol: 0 loop: 1 fade: 0 10 10 0)
				(gLongSong vol: 127 number: 818 loop: 1 playBed:)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					cycleSpeed: 6
					setMotion: 0
					setLoop: -1
					setHeading: 180 self
				)
			)
			(1
				(theSlime
					moveSpeed: (- global199 2)
					cycleSpeed: 3
					setStep: 3 3
				)
				(switch (theSlime loop?)
					(2
						(theSlime
							setMotion: MoveTo (gEgo x?) (- (gEgo y?) 3) self
						)
					)
					(else 
						(theSlime setMotion: MoveTo (gEgo x?) (gEgo y?) self)
					)
				)
				(gEgo view: 76 setLoop: 0 setCel: 0)
			)
			(2
				(theSlime cycleSpeed: 4)
				(gEgo cycleSpeed: 5 setCycle: End self)
			)
			(3
				(gEgo cycleSpeed: 7 setLoop: 1 setCycle: End self)
			)
			(4
				(theSlime setCycle: Fwd)
				(gEgo hide:)
			)
			(5
				(gLongSong number: 0 vol: 0 stop:)
				(gLongSong2 number: 0 vol: 0 stop:)
				(self dispose:)
				(proc0_10 3 13)
			)
		)
	)
)

(instance theSlime of Sq4Actor
	(properties
		view 75
		signal $6800
		illegalBits $0000
		xStep 2
		lookStr 3
	)
	
	(method (init)
		(if (== (gLongSong2 vol?) 0)
			(gLongSong vol: 0 fade: 0 10 10 0)
			(gLongSong2 vol: 127 play:)
		)
		(self
			setCycle: Fwd
			cycleSpeed: 6
			moveSpeed: (- global199 2)
			script: 0
		)
		(super init:)
	)
	
	(method (dispose)
		(super dispose:)
		(= local67 0)
		(if
			(and
				(!= (sewer location?) global11)
				(== (sewer status?) 3)
			)
			(if (gLongSong2 number?)
				(gLongSong2 vol: 0 fade: 0 10 10 0)
			)
			(if (gLongSong number?) (gLongSong vol: 127 playBed:))
		)
		(if (!= (sewer status?) 3)
			(if (gLongSong2 number?)
				(gLongSong2 vol: 0 fade: 0 10 10 0)
			)
			(if (gLongSong number?) (gLongSong vol: 127 playBed:))
		)
		(self setMotion: 0 setCycle: 0)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 702 say: 3)
			)
			(4
				(switch (sewer status?)
					(4
						(proc0_2)
						(gSq4GlobalNarrator modNum: 702 say: 4)
						(gEgo setMotion: PolyPath (theSlime x?) (theSlime y?))
					)
					(3
						(gSq4GlobalNarrator modNum: 702 say: 5)
					)
					(else 
						(gSq4GlobalNarrator modNum: 702 say: 6)
					)
				)
			)
			(13
				(if (== ((Inv at: 5) cel?) 2)
					(gSq4GlobalNarrator modNum: 702 say: 8)
				else
					(Load rsVIEW 81)
					(Load rsSOUND 820)
					(switch (sewer status?)
						(4
							(global2 setScript: scoopScript)
						)
						(3
							(switch global11
								(90
									(cond 
										(
											(and
												(& (gEgo onControl: 1) $0002)
												(== (theSlime loop?) 0)
											)
											(cond 
												((< (theSlime y?) 70) (gSq4GlobalNarrator modNum: 702 say: 9))
												((> (theSlime y?) 100) (gSq4GlobalNarrator modNum: 702 say: 10))
												(else (global2 setScript: scoopScript))
											)
										)
										((> (sewer distance?) 10) (gSq4GlobalNarrator modNum: 702 say: 11))
										(else
											(switch (Random 0 1)
												(0
													(gSq4GlobalNarrator modNum: 702 say: 13)
												)
												(1
													(gSq4GlobalNarrator modNum: 702 say: 12)
												)
											)
										)
									)
								)
								(95
									(cond 
										(
											(and
												(& (gEgo onControl: 1) $0002)
												(== (theSlime loop?) 3)
											)
											(cond 
												((< (theSlime y?) 60) (gSq4GlobalNarrator modNum: 702 say: 9))
												((> (theSlime y?) 110) (gSq4GlobalNarrator modNum: 702 say: 10))
												(else (global2 setScript: scoopScript))
											)
										)
										((> (sewer distance?) 10) (gSq4GlobalNarrator modNum: 702 say: 11))
										(else
											(switch (Random 0 1)
												(0
													(gSq4GlobalNarrator modNum: 702 say: 13)
												)
												(1
													(gSq4GlobalNarrator modNum: 702 say: 12)
												)
											)
										)
									)
								)
								(100
									(cond 
										(
											(and
												(& (gEgo onControl: 1) $0002)
												(== (theSlime loop?) 1)
											)
											(cond 
												((< (theSlime y?) 75) (gSq4GlobalNarrator modNum: 702 say: 9))
												((> (theSlime y?) 95) (gSq4GlobalNarrator modNum: 702 say: 10))
												(else (global2 setScript: scoopScript))
											)
										)
										((> (sewer distance?) 10) (gSq4GlobalNarrator modNum: 702 say: 11))
										(else
											(switch (Random 0 1)
												(0
													(gSq4GlobalNarrator modNum: 702 say: 13)
												)
												(1
													(gSq4GlobalNarrator modNum: 702 say: 12)
												)
											)
										)
									)
								)
								(115
									(if
										(and
											(& (gEgo onControl: 1) $0002)
											(> (theSlime y?) 105)
											(== (theSlime loop?) 1)
										)
										(global2 setScript: scoopScript)
									else
										(gSq4GlobalNarrator modNum: 702 say: 14)
									)
								)
								(105
									(if
										(and
											(& (gEgo onControl: 1) $0002)
											(> (theSlime y?) 105)
											(== (theSlime loop?) 0)
										)
										(global2 setScript: scoopScript)
									else
										(gSq4GlobalNarrator modNum: 702 say: 14)
									)
								)
								(else 
									(switch (Random 1 4)
										(1
											(gSq4GlobalNarrator modNum: 702 say: 15)
										)
										(2
											(gSq4GlobalNarrator modNum: 702 say: 16)
										)
										(3
											(gSq4GlobalNarrator modNum: 702 say: 17)
										)
										(4
											(gSq4GlobalNarrator modNum: 702 say: 18)
										)
									)
								)
							)
						)
						(else 
							(gSq4GlobalNarrator modNum: 702 say: 19)
						)
					)
				)
			)
			(7
				(gSq4GlobalNarrator modNum: 702 say: 20)
			)
			(6
				(gSq4GlobalNarrator modNum: 702 say: 21)
			)
			(
				(proc999_5
					theVerb
					8
					9
					10
					11
					12
					14
					15
					16
					17
					18
					19
					20
					21
					22
					23
				)
				(gSq4GlobalNarrator modNum: 702 say: 7)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (setSpeed)
		(= moveSpeed (- global199 2))
	)
)

(instance scoopScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gSq4GlobalNarrator modNum: 706 say: 12 self)
			)
			(1
				(theSlime moveSpeed: 5)
				(= local0 1)
				(sewer status: 5)
				(= gEgoX_2 (gEgo x?))
				(= gEgoY_2 (gEgo y?))
				(gEgo
					normal: 0
					cycleSpeed: 12
					illegalBits: 0
					ignoreActors: 1
				)
				(cond 
					(
					(or (> (sewer angle?) 270) (< (sewer angle?) 20))
						(sewer scoopLoop: 3)
						(gEgo setLoop: -1 setHeading: 315 self)
					)
					(
					(and (> (sewer angle?) 19) (< (sewer angle?) 100))
						(sewer scoopLoop: 4)
						(gEgo setLoop: -1 setHeading: 45 self)
					)
					(
					(and (> (sewer angle?) 99) (< (sewer angle?) 190))
						(sewer scoopLoop: 1)
						(gEgo setLoop: -1 setHeading: 135 self)
					)
					(
					(and (> (sewer angle?) 189) (< (sewer angle?) 271))
						(sewer scoopLoop: 0)
						(gEgo setLoop: -1 setHeading: 225 self)
					)
				)
			)
			(2
				(= register (gEgo loop?))
				(gEgo
					view: 81
					cel: 0
					cycleSpeed: 18
					setLoop: (sewer scoopLoop?)
					setCycle: CT 2 1 self
				)
			)
			(3
				(gLongSong vol: 127 number: 820 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo setMotion: MoveTo gEgoX_2 gEgoY_2 self)
			)
			(5 (= cycles 5))
			(6
				(proc0_11 74 5)
				(= cycles 5)
			)
			(7
				(gLongSong number: 805 loop: -1 vol: 0 fade: 0 10 10 0)
				(= local66 0)
				(proc0_3)
				(gSq4GlobalNarrator modNum: 702 say: 22)
				((gInv at: 5) cel: 2 cursor: 953)
				((IconBar at: 6) cursor: 953)
				(proc0_1 register 0)
				(theSlime ignoreActors: 0 moveSpeed: (- global199 2))
				(gLongSong2 vol: 127 number: 819 loop: -1 playBed:)
				(= seconds 3)
			)
			(8
				(= local0 0)
				(theSlime ignoreActors: 1)
				(sewer status: 4)
				(self dispose:)
			)
		)
	)
)

(instance thePipes of Sq4Feature
	(properties
		y 10
		nsBottom 200
		nsRight 320
		onMeCheck $0010
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 702 say: 23)
			)
			(4
				(gSq4GlobalNarrator modNum: 702 say: 24)
			)
			(7
				(switch (Random 0 1)
					(0
						(gSq4GlobalNarrator modNum: 702 say: 25)
					)
					(1
						(gSq4GlobalNarrator modNum: 702 say: 26)
					)
				)
			)
			(6
				(gSq4GlobalNarrator modNum: 702 say: 27)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theConduit of Sq4Feature
	(properties
		y 10
		nsBottom 200
		nsRight 320
		onMeCheck $0022
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 702 say: 28)
			)
			(7
				(gSq4GlobalNarrator modNum: 702 say: 29)
			)
			(6
				(switch (Random 0 1)
					(0
						(gSq4GlobalNarrator modNum: 702 say: 30)
					)
					(1
						(gSq4GlobalNarrator modNum: 702 say: 31)
					)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theVent of Sq4Feature
	(properties
		y 10
		nsBottom 200
		nsRight 320
		onMeCheck $0040
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 80 say: 1)
			)
			(7
				(gSq4GlobalNarrator modNum: 702 say: 32)
			)
			(6
				(gSq4GlobalNarrator modNum: 702 say: 33)
			)
			(4
				(gSq4GlobalNarrator modNum: 702 say: 34)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theDrip1 of Sq4Prop
	(properties
		view 80
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: 1)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 702 say: 35)
			)
			(4
				(gSq4GlobalNarrator modNum: 702 say: 36)
			)
			(7
				(gSq4GlobalNarrator modNum: 702 say: 38)
			)
			(6
				(gSq4GlobalNarrator modNum: 702 say: 39)
			)
			(
				(proc999_5
					theVerb
					8
					9
					10
					11
					12
					13
					14
					15
					16
					17
					18
					19
					20
					21
					22
					23
				)
				(gSq4GlobalNarrator modNum: 702 say: 37)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theDrip2 of Sq4Prop
	(properties
		view 80
	)
	
	(method (init)
		(super init:)
		(self ignoreActors: 1)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 702 say: 35)
			)
			(4
				(gSq4GlobalNarrator modNum: 702 say: 36)
			)
			(7
				(gSq4GlobalNarrator modNum: 702 say: 38)
			)
			(6
				(gSq4GlobalNarrator modNum: 702 say: 39)
			)
			(
				(proc999_5
					theVerb
					8
					9
					10
					11
					12
					13
					14
					15
					16
					17
					18
					19
					20
					21
					22
					23
				)
				(gSq4GlobalNarrator modNum: 702 say: 37)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theSlimeScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
		(and (== register 1) (< (sewer distance?) 20))
			(= register 0)
			(self init:)
		)
	)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(switch global11
					(75
						(= local62 8)
						(= local63 207)
					)
					(80
						(if (== (theSlime loop?) 2)
							(= local62 360)
							(= local63 91)
						else
							(= local62 158)
							(= local63 227)
						)
					)
					(85
						(= local62 311)
						(= local63 209)
					)
					(90
						(switch (theSlime loop?)
							(2
								(if (> (gEgo x?) (theSlime x?))
									(= local62 358)
									(= local63 89)
								else
									(= local62 192)
									(= local63 89)
								)
							)
							(else 
								(if
								(and (< (gEgo y?) 50) (< (gEgo y?) (theSlime y?)))
									(= local62 274)
									(= local63 -8)
								else
									(= local62 30)
									(= local63 195)
								)
							)
						)
					)
					(95
						(switch (theSlime loop?)
							(2
								(switch gWest
									(100
										(if (< (gEgo x?) (theSlime x?))
											(= local62 218)
											(= local63 89)
										else
											(= local62 359)
											(= local63 89)
										)
									)
									(90
										(if (< (gEgo x?) (theSlime x?))
											(= local62 -40)
											(= local63 89)
										else
											(= local62 98)
											(= local63 89)
										)
									)
								)
							)
							(else 
								(= local62 158)
								(= local63 220)
							)
						)
					)
					(100
						(switch (theSlime loop?)
							(2
								(if (< (gEgo x?) (theSlime x?))
									(= local62 -39)
									(= local63 91)
								else
									(= local62 120)
									(= local63 89)
								)
							)
							(else 
								(= local62 312)
								(= local63 211)
							)
						)
					)
					(105
						(switch (theSlime loop?)
							(0
								(if (< (gEgo y?) (theSlime y?))
									(= local62 225)
									(= local63 -7)
								else
									(= local62 94)
									(= local63 111)
								)
							)
							(2
								(switch gWest
									(110
										(if (> (gEgo x?) (theSlime x?))
											(= local62 337)
											(= local63 125)
										else
											(= local62 118)
											(= local63 125)
										)
									)
									(else 
										(= local62 337)
										(= local63 125)
									)
								)
							)
						)
					)
					(110
						(switch (theSlime loop?)
							(2
								(if (< (gEgo x?) (theSlime x?))
									(= local62 -30)
									(= local63 125)
								else
									(= local62 337)
									(= local63 125)
								)
							)
							(3
								(if (< (gEgo y?) (theSlime y?))
									(= local62 158)
									(= local63 -18)
								else
									(= local62 158)
									(= local63 109)
								)
							)
						)
					)
					(115
						(switch (theSlime loop?)
							(1
								(if (< (gEgo x?) (theSlime x?))
									(= local62 85)
									(= local63 -10)
								else
									(= local62 233)
									(= local63 113)
								)
							)
							(2
								(if (< (gEgo x?) (theSlime x?))
									(= local62 -36)
									(= local63 127)
								else
									(= local62 183)
									(= local63 127)
								)
							)
						)
					)
				)
				(theSlime
					setPri: 1
					setCycle: Fwd
					setMotion: MoveTo local62 local63 self
				)
			)
			(1
				(theSlime setCycle: Rev)
				(switch global11
					(80 (self dispose:))
					(90
						(cond 
							((< (theSlime y?) 0) (sewer location: 75))
							((== (theSlime loop?) 2) (theSlime setMotion: MoveTo 358 89 self))
							(else
								(sewer location: 105)
								(theSlime dispose:)
								(self dispose:)
							)
						)
					)
					(95
						(if (== (theSlime loop?) 2)
							(if (== gWest 100)
								(theSlime setMotion: MoveTo 352 91 self)
							else
								(= register 1)
								(theSlime setMotion: MoveTo -32 89 self)
							)
						else
							(sewer location: 110)
							(theSlime posn: 1000 1000 dispose:)
							(self dispose:)
						)
					)
					(100
						(if (== (theSlime loop?) 2)
							(theSlime setMotion: MoveTo -30 89 self)
						else
							(if (< (gEgo y?) 100)
								(sewer location: 0 status: 0)
							else
								(sewer location: 115)
							)
							(theSlime dispose:)
							(self dispose:)
						)
					)
					(105
						(switch (theSlime loop?)
							(0
								(theSlime setMotion: MoveTo 139 70 self)
							)
							(2
								(switch gWest
									(110
										(if (== local62 118)
											(self init:)
										else
											(sewer location: 110 status: 6)
											(theSlime dispose:)
											(self dispose:)
										)
									)
									(else 
										(= register 1)
										(theSlime setMotion: MoveTo 118 125 self)
									)
								)
							)
						)
					)
					(110
						(if (== (theSlime loop?) 3)
							(= register 1)
							(theSlime setMotion: MoveTo 158 -21 self)
						else
							(sewer location: 115 status: 6)
							(theSlime posn: 1000 1000 dispose:)
							(self dispose:)
						)
					)
					(115
						(switch (theSlime loop?)
							(2
								(theSlime setMotion: MoveTo -27 125 self)
							)
							(else 
								(theSlime setMotion: MoveTo 191 82 self)
							)
						)
					)
					(else 
						(theSlime dispose:)
						(self dispose:)
					)
				)
			)
			(2
				(switch global11
					(90
						(sewer location: 95)
						(theSlime dispose:)
						(self dispose:)
					)
					(100
						(sewer location: 95 status: 6)
						(theSlime dispose:)
						(self dispose:)
					)
					(105
						(= register 1)
						(theSlime setMotion: MoveTo 225 -7 self)
					)
					(110
						(if (== (theSlime loop?) 3)
							(if (or (< (gEgo x?) 60) (> (gEgo x?) 250))
								(sewer location: 0 status: 0)
							else
								(if (< (sewer distance?) 60) (sewer status: 6))
								(sewer location: 95 rmTimer: 0)
							)
							(= register 0)
							(= cycles 1)
						)
					)
					(115
						(switch (theSlime loop?)
							(2
								(if (or (> (gEgo x?) 206) (< (gEgo y?) 114))
									(sewer location: 0 status: 0)
								else
									(sewer location: 110 prevDistance: (+ (gEgo x?) 25))
								)
								(theSlime dispose:)
								(self dispose:)
							)
							(else 
								(= register 1)
								(theSlime setMotion: MoveTo 87 -7 self)
							)
						)
					)
					(else  (self cue:))
				)
			)
			(3
				(= register 0)
				(switch global11
					(95 (sewer location: gWest))
					(105
						(switch (theSlime loop?)
							(0
								(sewer location: 90 rmTimer: 0)
								(theSlime posn: 1000 1000)
							)
							(2 (sewer location: 110))
						)
					)
					(115
						(sewer location: 100)
						(cond 
							((< (gEgo y?) 70) (sewer prevDistance: 1))
							((< (gEgo y?) 105) (sewer prevDistance: 2))
							((> (gEgo x?) 190) (sewer prevDistance: 3))
							((> (Random 0 100) 50) (sewer status: 8))
							(else (sewer prevDistance: 4))
						)
					)
				)
				(theSlime dispose:)
				(self dispose:)
			)
		)
	)
)

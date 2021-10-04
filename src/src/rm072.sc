;;; Sierra Script 1.0 - (do not remove this comment)
(script# 72)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Feature)
(use RandCycle)
(use n958)
(use Jump)
(use Cycle)
(use Obj)

(public
	rm072 0
)

(local
	local0 =  282
	local1 =  56
	local2 =  291
	local3 =  62
	[local4 2] = [277 62]
	local6 =  195
	local7 =  54
	local8 =  325
	local9 =  72
)
(instance rm072 of SQRoom
	(properties
		picture 72
	)
	
	(method (init &tmp theJump)
		(proc0_2)
		(proc958_0 128 73 72)
		(Load rsSOUND 109)
		(switch global12
			(45
				(if (proc0_6 0)
					(Load rsSOUND 73)
				else
					(Load rsSOUND 77)
				)
				(proc0_2)
				(self setScript: shipLeaves)
			)
			(90
				(proc958_0 132 123 811)
				(if (proc0_6 16)
					(ship x: 267 y: 45 init:)
					(gear x: 267 y: 45 cel: 5 init:)
					(manhole setMotion: MoveTo 117 144 manhole)
					(gLongSong2 number: 123 loop: 1 vol: 127 flags: 0 play:)
					(gEgo z: 1000 init:)
					(proc0_2)
					(manholeScript start: 19)
					(self setScript: manholeScript)
				else
					(= theJump Jump)
					(Load rsSOUND 72)
					(proc0_2)
					(self setScript: manholeScript)
				)
			)
			(60
				(proc958_0 132 123 811)
				(if (proc0_6 16)
					(ship x: 267 y: 45 init:)
					(gear x: 267 y: 45 cel: 5 init:)
					(manhole setMotion: MoveTo 117 144 manhole)
					(gLongSong2 number: 123 loop: 1 vol: 127 flags: 0 play:)
					(gEgo z: 1000 init:)
					(proc0_2)
					(manholeScript start: 19)
					(self setScript: manholeScript)
				else
					(= theJump Jump)
					(Load rsSOUND 72)
					(proc0_2)
					(self setScript: manholeScript)
				)
			)
			(else 
				(proc958_0 132 75 76)
				(proc0_7 18)
				(= theJump Jump)
				(proc0_2)
				(proc0_8 0)
				(self setScript: xenonLanding)
			)
		)
		(theGreenBldg init:)
		(theWhiteBldg init:)
		(theManhole init:)
		(manhole init:)
		(manholeFeature init:)
		(theRoom init:)
		(rogersHead init:)
		(super init:)
	)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(== (global2 script?) manholeScript)
				(gEgo mover?)
			)
			(proc0_2)
			(global2 setScript: goto40Script)
		)
	)
	
	(method (dispose)
		(DisposeScript 991)
		(super dispose:)
	)
	
	(method (newRoom newRoomNumber)
		(switch newRoomNumber
			(40 (gLongSong2 fade:))
			(90 (gLongSong fade:))
		)
		(if (== newRoomNumber 90)
			(proc0_7 16)
		else
			(proc0_8 16)
		)
		(super newRoom: newRoomNumber)
		(gEgo z: 0)
	)
)

(instance manholeScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
		(and (== state 2) (>= (gLongSong prevSignal?) 128))
			(self cue:)
		)
		(if
		(and (== state 5) (>= (gLongSong prevSignal?) 129))
			(self cue:)
		)
		(if
		(and (== state 10) (>= (gLongSong prevSignal?) 130))
			(self cue:)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (proc0_2) (= seconds 3))
			(1
				(proc0_2)
				(gLongSong number: 72 loop: 1 vol: 127 flags: 0 playBed:)
				(manhole setMotion: MoveTo 117 144 self)
				(gLongSong2 number: 123 loop: 1 vol: 127 flags: 0 play:)
			)
			(2
				(proc0_2)
				(if
					(or
						(< (gLongSong prevSignal?) 1)
						(> (gLongSong prevSignal?) 128)
					)
					(self cue:)
				)
			)
			(3
				(manhole stopUpd:)
				(gEgo z: 1000 init:)
				(gLongSong2 number: 109 loop: 1 flags: 1 play:)
				(ship init: setMotion: MoveTo 267 24)
				(dust init: cycleSpeed: 18 setCycle: End self)
			)
			(4
				(dust loop: 1 cycleSpeed: 12 setCycle: RandCycle)
				(ship setMotion: MoveTo 267 24 self)
			)
			(5
				(if
					(or
						(< (gLongSong prevSignal?) 1)
						(> (gLongSong prevSignal?) 129)
					)
					(self cue:)
				)
			)
			(6
				(ship setMotion: MoveTo (ship x?) 45)
				(gear
					posn: (ship x?) (ship y?)
					init:
					setCycle: End
					setMotion: MoveTo (ship x?) 45
				)
				(= cycles 1)
			)
			(7
				(dust cycleSpeed: 6 setCycle: RandCycle)
				(= cycles 4)
			)
			(8
				(ship setCel: 0)
				(= cycles 25)
			)
			(9 (= cycles 30))
			(10
				(dust dispose:)
				(gLongSong2 fade:)
				(if
					(or
						(< (gLongSong prevSignal?) 1)
						(> (gLongSong prevSignal?) 130)
					)
					(self cue:)
				)
			)
			(11
				(proc0_3)
				(sp2 init:)
				(sp3 init:)
				(sp4 init:)
				(sp1
					posn: local0 local1
					setLoop: 3
					init:
					setMotion: JumpTo local2 local3 self
				)
			)
			(12
				(sp1
					setStep: 2 2
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo local6 local7
				)
				(= cycles 6)
			)
			(13
				(sp2
					posn: local0 local1
					setLoop: 3
					setMotion: JumpTo local2 local3 self
				)
			)
			(14
				(sp2
					setStep: 2 2
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo local6 local7
				)
				(= cycles 10)
			)
			(15
				(sp3
					posn: local0 local1
					setMotion: JumpTo local2 local3 self
				)
			)
			(16
				(sp4
					posn: local0 local1
					setMotion: JumpTo local2 local3 self
				)
				(sp3
					setStep: 2 2
					setCycle: Walk
					setMotion: MoveTo local8 local9
				)
			)
			(17
				(sp4
					setStep: 2 2
					setCycle: Walk
					setMotion: MoveTo local8 local9 self
				)
			)
			(18 (= seconds 15))
			(19 (= seconds 10))
			(20
				(gSq4GlobalNarrator say: 1)
				(manhole
					yStep: 2
					setMotion: MoveTo (manhole x?) (+ (manhole y?) 8)
				)
				(= seconds 3)
			)
			(21
				(manhole
					setMotion: MoveTo (manhole x?) (+ (manhole y?) 12) self
				)
				(= seconds 3)
			)
			(22
				(proc0_2)
				(gSq4GlobalNarrator say: 2)
				(manhole
					yStep: 12
					setMotion: MoveTo (manhole x?) 188 self
				)
			)
			(23
				(gLongSong2 number: 811 loop: 1 vol: 127 flags: 0 play:)
				(= cycles 1)
			)
			(24 (global2 newRoom: 90))
		)
	)
)

(instance xenonLanding of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(manhole stopUpd:)
				(= seconds 2)
			)
			(1
				(gLongSong2 number: 109 loop: 1 vol: 100 flags: 0 play:)
				(ship init: setMotion: MoveTo 267 24)
				(dust init: cycleSpeed: 18 setCycle: End self)
			)
			(2
				(gLongSong number: 75 loop: 1 vol: 127 flags: 0 play:)
				(dust loop: 1 cycleSpeed: 12 setCycle: Fwd)
				(ship setMotion: MoveTo 267 24 self)
			)
			(3 (= cycles 20))
			(4
				(ship setMotion: MoveTo (ship x?) 45)
				(gear
					posn: (ship x?) (ship y?)
					init:
					setCycle: End
					setMotion: MoveTo (ship x?) 45
				)
				(= cycles 1)
			)
			(5 (= cycles 4))
			(6
				(ship setCel: 0)
				(= cycles 25)
			)
			(7
				(gLongSong2 fade:)
				(= cycles 30)
				(gLongSong number: 76 loop: 1 vol: 127 flags: 1 playBed:)
			)
			(8
				(dust dispose:)
				(= cycles 8)
			)
			(9
				(sp1
					init:
					setLoop: 3
					setStep: 2 2
					moveSpeed: global199
					cycleSpeed: (* global199 2)
					setCycle: Walk
					x: local6
					y: local7
					setMotion: MoveTo local2 local3
				)
				(= cycles 12)
			)
			(10
				(sp2
					init:
					setLoop: 3
					setStep: 2 2
					moveSpeed: global199
					cycleSpeed: (* global199 2)
					setCycle: Walk
					x: local6
					y: local7
					setMotion: MoveTo local2 local3 self
				)
			)
			(11
				(sp1
					moveSpeed: 1
					setLoop: 2
					setMotion: JumpTo local0 (- local1 4) sp1
				)
				(= cycles 12)
			)
			(12
				(sp2
					moveSpeed: 1
					setLoop: 2
					setMotion: JumpTo local0 (- local1 4) sp2
				)
				(= cycles 1)
			)
			(13
				(sp3
					init:
					x: local8
					y: local9
					setLoop: 2
					setStep: 2 2
					moveSpeed: global199
					cycleSpeed: (* global199 2)
					setCycle: Walk
					setMotion: MoveTo local2 local3
				)
				(= cycles 12)
			)
			(14
				(sp4
					init:
					x: local8
					y: local9
					setLoop: 2
					setStep: 2 2
					setCycle: Walk
					moveSpeed: global199
					cycleSpeed: (* global199 2)
					setMotion: MoveTo local2 local3 self
				)
			)
			(15
				(sp3
					moveSpeed: 1
					setMotion: JumpTo local0 (- local1 4) sp3
				)
				(= cycles 12)
			)
			(16
				(sp4
					moveSpeed: 1
					setMotion: JumpTo local0 (- local1 4) sp4
				)
				(= cycles 12)
			)
			(17 (gLongSong fade: self) 0)
			(18
				(gLongSong2
					number: 802
					loop: -1
					vol: 127
					flags: 1
					playBed:
				)
				(global2 newRoom: 45)
			)
		)
	)
)

(instance shipLeaves of Script
	(properties)
	
	(method (doit &tmp [temp0 5])
		(gear x: (ship x?) y: (- (ship y?) 1))
		(if
		(and (== state 0) (== (gLongSong2 prevSignal?) 128))
			(self cue:)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(manhole stopUpd:)
				(gLongSong number: 109 loop: 1 vol: 100 flags: 0 play:)
				(if (proc0_6 0)
					(gLongSong2 number: 73 loop: 1 vol: 127 flags: 0 playBed:)
				else
					(gLongSong2 number: 77 loop: 1 vol: 127 flags: 1 playBed:)
					(= cycles 30)
				)
				(ship x: 267 y: 45 moveSpeed: 1 init:)
				(dust loop: 1 init: cycleSpeed: 12 setCycle: Fwd)
			)
			(1
				(if (not (proc0_6 18)) (gLongSong fade:))
				(if (proc0_6 0) (gLongSong2 hold: 1))
				(ship setMotion: MoveTo (ship x?) -10 self)
			)
			(2
				(dust loop: 0 cel: 9 cycleSpeed: 12 setCycle: Beg self)
				(if (proc0_6 18) (gLongSong2 number: 0 stop:))
			)
			(3
				(if (proc0_6 18)
					(proc0_8 18)
					(gLongSong fade:)
					(global2 newRoom: 60)
					(self dispose:)
				else
					(global2 newRoom: 59)
					(self dispose:)
				)
			)
		)
	)
)

(instance sewerScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(manhole setMotion: MoveTo (manhole x?) 188 self)
			)
			(1
				(gLongSong2 number: 811 loop: 1 vol: 127 flags: 0 play:)
				(= cycles 1)
			)
			(2 (global2 newRoom: 90))
		)
	)
)

(instance manholeFeature of Sq4Feature
	(properties
		x 160
		y 186
		nsBottom 200
		nsRight 320
		onMeCheck $0002
		lookStr 3
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (!= (global2 script?) xenonLanding)
					(proc0_2)
					(global2 setScript: sewerScript)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance manhole of Sq4Actor
	(properties
		x 117
		y 186
		yStep 4
		view 72
		loop 4
		signal $0800
	)
	
	(method (cue)
		(proc0_3)
		(manhole stopUpd:)
	)
)

(instance ship of Sq4Actor
	(properties
		x 210
		y -6
		yStep 1
		view 72
		priority 4
		signal $6810
		xStep 1
		lookStr 4
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (== (global2 script?) xenonLanding)
					(global2 newRoom: 45)
				else
					(gSq4GlobalNarrator say: 5)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance gear of Sq4Actor
	(properties
		yStep 1
		view 72
		loop 1
		priority 5
		signal $6810
		xStep 1
	)
)

(instance dust of Sq4Prop
	(properties
		x 213
		y 52
		view 73
		priority 3
		signal $6010
	)
)

(instance sp1 of Sq4Actor
	(properties
		yStep 1
		view 72
		loop 2
		priority 6
		signal $4810
		xStep 1
	)
	
	(method (cue)
		(super cue:)
		(self dispose:)
	)
)

(instance sp2 of Sq4Actor
	(properties
		yStep 1
		view 72
		loop 2
		priority 6
		signal $4810
		xStep 1
	)
	
	(method (cue)
		(super cue:)
		(self dispose:)
	)
)

(instance sp3 of Sq4Actor
	(properties
		yStep 1
		view 72
		loop 3
		priority 6
		signal $4810
		xStep 1
	)
	
	(method (cue)
		(super cue:)
		(self dispose:)
	)
)

(instance sp4 of Sq4Actor
	(properties
		yStep 1
		view 72
		loop 3
		priority 6
		signal $4810
		xStep 1
	)
	
	(method (cue)
		(super cue:)
		(self dispose:)
	)
)

(instance theGreenBldg of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		onMeCheck $0010
		lookStr 6
	)
)

(instance theWhiteBldg of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		onMeCheck $0020
		lookStr 7
	)
)

(instance theManhole of Sq4Feature
	(properties
		x 120
		y 187
		nsBottom 200
		nsRight 320
		onMeCheck $0040
		lookStr 8
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(manholeFeature doVerb: theVerb)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance rogersHead of Sq4Feature
	(properties
		x 120
		y 188
		nsBottom 189
		nsRight 319
		sightAngle 45
		onMeCheck $0004
		lookStr 9
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gSq4GlobalNarrator say: 10))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theRoom of Sq4Feature
	(properties
		x 152
		nsBottom 189
		nsRight 319
		sightAngle 180
		lookStr 11
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(proc0_2)
				(global2 setScript: goto40Script)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance goto40Script of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(if (and (not (proc0_6 73)) (== state 0))
			(self cue:)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_11 73 3)
				(gLongSong2 fade:)
				(= seconds 4)
			)
			(1 (global2 newRoom: 40))
		)
	)
)

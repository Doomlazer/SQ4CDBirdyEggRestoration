;;; Sierra Script 1.0 - (do not remove this comment)
(script# 397)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Narrator)
(use Sq4Feature)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Cycle)
(use Obj)

(public
	rm397 0
)

(local
	local0
	local1
	[local2 2]
	local4
	[local5 2]
	local7
	smelledWall
	[local8 300]
)
(instance rm397 of SQRoom
	(properties
		picture 397
		style $000a
		south 395
		lookStr 1
	)
	
	(method (init)
		(= local7 global34)
		(= global34 0)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						189
						0
						0
						319
						0
						319
						189
						306
						189
						298
						180
						197
						176
						181
						145
						297
						145
						269
						113
						254
						113
						223
						117
						93
						117
						66
						112
						41
						112
						31
						144
						133
						144
						114
						178
						17
						178
						7
						189
					yourself:
				)
		)
		(gLongSong number: 0 stop:)
		(gLongSong2 vol: 127 changeState:)
		(proc0_3)
		(clerkHead posn: 161 70 setPri: 8 init:)
		(clerk posn: 160 85 init:)
		(super init:)
		(self setRegions: 700)
		(birdyFeature init:) ;easter egg restore
		(displayCase init:)
		(shelf1 init:)
		(shelf2 init:)
		(bin1 init:)
		(bin2 init:)
		(box init:) ;easter egg restore
		(gEgo x: 160 y: 180 init:)
		(if (== global12 398) (gEgo posn: 127 163))
		(if (== global12 395)
			(global2 setScript: walkIn)
		else
			(global2 setScript: clerkScript)
		)
	)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(& (gEgo onControl: 1) $4000)
				(!= global160 0)
				(!= local0 1)
				(not (proc0_6 31))
			)
			(= local0 1)
			(global2 setScript: yell)
		)
		(if
			(and
				(& (gEgo onControl: 1) $2000)
				(!= global160 0)
				(!= local1 1)
				(not (proc0_6 31))
			)
			(= local1 1)
			(global2 setScript: yell)
		)
		(if
			(and
				(& (gEgo onControl: 1) $0200)
				(not local4)
				(!= global160 0)
				(not (proc0_6 31))
			)
			(= local4 1)
			(global2 setScript: buyBox)
		)
		(if
			(and
				(not (& (gEgo onControl: 1) $0200))
				(== local4 1)
			)
			(= local4 0)
		)
	)
	
	(method (dispose)
		(= global34 local7)
		(super dispose:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 1))
			;(6 (proc0_16))
			;(7 (proc0_16))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance walkIn of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo posn: 160 200)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 160 170 self)
			)
			(2
				(proc0_3)
				(client setScript: clerkScript)
				(self dispose:)
			)
		)
	)
)

(instance clerkScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0 (proc0_2) (= cycles 1))
			(1
				(cond 
					(
						(and
							(not (proc0_6 31))
							(!= global160 0)
							(== global12 398)
						)
						(tCLERK say: 5 self)
					)
					((and (== global12 398) (proc0_6 31)) (tCLERK say: 6 self))
					((== global12 398) (tCLERK say: 7 self))
					(else (tCLERK say: 8 self))
				)
			)
			(2
				(if (!= global12 398)
					(= temp0 (Random 0 2))
					(tCLERK
						say:
						(switch (= temp0 (Random 0 2))
							(0 9)
							(1 10)
							(2 11)
						) self
					)
					(= seconds 30)
				else
					(self cue:)
				)
			)
			(3
				(proc0_3)
				(clerkHead setCycle: 0 stopUpd: cel: 0)
				(clerk setCycle: 0 cel: 0 setScript: 0)
				(client setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance buyBox of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(tCLERK say: 1 self)
			)
			(1
				(proc0_3)
				(clerkHead setCycle: 0 cel: 0)
				(clerk setCycle: 0 cel: 0 setScript: 0)
				(client setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance yell of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0)
				(proc0_2)
				(cond 
					((and (== local0 1) (== local1 1)) (tCLERK say: 2 self))
					((proc999_5 (gEgo view?) 373 374) (tCLERK say: 3 self))
					(else (tCLERK say: 4 self))
				)
			)
			(1
				(clerk setCycle: 0 cel: 0)
				(clerkHead setCycle: 0 cel: 0)
				(proc0_3)
				(client setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance talk2 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: PolyPath 160 160 self)
			)
			(1
				(otherGuy
					init:
					loop: 1
					illegalBits: 0
					posn: 250 130
					setStep: 4 2
					setCycle: Fwd
					setMotion: MoveTo 10 130
				)
				(= cycles 10)
			)
			(2
				(myGuy
					init:
					loop: 2
					illegalBits: 0
					posn: 300 115
					setCycle: Fwd
					setMotion: MoveTo 120 115 self
				)
			)
			(3
				(otherGuy setCycle: 0)
				(myGuy setMotion: 0 view: 409 loop: 1 setCycle: Fwd)
				(= seconds 4)
			)
			(4
				(myGuy
					view: 408
					loop: 1
					setMotion: MoveTo 0 115 self
					setCycle: Fwd
				)
			)
			(5 (proc0_3) (self dispose:))
		)
	)
)

(instance birdy of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (!= (gEgo loop?) 2)
			(clerk loop: 0 cel: 0)
			(clerkHead loop: 2 setCycle: RandCycle cycleSpeed: 20)
			(self dispose:)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(clerkHead setCycle: 0 loop: 3 cel: 1)
				(clerk setCycle: 0 loop: 3 cel: 0)
				(= seconds 3)
			)
			(1
				(clerkHead loop: 4 cycleSpeed: 0 setCycle: Fwd)
				(clerk loop: 0 cel: 0)
				(= cycles (Random 20 40))
			)
			(2
				(clerkHead loop: 2 setCycle: RandCycle cycleSpeed: 20)
				(= seconds 10)
			)
			(3 (self dispose:))
		)
	)
)

(instance sayThankYou of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(tCLERK say: 12 self)
			)
			(1 (proc0_3) (self dispose:))
		)
	)
)

(instance clerk of Sq4Prop
	(properties
		view 397
	)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(not (self script?))
				(== (clerkHead loop?) 2)
				(== (gEgo loop?) 2)
				(== (Random 0 100) 1)
				smelledWall
			)
			(if (not (global2 script?)) 
				(global2 setScript: birdy)
			)
		)
	)	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(global2 setScript: clerkScript)
			)
			(8
				(cond 
					((not global160) (gSq4GlobalNarrator say: 2))
					((proc0_6 31) (gSq4GlobalNarrator say: 3))
					((< global159 5) (global2 setScript: buyBox))
					(else
						(self setScript: sayThankYou)
						(if (< (= global159 (- global159 5)) 1) (gEgo put: 0))
						(proc0_11 85 5)
						(proc0_7 31)
					)
				)
			)
			(1 (gSq4GlobalNarrator say: 4))
			(6 (gSq4GlobalNarrator say: 5))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance clerkHead of Sq4Prop
	(properties
		view 397
		loop 1
	)
	
	(method (doit)
		(super doit:)
		(cond 
			((or (clerk script?) (global2 script?)) 0)
			((> (gEgo y?) 168) (self setCycle: 0 loop: 1 cel: 11))
			(
			(and (not (& (gEgo onControl: 1) $0200)) (not cycler)) (self setCycle: RandCycle loop: 2 cycleSpeed: 126))
			((& (gEgo onControl: 1) $0200) (self setCycle: 0 loop: 1 cel: 0))
		)
	)
	
	(method (doVerb theVerb param2)
		(clerk doVerb: theVerb param2)
	)
)

(instance goBox of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 135 162 self)
			)
			(1 (gEgo loop: 5) (= cycles 5))
			(2 (global2 newRoom: 398))
		)
	)
)

(instance displayCase of Sq4Feature
	(properties
		x 157
		y 94
		nsTop 80
		nsLeft 45
		nsBottom 109
		nsRight 269
		sightAngle 90
		lookStr 6
	)
)

(instance bin1 of Sq4Feature
	(properties
		x 89
		y 135
		nsTop 129
		nsLeft 68
		nsBottom 141
		nsRight 111
		sightAngle 90
		lookStr 7
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (global2 setScript: goBox))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bin2 of Sq4Feature
	(properties
		x 78
		y 144
		nsTop 141
		nsLeft 49
		nsBottom 148
		nsRight 107
		sightAngle 90
		lookStr 7
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (global2 setScript: goBox))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shelf1 of Sq4Feature
	(properties
		x 161
		y 58
		nsTop 42
		nsLeft 63
		nsBottom 74
		nsRight 260
		sightAngle 90
		lookStr 6
	)
)

(instance otherGuy of Sq4Actor
	(properties
		view 382
	)
)

(instance myGuy of Sq4Actor
	(properties
		view 408
	)
)

(instance shelf2 of Sq4Feature
	(properties
		x 53
		y 63
		nsTop 51
		nsLeft 45
		nsBottom 76
		nsRight 61
		sightAngle 90
		lookStr 6
	)
)
(instance birdyFeature of Sq4Feature 
	(properties
		x 9
		y 33
		nsTop 28
		nsBottom 38
		nsRight 19
		noun 99
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(6
				(if (not (global2 script?))
					;(proc0_12 {Ah! Yeaa!})
					;(gSq4GlobalNarrator say: 8)
					(++ smelledWall)
					(self dispose:)
				)
			)
		)
	)
)
(instance tROG of Sq4Talker
	(properties
		z 400
		noun 7
		view 1008
		talkerNum 7
		mouthOffsetX 22
		mouthOffsetY 31
		eyeOffsetX 27
		eyeOffsetY 21
	)
)

(instance tCLERK of Sq4Talker
	(properties
		z 400
		noun 9
		view 1708
		talkerNum 9
		mouthOffsetX 21
		mouthOffsetY 36
		eyeOffsetX 25
		eyeOffsetY 18
	)
)
(instance box of Sq4Feature
	(properties
		x 307
		y 35
		nsTop 30
		nsLeft 296
		nsBottom 40
		nsRight 319
		noun 99
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(7
				(if (not (gEgo script?)) ;set script on ego, not room to avoid lockup- DL
					(gEgo setScript: talk2)
				)
			)
		)
	)
)
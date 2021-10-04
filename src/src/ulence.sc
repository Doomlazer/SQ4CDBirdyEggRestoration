;;; Sierra Script 1.0 - (do not remove this comment)
(script# 706)
(include sci.sh)
(use Main)
(use Sq4Narrator)
(use Sq4Feature)
(use PolyPath)
(use n958)
(use SysWindow)
(use Sound)
(use Cycle)
(use Game)
(use Obj)

(public
	ulence 0
	theBiker 1
	theZapScript 2
	theDeathScript 3
	theDodgeR 4
	theDodgeL 5
	theBikeSound 6
	theSand 7
	theDunes 8
	tRoger 9
)

(local
	local0
	local1
	local2
)
(class ulence of Rgn
	(properties
		script 0
		number 0
		modNum -1
		noun 0
		timer 0
		keep 0
		initialized 0
		beenInBar 0
		status 0
		deathLoop 0
		fieldOff 0
		bikerComing 0
		saveWindow 0
		egoBusy 0
	)
	
	(method (init)
		(if (!= gSq4Win Sq1Window)
			(= saveWindow gSq4Win)
			(= gSq4Win Sq1Window)
		)
		(super init: &rest)
		(proc0_14 1)
		(Load rsVIEW 636)
		(proc958_0 132 135 58 50)
		(forceField init:)
		(if (== global11 610)
			(forceField x: 52 y: 178 sightAngle: 90)
		)
		(if (not (proc999_5 global11 615 620))
			(gLongSong number: 58 loop: -1 vol: 127 play:)
		)
	)
	
	(method (doit &tmp temp0)
		(super doit:)
		(cond 
			(script 0)
			(
				(and
					(== (gEgo edgeHit?) 3)
					(proc999_5 global11 609 610 611)
					(== (ulence fieldOff?) 0)
				)
				(proc0_2)
				(gEgo setMotion: 0 y: (- (gEgo y?) 2))
				(= local0 1)
				(global2 setScript: theZapScript)
				(theZapScript init:)
			)
			(
				(and
					(& (gEgo onControl: 1) $2000)
					(not local0)
					(== (ulence fieldOff?) 0)
				)
				(proc0_2)
				(gEgo setMotion: 0)
				(switch global11
					(611
						(gEgo x: (- (gEgo x?) 2))
					)
					(612
						(if (and (> (gEgo x?) 185) (< (gEgo y?) 123))
							(gEgo y: (+ (gEgo y?) 2))
						else
							(gEgo y: (+ (gEgo y?) 2) x: (+ (gEgo x?) 2))
						)
					)
					(613
						(gEgo y: (+ (gEgo y?) 2))
					)
					(614
						(gEgo x: (- (gEgo x?) 4))
					)
				)
				(= local0 1)
				(global2 setScript: theZapScript)
			)
			((and (& (gEgo onControl: 1) $1000) local0) (= local0 0))
		)
	)
	
	(method (dispose)
		(= gSq4Win saveWindow)
		(super dispose:)
	)
	
	(method (newRoom newRoomNumber)
		(= keep
			(proc999_5 newRoomNumber 609 610 611 612 613 614 615 620)
		)
		(= initialized 0)
		(super newRoom: newRoomNumber &rest)
	)
)

(class Sq1Window of SysWindow
	(properties
		top 0
		left 0
		bottom 0
		right 0
		color 0
		back 15
		priority 15
		window 0
		type $0000
		title 0
		brTop 0
		brLeft 0
		brBottom 190
		brRight 320
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		eraseOnly 0
		underBits 0
		pUnderBits 0
		bordWid 3
	)
	
	(method (dispose)
		(SetPort 0)
		(Graph grRESTORE_BOX underBits)
		(Graph grRESTORE_BOX pUnderBits)
		(Graph grREDRAW_BOX lsTop lsLeft lsBottom lsRight)
		(super dispose:)
	)
	
	(method (open &tmp temp0 temp1)
		(SetPort 0)
		(= color gColor)
		(= back gBack)
		(= temp1 1)
		(if (!= priority -1) (= temp1 (| temp1 $0002)))
		(= lsTop (- top bordWid))
		(= lsLeft (- left bordWid))
		(= lsRight (+ right bordWid))
		(= lsBottom (+ bottom bordWid))
		(= underBits
			(Graph grSAVE_BOX lsTop lsLeft lsBottom lsRight 1)
		)
		(if (!= priority -1)
			(= pUnderBits
				(Graph grSAVE_BOX lsTop lsLeft lsBottom lsRight 2)
			)
		)
		(Graph
			grFILL_BOX
			lsTop
			lsLeft
			lsBottom
			lsRight
			temp1
			back
			priority
		)
		(Graph
			grDRAW_LINE
			(+ lsTop 1)
			(+ lsLeft 1)
			(+ lsTop 1)
			(- lsRight 2)
			global131
			priority
		)
		(Graph
			grDRAW_LINE
			(- lsBottom 2)
			(+ lsLeft 1)
			(- lsBottom 2)
			(- lsRight 2)
			global131
			priority
		)
		(Graph
			grDRAW_LINE
			(+ lsTop 1)
			(+ lsLeft 1)
			(- lsBottom 2)
			(+ lsLeft 1)
			global131
			priority
		)
		(Graph
			grDRAW_LINE
			(+ lsTop 1)
			(- lsRight 2)
			(- lsBottom 2)
			(- lsRight 2)
			global131
			priority
		)
		(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		(= type 129)
		(super open:)
	)
)

(instance theDeathScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					view: 635
					cel: 0
					setLoop: (ulence deathLoop?)
					setCycle: End self
				)
			)
			(1 (= seconds 4))
			(2
				(gSq4GlobalNarrator modNum: 707 say: 1 self)
			)
			(3 (proc0_10 0 6))
		)
	)
)

(instance theZapScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(++ local1)
				(gEgo view: 636)
				(switch global11
					(609
						(if (gEgo inRect: 15 187 317 191) (gEgo setLoop: 2))
					)
					(612
						(if (and (> (gEgo x?) 185) (< (gEgo y?) 123))
							(gEgo setLoop: 3)
						else
							(gEgo setLoop: 7)
						)
					)
					(611
						(if (gEgo inRect: 0 181 235 190) (gEgo setLoop: 2))
					)
					(610 (gEgo setLoop: 2))
					(614 (gEgo setLoop: 0))
					(613 (gEgo setLoop: 3))
				)
				(zapSound play:)
				(= cycles 20)
			)
			(1
				(zapSound stop:)
				(if (not local2) (proc0_1 (gEgo loop?) 0))
				(= cycles 3)
			)
			(2
				(if local2
					(= local1 4)
					(gSq4GlobalNarrator modNum: 706 say: 1 self)
				else
					(= cycles 3)
				)
			)
			(3
				(switch local1
					(1
						(tRoger modNum: 706 say: 1)
						(proc0_3)
						(self dispose:)
					)
					(2
						(tRoger modNum: 706 say: 2)
						(proc0_3)
						(self dispose:)
					)
					(3
						(switch (Random 0 5)
							(0 (tRoger modNum: 706 say: 3))
							(else 
								(tRoger modNum: 706 say: 4)
							)
						)
						(proc0_3)
						(self dispose:)
					)
					(else 
						(gEgo view: 635 setLoop: 0 setCel: 2)
						(= cycles 3)
					)
				)
			)
			(4
				(if (== global11 613) (gEgo setPri: 1))
				(gEgo setCycle: End self)
			)
			(5
				(gSq4GlobalNarrator modNum: 706 say: 2 self)
			)
			(6 (proc0_10 1 7))
		)
	)
)

(instance tongueScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= local2 1)
				(gEgo setMotion: PolyPath global70 global71 self)
			)
			(1
				(global2 setScript: theZapScript)
				(self dispose:)
			)
		)
	)
)

(instance theDodgeR of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: 0 setHeading: 90 self)
				(gSq4GlobalNarrator modNum: 706 say: 3)
			)
			(1
				(proc0_3)
				(gEgo view: 635 setLoop: 0 setCel: 0)
			)
			(2
				(ulence status: 5)
				(proc0_2)
				(gEgo
					posn: (+ (gEgo x?) 12) (- (gEgo y?) 10)
					setLoop: 2
					setCycle: End self
				)
			)
			(3
				(proc0_11 77 5)
				(proc0_1 (gEgo loop?) 0)
				(gEgo
					posn: (+ (gEgo x?) 24) (+ (gEgo y?) 5)
					heading: 90 self
				)
			)
			(4 (self dispose:))
		)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(cond 
			((pEvent claimed?) (return))
			(
				(and
					(== (gIconBar curIcon?) (gIconBar at: 0))
					(or
						(== (pEvent message?) JOY_RIGHT)
						(& (pEvent type?) evJOYSTICK)
					)
				)
				(self cue:)
				(pEvent claimed: 1)
			)
			(else (super handleEvent: pEvent))
		)
	)
)

(instance theDodgeL of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setMotion: 0 setHeading: 270 self)
				(gSq4GlobalNarrator modNum: 706 say: 4)
			)
			(1
				(proc0_3)
				(gEgo view: 635 setLoop: 1 setCel: 0)
			)
			(2
				(proc0_2)
				(ulence status: 5)
				(gEgo
					posn: (- (gEgo x?) 14) (- (gEgo y?) 7)
					setLoop: 3
					setCycle: End self
				)
			)
			(3
				(proc0_11 77 5)
				(proc0_1 (gEgo loop?) 0)
				(gEgo
					posn: (- (gEgo x?) 25) (+ (gEgo y?) 2)
					setHeading: 225 self
				)
			)
			(4 (self dispose:))
		)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(cond 
			((pEvent claimed?) (return))
			(
				(and
					(== (gIconBar curIcon?) (gIconBar at: 0))
					(or
						(== (pEvent message?) JOY_RIGHT)
						(& (pEvent type?) evJOYSTICK)
					)
				)
				(self cue:)
				(pEvent claimed: 1)
			)
			(else (super handleEvent: pEvent))
		)
	)
)

(instance theBiker of Sq4Actor
	(properties
		x 1000
		y 1000
		yStep 15
		view 632
		signal $6000
		illegalBits $0000
		xStep 15
		lookStr 5
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 706 say: 5)
			)
			(2
				(gSq4GlobalNarrator modNum: 706 say: 6)
			)
			(4
				(gSq4GlobalNarrator modNum: 706 say: 7)
			)
			(6
				(gSq4GlobalNarrator modNum: 706 say: 8)
			)
			(7
				(gSq4GlobalNarrator modNum: 706 say: 9)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance forceField of Sq4Feature
	(properties
		y 189
		nsBottom 189
		nsRight 319
		sightAngle 180
		onMeCheck $4000
		lookStr 10
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 706 say: 10)
			)
			(7
				(if (== (ulence egoBusy?) 1)
					(gSq4GlobalNarrator modNum: 706 say: 11)
				else
					(proc0_2)
					(gSq4GlobalNarrator modNum: 706 say: 12)
					(global2 setScript: tongueScript)
				)
			)
			(6
				(switch (Random 0 6)
					(0
						(gSq4GlobalNarrator modNum: 706 say: 13)
					)
					(1
						(gSq4GlobalNarrator modNum: 706 say: 14)
					)
					(2
						(gSq4GlobalNarrator modNum: 706 say: 15)
					)
					(3
						(gSq4GlobalNarrator modNum: 706 say: 16)
					)
					(else 
						(gSq4GlobalNarrator modNum: 706 say: 17)
					)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theDunes of Sq4Feature
	(properties
		y 1
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 706 say: 18)
				(if (proc999_5 global11 610 609)
					(gSq4GlobalNarrator modNum: 706 say: 19)
				)
			)
			(6
				(switch (Random 0 6)
					(0
						(gSq4GlobalNarrator modNum: 706 say: 20)
					)
					(1
						(gSq4GlobalNarrator modNum: 706 say: 21)
					)
					(2
						(gSq4GlobalNarrator modNum: 706 say: 22)
					)
					(3
						(gSq4GlobalNarrator modNum: 706 say: 23)
					)
					(4
						(gSq4GlobalNarrator modNum: 706 say: 24)
					)
					(5
						(gSq4GlobalNarrator modNum: 706 say: 25)
					)
					(6
						(gSq4GlobalNarrator modNum: 706 say: 26)
					)
				)
			)
			(7
				(switch (Random 0 4)
					(0
						(gSq4GlobalNarrator modNum: 706 say: 27)
					)
					(1
						(gSq4GlobalNarrator modNum: 706 say: 28)
					)
					(2
						(gSq4GlobalNarrator modNum: 706 say: 29)
					)
					(3
						(gSq4GlobalNarrator modNum: 706 say: 31)
					)
					(4
						(gSq4GlobalNarrator modNum: 706 say: 30)
					)
					(5
						(gSq4GlobalNarrator modNum: 706 say: 32)
					)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theSand of Sq4Feature
	(properties
		y 1
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(6
				(switch (Random 0 3)
					(0
						(gSq4GlobalNarrator modNum: 706 say: 34)
					)
					(1
						(gSq4GlobalNarrator modNum: 706 say: 35)
					)
					(2
						(gSq4GlobalNarrator modNum: 706 say: 36)
					)
					(3
						(gSq4GlobalNarrator modNum: 706 say: 37)
					)
				)
			)
			(1
				(gSq4GlobalNarrator modNum: 706 say: 38)
			)
			(7
				(switch (Random 0 4)
					(0
						(gSq4GlobalNarrator modNum: 706 say: 39)
					)
					(1
						(gSq4GlobalNarrator modNum: 706 say: 40)
					)
					(2
						(gSq4GlobalNarrator modNum: 706 say: 41)
					)
					(3
						(gSq4GlobalNarrator modNum: 706 say: 42)
					)
					(4
						(gSq4GlobalNarrator modNum: 706 say: 43)
					)
				)
			)
			(4
				(gSq4GlobalNarrator modNum: 706 say: 44)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theBikeSound of Sound
	(properties
		flags $0001
		number 841
	)
)

(instance zapSound of Sound
	(properties
		flags $0001
		number 135
	)
)

(instance tRoger of Sq4Talker
	(properties
		z 400
		noun 7
		modNum 706
		view 1008
		talkerNum 7
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 27
		eyeOffsetY 21
	)
)

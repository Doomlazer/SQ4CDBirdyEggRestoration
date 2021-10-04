;;; Sierra Script 1.0 - (do not remove this comment)
(script# 544)
(include sci.sh)
(use Main)
(use brain)
(use SQRoom)
(use Sq4Feature)
(use Cycle)
(use User)
(use Obj)

(public
	rm544 0
)

(local
	theSq4Prop
	local1
	local2
)
(instance rm544 of SQRoom
	(properties
		picture 544
		style $0064
		lookStr 1
	)
	
	(method (init &tmp [temp0 20])
		(self setRegions: 704)
		(super init:)
		(gEgo setCycle: 0)
		(proc0_3)
		(= local2 global199)
		(= global199 0)
		(if (not (proc0_6 27)) (KQ43Icon init:))
		(if (not (proc0_6 28)) (LLIcon init:))
		(if (not (proc0_6 38)) (droidIcon init:))
		(SQ4Icon init:)
		(if (not (brain formatting?)) (brainIcon init:))
		(toiletIcon init:)
		(exitBar init:)
		(if (proc0_6 27)
			(StrCpy @temp0 {Memory Free: 841,912,226 GBytes})
		else
			(StrCpy @temp0 {Memory Free: 2,451 KBytes})
		)
		(= local1
			(proc0_12 @temp0 64 40 171 25 global137 26 global129)
		)
		(= global34 0)
		(gLongSong fade: 75 10 10 0)
		(gLongSong2 number: 842 vol: 127 loop: 1 play:)
	)
	
	(method (doit &tmp userCurEvent userCurEventX userCurEventY)
		(super doit:)
		(= userCurEvent (User curEvent?))
		(cond 
			((proc999_5 (userCurEvent type?) 1 2 4))
			((not theSq4Prop))
			((theSq4Prop cycler?))
			(else
				(= userCurEventX (userCurEvent x?))
				(= userCurEventY (userCurEvent y?))
				(if
				(proc999_4 47 52 270 149 userCurEventX userCurEventY)
					(theSq4Prop x: userCurEventX y: userCurEventY)
				)
			)
		)
	)
	
	(method (dispose)
		(= global199 local2)
		(= global34 1)
		(gLongSong fade: 127 10 10 0)
		(super dispose:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2 (gSq4GlobalNarrator say: 2))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance KQ43Icon of Sq4Prop
	(properties
		x 60
		y 60
		view 544
		priority 14
		signal $0010
		lookStr 3
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(cond 
				((toiletIcon onMe: self) (toiletIcon setScript: flushFlash self))
				((== theSq4Prop self) (= theSq4Prop 0) (= cel 0))
				(theSq4Prop)
				(else (= theSq4Prop self) (= cel 1))
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
	
	(method (cue)
		(proc0_12 local1)
		(= local1
			(proc0_12
				{Memory Free: 841,912,226 GBytes}
				64
				40
				171
				25
				global137
				26
				global129
			)
		)
		(= theSq4Prop 0)
		(proc0_7 27)
		(self dispose:)
	)
)

(instance SQ4Icon of Sq4Prop
	(properties
		x 100
		y 60
		view 544
		loop 1
		priority 14
		signal $0010
		lookStr 4
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(cond 
				((toiletIcon onMe: self) (toiletIcon setScript: flushFlash self))
				((== theSq4Prop self) (= theSq4Prop 0) (= cel 0))
				(theSq4Prop)
				(else (= theSq4Prop self) (= cel 1))
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
	
	(method (cue)
		(= global4 1)
		(self dispose:)
	)
)

(instance LLIcon of Sq4Prop
	(properties
		x 150
		y 60
		view 544
		loop 2
		priority 14
		signal $0010
		lookStr 5
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(cond 
				((toiletIcon onMe: self) (toiletIcon setScript: flushFlash self))
				((== theSq4Prop self) (= theSq4Prop 0) (= cel 0))
				(theSq4Prop)
				(else (= theSq4Prop self) (= cel 1))
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
	
	(method (cue)
		(= theSq4Prop 0)
		(proc0_7 28)
		(self dispose:)
	)
)

(instance droidIcon of Sq4Prop
	(properties
		x 60
		y 95
		view 544
		loop 3
		priority 14
		signal $0010
		lookStr 6
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(cond 
				((toiletIcon onMe: self) (toiletIcon setScript: flushFlash self))
				((== theSq4Prop self) (= theSq4Prop 0) (= cel 0))
				(theSq4Prop)
				(else (= theSq4Prop self) (= cel 1))
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
	
	(method (cue)
		(= theSq4Prop 0)
		(proc0_7 38)
		(proc0_11 61 5)
		(self dispose:)
	)
)

(instance brainIcon of Sq4Prop
	(properties
		x 100
		y 95
		view 544
		loop 4
		priority 14
		signal $0010
		lookStr 7
	)
	
	(method (doVerb theVerb &tmp temp0 temp1)
		(cond 
			((== theVerb 4)
				(cond 
					((toiletIcon onMe: self) (toiletIcon setScript: flushFlash self))
					((== theSq4Prop self) (= theSq4Prop 0) (= cel 0))
					(theSq4Prop)
					(else (= theSq4Prop self) (= cel 1))
				)
			)
			((and (== theVerb 1) (not (HaveMouse)))
				(= temp0 ((User curEvent?) x?))
				(= temp1 ((User curEvent?) y?))
				(global1
					setCursor: ((gIconBar curIcon?) cursor?) 1 304 172
				)
				(Animate (global5 elements?) 0)
				(gSq4GlobalNarrator say: 7)
				(global1
					setCursor: ((gIconBar curIcon?) cursor?) 1 temp0 temp1
				)
			)
			(else (super doVerb: theVerb &rest))
		)
	)
	
	(method (cue)
		(= theSq4Prop 0)
		(proc0_12 local1)
		(= local1
			(proc0_12
				{Initiating Formatting Sequence Value to 5000}
				64
				40
				171
				25
				global137
				26
				global129
			)
		)
		(brain formatting: 5000)
		(gLongSong number: 869 loop: -1 play: setVol: 75)
		(proc0_11 62 15)
		(self dispose:)
	)
)

(instance toiletIcon of Sq4Prop
	(properties
		x 270
		y 155
		view 544
		loop 5
		priority 13
		signal $0010
		lookStr 9
	)
)

(instance exitBar of Sq4Feature
	(properties
		x 36
		y 37
		nsTop 32
		nsLeft 31
		nsBottom 43
		nsRight 42
		sightAngle 90
		lookStr 10
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (global2 newRoom: 514))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance flushFlash of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLongSong2 number: 839 loop: 1 play: self)
				(client setCel: 1)
				(= cycles 2)
			)
			(1 (theSq4Prop setCycle: Fwd))
			(2
				(theSq4Prop cue:)
				(= cycles 2)
			)
			(3
				(client setCel: 0)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

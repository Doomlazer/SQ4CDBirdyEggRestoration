;;; Sierra Script 1.0 - (do not remove this comment)
(script# 300)
(include sci.sh)
(use Main)
(use rssScript_703)
(use SQRoom)
(use Sq4Narrator)
(use Sq4Feature)
(use Polygon)
(use n958)
(use Cycle)
(use Obj)

(public
	rm300 0
)

(instance rm300 of SQRoom
	(properties
		picture 300
		east 305
		south 310
		west 299
	)
	
	(method (init)
		(proc958_0 128 0 300)
		(if (not (butte sawShadow?)) (Load rsVIEW 301))
		(self setRegions: 703)
		(theStairs init:)
		(theRoom init:)
		(gEgo setPri: 8)
		(switch global12
			(south
				(proc0_3)
				(self style: 14 setScript: enterScript)
			)
			(east
				(proc0_3)
				(self style: 11)
				(gEgo
					y:
						(cond 
							((< (gEgo y?) 67) 67)
							((> (gEgo y?) 88) 88)
							(else (gEgo y?))
						)
					setHeading: 270 self
				)
			)
			(west
				(proc0_2)
				(self style: 12 setScript: enterScript)
			)
			(else 
				(proc0_3)
				(gEgo view: 0 illegalBits: 0 posn: 150 79)
			)
		)
		(global2
			addObstacle:
				((Polygon new:)
					type: 1
					init: 0 0 319 0 319 65 146 65 136 45 40 65 40 82 23 91 0 92
					yourself:
				)
				((Polygon new:)
					type: 1
					init:
						319
						189
						286
						189
						239
						152
						221
						137
						198
						133
						191
						124
						176
						121
						154
						95
						162
						88
						319
						88
					yourself:
				)
				((Polygon new:)
					type: 1
					init:
						0
						189
						0
						103
						16
						96
						49
						94
						61
						99
						87
						99
						105
						109
						98
						124
						104
						133
						95
						151
						129
						189
					yourself:
				)
		)
		(gEgo init:)
		(super init:)
		(if (not (butte onLedgeFlag?)) (gEgo illegalBits: 0))
		(if (< (butte policeLanded?) 0)
			(proc958_0 128 305 7 5)
			(global2
				addObstacle:
					((Polygon new:)
						type: 2
						init: 144 51 163 80 115 92 62 97 43 87 46 70
						yourself:
					)
			)
			(policePod cel: 10 init: stopUpd:)
			(if
				(or
					(== (butte curPolice1Room?) 300)
					(== (butte curPolice2Room?) 300)
				)
				(butte junctioned: 1)
				((ScriptID 703 4)
					posn: 147 90
					init:
					setScript: copEnters
				)
			else
				(butte junctioned: 0)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: 2
						init: 130 52 143 68 93 78 83 83 59 84 45 80 46 70
						yourself:
					)
			)
		)
	)
	
	(method (doit &tmp temp0)
		(cond 
			(script 0)
			((== (gEgo edgeHit?) 3) (proc0_2) (self setScript: exitSouthScript))
			((== (gEgo edgeHit?) 2) (proc0_2) (self setScript: exitEastScript))
		)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond 
			(script)
			(
			(and (not (butte sawShadow?)) (& temp0 $0800))
				(if (IsObject policePod) (policePod setPri: 15))
				(gEgo setPri: 15)
				(butte sawShadow: (+ (butte sawShadow?) 1))
				(proc0_2)
				(global2 overlay: 301 100)
				(self setScript: shadowScript)
			)
			(
				(and
					(butte junctioned?)
					(not ((ScriptID 703 4) script?))
				)
				(cond 
					((== (butte oldPoliceRoom?) 305) ((ScriptID 703 4) posn: 330 76))
					((== (butte oldPoliceRoom?) 310) ((ScriptID 703 4) posn: 179 250))
					((== (butte oldPoliceRoom?) 299) ((ScriptID 703 4) posn: 0 95))
				)
				((ScriptID 703 4) init:)
				((ScriptID 703 4) setScript: copEnters)
			)
			(
				(or
					(& temp0 $0004)
					(& temp0 $0200)
					(& temp0 $0010)
					(& temp0 $2000)
					(and (& temp0 $0008) (not (butte onLedgeFlag?)))
					(and (& temp0 $0020) (butte onLedgeFlag?))
				)
				(proc0_2)
				(self setScript: fallScript 0 temp0)
			)
		)
	)
)

(instance fallScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					((& register $0200) 0)
					((& register $0010) (gEgo setPri: 4))
					((& register $0008) (gEgo setPri: 4))
					((& register $0020) (gEgo setPri: 13))
					((& register $2000)
						(gEgo
							x: (if (> (gEgo x?) 150)
								(+ (gEgo x?) 7)
							else
								(- (gEgo x?) 7)
							)
							setPri: 4
						)
					)
					((& register $0004) (gEgo setPri: 3))
				)
				(global2 setScript: (ScriptID 703 1))
				(self dispose:)
			)
		)
	)
)

(instance enterScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					((== global12 299) (gEgo posn: 8 94 setMotion: MoveTo 37 94 self))
					((butte onLedgeFlag?) (gEgo illegalBits: -32704 setPri: 15) (self cue:))
					(else (self cue:))
				)
			)
			(1 (proc0_3) (self dispose:))
		)
	)
)

(instance exitSouthScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (butte onLedgeFlag?)
					(global2 newRoom: (global2 south?))
				else
					(gEgo setMotion: MoveTo 180 250 self)
				)
			)
			(1
				(global2 newRoom: (global2 south?))
			)
		)
	)
)

(instance exitEastScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo
					setHeading: 90
					setMotion: MoveTo 335 (gEgo y?) self
				)
			)
			(1
				(global2 newRoom: (global2 east?))
			)
		)
	)
)

(instance policePod of Sq4View
	(properties
		x 149
		y 83
		view 305
		loop 1
		priority 5
		signal $4010
		lookStr 1
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 1))
			(4 (gSq4GlobalNarrator say: 2))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance copEnters of Script
	(properties)
	
	(method (doit)
		(if (and (not (global2 script?)) (== state 0))
			(self cue:)
		)
		(if
			(and
				(< ((ScriptID 703 4) distanceTo: gEgo) 80)
				(not (global2 script?))
			)
			((ScriptID 703 4) setScript: (ScriptID 703 5))
			(self dispose:)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				((ScriptID 703 4)
					setCycle: Walk
					setMotion: MoveTo 147 90 self
				)
			)
			(2
				((ScriptID 703 4)
					setMotion: MoveTo (gEgo x?) (gEgo y?) self
				)
			)
		)
	)
)

(instance ptera of Sq4Actor
	(properties
		x 207
		y 68
		view 301
		loop 3
		priority 6
		signal $4010
		cycleSpeed 9
	)
)

(instance shadowScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gIconBar disable:)
				(gEgo setHeading: 44)
				(ptera init: setCycle: End self)
				(= seconds 3)
			)
			(1 (gEgo setHeading: 90))
			(2
				(ptera dispose:)
				(gEgo setHeading: 136)
				(= cycles 2)
			)
			(3
				(global2 drawPic: 300 100)
				(= cycles 1)
			)
			(4
				(tROGER say: 1 self 0 64 5 160)
				(if (IsObject policePod) (policePod setPri: 5))
				(gEgo setPri: 8)
			)
			(5
				(if global25 (global25 dispose:))
				(gIconBar enable:)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance theStairs of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		onMeCheck $4000
		lookStr 3
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1 (gSq4GlobalNarrator say: 3))
			(else  (super doVerb: theVerb))
		)
	)
)

(instance theRoom of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2
				((ScriptID 703 6) doVerb: theVerb)
			)
			(1
				(gSq4GlobalNarrator modNum: 310 say: 3)
			)
			(else  (super doVerb: &rest))
		)
	)
)

(instance tROGER of FaceTalker
	(properties
		noun 7
		modeless 0
		talkerNum 7
	)
)

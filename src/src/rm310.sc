;;; Sierra Script 1.0 - (do not remove this comment)
(script# 310)
(include sci.sh)
(use Main)
(use rssScript_703)
(use MoveToY)
(use SQRoom)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use n958)
(use Cycle)
(use Obj)

(public
	rm310 0
)

(instance rm310 of SQRoom
	(properties
		picture 310
		horizon 15
		north 300
		east 315
		south 320
		west 306
	)
	
	(method (init)
		(proc958_0 128 0 300)
		(if (> (butte policeLanded?) 0)
			(Load rsVIEW 305)
			(Load rsPIC 300)
		else
			(proc958_0 128 7 5)
		)
		(switch global12
			(north
				(proc0_2)
				(self setScript: enterScript style: 13)
			)
			(south
				(proc0_2)
				(self setScript: enterScript style: 14)
				(gEgo illegalBits: 0 setPri: 6)
			)
			(east
				(self setScript: enterScript style: 11)
				(gEgo
					setPri: 13
					cel: 4
					x: 305
					y: (if (< (gEgo y?) 103) 103 else (gEgo y?))
				)
			)
			(west
				(if (< (gEgo y?) 110)
					(gEgo setPri: 12)
				else
					(gEgo setPri: 14)
				)
				(self style: 12 setScript: enterScript)
			)
			(else 
				(gEgo illegalBits: 0 posn: 155 92 setPri: 6)
				(proc0_3)
			)
		)
		(if
			(and
				(== global12 300)
				(not (butte sawGirlShadow?))
				(not (proc0_6 32))
			)
			(shadow init: setScript: shadowMoves)
		)
		(gEgo init:)
		(super init:)
		(if (or (== global12 300) (== global12 320))
			(self
				addObstacle:
					((Polygon new:)
						type: 1
						init:
							157
							0
							157
							11
							128
							13
							124
							30
							89
							49
							60
							78
							69
							94
							109
							107
							195
							175
							199
							189
							0
							189
							0
							0
						yourself:
					)
					((Polygon new:)
						type: 1
						init:
							319
							0
							319
							189
							273
							189
							259
							173
							265
							150
							236
							105
							185
							76
							185
							46
							225
							41
							278
							12
							280
							0
						yourself:
					)
			)
			(theBridge init:)
			(theRoom init:)
		else
			(global2
				addObstacle:
					((Polygon new:)
						type: 2
						init: 0 102 34 105 32 115 0 123
						yourself:
					)
					((Polygon new:)
						type: 1
						init:
							319
							189
							0
							189
							0
							129
							20
							123
							44
							121
							55
							112
							54
							104
							21
							95
							0
							94
							0
							43
							17
							41
							57
							21
							167
							0
							319
							0
							319
							100
							272
							103
							260
							106
							196
							116
							180
							128
							162
							136
							155
							145
							213
							141
							236
							152
							226
							159
							259
							158
							287
							154
							285
							149
							227
							145
							226
							135
							288
							123
							319
							120
						yourself:
					)
			)
			(theStairs init:)
			(theRoom init:)
			(gEgo illegalBits: -32768)
		)
		(cond 
			((== (butte curPolice1Room?) 310)
				(butte junctioned: 1)
				((ScriptID 703 4)
					loop: 1
					setPri: 13
					posn: 240 120
					init:
					setScript:
						(cond 
							((or (== global12 300) (== global12 320)) copOnLedge)
							((== global12 306) egoOnLedge)
							(else copEnters)
						)
				)
			)
			((== (butte curPolice2Room?) 310)
				(butte junctioned: 1)
				((ScriptID 703 4)
					posn: 136 70
					setPri: 8
					init:
					loop: (if (== (butte oldPoliceRoom?) 320) 3 else 2)
					setScript:
						(if (or (== global12 300) (== global12 320))
							copEnters
						else
							copOnStairs
						)
				)
			)
			(else (butte junctioned: 0))
		)
		(self setRegions: 703)
	)
	
	(method (doit &tmp temp0)
		(cond 
			(script)
			((== (gEgo edgeHit?) 1) (proc0_2) (self setScript: exitNorthScript))
		)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond 
			(
				(and
					(== script (ScriptID 703 1))
					(== (gEgo edgeHit?) 3)
					(< (gEgo x?) 160)
					(> (gEgo y?) 38)
				)
				(butte egoSwims: 1)
				(proc0_2)
				(self setScript: exitScript)
			)
			(script)
			((== (gEgo edgeHit?) 3) (proc0_2) (self setScript: exitScript))
			(
				(and
					(butte junctioned?)
					(not ((ScriptID 703 4) script?))
				)
				(cond 
					((== (butte curPolice1Room?) 310)
						(cond 
							((or (== global12 300) (== global12 320))
								((ScriptID 703 4)
									posn: 325 120
									setPri: 13
									init:
									setScript: copOnLedge
								)
							)
							((== global12 306)
								((ScriptID 703 4)
									posn: 325 120
									setPri: 13
									init:
									setScript: egoOnLedge
								)
							)
							(else
								(cond 
									((== (butte oldPoliceRoom?) 300) ((ScriptID 703 4) posn: 177 0))
									((== (butte oldPoliceRoom?) 315) ((ScriptID 703 4) posn: 325 110))
									((== (butte oldPoliceRoom?) 320) ((ScriptID 703 4) posn: 195 250))
								)
								((ScriptID 703 4) init: setScript: copEnters)
							)
						)
					)
					((== (butte curPolice2Room?) 310)
						(butte junctioned: 1)
						(if (or (== global12 300) (== global12 320))
							(cond 
								((== (butte oldPoliceRoom?) 300) ((ScriptID 703 4) posn: 177 0))
								((== (butte oldPoliceRoom?) 315) ((ScriptID 703 4) posn: 325 110))
								((== (butte oldPoliceRoom?) 320) ((ScriptID 703 4) posn: 195 250))
							)
							((ScriptID 703 4) init: setScript: copEnters)
						else
							(cond 
								((== (butte oldPoliceRoom?) 300) ((ScriptID 703 4) posn: 177 0))
								((== (butte oldPoliceRoom?) 320) ((ScriptID 703 4) posn: 195 200))
							)
							((ScriptID 703 4) init: setScript: copOnStairs)
						)
					)
				)
			)
			(
				(or
					(& temp0 $0002)
					(& temp0 $0004)
					(& temp0 $0040)
					(& temp0 $0080)
					(& temp0 $0008)
				)
				(if (or (== global12 300) (== global12 320))
					(proc0_2)
					(self setScript: fallScript 0 temp0)
				)
			)
			(
				(and
					(or
						(& temp0 $0010)
						(& temp0 $0100)
						(& temp0 $2000)
						(& temp0 $0020)
					)
					(or (== global12 306) (== global12 315))
				)
				(proc0_2)
				(self setScript: fallScript 0 temp0)
			)
		)
		(return
			(cond 
				(script)
				((and (== global12 315) (> (gEgo y?) 150)) (gEgo setPri: 14))
				((and (== global12 315) (gEgo setPri: 13)))
				((and (== global12 306) (> (gEgo y?) 110)) (gEgo setPri: 14))
				((and (== global12 306) (gEgo setPri: 12)))
				(else 0)
			)
		)
	)
)

(instance fallScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(cond 
					((& register $0100) (gEgo setPri: (- (gEgo priority?) 3)))
					((& register $0002)
						(gEgo
							posn: (+ (gEgo x?) 7) (- (gEgo y?) 5)
							setPri: (- (gEgo priority?) 3)
						)
					)
					((& register $0004)
						(gEgo
							x: (+ (gEgo x?) 10)
							setPri: (- (gEgo priority?) 3)
						)
					)
					((& register $0040) (gEgo x: (- (gEgo x?) 10)))
					((& register $0080)
						(gEgo
							x: (- (gEgo x?) 7)
							setPri: (- (gEgo priority?) 3)
						)
					)
					((& register $0010)
						(if (< (gEgo y?) 150)
							(gEgo setPri: (- (gEgo priority?) 1))
						else
							(gEgo setPri: 15)
						)
					)
					((& register $2000)
						(gEgo
							x: (+ (gEgo x?) 6)
							setPri: (- (gEgo priority?) 1)
						)
					)
					((& register $0008)
						(gEgo
							posn: (+ (gEgo x?) 4) (- (gEgo y?) 5)
							setPri: (- (gEgo priority?) 3)
						)
					)
					((& register $0020) (gEgo setPri: 9))
				)
				(global2 setScript: (ScriptID 703 1))
				(self dispose:)
			)
		)
	)
)

(instance exitScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (not (butte egoSwims?))
					(gEgo setHeading: 180 self)
				else
					(self cue:)
				)
			)
			(1
				(= temp0
					(CelHigh (gEgo view?) (gEgo loop?) (gEgo cel?))
				)
				(gEgo setMotion: MoveToY (+ 189 temp0) self)
			)
			(2
				(global2 newRoom: (global2 south?))
			)
		)
	)
)

(instance exitNorthScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
				(not (if (== global12 300) else (== global12 320)))
					(butte onLedgeFlag: 1)
					(gEgo illegalBits: 0 setMotion: MoveTo 133 -2 self)
				else
					(gEgo illegalBits: 0 setMotion: MoveTo (gEgo x?) -2 self)
				)
			)
			(1
				(global2 newRoom: (global2 north?))
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
					((== global12 300)
						(if (butte onLedgeFlag?)
							(butte onLedgeFlag: 0)
							(= global12 306)
							(gEgo
								illegalBits: 0
								setPri: 9
								posn: (gEgo x?) 0
								setMotion: MoveTo (- (gEgo x?) 50) 17 self
							)
						else
							(gEgo
								view: 0
								illegalBits: 0
								setPri: 6
								x: (if (<= (gEgo x?) 203) (gEgo x?) else 203)
								y: 48
								setMotion: MoveTo 180 49 self
							)
						)
					)
					((== global12 320)
						(gEgo
							posn:
								(if (> (gEgo x?) 190)
									(- (gEgo x?) 5)
								else
									(+ (gEgo x?) 5)
								)
								189
							setMotion: MoveTo 192 140 self
						)
					)
					(
						(and
							(== global12 306)
							(< 75 (gEgo y?))
							(< (gEgo y?) 110)
						)
						(gEgo
							x: (+
								0
								(/ (CelWide (gEgo view?) (gEgo loop?) (gEgo cel?)) 2)
							)
							setMotion: MoveTo 21 99 self
						)
					)
					((== global12 315)
						(gEgo
							x: (-
								319
								(/ (CelWide (gEgo view?) (gEgo loop?) (gEgo cel?)) 2)
							)
						)
						(= cycles 1)
					)
					(else
						(gEgo
							x: (+
								0
								(/ (CelWide (gEgo view?) (gEgo loop?) (gEgo cel?)) 2)
							)
						)
						(= cycles 1)
					)
				)
			)
			(1 (proc0_3) (self dispose:))
		)
	)
)

(instance copOnStairs of Script
	(properties)
	
	(method (doit)
		(if (and (not (global2 script?)) (== state 0))
			(self cue:)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				((ScriptID 703 4)
					setCycle: Walk
					setMotion: MoveTo 136 70 self
				)
			)
			(2
				(if (== ((ScriptID 703 4) loop?) 2)
					((ScriptID 703 4) setScript: (ScriptID 703 5))
					(self dispose:)
				else
					((ScriptID 703 4) setMotion: MoveTo 182 -1 self)
				)
			)
		)
	)
)

(instance copOnLedge of Script
	(properties)
	
	(method (doit)
		(if (and (not (global2 script?)) (== state 0))
			(self cue:)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				((ScriptID 703 4)
					setCycle: Walk
					setMotion: MoveTo 240 ((ScriptID 703 4) y?) self
				)
			)
			(2
				((ScriptID 703 4)
					setMotion: MoveTo ((ScriptID 703 4) x?) (- ((ScriptID 703 4) y?) 3)
				)
				(if
				(and (< (gEgo y?) 140) (not (global2 script?)))
					(ScriptID 703 3)
					((ScriptID 703 4) setScript: (ScriptID 703 5))
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(3
				((ScriptID 703 4)
					setMotion:
						MoveTo
						(- ((ScriptID 703 4) x?) 3)
						((ScriptID 703 4) y?)
						self
				)
			)
			(4
				((ScriptID 703 4)
					setMotion:
						MoveTo
						(+ ((ScriptID 703 4) x?) 3)
						(- ((ScriptID 703 4) y?) 3)
				)
				(if
				(and (< (gEgo y?) 110) (not (global2 script?)))
					(ScriptID 703 3)
					((ScriptID 703 4) setScript: (ScriptID 703 5))
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(5
				((ScriptID 703 4)
					setMotion: MoveTo 330 ((ScriptID 703 4) y?) self
				)
			)
		)
	)
)

(instance egoOnLedge of Script
	(properties)
	
	(method (doit)
		(if (and (not (global2 script?)) (== state 0))
			(self cue:)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				1
				((ScriptID 703 4)
					setCycle: Walk
					setMotion: MoveTo 169 135 self
				)
			)
			(2
				2
				(if (not (global2 script?))
					((ScriptID 703 4) setScript: (ScriptID 703 5))
				)
				(self dispose:)
			)
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
				(< ((ScriptID 703 4) distanceTo: gEgo) 60)
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
					setMotion: PolyPath (gEgo x?) (gEgo y?) self
				)
			)
		)
	)
)

(instance shadow of Sq4Actor
	(properties
		x 38
		y 187
		view 310
		lookStr 1
	)
)

(instance shadowMoves of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not script)
				(not (global2 script?))
				(== global12 300)
				(not (butte sawGirlShadow?))
			)
			(butte sawGirlShadow: 1)
			(self cue:)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				1
				(shadow setCycle: End self)
			)
			(2
				2
				(shadow
					setMotion:
						MoveTo
						(-
							(shadow x?)
							(CelWide (shadow view?) (shadow loop?) (shadow cel?))
						)
						(+
							(shadow y?)
							(CelHigh (shadow view?) (shadow loop?) (shadow cel?))
						)
						self
				)
			)
			(3
				3
				(gSq4GlobalNarrator say: 2)
				(shadow dispose:)
				(self dispose:)
			)
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
			(1 (gSq4GlobalNarrator say: 3))
			(else  (super doVerb:))
		)
	)
)

(instance theStairs of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		onMeCheck $4000
		lookStr 4
	)
)

(instance theBridge of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		onMeCheck $0800
		lookStr 5
	)
)

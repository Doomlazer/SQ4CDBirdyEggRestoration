;;; Sierra Script 1.0 - (do not remove this comment)
(script# 299)
(include sci.sh)
(use Main)
(use rssScript_703)
(use MoveToY)
(use SQRoom)
(use Sq4Feature)
(use Polygon)
(use n958)
(use DPath)
(use Cycle)
(use Obj)

(public
	rm299 0
)

(instance rm299 of SQRoom
	(properties
		picture 299
		east 300
		south 306
	)
	
	(method (init)
		(if (> (butte policeLanded?) 0)
			(Load rsVIEW 305)
			(Load rsPIC 300)
		else
			(proc958_0 128 7 5)
		)
		(proc958_0 128 0 300)
		(self setRegions: 703)
		(theRoom init:)
		(switch global12
			(south
				(proc0_2)
				(gEgo init: setPri: 15)
				(self setScript: enterScript style: 14)
			)
			(east
				(proc0_2)
				(gEgo init: hide: setPri: 8)
				(self setScript: enterScript style: 11)
			)
			(else 
				(proc0_3)
				(gEgo init: view: 0 posn: 205 130 setPri: 8)
			)
		)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						319
						189
						262
						189
						232
						186
						231
						169
						250
						162
						222
						149
						220
						143
						229
						137
						265
						143
						268
						147
						300
						147
						308
						122
						319
						118
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						207
						165
						200
						173
						213
						178
						221
						189
						208
						189
						169
						189
						116
						187
						108
						186
						90
						173
						85
						165
						85
						144
						184
						144
						193
						148
						205
						159
					yourself:
				)
				((Polygon new:)
					type: 2
					init:
						319
						94
						315
						96
						303
						96
						296
						105
						270
						118
						217
						118
						212
						122
						93
						119
						69
						128
						57
						140
						61
						153
						108
						189
						0
						189
						0
						0
						319
						0
					yourself:
				)
		)
		(super init:)
		(if
			(or
				(== (butte curPolice1Room?) 299)
				(== (butte curPolice2Room?) 299)
			)
			(butte junctioned: 1)
			((ScriptID 703 4)
				posn: 190 134
				setCycle: Walk
				init:
				setScript: copEnters
			)
		else
			(butte junctioned: 0)
		)
	)
	
	(method (doit &tmp temp0)
		(cond 
			(script 0)
			((== (gEgo onControl: 0) 2048) (proc0_2) (self setScript: exitScript))
		)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond 
			(script 0)
			(
				(and
					(butte junctioned?)
					(not ((ScriptID 703 4) script?))
				)
				((ScriptID 703 4)
					posn: 315 107
					init:
					setScript: copEnters
				)
			)
			(
				(or
					(& temp0 $0010)
					(& temp0 $0040)
					(& temp0 $0080)
					(& temp0 $0100)
					(& temp0 $1000)
					(& temp0 $2000)
					(& temp0 $0002)
					(& temp0 $0004)
				)
				(proc0_2)
				(self setScript: fallScript 0 temp0)
			)
		)
		(cond 
			(
				(and
					(not script)
					(or
						(and (> (gEgo y?) 179) (> (gEgo x?) 230))
						(and (> (gEgo y?) 148) (< (gEgo x?) 152))
					)
				)
				(gEgo setPri: 15)
			)
			((not script) (gEgo setPri: 8))
		)
	)
	
	(method (newRoom newRoomNumber)
		(if
		(and (== script fallScript) (== (gEgo edgeHit?) 3))
			(= newRoomNumber 0)
		else
			(super newRoom: newRoomNumber)
		)
	)
)

(instance fallScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(cond 
					((& register $0010) (gEgo setPri: 5))
					((& register $0080) (gEgo setPri: 3))
					((& register $1000) (gEgo setPri: 5 x: (- (gEgo x?) 7)))
					((& register $2000) (gEgo x: (+ (gEgo x?) 7) setPri: 5))
					((& register $0002) (gEgo setPri: 5))
					((& register $0040) (gEgo setPri: 6))
					((& register $0004) (gEgo setPri: 10))
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
					((== global12 306)
						(if (< (gEgo x?) 190)
							(gEgo
								posn: 182 247
								setLoop: 2
								setPri: 15
								setMotion: MoveTo 182 225 self
							)
						else
							(gEgo
								x: (if (> (gEgo x?) 250) 250 else (gEgo x?))
								y: 186
							)
							(= cycles 1)
						)
					)
					((== global12 300) (= cycles 1))
				)
			)
			(1
				(cond 
					((and (== global12 306) (< (gEgo x?) 190)) (= cycles 1))
					((== global12 300)
						(gEgo
							init:
							show:
							illegalBits: 0
							x: 322
							y: 101
							setMotion: MoveTo 308 101 self
						)
					)
					(else
						(proc0_3)
						(gEgo illegalBits: -32768)
						(client setScript: 0)
					)
				)
			)
			(2
				(if (== global12 300)
					(proc0_3)
					(proc0_1 1 0 4)
					(client setScript: 0)
				else
					(gEgo
						setLoop: 1
						setPri: 15
						setMotion: MoveTo 152 205 self
					)
				)
			)
			(3
				(gEgo setPri: 15 setMotion: MoveTo 118 186 self)
			)
			(4
				(gEgo setMotion: MoveTo 97 180 self)
			)
			(5
				(gEgo illegalBits: -32768 setLoop: -1)
				(proc0_3)
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
				(if (< (gEgo x?) 190)
					(gEgo setLoop: -1 setHeading: 134 self)
				else
					(global2 newRoom: (global2 south?))
				)
			)
			(1
				(= temp0
					(CelHigh (gEgo view?) (gEgo loop?) (gEgo cel?))
				)
				(gEgo setMotion: MoveToY (+ 190 temp0) self)
			)
			(2
				(if (> (gEgo x?) 189) (gEgo x: 189))
				(global2 newRoom: (global2 south?))
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
				(< ((ScriptID 703 4) distanceTo: gEgo) 80)
				(not (global2 script?))
				(not (== (gEgo onControl:) 16384))
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
					setMotion: DPath 218 137 211 169 227 154 182 123 320 115 self
				)
			)
		)
	)
)

(instance theRoom of Sq4Feature
	(properties
		x 160
		y 90
		nsBottom 200
		nsRight 320
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2
				((ScriptID 703 6) doVerb: theVerb)
			)
			(1 (gSq4GlobalNarrator say: 1))
			(else  (super doVerb:))
		)
	)
)

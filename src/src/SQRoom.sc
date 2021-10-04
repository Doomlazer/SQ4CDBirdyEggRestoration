;;; Sierra Script 1.0 - (do not remove this comment)
(script# 812)
(include sci.sh)
(use Main)
(use DIcon)
(use PolyPath)
(use Cycle)
(use Game)
(use User)
(use Obj)

(public
	eRS 0
)

(procedure (localproc_0377)
	(cond 
		((< (gEgo x?) 0) (gEgo x: (+ 0 (* (gEgo xStep?) 2))))
		((> (gEgo x?) 319) (gEgo x: (- 319 (* (gEgo xStep?) 2))))
	)
)

(procedure (localproc_03bd)
	(cond 
		((< (gEgo y?) (global2 horizon?)) (gEgo y: (+ (global2 horizon?) (* (gEgo yStep?) 2))))
		((> (gEgo y?) 189) (gEgo y: (- 189 (* (gEgo yStep?) 2))))
	)
)

(instance controls of Controls
	(properties)
)

(class SQRoom of Rm
	(properties
		script 0
		number 0
		modNum -1
		noun 0
		timer 0
		keep 0
		initialized 0
		picture 0
		style $ffff
		horizon 0
		controls 0
		north 0
		east 0
		south 0
		west 0
		curPic 0
		picAngle 0
		vanishingX 160
		vanishingY 0
		obstacles 0
		inset 0
		lookStr 0
	)
	
	(method (init &tmp temp0 temp1)
		(= number gNumber)
		(= controls controls)
		(= gPicAngle picAngle)
		(if picture (self drawPic: picture))
		(cond 
			((not (global5 contains: gEgo)) 0)
			(script 0)
			((proc999_5 style 11 12 13 14)
				(= temp0
					(+
						1
						(/
							(CelWide
								((User alterEgo?) view?)
								((User alterEgo?) loop?)
								((User alterEgo?) cel?)
							)
							2
						)
					)
				)
				(= temp1
					(+
						1
						(/
							(CelHigh
								((User alterEgo?) view?)
								((User alterEgo?) loop?)
								((User alterEgo?) cel?)
							)
							2
						)
					)
				)
				(switch ((User alterEgo?) edgeHit?)
					(1 ((User alterEgo?) y: 188))
					(4
						((User alterEgo?) x: (- 319 temp0))
					)
					(3
						((User alterEgo?) y: (+ horizon temp1))
					)
					(2
						((User alterEgo?) x: (+ 0 temp0))
					)
				)
				((User alterEgo?) edgeHit: 0)
			)
			(else (self setScript: eRS 0 gWest))
		)
		(gSq4GlobalNarrator default:)
	)
	
	(method (doit &tmp temp0)
		(cond 
			(script (script doit:))
			((not (global5 contains: gEgo)) 0)
			(
				(= temp0
					(switch ((User alterEgo?) edgeHit?)
						(1 north)
						(2 east)
						(3 south)
						(4 west)
					)
				)
				(self setScript: lRS 0 temp0)
			)
		)
	)
	
	(method (doVerb theVerb)
		(proc0_16 theVerb)
	)
)

(instance lRS of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(proc0_2)
				(= temp1
					(CelWide (gEgo view?) (gEgo loop?) (gEgo cel?))
				)
				(switch register
					((client north?)
						(global2 newRoom: register)
					)
					((client south?)
						(= temp0
							(CelHigh (gEgo view?) (gEgo loop?) (gEgo cel?))
						)
						(if (IsObject (gEgo _head?))
							(= temp0
								(+
									temp0
									(CelHigh
										((gEgo _head?) view?)
										((gEgo _head?) loop?)
										((gEgo _head?) cel?)
									)
								)
							)
						)
						(gEgo setMotion: PolyPath (gEgo x?) (+ 189 temp0) self)
					)
					((client east?)
						(gEgo setMotion: PolyPath (+ 319 temp1) (gEgo y?) self)
					)
					((client west?)
						(gEgo setMotion: PolyPath (- 0 temp1) (gEgo y?) self)
					)
				)
			)
			(1 (gEgo hide:) (= cycles 2))
			(2
				(global2 setScript: 0 newRoom: register)
			)
		)
	)
)

(instance eRS of Script
	(properties)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= cycles 0)
				(proc0_2)
				(= temp0
					(CelHigh (gEgo view?) (gEgo loop?) (gEgo cel?))
				)
				(= temp1
					(CelWide (gEgo view?) (gEgo loop?) (gEgo cel?))
				)
				(switch register
					((client north?)
						(localproc_0377)
						(gEgo y: (+ (global2 horizon?) (gEgo yStep?)))
						(= cycles 1)
					)
					((client south?)
						(localproc_0377)
						(gEgo
							y: (+ 189 temp0)
							setMotion: nBMT (gEgo x?) (- 189 (* (gEgo yStep?) 2)) self
						)
					)
					((client east?)
						(localproc_03bd)
						(gEgo
							x: (+ 319 (/ temp1 2))
							setMotion: nBMT (- 319 (* (gEgo xStep?) 2)) (gEgo y?) self
						)
					)
					((client west?)
						(localproc_03bd)
						(gEgo
							x: (- 0 (/ temp1 2))
							setMotion: nBMT (+ 0 (* (gEgo xStep?) 2)) (gEgo y?) self
						)
					)
					(else  (= cycles 1))
				)
			)
			(1 (proc0_3) (self dispose:))
		)
	)
)

(instance nBMT of MoveTo
	(properties)
	
	(method (doit)
		(super doit:)
		(if (client isBlocked:) (self moveDone:))
	)
)

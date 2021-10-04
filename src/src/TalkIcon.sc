;;; Sierra Script 1.0 - (do not remove this comment)
(script# 814)
(include sci.sh)
(use DCIcon)
(use Cycle)


(class TalkIcon of DCIcon
	(properties
		type $0004
		state $0000
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
		view 0
		loop 0
		cel 0
		cycler 0
		cycleSpeed 0
		signal $0000
		iterate -1
		iterCnt 0
		saveBits 0
	)
	
	(method (init)
		(cond 
			((== cycler -1) (= cycler 0))
			(cycler ((= cycler (cycler new:)) init: self))
			(else ((= cycler (Fwd new:)) init: self))
		)
		(= iterCnt 0)
	)
	
	(method (draw &tmp temp0)
		(if saveBits
			(Graph grRESTORE_BOX saveBits)
			(Graph grREDRAW_BOX nsTop nsLeft nsBottom nsRight)
		)
		(= saveBits
			(Graph grSAVE_BOX nsTop nsLeft nsBottom nsRight 3)
		)
		(DrawCel view loop cel nsLeft nsTop 15)
	)
	
	(method (cycle &tmp theCel)
		(= theCel cel)
		(super cycle:)
		(cond 
			((or (not (IsObject cycler)) (== cel theCel)) 0)
			((or (== iterate -1) (<= iterCnt iterate))
				(++ iterCnt)
				(if
					(and
						(> (NumLoops self) 1)
						(or loop (< (Random 1 100) 51))
					)
					(= loop (^ loop $0001))
				)
			)
			((> iterCnt iterate)
				(if (IsObject cycler) (cycler dispose:))
				(= loop (= cycler (= cel 0)))
			)
		)
	)
)

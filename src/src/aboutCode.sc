;;; Sierra Script 1.0 - (do not remove this comment)
(script# 811)
(include sci.sh)
(use Main)
(use Sq4Dialog)
(use Obj)

(public
	aboutCode 0
)

(instance aboutCode of Code
	(properties)
	
	(method (doit &tmp temp0 [temp1 600] [temp601 600])
		(= temp0 (global1 setCursor: 999 1))
		(Message msgGET 811 97 0 1 1 @temp1)
		(Format @temp601 @temp1 global27)
		(proc816_1 @temp601)
		(Message msgGET 811 97 0 2 1 @temp1)
		(proc816_1 @temp1)
		(Message msgGET 811 97 0 3 1 @temp1)
		(proc816_1 @temp1)
		(Message msgGET 811 97 0 4 1 @temp1)
		(proc816_1 @temp1)
		(global1 setCursor: temp0 1)
	)
)

;;; Sierra Script 1.0 - (do not remove this comment)
(script# 31)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Feature)
(use ForwardCounter)
(use Obj)

(public
	rm031 0
)

(instance rm031 of SQRoom
	(properties
		picture 31
	)
	
	(method (init &tmp [temp0 50])
		(self setRegions: 701)
		(Load rsVIEW 31)
		(super init:)
		(theMouth init: setCycle: 0)
		(self setScript: rmScript)
	)
)

(instance rmScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 3))
			(1
				(theMouth setCycle: ForwardCounter 20 self)
			)
			(2
				(theMouth
					posn: 142 106
					setLoop: 1
					setCycle: ForwardCounter 15 self
				)
			)
			(3
				(theMouth
					posn: 152 104
					setLoop: 2
					setCycle: ForwardCounter 10 self
				)
			)
			(4
				(hand init:)
				(theMouth
					posn: 151 127
					setLoop: 3
					setCycle: ForwardCounter 40 self
				)
			)
			(5
				(hand dispose:)
				(theMouth dispose:)
				(global2 newRoom: global12)
			)
		)
	)
)

(instance theMouth of Sq4Actor
	(properties
		x 153
		y 106
		view 31
	)
)

(instance hand of Sq4View
	(properties
		x 118
		y 189
		view 31
		loop 4
	)
)

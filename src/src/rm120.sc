;;; Sierra Script 1.0 - (do not remove this comment)
(script# 120)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Feature)
(use Cycle)
(use Obj)

(public
	rm120 0
)

(instance rm120 of SQRoom
	(properties
		picture 120
	)
	
	(method (init)
		(super init:)
		(self setScript: shipScript)
		(gLongSong2 hold: 3)
	)
)

(instance shipScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(ship init: hide:)
				(= seconds 3)
			)
			(2
				(ship show: setCycle: End self)
				(= seconds 2)
			)
			(3 (global2 newRoom: 535))
		)
	)
)

(instance ship of Sq4Actor
	(properties
		x 186
		y 87
		view 120
		loop 4
	)
)

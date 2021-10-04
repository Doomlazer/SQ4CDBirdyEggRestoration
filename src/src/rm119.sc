;;; Sierra Script 1.0 - (do not remove this comment)
(script# 119)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Feature)
(use Cycle)
(use Obj)

(public
	rm119 0
)

(local
	local0
)
(instance rm119 of SQRoom
	(properties
		picture 119
	)
	
	(method (init)
		(Load rsVIEW 120)
		(gLongSong2 hold: 2)
		(if (== global12 59)
			(ship x: 125 y: -1)
			(self setScript: flyInScript)
		else
			(ship x: 181 y: 59)
			(self setScript: flyOutScript)
		)
		(ship init: setCycle: Fwd)
		(super init:)
	)
)

(instance flyInScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 2))
			(1
				(ship setLoop: 0 setMotion: MoveTo 168 46 self)
			)
			(2 (global2 newRoom: 120))
		)
	)
)

(instance flyOutScript of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(if (< (Abs (- global88 local0)) 6)
			0
		else
			(= local0 global88)
			(++ register)
			(ship x: (- (ship x?) (/ register 4)))
			(ship y: (- (ship y?) (/ register 4)))
			(if
			(and (== state 1) (== (gLongSong prevSignal?) -1))
				(self cue:)
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
				(gLongSong2 stop:)
				(gLongSong prevSignal: 0)
				(-- register)
			)
			(1
				(gLongSong number: 74 loop: 1 vol: 127 playBed:)
				(ship loop: 1 setMotion: MoveTo 70 -3)
			)
			(2 (global2 newRoom: 72))
		)
	)
)

(instance ship of Sq4Actor
	(properties
		yStep 4
		view 120
		priority 6
		signal $2010
		xStep 2
	)
)

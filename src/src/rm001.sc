;;; Sierra Script 1.0 - (do not remove this comment)
(script# 1)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Feature)
(use n958)
(use Cycle)
(use Obj)

(public
	rm001 0
)

(local
	[local0 2]
)
(instance rm001 of SQRoom
	(properties
		picture 106
	)
	
	(method (init)
		(super init:)
		(Load rsPIC 1)
		(proc958_0 128 101)
		(proc958_0 135 68 69)
		(self setScript: rmScript setRegions: 707)
	)
)

(instance rmScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(cond 
			(
			(and (== state 1) (== (gLongSong prevSignal?) 10)) (self cue:))
			(register
				(Palette palANIMATE 160 191 -1)
				(Palette palANIMATE 128 159 -1)
			)
		)
	)
	
	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(gLongSong loop: -1 playBed:)
				(= cycles 1)
			)
			(1 0)
			(2
				(global2 drawPic: 1)
				(four init: hide:)
				(= register 1)
				(= seconds 3)
			)
			(3
				(four show: setCycle: End self)
			)
			(4
				(Message msgGET 1 97 0 1 1 @temp0)
				(proc0_12
					@temp0
					64
					1
					177
					67
					316
					25
					global157
					26
					global129
					27
					1
					30
					68
				)
				(four stopUpd:)
				(= cycles 1)
			)
			(5 (= seconds 5))
			(6
				(global2 drawPic: 803 10)
				(if (== global11 global13) (global2 newRoom: 6))
			)
		)
	)
)

(instance four of Sq4Prop
	(properties
		x 156
		y 129
		view 101
	)
)

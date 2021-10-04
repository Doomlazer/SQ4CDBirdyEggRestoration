;;; Sierra Script 1.0 - (do not remove this comment)
(script# 396)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Feature)
(use Sound)
(use View)
(use Obj)

(public
	rm396 0
)

(local
	local0
	local1
	[local2 200]
	[local202 200]
)
(procedure (localproc_03b7)
	(if argc
		(= local0
			(Display
				&rest
				100
				82
				60
				101
				0
				105
				68
				102
				global137
				106
				154
				107
			)
		)
	else
		(Display 396 0 108 local0)
	)
	(return local0)
)

(instance rm396 of SQRoom
	(properties
		picture 396
		style $000a
	)
	
	(method (init)
		(but1 init:)
		(but2 init:)
		(but3 init:)
		(buckScreen init:)
		(gEgo init: hide:)
		(super init:)
		(gLongSong setVol: 25)
		(self setRegions: 700)
		(global2 setScript: startUpScript)
	)
	
	(method (doit &tmp temp0)
		(super doit:)
	)
)

(instance startUpScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gIconBar disable: 8)
				(= seconds 3)
			)
			(1
				(= ticks 30)
				(buckScreen hide:)
			)
			(2
				(Message msgGET global11 3 0 8 1 @local202)
				(localproc_03b7 @local202)
				(= local1 0)
				(proc0_3)
				(gIconBar disable: 0 1 3 5 4 6 8)
				(self dispose:)
			)
		)
	)
)

(instance shutDownScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= ticks 10)
				(buckScreen show:)
			)
			(1
				(gEgo view: 374 loop: 1)
				(gIconBar enable: 8)
				(global2 newRoom: 395)
				(self dispose:)
			)
		)
	)
)

(instance but1Script of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(soundFX number: 102 loop: 0 play:)
				(client setCel: 1)
				(= ticks 30)
			)
			(1
				(client setCel: 0)
				(if (== local1 0)
					(= local1 1)
					(localproc_03b7)
					(Message msgGET global11 3 0 5 1 @local2)
					(localproc_03b7 (Format @local202 @local2 global169))
				)
				(= cycles 10)
			)
			(2 (self dispose:))
		)
	)
)

(instance butPushScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(soundFX number: 102 loop: 0 play:)
				(client setCel: 1)
				(= ticks 30)
			)
			(1
				(client setCel: 0)
				(= cycles 2)
			)
			(2 (self dispose:))
		)
	)
)

(instance but2Script of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(soundFX number: 102 loop: 0 play:)
				(client setCel: 1)
				(= ticks 30)
			)
			(1
				(client setCel: 0)
				(= cycles 2)
			)
			(2
				(localproc_03b7)
				(= cycles 2)
				(if (== local1 0)
					(= local1 2)
					(Message msgGET global11 3 0 11 1 @local2)
					(localproc_03b7 @local2)
				else
					(gEgo get: 0)
					(= local1 3)
					(= global159 (+ global159 global169))
					(= global169 0)
					(Message msgGET global11 3 0 10 1 @local202)
					(localproc_03b7 @local202)
				)
				(= cycles 2)
			)
			(3 (self dispose:))
		)
	)
)

(instance but3Script of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(soundFX number: 102 loop: 0 play:)
				(client setCel: 1)
				(= ticks 30)
			)
			(1
				(localproc_03b7)
				(client setCel: 0)
				(if (== local1 0)
					(global2 setScript: shutDownScript)
				else
					(= local1 0)
					(Message msgGET global11 3 0 8 1 @local202)
					(localproc_03b7 @local202)
					(= cycles 2)
				)
			)
			(2 (self dispose:))
		)
	)
)

(instance buckScreen of View
	(properties
		x 106
		y 83
		view 394
	)
)

(instance but1 of Sq4Prop
	(properties
		x 20
		y 83
		view 810
	)
	
	(method (doVerb)
		(self setScript: but1Script)
	)
)

(instance but2 of Sq4Prop
	(properties
		x 20
		y 110
		view 810
	)
	
	(method (doVerb)
		(if (not (== local1 1))
			(self setScript: but2Script)
		else
			(self setScript: butPushScript)
		)
	)
)

(instance soundFX of Sound
	(properties
		number 102
		priority 5
	)
)

(instance but3 of Sq4Prop
	(properties
		x 20
		y 137
		view 810
	)
	
	(method (doVerb)
		(self setScript: but3Script)
	)
)

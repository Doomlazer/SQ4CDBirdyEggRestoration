;;; Sierra Script 1.0 - (do not remove this comment)
(script# 21)
(include sci.sh)
(use Main)
(use SQRoom)
(use Sq4Narrator)
(use Sq4Feature)
(use RandCycle)
(use n958)
(use Cycle)
(use Obj)

(public
	rm021 0
)

(local
	[local0 4]
	local4
)
(procedure (localproc_01b0 param1)
	(TextSize @local0 param1 0 315)
	(return (/ (- 180 (- [local0 2] [local0 0])) 2))
)

(instance rm021 of SQRoom
	(properties
		picture 21
	)
	
	(method (init)
		(super init:)
		(Load rsSOUND 823)
		(Load rsVIEW 24)
		(proc958_0 129 803 21)
		(Load rsFONT 0)
		(p1 init: setCycle: RandCycle)
		(p2 init: setCycle: Fwd)
		(p3 init: setCycle: Fwd)
		(proc0_14 4)
		(if (!= global12 540) (self setRegions: 707))
		(switch global12
			(20
				(gLongSong number: 823 loop: 1 play:)
				(self setScript: newRmScript)
			)
			(540
				(self setScript: endScript 0 450)
			)
			(else 
				(gLongSong number: 823 loop: 1 play:)
				(self setScript: newRmScript)
			)
		)
	)
)

(instance rmScript of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= register 700)
				(= cycles 2)
			)
			(1
				(if (and (-- register) (== global13 global11))
					(Palette palANIMATE 176 207 1)
					(if (== register 100) (gLongSong fade:))
					(-- state)
				)
				(= cycles 1)
			)
			(2 (global2 newRoom: 59))
		)
	)
)

(instance newRmScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(Palette palANIMATE 176 207 1)
	)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0 (= seconds 7))
			(1 (gLongSong fade: self))
			(2 (global2 newRoom: 59))
		)
	)
)

(instance endScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gIconBar disable:)
				(= seconds 1)
			)
			(1
				(Palette palANIMATE 176 207 1)
				(Animate (global5 elements?) 1)
				(if (-- register) (-- state))
				(= cycles 1)
			)
			(2
				(global5 eachElementDo: #hide)
				(global2 drawPic: 803 6)
				(= cycles 10)
			)
			(3
				(tCredits talkerNum: 99 noun: 99 nMsgType: 3 say: 1 self)
			)
			(4
				(tCredits talkerNum: 97 nMsgType: 1 say: 3 self)
			)
			(5
				(tCredits talkerNum: 97 noun: 97 nMsgType: 1 say: 1 self)
			)
			(6 (tCredits say: 4 self))
			(7 (tCredits say: 5 self))
			(8 (tCredits say: 7 self))
			(9 (tCredits say: 8 self))
			(10 (tCredits say: 9 self))
			(11
				(if (== local4 5)
					(= global4 1)
				else
					(if (>= (++ local4) 1) (gIconBar enable:) (proc0_2))
					(= cycles 1)
				)
			)
			(12 (= start 4) (self init:))
		)
	)
)

(instance p1 of Sq4Prop
	(properties
		x 155
		y 81
		view 24
		cycleSpeed 4
	)
)

(instance p2 of Sq4Prop
	(properties
		x 214
		y 86
		view 24
		loop 1
		cel 2
		cycleSpeed 3
	)
)

(instance p3 of Sq4Prop
	(properties
		x 85
		y 146
		view 24
		loop 2
		cel 2
		cycleSpeed 3
	)
)

(instance tCredits of Sq4Narrator
	(properties
		noun 97
		modeless 1
		talkerNum 97
		nMsgType 1
	)
	
	(method (dispose)
		(= returnVal 0)
		(global2 drawPic: 803 13)
		(super dispose: &rest)
	)
	
	(method (display theText &tmp temp0)
		(= temp0 (localproc_01b0 theText))
		(= ticks (proc999_3 240 (/ ticks 2)))
		(Display
			theText
			102
			global131
			100
			3
			temp0
			106
			315
			105
			0
			101
			1
		)
	)
)

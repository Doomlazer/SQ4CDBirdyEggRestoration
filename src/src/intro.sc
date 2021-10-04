;;; Sierra Script 1.0 - (do not remove this comment)
(script# 707)
(include sci.sh)
(use Main)
(use Sq4Dialog)
(use Game)
(use Obj)

(public
	intro 0
)

(local
	local0
)
(class intro of Rgn
	(properties
		script 0
		number 0
		modNum -1
		noun 0
		timer 0
		keep 0
		initialized 0
		iconBar 0
	)
	
	(method (init)
		(gIconBar disable:)
		(super init:)
		(= gCursorNumber (= gWaitC 996))
		(global1 setCursor: gWaitC)
		(gSq4KeyDownHandler addToFront: self)
		(gSq4MouseDownHandler addToFront: self)
	)
	
	(method (handleEvent pEvent &tmp theGWalkCursor)
		(if (and (pEvent type?) (== global11 global13))
			(pEvent claimed: 1)
			(global8 pause: 1)
			(global1 setCursor: 999)
			(SetCursor 127 99)
			(switch
				(proc816_3
					{Would you like to skip\nthe introduction or\nwatch the whole thing?}
					64
					100
					60
					109
					78
					{Skip it}
					0
					109
					78
					{Watch it}
					1
					109
					78
					{Restore a Game}
					2
				)
				(0
					(gLongSong fade: 0 1 2 1)
					(Palette palSET_INTENSITY 8 15 100)
					(= gCursorNumber (= gWaitC (ScriptID 0 19)))
					(global2 newRoom: 59)
				)
				(1
					(global8 pause: 0)
					(global1 setCursor: gWaitC)
				)
				(2
					(Palette palSET_INTENSITY 8 10 100)
					(global8 pause: 0)
					(= theGWalkCursor gWalkCursor)
					(= gWalkCursor 999)
					(global1 restore:)
					(= gWalkCursor theGWalkCursor)
					(global1 setCursor: gWaitC)
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(= keep
			(proc999_5 newRoomNumber 1 6 9 10 15 16 17 19 20 21)
		)
		(= initialized 0)
		(if (not keep)
			(gIconBar enable:)
			(= gWaitC (ScriptID 0 19))
		)
		(gSq4KeyDownHandler delete: self)
		(gSq4MouseDownHandler delete: self)
	)
)

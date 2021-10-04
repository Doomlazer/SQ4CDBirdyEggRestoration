;;; Sierra Script 1.0 - (do not remove this comment)
(script# 391)
(include sci.sh)
(use Main)
(use Class_255_0)
(use SQRoom)
(use Sq4Dialog)
(use Sq4Narrator)
(use Sq4Feature)
(use Osc)
(use RandCycle)
(use n958)
(use SysWindow)
(use Sound)
(use Cycle)
(use Obj)

(public
	rm391 0
)

(local
	local0
	theGSq4Win
	local2
	[local3 500]
)
(procedure (localproc_0084 param1)
	(global2 drawPic: 393)
	(Display
		param1
		102
		global130
		100
		2
		12
		106
		316
		105
		0
		101
		1
	)
	(Display &rest 106 270 100 25 32 105 0)
)

(instance rm391 of SQRoom
	(properties
		picture 391
		style $000a
		lookStr 3
	)
	
	(method (init)
		(proc958_0 129 392 393 803)
		(proc958_0 132 875 392 393 394 395)
		(Load rsFONT 0)
		(= theGSq4Win gSq4Win)
		(= local2 global22)
		(lEar init: setCycle: Fwd)
		(rEar init: setCycle: Fwd)
		(theMouth init: setCycle: RandCycle)
		(theEyes init: setCycle: Osc)
		(chest init: hide: stopUpd:)
		(gLongSong number: 0 loop: 1 vol: 127 stop:)
		(super init:)
		(global10 add: roboHead eachElementDo: #init doit:)
		(gLongSong2 number: 396 loop: -1 vol: 127 playBed:)
		(robotEarSnd vol: 65)
		(robotEarSnd init: play:)
		(self setScript: welcomeSir)
	)
	
	(method (dispose)
		(gLongSong fade:)
		(super dispose:)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3 (global2 newRoom: 390))
			(6 (gSq4GlobalNarrator say: 4))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance roboTalk of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0
					(Display
						register
						106
						315
						100
						118
						154
						101
						1
						105
						300
						102
						global135
						107
					)
				)
				(= seconds 3)
			)
			(1
				(Display 391 0 108 local0)
				(self dispose:)
			)
		)
	)
)

(instance welcomeSir of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 2))
			(1
				(chest show: forceUpd:)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance startTerminal of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gIconBar disable:)
				(gIconBar curIcon: (gIconBar at: 2))
				(global1 setCursor: ((gIconBar curIcon?) cursor?))
				(= gSq4Win BlueWindow)
				(= global22 0)
				(BlueWindow color: global141 back: global149)
				(DrawStatus {___} global129 0)
				(global5 eachElementDo: #hide)
				(if (== (global2 style?) 13) (global2 style: 14))
				(global2 drawPic: 392)
				(robotEarSnd init: fade:)
				(gLongSong2 number: 396 loop: -1 vol: 127 playBed:)
				(= seconds 1)
			)
			(1
				(if
					(not
						(= register
							(proc816_3
								{__}
								78
								{Instructions}
								doInstructions
								{__}
								78
								{Specials}
								doSpecials
								{__}
								78
								{Catalog}
								doCatalog
								{__}
								78
								{Exit}
								backToRob
								{_}
								64
								-1
								130
							)
						)
					)
					(= register backToRob)
				)
				(global2 style: 13)
				(= cycles 2)
			)
			(2
				(gLongSong number: (Random 392 395) play:)
				(client setScript: register)
			)
		)
	)
)

(instance doInstructions of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(BlueWindow color: global141)
				(Message msgGET global11 2 0 1 1 @local3)
				(localproc_0084 {INSTRUCTIONS} @local3 102 global135)
				(= seconds 2)
			)
			(1
				(if (!= global90 1) (newRob say: 1))
				(if
					(proc816_3
						{__}
						78
						{Continue}
						0
						{__}
						78
						{Return to Top Menu}
						1
						{__}
						64
						56
						153
					)
					(gLongSong number: (Random 392 395) play:)
					(client setScript: startTerminal)
				else
					(gLongSong number: (Random 392 395) play:)
					(Message msgGET global11 2 0 2 1 @local3)
					(localproc_0084 {INSTRUCTIONS} @local3 102 global135)
					(= seconds 2)
				)
			)
			(2
				(if (!= global90 1) (newRob say: 2))
				(if
					(proc816_3
						{_}
						78
						{Return to Top Menu}
						0
						{__}
						78
						{Limited Time Specials}
						1
						{_}
						64
						31
						157
					)
					(gLongSong number: (Random 392 395) play:)
					(client setScript: doSpecials)
				else
					(gLongSong number: (Random 392 395) play:)
					(client setScript: startTerminal)
				)
			)
		)
	)
)

(instance doSpecials of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(BlueWindow color: (proc0_18 global161 global156))
				(Message msgGET global11 2 0 3 1 @local3)
				(localproc_0084
					{SPECIALS}
					@local3
					102
					(proc0_18 global133 global132)
				)
				(= seconds 2)
			)
			(1
				(if (!= global90 1) (newRob say: 3))
				(if
					(proc816_3
						{_}
						78
						{Continue}
						0
						{_}
						78
						{Return to Top Menu}
						1
						{_}
						64
						60
						122
					)
					(gLongSong number: (Random 392 395) play:)
					(client setScript: startTerminal)
				else
					(gLongSong number: (Random 392 395) play:)
					(Message msgGET global11 2 0 4 1 @local3)
					(localproc_0084
						{SPECIALS}
						@local3
						102
						(proc0_18 global133 global132)
					)
					(= seconds 2)
				)
			)
			(2
				(if (!= global90 1) (newRob say: 4))
				(switch
					(proc816_3
						78
						{Order}
						0
						{_}
						78
						{To Top Menu}
						1
						{_}
						78
						{Automated Catalog}
						2
						64
						20
						135
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Sorry - dealers only!__}
							78
							{Continue}
							1
							64
							60
							140
						)
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: doCatalog)
					)
				)
			)
		)
	)
)

(instance doCatalog of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 200])
		(switch (= state newState)
			(0
				0
				(BlueWindow color: (proc0_18 global138 global137))
				(Message msgGET global11 2 0 3 1 @local3)
				(localproc_0084
					{- Automated Catalog -}
					{\n\n\nWelcome to our Automated Catalog!__Please select from the following departments:_}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(1
				1
				(self
					changeState:
						(proc816_3
							{_}
							78
							{Electronic Gadgets}
							2
							{__}
							78
							{The Electronic Mommy}
							13
							{_}
							109
							{_}
							109
							{_}
							78
							{TechnoTots Toy Dept.}
							21
							{__}
							78
							{Return to Top Menu}
							29
							{_}
							64
							22
							102
						)
						(gLongSong number: (Random 392 395) play:)
				)
			)
			(2
				2
				(Message msgGET global11 2 0 7 1 @local3)
				(localproc_0084
					{- Electronic Gadgets -}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(3
				3
				(if (!= global90 1) (newRob say: 7))
				(switch
					(proc816_3
						{_}
						78
						{Order}
						0
						{_}
						78
						{Continue}
						1
						{_}
						78
						{Return to Top Menu}
						2
						{_}
						64
						35
						142
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Back-ordered; none currently available.}
							109
							78
							{Continue}
							1
							64
							73
							142
						)
						(= cycles 1)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(4
				4
				(Message msgGET global11 2 0 8 1 @local3)
				(localproc_0084
					{- Electronic Gadgets -}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(5
				5
				(if (!= global90 1) (newRob say: 8))
				(switch
					(proc816_3
						{_}
						78
						{Order}
						0
						{_}
						78
						{Continue}
						1
						{_}
						78
						{Return to Top Menu}
						2
						{_}
						64
						40
						152
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Sorry - Discontinued.__}
							78
							{Continue}
							1
							64
							60
							152
						)
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(6
				6
				(Message msgGET global11 2 0 9 1 @local3)
				(localproc_0084
					{- Electronic Gadgets -}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(7
				7
				(if (!= global90 1) (newRob say: 9))
				(switch
					(proc816_3
						{_}
						78
						{Order}
						0
						{_}
						78
						{Continue}
						1
						{_}
						78
						{Return to Top Menu}
						2
						{_}
						64
						35
						142
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Sorry - Estimated delivery:\nSummer 2735.}
							109
							78
							{Continue}
							1
							64
							80
							132
						)
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(8
				8
				(Message msgGET global11 2 0 10 1 @local3)
				(localproc_0084
					{- Electronic Gadgets -}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(9
				9
				(if (!= global90 1) (newRob say: 10))
				(switch
					(proc816_3
						{_}
						78
						{Order}
						0
						{_}
						78
						{Continue}
						1
						{_}
						78
						{Return to Top Menu}
						2
						{_}
						64
						35
						144
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{You do not possess the necessary number of Buckazoids.}
							64
							60
							144
						)
						(= cycles 1)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(10
				10
				(Message msgGET global11 2 0 11 1 @local3)
				(localproc_0084
					{- Electronic Gadgets -}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(11
				11
				(if (!= global90 1) (newRob say: 11))
				(switch
					(proc816_3
						{_}
						78
						(if (or (gEgo has: 11) (proc0_6 71))
							{Exchange}
						else
							{Order}
						)
						0
						{_}
						78
						{Catalog Menu}
						1
						{_}
						78
						{Return to Top Menu}
						2
						{_}
						64
						35
						132
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(cond 
							((or (gEgo has: 11) (proc0_6 71))
								(proc816_3
									{With many a grind, moan and "Well, I dunno...", the salesbot finally allows you to exchange the plug._}
									64
									60
									132
								)
								(self setScript: choosePlug self)
							)
							((>= global159 1999)
								(proc816_3
									{With great patience, you insert each and every one of the 1999 buckazoids into the salesbot's coin receptor._}
									64
									60
									132
								)
								(if (< (= global159 (- global159 1999)) 1)
									(gEgo put: 0)
								)
								(proc0_11 84 15)
								(gEgo get: 11)
								(self setScript: choosePlug self)
							)
							(else
								(proc816_3
									{You do not possess the necessary number of Buckazoids.}
									64
									60
									132
								)
								(= cycles 1)
							)
						)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(self changeState: 0)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(12 12 (self changeState: 0))
			(13
				(Message msgGET global11 2 0 13 1 @local3)
				(localproc_0084
					{- Electronic Mommy -}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(14
				14
				(if (!= global90 1) (newRob say: 13))
				(switch
					(proc816_3
						{_}
						78
						{Order}
						0
						{_}
						78
						{Continue}
						1
						{_}
						78
						{Return to Top Menu}
						2
						{_}
						64
						35
						136
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Sorry - Recalled by manufacturer.__}
							78
							{Continue}
							1
							64
							35
							146
						)
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(15
				15
				(Message msgGET global11 2 0 14 1 @local3)
				(localproc_0084
					{- Electronic Mommy -}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(16
				16
				(if (!= global90 1) (newRob say: 14))
				(switch
					(proc816_3
						{_}
						78
						{Order}
						0
						{_}
						78
						{Continue}
						1
						{_}
						78
						{Return to Top Menu}
						2
						{_}
						64
						35
						125
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Sorry - Not available in the Spiral Arm.__}
							109
							78
							{Continue}
							1
							64
							70
							120
						)
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(17
				17
				(Message msgGET global11 2 0 15 1 @local3)
				(localproc_0084
					{- Electronic Mommy -}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(18
				18
				(if (!= global90 1) (newRob say: 15))
				(switch
					(proc816_3
						{_}
						78
						{Order}
						0
						{_}
						78
						{Continue}
						1
						{_}
						78
						{Return to top menu}
						2
						{_}
						64
						35
						163
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Sorry - Estimated date of uplink: November 2803.}
							109
							78
							{Continue}
							1
							64
							65
							145
						)
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(19
				19
				(Message msgGET global11 2 0 16 1 @local3)
				(localproc_0084
					{- Electronic Mommy -}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(20
				20
				(if (!= global90 1) (newRob say: 16))
				(switch
					(proc816_3
						78
						{Order}
						0
						{_}
						78
						{Return to Catalog Menu}
						1
						{_}
						78
						{Top Menu}
						2
						64
						20
						155
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Sorry - Currently under UCC investigation.}
							109
							78
							{Continue}
							1
							64
							68
							140
						)
						(gLongSong number: (Random 392 395) play:)
						(self changeState: 0)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(self changeState: 0)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(21
				21
				(Message msgGET global11 2 0 17 1 @local3)
				(localproc_0084
					{TechnoTots Toys}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(22
				22
				(if (!= global90 1) (newRob say: 17))
				(switch
					(proc816_3
						{_}
						78
						{Order}
						0
						{_}
						78
						{Continue}
						1
						{_}
						78
						{Return to Top Menu}
						2
						{_}
						64
						40
						135
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Sorry - Sold out.__}
							78
							{Continue}
							1
							64
							60
							135
						)
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(23
				23
				(Message msgGET global11 2 0 18 1 @local3)
				(localproc_0084
					{TechnoTots Toys}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(24
				24
				(if (!= global90 1) (newRob say: 18))
				(switch
					(proc816_3
						{_}
						78
						{Order}
						0
						{_}
						78
						{Continue}
						1
						{_}
						78
						{Return to Top Menu}
						2
						{_}
						64
						35
						135
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Sorry - Discontinued.__}
							78
							{Continue}
							1
							64
							50
							142
						)
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(25
				25
				(Message msgGET global11 2 0 19 1 @local3)
				(localproc_0084
					{TechnoTots Toys}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(26
				26
				(if (!= global90 1) (newRob say: 19))
				(switch
					(proc816_3
						{_}
						78
						{Order}
						0
						{_}
						78
						{Continue}
						1
						{_}
						78
						{Return to Top Menu}
						2
						{_}
						64
						35
						140
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Sorry - Due to delay in manufacturing, this item\nis not yet available.}
							109
							78
							{Continue}
							1
							64
							87
							125
						)
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(= cycles 1)
					)
					(2
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(27
				27
				(Message msgGET global11 2 0 20 1 @local3)
				(localproc_0084
					{TechnoTots Toys}
					@local3
					102
					(proc0_18 global138 global137)
				)
				(= seconds 2)
			)
			(28
				28
				(switch
					(proc816_3
						{_}
						78
						{Order}
						0
						{_}
						78
						{Return to Top Menu}
						1
						{_}
						64
						60
						132
					)
					(0
						(gLongSong number: (Random 392 395) play:)
						(proc816_3
							{Sorry - Sold out.__}
							78
							{Continue}
							1
							64
							80
							132
						)
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
					(1
						(gLongSong number: (Random 392 395) play:)
						(client setScript: startTerminal)
					)
				)
			)
			(29
				29
				(client setScript: startTerminal)
			)
		)
	)
)

(instance backToRob of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_14 10)
				(= gSq4Win theGSq4Win)
				(= global22 local2)
				(global2 style: 10 drawPic: 391)
				(global5 eachElementDo: #show)
				(global10 add: roboHead eachElementDo: #init doit:)
				(gEgo hide:)
				(gLongSong2 number: 396 loop: -1 vol: 127 playBed:)
				(robotEarSnd vol: 65)
				(robotEarSnd init: play:)
				(= seconds 3)
			)
			(1
				(chest dispose:)
				(= cycles 2)
			)
			(2
				(self
					setScript: roboTalk self { THANK YOU\nFOR SHOPPING\nHz SO GOOD!}
				)
				(= cycles 5)
			)
			(3
				(proc0_3)
				(global2 newRoom: 390)
			)
		)
	)
)

(instance choosePlug of Script
	(properties)
	
	(method (changeState newState &tmp temp0 newConnector temp2 temp3)
		(switch (= state newState)
			(0
				(global2 drawPic: 803 100)
				(= register (List new:))
				(= temp0 0)
				(while (< temp0 10)
					(= temp2 (+ 120 (* 50 (/ temp0 5))))
					(= temp3 (+ 30 (* 30 (mod temp0 5))))
					((= newConnector (connector new:))
						setCel: temp0
						x: temp2
						y: temp3
						init:
					)
					(register addToFront: newConnector)
					(++ temp0)
				)
				(Display
					{Select the plug you\n wish to purchase.}
					@local3
					100
					97
					163
					102
					global135
				)
			)
			(1
				(register eachElementDo: #dispose)
				(= cycles 2)
			)
			(2
				(register dispose:)
				(self dispose:)
			)
		)
	)
)

(instance theEyes of Sq4Prop
	(properties
		x 162
		y 25
		view 391
		loop 4
		lookStr 5
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4 (gSq4GlobalNarrator say: 6))
			(6 (gSq4GlobalNarrator say: 1))
			(7 (gSq4GlobalNarrator say: 2))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lEar of Sq4Prop
	(properties
		x 79
		y 26
		view 391
		loop 1
		lookStr 7
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(7 (gSq4GlobalNarrator say: 8))
			(6 (gSq4GlobalNarrator say: 1))
			(7 (gSq4GlobalNarrator say: 2))
			(4 (gSq4GlobalNarrator say: 9))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rEar of Sq4Prop
	(properties
		x 245
		y 26
		view 391
		loop 2
		lookStr 7
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(7 (gSq4GlobalNarrator say: 8))
			(6 (gSq4GlobalNarrator say: 1))
			(7 (gSq4GlobalNarrator say: 2))
			(4 (gSq4GlobalNarrator say: 9))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theMouth of Sq4Prop
	(properties
		x 162
		y 60
		view 391
		loop 3
		lookStr 10
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(7 (gSq4GlobalNarrator say: 11))
			(6 (gSq4GlobalNarrator say: 12))
			(4 (gSq4GlobalNarrator say: 13))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance roboHead of Sq4Prop
	(properties
		x 160
		y 9
		view 391
		lookStr 14
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(7 (gSq4GlobalNarrator say: 2))
			(6 (gSq4GlobalNarrator say: 15))
			(4 (gSq4GlobalNarrator say: 16))
			(2 (gSq4GlobalNarrator say: 17))
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chest of Sq4View
	(properties
		x 161
		y 189
		view 393
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(7 (gSq4GlobalNarrator say: 18))
			(6 (gSq4GlobalNarrator say: 19))
			(else 
				(global2 setScript: startTerminal)
			)
		)
	)
	
	(method (onMe param1)
		(return
			(if
				(and
					(<= nsLeft (param1 x?))
					(<= (param1 x?) nsRight)
					(<= nsTop (param1 y?))
				)
				(<= (param1 y?) nsBottom)
			else
				0
			)
		)
	)
)

(instance connector of Sq4View
	(properties
		view 391
		loop 5
		priority 15
		signal $0010
		lookStr 21
	)
	
	(method (init)
		(super init:)
		(gSq4MouseDownHandler addToFront: self)
		(gSq4KeyDownHandler addToFront: self)
	)
	
	(method (handleEvent pEvent)
		(if
			(or
				(proc255_2 self pEvent)
				(and
					(== (pEvent type?) evKEYBOARD)
					(== (pEvent message?) KEY_RETURN)
				)
			)
			(pEvent claimed: 1)
			((gInv at: 11) state: cel)
			(choosePlug cue:)
		)
	)
	
	(method (delete)
		(super delete:)
		(gSq4MouseDownHandler delete: self)
		(gSq4KeyDownHandler delete: self)
	)
)

(instance newRob of Sq4Narrator
	(properties
		noun 23
		modNum 391
		talkerNum 23
		nMsgType 2
	)
)

(instance BlueWindow of SysWindow
	(properties)
)

(instance robotEarSnd of Sound
	(properties
		number 875
		vol 65
		loop -1
	)
)

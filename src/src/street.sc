;;; Sierra Script 1.0 - (do not remove this comment)
(script# 701)
(include sci.sh)
(use Main)
(use RegionPath)
(use Sq4Feature)
(use ForwardCounter)
(use n958)
(use Grooper)
(use n982)
(use Sound)
(use Cycle)
(use Game)
(use Obj)

(public
	street 0
	deathDroid 1
	cyborgPath 2
	cyborgScreams 3
	droidShoots 4
	cyborg 5
)

(local
	cyborgLoop =  -1
	local1
	local2
	[local3 74] = [0 0 0 0 314 -74 278 120 214 195 152 321 152 321 314 -72 314 -72 240 178 210 333 210 333 314 -72 314 -72 220 165 327 320 327 320 -73 -83 -73 -83 76 183 6 296 6 296 -65 94 -65 94 55 191 133 320 133 320 -24 14 -24 14 70 191 164 298 164 298 -24 180 -24 180 160 160 100 160 100 160]
	[local77 129] = [32767 30 100 500 200 500 32767 35 0 132 24 76 79 57 46 108 100 250 32767 50 0 65 220 75 218 73 40 128 30 250 32767 65 0 100 15 100 103 125 145 151 -5 173 32767 60 319 157 239 175 239 181 -5 150 32767 55 319 100 238 100 295 -1 32767 40 221 250 195 97 79 78 278 35 302 -1 32767 25 91 219 210 145 297 250 32767 40 310 55 270 150 285 250 32767 55 319 65 228 68 109 163 125 145 140 163 242 83 325 83 32767 60 0 140 325 140 32767 65 0 170 60 160 -5 95 32767 50 101 219 90 96 101 92 -5 103 -32768]
	[local206 48] = [-2 -46 1 0 0 0 8 -44 1 0 0 0 13 -43 3 11 -45 3 5 -43 3 9 -43 3 -3 -42 1 0 0 0 -11 -43 2 -8 -43 2 -14 -43 2 -9 -43 2 -6 -46 1]
	[local254 16] = [0 60 -30 30 -60 0 -30 -30 0 -60 30 -30 60 0 30 30]
)
(procedure (localproc_0e27 param1)
	(return
		(if (>= param1 22)
			(return (- param1 22))
		else
			(return (- 360 (- 22 param1)))
		)
	)
)

(class street of Rgn
	(properties
		script 0
		number 0
		modNum -1
		noun 0
		timer 0
		keep 0
		initialized 0
		gracePeriod 4200
	)
	
	(method (init)
		(super init: &rest)
		(= local1 (Random 500 1000))
		(proc958_0 128 26)
		(streetSoundFX init:)
		(if (not (proc0_6 0))
			(proc958_0 128 25 51)
			(cyborg
				init:
				setLoop: Grooper
				setCycle: Walk
				setMotion: cyborgPath
			)
		)
	)
	
	(method (doit)
		(super doit:)
		(if gracePeriod (-- gracePeriod))
		(if (and (> local1 0) (not (deathDroid script?)))
			(= local1 (- local1 1))
		else
			(= local1 (Random 500 1000))
			(if
				(and
					(not gracePeriod)
					(not (global2 script?))
					(not (proc0_6 0))
					(< (deathDroid z?) 100)
					(not (deathDroid script?))
					(!= global11 45)
					(!= global11 30)
					(!= global11 60)
				)
				(deathDroid
					init:
					setCycle: turnCycle
					setScript: lookScript
				)
				(gLongSong2 number: 21 vol: 127 loop: -1 flags: 1 play:)
				(gLongSong stop:)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(= keep
			(proc999_5 newRoomNumber 25 30 35 40 45 50 55 60 65)
		)
		(= initialized 0)
		(if (== (gLongSong2 number?) 21) (gLongSong2 fade:))
		(if (== (gLongSong prevSignal?) -1)
			(gLongSong
				number: 801
				loop: -1
				vol: 0
				flags: 1
				playBed:
				fade: 127 15 10 0
			)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance deathDroid of Sq4Actor
	(properties
		z 45
		yStep 5
		view 25
		priority 14
		signal $6810
		illegalBits $0000
		xStep 5
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 701 say: 1)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (isNotHidden)
		(return (not (proc982_0 self)))
	)
)

(instance cyborg of Sq4Actor
	(properties
		sightAngle 45
		yStep 1
		view 51
		signal $6000
		illegalBits $0000
		xStep 2
	)
	
	(method (doit)
		(super doit: &rest)
		(if (deathDroid script?)
			(cyborg setMotion: 0)
			(if (== cyborgLoop -1) (= cyborgLoop (cyborg loop?)))
			(proc0_13 cyborg deathDroid)
		)
		(if
			(and
				(not (cyborg z?))
				(!= (global2 script?) cyborgScreams)
				(!= (global2 script?) (ScriptID 812 0))
				(< (cyborg distanceTo: gEgo) 60)
				(!= (gEgo onControl: 1) 256)
				(not (deathDroid script?))
				(or
					(<
						(Abs
							(-
								(GetAngle (cyborg x?) (cyborg y?) (gEgo x?) (gEgo y?))
								(cyborg heading?)
							)
						)
						49
					)
					(< (cyborg distanceTo: gEgo) 30)
				)
			)
			(if
				(and
					(== global11 50)
					(== (global2 script?) (ScriptID 50 1))
					(== (gEgo view?) 50)
				)
				(cyborg setMotion: 0)
				(proc0_13 cyborg gEgo)
			else
				(proc0_2)
				(gEgo setMotion: 0)
				(global2 setScript: cyborgScreams)
			)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gSq4GlobalNarrator modNum: 701 say: 2)
			)
			(2
				(gSq4GlobalNarrator modNum: 701 say: 3)
			)
			(6
				(gSq4GlobalNarrator modNum: 701 say: 4)
			)
			(7
				(gSq4GlobalNarrator modNum: 701 say: 5)
			)
			(else  (super doVerb: theVerb))
		)
	)
	
	(method (isNotHidden)
		(return (not (proc982_0 self)))
	)
)

(instance cyborgPath of RegionPath
	(properties
		theRegion 701
	)
	
	(method (nextRoom)
		(if
			(and
				(== global11 (self at: (+ value 2)))
				(<
					(GetDistance
						(self at: (+ value 3))
						(self at: (+ value 4))
						(gEgo x?)
						(gEgo y?)
					)
					50
				)
			)
			(repeat
				(= value (- value 2))
				(breakif (== (self at: (+ 1 value)) 32767))
			)
		)
		(super nextRoom: &rest)
	)
	
	(method (at param1)
		(return [local77 param1])
	)
)

(instance lookScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2
					(switch global11
						(25 4)
						(35 54)
						(40 14)
						(50 44)
						(55 24)
						(60 64)
						(65 34)
					)
				)
				(self register: (if (> (gEgo y?) 120) -1 else 1))
				(deathDroid
					x: [local3 (+ local2 (* 4 register) 4)]
					y: [local3 (+ local2 (* 4 register) 5)]
					setCycle: turnCycle
					setMotion:
						MoveTo
						[local3 (+ local2 (* 2 register) 4)]
						[local3 (+ local2 (* 2 register) 5)]
						self
				)
			)
			(1
				(deathDroid
					setMotion: MoveTo [local3 (+ local2 4)] [local3 (+ local2 5)] self
				)
			)
			(2
				(if
					(or
						(and
							(or
								(not (global2 script?))
								(== (global2 script?) cyborgScreams)
								(== (global2 script?) (ScriptID 705 2))
							)
							(!= (gEgo onControl: 1) 256)
						)
						(== (global2 script?) cyborgScreams)
					)
					(proc0_2)
					(deathDroid cycleSpeed: 18 setScript: droidShoots)
				else
					(deathDroid cycleSpeed: 18 setCycle: End self)
					(proc0_11 45 5)
				)
			)
			(3
				(deathDroid loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(if
					(and
						(not (global2 script?))
						(!= (gEgo onControl: 1) 256)
					)
					(proc0_2)
					(deathDroid setScript: droidShoots)
				else
					(= cycles 1)
				)
			)
			(5
				(deathDroid
					setCycle:
						CT
						(if (== register -1)
							(switch global11
								(25 5)
								(35 3)
								(40 5)
								(50 3)
								(55 4)
								(65 4)
							)
						else
							(switch global11
								(25 1)
								(35 7)
								(40 1)
								(50 7)
								(55 1)
								(65 7)
							)
						)
						-1
						self
				)
			)
			(6
				(deathDroid
					cycleSpeed: 6
					setCycle: turnCycle
					setMotion:
						MoveTo
						[local3 (+ local2 (* 2 register -1) 4)]
						[local3 (+ local2 (* 2 register -1) 5)]
						self
				)
			)
			(7
				(deathDroid
					setMotion:
						MoveTo
						[local3 (+ local2 (* 4 register -1) 4)]
						[local3 (+ local2 (* 4 register -1) 5)]
						self
				)
				(cyborg setLoop: -1)
				(gLongSong2 fade:)
			)
			(8
				(deathDroid dispose:)
				(gLongSong
					number: 801
					loop: -1
					vol: 0
					playBed:
					flags: 1
					fade: 127 15 10 0
				)
				(cyborg
					loop: cyborgLoop
					setLoop: Grooper
					setCycle: Walk
					setMotion: cyborgPath
				)
				(= cyborgLoop -1)
				(lookScript start: 0)
				(proc0_3)
				(client setScript: 0)
			)
		)
	)
)

(instance droidShoots of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(deathDroid
					setCycle:
						CT
						(proc999_2
							7
							(/
								(*
									(GetAngle
										(deathDroid x?)
										(deathDroid y?)
										(gEgo x?)
										(gEgo y?)
									)
									4
								)
								180
							)
						)
						-1
						self
				)
			)
			(1
				(if (< (deathDroid distanceTo: gEgo) 30)
					(if
					(and (< 2 (deathDroid cel?)) (< (deathDroid cel?) 7))
						(deathDroid setPri: 13)
					)
					(deathDroid
						xStep: 10
						yStep: 10
						setCycle: 0
						setMotion:
							MoveTo
							(+ (deathDroid x?) [local254 (* (deathDroid cel?) 2)])
							(+
								(deathDroid y?)
								[local254 (+ (* (deathDroid cel?) 2) 1)]
							)
							self
					)
				else
					(deathDroid setCycle: 0)
					(= cycles 2)
				)
			)
			(2 (proc0_2) (= cycles 2))
			(3
				(proc0_2)
				(proc0_13 gEgo deathDroid)
				(gEgo setMotion: 0)
				(= cycles 2)
			)
			(4
				(proc0_2)
				(gunFire1
					init:
					x: (+ (deathDroid x?) [local206 (* (deathDroid cel?) 6)])
					y: (+
						(deathDroid y?)
						[local206 (+ (* (deathDroid cel?) 6) 1)]
					)
					loop: [local206 (+ (* (deathDroid cel?) 6) 2)]
					setPri:
						(if
						(and (< 2 (deathDroid cel?)) (< (proc0_2) 7))
							14
						else
							12
						)
					setCycle: End
				)
				(if
					(and
						(< 1 [local206 (+ (* (deathDroid cel?) 6) 2)])
						(<
							(gunFire1
								init:
								x: (+ (deathDroid x?) [local206 (* (deathDroid cel?) 6)])
								y: (+
									(deathDroid y?)
									[local206 (+ (* (deathDroid cel?) 6) 1)]
								)
								loop: [local206 (+ (* (deathDroid cel?) 6) 2)]
								setPri:
									(if
									(and (< 2 (deathDroid cel?)) (< (proc0_2) 7))
										14
									else
										12
									)
								setCycle: End
							)
							4
						)
					)
					(gunFire2
						init:
						x: (+
							(deathDroid x?)
							[local206 (+ (* (deathDroid cel?) 6) 3)]
						)
						y: (+
							(deathDroid y?)
							[local206 (+ (* (deathDroid cel?) 6) 4)]
						)
						loop: [local206 (+ (* (deathDroid cel?) 6) 5)]
						setPri:
							(if
							(and (< 2 (deathDroid cel?)) (< (deathDroid cel?) 7))
								14
							else
								12
							)
						setCycle: End
					)
				)
				(= cycles 3)
			)
			(5
				(proc0_2)
				(streetSoundFX number: 106 loop: 1 play:)
				(= cycles 3)
			)
			(6
				(streetSoundFX play:)
				(if (IsObject (ScriptID 705 3))
					((ScriptID 705 3) dispose:)
				)
				(proc0_2)
				(gLongSong number: 135 loop: -1 vol: 127 flags: 0 play:)
				(gEgo
					view: 26
					normal: 0
					loop:
						(switch (gEgo loop?)
							(4 0)
							(5 1)
							(6 0)
							(7 1)
							(else  (gEgo loop?))
						)
					cel: 0
					cycleSpeed: 6
					setCycle: CT 1 1
					setMotion: 0
				)
				(= cycles 3)
			)
			(7
				(streetSoundFX play:)
				(proc0_2)
				(gunFire1 dispose:)
				(gunFire2 dispose:)
				(gEgo setCycle: Beg self)
			)
			(8 (gEgo setCycle: CT 1 1 self))
			(9 (gEgo setCycle: Beg self))
			(10
				(gEgo setCycle: CT 1 1 self)
			)
			(11 (gEgo setCycle: Beg self))
			(12 (gEgo setCycle: End self))
			(13
				(gLongSong stop:)
				(= seconds 3)
				(gLongSong2 fade:)
			)
			(14 (proc0_10 8))
		)
	)
)

(instance cyborgScreams of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_13 cyborg gEgo)
				(proc0_13 gEgo cyborg)
				(= cycles 3)
			)
			(1
				(gIconBar disable:)
				(= cycles 1)
			)
			(2
				((ScriptID 705 1) dispose:)
				(Load rsSOUND 114)
				(cyborg hide: setMotion: 0)
				(deathDroid mover: 0)
				(gEgo hide:)
				(DrawPic 31 dpOPEN_FADEPALETTE)
				(global2 curPic: 31)
				(theMouth init:)
				(= cycles 1)
			)
			(3
				(gLongSong stop:)
				(gLongSong2 number: 829 loop: -1 vol: 127 flags: 1 play:)
				(gIconBar enable:)
				(proc0_2)
				(= seconds 3)
			)
			(4
				(theMouth setCycle: ForwardCounter 9 self)
			)
			(5
				(theMouth
					posn: 142 106
					setLoop: 1
					setCycle: ForwardCounter 7 self
				)
			)
			(6
				(theMouth
					posn: 152 104
					setLoop: 2
					setCycle: ForwardCounter 5 self
				)
			)
			(7
				(hand init:)
				(theMouth posn: 151 127 setLoop: 3 setCycle: Fwd)
				(streetSoundFX number: 114 loop: 1 flags: 1 play: self)
			)
			(8
				(gIconBar disable:)
				(= cycles 1)
			)
			(9
				(hand dispose:)
				(theMouth dispose:)
				(cyborg show:)
				(gEgo show:)
				(DrawPic global11)
				(global2 curPic: global11)
				(UnLoad 132 114)
				(UnLoad 129 31)
				(proc958_0 128 25 26)
				(proc958_0 132 106 135)
				(= cycles 1)
			)
			(10
				(gIconBar enable:)
				(gLongSong2 number: 21 vol: 127 loop: -1 flags: 1 play:)
				(gLongSong stop:)
				(deathDroid
					init:
					setCycle: turnCycle
					setScript: lookScript
				)
				(cyborg setMotion: 0)
			)
			(11 0)
		)
	)
)

(instance theMouth of Sq4Actor
	(properties
		x 153
		y 106
		view 31
		signal $6000
	)
)

(instance hand of Sq4View
	(properties
		x 118
		y 189
		view 31
		loop 4
		signal $6000
	)
)

(instance gunFire1 of Sq4Prop
	(properties
		z 45
		view 25
		loop 1
		signal $4000
	)
)

(instance gunFire2 of Sq4Prop
	(properties
		z 45
		view 25
		loop 2
		signal $4000
	)
)

(instance turnCycle of Fwd
	(properties)
	
	(method (nextCel)
		(return (+ (/ (* (localproc_0e27 (client heading?)) 4) 180) 1))
	)
)

(instance streetSoundFX of Sound
	(properties
		number 106
	)
)

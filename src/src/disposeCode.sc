;;; Sierra Script 1.0 - (do not remove this comment)
(script# 801)
(include sci.sh)
(use Main)
(use n958)
(use Obj)

(public
	disposeCode 0
)

(instance disposeCode of Code
	(properties)
	
	(method (doit param1)
		(proc958_0
			0
			939
			974
			969
			966
			965
			964
			956
			982
			951
			961
			942
			945
			946
			812
			808
			708
			810
			807
			819
			929
			765
			921
			816
			818
			934
			811
			978
		)
		(if
			(or
				(and
					(proc999_5 param1 25 30 35 40 45 50 55 60 65)
					(!= global102 701)
				)
				(and
					(proc999_5
						param1
						370
						371
						375
						376
						380
						381
						385
						386
						387
						390
						391
						395
						396
						397
						398
						399
						400
						405
						406
						410
						411
						290
					)
					(!= global102 700)
				)
				(and
					(proc999_5
						param1
						150
						500
						505
						510
						514
						515
						520
						525
						541
						544
						545
					)
					(!= global102 704)
				)
				(not
					(proc999_5
						param1
						25
						30
						35
						40
						45
						50
						55
						60
						65
						370
						371
						375
						376
						380
						381
						385
						386
						387
						390
						391
						395
						396
						397
						398
						399
						400
						405
						406
						410
						411
						290
						150
						500
						505
						510
						514
						515
						520
						525
						541
						544
						545
					)
				)
			)
			(DisposeScript 806)
		)
		(if (not (proc999_5 param1 405 406 410 411))
			(DisposeScript 809)
		)
		(DisposeScript 800)
		(DisposeScript 801)
	)
)

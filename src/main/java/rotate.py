def rotate(a,k):
	i = 0
	j = 0
	while 1:
		if j > len(a):
			break

		target =	(i + k) % len(a)
		backup = a[ target ]
		a[target] = a[i]
		i = target
		j+=1
	print a


rotate([1,2,3,4,5],3)


n=5

while [ $n -ge 1 ]
do
	echo -e "$n \n"
	n=$(expr $n - 1)
done

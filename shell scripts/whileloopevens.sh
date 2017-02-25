
echo "Enter lower limit: "
read ll

echo "Enter upper limit: "
read ul
a=$ll

echo -e "\nEven numbers: "
while [ $a -le $ul ]
do
	if [[ $(expr $a % 2) -eq 0 ]]
	then	echo $a
	fi

	a=$(expr $a + 1)
done

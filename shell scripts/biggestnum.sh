
# Run as: bash <filename>.sh 1 2 3

a=${1}
b=${2}
c=${3}

echo $a $b $c
echo -e "\nBiggest of three args:" 


if [ $a -gt $b ]
then
	if [ $a -gt $c ]
	then 	echo $a
	else
		echo $c
	fi

elif [ $b -gt $c ]
then
	echo $b

else
	echo $c
fi


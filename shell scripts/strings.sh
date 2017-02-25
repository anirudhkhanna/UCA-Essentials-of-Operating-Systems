
read st1
read st2

if [[ $st1 == $st2 ]]
then
	echo "Same!";

elif [[ $st1 > $st2 ]]
then
	echo "$st1 > $st2";

else
	echo "$st1 < $st2";
fi

len=${#st1};

echo -e "\nLength of str1 = $len";

stroffset=${st2:0:3}	#Means 3 elements from the 0th position.

echo -e "\nstring with offset = $stroffset \n";


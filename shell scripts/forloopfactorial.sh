
echo -e "\nEnter a number: "

read n

F=1

for((i=1;i<=$n;i++))
do
	F=`expr $F \* $i`
done

echo -e "\nFactorial = $F";

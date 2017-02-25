
echo -e "\n\nEnter number: "

read n

sum=0

while [ $n -ne 0 ]
do
	dig=$(expr $n % 10)
	n=$(expr $n / 10)
	sum=$(expr $sum + $dig)
done

echo -e "\nSum of digits: $sum"


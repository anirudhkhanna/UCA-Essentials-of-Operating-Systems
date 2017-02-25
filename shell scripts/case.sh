
# Run as: bash <filename>.sh -
#     OR  bash <filename>.sh +
#     OR  bash <filename>.sh x
#     OR  bash <filename>.sh /

option="${1}"

read a
read b

case $option in
+)
	echo -e "\n\nAddition "
	expr $a + $b
;;

-)
	echo -e "\n\nSubtraction "
	expr $a - $b
;;

x)	# As '*' would mean default case!
	echo -e "\n\nMultiplication "
	expr $a \* $b
;;

/)
	echo -e "\n\nDivision "
	expr $a / $b
;;
esac

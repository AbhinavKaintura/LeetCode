class toRoman:
    def intToRoman(self, num: int) -> str:

        thousands = ["", "M", "MM", "MMM"]
        hundreds = ["","C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"]
        tens = ["","X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"]
        ones = ["","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"]

        ans = thousands[int(num/1000)] + hundreds[int((num%1000)/100)] + tens[int((num%100)/10)] + ones[int(num%10)]
        return ans
    
print(toRoman().intToRoman(3749))
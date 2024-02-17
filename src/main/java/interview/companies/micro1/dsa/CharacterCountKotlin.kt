package interview.companies.micro1.dsa

/*
    Developer: Sandeep Prajapati
    Input String: "aaabddcccbaadd"
    Expected Result: "a5b2c3d4"
 */
fun main(args: Array<String>) {
    val input = "aaabddcccbaadd";
    println("Expected Result: " + compressString(input));
}

fun compressString(input: String): String{
    val hashMap = getHashMapFromStringInput(input);
    return getStringFromHashMap(hashMap);
}

private fun getStringFromHashMap(hashMap: HashMap<Char, Int>): String {
    val stringBuilder = StringBuilder();

    for((key, value) in hashMap){
        stringBuilder.append(key);
        stringBuilder.append(value);
    }

    return stringBuilder.toString();
}

private fun getHashMapFromStringInput(input: String): HashMap<Char, Int> {
    // convert input string to char[]
    val charArray = input.toCharArray();
    val integerHashMap = HashMap<Char, Int>();

    for(z in charArray){
        if(integerHashMap.containsKey(z)){
            integerHashMap[z] = integerHashMap[z]!! + 1;
        }else{
            integerHashMap[z] = 1;
        }
    }
    return integerHashMap;
}

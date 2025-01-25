class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length -1;
        
        int [] recursionDigits = plusOneRecursion(digits, index);
        if(recursionDigits[0] == 10){
            int recursionDigitsIndex = 1;
            int [] resultDigits = new int[recursionDigits.length + 1];
            for(int i = 2 ; i < resultDigits.length ; i++){
                resultDigits[i] = recursionDigits[recursionDigitsIndex++];
            }
            resultDigits[0] = 1;
            resultDigits[1] = 0;
            return resultDigits;
        }
        return recursionDigits;
    }
    
    private int[] plusOneRecursion(int[] array, int index){
        if(array[index] + 1 == 10){
            if(index == 0){
                array[index]++;
                return array;
            }
            array[index] = 0;
          return plusOneRecursion(array, index-1);
        } 
        array[index]++;
        return array;
    }
}
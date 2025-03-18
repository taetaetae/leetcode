class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0){
            return 0;
        }

        int sign = 1;
        int index = 0;
        if(s.charAt(0) == '-'){
            sign = -1;
            index++;
        }else if(s.charAt(0) == '+'){
            index++;
        }

        int result = 0;
        while(index < s.length()){
            char ch = s.charAt(index);
            if(ch < '0' || ch > '9'){
                break;
            }
            int digit = ch - '0';
            if(result > (Integer.MAX_VALUE - digit) / 10 ){
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
            index++;
        }
        System.out.println(result);

        return sign * result;
    }
}

/*
91283472332
2147483647
*/
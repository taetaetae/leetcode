class Solution {
    public String addBinary(String a, String b) {
        char aArray[] = a.toCharArray();
        char bArray[] = b.toCharArray();

        StringBuilder sb = new StringBuilder();
        int aIndex = aArray.length - 1;
        int bIndex = bArray.length - 1;
        int carray = 0;
        while(aIndex >= 0 || bIndex >= 0 || carray > 0){
            int aNum = aIndex >= 0 ? aArray[aIndex] - '0' : 0;
            int bNum = bIndex >= 0 ? bArray[bIndex] - '0' : 0;

            int sum = aNum + bNum + carray;
            int digit = sum % 2;
            carray = sum / 2;

            aIndex--;
            bIndex--;
            sb.append((char)(digit + '0'));
        }

        return sb.reverse().toString();
    }
}
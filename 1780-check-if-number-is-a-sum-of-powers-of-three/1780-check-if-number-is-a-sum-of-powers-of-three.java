class Solution {
    public boolean checkPowersOfThree(int n) {
    int maxDelta = 14;
    while (maxDelta >= 0 && n > 0) {
      int pow = (int) Math.pow(3, maxDelta);
      if (n >= pow) {
        n -= pow;
      }
      maxDelta--;
    }
    return n == 0;
  }
}
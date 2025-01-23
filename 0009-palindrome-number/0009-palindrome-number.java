class Solution {
public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }

    int beforeX = x;
    int pow = 0;
    int palindrome = 0;
    while (x >= 10) {
      palindrome *= 10;
      palindrome += (x % 10);
      x = x / 10;
    }

    palindrome *= 10;
    palindrome += (x % 10);
    return beforeX == palindrome;

  }
}
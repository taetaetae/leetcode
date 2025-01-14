class Solution {
    Set<Integer> resultSets = new HashSet<>();

    public boolean isHappy(int n) {
    /*
    자릿수 증가하면서 수 추출, 제곱 하여 누적 더함. 마지막 한자리는 그냥 제곱하여 더함
    반복
    1의자리수가 나오면 중단. 1인가 아닌가
     */

    do {
      n = sumOfSquaresDigits(n);
    } while (n >= 2);

    return n != 0;
  }

  public int sumOfSquaresDigits(int num) {
    int sum = 0;
    while (num > 0) {
      int digitsNum = num % 10;
      sum += (digitsNum * digitsNum);
      num = num / 10;
    }
    int result = sum + num * num;
    if (resultSets.contains(result)) {
      return 0;
    }
    resultSets.add(result);
    return result;
  }
}
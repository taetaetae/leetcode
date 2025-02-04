class Solution {

    class Pair {

      int maxDigitNum;
      int num;

      Pair(int maxDigitNum, int num) {
        this.maxDigitNum = maxDigitNum;
        this.num = num;
      }
    }

    public int maxSum(int[] nums) {
      /*
      여러 숫자들이 들어오고
      각 숫자들에서 가장 큰 숫자를 구하고
      여러 숫자들 중 가장 큰 숫자 쌍의 숫자들의 합

      객체 만들고 (가장 큰수, 실제 수)
      숫자들 순회하면서 가장 큰수, 실제 수 찾아서 우선수위 큐에 넣고
      우선순위 큐에서 상위꺼 빼면서 첫번째꺼랑 같은 큰수의 실제 수들의 합을 리턴
      첫번재랑 두번째랑 다르면 (가장 큰수의 쌍이 없을경우) -1 리턴

      객체 만들고 (가장 큰수, 실제 수)
      순회하면서 가장 큰수 기준으로 모아서(hashMap) 값들중에 가장 큰 두개의 합을 리턴
      가장 큰 두개의 합 > 우선순위 큐

      객체 만들고 (가장 큰수, 실제 수)
      순회하면서 큰수 기준 묶고
        PriorityQueue<Integer> maxDigitNum;
        Map<Integer, PriorityQueue<Integer>> maxDigitNumMap;

      maxDigitNum 상위부터 map에서 찾는데 2개가 미만이면 -1
      2개 이상일 경우 그 상위 2개 뽑아서 합


       */
      Map<Integer, PriorityQueue<Integer>> maxDigitNumMap = new HashMap<>();
      PriorityQueue<Integer> maxDigitNumQueue = new PriorityQueue<>((n1, n2) -> n2 - n1);

      for (int num : nums) {
        int maxDigitNum = getMaxDigitNum(num);
        if (maxDigitNumMap.containsKey(maxDigitNum)) {
          maxDigitNumMap.get(maxDigitNum).add(num);
        } else {
          PriorityQueue<Integer> numQueue = new PriorityQueue<>((n1, n2) -> n2 - n1);
          numQueue.add(num);
          maxDigitNumMap.put(maxDigitNum, numQueue);
          maxDigitNumQueue.add(maxDigitNum);
        }
      }

      int max = 0;
      while (!maxDigitNumQueue.isEmpty()) {
        Integer digitNum = maxDigitNumQueue.poll();
        PriorityQueue<Integer> priorityQueue = maxDigitNumMap.get(digitNum);
        if (priorityQueue.size() < 2) {
          continue;
        }
        int sum = priorityQueue.poll() + priorityQueue.poll();
        if (sum > max) {
          max = sum;
        }
      }
      return max == 0 ? -1 : max;
    }

    public int getMaxDigitNum(int num) {
      int maxNum = 0;
      while (num > 0) {
        int digit = num % 10;
        if (maxNum < digit) {
          maxNum = digit;
        }
        num = num / 10;
      }
      return maxNum;
    }

  }
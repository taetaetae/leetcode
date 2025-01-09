class Solution {
    public boolean isPalindrome(String s) {
        /*
    공백을 제거하고 + 대소문자 구분없이 + 영문자 기준만 보고
    앞뒤 문자들이 대칭을 이루는가?
    raceacar
    01234567

    length = 8
    center = length/2

    amanaplanacanalpanama
    012345678901234567890

    앞 뒤에서 한칸씩 오면서 영문자가 아닌 경우 제외하고
    같으면 한칸씩 더 당기고, 다르면 false
    앞 뒤 인덱스가 서로를 넘어서면 중단
    O(n)
     */

    // A man, a plan, a canal: Panama

    boolean result = true;
    int frontIndex = 0, backIndex = s.length() - 1;
    while (frontIndex < backIndex) {
      IndexAndValue frontIndexAndValue = getIndexAndValue(s, frontIndex, Direction.PLUS);
      IndexAndValue backIndexAndValue = getIndexAndValue(s, backIndex, Direction.MINUS);
      if (Character.toLowerCase(frontIndexAndValue.value) != Character.toLowerCase(backIndexAndValue.value)) {
        return false;
      }

      frontIndex = frontIndexAndValue.index;
      backIndex = backIndexAndValue.index;

    }
    return result;
  }

  private IndexAndValue getIndexAndValue(String s, int index, Direction direction) {
    char checkChar;
    boolean find = false;
    int beforeIndex = index;

    do {
      checkChar = s.charAt(index);
      if (Direction.PLUS.equals(direction)) {
        index++;
      } else {
        index--;
      }
      if(isAlphanumeric(checkChar)){
        find = true;
        break;
      }
    } while (index < s.length() && index >= 0);

    if(find){
      return new IndexAndValue(index, checkChar);
    }
    if (Direction.PLUS.equals(direction)) {
      beforeIndex++;
    } else {
      beforeIndex--;
    }
    return new IndexAndValue(beforeIndex,' ');
  }

  private boolean isAlphanumeric(char checkChar) {
    return (checkChar >= 'a' && checkChar <= 'z') ||
        (checkChar >= 'A' && checkChar <= 'Z') ||
        (checkChar >= '0' && checkChar <= '9');
  }

  class IndexAndValue {

    int index;
    char value;

    IndexAndValue(int index, char value) {
      this.index = index;
      this.value = value;
    }
  }

  enum Direction {
    PLUS, MINUS
  }
}
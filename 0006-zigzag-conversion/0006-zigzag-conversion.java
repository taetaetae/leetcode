class Solution {
    public String convert(String s, int numRows) {
        if(numRows ==1 ){
      return s;
    }
    String[] zigzagArray = new String[numRows];

    Direction direction = Direction.DOWN;
    int directionIndex = 1;
    zigzagArray[0] = String.valueOf(s.charAt(0));

    for (int i = 1; i < s.length(); i++) {
      if (zigzagArray[directionIndex] == null) {
        zigzagArray[directionIndex] = "";
      }

      zigzagArray[directionIndex] += s.charAt(i);

      if (Direction.DOWN.equals(direction)) {
        if (i % (numRows - 1) == 0) {
          direction = Direction.UP;
          directionIndex--;
        }else{
          directionIndex++;
        }
      } else {
        if (i % (numRows - 1) == 0) {
          direction = Direction.DOWN;
          directionIndex++;
        }else {
          directionIndex--;
        }
      }

    }
    StringBuilder sb = new StringBuilder();
    for (String value : zigzagArray) {
      if(value != null) {
        sb.append(value);
      }
    }

    return sb.toString();
  }


  enum Direction {
    UP, DOWN
  }
}
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] resultArray = new int[m + n];
    int index1 = 0, index2 = 0, resultIndex = 0;

    if(nums2.length == 0){
      return;
    }

    if(m == 0 || nums1.length == 0){
      System.arraycopy(nums2, 0, nums1, 0, nums2.length);
      return;
    }

    for (int i = 0; i < m+n; i++) {
      if (nums1[index1] < nums2[index2] && index1 < m) {
        resultArray[resultIndex++] = nums1[index1++];
      } else {
        resultArray[resultIndex++] = nums2[index2++];
      }

      if(index1 == nums1.length){
        for(; i < m+n; i++){
          resultArray[resultIndex++] = nums2[index2++];
        }
        break;
      }
      if(index2 == nums2.length){
        for(i += 1; i < m+n; i++){
          resultArray[resultIndex++] = nums1[index1++];
        }
        break;
      }

    }
    System.arraycopy(resultArray, 0, nums1, 0, resultArray.length);

    }
}

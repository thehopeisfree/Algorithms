public class FindPeakElement {
  public static void main(String[] args) {
    int[] nums = new int[] {9, 2, 3, 1};
    System.out.println(findPeakElement(nums));
  }

  private static int findPeakElement(int[] nums) {
    if (nums == null || nums.length == 0) return -1;
    
    int start = 0, end = nums.length - 1;
    
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] < nums[mid + 1]) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }

    return start;
  }
}
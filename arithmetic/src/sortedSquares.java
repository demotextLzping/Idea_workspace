import java.util.Map;

public class sortedSquares {
    public static int[] sortedSquares(int[] nums) {
        int[] newArr = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int count = right;
        while (count>=0) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                newArr[count--] = Math.abs(nums[left]) * Math.abs(nums[left]);
                left++;
            } else {
                newArr[count--] = Math.abs(nums[right]) * Math.abs(nums[right]);
                right--;
            }
        }
        return newArr;
    }

    public static void main(String[] args) {

        int[] arr = sortedSquares(new int[]{-4, -1});
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}

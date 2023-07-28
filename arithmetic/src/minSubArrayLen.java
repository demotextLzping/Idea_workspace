public class minSubArrayLen {
    public static int minSubArrayLen(int target, int[] nums) {
        int count = nums.length + 1;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum = sum + nums[right];
            while (sum >= target) {
                count = Math.min(count, right - left + 1);
                sum = sum - nums[left++];
            }
        }
        return count == nums.length + 1 ? 0 : count;
    }

    public static void main(String[] args) {
        int num = minSubArrayLen(4, new int[]{1, 4, 4});
        System.out.println(num);
    }
}

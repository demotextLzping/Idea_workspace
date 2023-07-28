
public class removeElement {
    public static int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    public static void main(String[] args) {
        int count = removeElement(new int[]{3, 2, 2, 3}, 2);
        System.out.println(count);
    }
}

package String;

public class LongestSubarrayContainsOnly1s {
	public static int longestConsecutiveOnes(int[] nums, int k) {
		if (nums.length == 0) {
			return 0;
		}
		int i = 0;
		int j = 0;
		int max = 0;
		while (j < nums.length) {
			if (nums[j] == 1) {
				max = Math.max(j - i + 1, max);
				j++;
			} else {
				if (k > 0) {
					k--;
					max = Math.max(j - i + 1, max);
					j++;
				} else {
					if (i == j) {
						i++;
						j++;
					} else {
						while (i < j && k == 0) {
							if (nums[i] == 0) {
								i++;
								k++;
							} else {
								i++;
							}
						}
					}

				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,1,0,0,0,1,0,1,0,1,1,1,1,1,1,0,1,1,0,1,1,1,0,1,0,0,1,0,0,0,1,1,1,0,1,1,1,0,0,0,0,1,0,0,0,1,0,1,1,0,1,1,1,1,1,0,0,1,1,0,1,0,0,1,0,0,0,0,1,1,1,0,0,1,0,0,1,1,1,1,0,1,0,1,1,0};
		int k = 89;
		System.out.println(nums.length);
		System.out.println(longestConsecutiveOnes(nums, k));
	}

}

package Stack;

import java.util.Deque;
import java.util.LinkedList;

public class TrappingRainWater {
	public static int trap(int[] height) {
        int res = 0;
        int current = 0;
        Deque<Integer> stack = new LinkedList<>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peekFirst()]) {
                int top = stack.pollFirst();
                if (stack.isEmpty()) {
                    // if stack is empty means the there are no two walls to trap water.
                    break;
                }
                int distance = current - stack.peekFirst() - 1;
                int boundedHeight = Math.min(height[current], height[stack.peekFirst()]) - height[top];
                res += distance * boundedHeight;
            }
            stack.offerFirst(current++);
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));
	}
}

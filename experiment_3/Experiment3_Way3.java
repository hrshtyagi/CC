import java.util.Stack;

public class PreviousNextSmaller {

    public static int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Previous Smaller
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                left[i] = -1;
            else
                left[i] = stack.peek();

            stack.push(i);
        }

        stack.clear();

        // Next Smaller
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                right[i] = n;
            else
                right[i] = stack.peek();

            stack.push(i);
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int width = right[i] - left[i] - 1;

            maxArea = Math.max(maxArea, width * heights[i]);
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] arr = {2,1,5,6,2,3};

        System.out.println(largestRectangleArea(arr));
    }
}

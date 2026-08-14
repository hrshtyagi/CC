public class BruteForce  {

    public static int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int left = i;
            while (left >= 0 && heights[left] >= heights[i]) {
                left--;
            }

            int right = i;
            while (right < n && heights[right] >= heights[i]) {
                right++;
            }

            int width = right - left - 1;
            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] arr = {2,1,5,6,2,3};

        System.out.println(largestRectangleArea(arr));
    }
}

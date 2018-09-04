import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class intersectionOfTwoArrays3 {
    /* Follow up:  What if the input arrays is ordered? */
    public int[] intersection(int[] arr1, int[] arr2) {
        if(arr1 == null || arr2 == null) return new int[0];
        int i = 0, j = 0;
        List<Integer> ans = new ArrayList<>();
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] > arr2[j]) {
                j++;
            } else if(arr1[i] < arr2[j]) {
                i++;
            } else {
                ans.add(arr1[i++]);
                j++;
            }
        }
        return ans.stream().filter(k -> k != null).mapToInt(k -> k).toArray();
    }

    public static void main(String[] args) {
        intersectionOfTwoArrays3 test = new intersectionOfTwoArrays3();
        int[] arr1 = new int[] {1, 2, 3, 3, 3, 4, 5, 6, 7, 8};
        int[] arr2 = new int[] {2, 2, 2, 2, 2, 3, 3, 3, 3, 7, 8};
        Arrays.stream(test.intersection(arr1, arr2)).forEach(System.out::println);
    }
}

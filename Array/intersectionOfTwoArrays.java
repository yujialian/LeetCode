class Solution {
    public int[] intersection(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < arr2.length; i++) {
            if(set.contains(arr2[i])) {
                ans.add(arr2[i]);
                set.remove(arr2[i]);
            }
        }
        return ans.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
    }
}

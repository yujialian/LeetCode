class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < B.length; i++) {
            if(map.containsKey(B[i])) map.get(B[i]).add(i);
            else {
                map.put(B[i], new ArrayList<Integer>());
                map.get(B[i]).add(i);
            }
        }
        List<Integer> findIndex = new ArrayList<>();
        for(int i = 0; i < A.length; i++) {
            findIndex.add(map.get(A[i]).get(0));
            map.get(A[i]).remove(0);
        }
        return findIndex.stream().mapToInt(i->i).toArray();
    }
}

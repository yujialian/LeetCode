class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < C.length; i++) {
            for(int j = 0; j < D.length; j++) {
                map.put(C[i] + D[j], map.getOrDefault(C[i] + D[j], 0) + 1);

            }

        }
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++) {
                int remain = 0 - A[i] - B[j];
                if(map.containsKey(remain)) {
                    count += map.get(remain);

                }

            }

        }
        return count;

    }

}

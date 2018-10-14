//628
class Solution {
    public int maximumProduct(int[] nums) {
        if(nums.length < 3) return 0;
        PriorityQueue<Integer> pqLarge = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                return i - j;
            }
        });
        PriorityQueue<Integer> pqSmall = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                return j - i;
            }
        });
        for(int num: nums) {
            pqLarge.offer(num);
            pqSmall.offer(num);
            if(pqLarge.size() > 3) pqLarge.poll();
            if(pqSmall.size() > 3) pqSmall.poll();
        }
        Iterator<Integer> it = pqLarge.iterator();
        int resAllPos = 1;
        for(int i = 0; i < 3; i++) {
            resAllPos *= it.next();
            
        }
        pqSmall.poll();
        pqLarge.poll();
        pqLarge.poll();
        int resAllSmall = pqSmall.poll() * pqSmall.poll() * pqLarge.poll();
        return resAllSmall > resAllPos ? resAllSmall : resAllPos;
    }
}

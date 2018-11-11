public class Main {
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        segmentTree<Integer> seg = new segmentTree(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
    System.out.println(seg);
    System.out.println("Query:");
    System.out.println("Range from 0 to 2, which should be 1, the test result is:" + seg.query(0, 2));
    System.out.println("Range from 2 to 5, should be -1, the result is:" + seg.query(2, 5));
    System.out.println("Range from 0 to 5, should be -3, the result is:" + seg.query(0, 5));
    }
    /*segment tree: segmentTree<Integer> segTree = new segmentTree<Integer>() { (a, b) -> a+b; }; */
    /* res should be: [-3,1,-4,-2,3,-3,-1,-2,0,null,null,-5,2,null,null,null,null,null,null,null,null,null,null,null]. */
}

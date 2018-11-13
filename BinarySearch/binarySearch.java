public class binarySearch<E extends Comparable<E>> {
    E[] data;
    public binarySearch(E[] arr) {
        data = (E[]) new Comparable[arr.length];
        for(int i = 0; i < arr.length; i++) {
           data[i] = arr[i]; 
        }
    }
    public binarySearch() {
        data = (E[]) new Comparable[10];
    }
    public int BS1(E target) {
        int l = 0, r = data.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(data[mid].compareTo(target) == 0) return mid;
            else if(data[mid].compareTo(target) < 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
    public int BS2(E target) {
        int l = 0, r = data.length;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(data[mid].compareTo(target) == 0) return mid;
            else if(data[mid].compareTo(target) > 0) r = mid;
            else l = mid + 1;
        }
        return -1;
    }
	/*
    public static void main(String[] args) {
        Integer[] data1 = new Integer[] {1, 2, 3, 4, 5, 6, 7, 9};
        Integer[] data2 = new Integer[] {11, 23, 100, 123, 155, 199, 230};
        binarySearch<Integer> bs = new binarySearch<Integer>(data1);
        for(int i = 0; i < data1.length; i++) {
            if(bs.BS1(data1[i]) == -1) System.out.println("BS1 Errored!");
            else System.out.println("Correnct! current index:"+bs.BS1(data1[i]));
            if(bs.BS2(data1[i]) == -1) System.out.println("BS2 Errored!");
            else System.out.println("Correnct! current index:"+bs.BS2(data1[i]));
            if(i == data1.length - 1) System.out.println("DATA1'S BS FINISHED!");
        }
        bs = new binarySearch<Integer>(data2);
        for(int i = 0; i < data2.length; i++) {
            if(bs.BS1(data2[i]) == -1) System.out.println("BS1 Errored!");
            if(bs.BS2(data2[i]) == -1) System.out.println("BS2 Errored!");
            if(i == data1.length - 1) System.out.println("DATA2'S BS FINISHED!");
        }
    }
	*/
    public static void main(String[] args) {

        int n = (int)Math.pow(10, 7);
        Integer data[] = Util.generateOrderedArray(n);
        System.out.println("Data size:" + n);

        long startTime = System.currentTimeMillis();
        binarySearch<Integer> bs = new binarySearch<Integer>(data);
        for(int i = 0 ; i < n ; i ++)
            if(i != bs.BS1(data[i]) && i != bs.BS2(data[i]))
                throw new IllegalStateException("find i failed!");
        long endTime = System.currentTimeMillis();

        System.out.println("Binary Search test complete.");
        System.out.println("Time cost: " + (endTime - startTime) + " ms");
    }
}

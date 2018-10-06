class MovingAverage {
    List<Integer> ans = new LinkedList<>();
    int size = 0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        ans.add(val);
        if(ans.size() > size) ans.remove(0);
        int sum = 0;
        for(int i = 0; i < ans.size(); i++) {
            sum += ans.get(i);
        }
        return sum / (double) ans.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

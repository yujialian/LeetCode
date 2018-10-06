public class CollazConjecture {
    public int collaz(int num) {
        int times = 0;
        while(num != 1) {
            times++;
            if(num % 2 == 1) num = 3 * num + 1;
            else num = num / 2;
        }
        return times;
    }

    public int longestCollaz(int num) {
        if(num < 1) return 0;

        int res = 0;
        for(int i = 1; i <= num; i++) {
            res = Math.max(res, collaz(i));
        }
        return res;
    }
}

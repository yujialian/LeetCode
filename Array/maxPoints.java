/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Fraction {
    int x;
    int y;
    Fraction() {x = 0; y = 0; }
    Fraction(int x, int y) {this.x = x; this.y = y;}
}
class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;
        if(points.length <= 2) return points.length;
        int count = 0;
        for(int i = 0; i < points.length; i++) {
            Map<String, Integer> record = new HashMap<>();
            int samePoints = 0;
            for(int j = 0; j < points.length; j++) {
                if(points[i].x == points[j].x && points[i].y == points[j].y) {
                    samePoints++;
                    count = Math.max(samePoints, count);
                } else {
                    String slopeStr = slopeToStr(slope(points[i], points[j]));
                    record.put(slopeStr, record.getOrDefault(slopeStr, 0) + 1);
                }
            }
            for(Map.Entry<String, Integer> entry: record.entrySet()) {
                count = Math.max(count, entry.getValue() + samePoints);
            }
        }
        return count;
    }
    public String slopeToStr(Fraction frac) {
        return frac.x + "/" + frac.y;
    }
    public Fraction slope(Point p1, Point p2) {
        int x = p2.x - p1.x;
        int y = p2.y - p1.y;
        if(x == 0) return new Fraction(0, 1);
        if(y == 0) return new Fraction(1, 0);
        int maxDivisor = gcd(Math.abs(x), Math.abs(y));
        return new Fraction(x/maxDivisor, y/maxDivisor);
    }
    public int gcd(int a, int b) {
        if(a < b) {
            a ^= b;
            b ^= a;
            a ^= b;
        }
        if(a % b == 0) return b;
        return gcd(b, a % b);
    }
}

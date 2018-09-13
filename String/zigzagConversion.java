public class zigzagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        boolean isDown = false;
        int rowCounter = 0;
        char[] charArr = s.toCharArray();
        for(int i = 0; i < charArr.length; i++) {
            if(rowCounter == 0 ) isDown = true;
            else if(rowCounter == numRows - 1) isDown = false;
            rows.get(rowCounter).append(charArr[i]);
            rowCounter = isDown ? rowCounter + 1 : rowCounter - 1;
        }
        String ans = "";
        for(int i = 0; i < rows.size(); i++) {
            ans += rows.get(i).toString();
        }
        return ans;
    }
}

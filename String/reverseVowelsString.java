class Solution {
    public String reverseVowels(String str) {
        HashSet<Character> set = new HashSet<>(Arrays.asList(new Character[] {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}));
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }
        int l = 0, r = sb.length() - 1;
        while(l < r) {
            while(l < r && !set.contains( sb.charAt(l)) ) l++;
            while(l < r && !set.contains( sb.charAt(r) )) r--;
            if(l >= r) return sb.toString();
            swap(sb, l++, r--);
        }
        return sb.toString();
    }
    private void swap(StringBuffer sb, int i, int j) {
        Character c = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, c);
    }
}

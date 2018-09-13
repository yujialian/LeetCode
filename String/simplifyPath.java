class Solution {
    public String simplifyPath(String path) {
        String[] pathName = path.split("/");
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < pathName.length; i++) {            
            if(pathName[i].equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            } else if(!pathName[i].equals(".") && !pathName[i].equals("")) stack.push(pathName[i]);
        }
        List<String> list = new ArrayList<String>(stack);
        return "/" + String.join("/", list);
    }
}

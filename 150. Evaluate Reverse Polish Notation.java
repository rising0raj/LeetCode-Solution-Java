// Runtime   5ms
// Beats     97.05%
// Memory    44.35MB
// Beats     62.56%
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer>st=new Stack<>();
        int y;
        for(String str: tokens){
            if(str.equals("+"))
                st.push(st.pop()+st.pop());
            else if(str.equals("-"))
                st.push(-st.pop()+st.pop());
            else if(str.equals("*"))
                st.push(st.pop()*st.pop());
            else if(str.equals("/")){
                y=st.pop(); 
                st.push(st.pop()/y);
            }
            else
                st.push(Integer.parseInt(str));
        }
        return st.peek();
        
    }
}

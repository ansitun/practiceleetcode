package medium;

import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        generateParenthesisHelper(n, 0, 0, result, "");

        return result;
    }

    public void generateParenthesisHelper(int n, int start, int end, List<String> result, String str) {
        if(start == n && end == n) {
            result.add(str);
        }

        if(end > start || start > n)
            return;

        if(start<=n)
            generateParenthesisHelper(n, start+1, end, result, str+"(");

        if(end<=start)
            generateParenthesisHelper(n, start, end+1, result, str+")");
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(3));
    }
}

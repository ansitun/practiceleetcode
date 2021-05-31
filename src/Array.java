import java.util.ArrayList;
import java.util.List;

public class Array {

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();

        if(digits.length() == 0) return combinations;

        String[] mapOfStr = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> result;

        combinations.add("");
        for(int k=0; k<digits.length(); k++) {
            String digit = mapOfStr[digits.charAt(k) - '0'];  // a, b, c | d,e,f


            result = new ArrayList<>();
            for(int j=0; j< digit.length(); j++) {
                for (String combination : combinations) {
                    result.add(combination + digit.charAt(j));
                }
            }
            combinations = result;


        }

        return combinations;
    }

    public static void main(String[] args) {
        Array a = new Array();

        System.out.println(a.letterCombinations("23"));
    }
}

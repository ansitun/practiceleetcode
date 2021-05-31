public class Walmart {

    // 38 - > 38%26 -> 14 , 38/26 -> x -> (x-1) A
    // AK
    public String fetchColumnName(int num) {

        char[] chArr = new char[26];
        for(int i=0; i< chArr.length; i++) {
            chArr[i] = (char)(i+'A');
        }

        StringBuilder result = new StringBuilder();
        int div = (num-1)/26;   // 27
        // prob is here. I should have used num instead of div
        while(div > 0) {
            result.append(chArr[div-1]);
            div /= 26;
        }
        result.append(chArr[(num-1) % 26]);

        return result.toString();
    }

    public static void main(String[] args) {
        Walmart w = new Walmart();
        System.out.println(w.fetchColumnName(705));
    }
}

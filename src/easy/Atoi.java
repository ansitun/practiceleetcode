package easy;

public class Atoi {
    public int myAtoi(String s) {
        char temp;
        int lastIndex = -1, sign = 1, result = 0, oldResult;
        boolean number = false;

        for(int i=0; i<s.length(); i++) {
            temp = s.charAt(i);

            if (!number) {
                if(temp == ' ' && lastIndex+1 == i) {
                    lastIndex = i;
                    continue;
                }

                if(lastIndex+1 == i && temp == '-' && i+1 < s.length() && (int)s.charAt(i+1) >= 48 && (int)s.charAt(i+1) <= 57) {
                    sign = -1;
                    lastIndex = i;
                } else if(lastIndex+1 == i && temp == '+' && i+1 < s.length() && (int)s.charAt(i+1) >= 48 && (int)s.charAt(i+1) <= 57) {
                    sign = 1;
                    lastIndex = i;
                }
            }


            if(lastIndex+1 == i && (int)temp >= 48 && (int)temp <=57) {
                number = true;
                lastIndex = i;
                oldResult = result;
                result = result*10 + (int)temp - 48;
                if (oldResult != result/10) {
                    if (sign == 1) return Integer.MAX_VALUE;
                    else return Integer.MIN_VALUE;
                }
            }
        }
        return result*sign;
    }

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.myAtoi("+-12"));
    }


}

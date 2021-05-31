package easy;

public class ReverseInteger {

    public int reverse(int x) {
        int result = 0, temp = result;
        int max = (int) (Math.pow(2,32)-1);
        while(x != 0) {
            temp = result;
            result = (10*result) + (x%10);
            if (result/10 != temp) return 0;
            // if (result < temp) return 0;
            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(-123));

        System.out.println(-(int)Math.pow(2,31) - 1);
    }
}

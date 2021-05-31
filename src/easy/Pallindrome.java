package easy;

public class Pallindrome {
    public boolean canBePalindrome(int x) {
        int[] arr = new int[10];
        int count = 0;
        if (x < 0) return false;

        while(x > 0) {
            arr[x%10]++;
            x /= 10;
            count++;
        }

        if(count%2 == 0) {
            for (int j : arr) if (j % 2 == 1) return false;
        } else {
            count = 0;
            for (int j : arr) {
                if (j % 2 == 1) count++;
                if (count > 1) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Pallindrome p = new Pallindrome();
        System.out.println(p.canBePalindrome(1010));

    }
}

public class Bitwise {

    public static void main(String args[]) {
        byte a = 123;
        byte b = 124;
        byte c = (byte) (a|b);
        byte d = 127;
        System.out.println((c & a)==d);
    }
}

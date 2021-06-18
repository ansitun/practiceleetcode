package medium;

import java.util.*;
// .....ajfie1234.243.23.438297fj........

// TBD
public class ValidateIP {
    public String validIPAddress(String IP) {

        StringBuilder sb = new StringBuilder();
        List<StringBuilder> list = new ArrayList<>(4);

        for (int i=0; i<IP.length(); i++) {
            if(IP.charAt(i) >=48 && IP.charAt(i) <= 57 || IP.charAt(i) == '.') {

                if(IP.charAt(i) == '.') {
                    if(sb.length() > 3)
                        sb.delete(0, sb.length()-3);
                }
                else
                    sb.append(IP.charAt(i));

                if(IP.charAt(i) == '.' && sb.length() != 0) {
                    list.add(new StringBuilder(sb));
                    sb = new StringBuilder();
//                    int temp = Integer.parseInt(sb.toString());
//                    //System.out.println(temp);
//                    if (temp >=0 && temp<= 255) {
//                        list.add(new StringBuilder(sb));
//                        sb = new StringBuilder();
//                    }
                    if(list.size() == 4) {
                        break;
                    }
                }

            }
        }

        sb = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            sb.append(stringBuilder);
            sb.append(".");
        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }
    public static void main(String[] args) {
        ValidateIP v = new ValidateIP();
        System.out.println(v.validIPAddress(".....ajfie1234.243.23.438297fj........"));
    }
}

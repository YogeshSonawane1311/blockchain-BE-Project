/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rcc;

public class ReverseDecryption {

    public String getReverseDe(String str, String key) {
        int sum = 0;

        for (int i = 0; i < key.length(); i++) {

            char ch = key.charAt(i);
            int alpha = (int) ch;
            sum = sum + alpha;

        }
      //  System.out.println("SUM IS D " + sum);
        int value = sum % 20;

        String res = "";

        char ch[] = str.toCharArray();

        String pp = "";

        for (int i = 0; i < ch.length; i++) {

            char c = ch[i];
            int y = c;

            int a = y;

            int f = a - (161 + value);

            char chh = (char) f;

            String pr = Character.toString(chh);
            pp = pp + pr;

        }

        res = pp;

        return res;
    }

}

package interview.program.stringprograms;

import java.util.HashMap;

public class TheripiPodu {

    static int[] alphas = new int[26];

    public static void main(String[] args) {
//        String name = "Ezra Moses Rajkumar";
        String name = "Stephania Zephorah Collins";
        HashMap<Character, Integer> result = new HashMap();

        // 1. create a placeholder
        alphaArray();

        char[] chars = name.toLowerCase().toCharArray();
        for (char letter: chars) {
//            System.out.println(c);

            int letterAscii = letter; // e - 101
            int count = 1;

            // 2. increment count in placeholder
            for(int key=0; key < 26 ; key++) {

                // alphas[0] == letterAscii
                // a == e => 97 == 101
                // alphas[1] == letterAscii
                // b == e > 98 == 101
                // alphas[2] == letterAscii
                // c == e > 99 == 101
                // alphas[3] == letterAscii
                // d == e > 100 == 101
                // alphas[4] == letterAscii
                // e == e > 101 == 101

                if(alphas[key] == letterAscii) {
                    if(result.containsKey(letter))
                        count = result.get(letter) + 1;

                    result.put(letter, count);
                    System.out.println(letter + " incremented by " + count);
                    break;
                }
            }
        }

        // 3. print all placeholders
        System.out.println("result is " + result);

        // 4. print with sort highest to lower

    }

    static void alphaArray() {
        int a =  'a';  // 'a' 97;
        for (int i = 0; i < 26; i++) {
            alphas[i] = a++;
//            System.out.println("alphas " + alphas[i]);
        }
    }
}

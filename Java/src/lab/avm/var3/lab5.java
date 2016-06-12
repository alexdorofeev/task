package lab.avm.var3;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Dorofeev on 6/7/2016.
 */
public class lab5 {
    private static double a = 3.1;
    private static double b = 5.4;
    private static double c = 0.2;
    private static double d = 9.6;
    private static double e = 7.8;
    public static void main(String[] args) {

        System.out.println(eval("a-(b+c*d)/e"));
    }
    static  boolean isOperator(char c) {

        return c == '+' || c == '-' || c == '*' || c == '/';

    }
    static int priority(char oper) {
        // Если символ * или / - приоритет 1
        if (oper == '*' || oper == '/') {
            return 1;
        }
        // Если символ + или - — приоритет 0
        else if (oper == '+' || oper == '-') {
            return 0;
        }
        // Если ни то, ни другое - приоритет -1
        else {
            return -1;
        }
    }

    static void letGo(LinkedList<Double> st, char oper) {

        double someOne = st.removeLast();

        double someTwo = st.removeLast();

        switch(oper) {
            case '+':
                st.add(someTwo + someOne);
                break;
            case '-':
                st.add(someTwo - someOne);
                break;
            case '*':
                st.add(someTwo * someOne);
                break;
            case '/':
                st.add(someTwo / someOne);
                break;
            default:
                System.out.println("Oops");
        }
    }
    static double eval(String s) {
        LinkedList<Double> someDoub = new LinkedList<>();
        LinkedList<Character> someOpers = new LinkedList<>();
        LinkedList<Character> some = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                someOpers.add('(');
                some.add(c);
            }
            else if (c == ')') {
                while(someOpers.getLast() != '(') {
                    some.add(c);

                    letGo(someDoub, someOpers.removeLast());
                }
                someOpers.removeLast();
            }
            else if (isOperator(c)) {
                while(!someOpers.isEmpty() &&
                        priority(someOpers.getLast()) >= priority(c)) {
                    some.add(c);

                    letGo(someDoub, someOpers.removeLast());
                }
                someOpers.add(c);
                some.add(c);
            }
            else {

                //  String operand = "";
                while(i < s.length() &&
                        isLetter(s.charAt(i))) {
                    some.add(c);

                    someDoub.add(getValue(s.charAt(i++)));
                }
                --i;
//                someDoub.add(Double.parseDouble(operand));
            }
        }
        while(!someOpers.isEmpty()) {
            letGo(someDoub, someOpers.removeLast());
        }
        System.out.println(Arrays.toString(some.toArray()));
        return someDoub.get(0);
    }
    public static double getValue(char ch)
    {
        switch (ch) {
            case 'a':
                return a;
            case 'b':
                return b;
            case 'c':
                return c;
            case 'd':
                return d;
            case 'e':
                return e;
        }
        return 0;
    }
    static boolean isLetter(char ch)
    {
        if (ch=='a'||ch=='b'||ch=='c'||ch=='d'||ch=='e')
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

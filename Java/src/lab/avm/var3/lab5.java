package lab.avm.var3;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Dorofeev on 6/6/2016.
 */
public class lab5 {
    public static void main(String[] args) {
  //    String C =  "8.5/(0.3*(2.4+7.9))-1.6";
        char[] expression = {'a', '/', '(', 'b', '*', '(', 'c', '+', 'd', ')', ')', '-', 'e'};

        System.out.println(eval(expression));
    }

    static boolean isDelim(char c) { // тру если пробел
            return c == ' ';
        }
        static boolean isOperator(char c) { // возвращяем тру если один из символов ниже
            return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
        }
        static int priority(char op) {
            switch (op) { // при + или - возврат 1, при * / % 2 иначе -1
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                case '%':
                    return 2;
                default:
                    return -1;
            }
        }
        static void processOperator(LinkedList<Double> st, char op) {
            double r = st.removeLast(); // выдёргиваем из упорядоченного листа последний элемент
            double l = st.removeLast(); // также
            switch (op) { // выполняем действие между l и r в зависимости от оператора в кейсе и результат валим в st
                case '+':
                    st.add(l + r);
                    break;
                case '-':
                    st.add(l - r);
                    break;
                case '*':
                    st.add(l * r);
                    break;
                case '/':
                    st.add(l / r);
                    break;
                case '%':
                    st.add(l % r);
                    break;
            }
        }
        public static double eval(char[] c) {
            LinkedList<Double> st = new LinkedList<Double>(); // сюда наваливают цифры
            LinkedList<Character> op = new LinkedList<Character>(); // сюда опрераторы и st и op в порядке поступления
            for (int i = 0; i < c.length; i++) { // парсим строку с выражением и вычисляем
                if (isDelim(c[i]))
                    continue;
                if (c[i] == '(')
                    op.add('(');
                else if (c[i] == ')') {
                    while (op.getLast() != '(')
                        processOperator(st,op.removeLast());
                    op.removeLast();
                } else if (isOperator(c[i])) {
                    while (!op.isEmpty() && priority(op.getLast()) >= priority(c[i]))
                        processOperator(st, op.removeLast());
                    op.add(c[i]);
                } else {
                    String operand = "";
                    while (i < c.length)
                        operand += c[i++];
                    --i;
                    st.add(Double.parseDouble(operand));
                }
            }
            while (!op.isEmpty())
                processOperator(st, op.removeLast());
            return st.get(0);  // возврат результата
        }
    }
//        char[] expression = {'a', '/', '(', 'b', '*', '(', 'c', '+', 'd', ')', ')', '-', 'e'};
//        System.out.println("Working on expression:" + Arrays.toString(expression));
//        double a = 8.5;
//        double b = 0.3;
//        double c = 2.4;
//        double d = 7.9;
//        double e = 1.6;
//        System.out.println("a =" + a + "b =" + b + "c =" + c + "d =" + d + "e =" + e);
//        char[] polizExpression = getPoliz(expression);
//        System.out.println("Poliz expression get by program: " + polizExpression);
//        double result = calculateResult(polizExpression, a, b, c, d, e);
//        System.out.println("Result: " + result);
//    }
//
//    static int isLetter(char ch)
//    {
//        if (ch=='a'||ch=='b'||ch=='c'||ch=='d'||ch=='e')
//        {
//            return 1;
//        }
//        else
//        {
//            return 0;
//        }
//    }
//
//
//    public static char[] getPoliz(char[] expression)
//    {
//        int length = expression.length;
//       // System.out.println(length);
//        char[] result = new char[length];
//        int resultIndex = 0;
//        char[] stack = new char[length];
//        int stackIndex = 0;
//
//
//        for (int i = 0; i < length; i++) {
//            // handling letters and '=' mark
//            if (isLetter(expression[i]) == 1) {
//                result[resultIndex] = expression[i];
//                resultIndex++;
//            }
//
//            // handling '('
//            if (expression[i]== '(')
//            {
//                stack[stackIndex] = '(';
//                stackIndex++;
//            }
//
//            // handling operators (only arithmethical)
//            if (expression[i] == '+' || expression[i] == '-' || expression[i] == '*' || expression[i] == '/')
//            {
//                int currentOperatorPriority = getPriority(expression[i]);
//                if (stackIndex == 0)
//                {
//                    stack[stackIndex] = expression[i];
//                    stackIndex++;
//                }
//                else
//                {
//                    char lastStackSymbol = stack[stackIndex-1];
//                    int lastStackSymbolPriority = getPriority(lastStackSymbol);
//
//                    if (lastStackSymbolPriority < currentOperatorPriority)
//                    {
//                        stack[stackIndex] = expression[i];
//                        stackIndex++;
//                    }
//                    else
//                    {
//                        while (lastStackSymbolPriority >= currentOperatorPriority)
//                        {
//                            result[resultIndex] = lastStackSymbol;
//                            resultIndex++;
//
//                            stackIndex--;
//                            lastStackSymbol = stack[stackIndex-1];
//                            lastStackSymbolPriority = getPriority(lastStackSymbol);
//                        }
//                        stack[stackIndex] = expression[i];
//                        stackIndex++;
//                    }
//
//                }
//            }
//
//            // handling ')'
//            if (expression[i] == ')')
//            {
//                char lastStackSymbol = stack[stackIndex-1];
//                while (lastStackSymbol != '(')
//                {
//                    result[resultIndex] = lastStackSymbol;
//                    resultIndex++;
//
//                    stackIndex--;
//                    lastStackSymbol = stack[stackIndex-1];
//                }
//                stackIndex--;
//            }
//        }
//
//        // handling remaining in stack operators
//        while (stackIndex != 0)
//        {
//            result[resultIndex] = stack[stackIndex-1];
//            stackIndex--;
//            resultIndex++;
//        }
//
//        result[resultIndex]='\0';
//        return result;
//    }
//
//   public static int getPriority(char oper)
//    {
//        if (oper == '(')
//        {
//            return 1;
//        }
//        if (oper == '+' || oper == '-')
//        {
//            return 2;
//        }
//
//            return 3;
//
//    }
//
//   public static double calculateResult(char[] polizExpression, double a, double b, double c, double d, double e)
//    {
//        int length = polizExpression.length;
//        double[] valueStack = new double[length];
//        int valueStackIndex = 0;
//
//        for (int i = 0; i < length; i++)
//        {
//            if (isLetter(polizExpression[i]) == 1)
//            {
//                valueStack[valueStackIndex] = getValue(polizExpression[i], a, b, c, d, e);
//                valueStackIndex++;
//            }
//            else
//            {
//                double operator2 = valueStack[valueStackIndex - 1];
//                double operator1 = valueStack[valueStackIndex - 2];
//                double result = performOperation(polizExpression[i], operator1, operator2);
//
//                valueStackIndex--;
//                valueStack[valueStackIndex-1] = result;
//            }
//        }
//        return valueStack[valueStackIndex - 1];
//    }
//
//  public static double performOperation(char operating, double operator1, double operator2) {
//        if(operating == '+') {
//                return operator1 + operator2;
//        } else if(operating ==  '-') {
//            return operator1 - operator2;
//        } else if(operating == '*') {
//            return operator1 * operator2;
//        } else
//                return operator1 / operator2;
//    }
//
//   public static double getValue(char ch, double a, double b, double c, double d, double e)
//    {
//        switch (ch) {
//            case 'a':
//                return a;
//            case 'b':
//                return b;
//            case 'c':
//                return c;
//            case 'd':
//                return d;
//            case 'e':
//                return e;
//        }
//        return 0;
//    }
//
//}

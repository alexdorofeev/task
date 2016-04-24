package lab.avm.var3;

/**
 * Created by Dorofeev on 4/24/2016.
 */
public class lab3 {
    public static double fun(double x) {
        double y = Math.log(x) - 5*Math.cos(x);
        return y;

    }

    public static double methodSimpsona(int a, int b, int m) {
        double h = (double)(b - a) / m;
        double sum = 0;
        double x0 = a;
        double x1 = a + h;

        for (int i = 0; i < m; i++)
        {
            sum += fun(x0) + 4*fun(x0 + h/2) + fun(x1);

            x0 += h;
            x1 += h;
        }

        return (h/6)*sum;

    }

    public static double automaticStep(double eps, int a, int b)
    {
        int m1 = 2;
        double s1, s2;
        do
        {
            s1 = rightRectangles(a, b, m1);
            m1 *= 2;
            s2 = rightRectangles(a, b, m1);
        }
        while (Math.abs(s1 - s2) > eps);
        int m = m1;
        System.out.print("m = " + m + " ");
        return s2;
    }


    public static double rightRectangles(double a, double b, int n)
    {
        double result = 0;
        double h = (b - a) / n;

        for(int i = 0; i < n; i++)
        {
            result += fun(a + h * (i + 0.5));
        }

        result *= h;

        return result;
    }




    public static void main(String[] args) {
        int a = 1;
        int b = 8;
        int m = 100;
        int m1, m2, m3;
        double eps1 = 0.01;
        double eps2 = 0.001;
        double eps3 = 0.0001;
        double simpsonValue = methodSimpsona(a, b, m);

        System.out.println("Here are results:");
        System.out.println("Simpson = " + simpsonValue);

        double auto1 = automaticStep(eps1, a, b);
        System.out.println("Aouto 0.01 = " + auto1);

        double diff1 = auto1 - simpsonValue;
        System.out.println("Diff = " + diff1);

        double auto2 = automaticStep(eps2, a, b);
        System.out.println("Aouto 0.001 = " + auto2);

        double diff2 = auto2 - simpsonValue;
        System.out.println("Diff = " + diff2);

        double auto3 = automaticStep(eps3, a, b);
        System.out.println("Aouto 0.0001 = " + auto3);

        double diff3 = auto3 - simpsonValue;
        System.out.println("Diff = " + diff3);





    }
}

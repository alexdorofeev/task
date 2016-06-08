package lab.avm.var3;

/**
 * Created by Dorofeev on 4/24/2016.
 */
public class lab1 {
    public static void main(String[] args) {
        double a = 1, b = 8;
        double eps = 0.0001;
        double step = 1;
        //	Scanner scanner = new Scanner(System.in)
        double Y1, Y2;
        double x;
        double x1;
        double con;
        int count=0;

        for(x =a; x<=b; x+=step) {
            Y1 = fun(x);
            Y2 = fun(x+step);
            if(Y1*Y2<0) {
                count++;
                System.out.println("\nRoot in the interval from " + x + "to " + (x+step));
            }
        }

        x = 1;
       // x1 = 1.5;
        con = 0.001;
        bisection(x, x+step, eps);
        simpleIteration(x, con, eps);

        x = 4;
       // x1 = 4.5;
        con = -0.001;
        bisection(x, x+step, eps);
        simpleIteration(x, con, eps);


        x = 7;
       // x1 = 8.5;
        con = 0.001;
        bisection(x, x+step, eps);
        simpleIteration(x, con, eps);
    }

    public static double fun(double x) {
        double y = Math.log(x) + 5*Math.cos(x);
        return y;

    }

    public static void  simpleIteration(double from, double to, double eps){
        double x1 = from;
        double x;
        do{
             x = x1;
            x1 = x1  +  to*fun(x);
        }while ( Math.abs( x1 - x ) > eps );
        System.out.println("Method of simple iterations: " + x1);
    }

    public static void bisection(double from, double to, double eps) {
        double yFrom = fun(from);
        double yTo = fun(to);
        while ((to - from) > eps) {
            double xMidd = (from + to)/2;
            double yMidd = fun(xMidd);
            if ((yFrom * yMidd) > 0) {
                from = xMidd;
                yFrom = yMidd;
            }
            else {
                to = xMidd;
                yTo = yMidd;
            }
        }

        System.out.println("Bisection " + (from + to)/2);
    }
}

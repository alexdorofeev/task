package lab.avm.var4;

/**
 * Created by Dorofeev on 4/24/2016.
 */
public class lab1 {
    public static void main(String[] args) {
        double a, b;
        double eps = 0.01;
        //	Scanner scanner = new Scanner(System.in);
        a = 4;
        b = 7;

        double v,x0,x1;
        int count=0;
        System.out.println("******  FIXED POINT METHOD  ******");
        do
        {   count++;
            x0=a;
            x1=fun(x0);
            if(Math.abs(fun(x1)-fun(x0))<=eps){
                System.out.println("Approximate Roots" + x1 + "Roots is found iteration " + count);
            }
            v=x1;
        }while(Math.abs(fun(x1)-fun(x0))>eps);

        System.out.println("===========================================");
        int k =0;
        double step = 0.5;
        for (double X = a; X <= b; X += step) {
            double Y1 = fun(X);
            double Y2 = fun(X + step);

            if (Y1*Y2 < 0) {
                k++;
                System.out.println("Root in line from " + X + " to " + (X+step));
                double rootIter = simpleIteration(X, X+step, eps);
                double rootBin = bisection(X, X+step, eps);
                System.out.println("Iteration: " + rootIter + " Checking: " + fun(rootIter));
                System.out.println("Bisection: " + rootBin + " Checking: " + fun(rootBin));
            }
        }
        System.out.println("Nomber of roots = " + k);
    }

    public static double fun(double x) {
        double y = Math.exp(x)/Math.pow(x,3) - Math.pow(Math.sin(x), 3);
        return y;

    }

    public static double simpleIteration(double from, double to, double eps){
        do{
            from = to;
            to = fun(from);
        }while ( Math.abs( fun(to) - fun(from) ) > eps );
        return from;
    }

    public static double bisection(double from, double to, double eps) {
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

        return (from + to)/2;
    }
}

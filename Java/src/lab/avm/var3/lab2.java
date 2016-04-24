package lab.avm.var3;

/**
 * Created by Dorofeev on 4/24/2016.
 */
public class lab2 {

    public static double interLagrang(double x, double[] yValue, int size){
        double lagranPol = 0;
        double basicPol;

        for (int i = 0; i < size; i++) {
            basicPol = 1;
            for (int j = 0; j < size; j++) {
                if(j == i) continue;
                basicPol *= (x - yValue[j])/(yValue[i] - yValue[j]);
            }
            lagranPol += basicPol * fun( yValue[i] );
        }
        return lagranPol;
    }

    public static void linInterpl(double point1,  double point2){
        System.out.println("Linear interpolation: from " + point1
                + " to " + point2);
        System.out.println("Real value: from " + fun(point1)
                + " to " + fun(point2));

        double diff = point2 - point1;
        double prevX = point1;
        for (int i = 1; i <= 10; i++) {

            double currentX = point1 + diff/10 * i;
            double prevY = fun(prevX);
            double currentY = fun(currentX);

            double interpol = prevY + (currentX - prevX) * (currentY - prevY)/(currentX - prevX);

            System.out.println("curentX = " + currentX
                    + " curentY = " + currentY
                    + " interpol = " + interpol);

            prevX = currentX;

        }


    }

    public static void getValueArr(double[] values, double a, double b, int size){
        for (int i = 0; i < size; i++) {
            values[i] = a + i*(b-a)/(size-1);
        }

    }


    public static double fun(double x) {
        double y = Math.log10(x) + 5*Math.cos(x);
        return y;

    }

    public static void main(String[] args) {
        final int size = 10;
        double[] xValue = new double[21];
        double[] yValue = new double[5];
        double a = 1, b = 8;
        double m = 5;

        getValueArr(xValue, a, b, 21);
        getValueArr(yValue, a, b, 5);

        for (int j = 0,  i = 0; j < 21 &&  i < m; j++) {


            double x = xValue[j];
            double realValue = fun(x);
            double lagrValue = interLagrang(x, yValue, 5);
            System.out.print("X = " + x
                    + " Real value = " + realValue
                    + " Lagrange = " + lagrValue
                    + " Dif = " + (realValue - lagrValue));

            if(x == yValue[i]){
                System.out.print(" True");
                i++;

            }

            System.out.println();
        }
        System.out.println("===================================");
        System.out.println("Linear interpolation: 2nd and 3rd points");
        linInterpl(yValue[1], yValue[2]);

    }
}

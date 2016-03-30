/**
 * Created by Dorofeev on 3/30/2016.
 */
public class FactorialDemo {

    public static void main(String[] args) {

        System.out.println(recFac(3));
        System.out.println(iterFac(3));
    }

    // Рекурсивный способ нахождения факториала
    public static int recFac(int n){
        return (n == 1) ? 1 : n*recFac(n-1);
    }

    //Итеративный метод находения факториала
    public static  int iterFac(int n){
        int f = 1;
        for (int i = 1; i <=n; i++) {
            f*=i;
        }
        return f;
    }
}

package lab.avm.var4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Dorofeev on 4/24/2016.
 */
public class lab4 {
    public static void main(String[] args) {
        int [] a;
        int n, x;
        Scanner scanner;
        Random random =  new Random();
        System.out.println("ведите n:");
        scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(99);
        }

        System.out.println(Arrays.toString(a));
        //linesort(a);
        sortShell(a);
        System.out.println(Arrays.toString(a));

        System.out.println("Видите число которые необходимо найдти: ");
        x = scanner.nextInt();
        benarySearch(a, x);

    }
    public static int[] linesort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int k = i;
            int max = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] > max){
                    max = arr[j];
                    k = j;
                }
            }
            arr[k] = arr[i];
            arr[i] = max;
        }

        return arr;
    }

    public static int [] sortShell(int[] arr) {
        int endSort;
        for (int h = arr.length/2; h > 0; h = h/2) {
            do {

                endSort = 0;
                int i = 0;
                int j = h;

                while (j < arr.length ) {

                    if(arr[i] > arr[j]){
                        int buf = arr[j];
                        arr[j] = arr[i];
                        arr[i] = buf;
                        endSort = 1;
                    }
                    j++;
                    i++;
                    //System.out.println(Arrays.toString(arr));
                }
            } while (endSort == 1);
        }
        return arr;
    }

    public static void benarySearch(int[] arr, int x) {
        boolean flag = false;
        int left = 0;
        int right = arr.length;
        int m = 0;
        int count = 0;
        while(left <= right && flag == false){
            m = (left + right) / 2;
            if(arr[m] == x){
                flag =true;
            } else if(arr[m] > x){
                right = m +1;
            } else left = m - 1;
            count++;
        }
        if(flag == true){
            System.out.println("Элемент " + x + " находится на " + m + " Найдено за " + count);
        }else
            System.out.println("такого элемента нет");

    }
}

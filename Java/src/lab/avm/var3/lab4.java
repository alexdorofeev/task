package lab.avm.var3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Dorofeev on 4/24/2016.
 */
public class lab4 {
    static  int coun = 0;

    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int[] a, b;

        int n;
        Scanner scaner = new Scanner(System.in);
        n = scaner.nextInt();
        a = new int[n];
        b = new int[n];


        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(20);
            b[i] = a[i];
        }
        System.out.println(Arrays.toString(a));

        lineSort(a);
        System.out.println(Arrays.toString(a));
        horSort(b, 0, n-1);
        System.out.println("Horsort count= " + coun);
        System.out.println(Arrays.toString(b));

        Scanner t = new Scanner(System.in);
        System.out.println("Введите число для поиска");
        int x = t.nextInt();

        binarySerch(b, x);


    }

    public static int[] lineSort(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length ; i++) {
            count++;
            int	k = i;
            int max = arr[i];
            for (int j = i+1; j < arr.length ; j++) {
                if(arr[j] > max){
                    max = arr[j];
                    k = j;
                }
            }
            arr[k] = arr[i];
            arr[i] = max;
        }
        System.out.println("Linesotr count= " + count);
        return arr;
    }

    public static int[] horSort(int[] arr, int left, int right) throws Exception {
        int	i = left;
        int j = right;
        int t = arr[(left + right)/2];

        do{
            coun++;
            while(arr[i] < t){
                i++;
            }
            while(arr[j] > t){
                j--;
            }
            if(i <= j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }

        }while(i <= j);
        if(i < right){ horSort(arr, i, right);}
        if(j > left){ horSort(arr, left, j);}
        return arr;
    }

    public static void  binarySerch(int[] arr, int x) {
        boolean flag = false;
        int m = 0;
        int left = 0;
        int right = arr.length-1;
        while((left <= right) && (flag == false)){
            m = (right + left)/ 2;
            if(arr[m] == x) {
                flag = true;
            } else if(arr[m] > x){
                right = m+1;

            } else {
                left = m-1;
            }

        }
        if(flag == true) {
            System.out.println("Ваш элемент находитьс под номером: " + m);
        } else
            System.out.println("Извинете! Такого элемента не существует!");

    }
}

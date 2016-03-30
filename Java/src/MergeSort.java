import java.util.Arrays;

/**
 * Created by Dorofeev on 3/30/2016.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = {1,2,4,5,6,11,12,24};
        int[] b = {1,3,4,5,9,10};
        int[] result;

     result = unionAll(a,b);
     //result = intersection(a,b);
     //result = unionDistinct(a,b);
     //result = minos(a,b);
     System.out.println(Arrays.toString(result));

    }
    // Данный метод объеденняет но дубликаты не скрываются))
    public static int[] unionAll(int[] a, int[] b){
        int[] result = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length){
            if(a[i]< b[j]){
                result[k] = a[i];
                i++;
            } else {
                result[k] = b[j];
                j++;
            }
            k++;
        }
        if (i < a.length) {
            for (int l = i; l < a.length; l++) {
                result[k] = a[l];
                k++;
            }
        } else{
                for (int l = j; l < b.length; l++) {
                    result[k] = b[l];
                    k++;
                }
            }
        return result;
    }
    //Данный метод выводит только пересеченне))
    public static int[] intersection(int[] a, int[] b){
        int[] result = new int[a.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length){
            if(a[i]<b[j]){
                i++;
            }else if(b[j]<a[i]){
                j++;
            } else {
                result[k] = a[i];
                i++;j++;k++;
            }
        }
        return result;
    }
    // Данный метод объеденяет без дубликатов))
    public static int[] unionDistinct(int[] a, int[] b){
        int[] result = new int[a.length+b.length];
        int i=0,j=0,k=0;
        while (i < a.length && j < b.length){
            if(a[i] < b[j]){
                result[k] = a[i];
                k++;i++;
            } else if(b[j] < a[i]){
                result[k] = b[j];
                j++;k++;
            }else {
                result[k] = a[i];
                i++;j++;k++;
            }
        }
        if(i<a.length){
            for (int l = i; l < a.length; l++) {
                result[k] = a[l];
                k++;
            }
        } else{
            for (int l = j; l < b.length; l++) {
                result[k] = b[l];
                k++;
            }
        }
        return result;
    }
    //Данный метод вычитает оди  из другого))
    public static int[] minos(int[] a, int[] b){
        int[] result = new int[a.length+b.length];
        int i=0,j=0,k=0;
        while (i < a.length && j < b.length){
            if(a[i]<b[j]){
                result[k++] = a[i];
                i++;
            }else if(b[j]<a[i]){
                j++;
            }else{
                i++;j++;k++;
            }
        }
        if(i<a.length){
            for (int l = i; l < a.length; l++) {
                result[k] = a[l];
                k++;
            }
        } else{
            for (int l = j; l < b.length; l++) {
                result[k] = b[l];
                k++;
            }
        }
        return result;
    }


}

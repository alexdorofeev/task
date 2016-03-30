/**
 * Created by Dorofeev on 3/30/2016.
 */

/**
 *Метод, заменяющий все пробелы в
 строке символами '%20'. Можно предположить, что
 длина строки позволяет сохранить дополнительные
 символы и «истинная» длина строки известна. (При-
 мечание: при реализации метода на Java используйте
 символьный массив.)
 Пример:
 Ввод: "Mr John Smith "
 Вывод: "Mr%20John%20Smith"
 */
public class SpaceReplace {
    public static void main(String[] args) {

        spaceRep("aa as sdsdf dfs");
    }

    public static void spaceRep(String str){
        int a = search(str);
        char[] strA = new char[str.length() + a*3];
        for (int i = 0, j=0; i < str.length(); i++) {
            if(str.charAt(i) == ' '){
                strA[++j] = '%';
                strA[++j] = '2';
                strA[++j] = '0';
            } else {
                strA[++j] = str.charAt(i);
            }
        }
        System.out.println(new String(strA));
    }

    public static int search(String str){
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' '){
                count+=1;
            }
        }
        return count;
    }
}

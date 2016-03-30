/**
 * Created by Dorofeev on 3/30/2016.
 */
import java.util.HashMap;
import java.util.Map;

/**
 * Mетод, принимает на вход массив символов
 * Вычисляет количество повторений каждого
 * принятого символа и выводит в консоль.
 */
public class SymbolCompressor {
    public static void main(String[] args) {
       compresSymbol("aaabbbcccdddeerttrfff");
        compresSymbol("22222111114445");
    }
    private static void compresSymbol(String str){
        Map<Character,Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        System.out.println(map);
    }
}

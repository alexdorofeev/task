/**
 * Created by Dorofeev on 3/30/2016.
 */

/**
* метод, осуществляющий сжатие строки, на основе счетчика повторяющихся символов.
* Например, строка aabcccccaaa должна превратиться в a2b1c5a3.
 * Если «сжатая» строка оказывается длиннее исходной,
 * метод должен вернуть исходную строку.
*/
public class StringCompresor {
    public static void main(String[] args) {
        System.out.println(compresString("aabbc"));
    }
    public static String compresString(String str){
        if(str == null){
            System.out.println("Строка не может быть null");
        }
        if(str.isEmpty()){
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int chCount = 0;
        char prevCharacter = str.charAt(0);

        for (char ch: str.toCharArray()) {
            if(prevCharacter == ch){
                chCount++;
            } else {
                sb.append(prevCharacter).append(chCount);
                prevCharacter = ch;
                chCount = 1;
            }
        }
    sb.append(prevCharacter).append(chCount);
        return (sb.length() >= str.length()) ? str : sb.toString();
    }
}

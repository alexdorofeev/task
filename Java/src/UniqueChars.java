/**
 * Created by Dorofeev on 3/30/2016.
 */


public class UniqueChars {
    public static void main(String[] args) {
      uniqueChars("absde");
      uniqueChars("abssde");
      uniqueCharsOpti("absde");
      uniqueCharsOpti("abssde");

    }

    /**
     * Алгоритм, определяющий, все ли
     символы в строке встречаются один раз.
     */
    public static void uniqueChars(String str){
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j < str.length(); j++) {
                if(str.charAt(i) == str.charAt(j)){
                   flag = true;
                }
            }
        }
        if(flag == true){
            System.out.println("Нашел поторный символ))");
        }else {
            System.out.println("Все символы разные))");
        }
    }

    /**
     * Алгоритм, определяющий, все ли
     символы в строке встречаются один раз. оптимизированный))
     если UNICODE нужно подправить))
     */
    public static void uniqueCharsOpti(String str){
        if(str.length() > 256) {
            System.out.println("В строке символов больше 256");
        }
        boolean[] flag = new boolean[256];
        for (int i = 0; i <str.length() ; i++) {
            int val = str.charAt(i);
            if(flag[val]){
                System.out.println("Нашел поторный символ))");
            }
            flag[val] = true;
        }

    }


}

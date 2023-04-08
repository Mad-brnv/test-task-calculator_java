import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите арифмитеческую операцию: ");
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        if(Calculat.culc(str) != "0"){
            System.out.println(Calculat.culc(str));
        }}
}
class Calculat {
    public static String culc(String str) {
        String num[] = str.split(" ");
        boolean rome = false;
        int[] nums = new int[5];
        int val = 0, norome = 0;
        try {
            for(int i = 0; i<=num.length; i+=2){
            nums[i] = Integer.parseInt(num[i]);}
        } catch (NumberFormatException e) {
            rome = true;
        }
        if(rome == true){
            for(int j = 0; j<num.length; j+=2){
                switch (num[j]){
                    case "I":
                        nums[j] = 1;
                        break;
                    case "II":
                        nums[j] = 2;
                        break;
                    case "III":
                        nums[j] = 3;
                        break;
                    case "IV":
                        nums[j] = 4;
                        break;
                    case "V":
                        nums[j] = 5;
                        break;
                    case "VI":
                        nums[j] = 6;
                        break;
                    case "VII":
                        nums[j] = 7;
                        break;
                    case "VIII":
                        nums[j] = 8;
                        break;
                    case "IX":
                        nums[j] = 9;
                        break;
                    case "X":
                        nums[j] = 10;
                        break;
                    default:
                        norome++;
                }
            }
        }
        String answer = "";
        if(nums[2] != 0) {
            switch (num[1]) {
                case "/":
                    val = nums[0] / nums[2];
                    break;
                case "+":
                    val = nums[0] + nums[2];
                    break;
                case "-":
                    val = nums[0] - nums[2];
                    break;
                case "*":
                    val = nums[0] * nums[2];
                    break;
            }
        }
        if(norome>0) {
            return "используются одновременно разные системы счисления";
        }else if(rome == true){
            answer = String.valueOf(RomeOff.romeoff(val));
            return answer;
        }else if (nums[2] == 0) {
            return "строка не является математической операцией";
        }else if(nums[0] >= 10 || nums[2] >= 10){
            return "число больше 10 не принемается";
        }else if(nums[4] < 0 || nums[4] > 0) {
            return "формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
        }else if(nums[0] <= 10 && nums[2] <= 10){
            answer = String.valueOf(val);
            return answer;
        }else {
            return "хуита";
        }
}

class RomeOff {
    public static String romeoff(int val){
        String Romee = "";
        String[] rom = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        if(val<=0){
               System.out.println("В римской системе нет отрицательных чисел");
                } else  {
            Romee = rom[val];
            return Romee;
        }
        return "0";
    }
}}
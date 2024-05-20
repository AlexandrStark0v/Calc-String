import java.util.Scanner;

public class CalcString {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите значения для совершения операции");
        String expression = sc.nextLine();
        System.out.println("\"" + examination(expression) + "\"");
    }

    public static String examination(String expression) throws Exception {
        String num1;
        String num2;
        String oper;
        String s = "\"";
        oper = checkingTheSign(expression);
        if (oper == null) throw new Exception("неверный формат арифметической операции");
        String[] split1 = expression.split("[+\\-*/]");
        num1 = split1[0];
        if (!num1.contains(s)) throw new Exception("неверная форма ввода данных");
        if (split1.length > 2){
            num1 = split1[0]+'-'+split1[1];
        }
        num1 = num1.replaceAll("\"","").trim();
        num2 = split1[split1.length - 1].trim();
        if (!num2.contains(s)){
            if(!CheckInt.checkInt10(num2))throw new Exception("неверная форма ввода данных");
        }
        num2 = num2.replaceAll("\"","").trim();

        if(num1.length() - 1 >= 10) throw new Exception("неверная форма ввода данных");

        var result = calc(num1, oper, num2);
        if(result.length() >= 40){
            result = result.substring(0,40) + "...";
        }
        return result;
    }

    public static String checkingTheSign(String expression) {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }
    class CheckInt {
        static String[] numbers = new String[]{"0","1","2","3","4","5","6","7","8","9","10"};
        public static boolean checkInt10(String num){
            for (int i = 0; i < numbers.length; i++) {
                if(num.equals(numbers[i])){
                    return true;
                }
            }
            return false;
        }
    }
    public static String calc(String num1, String oper, String num2) {
        var res = "";

        if (oper.equals("+")) {
            for (int i = 0; i < num1.length(); i++) {
                res = res + num1.charAt(i);
            }
            res = res + num2;
        }
        if (oper.equals("-")) {
            String[] spl= num1.split(num2);
            num1 = spl[0];

            if (spl.length > 1) {
                res = spl[0] + spl[1];
            }
             else { res = num1;
            }
        }
        if (oper.equals("*")){
            res = num1.repeat(Integer.parseInt(num2));
        }

        if (oper.equals("/")){
            int num3 = num1.length()/Integer.parseInt(num2);
            res = num1.substring(0,num3);
        }
        return res;
    }
}












import java.util.Scanner;

public class 简易计算器 {
    public static void main(String[] args) {
//        简易计算器
//        输入两个数，选择运算符，输出结果
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数：");
        double num1 = scanner.nextDouble();

        System.out.println("请输入第二个数：");
        double num2 = scanner.nextDouble();

        System.out.println("请输入运算符（+、-、*、/）：");
        String operator = scanner.next();
        double result = calculate(num1, num2, operator);
        System.out.println("运算结果为：" + result);
    }
//    定义一个方法来实现简易计算器
    public static double calculate(double num1, double num2, String operator){
        double result = 0;
        switch (operator){
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                System.out.println("输入的运算符有误，请重新输入！");
        }
    return result;}
}

import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
//接收输入的身高，体重，年龄，性别
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入身高（单位：米）：");
        double height = scanner.nextDouble();

        System.out.println("请输入体重（单位：千克）：");
        double weight = scanner.nextDouble();

        System.out.println("请输入年龄：");
        int age = scanner.nextInt();

        System.out.println("请输入性别（1代表男，2代表女）：");
        String sex = scanner.next();

        double bmi = calculateBMI(weight, height);
        double bmr = calculateBMR(height, weight, age, sex);
        System.out.println("您的BMI值为：" + bmi);
        System.out.println("您的BMR值为：" + bmr);

    }

    //定义一个方法计算出BMI值
    private static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    //定义一个方法来计算BMR值
    private static double calculateBMR(double height, double weight, int age, String sex) {
        double bmr;
        height = height * 100;
        if ("男".equals(sex)) {
            bmr = 66 + (13.7 * weight) + (5 * height) - (6.8 * age);
        } else {
            bmr = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);
        }
        return bmr;
    }


}
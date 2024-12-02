public class BouncingHeart {  
  
    private static final String HEART = "♥"; // 使用Unicode爱心字符  
    private static final int MAX_WIDTH = 80; // 控制台的最大宽度，用于确定爱心的位置  
    private static int currentPosition = 0; // 当前爱心的位置  
  
    public static void main(String[] args) {  
        try {  
            while (true) { // 无限循环来模拟跳动  
                clearConsole(); // 清除控制台内容（在某些系统中可能不支持）  
                drawHeart(); // 绘制爱心  
                Thread.sleep(200); // 等待一段时间以模拟跳动效果  
                currentPosition = (currentPosition + 1) % MAX_WIDTH; // 更新位置  
            }  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }  
  
    private static void drawHeart() {  
        // 在当前位置打印爱心，其余位置用空格填充  
        for (int i = 0; i < MAX_WIDTH; i++) {  
            if (i == currentPosition) {  
                System.out.print(HEART);  
            } else {  
                System.out.print(" ");  
            }  
        }  
        System.out.println(); // 换行以开始新的一行  
    }  
  
    // 清除控制台内容的方法（注意：这在某些操作系统或IDE中可能不起作用）  
    private static void clearConsole() {  
        final String os = System.getProperty("os.name");  
  
        try {  
            final String command;  
  
            if (os.contains("Windows")) {  
                command = "cls";  
            } else {  
                command = "clear";  
            }  
  
            final Process process = Runtime.getRuntime().exec(new String[]{command});  
  
            // 等待命令执行完成  
            process.waitFor();  
        } catch (final Exception e) {  
            e.printStackTrace();  
        }  
    }  
}
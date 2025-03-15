import java.util.Random;

/**
 * 冒泡排序类
 */
public class 冒泡排序 {
    /**
     * 主函数入口
     * @param args 命令行参数
     */
    public static void main(String[] args) {
//        定义一个数组
        int[] arr = {5, 3, 7, 9, 4, 2, 6, 8};
//        调用bubbleSort方法对数组进行排序
        bubbleSort(arr);
//        使用增强for循环遍历排序后的数组，并打印每个元素
        for (int i : arr) {
            System.out.print(arr[i]);
        }
    }

    /**
     * 对数组进行冒泡排序
     * @param arr 需要排序的数组
     */
    public static void bubbleSort(int[] arr) {
//        获取数组长度
        int length = arr.length;
//        外层循环控制排序的轮数
        for (int i =0; i < length-1 ; i++) {
//            内层循环控制每轮排序的比较次数
            for (int j = 0; j < length - i-1; j++) {
//                如果当前元素大于下一个元素，则交换它们的位置
                if (arr[j] > arr[j + 1]) {
//                    定义一个临时变量temp来交换arr[j]和arr[j+1]的值
                    int temp = arr[j];
//                    将较小的元素arr[j+1]赋值给arr[j]
                    arr[j] = arr[j + 1];
//                    将较大的元素temp（原arr[j]）赋值给arr[j+1]
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

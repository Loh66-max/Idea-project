public class 冒泡排序 {
    public static void main(String[] args) {
//        定义一个数组
        int[] arr = {1, 5, 3, 7, 9, 4};
        bubbleSort(arr);
        for (int j : arr) {
            System.out.print(j+" ");
        }
    }
//    定义一个方法对数组进行冒泡排序
    public static void bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
//            定义一个变量，记录数组中交换的次数
            for (int j = 0; j < length - 1 - i; j++) {
//                定义一个变量，记录数组中交换的次数
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
//                    定义一个变量，记录数组中交换的次数
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
//                    定义一个变量，记录数组中交换的次数

                }
            }
        }
    }
}

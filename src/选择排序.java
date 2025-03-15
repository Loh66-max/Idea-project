public class 选择排序 {
    public static void main(String[] args) {
        int[] a = {55, 43, 32, 211, 1333};
        selectSort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    /**
     * 定义一个选择排序的方法
     * 选择排序的原理是每次从未排序的部分中选出最小的元素，放到已排序部分的末尾
     * 此方法直接在输入数组上进行排序，不需要额外的存储空间
     * 时间复杂度为O(n^2)，适用于元素数量不大的情况
     *
     * @param a 待排序的整型数组
     */
    public static void selectSort(int[] a) {
        // 遍历数组，每次确定一个最小元素的位置
        for (int i = 0; i < a.length-1 ; i++) {
            // 假设当前位置的元素是最小的
            int min = i;
            // 从当前位置的下一个元素开始，寻找真正的最小元素
            for (int j = i + 1; j < a.length; j++) {
                // 如果找到更小的元素，记录其位置
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            // 如果找到的最小元素不在当前位置，将其与当前位置的元素交换
            if (min != i) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }
}





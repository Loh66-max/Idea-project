import java.util.Scanner;

/* 双链表结点定义 */
class DulNode {
    int data;
    DulNode prior;
    DulNode next;

    DulNode(int data) {
        this.data = data;
        this.prior = null;
        this.next = null;
    }
}

class DulLinkList {
    private DulNode first;

    /* 默认构造函数 */
    public DulLinkList() {
        first = new DulNode(0); // 生成头结点
        first.prior = null;
        first.next = null;
    }

    /* 带参构造函数 */
    public DulLinkList(int[] a, int n) {
        /* 传入一个长度为n的数组a，初始化线性表，补充尾插法代码 */
        first = new DulNode(0);
        DulNode rear = first;
        for (int i = 0; i < n; i++) {
            DulNode s = new DulNode(a[i]);
            rear.next = s;
            s.prior = rear;
            rear = s;
        }
        rear.next = null;
    }


    /* 返回链表长度 */
    public int getLength() {
        /* 补充获取链表长度的代码 */
        DulNode rear = first.next;
        int count = 0;
        while (rear != null) {
            rear = rear.next;
            count++;
        }
        return count;
    }


    /* 返回链表第i个元素 */
    public int getElement(int i) {
        /* 位置从1开始计数，若链表中不存在位置i，返回-1，否则返回该位置的数值 */
        DulNode rear = first.next;
        if (i < 1) {
            return -1;
        }
        for (int j = 1; rear != null; rear = rear.next, j++) {
            if (j == i) {
                return rear.data;
            }
        }
        return -1;


    }

    /* 返回元素x第一次出现的位置 */
    public int locate(int x) {
        /* 位置从1开始计数，若链表中没有元素x，返回-1，若查找成功，返回序号*/
        DulNode rear = first.next;
        for (int j = 1; rear != null; rear = rear.next, j++) {
            if (rear.data == x) {
                return j;
            }
        }
        return -1;
    }


    /* 在位置i处插入元素x */
    public void insert(int i, int x) {
    if (i < 1) return;

    DulNode rear = first;
    for (int j = 0; rear != null && j< i - 1; j++) {
        rear= rear.next;
    }

    if (rear == null) return;

    DulNode newNode = new DulNode(x);
    newNode.next = rear.next;
    newNode.prior = rear;

    if (rear.next != null) {
        rear.next.prior = newNode;
    }
    rear.next = newNode;
}



    /* 删除并返回位置i的元素 */
    public int delete(int i) {
        /* 位置从1开始计数，若删除位置错误，则什么都不用做并返回-1 */
        if (i < 1) return -1;

        DulNode rear = first.next;
        for (int j = 1; rear != null; rear = rear.next, j++) {
            if (j == i) {
                rear.prior.next = rear.next;
                if (rear.next != null) {
                    rear.next.prior = rear.prior;
                }
                return rear.data;
            }
        }
        return -1;
    }


    /* 返回链表是否为空 */
    public boolean isEmpty() {
        return first.prior == null && first.next == null;
    }

    /* 输出链表 */
    public void printList() {
        /* 如果链表为空，则什么都不输出 */
        /* 链表元素每两个之间用空格隔开，最后一个元素后没有空格，然后换行 */
        if (isEmpty()){
            return;
        }
        DulNode rear = first.next;
        while (rear!=null&&rear.next!=null){
            System.out.print(rear.data+" ");
            rear = rear.next;
        }
        System.out.println(rear.data);
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        DulLinkList linkList = new DulLinkList(a, n);
        while (scanner.hasNextInt()) {
            int index, value;
            int operate = scanner.nextInt();
            switch (operate) {
                case 1:
                    System.out.println("length = " + linkList.getLength());
                    break;
                case 2:
                    index = scanner.nextInt();
                    System.out.println("local " + index + " data = " + linkList.getElement(index));
                    break;
                case 3:
                    value = scanner.nextInt();
                    System.out.println("data " + value + " local = " + linkList.locate(value));
                    break;
                case 4:
                    index = scanner.nextInt();
                    value = scanner.nextInt();
                    linkList.insert(index, value);
                    System.out.print("list = ");
                    linkList.printList();
                    break;
                case 5:
                    index = scanner.nextInt();
                    System.out.println("delete data = " + linkList.delete(index));
                    System.out.print("deleted list = ");
                    linkList.printList();
                    break;
                case 6:
                    int intValue = linkList.isEmpty() ? 1 : 0;
                    System.out.println("list is empty = " + intValue);
                    break;
                case 7:
                    System.out.print("data = ");
                    linkList.printList();
                    break;
                default:
                    System.out.println("end");
                    scanner.close();
                    return;
            }
        }
        scanner.close();
    }
}
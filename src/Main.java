import java.util.Scanner;

// 定义链表节点类
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// 定义单链表类
class LinkList {
    private Node first;

    // 无参构造函数
    public LinkList() {
        first = new Node(0); // 生成头结点
        first.next = null;
    }

    // 有参构造函数
    public LinkList(int[] a, int n,int flag) {
        /* 传入一个长度为n的数组a，初始化单链表 */
        first = new Node(0); // 生成头结点
        if (flag == 1) { // 头插法
            for (int i = 0; i < n; i++) {
                Node s = new Node(a[i]);
                s.next = first.next;
                first.next = s;
            }

        } else if (flag == 0) { // 尾插法
            Node rear = first;
            for (int i = 0; i < n; i++) {
                Node s = new Node(a[i]);
                rear.next = s;
                rear = s;
            }
            rear.next = null;

        }
    }

    // 判断单链表是否为空
    public boolean isEmpty() {
        /* 头结点的引用域为null时，单链表为空，否则不为空 */
        return first.next == null ? true : false;
    }

    public void insert(int i/*插入位置*/, int x/*插入元素*/) {
        Node p = first; //工作引用p初始化，从头结点开始
        int local = 0; //local从0开始
        while (p != null && local < i- 1) {
            p =p.next;
            local++;
        }
        if (p == null || i < 1 || i > getLength()+1) {
            System.out.println("The insert position is invalid");; //没有找到第i-1个结点
        } else {
            Node s = new Node(x); //完成插入
            s.next = p.next;
            p.next = s;
        }
    }

    public int delete(int i) {
        Node p = first;    //工作引用p初始化，从头结点开始
        int local = 0;//local从0开始
        while (p != null && local < i- 1) {//查找第i-1个结点
            p = p.next;
            local++;
        }
        if (i < 1 || p == null || p.next == null) {
            System.out.println("The delete position is invalid");
            return -1;
        } else {
            Node q = p.next;
            int x = q.data;
            p.next = q.next;
            System.out.println(x); // 输出被删除的数据元素值
            return x;
        }
    }

    public int getLength() {
        Node p = first.next;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    public int getElement(int i) {
        /* 位置从1开始计数，若单链表中不存在位置i，返回-1，否则返回该位置的数值 */
        Node p = first.next;
        int local = 1;
        while (p != null && local < i) {
            p = p.next;
            local++;
        }
        if (p == null || i < 1) {
            System.out.println("The search position is invalid");
            return -1;
        } else
            return p.data;
    }

    public int locate(int x) {
        /* 位置从1开始计数，若单链表中没有元素x，返回-1，若查找成功，返回序号*/
        Node p = first.next;    //从第一个元素结点开始
        int local = 1;
        while (p != null) {
            if (p.data == x)
                return local;
            p = p.next;
            local++;
        }
        System.out.println("The element being searched for does not exist");
        return -1;
    }

    public void printList() {
        /* 如果链表为空，则什么都不输出 */
        /* 链表元素每两个之间用空格隔开，最后一个元素后没有空格，然后换行 */
        if (isEmpty()) {
            return;
        }
        Node p = first.next;
        while (p != null && p.next != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println(p.data);

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int flag = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        LinkList linkList = new LinkList(a, n, flag);
        int need = 1;
        while (need != 0) {
            need = scanner.nextInt();
            if (need == 2) {
                // 删除操作（方法内部已处理输出）
                int i = scanner.nextInt();
                linkList.delete(i); // 直接调用，不额外输出
            } else if (need == 1) {
                // 插入操作（方法内部已处理非法提示）
                int i = scanner.nextInt();
                int x = scanner.nextInt();
                linkList.insert(i, x);
            } else if (need == 3) {
                // 按位查找（成功时输出值，失败时方法内已提示）
                int index = scanner.nextInt();
                int element = linkList.getElement(index);
                if (element != -1) {
                    System.out.println(element);
                }
            } else if (need == 4) {
                // 按值查找（成功时输出位置，失败时方法内已提示）
                int x = scanner.nextInt();
                int position = linkList.locate(x);
                if (position != -1) {
                    System.out.println(position);
                }
            } else if (need == 5) {
                // 获取长度（直接输出）
                System.out.println(linkList.getLength());
            } else if (need == 6) {
                // 输出链表（方法内部已处理格式）
                linkList.printList();
            } else if (need == 0) {
                break;
            }
        }
        scanner.close();
    }
}

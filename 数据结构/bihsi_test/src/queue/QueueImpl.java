package queue;

//队列
public class QueueImpl implements IQueue {

    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int used;

    public QueueImpl() {
        this.front = null;
        this.rear = null;
        this.used = 0;
    }

    @Override
    public boolean empty() {
        return this.used == 0;
    }
    // 返回队首元素，但不出队列

    @Override
    public int peek() {
        if (empty()) {
            throw new UnsupportedOperationException("kongde");
        }
        return this.front.data;
    }

    // 返回队首元素，并且出队列
    @Override
    public int poll() {
        if (empty()) {
            throw new UnsupportedOperationException("kongde");
        }
        int old = this.front.data;
        this.front = front.next;
        this.used--;
        return old;
    }

    @Override
    public void add(int item) {

        Node node = new Node(item);
        if (this.front == null) {
            this.front = node;
            this.rear = node;
        } else {
            this.rear.next = node;
            //this.rear= this.rear.next;
            this.rear = node;
        }
        this.used++;
    }

    @Override
    public int size() {
       return this.used;
    }
}

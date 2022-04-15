class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }
}

public class CycleLinkedList<T> implements List<T> {
    private Node<T> start;
    private Node<T> end;
    private int size;

    public CycleLinkedList() {
        clear();
    }

    public void add(T element) {
        if (isEmpty()) {
            start = new Node<T>(element, start);
            end = start;
        } else {
            Node<T> newNode = new Node<T>(element, start);
            newNode.setNext(start);
            end.setNext(newNode);
            end = end.getNext();
        }
        size++;
    }

    public void add(T element, int index) {
        if (index == size()) {
            add(element);
            return;
        }
        if (index > size() || index < 0)
            throw new IndexOutOfBoundsException();

        Node<T> currentNode = start;
        Node<T> previousNode = end;

        while (index > 0) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            index--;
        }

        if (previousNode != null) {
            previousNode.setNext(new Node<T>(element, currentNode));
        } else {
            start = new Node<T>(element, start);
        }

        size++;
    }

    public T get(int index) {
        index = index % size();
        if (index < 0)
            index += size();

        Node<T> current = start;

        while (index > 0) {
            current = current.getNext();
            index--;
        }

        return current.getData();
    }

    public void clear() {
        start = null;
        end = null;
        size = 0;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public int size() {
        return size;
    }
}
public class LinkedList<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public boolean remove(T data) {
        if (head == null)
            return false;

        if (head.getData() != null && head.getData().equals(data)) {
            head = head.getNext();
            size--;
            return true;
        }

        Node<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData() != null && current.getNext().getData().equals(data)) {
                current.setNext(current.getNext().getNext());
                size--;
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData() != null && current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }   
    
    public T obtenerUltimo() {
        if (head == null) {
            return null;
        }
        Node<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current.getData();
    }

    public T eliminarUltimo() {
        if (head == null) {
            return null;
        }

        if (head.getNext() == null) {
            T data = head.getData();
            head = null;
            size--;
            return data;
        }

        Node<T> current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }

        T data = current.getNext().getData();
        current.setNext(null);
        size--;
        return data;
    }
}
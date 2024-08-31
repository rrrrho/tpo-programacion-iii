package Huffman;

public class MinHeap {
    // Member variables of this class
    private final Node[] Heap;
    private int size;
    private final int maxsize;

    // Initializing front as static with unity
    private static final int FRONT = 1;

    // Constructor of this class
    public MinHeap(int maxsize) {
        // This keyword refers to current object itself
        this.maxsize = maxsize;
        this.size = 0;

        Heap = new Node[this.maxsize + 1];
        Heap[0] = new Node(Integer.MIN_VALUE);
    }

    // Method 1
    // Returning the position of
    // the parent for the node currently
    // at pos
    private int parent(int pos) {
        return pos / 2;
    }

    // Method 2
    // Returning the position of the
    // left child for the node currently at pos
    private int leftChild(int pos) {
        return (2 * pos);
    }

    // Method 3
    // Returning the position of
    // the right child for the node currently
    // at pos
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    // Method 4
    // Returning true if the passed
    // node is a leaf node
    private boolean isLeaf(int pos) {
        return pos > (size / 2);
    }

    // Method 5
    // To swap two nodes of the heap
    private void swap(int fpos, int spos) {
        Node tmp;
        tmp = Heap[fpos];

        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // Method 6
    // To heapify the node at pos
    private void minHeapify(int pos) {
        if(!isLeaf(pos)){
            int swapPos= pos;
            // swap with the minimum of the two children
            // to check if right child exists. Otherwise default value will be '0'
            // and that will be swapped with parent node.
            if(rightChild(pos)<=size)
                swapPos = Heap[leftChild(pos)].getFrequency() < Heap[rightChild(pos)].getFrequency() ?
                        leftChild(pos):rightChild(pos);
            else
                swapPos= leftChild(pos);

            if(Heap[pos].getFrequency() > Heap[leftChild(pos)].getFrequency() ||
                    Heap[pos].getFrequency() > Heap[rightChild(pos)].getFrequency()){
                swap(pos,swapPos);
                minHeapify(swapPos);
            }
        }
    }

    // Method 7
    // To insert a node into the heap
    public void insert(Node element) {
        if (size >= maxsize) {
            return;
        }

        Heap[++size] = element;
        int current = size;

        while (Heap[current].getFrequency() < Heap[parent(current)].getFrequency()) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Method 8
    // To print the contents of the heap
    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            String result = "PARENT : " + Heap[i].getFrequency();

            int leftChildIndex = 2 * i;
            if (leftChildIndex <= size) {
                result += " LEFT CHILD : " + Heap[leftChildIndex].getFrequency();
            }

            int rightChildIndex = 2 * i + 1;
            if (rightChildIndex <= size) {
                result += " RIGHT CHILD : " + Heap[rightChildIndex].getFrequency();
            }

            // Printing the parent and both childrens
            System.out.print(result);

            // By here new line is required
            System.out.println();
        }
    }

    // Method 9
    // To remove and return the minimum
    // element from the heap
    public Node remove() {
        Node popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);

        return popped;
    }
}
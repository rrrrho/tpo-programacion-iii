import Huffman.MinHeap;
import Huffman.Node;

public class Main {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap(7);
        heap.insert(new Node("A", 1));
        heap.insert(new Node("B", 3));
        heap.insert(new Node("C", 5));
        heap.insert(new Node("D", 7));
        heap.insert(new Node("E", 9));
        heap.insert(new Node("F", 8));
        heap.insert(new Node("G", 10));
        heap.print();
        System.out.println("Removed: " + heap.remove().getFrequency());
        heap.print();
        System.out.println("Removed: " + heap.remove().getFrequency());
        heap.print();
        System.out.println("Inserted: 12");
        heap.insert(new Node("H", 12));
        heap.print();
    }
}
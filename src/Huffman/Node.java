package Huffman;

public class Node {
    private String symbol;
    private int frequency;

    public Node(int frequency) {
        this.frequency = frequency;
    }

    public Node(String symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
    }

    // getters and setters
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}

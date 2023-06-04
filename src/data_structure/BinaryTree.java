package data_structure;

/**
 * Binary tree data structure
 *
 * @author Frank_Xiao
 */
public class BinaryTree {
    /**
     * left and right subtree
     */
    private BinaryTree left, right;
    /**
     * value of the stored character, null if it's not a leaf
     */
    private final Character ch;
    /**
     * frequency of the character
     */
    private final int frequency;
    /**
     * indicate whether it's a left subtree of a right subtree
     */
    private int lor;


    /**
     * Constructs a tree with character or frequency
     *
     * @param ch        character or null
     * @param frequency frequency of the node
     */
    public BinaryTree(Character ch, int frequency) {
        this.ch = ch;
        this.frequency = frequency;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public Character getCh() {
        return ch;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setLor(int lor) {
        this.lor = lor;
    }

    public int getLor() {
        return lor;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "ch=" + ch +
                ", frequency=" + frequency +
                ", lor=" + lor +
                '}';
    }
}

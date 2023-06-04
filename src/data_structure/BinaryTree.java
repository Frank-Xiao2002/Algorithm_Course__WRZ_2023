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
    private Character ch;
    /**
     * frequency of the character
     */
    private int frequency;
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

    /**
     * @param left
     * @param right
     * @param ch
     * @param frequency
     * @param lor
     */
    public BinaryTree(BinaryTree left, BinaryTree right, Character ch, int frequency, int lor) {
        this.left = left;
        this.right = right;
        this.ch = ch;
        this.frequency = frequency;
        this.lor = lor;
    }
}

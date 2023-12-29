package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class node {
    int data;
    node left;
    node right;

    public node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTreeStructure {
    node root;

    public BinaryTreeStructure() {
        root = null;
    }

    public static void main(String[] args) {
        BinaryTreeStructure tree = new BinaryTreeStructure();

        // Membentuk pohon dengan menambahkan simpul
        tree.root = new node(50);
        tree.root.left = new node(30);
        tree.root.right = new node(70);
        tree.root.left.left = new node(10);
        tree.root.left.right = new node(35);
        tree.root.right.left = new node(65);
        tree.root.right.right = new node(80);

        // Cetak struktur pohon seperti struktur folder
        System.out.println("Struktur Pohon:");
        printTreeStructure(tree.root, "", true);

        System.out.println("\nPreorder Traversal:");
        tree.preorderTraversal(tree.root);

        System.out.println("\nInorder Traversal:");
        tree.inorderTraversal(tree.root);

        System.out.println("\nPostorder Traversal:");
        tree.postorderTraversal(tree.root);

        System.out.println("\nlevel order Traversal:");
        BinaryTreeStructure.LevelOrder(tree.root );

    }

    public static void printTreeStructure(node node, String prefix, boolean isTail) {
        if (node != null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + node.data);
            if (node.left != null || node.right != null) {
                printTreeStructure(node.left, prefix + (isTail ? "    " : "│   "), false);
                printTreeStructure(node.right, prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }

    public void preorderTraversal(node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    public void inorderTraversal(node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    public void postorderTraversal(node node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void LevelOrder(node root) {
        Queue<node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}

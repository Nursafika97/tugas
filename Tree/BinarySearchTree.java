package Tree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    String data;
    TreeNode left;
    TreeNode right;

    public TreeNode(String data) {
        this.data = data;
        left = right = null;
    }
}

class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    // Metode untuk menyisipkan node baru dalam BST
    public TreeNode insert(TreeNode root, String data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data.compareTo(root.data) < 0) {
            root.left = insert(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // Metode untuk melakukan traversal preorder
    public void preorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    // Metode untuk melakukan traversal inorder
    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    // Metode untuk melakukan traversal postorder
    public void postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Metode untuk melakukan traversal level-order
    public void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // Metode untuk mencetak struktur pohon
    public static void printTreeStructure(TreeNode node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.data);
            printTreeStructure(node.left, prefix + (isLeft ? "│   " : "    "), true);
            printTreeStructure(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Menyusun tree seperti yang dijelaskan
        tree.root = tree.insert(tree.root, "mango");
        tree.root = tree.insert(tree.root, "apple");
        tree.root = tree.insert(tree.root, "banana");
        tree.root.right = tree.insert(tree.root.right, "orange");
        tree.root.right = tree.insert(tree.root.right, "grapes");
        tree.root.right.right = tree.insert(tree.root.right.right, "pineapple");
        tree.root.right.right.left = tree.insert(tree.root.right.right.left, "peach");

        // Menampilkan struktur pohon sebelum traversal
        System.out.println("Struktur Pohon:");
        printTreeStructure(tree.root, "", true);

        // Menampilkan hasil dari traversal
        System.out.println("\nPreorder Traversal:");
        tree.preorderTraversal(tree.root);

        System.out.println("\n\nInorder Traversal:");
        tree.inorderTraversal(tree.root);

        System.out.println("\n\nPostorder Traversal:");
        tree.postorderTraversal(tree.root);

        System.out.println("\n\nLevel-order Traversal:");
        tree.levelOrderTraversal(tree.root);
    }
}

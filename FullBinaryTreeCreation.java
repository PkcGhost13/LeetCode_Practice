package LeetCode_Practice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class FullBinaryTreeCreation {
    static Map<Integer, List<TreeNode>> saved = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> binaryTrees = new ArrayList<>();
        if (n % 2 == 0) {
            return binaryTrees;
        }
        if (!saved.containsKey(n)) {
            if (n == 1) {
                binaryTrees.add(new TreeNode(0));
            } else {
                for (int i = 1; i < n; i += 2) {
                    List<TreeNode> lTrees = allPossibleFBT(i);
                    List<TreeNode> rTrees = allPossibleFBT(n - 1 - i);
                    for (TreeNode lt : lTrees) {
                        for (TreeNode rt : rTrees) {
                            binaryTrees.add(new TreeNode(0, lt, rt));
                        }
                    }
                }
            }
            saved.put(n,binaryTrees);
        }
        return saved.get(n);
    }

    // Helper method to serialize a tree into a list
    public List<Integer> serialize(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                result.add(null);
            }
        }
        // Remove trailing nulls
        // while (result.size() > 0 && result.get(result.size() - 1) == null) {
        //     result.remove(result.size() - 1);
        // }
        return result;
    }

    public static void main(String[] args) {
        FullBinaryTreeCreation fbt = new FullBinaryTreeCreation();
        List<TreeNode> result = fbt.allPossibleFBT(11);
        System.out.println("Total Full Binary Trees: " + result.size());
        for (TreeNode tree : result) {
            List<Integer> serializedTree = fbt.serialize(tree);
            System.out.println(serializedTree);
        }
    }
}
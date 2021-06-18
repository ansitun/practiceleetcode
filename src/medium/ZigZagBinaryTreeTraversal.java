package medium;
import java.util.*;

public class ZigZagBinaryTreeTraversal {
    public static class TreeNode {
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

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

            Queue<TreeNode> q = new LinkedList<>();
            int level = 0;

            List<List<Integer>> result = new ArrayList<>();
            if (root == null)
                return result;

            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            result.add(list);
            q.add(root);
            level++;

            int size = q.size();
            while (q.size() > 0) {

                list = new ArrayList<>();
                for (int i = 0; i < size; i++) {

                    TreeNode node = q.poll();

                    if (node.left != null) {
                        q.add(node.left);
                        list.add(node.left.val);
                    }

                    if (node.right != null) {
                        q.add(node.right);
                        list.add(node.right.val);
                    }
                }

                if (level % 2 != 0) {
                    Collections.reverse(list);
                }
                level++;
                size = q.size();

                if (list.size() > 0)
                    result.add(list);
            }

            return result;
        }

        public static void main(String[] args) {
            ZigZagBinaryTreeTraversal z = new ZigZagBinaryTreeTraversal();
            System.out.println(z.zigzagLevelOrder(new TreeNode(123)));
        }
}

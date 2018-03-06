package questions;

import org.junit.Test;

/**
 * Created by LZP on 2018/1/14.
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * 我们约定空树不是任意一个树的子结构
 */
public class Lzp16 {
    public boolean Judge(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root2 == null && root1 != null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        if (root2.left != null && root1.left == null) {
            return false;
        }
        if (root2.left != null && root1.left != null) {
            if (!Judge(root1.left, root2.left)) {
                return false;
            }
        }
        if (root2.right != null && root1.right == null) {
            return false;
        }
        if (root2.right != null && root1.right != null) {
            if (!Judge(root1.right, root2.right)) {
                return false;
            }
        }

        return true;
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return false;
        }
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root2 == null && root1 != null) {
            return false;
        }
        if (root1.val == root2.val) {
            if (Judge(root1, root2)) {
                return true;
            }
            //同步递归两棵树，直到递归完成且所有值相等
        }
        if (root1.left != null) {
            if (HasSubtree(root1.left, root2)) {
                return true;
            }
            //左子树判断
        }
        if (root1.right != null) {
            if (HasSubtree(root1.right, root2)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        TreeNode treeNode1 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(8);
        TreeNode treeNode3 = new TreeNode(9);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.right = treeNode2;
        treeNode2.right = treeNode3;
        treeNode3.right = treeNode4;
        treeNode4.right = treeNode5;


        TreeNode treeNode6 = new TreeNode(8);
        TreeNode treeNode7 = new TreeNode(9);
        TreeNode treeNode8 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(2);
        treeNode6.right = treeNode7;
        treeNode7.left = treeNode8;
        treeNode8.left = treeNode9;
        Lzp16 lzp = new Lzp16();
        boolean x = lzp.HasSubtree(treeNode1, treeNode6);
        System.out.println(x);
    }
}

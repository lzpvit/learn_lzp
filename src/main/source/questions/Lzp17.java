package questions;

/**
 * Created by LZP on 2018/1/14.
 * ���������Ķ�����������任ΪԴ�������ľ���
 */
public class Lzp17 {
    public void Mirror(TreeNode root) {
        if (root!=null) {
            TreeNode tmp;
            if (root.left != null && root.right != null) {
                Mirror(root.left);
                Mirror(root.right);
                tmp = root.left;
                root.left = root.right;
                root.right = tmp;
            } else if (root.left == null && root.right != null) {
                Mirror(root.right);
                root.left = root.right;
                root.right = null;
            } else if (root.left != null && root.right == null) {
                Mirror(root.left);
                root.right = root.left;
                root.left = null;
            } else {
            }
        }
    }
}

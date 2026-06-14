/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // [1=[2=[],[]],[3=[4=[],[]],[5=[],[]]]]
        StringBuilder sb = new StringBuilder();
        recursionSerialize(root, sb);
        return sb.toString();
    }

    private void recursionSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("[]");
            return;
        }

        sb.append('[');

        sb.append(root.val);
        sb.append('=');

        recursionSerialize(root.left, sb);
        sb.append(',');
        recursionSerialize(root.right, sb);

        sb.append(']');
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;
        return recursionDeserialize(data);
    }

    private TreeNode recursionDeserialize(String data) {
        if (data.charAt(index) == '[' &&
            data.charAt(index + 1) == ']') {
            index += 2;
            return null;
        }

        index++;

        int sign = 1;
        if (data.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        int value = 0;
        while (index < data.length() &&
               Character.isDigit(data.charAt(index))) {
            value = value * 10 + (data.charAt(index) - '0');
            index++;
        }

        TreeNode node = new TreeNode(value * sign);

        index++;

        node.left = recursionDeserialize(data);

        if (index < data.length() && data.charAt(index) == ',') {
            index++;
            node.right = recursionDeserialize(data);
        }

        if (index < data.length() && data.charAt(index) == ']') {
            index++;
        }

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
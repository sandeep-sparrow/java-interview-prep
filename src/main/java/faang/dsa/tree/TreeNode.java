package faang.dsa.tree;

import java.util.ArrayList;

public class TreeNode {

    String data;
    ArrayList<TreeNode> children;

    public TreeNode(String data) {
        this.data = data;
        this.children = new ArrayList<>();
    }
    
    public void addChild(TreeNode node) {
        this.children.add(node);
    }

    public String print(int level) {
        String ret;
        ret = TreeNode.repeat(" ", level)+data+"\n";
        for(TreeNode child: children) {
            ret += child.print(level+1);
        }
        return ret;
    }

    public static String repeat(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}

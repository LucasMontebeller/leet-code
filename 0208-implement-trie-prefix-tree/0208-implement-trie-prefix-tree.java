class Trie {
    class Node {
            char val;
            Map<Character, Node> children = new HashMap<>();
            boolean isEndOfWord;

            Node(char val) {
                this.val = val;
            }
        }

    private final Node root;

    public Trie() {
        root = new Node('\0');
    }

    public void insert(String word) {
        Node current = root;

        for (char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new Node(c));
            current = current.children.get(c);
        }

        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        Node node = findNode(word);
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    private Node findNode(String str) {
        Node current = root;

        for (char c : str.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return null;
            }
            current = current.children.get(c);
        }

        return current;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
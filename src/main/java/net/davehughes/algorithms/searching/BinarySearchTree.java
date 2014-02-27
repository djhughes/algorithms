package net.davehughes.algorithms.searching;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
  // Root of the tree
  private Node root;

  private class Node {
    // Sorted by key
    private Key key;
    // Associated data
    private Value value;
    // Root of the left sub-tree
    private Node left;
    // Root of the right sub-tree
    private Node right;

    public Node(Key key, Value value) {
      this.key = key;
      this.value = value;
    }
  }

  /**
   * Checks if there is a node with the given key.
   *
   * @param key search key
   * @return true if there is a node in the tree with the given key, otherwise false
   */
  public boolean contains(Key key) {
    return get(key) != null;
  }

  /**
   * Returns the value associated with the given key.
   *
   * @param key search key
   * @return the value associated with the given tree if it is present in the tree, otherwise null.
   */
  public Value get(Key key) {
    return get(root, key);
  }

  private Value get(Node node, Key key) {
    if (node == null) {
      return null;
    }

    int comparison = key.compareTo(node.key);

    if (comparison < 0) {
      return get(node.left, key);
    } else if (comparison > 0) {
      return get(node.right, key);
    } else {
      return node.value;
    }
  }

  /**
   * Inserts the given key-value pair into the tree. If the key already exists then update with the
   * new value.
   *
   * @param key
   * @param value
   */
  public void put(Key key, Value value) {
    if (value == null) {
      delete(key);
      return;
    }

    root = put(root, key, value);
  }

  private Node put(Node node, Key key, Value value) {
    if (node == null) {
      return new Node(key, value);
    }

    int comparison = key.compareTo(node.key);

    if (comparison < 0) {
      node.left = put(node.left, key, value);
    } else  if (comparison > 0) {
      node.right = put(node.right, key, value);
    } else {
      node.value = value;
    }

    return node;
  }

  /**
   * Deletes the node with the given key.
   * @param key search key
   */
  public void delete(Key key) {
    root = delete(root, key);
  }

  private Node delete(Node node, Key key) {
    if (node == null) {
      return null;
    }

    int comparison = key.compareTo(node.key);

    if (comparison < 0) {
      node.left = delete(node.left, key);
    } else if (comparison > 0) {
      node.right = delete(node.right, key);
    } else {
      // If there is no right sub-tree then replace this node with the left sub-tree
      if (node.right == null) {
        return node.left;
      }

      // If there is no left sub-tree then replace this node with the right sub-tree
      if (node.left == null) {
        return node.right;
      }

      Node temp = node;
      // Reassign 'node' to be the smallest node in the right sub-tree.
      node = min(temp.right);
      // Set the right sub-tree of the replacement node to be that of the now-deleted node, minus
      // the node that we've taken out of it to be this replacement node.
      node.right = deleteMin(temp.right);
      // Set the left sub-tree of the replacement node to be that of the deleted node.
      node.left = temp.left;
    }

    return node;
  }

  private Node deleteMin(Node node) {
    if (node.left == null) {
      return node.right;
    }

    node.left = deleteMin(node.left);

    return node;
  }

  private Node min(Node node) {
    if (node.left == null) {
      return node;
    } else {
      return min(node.left);
    }
  }

  public void traverseInOrder() {
    traverseInOrder(root);
  }

  private void traverseInOrder(Node node) {
    if (node == null) {
      return;
    }

    traverseInOrder(node.left);

    System.out.println(String.format("Key: %s, Value: %s", node.key, node.value));

    traverseInOrder(node.right);
  }

  public static void main(String[] args) {
    BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<Integer, Integer>();
    Integer[] values = {7, 5, 10, 2, 6, 8, 12};
    for (Integer value : values) {
      tree.put(value, value);
    }

    tree.traverseInOrder();

    tree.delete(7);

    System.out.println("\n");

    tree.traverseInOrder();
  }
}

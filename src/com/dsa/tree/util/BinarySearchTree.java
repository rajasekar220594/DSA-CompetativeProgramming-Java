package com.dsa.tree.util;

public class BinarySearchTree {
	
	private Node root;
	
	public Node insertBSTRecursive(Node currentNode, int value) {
		Node newNode = null;
		if(currentNode == null) {
			newNode = new Node(value);
			return newNode;
		}
		if(value < currentNode.data) {
			currentNode.left = insertBSTRecursive(currentNode.left, value);
		} else if(value > currentNode.data) {
			currentNode.right = insertBSTRecursive(currentNode.right, value);
		}
		return currentNode;
	}
	
	public Node insertBSTIterative(int value) {
		if(root == null) {
			root = new Node(value);
			return root;
		}
		Node current = root, previous = null;
		while(current != null) {
			previous = current;
			if(current.data == value) {
				return current;
			} else if(value < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		
		Node newNode = new Node(value);
		if(current == null && value < previous.data) {
			previous.left = newNode;
		} else {
			previous.right = newNode;
		}
		return newNode;
	}
	
	public void createBST(int arr[]) {
		root = new Node(arr[0]);
		Node current, previous;
		for(int i=1; i<arr.length; i++) {
			current = root;
			previous = null;
			while(current != null) {
				previous = current;
				if(current.data == arr[i]) {
					break;
				} else if(arr[i] < current.data) {
					current = current.left;
				} else {
					current = current.right;
				}
			}
			Node newNode = new Node(arr[i]);
			if(current == null && arr[i] < previous.data) {
				previous.left = newNode;
			} else {
				previous.right = newNode;
			}
		}
	}
	
	public Node searchBSTRecursive(Node node, int key) {
		if(node == null) return null;
		if(key == node.data) {
			return node;
		} else if(key < node.data) {
			return searchBSTRecursive(node.left, key);
		} else {
			return searchBSTRecursive(node.right, key);
		}
	}
	
	public Node searchBSTIterative(Node node, int key) {
		while(node != null) {
			if(node.data == key) {
				return node;
			} else if(key < node.data) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return null;
	}

	public static void inOrderBST(Node root) {
		if(root == null) return;
		inOrderBST(root.left);
		System.out.print(root.data+" ");
		inOrderBST(root.right);
	}
	
	 /**
     * Return node's successor value
     * @param root
     * @return
     */
    private int successor(Node root){
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root.data;
    }
    /**
     * Return node's predecessor value
     * @param root
     * @return
     */
    private int predecessor(Node root){
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.data;
    }
    
	public static int height(Node root) {
		int x,y;
		if(root==null)return 0;
		
		x=height(root.left);
		y=height(root.right);
		return x>y?x+1:y+1;
	}
	
	public Node deleteNodeRecursive(Node root, int key) {
		if(root == null) return null;
		if(root.left == null && root.right == null){ //its a leaf node;
            root = null;
            return null;
        }
		
		if(key < root.data){ //move left
            root.left = deleteNodeRecursive(root.left, key);
        } else if(key > root.data){ //move right
            root.right = deleteNodeRecursive(root.right, key);
        } else {
        	if(height(root.left) > height(root.right)) {
        		root.data = predecessor(root);
                root.left = deleteNodeRecursive(root.left, root.data);
        	} else {
        		root.data = successor(root); // my worthy successor
                root.right = deleteNodeRecursive(root.right, root.data);
        	}
        }
		return root;
		
        /*
		if(root == null) return root;
        if(key > root.data){ //move right
            root.right = deleteNodeRecursive(root.right, key);
        }else if(key < root.data){ //move left
            root.left = deleteNodeRecursive(root.left, key);
        }else{ //oh yes, we finally found the target
            if(root.left == null && root.right == null){ //hmm, its a leaf node; easy peasy
                root = null;
            }else if(root.right != null){ // oh, it has a right child, don't make it an orphan or is it old enough to become a parent ? lets find out
                root.data = successor(root); // my worthy successor
                root.right = deleteNodeRecursive(root.right, root.data);
            }else{ //oh it seems that I do not have a worthy successor, fallback, fallback ...
                root.data = predecessor(root);
                root.left = deleteNodeRecursive(root.left, root.data);
            }
        }
        return root;*/
    }
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		int arr[] = {30,20,40,10,25,35,50};
		
		tree.createBST(arr);
		
		tree.inOrderBST(tree.root);
		
		tree.deleteNodeRecursive(tree.root, 30);
		tree.inOrderBST(tree.root);
	}
	
}

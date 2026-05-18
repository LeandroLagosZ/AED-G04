package bstreelinklistinterfgeneric;

import bstreeInterface.BinarySearchTree;
import Exceptions.*;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {
	private class Node {
		E data;
		Node left;
		Node right;

		public Node(E data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	private Node root;

	public LinkedBST() {
		root = null;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void insert(E data) throws ItemDuplicated {
		root = insertRec(root, data);
	}

	private Node insertRec(Node current, E data) throws ItemDuplicated {
		if (current == null) {
			return new Node(data);
		}
		int cmp = data.compareTo(current.data);
		if (cmp < 0) {
			current.left = insertRec(current.left, data);
		} 
		else if (cmp > 0) {
			current.right = insertRec(current.right, data);
		} 
		else {
			throw new ItemDuplicated("Elemento duplicado: " + data);
		}

		return current;
	}

	@Override
	public E search(E data) throws ItemNotFound {
		Node result = searchRec(root, data);
		if (result == null) {
			throw new ItemNotFound("Elemento no encontrado: " + data);
		}
		return result.data;
	}

	private Node searchRec(Node current, E data) {
		if (current == null) {
			return null;
		}
		int cmp = data.compareTo(current.data);
		if (cmp == 0) {
			return current;
		}
		if (cmp < 0) {
			return searchRec(current.left, data);
		}

		return searchRec(current.right, data);
	}

	@Override
	public void delete(E data) throws ExceptionIsEmpty {
		if (isEmpty()) {
			throw new ExceptionIsEmpty("El árbol está vacío");
		}

		root = deleteRec(root, data);
	}

	private Node deleteRec(Node current, E data) {
		if (current == null) {
			return null;
		}
		int cmp = data.compareTo(current.data);

		if (cmp < 0) {
			current.left = deleteRec(current.left, data);
		} 
		else if (cmp > 0) {
			current.right = deleteRec(current.right, data);
		} 
		else {
			// Suponiendo que no tiene hijos
			if (current.left == null && current.right == null) {
				return null;
			}

			// Suponiendo que tiene 1 hijo
			if (current.left == null) {
				return current.right;
			}

			if (current.right == null) {
				return current.left;
			}

			// Suponiendo que tiene 2 hijos
			Node successor = findMin(current.right);
			current.data = successor.data;
			current.right = deleteRec(current.right, successor.data);
		}

		return current;
	}



	public void inOrder() {
		inOrderRec(root);
		System.out.println();
	}

	private void inOrderRec(Node current) {
		if (current != null) {
			inOrderRec(current.left);
			System.out.print(current.data + " ");
			inOrderRec(current.right);
		}
	}

	public void preOrder() {
		preOrderRec(root);
		System.out.println();
	}

	private void preOrderRec(Node current) {
		if (current != null) {
			System.out.print(current.data + " ");
			preOrderRec(current.left);
			preOrderRec(current.right);
		}
	}

	public void postOrder() {
		postOrderRec(root);
		System.out.println();
	}

	private void postOrderRec(Node current) {
		if (current != null) {
			postOrderRec(current.left);
			postOrderRec(current.right);
			System.out.print(current.data + " ");
		}
	}

	public E min() throws ExceptionIsEmpty {
		if (isEmpty()) throw new ExceptionIsEmpty("Árbol vacío");
		return findMin(root).data;
	}

	private Node findMin(Node current) {
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	public E max() throws ExceptionIsEmpty {
		if (isEmpty()) throw new ExceptionIsEmpty("Árbol vacío");
		return findMax(root).data;
	}

	private Node findMax(Node current) {
		while (current.right != null) {
			current = current.right;
		}
		return current;
	}

	public void destroyNodes() throws ExceptionIsEmpty {
		if (isEmpty()) {
			throw new ExceptionIsEmpty("El árbol está vacío");
		}
		root = null;
	}

	public int countAllNodes() {
		return countAllNodesRec(root);
	}

	private int countAllNodesRec(Node current) {
		if (current == null) {
			return 0;
		}
		return 1 + countAllNodesRec(current.left) + countAllNodesRec(current.right);
	}

	public int countNodes() {
		return countNodesRec(root);
	}

	private int countNodesRec(Node current) {
		if (current == null || (current.left == null && current.right == null)) {
			return 0;
		}
		return 1 + countNodesRec(current.left) + countNodesRec(current.right);
	}

	public int height(E x) {
		Node target = root;
		while (target != null) {
			int cmp = x.compareTo(target.data);
			if (cmp == 0) break;
			else if (cmp < 0) target = target.left;
			else target = target.right;
		}

		if (target == null) {
			return -1;
		}

		java.util.Queue<Node> queue = new java.util.LinkedList<>();
		queue.add(target);
		int nodeHeight = -1;

		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			nodeHeight++;
			for (int i = 0; i < levelSize; i++) {
				Node current = queue.poll();
				if (current.left != null) queue.add(current.left);
				if (current.right != null) queue.add(current.right);
			}
		}
		return nodeHeight;
	}

	public int amplitude(int nivel) {
		if (root == null) {
			return 0;
		}

		java.util.Queue<Node> queue = new java.util.LinkedList<>();
		queue.add(root);
		int currentLevel = 0;

		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			if (currentLevel == nivel) {
				return levelSize;
			}
			for (int i = 0; i < levelSize; i++) {
				Node current = queue.poll();
				if (current.left != null) queue.add(current.left);
				if (current.right != null) queue.add(current.right);
			}
			currentLevel++;
		}
		return 0;
	}

	public int areaBST() throws ExceptionIsEmpty {
		if (isEmpty()) {
			throw new ExceptionIsEmpty("El árbol está vacío");
		}

		int treeHeight = -1;
		java.util.Queue<Node> heightQueue = new java.util.LinkedList<>();
		heightQueue.add(root);

		while (!heightQueue.isEmpty()) {
			int levelSize = heightQueue.size();
			treeHeight++;
			for (int i = 0; i < levelSize; i++) {
				Node current = heightQueue.poll();
				if (current.left != null) heightQueue.add(current.left);
				if (current.right != null) heightQueue.add(current.right);
			}
		}

		int leafCount = 0;
		java.util.Queue<Node> leafQueue = new java.util.LinkedList<>();
		leafQueue.add(root);

		while (!leafQueue.isEmpty()) {
			Node current = leafQueue.poll();
			if (current.left == null && current.right == null) {
				leafCount++;
			}
			if (current.left != null) leafQueue.add(current.left);
			if (current.right != null) leafQueue.add(current.right);
		}

		return leafCount * treeHeight;
	}

	public void drawBST() {
        if (isEmpty()) {
            System.out.println("Árbol vacío");
            return;
        }
        System.out.println("\nEstructura del Árbol:");
        drawBSTRec(root, 0);
        System.out.println();
    }

    private void drawBSTRec(Node current, int nivel) {
        if (current != null) {
            drawBSTRec(current.right, nivel + 1);

            for (int i = 0; i < nivel; i++) {
                System.out.print("      "); 
            }
            
            System.out.println(current.data);
            drawBSTRec(current.left, nivel + 1);
        }
    }
}
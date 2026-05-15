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

    @Override
    public String toString() {
        if (isEmpty()) {
            return "BST vacío";
        }
        return toStringRec(root);
    }

    private String toStringRec(Node current) {
        if (current == null) {
            return "";
        } 
        String resultado = "";
        resultado += toStringRec(current.left);
        resultado += current.data + " ";
        resultado += toStringRec(current.right);
        
        return resultado;
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
}
package com.daoshan.school.demo.java.链表;

/**
 * 节点
 * @param <T>
 */
public class Node<T> {

    private T t;

    private Node<T> nextNode;

    public Node(T t){
        this.t = t;
    }

    public Node<T> getNode() {
        return nextNode;
    }

    public void setNode(Node<T> node) {
        this.nextNode = node;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

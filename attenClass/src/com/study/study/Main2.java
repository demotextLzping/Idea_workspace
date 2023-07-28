package com.study.study;

import java.io.InputStreamReader;
import java.util.Scanner;

class Node {
    private int value;
    private Node next;

    public Node() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}

class MyLinkedList {
    Node head;
    Node next;
    int count;

    public void add(int value) {
        if (head == null) {
            Node node = new Node();
            node.setValue(value);
            node.setNext(null);
            head = node;
            next = node;
        } else {
            Node node = new Node();
            node.setValue(value);
            node.setNext(null);
            next.setNext(node);
            next = node;
        }
        count++;
    }

    public void delete(int index) {
        Node node = head;
        if (index == 1) {
            head = node.getNext();
        } else {
            for (int i = 1; i < index - 1; i++) {
                node = node.getNext();
            }
            Node temp = node.getNext();
            node.setNext(temp.getNext());
        }
        count--;
    }

    public void addIndex(int index, int value) {
        if (index == 0) {
            Node node = new Node();
            node.setValue(value);
            node.setNext(head);
            head = node;
        } else if (index < count) {
            Node node = head;
            for (int i = 1; i < index; i++) {
                node = node.getNext();
            }
            Node temp = new Node();
            temp.setValue(value);
            temp.setNext(node.getNext());
            node.setNext(temp);

        }else {
            Node node=new Node();
            next.setNext(node);
            node.setValue(value);
            node.setNext(null);

        }
        count++;
    }

    public void get() {
        Node node = head;
        for (int i = 0; i < count; i++) {
            System.out.print(node.getValue() + " ");
            node = node.getNext();

        }
    }
}

public class Main2 {
    public static void main(String[] args) {
        MyLinkedList mll = new MyLinkedList();
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            mll.add(scanner.nextInt());
        }
        int runCount = scanner.nextInt();
        while (scanner.hasNextInt()) {
            int flag = scanner.nextInt();
            int index = scanner.nextInt();
            if (flag == 0) {
                int value = scanner.nextInt();
                if (index <= mll.count) {
                    mll.addIndex(index, value);
                }
            } else {
                if (index > 0 && index < mll.count) {
                    mll.delete(index);
                }
            }
            runCount--;
            if (runCount == 0) {
                break;
            }
        }
        mll.get();
        System.out.println();
    }
}

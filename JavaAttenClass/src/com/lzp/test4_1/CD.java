package com.lzp.test4_1;

/**
 * @author£º LZPing
 * @date£º 2022-11-18 14:00
 * @Description
 */
public class CD {
    private int size;
    private int content[];

    public void setSize(int size) {
        this.size = size;
        content = new int[size];
    }

    public int getSize() {
        return size;
    }

    public int[] getContent() {
        return content;
    }

    public void setContent(int[] content) {
        this.content = content;
    }
}
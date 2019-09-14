package com.github.hcsp.multithread;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int value = 0;

    ReentrantLock lock = new ReentrantLock();

    public int getValue() {
        lock.lock();
        try {
            return value;
        } finally {
            lock.unlock();
        }
    }

    // 加上一个整数i，并返回加之后的结果
    public int addAndGet(int i) {
        lock.lock();
        try {
            value += i;
            return value;
        } finally {
            lock.unlock();
        }
    }

    // 减去一个整数i，并返回减之后的结果
    public int minusAndGet(int i) {
        lock.lock();
        try {
            value -= i;
            return value;
        } finally {
            lock.unlock();
        }
    }
}

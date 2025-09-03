package com.alex.aula2;

public class Main {
    public static void main(String[] args) {

        MinhaThreadRunnable threadRunnable1 = new MinhaThreadRunnable("Thread #1", 200);

        MinhaThreadRunnable threadRunnable2 = new MinhaThreadRunnable("Thread #2", 150);

        MinhaThreadRunnable threadRunnable3 = new MinhaThreadRunnable("Thread #3", 350);

    }
}

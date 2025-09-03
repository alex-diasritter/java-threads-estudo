package com.alex.aula1;

public class MinhaThread extends Thread {

    private String nomeThread;
    private int tempo;

    public MinhaThread(String nomeThread, int tempo) {
        this.nomeThread = nomeThread;
        this.tempo = tempo;
        start();

    }

    public void run() {
        try {
        for (int i = 0; i < 6; i++) {
            System.out.println(nomeThread + " contador: " + i);
            Thread.sleep(tempo);
        }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.alex.aula2;

/*
Implementando a interface temos a vantagem de poder extender outra classe e não somente Thread.
*/
public class MinhaThreadRunnable implements Runnable {

    private String nome;
    private int tempo;

    public MinhaThreadRunnable(String nome, int tempo) {
        this.nome = nome;
        this.tempo = tempo;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println(nome + " contador: " + i);
            try {
                Thread.sleep(tempo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(nome + " terminou a execução.");
    }
}

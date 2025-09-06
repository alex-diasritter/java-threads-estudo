package com.alex.aula3;

public class Main {
    public static void main(String[] args) {

        TiqueTaqueRunnable jogo = new TiqueTaqueRunnable();

        Thread tiqueThread = new Thread(new TiqueTaqueRunnable.TiqueTask(jogo), "Tique-Thread");
        Thread taqueThread = new Thread(new TiqueTaqueRunnable.TaqueTask(jogo), "Taque-Thread");

        tiqueThread.start();
        taqueThread.start();

        // Thread main espera terminar
        try {
            tiqueThread.join();
            taqueThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("✅ Fim do jogo Tique-Taque!");
    }
}

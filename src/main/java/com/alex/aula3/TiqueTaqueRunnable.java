package com.alex.aula3;

public class TiqueTaqueRunnable {

        private boolean vezDeTique = true;
        private final Object lock = new Object();

        public void tique() {
            synchronized (lock) {
                while (!vezDeTique) {
                    try {
                        lock.wait(); // Espera até ser sua vez
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.print("Tique");
                vezDeTique = false; // Passa a vez
                lock.notify();      // Acorda a thread "Taque"
            }
        }

        public void taque() {
            synchronized (lock) {
                while (vezDeTique) {
                    try {
                        lock.wait(); // Espera até ser sua vez
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.println(" Taque");
                vezDeTique = true;  // Passa a vez
                lock.notify();      // Acorda a thread "Tique"
            }
        }

        static class TiqueTask implements Runnable {
            private final TiqueTaqueRunnable jogo;

            public TiqueTask(TiqueTaqueRunnable jogo) {
                this.jogo = jogo;
            }

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    jogo.tique();
                    try {
                        Thread.sleep(300); // Pequena pausa para visualização
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        }

        static class TaqueTask implements Runnable {
            private final TiqueTaqueRunnable jogo;

            public TaqueTask(TiqueTaqueRunnable jogo) {
                this.jogo = jogo;
            }

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    jogo.taque();
                    try {
                        Thread.sleep(300); // Pequena pausa para visualização
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        }
    }

package com.alex.executores;

import java.util.Random;
import java.util.concurrent.*;

public class Aula1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //executor.execute(new Tarefa());

        Future<String> future = executor.submit(new Tarefa());

        System.out.println(future.get());

        // colocar em um finnaly
        executor.shutdown(); //importante, caso contrário a thread continua executando
    }

    // a diferença pra Runnable é que Callable retorna um valor
    public static class Tarefa implements Callable<String> {
        @Override
        public String call() throws Exception {
            var name = Thread.currentThread();
            var nextInt = new Random().nextInt(1000);
            return name + " thread callable " + nextInt;
        }

        /*
        @Override
        public void run() {
            System.out.println(Thread.currentThread() + "Executor thread");
        }
         */
    }
}

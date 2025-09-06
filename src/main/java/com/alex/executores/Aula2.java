package com.alex.executores;

import java.util.Random;
import java.util.concurrent.*;

public class Aula2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //pool predefinido de N threads
        //ExecutorService executorService = Executors.newFixedThreadPool(4);
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<String> submit = executorService.submit(new Tarefa());
        Future<String> submit2 = executorService.submit(new Tarefa());
        Future<String> submit3 = executorService.submit(new Tarefa());
        Future<String> submit4 = executorService.submit(new Tarefa());

        System.out.println(submit.get());
        System.out.println(submit2.get());
        System.out.println(submit3.get());
        System.out.println(submit4.get());

    }

    public static class Tarefa implements Callable<String> {
        @Override
        public String call() throws Exception {
            var name = Thread.currentThread();
            var nextInt = new Random().nextInt(1000);
            return name + " thread callable " + nextInt;
        }
    }
}

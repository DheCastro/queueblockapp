package com.dextra.queueblockapp;

import java.util.concurrent.BlockingQueue;

public class NumbersConsumer  implements Runnable {
    private final BlockingQueue<Integer> queue;
    private final Integer stopThread;

    NumbersConsumer(BlockingQueue<Integer> queue, Integer stopThread) {
        this.queue = queue;
        this.stopThread = stopThread;
    }

    public void run() {
        try {
            while (true) {
            	
            	Integer result = queue.take();
                if (result.equals(stopThread)) {
                    return;
                }
              
                System.out.println("QUEUE SIZE ::::::::::::::::::::::::::::::: " + queue.size());
                System.out.println(Thread.currentThread().getName() + " result: " + result);
 
                /**for(int x = 0; x < 5; x++) {
                	System.out.println("PROCESSING :::::::::::::::::::::::::::::::");
                }*/
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
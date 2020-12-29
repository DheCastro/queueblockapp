package br.com.dhecastro.queueblockapp;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SimulationBlockQueue {
	public static void main(String[] args) {
	        
		//Config Queue Variables 
		int queue_max_size = 10;
        int producers_number = 1;
        int consumers_number = 1;
        int stop_thread = Integer.MAX_VALUE;
        int stop_thread_per_producer = consumers_number / producers_number;
        
        //Create queue
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(queue_max_size);

        //Create producers
        for (int i = 0; i < producers_number; i++) {
            new Thread(new Producer(queue, stop_thread, stop_thread_per_producer)).start();
        }

        //Create consumers
        for (int j = 0; j < consumers_number; j++) {
            new Thread(new Consumer(queue, stop_thread)).start();
        }
	}
}

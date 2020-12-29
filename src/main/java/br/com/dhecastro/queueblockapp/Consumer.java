package br.com.dhecastro.queueblockapp;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private final BlockingQueue<Integer> queue;
	private final Integer stopThread;

	Consumer(BlockingQueue<Integer> queue, Integer stopThread) {
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

				//uncomment to see the queue being consumed and returning to maximum at the predetermined size
				/** System.out.println("QUEUE SIZE ::::::::::::::::::::::::::::::: " + queue.size()); */
				
				System.out.println(Thread.currentThread().getName() + " result: " + result);

				//uncomment to see how the thread waits for processing to finish, before starting the next one in the queue
				/** for(int x = 0; x < 5; x++) { System.out.println("PROCESSING :::::::::::::::::::::::::::::::"); } */
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
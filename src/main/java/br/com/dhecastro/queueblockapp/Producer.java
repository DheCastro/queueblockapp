package br.com.dhecastro.queueblockapp;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {

	private final BlockingQueue<Integer> numbersQueue;
	private final Integer stopThread;
	private final int stopThreadPerProducer;

	Producer(BlockingQueue<Integer> numbersQueue, Integer stopThread, int stopThreadPerProducer) {
		this.numbersQueue = numbersQueue;
		this.stopThread = stopThread;
		this.stopThreadPerProducer = stopThreadPerProducer;
	}

	public void run() {
		try {
			generateNumbers();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	private void generateNumbers() throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			numbersQueue.put(ThreadLocalRandom.current().nextInt(100));
		}
		for (int j = 0; j < stopThreadPerProducer; j++) {
			numbersQueue.put(stopThread);
		}
	}
}
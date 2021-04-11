package br.com.treinaweb.javacollections;

import java.util.PriorityQueue;
import java.util.Queue;

import br.com.treinaweb.javacollections.models.Pessoa;

public class MainQueue {

	public static void main(String[] args) {
		Queue<Pessoa> queue = new PriorityQueue<Pessoa>((p1, p2) -> {
			return p1.getNome().compareTo(p2.getNome());
		});
//		Queue<Pessoa> queue = new PriorityQueue<Pessoa>();
		queue.add(new Pessoa(3, "TreinaWeb 3"));
		queue.add(new Pessoa(1, "TreinaWeb 1"));
		queue.add(new Pessoa(2, "TreinaWeb 2"));
		queue.offer(new Pessoa(4, "TreinaWeb 4"));
		System.out.println(queue);
		while (!queue.isEmpty()) {
			Pessoa p = queue.poll();
//			Pessoa p = queue.peek();
			System.out.println(p);
		}
//		for (Pessoa p : queue) {
//			System.out.println(p);
//		}
		
	}

}

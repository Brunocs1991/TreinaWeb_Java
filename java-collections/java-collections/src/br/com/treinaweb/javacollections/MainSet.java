package br.com.treinaweb.javacollections;

import java.util.NavigableSet;
import java.util.TreeSet;

import br.com.treinaweb.javacollections.models.Pessoa;

public class MainSet {

	public static void main(String[] args) {
//		Set<Integer> set = new HashSet<Integer>();
//		set.add(1);
//		set.add(2);
//		set.add(3);
//		System.out.println(set);
//		set.add(3);
//		System.out.println(set);
//		Set<Pessoa> set = new HashSet<Pessoa>();
//		Set<Pessoa> set = new LinkedHashSet<Pessoa>();
//		Set<Pessoa> set = new TreeSet<Pessoa>((p1, p2) -> {
//			return p1.getNome().compareTo(p2.getNome());
//		});
//		Set<Pessoa> set = new TreeSet<Pessoa>();
		NavigableSet<Pessoa> set = new TreeSet<Pessoa>();
		set.add(new Pessoa(2, "TreinaWeb 2"));
		set.add(new Pessoa(3, "TreinaWeb 3"));
		set.add(new Pessoa(1, "TreinaWeb 1"));
		Pessoa teste = set.ceiling(new Pessoa(2, "TreinaWeb 2"));
		System.out.println(teste);
//		set.add(null);
//		System.out.println(set);
////		set.add(new Pessoa(2, "TreinaWeb 2"));
//		for (Pessoa p : set) {
//			System.out.println(p);
//		}

	}

}

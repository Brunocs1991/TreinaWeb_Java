package br.com.treinaweb.javacollections;

import java.util.Set;
import java.util.TreeSet;

import br.com.treinaweb.javacollections.models.Pessoa;

public class MainSet2 {

	public static void main(String[] args) {
//		HashSet<Pessoa> pessoas = new HashSet<Pessoa>();
//		Set<Pessoa> pessoas = new LinkedHashSet<Pessoa>();
		Set<Pessoa> pessoas = new TreeSet<Pessoa>();
		System.out.println(pessoas.add(new Pessoa(1, "TreinaWeb 1")));
		System.out.println(pessoas);
		System.out.println(pessoas.add(new Pessoa(1, "TreinaWeb 1")));
		pessoas.add(new Pessoa(2, "TreinaWeb 2"));
		pessoas.add(new Pessoa(3, "TreinaWeb 3"));
		pessoas.add(new Pessoa(4, "TreinaWeb 4"));
		pessoas.add(new Pessoa(5, "TreinaWeb 5"));
		pessoas.add(new Pessoa(6, "TreinaWeb 6"));
		pessoas.add(new Pessoa(7, "TreinaWeb 7"));
		pessoas.add(new Pessoa(8, "TreinaWeb 8"));
		pessoas.add(new Pessoa(9, "TreinaWeb 9"));
		pessoas.add(new Pessoa(10, "TreinaWeb 10"));
		pessoas.add(new Pessoa(11, "TreinaWeb 11"));
		pessoas.add(new Pessoa(12, "TreinaWeb 12"));
		pessoas.add(new Pessoa(13, "TreinaWeb 13"));
		pessoas.add(new Pessoa(14, "TreinaWeb 14"));
		pessoas.add(new Pessoa(15, "TreinaWeb 15"));
		pessoas.add(new Pessoa(16, "TreinaWeb 16"));
		pessoas.add(new Pessoa(17, "TreinaWeb 17"));

		System.out.println(pessoas);
		for (Pessoa p : pessoas) {
			System.out.println(p);
		}

	}

}

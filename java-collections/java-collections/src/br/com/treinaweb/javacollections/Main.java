package br.com.treinaweb.javacollections;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import br.com.treinaweb.javacollections.models.Pessoa;

public class Main {

	public static void main(String[] args) {

//		/**
//		 * subindo no nivel de abstração de arraylist para list conforme arraylist
//		 * extendes list que extendes de collections tanto que as implementações. abaixo
//		 * funcionam sem erros
//		 * ///////////////////////////////////////////////////////////////////////////
//		 * ****** ArrayList<Pessoa> pessoas= new ArrayList<Pessoa>(); ***************
//		 * ****** Collection<Pessoa> pessoas = new ArrayList<Pessoa>(); *************
//		 * //////////////////////////////////////////////////////////////////////////
//		 * 
//		 */

		List<Pessoa> pessoas = new LinkedList<Pessoa>();
		pessoas.add(new Pessoa(3, "Treina Web 3,,"));
		pessoas.add(new Pessoa(1, "Treina Web 1,"));
		pessoas.add(new Pessoa(2, "Treina Web 2"));
		System.out.println("============================================");
		System.out.println("* Antes da Ordenação: *");
		System.out.println(pessoas.toString());
		System.out.println("============================================");
		System.out.println("* Depois da Ordenação: *");
//		Collections.sort(pessoas, new PessoaTamanhoNomeComparator());
//		Collections.sort(pessoas, (Comparator<Pessoa>) (o1, o2) -> {
//			if (o1.getNome().length() == o2.getNome().length()) {
//				return 0;
//			} else if (o1.getNome().length() < o2.getNome().length()) {
//				return -1;
//			}
//			return 1;
//		});
//		pessoas.sort((o1, o2) -> {
//			if (o1.getNome().length() == o2.getNome().length()) {
//				return 0;
//			} else if (o1.getNome().length() < o2.getNome().length()) {
//				return -1;
//			}
//			return 1;
//		});
//		pessoas.sort(Comparator.comparingInt(Pessoa::getId));
//		pessoas.sort(Comparator.comparing(Pessoa::getNome, (n1, n2) -> {
//			if (n1.length() == n2.length()) {
//				return 0;
//			} else if (n1.length() < n2.length()) {
//				return -1;
//			}
//			return 1;
//		}));
//		pessoas.sort(Comparator.naturalOrder());
		pessoas.sort(Comparator.reverseOrder());
//		Collections.sort(pessoas);
		System.out.println(pessoas.toString());

//		pessoas.remove(pessoas.get(0));
//		pessoas.remove(new Pessoa(1, "Treina Web 1"));
//		System.out.println(pessoas.contains(new Pessoa(2, "Treina Web 2")));

//		System.out.println("============================================");
//		System.out.println("*COM FOR*");
//		for (int i = 0; i < pessoas.size(); i++) {
//			Pessoa p = pessoas.get(i);
//			System.out.println(p);
//		}
//		System.out.println("============================================");
//		System.out.println("*COM ITERATOR*");
//		Iterator<Pessoa> iteratorPessoa = pessoas.iterator();
////		ListIterator<Pessoa> iteratorPessoa = pessoas.listIterator();
//		while (iteratorPessoa.hasNext()) {
//			Pessoa p = iteratorPessoa.next();
//			if (p.getId() == 1) {
//				iteratorPessoa.remove();
//			}
//			System.out.println(p);
//		}
//		pessoas.removeIf(p -> p.getId() == 1);
//		System.out.println(pessoas.toString());
//		System.out.println("============================================");
//		System.out.println("*COM FOREACH*");
//		for (Pessoa p : pessoas) {
//			System.out.println(p);
//		}
		System.out.println("============================================");
		System.out.println("*FIM!*");
	}

}

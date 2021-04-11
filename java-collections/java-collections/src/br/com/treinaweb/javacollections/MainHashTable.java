package br.com.treinaweb.javacollections;

import java.util.Enumeration;
import java.util.Hashtable;

import br.com.treinaweb.javacollections.models.Pessoa;

public class MainHashTable {

	public static void main(String[] args) {
		Hashtable<String, Pessoa> tabelaPessoas = new Hashtable<String, Pessoa>(20, 0.6f);
		tabelaPessoas.put("legal", new Pessoa(1, "TreinaWeb 1"));
		System.out.println(tabelaPessoas);
		tabelaPessoas.put("chato", new Pessoa(2, "TreinaWeb 2"));
		System.out.println(tabelaPessoas);
		System.out.println(tabelaPessoas.get("legal"));
		System.out.println(tabelaPessoas.put("legal", new Pessoa(3, "TreinaWeb 3")));
		System.out.println(tabelaPessoas.get("legal"));
		System.out.println(tabelaPessoas.put("bla", new Pessoa(4, "TreinaWeb 4")));
//		// Iterator
		// fail-fast iterator
//		Iterator<String> iteratorChaves = tabelaPessoas.keySet().iterator();
//		tabelaPessoas.remove("legal");
//		while (iteratorChaves.hasNext()) {
//			String chave = iteratorChaves.next();
//			System.out.println("-" + tabelaPessoas.get(chave).toString());
//		}
		// no fail-fast iterator
		Enumeration<String> chaves = tabelaPessoas.keys();
		tabelaPessoas.remove("legal");
		while (chaves.hasMoreElements()) {
			String chave = chaves.nextElement();
			System.out.println("-" + tabelaPessoas.get(chave).toString());
		}
//		Pessoa p = null;
//		if (tabelaPessoas.containsKey("legal")) {
//			p = tabelaPessoas.get("legal");
//		} else {
//			p = new Pessoa(-1, "Não Existe");
//		}
//		System.out.println(p);
		Pessoa p = tabelaPessoas.getOrDefault("legal", new Pessoa(-1, "Não Existe"));
		System.out.println(p);

//		if (!tabelaPessoas.containsKey("legal")) {
//			tabelaPessoas.put("legal", new Pessoa(1, "TreinaWeb 1"));
//		}
		tabelaPessoas.putIfAbsent("legal", new Pessoa(1, "TreinaWeb 1"));
		System.out.println(tabelaPessoas);
		tabelaPessoas.forEach((chave,valor) ->{
			System.out.println(String.format("[%s]%s", chave,valor.toString()));
		});
	}

}

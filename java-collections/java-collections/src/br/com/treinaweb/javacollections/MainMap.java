package br.com.treinaweb.javacollections;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import br.com.treinaweb.javacollections.models.Pessoa;

public class MainMap {

	public static void main(String[] args) {
//		Map<String, Pessoa> mapaPessoas = new HashMap<String, Pessoa>();
//		Map<String, Pessoa> mapaPessoas = new LinkedHashMap<String, Pessoa>(16, 0.75f, true);
		Map<String, Pessoa> mapaPessoas = new TreeMap<String, Pessoa>(Comparator.reverseOrder());
		System.out.println(mapaPessoas.put("legal", new Pessoa(1, "TreinaWeb 1")));
		System.out.println(mapaPessoas);
		mapaPessoas.put("legal", new Pessoa(2, "TreinaWeb 2"));
		System.out.println(mapaPessoas);
//		mapaPessoas.put(null, new Pessoa(-1, "NULO"));
//		System.out.println(mapaPessoas);
//		mapaPessoas.put(null, new Pessoa(-2, "NULO 2"));
//		System.out.println(mapaPessoas);
		mapaPessoas.put("teste", null);
		System.out.println(mapaPessoas);
		Pessoa p = mapaPessoas.get("legal");
		System.out.println(p);
		System.out.println(mapaPessoas);
		mapaPessoas.put("a", new Pessoa(100, "TreinaWeb 100"));
		System.out.println(mapaPessoas);

	}

}

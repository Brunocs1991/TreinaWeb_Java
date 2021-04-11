package br.com.treinaweb.javacollections.models;

public class Pessoa implements Comparable<Pessoa> {
	private int id;

	public Pessoa(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	private String nome;

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public int compareTo(Pessoa o) {

//		0 = os objetos são considerados "iguais".
		if (this.getId() == o.getId()) {
			return 0;
		}
//		<0 : a instância é considerada "menor" do que o argumento.
		if (this.getId() < o.getId()) {
			return -1;
		}
//		< 0 : a instância é considerada "maior" do que o argumento.
		return 1;
	}

}

package br.com.treinaweb.struts2.controllers;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import br.com.treinaweb.struts2.entidades.Pessoa;
import br.com.treinaweb.struts2.servicos.PessoaService;

public class PessoaController extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6910136550216389876L;
	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	private List<Pessoa> pessoasPorNome;
	private String mensagemErro;

	public String inserirPessoa() {
		return "OK";
	}

	public String listar() {
		try {
			PessoaService ps = new PessoaService();
			this.pessoas = ps.todas();
			return SUCCESS;

		} catch (Exception e) {
			this.mensagemErro = e.getMessage();
			return ERROR;
		}
	}

	public String mostrar() {
		try {
			PessoaService ps = new PessoaService();
			int id = Integer.parseInt(ActionContext.getContext().getParameters().get("id").getValue());
			this.pessoa = ps.porId(id);
			return SUCCESS;
		} catch (Exception e) {
			this.mensagemErro = e.getMessage();
			return ERROR;
		}

	}

	public String inserir() {
		try {
			PessoaService ps = new PessoaService();
			ps.inserir(this.pessoa);
			return SUCCESS;
		} catch (Exception e) {
			this.mensagemErro = e.getMessage();
			return ERROR;
		}
	}

	public String pesquisarPorNome() {
		PessoaService ps = new PessoaService();
		String nome = ActionContext.getContext().getParameters().get("nome").getValue();
		this.pessoasPorNome = ps.pesquisaPorNome(nome);
		return SUCCESS;
	}

	@Override
	public void validate() {
		if (this.pessoa != null) {
			if (this.pessoa.getNome() == "") {
				addFieldError("pessoa.nome", "O nome � obrigat�rio");
			}
			if (this.pessoa.getNome().length() <= 3) {
				addFieldError("pessoa.nome", "O nome deve conter no m�nimo 3 caracter");
			}
			if (this.pessoa.getIdade() == null) {
				addFieldError("pessoa.idade", "A idade deve ser  um n�mero v�lido.");
			}
		}
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public List<Pessoa> getPessoasPorNome() {
		return pessoasPorNome;
	}

}

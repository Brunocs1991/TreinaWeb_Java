package br.com.treinaweb.agenda.servicos.interfaces;

import java.io.IOException;
import java.util.List;

import br.com.treinaweb.agenda.entidades.Contato;

public interface ServicoExportadorContato {
	void exportar(List<Contato> contatos, String nomeArquivo) throws IOException;
}

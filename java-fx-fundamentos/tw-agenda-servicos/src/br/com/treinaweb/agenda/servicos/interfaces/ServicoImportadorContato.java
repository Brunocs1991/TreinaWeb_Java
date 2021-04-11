package br.com.treinaweb.agenda.servicos.interfaces;

import java.io.IOException;
import java.sql.SQLException;

import br.com.treinaweb.agenda.entidades.Contato;
import br.com.treinaweb.agenda.repositorios.interfaces.AgendaRepositorio;

public interface ServicoImportadorContato {
	void importar(String nomeArquivo, AgendaRepositorio<Contato> agendaRepositorio) throws IOException, SQLException;

}

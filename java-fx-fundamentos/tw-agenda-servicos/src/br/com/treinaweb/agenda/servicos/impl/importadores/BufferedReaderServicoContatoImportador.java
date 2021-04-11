package br.com.treinaweb.agenda.servicos.impl.importadores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import br.com.treinaweb.agenda.entidades.Contato;
import br.com.treinaweb.agenda.repositorios.interfaces.AgendaRepositorio;
import br.com.treinaweb.agenda.servicos.interfaces.ServicoImportadorContato;

public class BufferedReaderServicoContatoImportador implements ServicoImportadorContato {

	@Override
	public void importar(String nomeArquivo, AgendaRepositorio<Contato> agendaRepositorio)
			throws IOException, SQLException {
		try (FileReader fileReader = new FileReader(nomeArquivo)) {
			try (BufferedReader reader = new BufferedReader(fileReader)) {
//				String dado = "";
//				while ((dado = reader.readLine()) != null) {
				while (reader.read() != -1) {
					String dado = reader.readLine();
					String[] informacoes = dado.split(";");
					Contato contato = new Contato();
					contato.setNome(informacoes[1]);
					contato.setIdade(Integer.parseInt(informacoes[2]));
					contato.setTelefone(informacoes[3]);
					agendaRepositorio.inserir(contato);
				}
			}
		}
	}

}

package br.com.treinaweb.agenda.servicos.impl.exportadores;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import br.com.treinaweb.agenda.entidades.Contato;
import br.com.treinaweb.agenda.servicos.interfaces.ServicoExportadorContato;

public class PrintWriterServicoContato implements ServicoExportadorContato {

	@Override
	public void exportar(List<Contato> contatos, String nomeArquivo) throws IOException {
		try (FileWriter fileWriter = new FileWriter(nomeArquivo)) {
			try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
				for (Contato contato : contatos) {
					printWriter.println(String.format("%d;%s;%d;%s", contato.getId(), contato.getNome(),
							contato.getIdade(), contato.getTelefone()));
//					printWriter.printf("%d,%s,%d,%s,", contato.getId(), contato.getNome(), contato.getIdade(),
//							contato.getTelefone());
					
				}
			}
		}

	}

}

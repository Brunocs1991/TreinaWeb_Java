package br.com.treinaweb.agenda.servicos.impl.exportadores;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import br.com.treinaweb.agenda.entidades.Contato;
import br.com.treinaweb.agenda.servicos.interfaces.ServicoExportadorContato;

public class BufferedWriterServicoContato implements ServicoExportadorContato {

	@Override
	public void exportar(List<Contato> contatos, String nomeArquivo) throws IOException {
		FileWriter fileWriter = new FileWriter(nomeArquivo);
		try (BufferedWriter writer = new BufferedWriter(fileWriter)) {
			List<String> dadosParaExportar = contatos.stream().map(Contato -> String.format("%d;%s;%d;%s",
					Contato.getId(), Contato.getNome(), Contato.getId(), Contato.getTelefone()))
					.collect(Collectors.toList());
			for (String linha : dadosParaExportar) {
				writer.write(linha);
				writer.newLine();
			}
			writer.flush();
		}
	}
}

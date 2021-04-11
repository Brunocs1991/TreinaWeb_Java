package br.com.treinaweb.agenda.servicos.impl.exportadores;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import br.com.treinaweb.agenda.entidades.Contato;
import br.com.treinaweb.agenda.servicos.interfaces.ServicoExportadorContato;

public class FileOutputStreamServicoContato implements ServicoExportadorContato {

	@Override
	public void exportar(List<Contato> contatos, String nomeArquivo) throws IOException {
		try (FileOutputStream fileStream = new FileOutputStream(nomeArquivo)) {
			fileStream.getChannel().tryLock();
			List<String> dados = contatos.stream().map(contato -> String.format("%d;%s;%d;%s\n", contato.getId(),
					contato.getNome(), contato.getIdade(), contato.getTelefone())).collect(Collectors.toList());
			for (String dado : dados) {
				fileStream.write(dado.getBytes());
			}
		}

	}

}

package br.com.treinaweb.agenda.servicos.impl.exportadores;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import br.com.treinaweb.agenda.entidades.Contato;
import br.com.treinaweb.agenda.servicos.interfaces.ServicoExportadorContato;

public class DataOutputStreamServicoContato implements ServicoExportadorContato {

	@Override
	public void exportar(List<Contato> contatos, String nomeArquivo) throws IOException {
		try (FileOutputStream fileOutputStream = new FileOutputStream(nomeArquivo)) {
			try (DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)) {
				List<String> dados = contatos.stream().map(contato -> String.format("%d;%s;%d;%s\n", contato.getId(),
						contato.getNome(), contato.getIdade(), contato.getTelefone())).collect(Collectors.toList());
				for (String dado : dados) {
					dataOutputStream.writeUTF(dado);
					System.out.println(dataOutputStream.size());
				}
			}
		}
	}

}

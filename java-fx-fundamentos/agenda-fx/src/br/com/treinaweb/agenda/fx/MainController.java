package br.com.treinaweb.agenda.fx;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import br.com.treinaweb.agenda.entidades.Contato;
import br.com.treinaweb.agenda.repositorios.impl.ContatoRepositorioJdbc;
import br.com.treinaweb.agenda.repositorios.interfaces.AgendaRepositorio;
import br.com.treinaweb.agenda.servicos.impl.exportadores.Java7ServicoContato;
import br.com.treinaweb.agenda.servicos.impl.importadores.Java7ServicoContatoImportador;
import br.com.treinaweb.agenda.servicos.interfaces.ServicoExportadorContato;
import br.com.treinaweb.agenda.servicos.interfaces.ServicoImportadorContato;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainController implements Initializable {
	@FXML
	private TableView<Contato> tabelaContatos;
	@FXML
	private Button botaoInserir;
	@FXML
	private Button botaoAlterar;
	@FXML
	private Button botaoExcluir;
	@FXML
	private TextField txfNome;
	@FXML
	private TextField txfIdade;
	@FXML
	private TextField txfTelefone;
	@FXML
	private Button botaoSalvar;
	@FXML
	private Button botaoCancelar;
	private boolean ehInserir;
	private Contato contatoSelecionado;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.tabelaContatos.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		habilitarEdicaoAgenda(false);
//		this.tabelaContatos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Contato>() {
//			@Override
//			public void changed(ObservableValue<? extends Contato> observable, Contato oldValue, Contato newValue) {
//				if (newValue != null) {
//					txfNome.setText(newValue.getNome());
//					txfIdade.setText(String.valueOf(newValue.getIdade()));
//					txfTelefone.setText(newValue.getTelefone());
//				}
//			}
//		});
		this.tabelaContatos.getSelectionModel().selectedItemProperty()
				.addListener((observador, contatoAntigo, contatoNovo) -> {
					if (contatoNovo != null) {
						txfNome.setText(contatoNovo.getNome());
						txfIdade.setText(String.valueOf(contatoNovo.getIdade()));
						txfTelefone.setText(contatoNovo.getTelefone());
						this.contatoSelecionado = contatoNovo;
					}
				});
		carregarTabelaContatos();
	}

	public void botaoInserir_Action() {
		this.ehInserir = true;
		this.txfNome.setText("");
		this.txfIdade.setText("");
		this.txfTelefone.setText("");
		habilitarEdicaoAgenda(true);

	}

	public void botaoAlterar_Action() {
		habilitarEdicaoAgenda(true);
		this.ehInserir = false;
		this.txfNome.setText(this.contatoSelecionado.getNome());
		this.txfIdade.setText(Integer.toString(this.contatoSelecionado.getIdade()));
		this.txfTelefone.setText(this.contatoSelecionado.getTelefone());
	}

	public void botaoExcluir_Action() throws IOException, SQLException {
		Alert confirmacao = new Alert(AlertType.CONFIRMATION);
		confirmacao.setTitle("Confirmaçao");
		confirmacao.setHeaderText("Confirmação da exclusão do contato");
		confirmacao.setContentText("Tem certeza que deseja excluir este contato?");
		Optional<ButtonType> resultadoConfirmacao = confirmacao.showAndWait();
		if (resultadoConfirmacao.isPresent() && resultadoConfirmacao.get() == ButtonType.OK) {
			AgendaRepositorio<Contato> repositorioContato = new ContatoRepositorioJdbc();
			repositorioContato.excluir(this.contatoSelecionado);
			carregarTabelaContatos();
			this.tabelaContatos.getSelectionModel().selectFirst();
		}

	}

	public void botaoCancelar_Action() {
		habilitarEdicaoAgenda(false);
		this.tabelaContatos.getSelectionModel().selectFirst();
	}

	public void botaoSalvar_Action() {
		try {
			AgendaRepositorio<Contato> repositorioContato = new ContatoRepositorioJdbc();
			Contato contato = new Contato();
			contato.setNome(txfNome.getText());
			contato.setIdade(Integer.parseInt(txfIdade.getText()));
			contato.setTelefone(txfTelefone.getText());
			if (this.ehInserir) {
				repositorioContato.inserir(contato);
			} else {
				repositorioContato.atualizar(contato);
			}
			habilitarEdicaoAgenda(false);
			carregarTabelaContatos();
			this.tabelaContatos.getSelectionModel().selectFirst();
		} catch (Exception e) {
			Alert mensagem = new Alert(AlertType.ERROR);
			mensagem.setTitle("Erro!");
			mensagem.setHeaderText("Erro no banco dedados");
			mensagem.setContentText("Houve um erro ao manipular  o contato: " + e.getMessage());
			mensagem.showAndWait();
		}
	}

	private void carregarTabelaContatos() {
		try {
			AgendaRepositorio<Contato> repositorioContato = new ContatoRepositorioJdbc();
			List<Contato> contatos = repositorioContato.selecionar();
//			if (contatos.isEmpty()) {
//				Contato contato = new Contato();
//				contato.setNome("TreinaWeb");
//				contato.setIdade(12);
//				contato.setTelefone("123456");
//				contatos.add(contato);
//			}
			ObservableList<Contato> contatosObservableList = FXCollections.observableList(contatos);
			this.tabelaContatos.getItems().setAll(contatosObservableList);
		} catch (Exception e) {
			Alert mensagem = new Alert(AlertType.ERROR);
			mensagem.setTitle("Erro!");
			mensagem.setHeaderText("Erro no banco dedados");
			mensagem.setContentText("Houve um erro ao obter a lista de contatos: " + e.getMessage());
			mensagem.showAndWait();

		}
	}

	private void habilitarEdicaoAgenda(Boolean edicaoEstaHabilidata) {
		this.txfNome.setDisable(!edicaoEstaHabilidata);
		this.txfIdade.setDisable(!edicaoEstaHabilidata);
		this.txfTelefone.setDisable(!edicaoEstaHabilidata);
		this.botaoSalvar.setDisable(!edicaoEstaHabilidata);
		this.botaoCancelar.setDisable(!edicaoEstaHabilidata);
		this.botaoInserir.setDisable(edicaoEstaHabilidata);
		this.botaoAlterar.setDisable(edicaoEstaHabilidata);
		this.botaoExcluir.setDisable(edicaoEstaHabilidata);
		this.tabelaContatos.setDisable(edicaoEstaHabilidata);

	}

	public void btnExportarContatos_Action() {
		AgendaRepositorio<Contato> repositorioContato = new ContatoRepositorioJdbc();
		try {
			List<Contato> contatos = repositorioContato.selecionar();
			ServicoExportadorContato servicoContato = new Java7ServicoContato();
			servicoContato.exportar(contatos, "C://manual/agenda.csv");
			Alert mensagemSucesso = new Alert(AlertType.INFORMATION);
			mensagemSucesso.setTitle("Sucesso!");
			mensagemSucesso.setHeaderText("Sucesso na exportação");
			mensagemSucesso.setContentText("A exportação foi concluida com êxito");
			mensagemSucesso.showAndWait();

		} catch (Exception e) {
			Alert mensagem = new Alert(AlertType.ERROR);
			mensagem.setTitle("Erro!");
			mensagem.setHeaderText("Erro ao acessar recursos externos ou ao criar a conexão com o banco.");
			mensagem.setContentText("Houve um erro ao obter a lista de contatos: " + e.getMessage());
			mensagem.showAndWait();

		}
	}

	public void btnImportarContatos_Action() {
		AgendaRepositorio<Contato> repositorioContato = new ContatoRepositorioJdbc();
		try {
			ServicoImportadorContato importador = new Java7ServicoContatoImportador();
			importador.importar("C://manual/agenda.csv", repositorioContato);
			Alert mensagemSucesso = new Alert(AlertType.INFORMATION);
			mensagemSucesso.setTitle("Sucesso!");
			mensagemSucesso.setHeaderText("Sucesso na importação");
			mensagemSucesso.setContentText("A importação foi concluida com êxito");
			mensagemSucesso.showAndWait();
			carregarTabelaContatos();
		} catch (Exception e) {
			Alert mensagem = new Alert(AlertType.ERROR);
			mensagem.setTitle("Erro!");
			mensagem.setHeaderText("Erro ao acessar recursos externos ou ao criar a conexão com o banco.");
			mensagem.setContentText("Houve um erro ao obter a lista de contatos: " + e.getMessage());
			mensagem.showAndWait();

		}
	}

}

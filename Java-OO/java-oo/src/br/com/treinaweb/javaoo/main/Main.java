package br.com.treinaweb.javaoo.main;

import br.com.treinaweb.javaoo.classes.Carro;
import br.com.treinaweb.javaoo.classes.Moto;
import br.com.treinaweb.javaoo.classes.VeiculoBase;
import br.com.treinaweb.javaoo.excecoes.AbastecimentoVeiculoLigadoException;
import br.com.treinaweb.javaoo.excecoes.ChassiInvalidoException;

public class Main {

	public static void main(String[] args) {
		try {
			VeiculoBase corsa = new Carro("Corsa", "GM");
			corsa.setChassi("ABCDE");
			corsa.abastecer(10);
			((Carro) corsa).setQuantidadedePortas(4);
			System.out.println(corsa.getNome());
			System.out.println(corsa.getChassi());
			System.out.println(corsa.getQuantidadeRodas());
			System.out.println(String.format("O veículo %s esta ligado? %b", corsa.getNome(), corsa.isLigado()));
			System.out.println(corsa.getQuantidadeCombustivel());
			corsa.preparar();
			corsa.abastecer(10);
			corsa.preparar();
			corsa.ligar();
			corsa.acelerar();
			System.out.println(String.format("A velocidade atual do veículo e: %f", corsa.getVelocidade()));
			corsa.frear();
			System.out.println(String.format("A velocidade atual do veículo e: %f", corsa.getVelocidade()));
			VeiculoBase biz = new Moto("biz", "yamaha");
			biz.abastecer(10);
			biz.ligar();
			biz.acelerar();
			biz.acelerar();
			System.out.println(String.format("A velocidade atual do veículo e: %f", biz.getVelocidade()));
		} catch (AbastecimentoVeiculoLigadoException e) {
			System.out.println("Você não pode abastecer um veiculo enquanto ele estiver ligado");
		} catch (ChassiInvalidoException e) {
			System.out.println("O chassi e invalido. " + e.getMessage());
		} catch (Exception e) {
			System.out.println("**Ocorreu um erro: " + e.getMessage());
		}
	}

}

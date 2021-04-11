package br.com.treinaweb.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int acao = 1; // 0 sai, 1 opera��o 2 historico
		ArrayList<String> historico = new ArrayList<String>();
		while (acao > 0) {
			if (acao == 1) {
				System.out.println("===== OPERA��O MATEMATICA ====");
				System.out.print("Digite o Primeiro Numero: ");
				int numero1=0;
				try {
					numero1 = scanner.nextInt();
				}catch(InputMismatchException e) {
					System.out.println(String.format("Ocorreu um erro no formato: %s. O primeiro n�mero assumir� o valor 1", e.getMessage()));
					scanner.nextLine();
					numero1=1;
				}
				System.out.print("Informe a opera��o: ");
				char operacao = scanner.next().charAt(0);
				int numero2=0;
				try {
					System.out.print("Digite o Segundo Numero: ");
					numero2 = scanner.nextInt();
				}catch(InputMismatchException e) {
					System.out.println(String.format("Ocorreu um erro no formato: %s. O segundo n�mero assumir� o valor 1", e.getMessage()));
					scanner.nextLine();
					numero2=1;
				}
				System.out.println(String.format("Voc� quer fazer a opera��o %d %c %d", numero1, operacao, numero2));
				int resultado = 0;
				switch (operacao) {
				case '+':
					resultado = numero1 + numero2;
					break;
				case '-':
					resultado = numero1 - numero2;
					break;
				case '*':
					resultado = numero1 * numero2;
					break;
				case '/':
					resultado = numero1 / numero2;
					break;
				default:
					System.out.println("Opera��o Invalida");
				}
				String entradaHistorico = String.format("%d%c%d=%d", numero1, operacao, numero2, resultado);
				historico.add(entradaHistorico);
				System.out.println(entradaHistorico);
			} else if (acao == 2) {
				System.out.println("===== HISTORICO ====");
				System.out.println(String.format("Voc� j� fez %d opera��es", historico.size()));
				historico.forEach(itemhistorico -> System.out.println(itemhistorico));
			}
			System.out.println("==== O QUE VOC� DESEJA FAZER? ====");
			System.out.println("1. OPERA��O MATEMATICA");
			System.out.println("2. HISTORICO");
			System.out.println("0. SAIR");
			System.out.println("SUA OP��O: ");
			acao = scanner.nextInt();
		}
		scanner.close();
	}
}

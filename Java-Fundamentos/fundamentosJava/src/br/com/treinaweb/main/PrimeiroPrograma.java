package br.com.treinaweb.main;

import java.util.Scanner;

public class PrimeiroPrograma {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite O Seu Nome: ");
		String nome = scanner.nextLine();
		System.out.println("Seja Bem Vindo: "+nome);
		scanner.close();
		System.out.println("Ola Mundo !!!!");
		System.out.print("Ola Mundo Novamente.\n");
		System.out.print("Ola mundo mais uma vez.");
	}

}

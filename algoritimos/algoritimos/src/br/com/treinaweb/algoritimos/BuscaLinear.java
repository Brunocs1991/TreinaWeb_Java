package br.com.treinaweb.algoritimos;

import java.util.Scanner;

public class BuscaLinear {
	public static void main(String[] args) {

		int[] numeros = new int[5];
		Scanner leitor = new Scanner(System.in);
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Digite um numero");
			int numero = leitor.nextInt();
			numeros[i] = numero;
		}
		// ** Busca Linear
		System.out.println("**Busca Linear**");
		System.out.println("Digite o número a ser pesquisado");
		int alvo = leitor.nextInt();
		int posicaoResultado = -1 ;
		
		for (int i= 0; i<numeros.length; i++) {
			if (numeros[i]==alvo) {
				posicaoResultado = i;
			}
		}
		if (posicaoResultado <0) {
			System.out.println("Elemento não encontrado");
		}else {
			System.out.println(String.format("O numero %d foi encontrado na posição %d.", alvo,posicaoResultado));
		}
		// ** Fim busca Linear
		System.out.println("Vetor: ");
		ImprimirArray(numeros);
		leitor.close();
	}
	private static void ImprimirArray(int [] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
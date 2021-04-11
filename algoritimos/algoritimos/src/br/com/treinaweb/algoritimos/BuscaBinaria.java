package br.com.treinaweb.algoritimos;

import java.util.Scanner;

public class BuscaBinaria {
	public static void main(String[] args) {

		int[] numeros = new int[5];
		Scanner leitor = new Scanner(System.in);
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Digite um numero");
			int numero = leitor.nextInt();
			numeros[i] = numero;
		}
		// ** Selection sort
		System.out.println("Vetor original:");
		ImprimirArray(numeros);

		for (int i = 0; i < numeros.length; i++) {
			int indiceDoMenor = i;
			for (int j = i + 1; j < numeros.length; j++) {
				if (numeros[j] < numeros[indiceDoMenor]) {
					indiceDoMenor = j;
				}
			}
			int temp = numeros[indiceDoMenor];
			numeros[indiceDoMenor] = numeros[i];
			numeros[i] = temp;
		}
		System.out.println("Vetor ordenado:");
		ImprimirArray(numeros);
		// ** Fim selection sort
		// ** Busca Binaria.
		int resultado = -1;
		int inicio = 0;
		int fim = numeros.length - 1;
		int meio = 0;
		System.out.println("Digite o elemento a ser encontrado: ");
		int alvo = leitor.nextInt();

		while (inicio <= fim) {
			meio = (inicio + fim) / 2;
			if (numeros[meio] < alvo) {
				inicio = meio + 1;
			} else if (numeros[meio] > alvo) {
				fim = meio - 1;
			} else if (numeros[meio] == alvo) {
				resultado = meio;
				break;
			}
		}
		if (resultado<0) {
			System.out.println("Elemento não encontrado");
		}else {
			System.out.println(String.format("O número %d esta na posição %d", alvo,resultado));
		}
		// ** Fim Busca Binaria.
		leitor.close();
	}

	private static void ImprimirArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}

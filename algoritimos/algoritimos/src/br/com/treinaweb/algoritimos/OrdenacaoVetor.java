package br.com.treinaweb.algoritimos;

import java.util.Scanner;

public class OrdenacaoVetor {
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
			numeros[indiceDoMenor]=numeros[i];
			numeros[i]= temp;
		}System.out.println("Vetor ordenado:");
		ImprimirArray(numeros);
		// ** Fim selection sort
		
		leitor.close();
	}

	private static void ImprimirArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}

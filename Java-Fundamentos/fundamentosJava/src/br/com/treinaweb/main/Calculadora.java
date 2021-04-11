package br.com.treinaweb.main;

import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o Primeiro Numero: ");
		int numero1 = scanner.nextInt();
		System.out.print("Informe a opera��o: ");
		char operacao = scanner.next().charAt(0);
		//System.out.print(operacao);
		System.out.print("Digite o Segundo Numero: ");
		int numero2 = scanner.nextInt();
		//interpola��o
		System.out.println(String.format("Voc� quer fazer a opera��o %d %c %d", numero1,operacao,numero2));
		int resultado = 0;
		if (operacao == '+') {
			resultado = numero1+numero2;
		}else if(operacao == '-'){
			resultado = numero1-numero2;			
		}else if(operacao == '*') {
			resultado = numero1*numero2;
		}else if (operacao == '/') {
			resultado = numero1/numero2;
		}else {
			System.out.println("Opera��o Invalida");
		}
		System.out.println(String.format("%d%c%d=%d", numero1,operacao,numero2,resultado));		
		scanner.close();
	}

}

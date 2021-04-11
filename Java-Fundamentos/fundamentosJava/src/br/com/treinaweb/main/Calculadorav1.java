package br.com.treinaweb.main;

import java.util.Scanner;

public class Calculadorav1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o Primeiro Numero: ");
		int numero1 = scanner.nextInt();
		System.out.print("Informe a operação: ");
		char operacao = scanner.next().charAt(0);
		System.out.print("Digite o Segundo Numero: ");
		int numero2 = scanner.nextInt();
		System.out.println(String.format("Você quer fazer a operação %d %c %d", numero1,operacao,numero2));
		int resultado = 0;
		switch(operacao) {
		case '+':
			resultado = numero1+numero2;
		break;
		case '-':
			resultado = numero1-numero2;
		break;
		case '*':
			resultado = numero1*numero2;
		break;
		case '/':
			resultado = numero1/numero2;
		break;
		default:
			System.out.println("Operação Invalida");
		}
		System.out.println(String.format("%d%c%d=%d", numero1,operacao,numero2,resultado));		
		scanner.close();
	}

}

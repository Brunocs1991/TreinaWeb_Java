package br.com.treinaweb.main;

import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o Primeiro Numero: ");
		int numero1 = scanner.nextInt();
		System.out.print("Informe a operação: ");
		char operacao = scanner.next().charAt(0);
		//System.out.print(operacao);
		System.out.print("Digite o Segundo Numero: ");
		int numero2 = scanner.nextInt();
		//interpolação
		System.out.println(String.format("Você quer fazer a operação %d %c %d", numero1,operacao,numero2));
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
			System.out.println("Operação Invalida");
		}
		System.out.println(String.format("%d%c%d=%d", numero1,operacao,numero2,resultado));		
		scanner.close();
	}

}

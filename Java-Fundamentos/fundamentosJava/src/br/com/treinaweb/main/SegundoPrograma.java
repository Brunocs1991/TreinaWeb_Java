package br.com.treinaweb.main;

import java.util.Scanner;

public class SegundoPrograma {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite o Primeiro Numero: ");
		//lendo como numero diretamente
		int numero1 = scanner.nextInt();
		//lendo como texto e convertendo para numero com parseint (cast)
		//int numero1 = Integer.parseInt(scanner.nextLine());
		System.out.print("Digite o Segundo Numero: ");
		//lendo como numero
		int numero2 = scanner.nextInt();
		//lendo como texto e convertendo para numero com parseint (cast)
		//int numero2 = Integer.parseInt(scanner.nextLine());
		scanner.close();
		System.out.println("O Primeiro Numero Digitado foi: " + numero1);
		System.out.println("O Segundo Numero Digitado foi: " + numero2);
	}

}

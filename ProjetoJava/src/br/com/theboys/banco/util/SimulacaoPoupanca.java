package br.com.theboys.banco.util;

import java.util.Scanner;

public class SimulacaoPoupanca {
	private static double valor;
	private static int dia;

	public static void simulacaoPoupanca() {
		double rendimento = 0;
		double valorTotal = 0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("O----------------------------O");
		System.out.println("|         Simula��o          |");
		System.out.println("O----------------------------O");
		System.out.print("|-> Digite o valor: R$ ");
		valor = scanner.nextDouble();
		System.out.println("O----------------------------O");
		System.out.print("|-> Digite quantos dias: ");
		dia = scanner.nextInt();
		LimpaTela.limpa();

		if (valor <= 0 || dia <= 0) {
			System.out.println("##############################");
			System.out.println("### Data ou valor inv�lido ###");
			System.out.println("##############################");
		} else {
			rendimento = dia * (valor * 0.01);
			valorTotal = valor + rendimento;

			System.out.println("O----------------------------O");
			System.out.println("|         Simula��o          |");
			System.out.println("|         Poupan�a           |");
			System.out.println("O----------------------------O");
			System.out.println("|-> Valor Total: R$ " + valorTotal);
			System.out.println("|-> Rendeu: R$ " + rendimento);
		}
	}
}

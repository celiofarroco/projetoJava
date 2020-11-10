package br.com.theboys.banco.util;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

import br.com.theboys.banco.contas.Conta;
import br.com.theboys.banco.contas.ContaCorrente;

public class EscreveCsv {
	public static void salva(List<Conta> contas) {

		PrintStream stream;
		try {
			stream = new PrintStream("Conta.csv");
			for (Conta conta : contas) {
				stream.println(conta.getTipo() + "," + conta.getCpf() + ","
						+ conta.getTitular() + "," + conta.getAgencia() + ","
						+ conta.getNumero() + "," + conta.getSaldo());
			}
			stream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void salvaRelatorio(List<Conta> contas) {

		PrintStream stream;
		try {
			stream = new PrintStream("Relatorio.txt");
			for (Conta conta : contas) {
				if (conta.getTipo().equals("Conta Corrente")) {
					ContaCorrente conta1 = (ContaCorrente) conta;
					stream.println(conta.getTipo() + " - " + "N� da conta: "
							+ conta.getNumero() + " - " + "Saldo: "
							+ conta.getSaldo());
					stream.println("Tributa��o Conta Corrente: "
							+ conta1.getValorImposto());

				} else if (conta.getTipo().equals("Conta Poupan�a")) {
					stream.println(conta.getTipo() + " - " + "N� da conta: "
							+ conta.getNumero() + " - " + "Saldo: "
							+ conta.getSaldo());
				} else {
					System.out.println("Tipo inv�lido!");
				}
			}
			stream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public static void salvaRelatorio(Conta conta) {
		
		PrintStream stream;
		String arquivo = conta.getTitular()+".csv";
		try {
			stream = new PrintStream(arquivo);
			stream.println(
					"Titular: " + conta.getTitular().trim() + " Cpf: " + conta.getCpf()
							+ " Ag�ncia: " + conta.getAgencia() + " N� da conta: "
							+ conta.getNumero() + " Saldo: " + conta.getSaldo());
			stream.println("\nValor cobrado saque (taxa): " + ContaCorrente.getTaxa1()
					+ " quantidade de saques: " + conta.getQuantidadeSaque()
					+ " Valor total (taxa): "
					+ (conta.getQuantidadeSaque() * ContaCorrente.getTaxa1()));
			stream.println("\nValor cobrado deposito (taxa): "
					+ ContaCorrente.getTaxa1() + " quantidade de dep�sitos: "
					+ conta.getQuantidadeDeposito() + " Valor total (taxa): "
					+ (conta.getQuantidadeDeposito() * ContaCorrente.getTaxa1()));
			stream.println("\nValor cobrado transfer�ncia (taxa): "
					+ ContaCorrente.getTaxa2() + " quantidade de transfer�ncias: "
					+ conta.getQuantidadeTranferencia() + " Valor total (taxa): "
					+ (conta.getQuantidadeTranferencia()
							* ContaCorrente.getTaxa2()));
			stream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}

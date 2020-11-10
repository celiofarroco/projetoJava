package br.com.theboys.banco.relatorios;

import br.com.theboys.banco.contas.Conta;
import br.com.theboys.banco.contas.ContaCorrente;

public class RelatorioCliente {
	public static void relatorioCliente(Conta conta) {

		System.out.println(
				"Titular: " + conta.getTitular().trim() + " Cpf: " + conta.getCpf()
						+ " Ag�ncia: " + conta.getAgencia() + " N� da conta: "
						+ conta.getNumero() + " Saldo: " + conta.getSaldo());
		System.out.println("\nValor cobrado saque (taxa): " + ContaCorrente.getTaxa1()
				+ " quantidade de saques: " + conta.getQuantidadeSaque()
				+ " Valor total (taxa): "
				+ (conta.getQuantidadeSaque() * ContaCorrente.getTaxa1()));
		System.out.println("\nValor cobrado deposito (taxa): "
				+ ContaCorrente.getTaxa1() + " quantidade de dep�sitos: "
				+ conta.getQuantidadeDeposito() + " Valor total (taxa): "
				+ (conta.getQuantidadeDeposito() * ContaCorrente.getTaxa1()));
		System.out.println("\nValor cobrado transfer�ncia (taxa): "
				+ ContaCorrente.getTaxa2() + " quantidade de transfer�ncias: "
				+ conta.getQuantidadeTranferencia() + " Valor total (taxa): "
				+ (conta.getQuantidadeTranferencia()
						* ContaCorrente.getTaxa2()));
	}
}

package br.com.treinaweb.java.streams;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		List<Empregado> empregados = new ArrayList<Empregado>();
		empregados.add(new Empregado(1, "Jo�o", 2000, "Producao"));
		empregados.add(new Empregado(1, "Marcelo", 5000, "Producao"));
		empregados.add(new Empregado(2, "Maria", 3000, "RH"));
		empregados.add(new Empregado(2, "Jose", 5000, "Controladoria"));
		empregados.add(new Empregado(4, "Josefina", 7000, "CTO"));

		System.out.println("****Funcion�rios que come�am com [J]****");
//		Stream<Empregado> streamEmpregados = empregados.stream();
//		Stream<Empregado> empregadosCome�amComJ = streamEmpregados.filter(emp -> emp.getNome().startsWith("J"));
//		List<Empregado> empregadosComJ = empregadosCome�amComJ.collect(Collectors.toList());
		Stream<Empregado> stream = empregados.stream().filter(emp -> {
			System.out.println("** Invocando o filter()");
			return emp.getNome().startsWith("J");
		});
		System.out.println("** A convers�o para lista ser� invocada");
		List<Empregado> empregadosComJ = stream.collect(Collectors.toList());
//		List<Empregado> empregadosComJ = empregados.stream()
//				.filter(emp -> emp.getNome().startsWith("J"))
//				.collect(Collectors.toList());
		empregadosComJ.stream().forEach((emp) -> System.out.println(emp.getNome()));
		OptionalDouble menorSalario = empregadosComJ.stream().mapToDouble((emp) -> emp.getSalario()).min();
		if (menorSalario.isPresent()) {
			System.out.println("Menor Sal�rio R$: " + menorSalario.getAsDouble());
		}
		DoubleSummaryStatistics sumario = empregados.stream()
				.collect(Collectors.summarizingDouble(Empregado::getSalario));
		System.out.println("Estat�sticas dos sal�rios");
		System.out.println("Maior Sal�rio R$: " + sumario.getMax());
		System.out.println("Menor Sal�rio R$: " + sumario.getMin());
		System.out.println("Sal�rio Medio R$: " + sumario.getAverage());
		System.out.println("Folha salarial RS: " + sumario.getSum());
		List<String> nomesEmpregados = empregados.stream().map(emp -> emp.getNome()).collect(Collectors.toList());
		System.out.println("Nomes dos empregados: ");
		nomesEmpregados.forEach(System.out::println);
		String nomesSeparadosPorVirgula = empregados.stream().map(Empregado::getNome).reduce("Nomes dos empregados: ",
				(n1, n2) -> n1 + "," + n2);
		System.out.println(nomesSeparadosPorVirgula);
		Map<String, List<Empregado>> dadosDepartamento = empregados.stream()
				.collect(Collectors.groupingBy(Empregado::getDepartamento));
		System.out.println("**Empregados por departamento");
		dadosDepartamento.forEach((dep, emps) -> {
			System.out.println("- " + dep + ", " + emps.size() + " Funcion�rios");
			emps.forEach(emp -> {
				System.out.println(" 	* " + emp.getNome());
			});
		});

//		System.out.println("**LISTA DE EMPREGADOS**");
//		// for (Empregado emp : empregados) {
//		// System.out.println(emp.getNome());
//		// }
//		empregados.stream().forEach(emp -> {
//			System.out.println(emp.getNome());
//		});
//		// double salarioTotal = 0;
//		// for (Empregado emp : empregados) {
//		// salarioTotal = salarioTotal + emp.getSalario();
//		// }
//		double salarioTotal = empregados.stream().mapToDouble(emp -> emp.getSalario()).sum();
//		System.out.println("Sal�rio total: R$" + salarioTotal);
//		// Mensageiro mensageiro = new MensageiroConsole();
//		// mensageiro.emitirMensagem("Treina Web");
//		// Mensageiro mensageiro = new Mensageiro() {
//
//		// @Override
//		// public void emitirMensagem(String mensagem) {
//		// System.out.println("Mensagem do objeto an�nimo: " + mensagem);
//		// }
//		// };
//		Mensageiro mensageiro = (mensagem) -> System.out.println("Mensagem da express�o lambda: " + mensagem);
//		mensageiro.emitirMensagem("TreinaWeb");
//
//		// *************************************************************************************
//		// consumer
//		// Entra um parametro e n�o retorna nada!
//		System.out.println("Execu��o do consumer: ");
//		Consumer<Empregado> consumer = (emp) -> {
//			System.out.println(emp.getNome() + ",R$" + emp.getSalario());
//		};
//		consumer.accept(new Empregado(10, "Treina Web", 1000, "Educa��o"));
//		// Functions
//		System.out.println("Execu��o da Functions: ");
//		Function<Empregado, Double> function = (emp) -> emp.getSalario() * 10;
//		double novoSalario = function.apply(new Empregado(1000, "", 1, ""));
//		System.out.println(novoSalario);
//
//		// BinaryOperator
//		System.out.println("Execu��o do BinaryOperator: ");
//		BinaryOperator<Empregado> binaryOperator = (emp1, emp2) -> new Empregado(-1, emp1.getNome() + emp2.getNome(),
//				emp1.getSalario() + emp2.getSalario(), "ju��o");
//		Empregado novoEmpregado = binaryOperator.apply(new Empregado(0, "Treina", 1000, ""),
//				new Empregado(0, "Web", 10000, ""));
//		System.out.println(novoEmpregado.getNome() + ",R$: " + novoEmpregado.getSalario());
//
//		// Predicate
//		System.out.println("Execu��o do Predicate: ");
//		Predicate<Empregado> predicate = (emp) -> emp.getNome().endsWith("Web");
//		Boolean terminaComWeb = predicate.test(new Empregado(0, "TreinaWeb", 0, ""));
//		System.out.println(terminaComWeb);
//
//		// Supplier
//		System.out.println("Execu��o do Supplier: ");
//		Supplier<Empregado> supplier = () -> new Empregado(new Random().nextInt(), "TreinaWeb", 0, "");
//		Empregado emp1 = supplier.get();
//		System.out.println(emp1.getId());
//		Empregado emp2 = supplier.get();
//		System.out.println(emp2.getId());
	}

}

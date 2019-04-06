package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.ContratoHora;
import entities.Departamento;
import entities.Empresa;
import entities.Trabalhador;
import entities.enums.LevelTrabalhador;

public class index {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.ENGLISH);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre com o nome da empresa: ");
		String nome_empresa = sc.nextLine();
		Empresa empresa = new Empresa(nome_empresa);
		System.out.println("Entre com o numero de funcionarios: ");
		Integer n_funcionarios = sc.nextInt();
		sc.nextLine();
		System.out.printf("%n");
		
		while(n_funcionarios>0) {
			System.out.print("Entre seu departamento: ");
			String nomeDepartamento = sc.nextLine();
			System.out.println("Entre seus dados");
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Level: ");
			String level = sc.next();
			System.out.print("Salario Base: ");
			Double salarioBase = sc.nextDouble();
			
			//intanciação do trabalhador
			Trabalhador trabalhador = new Trabalhador(nome, LevelTrabalhador.valueOf(level), salarioBase, new Departamento(nomeDepartamento));
			
			System.out.print("Quantos contratos voce conseguiu: ");
			Integer n_contratos = sc.nextInt();
			//ciclo de entrada de contratos
			while(n_contratos > 0) {
				System.out.print("Entre com a data(DD/MM/YY): ");
				Date data_contrato = sdf.parse(sc.next()); //nextLine em datas deu problema aqui e embaixo
				System.out.print("Entre com o valor por hora: ");
				Double valorHora = sc.nextDouble();
				System.out.print("Duração em horas: ");
				Integer horas = sc.nextInt();
				//intanciação do contrato
				ContratoHora contrato = new ContratoHora(data_contrato, valorHora, horas);
				//anexação deste contrato na lista de contratos do trabalhador
				trabalhador.addContrato(contrato);
				
				n_contratos--;
			}
			
			System.out.print("Entre mês e ano que quer saber seu income (MM/YYYY): ");
			String data_income = sc.next(); //nextLine em datas deu problema aqui e acima
			int mes = Integer.parseInt(data_income.substring(0, 2));
			int ano = Integer.parseInt(data_income.substring(3, 7));
			
			System.out.println();
			System.out.println("Nome: " + trabalhador.getNome());
			System.out.println("Departamento: " + trabalhador.getNomeDepartamento());
			System.out.printf("Income do mês %d do ano %d foi de %.2f reais%n%n", mes, ano, trabalhador.income(mes, ano));
			sc.nextLine();
			n_funcionarios --;
		}
	}
}

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
		
		//cria empresa e a inst�ncia
		System.out.println("Entre com o nome da empresa: ");
		String nome_empresa = sc.nextLine();
		Empresa empresa = new Empresa(nome_empresa);
		System.out.println("Entre com o numero de trabalhadores contratados como tercerizados: ");
		Integer n_funcionarios = sc.nextInt();
		sc.nextLine();
		System.out.printf("%n");
		
		//adiciona funcion�rios
		while(n_funcionarios>0) {
			System.out.print("Entre por qual departamento foi contrato: ");
			String nomeDepartamento = sc.nextLine();
			System.out.println("Entre dados do trabalhador tercerizado");
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Level: ");
			String level = sc.next();
			System.out.print("Salario Base: ");
			Double salarioBase = sc.nextDouble();
			
			//intancia��o do trabalhador
			Trabalhador trabalhador = new Trabalhador(nome, LevelTrabalhador.valueOf(level), salarioBase, new Departamento(nomeDepartamento));
			
			//recebe o n�mero de contratos e o adiciona a seguir
			System.out.print("Quantos contratos com este trabalhador? ");
			Integer n_contratos = sc.nextInt();

			while(n_contratos > 0) {
				System.out.print("Entre com a data do contrato (DD/MM/YY): ");
				Date data_contrato = sdf.parse(sc.next()); //nextLine em datas deu problema aqui e embaixo
				System.out.print("Entre com o valor por hora: ");
				Double valorHora = sc.nextDouble();
				System.out.print("Dura��o em horas: ");
				Integer horas = sc.nextInt();
				//intancia��o do contrato
				ContratoHora contrato = new ContratoHora(data_contrato, valorHora, horas);
				//anexa��o deste contrato na lista de contratos do trabalhador
				trabalhador.addContrato(contrato);
				
				n_contratos--;
			}
			
			System.out.print("Entre m�s e ano que quer saber os gastos da empresa com este trabalhador (MM/YYYY): ");
			String data_income = sc.next(); //nextLine em datas deu problema aqui e acima
			int mes = Integer.parseInt(data_income.substring(0, 2));
			int ano = Integer.parseInt(data_income.substring(3, 7));
			
			empresa.addTrabalhador(trabalhador);
			
			System.out.println();
			System.out.println("Nome da Empresa: " + trabalhador.getNome());
			System.out.println("Departamento contratante: " + trabalhador.getNomeDepartamento());
			System.out.printf("Gasto do m�s %d no ano de %d com este trabalhador foi de %.2f reais%n%n", mes, ano, trabalhador.income(mes, ano));
			sc.nextLine();
			n_funcionarios --;
		}
		
		//saber redimento de uma empresa por quanto seus funcion�rios ganharam
		System.out.println("Voce quer saber o gasto com trabalhadores tercerizados em um determinado m�s e ano da sua Empresa?(y/n)");
		String saber = sc.nextLine();
		if(saber.equals(String.valueOf('y'))) {
			System.out.print("Entre m�s e ano que quer saber seu gasto (MM/YYYY): ");
			String data_income = sc.next(); //nextLine em datas deu problema aqui e acima
			int mes = Integer.parseInt(data_income.substring(0, 2));
			int ano = Integer.parseInt(data_income.substring(3, 7));
				
			System.out.println("Nome: " + empresa.getNome());
			System.out.printf("Gastos da empresa no m�s %d do ano de %d foi de %.2f reais", mes, ano, empresa.income(mes, ano));
		}
		sc.close();
	}
}

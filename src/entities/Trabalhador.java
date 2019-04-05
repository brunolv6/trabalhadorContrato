package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.LevelTrabalhador;

public class Trabalhador {
	//atributos
	public String nome;
	public LevelTrabalhador level;
	public Double salarioBase;
	
	//atributos de classes externas, precisam ser instanciadas aqui ou ao adicionar
	public Departamento nomeDepartamento;
	public List<ContratoHora> contratos = new ArrayList<>();
	
	//construtor
	public Trabalhador(String nome, LevelTrabalhador level, Double salarioBase, Departamento nomeDepartamento) {
		this.nome = nome;
		this.level = level;
		this.salarioBase = salarioBase;
		this.nomeDepartamento = nomeDepartamento;
	}
	
	//métodos add e remove contratos
	public void addContrato(ContratoHora contrato) {
		contratos.add(contrato);
	}
	
	public void removeContrato(ContratoHora contrato) {
		contratos.remove(contrato);
	}
	
	//método calcula income de um mês e ano específico e o retorna
	public Double income(int mes, int ano) {
		Calendar cal = Calendar.getInstance();
		Double soma = salarioBase;
		//verifica cada contrato do tipo ContratoHora na lista "contratos"
		for(ContratoHora c: contratos) {
			cal.setTime(c.getData());
			int data_mes = 1 + cal.get(Calendar.MONTH); //+1 porque mês começa no zero em Calendar
			int data_ano = cal.get(Calendar.YEAR); 
			if(data_mes == mes && data_ano == ano) {
				soma += c.valorTotal();
			}
		}
		return soma;
	}

	
	//gets e sets
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LevelTrabalhador getLevel() {
		return level;
	}

	public void setLevel(LevelTrabalhador level) {
		this.level = level;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public String getNomeDepartamento() {
		return nomeDepartamento.getDepartamento();
	}

	public void setNomeDepartamento(Departamento nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}	
}

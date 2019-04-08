package entities;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	//atributo comum
	public String nome;
	//atributo de lista
	public List<Trabalhador> trabalhadores = new ArrayList<>();
	
	public Empresa(String nome) {
		this.nome = nome;
	}
	
	//gets e sets
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//métodos de lista para rabalhadores da empresa
	public void addTrabalhador(Trabalhador trabalhador) {
		trabalhadores.add(trabalhador);
	}
	
	public void removeTrabalhador(Trabalhador trabalhador) {
		trabalhadores.remove(trabalhador);
	}
	
	public Double income(int mes, int ano) {
		Double soma = 0.0;
		for(Trabalhador t : trabalhadores) {
			soma += t.income(mes, ano);
		}
		return soma;
	}
}

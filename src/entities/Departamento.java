package entities;

public class Departamento {
	public String nomeDepartamento;
	
	//construtor espec�fico
	public Departamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}
	
	//gets e sets
	public String getDepartamento() {
		return nomeDepartamento;
	}
	
	public void setDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}
	
}

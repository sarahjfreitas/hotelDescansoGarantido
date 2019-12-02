package Model;

public class Funcionario {
	private int codigo;
	private String nome;
	private String telefone;
	private String cargo;
	private double salario;
	
	public Funcionario(){}
	
	public Funcionario(int codigo, String nome, String telefone, String cargo, double salario){
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.cargo = cargo;
		this.salario = salario;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}

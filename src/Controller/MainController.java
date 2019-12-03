package Controller;

import java.util.ArrayList;

import Model.Cliente;
import Model.Estadia;
import Model.Funcionario;
import Model.Quarto;

public class MainController {
	public ArrayList<Cliente> listaClientes;
	public ArrayList<Estadia> listaEstadias;
	public ArrayList<Funcionario> listaFuncionarios;
	public ArrayList<Quarto> listaQuartos;
	
	public MainController() {
		listaClientes = new ArrayList<Cliente>();
		listaEstadias = new ArrayList<Estadia>();
		listaFuncionarios = new ArrayList<Funcionario>();
		listaQuartos = new ArrayList<Quarto>();
	}

	
	
	public void adicionarCliente(String codigo, String endereco, String nome, String telefone) {
		Cliente c = new Cliente(Integer.parseInt(codigo),nome,endereco,telefone);
		listaClientes.add(c);
	}
	
	public void adicionarFuncionario(String codigo, String cargo, String nome, String telefone, String salario) {
		Funcionario f = new Funcionario(Integer.parseInt(codigo), nome,telefone,cargo,Double.parseDouble(salario));
		listaFuncionarios.add(f);
	}
	
	public void adicionarQuarto(String numero, String capacidade, String valorDiaria) {
		Quarto q = new Quarto(Integer.parseInt(numero), Integer.parseInt(capacidade),Double.parseDouble(valorDiaria));
		listaQuartos.add(q);
	}
	
	public void adicionarEstadia(String codigoCliente, String codigo, String quantidade, String numeroQuarto, String dataEntrada, String dataSaida) {
		
	}
	
	

}

package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Model.Cliente;
import Model.Estadia;
import Model.Funcionario;
import Model.Quarto;
import Util.ResponseMessage;
import Util.Utilities;

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

	
	
	public ResponseMessage adicionarCliente(String codigo, String endereco, String nome, String telefone) {
		if(!Utilities.isInteger(codigo)) {
			return new ResponseMessage(false,"Código deve ser um número inteiro");			
		}
		int codigoNum = Integer.parseInt(codigo);
		if(!listaClientes.stream().filter(c -> c.getCodigo() == codigoNum).collect(Collectors.toList()).isEmpty()) {
			return new ResponseMessage(false,"Código deve único");
		}
		
		//TODO: validar outros campos se sobrar tempo
		
		Cliente c = new Cliente(codigoNum,nome,endereco,telefone);
		listaClientes.add(c);
		return new ResponseMessage(true,"Cliente adicionado");
	}
	
	public ResponseMessage adicionarFuncionario(String codigo, String cargo, String nome, String telefone, String salario) {
		if(!Utilities.isInteger(codigo)) {
			return new ResponseMessage(false,"Código deve ser um número inteiro");			
		}
		int codigoNum = Integer.parseInt(codigo);
		if(!listaClientes.stream().filter(c -> c.getCodigo() == codigoNum).collect(Collectors.toList()).isEmpty()) {
			return new ResponseMessage(false,"Código deve único");
		}
		if(!Utilities.isDouble(salario)) {
			return new ResponseMessage(false,"Salário deve ser um número decimal ou inteiro.");			
		}
		

		//TODO: validar outros campos se sobrar tempo
		
		Funcionario f = new Funcionario(Integer.parseInt(codigo), nome,telefone,cargo,Double.parseDouble(salario));
		listaFuncionarios.add(f);
		return new ResponseMessage(true,"Funcionário adicionado");
	}
	
	public void adicionarQuarto(String numero, String capacidade, String valorDiaria) {
		Quarto q = new Quarto(Integer.parseInt(numero), Integer.parseInt(capacidade),Double.parseDouble(valorDiaria));
		listaQuartos.add(q);
	}
	
	public ResponseMessage adicionarEstadia(String codigoCliente, String codigo, String quantidade,String dataEntrada, String dataSaida) {
		if(!Utilities.isInteger(codigoCliente)) {
			return new ResponseMessage(false,"Código deve ser um número inteiro");			
		}
		int codigoClienteNum = Integer.parseInt(codigoCliente);
		
		if(!Utilities.isInteger(codigo)) {
			return new ResponseMessage(false,"Código deve ser um número inteiro");			
		}
		int codigoNum = Integer.parseInt(codigo);
		
		if(!Utilities.isInteger(quantidade)) {
			return new ResponseMessage(false,"Quantidade deve ser um número inteiro");			
		}
		int quantidadeNum = Integer.parseInt(quantidade);
		
		Cliente cliente = buscarCliente(codigoClienteNum);
		if(cliente == null) {
			return new ResponseMessage(false,"Cliente não encontrado.");
		}

		// TODO: validar datas
		// TODO: calculas dias de estadia
		// TODO: buscar quarto vago
		// TODO: adicionar estadia
		
		return new ResponseMessage(true,"Estadia adicionada");
	}
	
	public Cliente buscarCliente(int codigo) {
		List<Cliente> lista = listaClientes.stream().filter(c -> c.getCodigo() == codigo).collect(Collectors.toList());
		if(lista.isEmpty()) {
			return null;
		}
		else {
			return lista.get(0);
		}
	}
	

}

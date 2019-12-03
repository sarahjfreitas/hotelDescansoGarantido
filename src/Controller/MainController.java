package Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
			return new ResponseMessage(false,"C�digo deve ser um n�mero inteiro");			
		}
		int codigoNum = Integer.parseInt(codigo);
		if(!listaClientes.stream().filter(c -> c.getCodigo() == codigoNum).collect(Collectors.toList()).isEmpty()) {
			return new ResponseMessage(false,"C�digo deve �nico");
		}
		
		//TODO: validar outros campos se sobrar tempo
		
		Cliente c = new Cliente(codigoNum,nome,endereco,telefone);
		listaClientes.add(c);
		return new ResponseMessage(true,"Cliente adicionado");
	}
	
	public ResponseMessage adicionarFuncionario(String codigo, String cargo, String nome, String telefone, String salario) {
		if(!Utilities.isInteger(codigo)) {
			return new ResponseMessage(false,"C�digo deve ser um n�mero inteiro");			
		}
		int codigoNum = Integer.parseInt(codigo);
		if(!listaClientes.stream().filter(c -> c.getCodigo() == codigoNum).collect(Collectors.toList()).isEmpty()) {
			return new ResponseMessage(false,"C�digo deve �nico");
		}
		if(!Utilities.isDouble(salario)) {
			return new ResponseMessage(false,"Sal�rio deve ser um n�mero decimal ou inteiro.");			
		}
		

		//TODO: validar outros campos se sobrar tempo
		
		Funcionario f = new Funcionario(Integer.parseInt(codigo), nome,telefone,cargo,Double.parseDouble(salario));
		listaFuncionarios.add(f);
		return new ResponseMessage(true,"Funcion�rio adicionado");
	}
	
	public void adicionarQuarto(String numero, String capacidade, String valorDiaria) {
		Quarto q = new Quarto(Integer.parseInt(numero), Integer.parseInt(capacidade),Double.parseDouble(valorDiaria));
		listaQuartos.add(q);
	}
	
	public ResponseMessage adicionarEstadia(String codigoCliente, String codigo, String quantidade,String dataEntrada, String dataSaida) {
		if(!Utilities.isInteger(codigoCliente)) {
			return new ResponseMessage(false,"C�digo deve ser um n�mero inteiro");			
		}
		int codigoClienteNum = Integer.parseInt(codigoCliente);
		
		if(!Utilities.isInteger(codigo)) {
			return new ResponseMessage(false,"C�digo deve ser um n�mero inteiro");			
		}
		int codigoNum = Integer.parseInt(codigo);
		
		if(!Utilities.isInteger(quantidade)) {
			return new ResponseMessage(false,"Quantidade deve ser um n�mero inteiro");			
		}
		int quantidadeNum = Integer.parseInt(quantidade);
		
		Cliente cliente = buscarCliente(codigoClienteNum);
		if(cliente == null) {
			return new ResponseMessage(false,"Cliente n�o encontrado.");
		}
		Date dtEntrada;
		Date dtSaida;
		int intervaloDias;
		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			dtEntrada = df.parse(dataEntrada);
			dtSaida = df.parse(dataSaida);
			intervaloDias = (int) ((dtSaida.getTime() - dtEntrada.getTime() ) / 86400000L);
		}
		catch(Exception e) {
			return new ResponseMessage(false,"Data precisa estar no formato dd/MM/yyyy.");
		}
		
		Quarto quarto = buscarQuartoVago(dtEntrada, dtSaida,quantidadeNum);
		if(quarto == null) {
			return new ResponseMessage(false,"Nenhum quarto dispon�vel");			
		}
		
		Estadia estadia = new Estadia(codigoNum,quarto,quantidadeNum,cliente,dtEntrada,dtSaida,intervaloDias);
		quarto.setStatus(false);
		quarto.getEstadias().add(estadia);		
		listaEstadias.add(estadia);
		
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
	
	public Quarto buscarQuartoVago(Date dtEntrada, Date dtSaida, int quantidadeHospedes) {
		for(Quarto quarto : listaQuartos) {
			if(quarto.isDisponivel(dtEntrada, dtSaida) && quantidadeHospedes <=  quarto.getCapacidade()) {
				return quarto;
			}
		}
		return null;
	}
	

}

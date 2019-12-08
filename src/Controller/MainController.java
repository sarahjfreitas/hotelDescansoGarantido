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

/**
 * controller principal do projeto
 * @author sarah.freitas
 */
public class MainController {

    /**
     * lista de clientes
     */
    public ArrayList<Cliente> listaClientes;

    /**
     * lista de estadias
     */
    public ArrayList<Estadia> listaEstadias;

    /**
     * lista de funcionarios
     */
    public ArrayList<Funcionario> listaFuncionarios;

    /**
     * lista de quartos
     */
    public ArrayList<Quarto> listaQuartos;

    /**
     * contrutor padrao
     */
    public MainController() {
        listaClientes = new ArrayList<>();
        listaEstadias = new ArrayList<>();
        listaFuncionarios = new ArrayList<>();
        listaQuartos = new ArrayList<>();
    }

    /**
     * metodo que adiciona um novo cliente
     * @param codigo String codigo do cliente
     * @param endereco String endereco do cliente
     * @param nome String nome do cliente
     * @param telefone String telefone do cliente
     * @return ResponseMessage status true ou false dependendo do sucesso e mensagem com detalhes
     */
    public ResponseMessage adicionarCliente(String codigo, String endereco, String nome, String telefone) {
        if (!Utilities.isInteger(codigo)) {
            return new ResponseMessage(false, "Código deve ser um número inteiro");
        }
        int codigoNum = Integer.parseInt(codigo);
        if (!listaClientes.stream().filter(c -> c.getCodigo() == codigoNum).collect(Collectors.toList()).isEmpty()) {
            return new ResponseMessage(false, "Código deve único");
        }

        //TODO: validar outros campos se sobrar tempo
        Cliente c = new Cliente(codigoNum, nome, endereco, telefone);
        listaClientes.add(c);
        return new ResponseMessage(true, "Cliente adicionado");
    }

    /**
     * metodo que adiciona um novo funcionario
     * @param codigo Sring codigo do funcinario
     * @param cargo String cargo do funcinario
     * @param nome String nome do funcinario
     * @param telefone String telefone do funcinario
     * @param salario String salario do funcinario
     * @return ResponseMessage status true ou false dependendo do sucesso e mensagem com detalhes
     */
    public ResponseMessage adicionarFuncionario(String codigo, String cargo, String nome, String telefone, String salario) {
        if (!Utilities.isInteger(codigo)) {
            return new ResponseMessage(false, "Código deve ser um número inteiro");
        }
        int codigoNum = Integer.parseInt(codigo);
        if (!listaClientes.stream().filter(c -> c.getCodigo() == codigoNum).collect(Collectors.toList()).isEmpty()) {
            return new ResponseMessage(false, "Código deve único");
        }
        if (!Utilities.isDouble(salario)) {
            return new ResponseMessage(false, "Salário deve ser um número decimal ou inteiro.");
        }

        //TODO: validar outros campos se sobrar tempo
        Funcionario f = new Funcionario(Integer.parseInt(codigo), nome, telefone, cargo, Double.parseDouble(salario));
        listaFuncionarios.add(f);
        return new ResponseMessage(true, "Funcionário adicionado");
    }

    /**
     * metodo que adiciona um novo quarto
     * @param numero String numero do quarto
     * @param capacidade Sring capacidade maxima de hospedes
     * @param valorDiaria String valor da diaria
     */
    public void adicionarQuarto(String numero, String capacidade, String valorDiaria) {
        Quarto q = new Quarto(Integer.parseInt(numero), Integer.parseInt(capacidade), Double.parseDouble(valorDiaria));
        listaQuartos.add(q);
    }

    /**
     * metodo que adiciona uma nova estadia
     * @param codigoCliente String codigo do cliente
     * @param codigo String codigo da estadia
     * @param quantidade String quantidade de hospedes
     * @param dataEntrada String data de entrada no formato dd/MM/yyyy
     * @param dataSaida String data de saida no formato dd/MM/yyyy
     * @return ResponseMessage status true ou false dependendo do sucesso e mensagem com detalhes
     */ 
    public ResponseMessage adicionarEstadia(String codigoCliente, String codigo, String quantidade, String dataEntrada, String dataSaida) {
        if (!Utilities.isInteger(codigoCliente)) {
            return new ResponseMessage(false, "Código deve ser um número inteiro");
        }
        int codigoClienteNum = Integer.parseInt(codigoCliente);

        if (!Utilities.isInteger(codigo)) {
            return new ResponseMessage(false, "Código deve ser um número inteiro");
        }
        int codigoNum = Integer.parseInt(codigo);

        if (!Utilities.isInteger(quantidade)) {
            return new ResponseMessage(false, "Quantidade deve ser um n�mero inteiro");
        }
        int quantidadeNum = Integer.parseInt(quantidade);

        Cliente cliente = buscarCliente(codigoClienteNum);
        if (cliente == null) {
            return new ResponseMessage(false, "Cliente não encontrado.");
        }
        Date dtEntrada;
        Date dtSaida;
        int intervaloDias;
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            dtEntrada = df.parse(dataEntrada);
            dtSaida = df.parse(dataSaida);
            intervaloDias = (int) ((dtSaida.getTime() - dtEntrada.getTime()) / 86400000L);
        } catch (Exception e) {
            return new ResponseMessage(false, "Data precisa estar no formato dd/MM/yyyy.");
        }

        Quarto quarto = buscarQuartoVago(dtEntrada, dtSaida, quantidadeNum);
        if (quarto == null) {
            return new ResponseMessage(false, "Nenhum quarto dispon�vel");
        }

        Estadia estadia = new Estadia(codigoNum, quarto, quantidadeNum, cliente, dtEntrada, dtSaida, intervaloDias);
        quarto.setStatus(false);
        quarto.getEstadias().add(estadia);
        cliente.getEstadias().add(estadia);
        listaEstadias.add(estadia);

        return new ResponseMessage(true, "Estadia adicionada");
    }

    /**
     * metodo que encerra uma estadia
     * @param codigoEstadia int codigo da estadia
     * @return ResponseMessage status true ou false dependendo do sucesso e mensagem com detalhes
     */
    public ResponseMessage finalizarEstadia(int codigoEstadia) {
        Estadia estadia = buscarEstadia(codigoEstadia);
        if (estadia == null) {
            return new ResponseMessage(false, "Estadia não encontrada");
        }
        estadia.getQuarto().setStatus(true);
        double valorAPagar = estadia.getValorTotal();
        return new ResponseMessage(true, Double.toString(valorAPagar));
    }

    /**
     * metodo que busca um cliente pelo codigo
     * @param codigo int codigo do cliente
     * @return Cliente encontrado ou null se nao for encontrado
     */
    public Cliente buscarCliente(int codigo) {
        List<Cliente> lista = listaClientes.stream().filter(c -> c.getCodigo() == codigo).collect(Collectors.toList());
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    /**
     * metodo que busca um cliente pelo nome
     * @param nome String nome do Cliente
     * @return Cliente encontrado ou null se nao for encontrado
     */
    public Cliente buscarCliente(String nome) {
        List<Cliente> lista = listaClientes.stream().filter(c -> c.getNome().equals(nome)).collect(Collectors.toList());
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    /**
     * metodo que busca as estadias de um cliente
     * @param codigo int codigo do cliente
     * @return ArrayList de Estadia contendo as estadias do cliente
     */
    public ArrayList<Estadia> buscarEstadiasDoCliente(int codigo){
        Cliente c = buscarCliente(codigo);
        if(c == null){
            return null;
        }
        return c.getEstadias();
    }

    /**
     * metodo que busca um quarto vago
     * @param dtEntrada Date data desejada de entrada
     * @param dtSaida Date data desejada de saida
     * @param quantidadeHospedes int quantidade de hospedes
     * @return retorna o Quarto caso existe algum disponivel, caso contrario retorna null
     */
    public Quarto buscarQuartoVago(Date dtEntrada, Date dtSaida, int quantidadeHospedes) {
        for (Quarto quarto : listaQuartos) {
            if (quarto.isDisponivel(dtEntrada, dtSaida) && quantidadeHospedes <= quarto.getCapacidade()) {
                return quarto;
            }
        }
        return null;
    }

    /**
     * metodo que busca uma estadia pelo codigo
     * @param codigo int codigo da estadia
     * @return Estadia encontrada ou null caso nao encontre
     */
    public Estadia buscarEstadia(int codigo) {
        List<Estadia> lista = listaEstadias.stream().filter(c -> c.getCodigo() == codigo).collect(Collectors.toList());
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    /**
     * metodo que busca a quantidade de pontos de fidelidade de um cliente
     * @param codigo int codigo do cliente
     * @return int quantidade de pontos de fidelidade do cliente ou 0 caso não encontre o cliente
     */
    public int buscarQuantidadePontosFidelidadeCliente(int codigo){
        Cliente c = buscarCliente(codigo);
        if(c == null){
            return 0;
        }
        return c.getPontosFidelidade();
    }
}
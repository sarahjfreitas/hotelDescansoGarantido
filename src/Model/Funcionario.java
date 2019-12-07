package Model;

/**
 * Classe para objetos do tipo Funcionario
 *
 * @author Sarah Júlia
 */
public class Funcionario {

    private int codigo;
    private String nome;
    private String telefone;
    private String cargo;
    private double salario;

    /**
     * Contrutor para criação de funcionario vazio
     */
    public Funcionario() {
    }

    /**
     * Contrutor para criação de funcionario com os dados
     *
     * @param codigo int - codigo do funcionario
     * @param nome String - nome do funcionario
     * @param telefone String - telefone do funcionario
     * @param cargo String - cargo do funcionario
     * @param salario Double - salario do funcionario
     */
    public Funcionario(int codigo, String nome, String telefone, String cargo, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.cargo = cargo;
        this.salario = salario;
    }

    /**
     * Método para retorno do codigo do funcionario
     *
     * @return int - codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Método para definir o codigo do funcionario
     *
     * @param codigo int - codigo do funcionario
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Método para retorno do nome do funcionario
     *
     * @return nome String - nome do funcionario
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método para definir o nome do funcionario
     *
     * @param nome String - nome do funcionario
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método para retornar o telefone do funcionario
     *
     * @return telefone String - telefone do funcionario
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Método para definir o telefone do funcionario
     *
     * @param telefone String - telefone do funcionario
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Método para retornar o cargo do funcionario
     *
     * @return cargo String - cargo do funcionario
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Método para definir o cargo do funcionario
     *
     * @param cargo String - cargo do funcionario
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Método para retornar o salario do funcionario
     *
     * @return cargo String - salario do funcionario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Método para definir o salario do funcionario
     *
     * @param salario String - salario do funcionario
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }
}

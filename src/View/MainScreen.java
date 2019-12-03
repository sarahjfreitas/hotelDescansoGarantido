package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import Controller.MainController;
import Model.Cliente;
import Model.Quarto;

public class MainScreen {

	protected Shell shlHotelDescansoGarantido;
	private Text textClienteCodigo;
	private Text textClienteNome;
	private Text textClienteEndereco;
	private Text textClienteTelefone;
	private Text textFuncionarioCodigo;
	private Text textFuncionarioNome;
	private Text textFuncionarioTelefone;
	private Text textFuncionarioCargo;
	private Text textFuncionarioSalario;
	private Text textQuartoNumero;
	private Text textQuartoQuantidade;
	private Text textQuartoValor;
	private Text textEstadiaCodigo;
	private Text textEstadiaEntrada;
	private Text textEstadiaSaida;
	private Combo comboEstadiaQuarto;
	private Combo comboEstadiaCliente;
	
	private MainController mainController;
	
	private int clienteLastCode;
	private int funcionarioLastCode;
	private int estadiaLastCode;
	private Text textEstadiaQuantidadeHospedes;
	
	public static void main(String[] args) {		
		try {
			MainScreen window = new MainScreen();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	MainScreen() {
		mainController  = new MainController();
		clienteLastCode = 1;
		funcionarioLastCode = 1;
		estadiaLastCode = 1;
	}

	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlHotelDescansoGarantido.open();
		shlHotelDescansoGarantido.layout();
		while (!shlHotelDescansoGarantido.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	public void onAdicionarCliente() {
		String codigo = textClienteCodigo.getText();
		String endereco = textClienteEndereco.getText();
		String nome = textClienteNome.getText();
		String telefone = textClienteTelefone.getText();
		mainController.adicionarCliente(codigo, endereco, nome, telefone);
		atualizarListaClientes();
		clienteLastCode++;
		textClienteCodigo.setText(Integer.toString(clienteLastCode));
	}
	
	public void onAdicionarFuncionario() {
		String codigo = textFuncionarioCodigo.getText();
		String nome = textFuncionarioNome.getText();
		String telefone = textFuncionarioTelefone.getText();
		String cargo = textFuncionarioCargo.getText();
		String salario = textFuncionarioSalario.getText();
		mainController.adicionarFuncionario(codigo, cargo, nome, telefone, salario);
		funcionarioLastCode++;
		textFuncionarioCodigo.setText(Integer.toString(funcionarioLastCode));
	}
	
	public void onAdicionarQuarto() {
		String numero = textQuartoNumero.getText();
		String capacidade = textQuartoQuantidade.getText();
		String valorDiaria = textQuartoValor.getText();
		mainController.adicionarQuarto(numero, capacidade, valorDiaria);
		atualizarListaQuartos();
	}
	
	public void onAdicionarEstadia() {
		String saida = textEstadiaSaida.getText();
		String entrada = textEstadiaEntrada.getText();
		String quantidade = textEstadiaQuantidadeHospedes.getText();
		String quarto = comboEstadiaQuarto.getText();
		String codigoCliente = comboEstadiaCliente.getText().split(" - ")[0];
		String codigo = textEstadiaCodigo.getText();
		
		mainController.adicionarEstadia(codigoCliente, codigo, quantidade, quarto,entrada,saida);
		estadiaLastCode++;
		textEstadiaCodigo.setText(Integer.toString(estadiaLastCode));
	}
		
	
	public void atualizarListaClientes() {
		comboEstadiaCliente.removeAll();
		for (Cliente cliente : mainController.listaClientes) {
			comboEstadiaCliente.add(Integer.toString(cliente.getCodigo()) + " - " + cliente.getNome() );
	    }
	}
	
	public void atualizarListaQuartos() {
		comboEstadiaQuarto.removeAll();
		for (Quarto quarto : mainController.listaQuartos) {
			comboEstadiaQuarto.add(Integer.toString(quarto.getNumero()) );
	    }
	}
	
	protected void createContents() {
		shlHotelDescansoGarantido = new Shell();
		shlHotelDescansoGarantido.setSize(846, 453);
		shlHotelDescansoGarantido.setText("Hotel Descanso Garantido");
		
		TabFolder tabFolder = new TabFolder(shlHotelDescansoGarantido, SWT.NONE);
		tabFolder.setBounds(10, 10, 810, 383);
		
		TabItem tbtmCadastros = new TabItem(tabFolder, SWT.NONE);
		tbtmCadastros.setText("Cadastrar");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmCadastros.setControl(composite);
		
		Group grpCliente = new Group(composite, SWT.NONE);
		grpCliente.setLocation(10, 0);
		grpCliente.setSize(782, 97);
		grpCliente.setText("Cliente");
		
		Label lblCdigo = new Label(grpCliente, SWT.NONE);
		lblCdigo.setBounds(15, 22, 46, 15);
		lblCdigo.setText("C\u00F3digo:");
		
		textClienteCodigo = new Text(grpCliente, SWT.BORDER);
		textClienteCodigo.setEnabled(false);
		textClienteCodigo.setBounds(67, 19, 46, 21);
		textClienteCodigo.setText(Integer.toString(clienteLastCode));
		
		Label lblNome = new Label(grpCliente, SWT.NONE);
		lblNome.setBounds(119, 22, 39, 15);
		lblNome.setText("Nome:");
		
		textClienteNome = new Text(grpCliente, SWT.BORDER);
		textClienteNome.setBounds(164, 19, 370, 21);
		
		Label lblEndereo = new Label(grpCliente, SWT.NONE);
		lblEndereo.setBounds(10, 53, 55, 15);
		lblEndereo.setText("Endere\u00E7o:");
		
		textClienteEndereco = new Text(grpCliente, SWT.BORDER);
		textClienteEndereco.setBounds(67, 50, 466, 21);
		
		Label lblTelefone = new Label(grpCliente, SWT.NONE);
		lblTelefone.setBounds(540, 22, 55, 15);
		lblTelefone.setText("Telefone:");
		
		textClienteTelefone = new Text(grpCliente, SWT.BORDER);
		textClienteTelefone.setBounds(598, 19, 171, 21);
		
		Button btnAdicionarCliente = new Button(grpCliente, SWT.NONE);
		btnAdicionarCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				onAdicionarCliente();
			}
		});
		btnAdicionarCliente.setBounds(694, 62, 75, 25);
		btnAdicionarCliente.setText("Adicionar");
		
		Group grpFuncionrio = new Group(composite, SWT.NONE);
		grpFuncionrio.setLocation(10, 103);
		grpFuncionrio.setSize(782, 82);
		grpFuncionrio.setText("Funcion\u00E1rio");
		
		Label label = new Label(grpFuncionrio, SWT.NONE);
		label.setText("C\u00F3digo:");
		label.setBounds(11, 22, 46, 15);
		
		textFuncionarioCodigo = new Text(grpFuncionrio, SWT.BORDER);
		textFuncionarioCodigo.setEnabled(false);
		textFuncionarioCodigo.setBounds(63, 19, 46, 21);
		textFuncionarioCodigo.setText(Integer.toString(funcionarioLastCode));
		
		Label label_1 = new Label(grpFuncionrio, SWT.NONE);
		label_1.setText("Nome:");
		label_1.setBounds(115, 22, 39, 15);
		
		textFuncionarioNome = new Text(grpFuncionrio, SWT.BORDER);
		textFuncionarioNome.setBounds(160, 19, 370, 21);
		
		Label label_2 = new Label(grpFuncionrio, SWT.NONE);
		label_2.setText("Telefone:");
		label_2.setBounds(536, 22, 55, 15);
		
		textFuncionarioTelefone = new Text(grpFuncionrio, SWT.BORDER);
		textFuncionarioTelefone.setBounds(598, 19, 171, 21);
		
		Label lblCargo = new Label(grpFuncionrio, SWT.NONE);
		lblCargo.setBounds(10, 46, 50, 15);
		lblCargo.setText("Cargo:");
		
		textFuncionarioCargo = new Text(grpFuncionrio, SWT.BORDER);
		textFuncionarioCargo.setBounds(63, 46, 304, 21);
		
		Label lblSalrio = new Label(grpFuncionrio, SWT.NONE);
		lblSalrio.setBounds(386, 46, 41, 15);
		lblSalrio.setText("Sal\u00E1rio:");
		
		textFuncionarioSalario = new Text(grpFuncionrio, SWT.BORDER);
		textFuncionarioSalario.setBounds(433, 46, 171, 21);
		
		Button buttonAdicionarFuncionario = new Button(grpFuncionrio, SWT.NONE);
		buttonAdicionarFuncionario.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				onAdicionarFuncionario();
			}
		});
		buttonAdicionarFuncionario.setText("Adicionar");
		buttonAdicionarFuncionario.setBounds(694, 47, 75, 25);
		
		Group grpQuarto = new Group(composite, SWT.NONE);
		grpQuarto.setLocation(10, 191);
		grpQuarto.setSize(782, 65);
		grpQuarto.setText("Quarto");
		
		Label lblNmero = new Label(grpQuarto, SWT.NONE);
		lblNmero.setBounds(10, 20, 50, 15);
		lblNmero.setText("N\u00FAmero:");
		
		textQuartoNumero = new Text(grpQuarto, SWT.BORDER);
		textQuartoNumero.setBounds(64, 14, 60, 21);
		
		Label lblQuantidadeDeHospedes = new Label(grpQuarto, SWT.NONE);
		lblQuantidadeDeHospedes.setBounds(135, 20, 140, 15);
		lblQuantidadeDeHospedes.setText("Quantidade de Hospedes:");
		
		textQuartoQuantidade = new Text(grpQuarto, SWT.BORDER);
		textQuartoQuantidade.setBounds(278, 14, 60, 21);
		
		Label lblValorDiria = new Label(grpQuarto, SWT.NONE);
		lblValorDiria.setBounds(344, 20, 70, 15);
		lblValorDiria.setText("Valor Di\u00E1ria:");
		
		textQuartoValor = new Text(grpQuarto, SWT.BORDER);
		textQuartoValor.setBounds(415, 14, 60, 21);
		
		Button buttonAdicionarQuarto = new Button(grpQuarto, SWT.NONE);
		buttonAdicionarQuarto.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				onAdicionarQuarto();
			}
		});
		buttonAdicionarQuarto.setText("Adicionar");
		buttonAdicionarQuarto.setBounds(697, 30, 75, 25);
		
		Group grpEstadia = new Group(composite, SWT.NONE);
		grpEstadia.setText("Estadia");
		grpEstadia.setBounds(10, 262, 782, 82);
		
		Label label_3 = new Label(grpEstadia, SWT.NONE);
		label_3.setText("C\u00F3digo:");
		label_3.setBounds(10, 22, 46, 15);
		
		textEstadiaCodigo = new Text(grpEstadia, SWT.BORDER);
		textEstadiaCodigo.setEnabled(false);
		textEstadiaCodigo.setBounds(62, 19, 46, 21);
		textEstadiaCodigo.setText(Integer.toString(estadiaLastCode));
		
		Label lblNewLabel = new Label(grpEstadia, SWT.NONE);
		lblNewLabel.setBounds(114, 22, 90, 15);
		lblNewLabel.setText("Data de Entrada:");
		
		textEstadiaEntrada = new Text(grpEstadia, SWT.BORDER);
		textEstadiaEntrada.setBounds(206, 19, 83, 21);
		
		Label lblDataDeSada = new Label(grpEstadia, SWT.NONE);
		lblDataDeSada.setBounds(302, 22, 76, 15);
		lblDataDeSada.setText("Data de Sa\u00EDda:");
		
		textEstadiaSaida = new Text(grpEstadia, SWT.BORDER);
		textEstadiaSaida.setBounds(382, 19, 83, 21);
		
		Label lblNewLabel_1 = new Label(grpEstadia, SWT.NONE);
		lblNewLabel_1.setBounds(10, 52, 50, 15);
		lblNewLabel_1.setText("Cliente:");
		
		comboEstadiaCliente = new Combo(grpEstadia, SWT.READ_ONLY);
		comboEstadiaCliente.setBounds(62, 49, 227, 23);
		
		Label lblQuarto = new Label(grpEstadia, SWT.NONE);
		lblQuarto.setBounds(302, 52, 45, 15);
		lblQuarto.setText("Quarto:");
		
		comboEstadiaQuarto = new Combo(grpEstadia, SWT.READ_ONLY);
		comboEstadiaQuarto.setBounds(348, 49, 117, 23);
		
		Button buttonAdicionarEstadia = new Button(grpEstadia, SWT.NONE);
		buttonAdicionarEstadia.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				onAdicionarEstadia();
			}
		});
		buttonAdicionarEstadia.setText("Adicionar");
		buttonAdicionarEstadia.setBounds(697, 47, 75, 25);
		
		Label label_4 = new Label(grpEstadia, SWT.NONE);
		label_4.setText("Quantidade de Hospedes:");
		label_4.setBounds(476, 22, 140, 15);
		
		textEstadiaQuantidadeHospedes = new Text(grpEstadia, SWT.BORDER);
		textEstadiaQuantidadeHospedes.setBounds(622, 19, 60, 21);
		
		TabItem tbtmPesquisar = new TabItem(tabFolder, SWT.NONE);
		tbtmPesquisar.setText("Pesquisar");

	}
}

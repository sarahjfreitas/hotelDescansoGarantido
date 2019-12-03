package View;

import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.sun.javafx.collections.MappingChange.Map;

import Controller.MainController;
import Model.Cliente;

import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

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
	private Text text_FuncionarioSalario;
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
	}

	/**
	 * Open the window.
	 */
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
	
	public void atualizarListaClientes() {
		comboEstadiaCliente.removeAll();
		for (Cliente cliente : mainController.listaClientes) {
			comboEstadiaCliente.add(Integer.toString(cliente.getCodigo()) + " - " + cliente.getNome() );
	    }
	}
	
	/**
	 * Create contents of the window.
	 */
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
		
		text_FuncionarioSalario = new Text(grpFuncionrio, SWT.BORDER);
		text_FuncionarioSalario.setBounds(433, 46, 171, 21);
		
		Button buttonAdicionarFuncionario = new Button(grpFuncionrio, SWT.NONE);
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
		
		Label lblNewLabel = new Label(grpEstadia, SWT.NONE);
		lblNewLabel.setBounds(114, 22, 90, 15);
		lblNewLabel.setText("Data de Entrada:");
		
		textEstadiaEntrada = new Text(grpEstadia, SWT.BORDER);
		textEstadiaEntrada.setBounds(206, 19, 83, 21);
		
		Label lblDataDeSada = new Label(grpEstadia, SWT.NONE);
		lblDataDeSada.setBounds(302, 22, 83, 15);
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
		buttonAdicionarEstadia.setText("Adicionar");
		buttonAdicionarEstadia.setBounds(697, 47, 75, 25);
		
		TabItem tbtmPesquisar = new TabItem(tabFolder, SWT.NONE);
		tbtmPesquisar.setText("Pesquisar");

	}
}

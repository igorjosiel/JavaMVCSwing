package Views;

import Componentes.JTextLimpar;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.FuncionaraioController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FuncionarioFrame extends JFrame
{
    private JPanel contentPane;
    private JTextLimpar nameTextField;
    private JTextLimpar matriculaTextField;
    
    private JFrame jframe = this;
	
    private JButton btnCadastrar;
    private JButton btnLimpar;
    private JButton btnExibir;
    private JButton btnSortear;
    private JButton btnFechar;
	
    /**
	* Lança a aplicação
    */
    public static void main(String[] args)
    {
	EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
		try
                {
                    FuncionarioFrame frame = new FuncionarioFrame();
		
                    frame.setVisible(true);
		}

                catch (Exception e)
                {
                    e.printStackTrace();
		}
            }
		
        });
    }

    /**
        * Criação do frame
    */
	
    public FuncionarioFrame()
    {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
		
        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(33, 73, 61, 16);
        contentPane.add(lblNome);
		
	JLabel lblMatrcula = new JLabel("Matrícula");
        lblMatrcula.setBounds(33, 120, 81, 16);
        contentPane.add(lblMatrcula);
		
	nameTextField = new JTextLimpar();
        nameTextField.setBounds(135, 68, 130, 26);
        contentPane.add(nameTextField);
        nameTextField.setColumns(10);
		
        matriculaTextField = new JTextLimpar();
	matriculaTextField.setBounds(135, 115, 130, 26);
	contentPane.add(matriculaTextField);
	matriculaTextField.setColumns(10);
		
	btnCadastrar = new JButton("Cadastrar");
	btnCadastrar.setBounds(274, 215, 117, 29);
        btnCadastrar.setBackground(Color.BLUE);
        btnCadastrar.setForeground(Color.WHITE);
	contentPane.add(btnCadastrar);
		
	btnLimpar = new JButton("Limpar");
	btnLimpar.setBounds(158, 215, 117, 29);
        btnLimpar.setBackground(Color.BLUE);
        btnLimpar.setForeground(Color.WHITE);
	contentPane.add(btnLimpar);
		
	btnExibir = new JButton("Exibir");
	btnExibir.setBounds(33, 215, 117, 29);
        btnExibir.setBackground(Color.BLUE);
        btnExibir.setForeground(Color.WHITE);
	contentPane.add(btnExibir);
        
        btnSortear = new JButton("Sortear");
	btnSortear.setBounds(403, 215, 117, 29);
        btnSortear.setBackground(Color.BLUE);
        btnSortear.setForeground(Color.WHITE);
	contentPane.add(btnSortear);
        
        btnFechar = new JButton("Fechar");
	btnFechar.setBounds(503, 215, 117, 29);
        btnFechar.setBackground(Color.BLUE);
        btnFechar.setForeground(Color.WHITE);
	contentPane.add(btnFechar);
        
	this.setButtonListeners();
        
        this.getContentPane().setBackground(Color.BLACK);
        
        lblMatrcula.setForeground(Color.WHITE);
        lblNome.setForeground(Color.WHITE);
    }
	
    private void setButtonListeners()
    {
        FuncionaraioController fController = new FuncionaraioController(nameTextField, matriculaTextField, jframe);

        btnCadastrar.addActionListener(fController);
        btnLimpar.addActionListener(fController);
        btnExibir.addActionListener(fController);
        btnSortear.addActionListener(fController);
        btnFechar.addActionListener(fController);
    }
}

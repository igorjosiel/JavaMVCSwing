package Controllers;

import Componentes.Arquivo;
import Componentes.JTextLimpar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Models.Funcionario;
import Views.AlertFrameCadastrar;
import Views.AlertFrameExibir;
import java.util.ArrayList;

import java.util.Random;
import javax.swing.JFrame;

public class FuncionaraioController implements ActionListener
{
    private JTextLimpar fName;
    private JTextLimpar fMatricula;
    
    private JFrame jframe;
    
    private Funcionario funcionario;
    
    private ArrayList<Funcionario> listFuncionarios;
    
    Random random = new Random();
	
    public FuncionaraioController(JTextLimpar name, JTextLimpar matricula, JFrame jframe)
    {
	this.fName = name;
	this.fMatricula = matricula;
        this.jframe = jframe;
        
        listFuncionarios = new ArrayList<Funcionario>();
    }
	
    @Override
    public void actionPerformed(ActionEvent e)
    {
        // TODO Auto-generated method stub
				
        System.out.print(e.getActionCommand());
		
        switch(e.getActionCommand())
        {
            case "Cadastrar": this.criarFuncionario();
            
            break;
            
            case "Limpar": this.limparFormulario();
		
            break;
		
            case "Exibir": this.exibirFuncionario();
			
            break;
            
            case "Sortear": this.sortearFuncionario();
			
            break;
            
            case "Fechar": this.fecharFuncionario();
            
            break;
		
            default: System.out.println("NADA");
	}	
    }
	
    public void criarFuncionario()
    {
	funcionario = new Funcionario(this.fName.getText(), Integer.parseInt(fMatricula.getText()));
		
        listFuncionarios.add(funcionario);
        
	Arquivo.WriteArquivo(funcionario);
    }
	
    public void limparFormulario()
    {
	this.fName.clear();
	this.fMatricula.clear();
    }
	
    public void exibirFuncionario()
    {
        if (listFuncionarios.isEmpty())
        {
            AlertFrameExibir alerta = new AlertFrameExibir();
            
            alerta.setVisible(true);
        }
        
        if (listFuncionarios.size() > 0)
        {
            this.fName.setText(this.funcionario.getName());
            this.fMatricula.setText(Integer.toString(this.funcionario.getMatricula()));
        }
    }

    private void sortearFuncionario()
    {
        int numero = 0;
        
        if (!listFuncionarios.isEmpty()) numero = random.nextInt(listFuncionarios.size());
            
        if (listFuncionarios.size() >= 2)
        {
            for (int i = 0; i < listFuncionarios.size(); i++)
            {
                if (i == numero)
                {
                    this.fName.setText(this.listFuncionarios.get(i).getName());
                    this.fMatricula.setText(Integer.toString(this.listFuncionarios.get(i).getMatricula()));
                }
            }
        }
        
        if (listFuncionarios.size() == 1)
        {
            AlertFrameCadastrar alerta = new AlertFrameCadastrar();
            
            alerta.setVisible(true);
        }
        
        if (listFuncionarios.isEmpty())
        {
            AlertFrameExibir alerta = new AlertFrameExibir();
            
            alerta.setVisible(true);
        }
    }

    private void fecharFuncionario()
    {
        jframe.dispose();
    }
}

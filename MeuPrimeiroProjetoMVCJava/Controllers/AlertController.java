
package Controllers;

import Models.Funcionario;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class AlertController implements ActionListener
{
    private JFrame fecharAlerta;
    
    public AlertController(JFrame fechaAlerta)
    {
        this.fecharAlerta = fechaAlerta;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {	
        if (e.getActionCommand().equals("Voltar"))
        {
            this.fecharAlerta.dispose();
	}
    }
}

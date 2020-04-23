package Models;

public class Funcionario
{
    private String name;
    private int matricula;
	
    public Funcionario(String name, int matricula)
    {
        this.name = name;
        this.matricula = matricula;
    }
	
    public String getName ()
    {
        return this.name;
    }
	
    public int getMatricula ()
    {
        return this.matricula;
    }
	
    public String toString()
    {
        return this.name + " - " + this.matricula;
    }
}

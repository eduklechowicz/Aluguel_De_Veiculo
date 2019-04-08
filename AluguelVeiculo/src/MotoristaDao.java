import java.util.ArrayList;

public class MotoristaDao
{
	private static ArrayList <Motorista> motoristas = new ArrayList <Motorista>();
	
	public static void inserir(Motorista motorista)
		{
			motoristas.add(motorista);
		}
	
	public static Motorista obterMotorista(int id, String cpf)
	{
		for (Motorista x : motoristas) 
		{
			if(x.getId() == id && x.getNome().equals(cpf))
			{
				return x;
			}
		}
		return null;
	}
}

import java.util.ArrayList;

public class ViagemDao 
{
	private static ArrayList <Viagem> viagens = new ArrayList <Viagem>();
	
	public static void inserir(Viagem viagem)
		{
			viagens.add(viagem);
		}
	
	public static Viagem obterViagem(String cpf, int id)
	{
		for (Viagem x : viagens) 
		{
			if(x.getCliente().getCpf().equals(cpf)&& x.getId() == id)
			{
				return x;
			}
		}
		return null;
	}
	
	public static Viagem obterViagens(int id)
	{
		for (Viagem x : viagens) 
		{
			if(x.getId() == id)
			{
				return x;
			}
		}
		return null;
	}
}

import java.util.ArrayList;

public class ClienteDao 
{
	
	private static ArrayList <Cliente> clientes = new ArrayList <Cliente>();
		
	public static void inserir(Cliente cliente)
		{
			clientes.add(cliente);
		}
	
	public static Cliente obterCliente(int id, String cpf)
	{
		for (Cliente x : clientes) 
		{
			if(x.getId() == id && x.getCpf().equals(cpf))
			{
				return x;
			}
		}
		return null;
	}
}

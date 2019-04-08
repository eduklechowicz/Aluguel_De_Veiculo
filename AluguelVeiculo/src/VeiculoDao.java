import java.util.ArrayList;

public class VeiculoDao 
{
	private static ArrayList <Veiculo> veiculos = new ArrayList <Veiculo>();
	
	public static void inserir(Veiculo veiculo)
		{
			veiculos.add(veiculo);
		}
	
	public static Veiculo obterVeiculo(int id, String placa)
	{
		for (Veiculo x : veiculos) 
		{
			if(x.getId() == id && x.getPlaca().equals(placa))
			{
				return x;
			}
		}
		return null;
	}
}


public class Principal 
{
	public static void main(String[] args) 
	{
		
		int opc;
		do{
			System.out.println("\n\n1 - Criar Motorista ");
			System.out.println("2 - Criar Veiculo ");
			System.out.println("3 - Criar Cliente ");
			System.out.println("4 - Criar Viagem: ");
			System.out.println("5 - Verificar Viagem: ");
			System.out.println("6 - Sair ");
			
			opc = Console.readInt("Opção: ");
			switch(opc)
			{
				case 1:
					cadastrarMotorista();
					break;
				case 2:
					cadastrarVeiculo();
					break;
				case 3:
					cadastrarCliente();
					break;
				case 4:
					cadastrarViagem();
					break;
				case 5:
					listarViagem();
					break;
			}
		}while(opc != 6);
	}
	
	private static void cadastrarMotorista()
	{
		System.out.println("\n\n");
		Motorista motorista = new Motorista();
		motorista.setId(Console.readInt("Id do Motorista: "));
		motorista.setCpf(Console.readString("CPF do Motorista: "));
		if(MotoristaDao.obterMotorista(motorista.getId(), motorista.getCpf()) == null)
		{
			motorista.setNome(Console.readString("Nome do Motorista: "));
			motorista.setCnh(Console.readString("Numero Da CNH: "));
			MotoristaDao.inserir(motorista);
		}
		else
		{
			System.out.println("Motorista Já Cadastrado");
		}
		
	}
	
	private static void cadastrarVeiculo()
	{
		System.out.println("\n\n");
		Veiculo veiculo = new Veiculo();
		veiculo.setId(Console.readInt("Id do Veiculo: "));
		veiculo.setPlaca(Console.readString("Placa do Veiculo: "));
		if(VeiculoDao.obterVeiculo(veiculo.getId(), veiculo.getPlaca()) == null)
		{
			veiculo.setNome(Console.readString("Nome do Veiculo: "));
			veiculo.setMarca(Console.readString("Marca do Veiculo: "));
			VeiculoDao.inserir(veiculo);
		}
		else
		{
			System.out.println("Veiculo Já Cadastrado");
		}
		
	}
	
	private static void cadastrarCliente()
	{
		System.out.println("\n\n");
		Cliente cliente = new Cliente();
		cliente.setId(Console.readInt("Id do Cliente: "));
		cliente.setCpf(Console.readString("CPF do Cliente: "));
		if(ClienteDao.obterCliente(cliente.getId(), cliente.getCpf()) == null)
		{
			cliente.setNome(Console.readString("Nome do Cliente: "));
			ClienteDao.inserir(cliente);
		}
		else
		{
			System.out.println("Cliente Já Cadastrado");
		}
		
	}
	
	private static void cadastrarViagem()
	{
		System.out.println("\n\n");
		Veiculo veiculo = new Veiculo();
		veiculo.setId(Console.readInt("Id do Veiculo: "));
		veiculo.setPlaca(Console.readString("Placa do Veiculo: "));
		veiculo = VeiculoDao.obterVeiculo(veiculo.getId(), veiculo.getPlaca());
		if(veiculo != null)
		{
			Cliente cliente = new Cliente();
			cliente.setId(Console.readInt("Id do Cliente: "));
			cliente.setCpf(Console.readString("CPF do Cliente: "));
			cliente = ClienteDao.obterCliente(cliente.getId(), cliente.getCpf());
			if(cliente != null)
			{
				Viagem viagem = new Viagem();
				viagem.setVeiculo(veiculo);
				viagem.setCliente(cliente);
				viagem.setId(Console.readInt("Id da Viagem: "));
				
				if(ViagemDao.obterViagem(viagem.getCliente().getCpf(), viagem.getId()) == null)
				{
					viagem.setData(Console.readString("Data da Viagem: "));
					viagem.setOrigem(Console.readString("Origem da Viagem: "));
					viagem.setDestino(Console.readString("Destino da Viagem: "));
					ViagemDao.inserir(viagem);
				}
				else
				{
					System.out.println("Viagem já Cadastrada");
				}
			}
			else
			{
				System.out.println("Cliente Não Cadastrado");
			}
		}
		else
		{
			System.out.println("Veiculo Não Cadastrado");
		}
	}
	
	private static void listarViagem()
	{
		System.out.println("\n\n");
		Viagem viagem = new Viagem();
		viagem.setId(Console.readInt("Id da Viagem: "));
		
		if((viagem = ViagemDao.obterViagens(viagem.getId()))!= null)
		{
			System.out.println("Nome: " + viagem.getCliente().getNome());
			System.out.println("CPF: " + viagem.getCliente().getCpf());
			System.out.println("Veiculo: " + viagem.getVeiculo().getNome());
			System.out.println("Marca: " + viagem.getVeiculo().getMarca());
			System.out.println("Placa: " + viagem.getVeiculo().getPlaca());
			System.out.println("Data: " + viagem.getData());
			System.out.println("Origem: " + viagem.getOrigem());
			System.out.println("Destino: " + viagem.getDestino());
			
		}
		else
		{
			System.out.println("\n\n Dados Não Cadastrados");
		}
		
	}
}

    import static java.lang.Integer.parseInt;
	import static javax.swing.JOptionPane.showInputDialog;
	import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JOptionPane;

import static javax.swing.JOptionPane.*;

	import static java.lang.Integer.*;

	public class Principal {
		 public static void main(String[] args) {
			Reserva[] clientes = new Reserva[10];
			int posicao = 0;
			int opcao;

			do {
				opcao = parseInt(showInputDialog(GerarMenus()));
				if (opcao < 1 || opcao > 6) {
					showMessageDialog(null, " !opção inválida! ");
				} else {
					switch (opcao) {
					case 1:
					
						Reserva reserva  = reservarMesa();
						
						clientes[posicao] = reserva;
						posicao++;
						break;
					
				
					case 2:
						pesquisar(clientes, posicao);
						break;
					
					
					case 3:
					
					 listar(clientes, posicao);
					 
					 break;
					
					case 4:
						 listadeespera(clientes,posicao);
						
						break;
						
					case 5:
						remover(clientes, posicao);
					 break;
					
					case 6:
						
						break;
					
					
					
					}
				
				}

			}

			while (opcao != 6);

		}

		public static String GerarMenus() {
			String aux = "Escolha uma opção\n";
			aux += " 1. reservar mesa\n";
			aux += " 2. pesquisar reserva\n";
			aux += " 3. imprimir reservas\n";
			aux += " 4. imprimir lista de espera\n";
			aux += " 5. cancelar reserva\n";
			aux += " 6. finalizar";
			return aux;
		}

		public static int LocalizarCPF(Reserva[] clientes, int posicao, String cpf) {
			int posicao_aux = -1;
			for (int i = 0; i < posicao; i++) {
				if (clientes[i].getCpf().equalsIgnoreCase(cpf))
					;
				posicao_aux = i;
				break;
			}

			return posicao_aux;
		}

		public static void pesquisar(Reserva[] clientes, int posicao) {
			String cpf = showInputDialog("informe o CPF do cliente");
			int posicao_aux = LocalizarCPF(clientes, posicao, cpf);
			if (posicao_aux == -1) {
				showMessageDialog(null, cpf + " não foi encontrado");
			} else {
				showMessageDialog(null, clientes[posicao_aux].GetDados());
			    if(posicao > 4) {
			    	
			    	showMessageDialog(null, "Você está na lista de espera! ");
			    }
			
			
			}
		}


	    public static void listar(Reserva[] clientes, int posicao) {
		String aux = "";
		for (int g = 0; g < 5; g++) {
			aux += clientes[g].GetDados() + "\n";
		
		}
		showMessageDialog(null, aux);

	}




	 public static int remover(Reserva[] clientes, int posicao) {
		String cpf = showInputDialog("informe o CPF do cliente que será removido");
		int posicao_aux = LocalizarCPF(clientes,posicao, cpf);
		if(posicao_aux == -1) {
			showMessageDialog(null,cpf +" não foi encontrado");
		} else {
			for(int i = posicao_aux; i< posicao; i++) {
				clientes[i] = clientes[i+1];
			}
		posicao--;
		
		}
		 return posicao;	
	}

	public static void listadeespera(Reserva[] clientes, int posicao) {
		String aux = "";
		for (int g = 5; g > 4 && g < 10 ; g++) {
			aux += clientes[g].GetDados() + "\n";
		
		}
		showMessageDialog(null, aux);

	}
	
	private static String inputTipoPessoa() {
        String tipoPessoa = null;
        while (tipoPessoa == null) {
            tipoPessoa = showInputDialog("pessoa Juridica (J) ou pessoa Fisica (F)");
            if (!"f".equals(tipoPessoa) && !"j".equals(tipoPessoa)) {
                tipoPessoa = null;
                System.out.println("Opcao invalida, aceito apenas f ou j");
            }
        }
        return tipoPessoa;
    }
	private static PessoaFisica cadastrarPF(String nome) {
        System.out.print(" CPF: ");
        String cpf = showInputDialog("insira o CPF");
        PessoaFisica pf = new PessoaFisica(nome,cpf);
        
        return  pf;
    }

    private static PessoaJuridica cadastrarPJ(String nome) {
        System.out.print("CNPJ: ");
        String cnpj = showInputDialog("insira o CNPJ");
        PessoaJuridica pj = new PessoaJuridica(nome,cnpj);
        
        return pj;
    }
     public static Reserva reservarMesa() {
        
        Reserva reserva = null;
        Cliente cliente = null;
        String nome = showInputDialog("informe o  seu nome");
        String tipoPessoa = inputTipoPessoa();
        switch (tipoPessoa) {
            case "j":
                cliente = cadastrarPJ(nome);
                break;
            case "f":
                cliente = cadastrarPF(nome);
                break;
        } 
       int pagamento = parseInt("informe a forma de pagamento! 1- debito / 2- parcelado");
        
        reserva = new Reserva(cliente, pagamento);
      
        return reserva ;
     }
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

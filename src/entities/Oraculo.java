package entities;

import java.util.Random;
import java.util.Scanner;

import lib.InOut;

/**
 *
 * @author alunolab08
 */
    public class Oraculo {
    String nome;
    Guerreiro warrior;
    
    public Oraculo(String nome) {
        this.nome = nome;
    }
    
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public Guerreiro getGuerreiro() {
        return warrior;
    }

    public int sortearNumeroSecreto() {
        Random rand = new Random();
        int numeroSecreto = rand.nextInt(100) + 1;
        return numeroSecreto;
    }
    
	public void prologoIntroducao() {
		// Crie uma instância do Oráculo com o nome do Guerreiro
        this.warrior = InOut.returnGerreiro();
        // Exibe o estado inicial do Guerreiro
        InOut.MsgDeInformacao("Bem-vindo, Guerreiro " + this.warrior.getNome() + "!", "Número de vidas do Guerreiro: " + this.warrior.getVidas());
	}
	
	private void prologoPerdedor() {
        InOut.MsgDeInformacao("Lamento Guerreiro", "Não foi dessa vez, tente mais tarde!!!");
	}
	private void prologoVencedor() {
        InOut.MsgDeInformacao("Boa Guerreiro", "Sempre acreditei em seu potencial!!");
	}
    
    public boolean decidirVidaExtra(String pedido) {
    	String[] quantPalavras = pedido.split(" ");
    	return quantPalavras.length > 5;
    }
    
	private int gerarNumeroSecreto() {
	        Random random = new Random();
	        return random.nextInt(100) + 1;
	    }

	    // Leia o palpite do jogador a partir do teclado
	    private static int lerPalpite() {
	        int valor = InOut.leInt("Digite seu Palpite");
	        return valor;
	    }
	
	     public boolean loadLevel1() {
	    	 int numeroSecreto = this.gerarNumeroSecreto();
	    	 int vidas = this.warrior.getVidas();
	         boolean acertou = false;
	    	 while (vidas > 0) {
	    		 int palpite = this.lerPalpite();
	    		 if (palpite == numeroSecreto) {
	                 this.prologoVencedor();
	                 acertou = true;
	                 break;
	             } else if (palpite < numeroSecreto) {
	            	 InOut.MsgDeInformacao("Quase lá ...", "Dica: O número secreto é MAIOR.");
	             } else {
	            	 InOut.MsgDeInformacao("Quase lá ...","Dica: O número secreto é MENOR.");
	             }
	             vidas--;
	             System.out.println("Você tem " + vidas + " vidas restantes.");
	    	 }
	    	 if(!acertou) this.prologoPerdedor();
	    	return acertou;
	     }
	     
	     public boolean loadLevel2(int opcao) {
	         Random random = new Random();
	         int numeroGuerreiro = random.nextInt(6); // Gere um número entre 0 e 5 para o Guerreiro
	         int numeroOraculo = random.nextInt(6); // Gere um número entre 0 e 5 para o Oráculo

	         InOut.MsgDeInformacao("Número do Guerreiro: " , "Numero=>"+numeroGuerreiro);
	         InOut.MsgDeInformacao("Número do Oráculo: " , "Numero=>"+numeroOraculo);

	         int soma = numeroGuerreiro + numeroOraculo;
	         boolean resultadoPar = (soma % 2 == 0); // Verifica se a soma é par

	         InOut.MsgDeInformacao("Soma", "Valor da soma: "+ soma);

	         // Verifique se o Guerreiro escolheu PAR (opcao=1) e a soma é par, ou se escolheu ÍMPAR (opcao=2) e a soma é ímpar
	         if ((opcao == 1 && resultadoPar) || (opcao == 2 && !resultadoPar)) {
	             return true; // O Guerreiro venceu
	         } else {
	             return false; // O Guerreiro perdeu
	         }
	     }

    
    }

        

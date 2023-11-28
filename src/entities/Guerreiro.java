package entities;

import java.util.Random;

import lib.InOut;

public class Guerreiro {
    String nome;
    int vidas;

    public Guerreiro(String nome) {
    	Random rand = new Random();
        this.nome = nome;
        this.vidas = rand.nextInt(4) + 9;
    }
    
    public boolean vidaExtra(Oraculo oraculo) {
        InOut.MsgDeInformacao("Guerreiro " + nome , "Você pediu uma vida extra.");
        String misericordia = InOut.leString("Escreva sua misericordia");
        boolean concedida = oraculo.decidirVidaExtra(misericordia);
        if (concedida) {
        	InOut.MsgDeInformacao("Boa Guerreiro","Vida extra concedida. Agora você tem 1 vida.");
        	this.vidas = 1;
        } else {
        	InOut.MsgDeInformacao("Fim da linha ...","Desculpe, seu pedido de vida extra foi negado.");
        }
        
        return concedida;
    }

    public void getGuerreiro(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setVidas(int vidas) {
    	this.vidas = vidas;
    }

    public int getVidas() {
        return vidas;
    }
}

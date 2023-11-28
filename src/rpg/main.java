package rpg;

import entities.Oraculo;
import lib.InOut;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Oraculo oraculo = new Oraculo("Oraculo Mestre");
		oraculo.prologoIntroducao();
		

		if(!oraculo.loadLevel1()) {
			oraculo.getGuerreiro().vidaExtra(oraculo);
			oraculo.loadLevel1();
		}

		if(oraculo.getGuerreiro().getVidas()>0) {
			int opcao = InOut.leInt("Digite sua opção");
			oraculo.loadLevel2(opcao);
		}

	}

}

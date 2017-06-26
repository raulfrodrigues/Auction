package codigo;

import java.math.BigDecimal;
import java.util.ArrayList;

import deprecated.Bid;

public class LeilaoDemanda implements LeilaoStrategy {

	@Override
	public Bid getVencedor(ArrayList<Bid> lances) {
		if (lances.size() == 0) return null;
		Bid maiorLance = lances.get(0);
		for(int i = 1; i<lances.size();i++){
			if (lances.get(i).getValor().compareTo( maiorLance.getValor()) > 0)
				maiorLance = lances.get(i);
		}
		return maiorLance;
	}
	
	public String valorBase(){
		return "Valor Mínimo";
	}
	
	public String tipoLeilao(){
		return "Leilão Demanda";
	}

	@Override
	public void cadastraLance(ArrayList<Bid> lances, String cpf, BigDecimal valor, BigDecimal valorBase) {
		if(valor.compareTo(valorBase) >= 0) lances.add(new Bid(cpf, valor));
	}
}

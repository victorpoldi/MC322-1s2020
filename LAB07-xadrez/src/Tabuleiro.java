import java.util.ArrayList;

public class Tabuleiro {

	ArrayList<Peca> pecas = new ArrayList<Peca>();
	
	private char[][] tab = {{'-','-','-','-','-','-','-','-'},
							{'-','-','-','-','-','-','-','-'},
							{'-','-','-','-','-','-','-','-'},
							{'-','-','-','-','-','-','-','-'},
							{'-','-','-','-','-','-','-','-'},
							{'-','-','-','-','-','-','-','-'},
							{'-','-','-','-','-','-','-','-'},
							{'-','-','-','-','-','-','-','-'}};

	public void printTabuleiro(){
		for (int i = 0; i <= 7; i++){
			System.out.print(8-i+" ");
			for (int j = 0; j <= 7; j++){
				System.out.print(tab[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("  a b c d e f g h");
	}
	
	public ArrayList<Peca> getPecas(){
		return pecas;
	}
	
	public char[][] getTab() {
		return tab;
	}

	public void criarPecas() {
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				if (i == 0) {
					if (j == 0 || j == 7){
						Peca torreP = new Torre();
						torreP.setX(j);
						torreP.setY(i);
						torreP.converterIntEmString(j, i, torreP);
						torreP.setCor('T');
						torreP.setTab(this);
						pecas.add(torreP);
					}
					if (j == 1 || j == 6){
						Peca cavaloP = new Cavalo();
						cavaloP.setX(j);
						cavaloP.setY(i);
						cavaloP.converterIntEmString(j, i, cavaloP);
						cavaloP.setCor('H');
						cavaloP.setTab(this);
						pecas.add(cavaloP);
					}
					if (j == 2 || j == 5){
						Peca bispoP = new Bispo();
						bispoP.setX(j);
						bispoP.setY(i);
						bispoP.converterIntEmString(j, i, bispoP);
						bispoP.setCor('B');
						bispoP.setTab(this);
						pecas.add(bispoP);
					}
					if (j == 3){
						Peca rainhaP = new Rainha();
						rainhaP.setX(j);
						rainhaP.setY(i);
						rainhaP.converterIntEmString(j, i, rainhaP);
						rainhaP.setCor('Q');
						rainhaP.setTab(this);
						pecas.add(rainhaP);
					}
					if (j == 4){
						Peca reiP = new Rei();
						reiP.setX(j);
						reiP.setY(i);
						reiP.converterIntEmString(j, i, reiP);
						reiP.setCor('K');
						reiP.setTab(this);
						pecas.add(reiP);
					}
				}
				if (i == 1) {
					Peca peaoP = new Peao();
					peaoP.setX(j);
					peaoP.setY(i);
					peaoP.converterIntEmString(j, i, peaoP);
					peaoP.setCor('P');
					pecas.add(peaoP);
				}
				if (i == 7) {
					if (j == 0 || j == 7){
						Peca torreB = new Torre();
						torreB.setX(j);
						torreB.setY(i);
						torreB.converterIntEmString(j, i, torreB);
						torreB.setCor('t');
						pecas.add(torreB);
					}
					if (j == 1 || j == 6){
						Peca cavaloB = new Cavalo();
						cavaloB.setX(j);
						cavaloB.setY(i);
						cavaloB.converterIntEmString(j, i, cavaloB);
						cavaloB.setCor('h');
						pecas.add(cavaloB);
					}
					if (j == 2 || j == 5){
						Peca bispoB = new Bispo();
						bispoB.setX(j);
						bispoB.setY(i);
						bispoB.converterIntEmString(j, i, bispoB);
						bispoB.setCor('b');
						pecas.add(bispoB);
					}
					if (j == 3){
						Peca rainhaB = new Rainha();
						rainhaB.setX(j);
						rainhaB.setY(i);
						rainhaB.converterIntEmString(j, i, rainhaB);
						rainhaB.setCor('q');
						pecas.add(rainhaB);
					}
					if (j == 4){
						Peca reiB = new Rei();
						reiB.setX(j);
						reiB.setY(i);
						reiB.converterIntEmString(j, i, reiB);
						reiB.setCor('k');
						pecas.add(reiB);
					}
				}
				if (i == 6) {
					Peca peaoB = new Peao();
					peaoB.setX(j);
					peaoB.setY(i);
					peaoB.converterIntEmString(j, i, peaoB);
					peaoB.setCor('p');
					pecas.add(peaoB);
				}
			}
		}
	}
	
	public void adicionarPecasNoTab() {
		for (int i = 0; i<pecas.size(); i++) {
			tab[pecas.get(i).getY()][pecas.get(i).getX()] = pecas.get(i).getCor();
//			System.out.println(pecas.get(i).getX() + " " + pecas.get(i).getY());
		}
	}

	public Peca findPeca(String posicao) {
		for (Peca peca : pecas) {
			if (peca.getPosicao().equals(posicao)) {
				return peca;
			}
		}
		return null;	
	}
	
	public void moverPecas(String movimento) {
		String source = String.valueOf(movimento.charAt(0)) + String.valueOf(movimento.charAt(1));
		String target = String.valueOf(movimento.charAt(3)) + String.valueOf(movimento.charAt(4));
		System.out.println("Source: "+ source);
		System.out.println("Target: "+ target);
		Peca pecaAtual = findPeca(source);
		Peca pecaAtacada = findPeca(target);
		if (pecaAtual != null) {
			if (pecaAtual.verifMov(target)) {
				tab[pecaAtual.getY()][pecaAtual.getX()] = '-';
				pecaAtual.setPosicao(target);
				pecaAtual.converterStringEmInt(target.charAt(0), target.charAt(1), pecaAtual);
				if (pecaAtacada != null && pecaAtual.verifInimigo(pecaAtacada)) {
					pecas.remove(pecaAtacada);
//				System.out.println("capturou");
				}
			}
		}
	}
}

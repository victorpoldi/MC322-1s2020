public class Peca {
	
	private Tabuleiro tab;
	
	private String posicao;
	private int x, y;
	private char cor;
	
	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao){
		this.converterStringEmInt(posicao.charAt(0), posicao.charAt(1), this);
		this.posicao = posicao;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public char getCor() {
		return cor;
	}

	public void setCor(char cor) {
		this.cor = cor;
	}
	
	public Tabuleiro getTab() {
		return tab;
	}

	public void setTab(Tabuleiro tab) {
		this.tab = tab;
	}

	public void converterIntEmString(int x, int y, Peca peca) {
		char c1 = '-';
		char c2 = '-';
		if (x == 0) c1 = 'a';
		if (x == 1) c1 = 'b';
		if (x == 2) c1 = 'c';
		if (x == 3) c1 = 'd';
		if (x == 4) c1 = 'e';
		if (x == 5) c1 = 'f';
		if (x == 6) c1 = 'g';
		if (x == 7) c1 = 'h';
		if (y == 0) c2 = '8';
		if (y == 1) c2 = '7';
		if (y == 2) c2 = '6';
		if (y == 3) c2 = '5';
		if (y == 4) c2 = '4';
		if (y == 5) c2 = '3';
		if (y == 6) c2 = '2';
		if (y == 7) c2 = '1';
		peca.setPosicao(String.valueOf(c1) + String.valueOf(c2));
//		System.out.println(String.valueOf(c1) + String.valueOf(c2));
	}
	
	public void converterStringEmInt(char c1, char c2, Peca peca) {
		if (c1 == 'a') peca.setX(0);
		if (c1 == 'b') peca.setX(1);
		if (c1 == 'c') peca.setX(2);
		if (c1 == 'd') peca.setX(3);
		if (c1 == 'e') peca.setX(4);
		if (c1 == 'f') peca.setX(5);
		if (c1 == 'g') peca.setX(6);
		if (c1 == 'h') peca.setX(7);
		if (c2 == '1') peca.setY(7);
		if (c2 == '2') peca.setY(6);
		if (c2 == '3') peca.setY(5);
		if (c2 == '4') peca.setY(4);
		if (c2 == '5') peca.setY(3);
		if (c2 == '6') peca.setY(2);
		if (c2 == '7') peca.setY(1);
		if (c2 == '8') peca.setY(0);
	}

	public boolean verifMov(String target) {
//		if letra diferete de a a h ou numero mairo q 8
		return true;
	}
	
	public boolean verifInimigo(Peca pecaAtacada) {
		if (this.cor == 'P' || this.cor == 'T' || this.cor == 'H'
		 || this.cor == 'B' || this.cor == 'Q' || this.cor == 'K') {
			if (pecaAtacada.cor == 'p' || pecaAtacada.cor == 't' || pecaAtacada.cor == 'h' 
			 || pecaAtacada.cor == 'b' || pecaAtacada.cor == 'q' || pecaAtacada.cor == 'k') {
				return true; 
			} else {
				return false;
			}
		} else {
			if  (pecaAtacada.cor == 'p' || pecaAtacada.cor == 't' || pecaAtacada.cor == 'h' 
			  || pecaAtacada.cor == 'b' || pecaAtacada.cor == 'q' || pecaAtacada.cor == 'k'){
				return false;
			} else {
				return true;
			}
		}
	}
	
}

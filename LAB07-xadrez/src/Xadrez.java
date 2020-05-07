public class Xadrez {
	public static void main(String[] args) {

		//testarPecas();
		
		Tabuleiro t = new Tabuleiro();
		
		CSVReader csv = new CSVReader();
		csv.setDataSource("C:/Users/Acer/Downloads/CSV_lab.csv");
		String[] mov = csv.requestCommands();
			
		t.criarPecas();
		t.adicionarPecasNoTab();
		
		System.out.println("Tabuleiro Inicial");
		t.printTabuleiro();
		
		for (int i = 0; i < mov.length; i++) {
			t.moverPecas(mov[i]);
			t.adicionarPecasNoTab();
			t.printTabuleiro();
		}
	}

//	private static void testarPecas() {
//		Peao p1 = new Peao();
//		p1.setPosicao("a2");
//		System.out.println(p1.verifMov("a3") == true);
//		Peao p2 = new Peao();
//		p2.setPosicao("a2");
//		System.out.println(p2.verifMov("a1") == false);		
//	}
}

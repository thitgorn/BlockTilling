import java.util.Random;

public class App {
	App(int square) {
		Random rand = new Random();
		Table table = new Table(square);
		table.setHole(rand.nextInt(square), rand.nextInt(square));
		new Tiling(table);
	}

	public static void main(String[] args) {
		// Enter Size of table
		new App(64);
	}
}

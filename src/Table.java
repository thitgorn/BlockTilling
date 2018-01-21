import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Table extends JFrame {
	private static final long serialVersionUID = 1L;
	private int wh;
	public Block[][] table;

	public Table(int wh) {
		this.wh = wh;
		this.setLayout(new GridLayout(wh, wh));
		table = new Block[wh][wh];

		initComponent();
		

		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initComponent() {
		for (int i = 0; i < wh; i++) {
			for (int j = 0; j < wh; j++) {
				Block temp = new Block(wh);
				table[i][j] = temp;
				this.add(temp);
			}
		}
	}

	public void setHole(int i, int j) {
		table[i][j].paintBlock(Color.BLACK);
	}
}

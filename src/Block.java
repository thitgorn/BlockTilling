import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Block extends JPanel {
	private static final long serialVersionUID = 1L;
	private boolean paint = false;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private Dimension preferSize = new Dimension(screenSize.width / 2, screenSize.height / 2);

	public Block(int wh) {
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setPreferredSize(new Dimension(preferSize.width / wh, preferSize.height / wh));
		this.setBackground(Color.white);
	}

	public void paintBlock(Color color) {
		this.setBackground(color);
		this.paint = true;
	}

	public boolean isPaint() {
		return this.paint;
	}
}

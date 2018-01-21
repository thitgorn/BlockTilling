import java.awt.Color;
import java.util.Random;

import javax.swing.BorderFactory;

public class Tiling {
	private Table board;

	public Tiling(Table board) {
		this.board = board;
		solve(0, 0, board.table.length, board.table.length);
	}

	private void solve(int fromX, int fromY, int width, int height) {
		if (width == 1)
			return;

		Color rand = createRandomColor();

		boolean q1, q2, q3, q4;
		q1 = q2 = q3 = q4 = false;

		loop: {
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					if (board.table[i + fromX][j + fromY].isPaint()) {
						int firstCondition = (i + fromX) / ((height / 2) + fromX);
						int secondCondition = (j + fromY) / ((width / 2) + fromY);
						if ((firstCondition < 1) && (secondCondition < 1))
							q1 = true;

						else if ((firstCondition < 1) && (secondCondition >= 1))
							q2 = true;

						else if ((firstCondition >= 1) && (secondCondition < 1))
							q3 = true;

						else if ((firstCondition >= 1) && (secondCondition >= 1))
							q4 = true;

						break loop;
					}
				}
			}
		}

		int[][] dif = null;
		int firstPlaceX = (height / 2) + fromX;
		int firstPlaceY = (width / 2) + fromY;

		if (q1) {
			dif = new int[][] { { 0, 0 }, { -1, 0 }, { 0, -1 } };
			board.table[firstPlaceX][firstPlaceY].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
			board.table[firstPlaceX - 1][firstPlaceY]
					.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
			board.table[firstPlaceX][firstPlaceY - 1]
					.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
		}
		if (q2) {
			dif = new int[][] { { 0, 0 }, { -1, -1 }, { 0, -1 } };
			board.table[firstPlaceX][firstPlaceY].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
			board.table[firstPlaceX - 1][firstPlaceY - 1]
					.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
			board.table[firstPlaceX][firstPlaceY - 1]
					.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, Color.BLACK));
		}
		if (q3) {
			dif = new int[][] { { 0, 0 }, { -1, 0 }, { -1, -1 } };
			board.table[firstPlaceX][firstPlaceY].setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
			board.table[firstPlaceX - 1][firstPlaceY]
					.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 1, Color.BLACK));
			board.table[firstPlaceX - 1][firstPlaceY - 1]
					.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));

		}
		if (q4) {
			dif = new int[][] { { -1, -1 }, { -1, 0 }, { 0, -1 } };
			board.table[firstPlaceX-1][firstPlaceY-1].setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.BLACK));
			board.table[firstPlaceX-1][firstPlaceY].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
			board.table[firstPlaceX][firstPlaceY-1].setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
		}

		for (int[] d : dif) {
			board.table[firstPlaceX + d[0]][firstPlaceY + d[1]].paintBlock(rand);
		}

		int nextX1 = 0 + fromX;
		int nextX2 = (width / 2) + fromX;
		int nextY1 = 0 + fromY;
		int nextY2 = height / 2 + fromY;

		solve(nextX1, nextY1, width / 2, height / 2);
		solve(nextX2, nextY1, width / 2, height / 2);
		solve(nextX1, nextY2, width / 2, height / 2);
		solve(nextX2, nextY2, width / 2, height / 2);
	}

	private Color createRandomColor() {
		Random rand = new Random();
		int r = rand.nextInt(256);
		int g = rand.nextInt(256);
		int b = rand.nextInt(256);
		return new Color(r, g, b);
	}
}

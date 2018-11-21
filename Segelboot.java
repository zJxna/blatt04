/******************************************************************************
 *  Compilation:  javac Segelboot.java
 *  Execution:    java Segelboot
 *
 *  Eingabe: Keine
 *  Ausgabe: Die Zeichnung eines Segelboots.
 * 
 * 
 ******************************************************************************/

public class Segelboot {
	public static void main(String args[]) {
		double boot_x[] = {
			1,
			6,
			5,
			2
		};
		double boot_y[] = {
			2,
			2,
			1,
			1
		};
		double segel_x[] = {
			1.5,
			3.5,
			3.5
		};
		double segel_y[] = {
			3,
			5.5,
			3
		};

		StdDraw.setScale(0, 7);

		// Boot zeichnen
		StdDraw.polygon(boot_x, boot_y);

		// Segel zeichnen
		StdDraw.polygon(segel_x, segel_y);

		// Rest des Fahnenmasts zeichnen
		StdDraw.line(3.5, 2, 3.5, 3);
	}
}

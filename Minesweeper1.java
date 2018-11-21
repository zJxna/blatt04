/******************************************************************************
 *  Compilation:  javac Minesweeper1.java
 *  Execution:    java Minesweeper1 f00 f01 ... f0n f10 f11 ... f1n ... fn0 ... fnn
 *
 *  Eingabe: Eine zeilenweise angeordnete quadratische Matrix. 
 *           Die Werte der Matrix sind 0 (keine Mine) oder 1 (Mine)
 *  Ausgabe: Eine gleichgrosse Matrix von ganzen Zahlen, die die Anzahl 
 *           der Minen in der Umgebung angibt. Felder, die selber eine Mine 
 *           beinhalten haben den Wert -1
 *
 *  Beispiel: 
 *  Eingabefeld
 *           ------     
 *           |    |
 *           |    |
 *           |  * |
 *           |  * |
 *           ------     
 * 
 
 $ java Minesweeper1 0 0 0 0 \ 
                     0 0 0 0 \
                     0 0 1 0 \
                     0 0 1 0
 0 0 0 0
 0 1 1 1
 0 2 -1 2
 0 2 -1 2 

 * Hinweis: Mit \ kann man in der Shell mehrzeilige Befehle eingaben.
 * Der Aufruf oben ist aequivalent zu:  
 $ java Minesweeper1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0
 * 
 * Sie koennen davon ausgehen, dass das Programm immer mit korrekten Eingaben aufgerufen wird.
 * 
 ******************************************************************************/

public class Minesweeper1 {
	public static void main(String[] args) {
		// Groesse der Matrix bestimmen
		int n = (int) Math.sqrt(args.length);
		int[][] input = new int[n][n];
		int[][] output = new int[n][n];

		// Matrix einlesen 
		for (int z = 0; z < n; z++) {
			for (int s = 0; s < n; s++) {
				input[z][s] = Integer.parseInt(args[z * n + s]);
			}
		}

		// Nachbarn ausrechnen
		for (int z = 0; z < n; z++) {
			for (int s = 0; s < n; s++) {
				if (input[z][s] == 1) {
					output[z][s] = -1;
				} else {
					int count = 0;
					for (int i = z - 1; i <= z + 1; i++) {
						for (int j = s - 1; j <= s + 1; j++) {
							if (i < n && i >= 0 && // zeile ist gueltig
							        j < n && j >= 0 && // spalte ist gueltig
							        input[i][j] == 1) {
								count++;
							}
						}
					}

					output[z][s] = count;
				}
			}
		}

		// Matrix ausgeben 
		for (int z = 0; z < n; z++) {
			for (int s = 0; s < n - 1; s++) {
				System.out.print(output[z][s]);
				System.out.print(" ");
			}
			System.out.println(output[z][n - 1]);
		}
	}
}

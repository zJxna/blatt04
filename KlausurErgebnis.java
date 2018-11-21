/******************************************************************************
   Compilation:  javac KlausurErgebnis.java
   Execution:    java KlausurErgebnis gesamtpunkte
 
   Eingabe: Die Eingabe besteht mindestens aus einem Integerwert, der die 
			maximal erreichbare Punktzahl der Klausur darstellt.
            Dieser Wert wird als Parameter bei Programmstart uebergeben.
            
            Zur Laufzeit bekommt das Programm maximal 100 Datensätze. Diese
            sollen von der Standardeingabe eingelesen werden. Ein Datensatz
            besteht aus dem Login (ein String unbekannter Laenge) und der 
            erreichten Punktzahl (die kleiner oder gleich der maximalen 
            Punktzahl ist).
            
            Die Eingabe wird entweder durch das Erreichen der maximalen Anzahl 
            oder durch die EOF-Sequenz beendet. 

   Ausgabe: Eine Tabelle mit den Spalten Login, Punkte, Prozent und bestanden. 

             - Login und Punkte sind die urspruenglichen Eingaben.
             - Prozent wird durch Division der Punkte des Studierenden durch die 
               Gesamtpunktzahl berechnet und soll genau gespeichert werden. Fuer
               die Ausgabe soll der Wert mit 100 multipliziert und auf eine 
               Nachkommastelle genau ausgegeben werden.
             - In dem Feld bestanden soll "ja" stehen, wenn die Punktzahl
               groesser oder gleich der Haelfte der Gesamtpunktzahl ist.
               Ansonsten soll dort "nein" stehen.
 
            Texte sollen linksbuendig, Zahlen sollen rechtsbuendig untereinander,
            wie in dem Beispiel unten und den Tests, formatiert ausgegeben 
            werden.

   Hinweise: Verwenden Sie StdIn zum Einlesen und StdOut.printf zum Ausgeben der 
             Werte. Sie koennen Arrays verwenden um die Eingaben vor der 
             Verarbeitung zwischenzuspeichern.

             Die Laenge eines Strings koennen sie mit length() feststellen. 
 
               String s = "foo";
               System.out.println(s.length());
 
             gibt 3 aus. Beachten Sie den Unterschied zur Laenge von Arrays:

               int[] a = {1,2,3};
               System.out.println(a.length);
 
   Beispiel:
  
 $ java KlausurErgebnis 50 < input.txt

 Login       Punkte Prozent bestanden
 bendisposto     20    40.0 nein
 jahaa           30    60.0 ja
 studi100        50   100.0 ja


 ******************************************************************************/
public class KlausurErgebnis {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("ERROR");
			return;
		}

		int gesamt = Integer.parseInt(args[0]);
		if (gesamt < 0) {
			System.out.println("ERROR");
			return;
		}

		String[] login = new String[100];
		int[] punkte = new int[100];
		double[] percent = new double[100];
		boolean[] zugelassen = new boolean[100];

		int count = 0;
		int maxlen = "Login".length();

		// Einlesen der Daten 
		do {
			login[count] = StdIn.readString();
			punkte[count] = StdIn.readInt();

			// Laengsten String finden
			if (login[count].length() > maxlen) maxlen = login[count].length();

			// Berechnen der abgeleiteten Spalten
			percent[count] = 100 * punkte[count] / (double) gesamt;
			zugelassen[count] = punkte[count] >= gesamt / 2;
			count++;
		} while (! StdIn . isEmpty () && count < 100);

		// Ausgabe der Daten
		String format = "%-" + (maxlen) + "s ";
		StdOut.printf(format, "Login");
		StdOut.print("Punkte ");
		StdOut.print("Prozent ");
		StdOut.println("bestanden");

		for (int i = 0; i < count; i++) {
			StdOut.printf("%-" + (maxlen + 1) + "s", login[i]);
			StdOut.printf("%6d", punkte[i]);
			StdOut.printf("%8.1f", percent[i]);
			if (zugelassen[i]) {
				StdOut.println(" ja");
			}
			else {
				StdOut.println(" nein");
			}
		}
	}
}

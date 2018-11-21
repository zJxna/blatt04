/******************************************************************************
 *  Compilation:  javac RemoveDuplicates.java
 *  Execution:    java RemoveDuplicates
 *
 *  Eingabe: Es werden keine Werte als Argumente beim Start übergeben. 
             Das Programm soll so lange Integer Werte von der Standardeingabe lesen,
             bis die EOF-Sequenz erreicht ist. 

 *  Ausgabe: Die Zahlenfolge, bei der alle Duplikate entfernt wurden.
 *
 *  Hinweise: Verwenden Sie StdIn zum Einlesen der Werte. Sie koennen davon ausgehen, 
 *            dass mindestens ein Wert eingegeben wird. Die Ausgabe soll erst erfolgen, 
 *            wenn die EOF-Sequenz gelesen wurde, sie koennen die Ausgabe in einem 
 *            String zwischenspeichern.
 *
 *  Beispiel:
 * 
 $ echo 1 1 2 2 1 1 3 4 6 2 1 | java RemoveDuplicates
 1 2 1 3 4 6 2 1

 ******************************************************************************/

public class RemoveDuplicates {
   public static void main(String[] args) {
      int[] input = StdIn.readAllInts();
      
      StdOut.print(input[0]);

      for(int i=1; i<input.length; i++) {
         if (input[i] != input[i-1]) {
            StdOut.printf(" %d", input[i]);
         }
      }

      StdOut.println();

/*  
      // Alternative Loesung:
      String ausgabe = "";
      int last = StdIn.readInt(); 
    
      ausgabe = ausgabe + last;

      while (!StdIn.isEmpty()) {
         int v = StdIn.readInt();
         if (v != last) { ausgabe = ausgabe + " " + v; }
         last = v;
      }
      System.out.println(ausgabe); 
*/
   }
}


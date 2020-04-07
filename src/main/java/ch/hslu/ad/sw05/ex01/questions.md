Reflektionsfragen: 

1) Die Zeichnungsmethode des Canvas. Alle Bälle zeichnen in dasselbe Canvas und möglicherweise gleichzeitig, um die auszuschliessen wurden die Zeichnungsmethoden synchronized definiert.

2) Es werden verschiedenste Bälle gezeichnet und es scheint als würden sie gleichzeitzig nach unten fallen, dies ist jedoch nicht 100% korrekt, denn wie zuvor erwähnt kann sich immer nur ein Thread in der Zeichnungsmehtode aufhalten. Des Weiteren erkennt man, dass sich die Bälle immer wieder neu überlappen, dies ist auf denselben Grund zurückzuführen (der erste Ball wird gezeichnet und der zweite darüber)

4) Das Programm kann beschleunigt werden indem eine Parallelisierung möglich wird.

5) Variante 1: Erzeugen eines Objekts der Klasse Thread, welcher als übergabeparameter ein Objekt, welches das Runnable Interface implementiert mitgegeben wird. <br>
   Variante 2: Die Klasse Thread für die eigenen Notwendigkeiten spezialisieren und ein Objekt dieser Spezifikation erstellen. (<strong>nicht empfohlen</strong>)
   
6) Variante 1: Wenn die run-Methode fehlerfrei abgearbeitet wurde. <br>
   Variante 2: Wenn der Thread von aussen aktiv beendet wird.<br>
   Variante 3: Wenn während der run-Methode eine Exception eintrifft, die den Thread beendet. <br>
   Variante 4: Wenn System.exit aufgerufen wird.

7) Sie werden vom Canvas gelöscht und danach wieder neu gezeichnet (beide Methoden sind synchronized)


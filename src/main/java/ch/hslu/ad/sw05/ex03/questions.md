1) Um benötigte Ressourcen wieder freigeben zu können.

2) Ich habe die Interrupt Variante verwendet, da sie bereits bekannt und dokumentiert ist.  <br>
   Andere Art des Abbruchs wurde in Version 2 realisiert.
   
3) Die Interrupt-Variante

4) wird die Thread-Klassenmethode interrupted verwendet, so muss beachtet werden dass nach der Abfrage des 
   Interrupted-Flags dieses wieder auf false zurück.
   
5) die stop-Methode unterbricht den Thread sofort. Ist dieser Thread jedoch mitten in einer Aktion wie beispielsweise das Beschreiben 
eines Files und wird gestoppt noch bevor er fertig schreiben konnte bringt dies Fehler mit sich. Aufgrund dessen sollte 
die Methode nicht aufgerufen werden 
   
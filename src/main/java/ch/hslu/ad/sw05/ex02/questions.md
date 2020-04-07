1) Die gemeinsame Ressource sollte synchronized sein, um den gegenseitigen Ausschluss zu erreichen (wenn ein Thread den Lock hat, kann bis er ihn wieder freigibt kein weiterer auf die gemeinsame Ressource zugreiffen). 

2) Das Dead-Locks entstehen. Wird in einer Methode auf den Lock einer anderen Gewartet und umgekehrt, kann es vorkommen, dass sich beide gegenseitig ausschliessen.

3) Verursacht, dass geschützt auf die gemeinsamen Ressourcen zugegriffen wird und verhindert somit, dass keine inkonsistenten Daten enthalten sind.

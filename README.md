#object georienteerd vanuit databases
Misschien helpt dit om classes en objecten beter te begrijpen:

Een class is als een tabel definitie in een database. Het specificeerd hoe de tabel eruit komt te zien, welke waarden waar staan, wat het zijn en met welke namen ze zijn op te vragen.
Een object is als een ingevulde rij in een tabel.

| voornaam | tussenvoegsel | achternaam | adres | woonplaats | geboortedatum | <-- class
|----------|---------------|------------|-------|------------|---------------|
| piet|van|boter|coolsingel 50|rotterdam| <--object

Als je een object aanmaakt kijkt hij naar de class en gebruikt deze als template voor het te creeeren object.

Methods zou je dan kunnen zien als interactieve velden in de rij.
Sommige rijen in een database worden verzameld en gecomputeerd vanuit andere rijen, dit zou dan een method zijn in java.
Het grootste verschil is dan alleen dat eem method zijn waarde pas berekend als deze expliciet wordt aangeroepen.

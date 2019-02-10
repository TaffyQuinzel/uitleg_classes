# Object georienteerd vanuit databases
Een class is als een tabel definitie in een database. Het specificeerd hoe de tabel eruit komt te zien, welke waarden waar staan, wat het zijn en met welke namen ze zijn op te vragen.
Een object is als een ingevulde rij in een tabel.

| voornaam | tussenvoegsel | achternaam | adres | woonplaats | geboortedatum | <--*_class_* |
|----------|---------------|------------|-------|------------|---------------|-------|
| piet|van|boter|coolsingel 50|rotterdam| 31-08-1976|<--*_object_* |


In java ziet dit er ongeveer zo uit:
```java
class Gegevens {
  // specificatie hoe de class eruit komt te zien
  String voornaam;
  String tussenvoegsel;
  String achternaam;
  String adres;
  String woonplaats;
  String geboortedatum;
}
```

## De Constructor
Als we hier dan een object van willen maken hebben we een constructor nodig waarmee de class kan worden geinitieerd tot een object.
```java
  Gegevens() {
    voornaam =  "piet";
    tussenvoegsel = "van";
    achternaam = "boter";
    adres = "coolsingel 50";
    woonplaats = "rotterdam";
    geboortedatum =  "31-08-1976";
  }
```
De constructor heeft altijd dezelfde naam als de class.

## Objecten aanmaken
Als je een object wilt maken gebruik je het `new` keywoord:
```java
Gegevens piet = new Gegevens();
```

Hier wordt een object `piet` gemaakt met als type `Gegevens`. Hier is gelijk duidelijk te zien dat een class eigenlijk een type is.
Met `new` wordt aangegeven dat er een nieuw object moet worden gemaakt en `Gegevens()` specificeert welke constructor moet worden gebruikt om dit object te maken.

Als je een object aanmaakt kijkt hij naar de class en de constructor en gebruikt deze als template voor het te creeeren object.

### Alternatieve constructors
Je kan meerder constructors per class hebben. Ze moeten dan well verschillen van elkaar, anders weet de compiler niet welke constructor hij moet aanroepen.

Als we de volgende constructor aanmaken, krijgen we een error:
```java
  Gegevens() {
    voornaam =  "jan";
    tussenvoegsel = "";
    achternaam = "klaassen";
    adres = "hoofdstraat 50";
    woonplaats = "utrecht";
    geboortedatum =  "03-04-1994";
  }
```
We hebben namelijk al de constructor `Gegevens()` eerder gespecificeerd. En hoewel er in de constructor andere dingen gebeuren, de waarden die worden toegekend zijn anders, is de definitie van de constructor hetzelfde.
De definitie van beide constructors is `Gegevens()`, hierdoor weer `new` niet welke constructor je wilt gebruiken.

Als we onze nieuwe constructor aanpassen kunnen we hem wel gebruiken:
```java
  Gegevens(String voornaam) {
    this.voornaam = voornaam;
    tussenvoegsel = "";
    achternaam = "klaassen";
    adres = "hoofdstraat 50";
    woonplaats = "utrecht";
    geboortedatum =  "03-04-1994";
  }
```
De construtor definitie is nu `Gegevens(String voornaam)` en kunnen we zo gebruiken:
```java
  Gegevens jan = new Gegevens("jan");
```
De constructor neemt nu een string als argument en gebruikt de waarde van de string om de variabele `voornaam` een waarde te geven.

Hier zien we echter iets eigenaardigs, het gebruik van `this`.
Omdat de argument naam hetzelfde is als de variabele in de class hebben we een manier nodig om ze te onderscheiden. Met `this` roep je het huidige object aan waar je je op dit moment in bevindt, in dit geval het object `jan`.
Met de `.` kan je dan zeggen dat je een specifieke variabele of method wil aanroepen in dit object, in dit gevaal `voornaam`.
De `.` kan je zien als een manier om 1 specifiek veld van een rij in een tabel op te vragen.

# Methods
Methods zou je dan kunnen zien als interactieve velden in de rij.
Sommige rijen in een database worden verzameld en gecomputeerd vanuit andere rijen, dit zou dan een method zijn in java.
Het grootste verschil is dan alleen dat eem method zijn waarde pas berekend als deze expliciet wordt aangeroepen.

Constructors zijn speciale methods die automatisch tijdens het initieren van een object worden aangeroepen.

Stel we willen de gegevens interactief ophalen.

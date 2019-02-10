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
Methods zou je in een database kunnen vergelijken met interactieve velden in de rij.
Sommige rijen in een database worden verzameld en gecomputeerd vanuit andere rijen, met bijvoorbeeld queries, dit zou dan een method zijn in java.

Constructors zijn speciale methods die automatisch tijdens het initieren van een object worden aangeroepen.

## De main method
Nu hebben we een hele mooie class `Gegevens` opgezet, maar nu willen we er ook iets mee doen.
Als je een programma wil maken hebben we een apart `main` method nodig.
Er is maar 1 `main` method per programma.
De java runtime zoek in je programma naar die ene `main` en begint daar de executie van het programma.

Omdat een method altijd in een class moet zitten is het handig om een class aan te maken die alleen de `main` method bevat.
```java
class Program {
  public static void main(String args[]) {
    Gegevens piet = new Gegevens();
  }
}
```
Laten we de code is ontleden.
Met `class Program {` definieren we een class `Program`, deze gebruiken we om de `main` in te stoppen. Er staat daarom ook verder niks in de class.
Er is geen constructor nodig omdat er niks hoeft te worden geinitieerd. Het enige wat we immers gebruiken is de `main` method.
De `main` definieren we met:
```java
  public static void main(String args[]) {
```
Het `public` keyword duid aan dat de method van buiten de class in aan te roepen. Dit is nodig om de java runtime de `main` method te kunnen vinden.
`static` geeft aan dat er maar 1 instantie van deze method kan zijn. Dit is uiteraard nodig omdat er maar 1 `main` kan zijn.
`void` geeft de waarde aan wat de method teruggeeft of in java termen de __return value__ van de method.
`main` is de naam van de method en alles wat tussen de haakjes staat zijn de argumenten die aan de method worden meegegeven, in dit geval `String args[]`.

`String` is het type van het argument genaamd `args`. De blokhaakjes `[]` geven aan dat het een array is.
`args` is dus een array van `String`s en zijn de mogelijke command line arguments die je aan het programma meegeeeft. Ook als je van te voren weet dat je geen argumenten nodig hebt moet je ze definieren.

In de volgende regel maken we een `Gegevens` object aan genaamd `piet`:
```java
    Gegevens piet = new Gegevens();
```
Even een korte herhaling:
* Met `new` geven we aan dat er een nieuw object moet worden aangemaakt.
* Met `Gegevens()` geven we aan welk class en welke constructor voor het object moet worden gebruikt.

## Classes en waar ze staan
We kunnen de `Gegevens` class gebruiken in de `Program` class omdat deze in dezelfde directory staan:
```
src/
├── Gegevens.java
└── Program.java
```
Elke class heeft zijn eigen `.java` file met dezelfde naam als de class.

## Methods gebruiken
Nu we een programma hebben wat we kunnen uitvoeren kunnen we het ook gaan gebruiken.
Als we het huidige programma uitvoeren gebeurt er namelijk weinig; het wordt een object `piet` wordt aangemaakt en dan is het programma al klaar.

Laten we beginnen met laten zien wat we allemaal over piet weten. Hiervoor willen we de gegevens van piet uitprinten. Bijvoorbeeld zo:
```java
  public static void main(String args[]) {
    Gegevens piet = new Gegevens();

    // print gegevens
    System.out.println("voornaam:"      + piet.voornaam);
    System.out.println("tussenvoegsel:" + piet.tussenvoegsel);
    System.out.println("achternaam:"    + piet.achternaam);
    System.out.println("adres:"         + piet.adres);
    System.out.println("woonplaats:"    + piet.woonplaats);
    System.out.println("geboortedatum:" + piet.geboortedatum);
  }
```
Dit is echter niet heel mooi als je meerdere `Gegevens` objecten hebt, dan lopen je aantal regels code snel op.
Laten we daarom in `Gegevens` een method maken die ze voor ons print:
```java
class Gegevens
  public void printData() {
    System.out.println("voornaam:"      + voornaam);
    System.out.println("tussenvoegsel:" + tussenvoegsel);
    System.out.println("achternaam:"    + achternaam);
    System.out.println("adres:"         + adres);
    System.out.println("woonplaats:"    + woonplaats);
    System.out.println("geboortedatum:" + geboortedatum);
  }
}
```
Deze method moet uiteraard `public` zijn anders kunnen we hem niet aanroepen.
Echter konden we ook de variabelen aanroepen vanuit de `main` terwijl we deze niet public hadden gemaakt. Dit komt omdat alles standaard public is. Dit is natuurlijk niet handig, want dan kan iedereen de data van het object aanpassen zonder dat het object en ander gebruikers van het object daar kennis van hebben.

Laten we de variabelen daarom `private` maken. Zo kan alleen het object zelf nog bij deze data.
```java
class Gegevens {
  private String voornaam;
  private String tussenvoegsel;
  private String achternaam;
  private String adres;
  private String woonplaats;
  private String geboortedatum;
}
```
Nu kunnen we ook de `main` aanpassen door de nieuwe method `printData` aan te roepen:
```java
  public static void main(String args[]) {
    Gegevens piet = new Gegevens();

    piet.printData();
  }
```

## Wat slimmigheid toevoegen
Nu kunnen we al die gegevens ook wat mooier formatteren. De naam als 1 geheel bijvoorbeeld:
```java
    System.out.println("naam: " + voornaam + tussenvoegsel + achternaam);
```
Maar niet ieder persoon heeft een tussenvoegsel. Dus daar moeten we rekening mee houden:
```java
    if (tussenvoegsel == null || tussenvoegsel.length() == 0)
      System.out.println("naam: " + voornaam + achternaam);
    else
      System.out.println("naam: " + voornaam + tussenvoegsel + achternaam);
```
De code is alleen wat rommelig door al die aanroepingen van `System.out.println`.
Laten we hier ook is wat aan doen:
```java
    String naam = "naam: " + voornaam;
    if (tussenvoegsel != null && tussenvoegsel.length() > 0) {
      naam += tussenvoegsel;
    }
    naam += achternaam;
    System.out.println("naam: " + naam);
```
En als we maar 1 `System.out.println` willen hebben:
```java
  public void printData() {
    String output = "naam:\t" + voornaam;
    if (tussenvoegsel != null && tussenvoegsel.length() > 0) {
      output += tussenvoegsel;
    }
    output += achternaam + "\n";

    output += "adres:\t"         + adres         + "\n";
    output += "woonplaats:\t"    + woonplaats    + "\n";
    output += "geboortedatum:\t" + geboortedatum + "\n";

    System.out.println(output);
  }
```
Hier maken we gebruik van _escape characters_ in de strings om tabs en newlines in te voegen. Tabs worden gespecifieceerd door `\t` en newlines door `\n`.


# Command line interactie
Stel we weten geen van de gegevens en willen deze opvragen. Dan kunnen we dat doen door argumenten in te lezen bij het opstarten van het programma of als het programma al draait. Wij kiezen voor het laatste.

Om via de command line text in te lezen gebruiken we `BufferedReader` en `InputStreamReader`.
`inputStreamReader` kan data inlezen vanuit een gespificeerde input, hiervoor gebruiken we `System.in`.
Om de gegenereerde stream van `inputStreamReader` te kunnen verwerken gebruiken we `BufferedReader`, hiermee kunnen we stukjes van de stream verwerken zonder direct met streams te hoeven werken.

Met het voorgaande kunnen we een nieuw object maken die text van de command line in kan lezen:
```java
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
```
Om te zetten naar een `String` gebruiken we de `readLine()` method.
```java
    String cli_input = input.readLine();
```
Als je dit wil compileren krijg je een error. `readLine()` kan namelijk een _gooien_.

## Exceptions
Exceptions zijn objecten die worden _geactiveerd_ wanneer er iets ongeplands gebeurt in een method.
Een exception wordt geactiveerd door hem te _gooien_. Als deze wordt gegooid moet je deze _ooit_ een keer _afvangen_.
Het afvangen wordt gedaan met een `catch` en als je een method wil roepen die een exception kan gooien moet dat binnen een `try` block. Dit ziet er zo uit:
```java
try {
  String cli_input = input.readLine();
} catch(Exception e) {
  ...
}
```
`catch` vangt de exception en in het `catch` block kan je de exception dan verwerken naar bijvoorbeeld een errorlog.

### Exceptions doorspelen
Als je niet direct rekening wil houden met mogelijke exceptions kan je deze doorspelen door dit aan te geven in de method definitie, door middel van `throws`:
```java
public void functieNaam() throws Exception {
  ...
}
```

Echter als er een exception wordt gegooid moet je deze nog steeds afvangen in de method waar je de functie aanroept die de exception doorspeelt. In dit geval `functieNaam()`.


# Compleet programma
Probeer met al de vergane kennis het programma in `src/` te begrijpen.









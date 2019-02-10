import java.io.BufferedReader;
import java.io.InputStreamReader;


class Gegevens {
  /*
   * alles wat in de class staat is een specificatie van hoe de objecten
   *   gemaakt met deze class eruit komt te zien
   */

  // variabelen in de class => standaard database velden
  private String voornaam;
  private String tussenvoegsel;
  private String achternaam;
  private String adres;
  private String woonplaats;
  private String geboortedatum;
  private BufferedReader input;

  // contructor => hier wordt de data van de class geinitieerd
  Gegevens() {
    input = new BufferedReader(new InputStreamReader(System.in)); // nieuw BufferedReader object genaamd 'input'
    voornaam      = "";
    tussenvoegsel = "";
    achternaam    = "";
    adres         = "";
    woonplaats    = "";
    geboortedatum = "";
  }


  /*
   * methods
   *   nu specificeren we alle methods (interactieve velden)
   */

  /*
   * public methods
   */

  // print alle data die bekend is
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

  // hier kan je interactief alle velden mee verzamelen
  public void verzamelData() throws Exception {
    voornaam      = leesVariabele("voornaam");
    tussenvoegsel = leesVariabele("tussenvoegsel");
    achternaam    = leesVariabele("achternaam");
    adres         = leesVariabele("adres");
    woonplaats    = leesVariabele("woonplaats");
    geboortedatum = leesVariabele("geboortedatum");
  }


  /*
   * private methods
   */

  // lees een variabele vanuit cli
  private String leesVariabele(String variabeleNaam) throws Exception {
    System.out.println("wat is je " + variabeleNaam + "?");
    return input.readLine();
  }

}

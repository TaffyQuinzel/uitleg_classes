class Program {
  public static void main(String args[]) {
    Gegevens piet = new Gegevens(); // maak een nieuw Gegevens object aan genaamd 'piet'
    try {
      piet.verzamelData();
    } catch (Exception e) {
      System.out.println("error occured");
    }
    piet.printData();
  }
}

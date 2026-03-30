public class Main
{
    public static void main(String[] args)
    {
        Osoba[] tablica = new Osoba [4];

        Osoba os1 = new Osoba("Jan", "Kowalski");
        tablica[0] = os1;

        Osoba os2 = new Agent("James", "Bond");
        tablica[1] = os2;

        tablica[2] = new Osoba("Patryk", "Nowak");
        tablica[3] = new Agent("Agent", "Agent");

        for(Osoba os : tablica)
            System.out.println(os);
    }
}
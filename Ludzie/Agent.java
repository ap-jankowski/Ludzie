package Ludzie;

public class Agent extends Osoba
{
    public Agent(String Imie, String Nazwisko)
    {
        super(Imie, Nazwisko);
    }

    public String toString()
    {
        return Nazwisko + ", " + Imie + " " + Nazwisko;
    }
}

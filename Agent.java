public class Agent extends Osoba
{
    Agent(String Imie, String Nazwisko)
    {
        super(Imie, Nazwisko);
    }

    public String toString()
    {
        return Nazwisko + ", " + Imie + " " + Nazwisko;
    }
}

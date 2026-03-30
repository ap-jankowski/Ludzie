public class Osoba
{
    protected String Imie;
    protected String Nazwisko;

    Osoba(String Imie, String Nazwisko)
    {
        this.Imie = Imie;
        this.Nazwisko = Nazwisko;
    }

    public String toString()
    {
        return Imie + " " + Nazwisko;
    }
}

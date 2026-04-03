public class Ulamek
{
    private int licznik;
    private int mianownik;

    Ulamek(int licznik, int mianownik)
    {
        this.licznik = licznik;
        if(mianownik == 0)
        {
            System.out.println("Nie można dzielić przez zero!");
            System.exit(1);
        }
        this.mianownik = mianownik;
    }

    private int nwd(int a, int b)
    {
        if(b == 0) return a;
        return nwd(b, a % b);
    }

    private void skroc()
    {
        licznik /= nwd(licznik, mianownik);
        mianownik /= nwd(licznik, mianownik);
    }

    public void dodaj(Ulamek skladnik)
    {
        licznik = licznik * skladnik.mianownik() + skladnik.licznik() * mianownik;
        mianownik *= skladnik.mianownik();
        skroc();
    }

    public void dodaj(int liczba)
    {
        dodaj(new Ulamek(liczba, 1));
    }

    public void pomnoz(Ulamek czynnik)
    {
        licznik *= czynnik.licznik();
        mianownik *= czynnik.mianownik();
        skroc();
    }

    public void pomnoz(int liczba)
    {
        pomnoz(new Ulamek(liczba, 1));
    }

    public void odejmij(Ulamek odjemna)
    {
        dodaj(new Ulamek(-odjemna.licznik(), odjemna.mianownik()));
    }

    public void odejmij(int liczba)
    {
        odejmij(new Ulamek(liczba, 1));
    }

    public void podziel(Ulamek dzielnik)
    {
        if(dzielnik.licznik() == 0)
            System.out.println("Nie można dzielić przez zero!");
        else pomnoz(new Ulamek(dzielnik.mianownik(), dzielnik.licznik()));
    }

    public void podziel(int liczba)
    {
        if(liczba == 0)
            System.out.println("Nie można dzielić przez zero!");
        else podziel(new Ulamek(liczba, 1));
    }

    public String toString()
    {
        skroc();
        if(mianownik == 1) return licznik + "";
        else return licznik + "/" + mianownik;
    }
}
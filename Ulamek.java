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
            mianownik = 1;
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

    public int getLicznik()
    {
        return licznik;
    }

    public int getMianownik()
    {
        return mianownik;
    }

    public void dodaj(Ulamek skladnik)
    {
        licznik = licznik * skladnik.getMianownik() + skladnik.getLicznik() * mianownik;
        mianownik *= skladnik.getMianownik();
        skroc();
    }

    public void dodaj(int liczba)
    {
        dodaj(new Ulamek(liczba, 1));
    }

    public void pomnoz(Ulamek czynnik)
    {
        licznik *= czynnik.getLicznik();
        mianownik *= czynnik.getMianownik();
        skroc();
    }

    public void pomnoz(int liczba)
    {
        pomnoz(new Ulamek(liczba, 1));
    }

    public void odejmij(Ulamek odjemna)
    {
        dodaj(new Ulamek(-odjemna.getLicznik(), odjemna.getMianownik()));
    }

    public void odejmij(int liczba)
    {
        odejmij(new Ulamek(liczba, 1));
    }

    public void podziel(Ulamek dzielnik)
    {
        if(dzielnik.getLicznik() == 0)
            System.out.println("Nie można dzielić przez zero!");
        else pomnoz(new Ulamek(dzielnik.getMianownik(), dzielnik.getLicznik()));
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
import Ludzie.Osoba

public class BuforCykliczny
{
    public static Osoba[] powieksz(Osoba[] tablica)
    {
        Osoba[] w = new Osoba[tablica.length * 2];
        for(int i = 0; i < tablica.length; i++)
            w[i] = tablica[i];

        return w;
    }

    public static Osoba[] pomniejsz(Osoba[] tablica)
    {
        Osoba[] w = new Osoba[tablica.length / 2];
        for(int i = 0; i < tablica.length / 4; i++)
            w[i] = tablica[i];

        return w;
    }
}
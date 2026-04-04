import Ludzie.Osoba;

public class BuforCykliczny
{
    private Osoba[] tablica = new Osoba[4];
    private int capacity = 4;
    private int size;
    private int begin;


    public boolean empty(){
        return size == 0;
    }

    private void powieksz()
    {
        Osoba[] w = new Osoba[capacity * 2];
        for(int i = 0; i < size; i++)
            w[i] = tablica[(begin + i) % capacity];
        capacity *= 2;
        begin = 0;
        tablica = w;
    }

    private void pomniejsz()
    {
        Osoba[] w = new Osoba[capacity / 2];
        for(int i = 0; i < size; i++)
            w[i] = tablica[(begin + i)%capacity];

        capacity /= 2;
        begin = 0;
        tablica = w;
    }
    public void dodaj(Osoba o){
        if(size == capacity) powieksz();
        tablica[(begin + size)%capacity] = o;
        size++;
    }
    public Osoba pobierz(){
        if(empty()) return null;
        Osoba o = tablica[begin];
        size--;
        begin++;
        begin %= capacity;
        if(capacity/4 >= size && capacity > 8) pomniejsz();
        return o;
    }
    public void wypisz(){
        String wynik = "[";
        for(int i = 0; i < size; i++){
            wynik += tablica[(begin + i) % capacity];
            if(i < size - 1) wynik += ", ";
        }
        wynik += "]";
        System.out.println(wynik);
    }
}
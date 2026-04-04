public class BuforCykliczny
{
    private Ulamek[] tablica = new Ulamek[4];
    private int capacity = 4;
    private int size;
    private int begin;


    public boolean empty()
    {
        return size == 0;
    }

    private void powieksz()
    {
        Ulamek[] w = new Ulamek[capacity * 2];
        for(int i = 0; i < size; i++)
            w[i] = tablica[(begin + i) % capacity];
        capacity *= 2;
        begin = 0;
        tablica = w;
    }

    private void pomniejsz()
    {
        Ulamek[] w = new Ulamek[capacity / 2];
        for(int i = 0; i < size; i++)
            w[i] = tablica[(begin + i)%capacity];

        capacity /= 2;
        begin = 0;
        tablica = w;
    }

    public void dodaj(Ulamek o)
    {
        if(size == capacity) powieksz();
        tablica[(begin + size)%capacity] = o;
        size++;
    }

    public Ulamek pobierz()
    {
        if(empty()) return null;
        Ulamek o = tablica[begin];
        size--;
        begin++;
        begin %= capacity;
        if(capacity/4 >= size && capacity > 8) pomniejsz();
        return o;
    }

    public void wypisz()
    {
        String wynik = "[";
        for(int i = 0; i < size; i++){
            wynik += tablica[(begin + i) % capacity];
            if(i < size - 1) wynik += ", ";
        }
        wynik += "]";
        System.out.println(wynik);
    }
}
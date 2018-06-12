import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class Slimak extends Mapa implements Runnable {
    private Mapa mapa;


    public Slimak(Mapa mapa) {
        this.mapa = mapa;
    }

    @Override
    public synchronized void run(){
        Random rng = new Random();
        int a, b,i=0;
        long t = System.currentTimeMillis();


        while(true) {
            //System.out.println("szukam jedzenia" + ++i);
            a = rng.nextInt(5);
            b = rng.nextInt(5);
            //System.out.println("slimak id " + Thread.currentThread().getId() + ": wylosowal pole " + a +"-"+b + "o wartosci " + mapa.tab[a][b].wartosc());
            //System.out.println("slimak id " + Thread.currentThread().getId() + ": czas = " + Long.toString(System.currentTimeMillis() - t));
            t = System.currentTimeMillis();
            synchronized (mapa.tab[a][b]) {
                t = System.currentTimeMillis();

                while (mapa.wartosc(a, b) > 0) {
                    if(t>0){
                        //System.out.println("slimak id " + Thread.currentThread().getId() + ": znalazlem jedzenie w " + Long.toString(System.currentTimeMillis() - t) + " na polu " + a + "-" + b);
                        t=System.currentTimeMillis();
                    }

                    i=0;
                    mapa.decrement(a, b);
                    mapa.tabela()[a][b].imageview.setVisible(true);
                    //System.out.println("zjadlem " + a + "-" + b);
                    try {
                        Thread.currentThread().sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mapa.tabela()[a][b].imageview.setVisible(false);
            }
        }
    }


}

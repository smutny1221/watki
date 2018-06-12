import java.util.Random;

import static java.lang.Thread.sleep;

public class Wzrost implements Runnable {
    private Mapa mapa;

    public Wzrost(Mapa mapa) {
        this.mapa = mapa;
    }

    public void run(){
        Random rng = new Random();
        int a,b;

        while(true){
            a = rng.nextInt(5);
            b = rng.nextInt(5);


            synchronized (mapa.tab[a][b]){
                mapa.increment(a,b);
                //System.out.println("wzrost " + a + "-" + b);
            }


            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

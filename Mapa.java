import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;

public class Mapa {
    protected Pole[][] tab = new Pole[5][5];
    //protected List<Pole> = new List<Pole>;

    Mapa(Pole[][] tab){
        this.tab = tab;
    }

    Mapa(){
        Random rng = new Random();
        Image image = null;
        try {
            image = new Image(new FileInputStream("C:\\Users\\user\\Dropbox\\studia\\semestr 6\\idea\\smutne_watki\\src\\snail.png"));

            for(int j=0;j<5;j++) {
                for (int i = 0; i < 5; i++) {
                    ImageView imageview = new ImageView(image);
                    imageview.setFitHeight(40);
                    imageview.setFitWidth(40);
                    imageview.setX(30+i*100);
                    imageview.setY(30+j*100);
                    imageview.setVisible(false);

                    this.tab[i][j] = new Pole(rng.nextInt(5) + 3, new Rectangle(i * 100, j * 100, 100, 100), imageview);
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    protected synchronized void increment(int a, int b){
        tab[a][b].increment();
    }

    protected int wartosc(int a, int b){
        return tab[a][b].wartosc();
    }

    protected Pole[][] tabela(){
        return tab;
    }

    protected synchronized int decrement(int a, int b) {
        return tab[a][b].decrement();
    }
}

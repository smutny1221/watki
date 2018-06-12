import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Pole {
    private int pole;
    protected Rectangle kwadrat;
    protected ImageView imageview;

    private String[] kolor = {"ff9966","ffcc99","ffcc66","ffcc00","ffff00","ffff66","ccff66","ccff33","99ff33","66ff33","33cc33"};

    Pole(int pole) {
        this.pole = pole;
    }

    Pole(int pole, Rectangle kwadrat, ImageView imageview) {
        this.pole = pole;
        this.kwadrat = kwadrat;
        this.imageview = imageview;

        this.kwadrat.setFill(Paint.valueOf(kolor[pole]));
    }

    public void increment() {
        if (this.pole < 10) {
            this.pole++;
            kwadrat.setFill(Paint.valueOf(kolor[pole]));
        }
    }

    public int decrement() {
        if (this.pole > 0) {
            this.pole--;
            kwadrat.setFill(Paint.valueOf(kolor[pole]));
        }
        return this.pole;
    }

    public int wartosc() {
        return pole;
    }

}

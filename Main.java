import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static java.lang.Thread.sleep;

public class Main extends Application {
    protected static int tab;



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Mapa mapa = new Mapa();
        Runnable runner;
        Thread tr;

        //root bedzie zawieral wszystkie elementy graficzne
        Pane root = new Pane();
        root.setPrefSize(500,500);

        try {
            Image image = new Image(new FileInputStream("C:\\Users\\user\\Dropbox\\studia\\semestr 6\\idea\\smutne_watki\\src\\snail.png"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("BLEDNA SCIEZKA PLIKU");
            System.exit(-1221);
        }

        //watek wyswietlania
        runner = new Display(mapa);
        tr = new Thread(runner);
        tr.setDaemon(true);
        tr.start();

        //przerwa
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //watki limakow
        for(int i=0;i<5;i++) {
            runner = new Slimak(mapa);
            tr = new Thread(runner);
            tr.start();
        }

        //watki wzrostu
        for(int i=0;i<5;i++) {
            runner = new Wzrost(mapa);
            tr = new Thread(runner);
            tr.start();
        }



        //dodaje Pola z mapy do roota
        for(int j=0;j<5;j++) {
            for (int i = 0; i < 5; i++) {
                root.getChildren().add(mapa.tabela()[i][j].kwadrat);
                root.getChildren().add(mapa.tabela()[i][j].imageview);
            }
        }







    }
}

/* teraz slimaki i wzrosty czekaja na dostep do zajetego pola, zamiast isc gdzies indziej
https://stackoverflow.com/questions/1779795/how-do-determine-if-an-object-is-locked-synchronized-so-not-to-block-in-java
*/













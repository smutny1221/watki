import javafx.scene.paint.Paint;

public class Display extends Main implements Runnable {
    private Mapa mapa;

    public Display(Mapa mapa) {
        this.mapa = mapa;
    }

    @Override
    public void run(){
        while(true){
            for(int j=0;j<5;j++) {
                for (int i = 0; i < 5; i++) {
                    System.out.print(Integer.toString(mapa.wartosc(i, j)) + " ");
                    //mapa.tabela()[i][j].kwadrat.setFill(Paint.valueOf("#" + Integer.toString(100+i*33) + Integer.toString(100+j*33)));
                }
                System.out.println("");
            }
            for(int j=0;j<10;j++) {
                System.out.println("");
            }

            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

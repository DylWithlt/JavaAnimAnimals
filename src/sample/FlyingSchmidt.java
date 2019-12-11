package sample;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FlyingSchmidt extends Animal implements Flying {

    FlyingSchmidt(Stage stage, String name, ImageView imgView) {
        super(stage, name, imgView);
    }

    @Override
    public void fly() {
        imgView.setX(imgView.getX() + 1);
        imgView.setY(Math.sin(imgView.getX()/10)*50 + 100);
    }

    @Override
    public void run() {
        super.run();

        for (int i = 0; i < stage.getMaxWidth(); i++) {
            fly();
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

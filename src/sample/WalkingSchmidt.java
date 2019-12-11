package sample;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class WalkingSchmidt extends Animal implements Walking {


    WalkingSchmidt(Stage stage, String name, ImageView imgView) {
        super(stage, name, imgView);
    }

    @Override
    public void walk() {
        imgView.setX(imgView.getX()+1);
        imgView.setY(300);
    }

    @Override
    public void run() {
        super.run();

        for (int i = 0; i < stage.getMaxWidth(); i++) {
            walk();
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

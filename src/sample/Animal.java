package sample;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;

abstract public class Animal implements Runnable {
    protected final Stage stage;
    String name;
    ImageView imgView;

    Animal(Stage stage, String name, ImageView imgView) {
        this.name = name;
        this.imgView = imgView;
        this.stage = stage;
    }


    @Override
    public void run() {

    }
}

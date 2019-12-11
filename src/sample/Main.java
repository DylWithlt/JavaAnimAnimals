package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main extends Application {

    public static ImageView makeImageView(String filePath) throws FileNotFoundException {
        Image image = new Image(new FileInputStream(filePath));

        ImageView imgView = new ImageView(image);

        imgView.setFitHeight(100);
        imgView.setFitWidth(100);

        imgView.setPreserveRatio(true);

        return imgView;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        HashSet<Animal> animals = new HashSet<>();

        Group root = new Group();

        ImageView tomImg1 = makeImageView("src/sample/tomschmidt.png");
        ImageView tomImg2 = makeImageView("src/sample/tomschmidt.png");

        root.getChildren().add(tomImg1);
        root.getChildren().add(tomImg2);

        Animal tom1 = new WalkingSchmidt(primaryStage,"walkingTomOne", tomImg1);
        Animal tom2 = new FlyingSchmidt(primaryStage,"flyingTomOne", tomImg2);

        animals.add(tom1);
        animals.add(tom2);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (Animal animal:animals) {
            executorService.execute(animal);
        }

        System.out.println(IntStream.rangeClosed(0, 1000)
                .filter((x) -> (x%2 == 0))
                .sum());

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

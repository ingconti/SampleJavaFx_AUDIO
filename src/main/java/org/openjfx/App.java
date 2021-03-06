package org.openjfx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

//audio: // see module Info, TOO.
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;



public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("play some Audio");
        Group root = new Group();
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawSome(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        playMySnd();
    }
    private void drawSome(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
    }


    private void playMySnd(){
/*
//  show how to read txt files...
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("file.txt");
        if (inputStream==null)return;
        printInputStream(inputStream);

*/
        // loading resources:
        //https://mkyong.com/java/java-read-a-file-from-resources-folder/


        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource("bass.mp3");

        if (url==null)
            return;
        String mediumPath = url.toString();
        Media medium = new Media(mediumPath);
        MediaPlayer mediaPlayer = new MediaPlayer(medium);
        mediaPlayer.play();
    }

    private static void printInputStream(InputStream is) {

        try (
                InputStreamReader streamReader =
                     new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
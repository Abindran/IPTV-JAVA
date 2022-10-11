package videoplayer;


import iptv.Main;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Player extends Application
{

    @Override
    public void start(Stage primaryStage){

//        Getting the video url
        Main obj = new Main();
        String path=obj.getVideUrl();


        VideoPlayer videoPlayer = new VideoPlayer(path);

        Scene scene = new Scene(videoPlayer,1280,760, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Playing video");
        primaryStage.show();
    }




    public static  void main(){
        launch();
    }
}


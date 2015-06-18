package cz.dredwerkz.sauce;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * A simple, minimalistic web browser.
 * @author Jiri Prajzner
 * @web http://www.dredwerkz.cz
 */
public class Sauce extends Application {
  String HOME_PAGE = "http://www.seznam.cz";
  
  private BorderPane bpLayout;
  private WebEngine we;
  private int HEIGHT = 512;
  private int WIDTH = 800;
  
  @Override
  public void start(Stage stage) {
    TextField addressBar = new TextField();
    addressBar.setPrefColumnCount(80);
    addressBar.setOnAction(a -> {
      we.load(addressBar.getText());
    });
    
    WebView wv = new WebView();
    we = wv.getEngine();
    we.load(HOME_PAGE);
    Group wwwPage = new Group(wv);
    
    bpLayout = new BorderPane();
    bpLayout.setTop(addressBar);
    bpLayout.setCenter(wwwPage);
    
    Scene scene = new Scene(bpLayout, WIDTH, HEIGHT);
    
    stage.setTitle("www.dredwerkz.cz - Sauce - @dr3dwerkz");
    stage.setScene(scene);
    stage.show();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
  
}

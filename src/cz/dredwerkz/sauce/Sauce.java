package cz.dredwerkz.sauce;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * A simple, minimalistic web browser.
 *
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
    addressBar.setMinWidth(500);
    addressBar.setOnAction(a -> {
      String query = addressBar.getText();
      if (!(query.startsWith("http") || query.startsWith("https") || query.startsWith("www"))) {
        we.load("https://duckduckgo.com/?q=" + query);
      } else if (query.startsWith("www")) {
        we.load("http://" + query);
      } else {
        we.load(query);
      }
    });;

    WebView wv = new WebView();
    we = wv.getEngine();
    we.load(HOME_PAGE);

    bpLayout = new BorderPane();
    bpLayout.setTop(addressBar);
    bpLayout.setCenter(wv);

    Scene scene = new Scene(bpLayout, WIDTH, HEIGHT);
    /*scene.setOnKeyPressed(kp -> {
     if (kp.isControlDown() && kp.getCode() == KeyCode.T) {
     // fire up a new tab
     }
     });*/

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

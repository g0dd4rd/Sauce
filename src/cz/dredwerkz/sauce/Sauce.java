package cz.dredwerkz.sauce;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/**
 * A simple, minimalistic web browser.
 *
 * @author Jiri Prajzner
 * @web http://www.dredwerkz.cz
 */
public class Sauce extends Application {
  private int HEIGHT = 512;
  private int WIDTH = 800;

  @Override
  public void start(Stage stage) {
    TabPane tabPane = new TabPane();
    tabPane.getTabs().add(new WebPage());

    Scene scene = new Scene(tabPane, WIDTH, HEIGHT);
    scene.setOnKeyPressed(kp -> {
      if (kp.isControlDown() && kp.getCode() == KeyCode.T) {
        tabPane.getTabs().add(new WebPage());
        tabPane.getSelectionModel().selectLast();
      }
    });

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

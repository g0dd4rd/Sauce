package cz.dredwerkz.sauce;

import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * Class representing a Tab as a WebPage, its actions and properties
 * @author Jiri Prajzner 
 * @web http://www.dredwerkz.cz
 */
public class WebPage extends Tab {
  String HOME_PAGE = "http://www.seznam.cz";
  
  private BorderPane bpLayout;
  private TextField addressBar;
  private WebEngine engine;
  private WebView view;
  
  WebPage() {
    bpLayout = new BorderPane();
    addressBar = new TextField();
    view = new WebView();
    engine = view.getEngine();
    layoutWebPage();
    actionWebPage();
  }
  
  void layoutWebPage() {
    addressBar.setPrefColumnCount(80);
    engine.load(HOME_PAGE);
    bpLayout.setTop(addressBar);
    bpLayout.setCenter(view);
    setContent(bpLayout);
  }
  
  void actionWebPage() {
    addressBar.setOnAction(a -> {
      String query = addressBar.getText();
      if (!(query.startsWith("http") || query.startsWith("https") || query.startsWith("www"))) {
        engine.load("https://duckduckgo.com/?q=" + query);
      } else if (query.startsWith("www")) {
        engine.load("http://" + query);
      } else {
        engine.load(query);
      }
    });;
  }
  
  void setHomePage(String homePage) {
    HOME_PAGE = homePage;
  }
}

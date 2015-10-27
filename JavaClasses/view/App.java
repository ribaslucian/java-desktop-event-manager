/**
 * @author Lucian Rossoni Ribas <ribas.lucian@gmail.com>
 * @author Vinicius Alonso <?>
 *
 * @version 1.0
 *
 */
package view;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;

public class App {

    public static void main(String[] args) {
        View.views.get("login").setVisible(true);
    }

}

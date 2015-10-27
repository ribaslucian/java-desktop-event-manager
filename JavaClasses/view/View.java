/**
 * @author Lucian Rossoni Ribas <ribas.lucian@gmail.com>
 * @author Vinicius Alonso <?>
 *
 * @version 1.0
 *
 * The view class that is the basis for the views of our application. Has
 * access to all instantiated visions and basic methods for them.
 */
package view;

import java.awt.Container;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;

abstract class View extends JFrame {

    /**
     * attribute map. This public variable that will save all of the views of
     * our application, your content will be defined by class name that
     * represents the view
     */
    public static Map<String, View> views = new HashMap<String, View>() {
        {
            put("login", new Login());
            put("diary", new Diary());
        }
    };

    /**
     * attribute container. Basic container, all views need an independent. Your
     * set method is required for all views.
     */
    protected Container container = new Container();

    /**
     * method setContainer(). method that is created in all views. Your block is
     * default and should contain your layout definition and get pane in
     * yourself
     *
     * @return void
     */
    abstract void setContainer();

    /**
     * initialize method(). method that is created in all views. Your block is
     * default and should contain your layout definition and get pane in
     * yourself
     *
     * @param title: will be the title of the view
     * @param width: will be the width size of the view
     * @param width: will be the height size of the view
     *
     * @return void
     */
    public void initialize(String Title, int width, int height) {
        setSize(width, height);
        setTitle("Agenda: Conecte-se");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

}

/**
 * @author Lucian Rossoni Ribas <ribas.lucian@gmail.com>
 * @author Vinicius Alonso <?>
 *
 * @version 1.0
 *
 * The Login View class is responsive for estructure the login view.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class Login extends View {

    /**
     * attribute windowWidth, windowHeight. Attributes responsible for size of
     * the view
     */
    private int windowWidth = 350;
    private int windowHeight = 220;

    /**
     * attribute pn. Represent the primary painel of the view, everybody are
     * inside them.
     */
    private JPanel pn = new JPanel();
    private TitledBorder pnBorder = new TitledBorder("Identifique-se para acessar o sistema");

    /**
     * attributes with sufixe "Name". represents the elements that make up the
     * name Title.
     */
    private JPanel pnUserName = new JPanel();
    private FlowLayout ltUserName = new FlowLayout();
    private JLabel lbUserName = new JLabel("Nome de Usuário");
    private JTextField tfUserName = new JTextField();

    /**
     * attributes with sufixe "Password". represents the elements that make up
     * the password Title.
     */
    private JPanel pnPassword = new JPanel();
    private FlowLayout ltPassword = new FlowLayout();
    private JLabel lbPassword = new JLabel("Senha:");
    private JTextField tfPassword = new JPasswordField();

    /**
     * attributes with sufixe "Connect". represents the elements that make up the
     * Connect Title.
     */
    private JPanel pnBtConnect = new JPanel();
    private FlowLayout ltBtConnect = new FlowLayout();
    private Button btConnect = new Button("Entrar");

    /**
     * method Login(). Is the constructor of the class, your responsibility is
     * initialize and define the basic attributes of the view.
     */
    public Login() {
        initialize("Agenda: Conecte-se", windowWidth, windowHeight);

        setContainer();
        setPanel();

        setPnUserName();
        setPnPassword();
        setPnBtConnect();

        setListeners();
    }

    /**
     * method setContainer(). Is responsible for defining container of parecent
     * view.
     *
     * @return void
     */
    @Override
    public void setContainer() {
        container.setLayout(new BorderLayout());
        container = getContentPane();
    }

    /**
     * method setPanel(). Is responsible for defining the primary panel of the
     * view.
     *
     * @return void
     */
    public void setPanel() {
        pn.add(pnUserName);
        pn.add(pnPassword);
        pn.add(pnBtConnect);
        pn.setPreferredSize(new Dimension(windowWidth, windowHeight));
        pn.setLayout(new BoxLayout(pn, BoxLayout.Y_AXIS));
        pnBorder.setTitleFont(new Font("Arial", Font.BOLD, 15));
        pnBorder.setTitleColor(Color.DARK_GRAY);
        pn.setBorder(pnBorder);

        container.add(pn, BorderLayout.CENTER);
    }

    /**
     * method setPnUserName(). Is responsible for defining the name area.
     *
     * @return void
     */
    public void setPnUserName() {
        ltUserName.setAlignment((int) LEFT_ALIGNMENT);
        lbUserName.setFont(new Font("Arial", Font.PLAIN, 13));
        tfUserName.setPreferredSize(new Dimension(325, 30));
        pnUserName.setLayout(ltUserName);
        pnUserName.add(lbUserName);
        pnUserName.add(tfUserName);
    }

    /**
     * method setPnPassword(). Is responsible for defining the password area.
     *
     * @return void
     */
    public void setPnPassword() {
        ltPassword.setAlignment((int) LEFT_ALIGNMENT);
        lbPassword.setFont(new Font("Arial", Font.PLAIN, 13));
        tfPassword.setPreferredSize(new Dimension(325, 30));
        pnPassword.setLayout(ltPassword);
        pnPassword.add(lbPassword);
        pnPassword.add(tfPassword);
    }

    /**
     * method setPnBtConnect(). Is responsible for defining the BtConnect area.
     *
     * @return void
     */
    public void setPnBtConnect() {
        btConnect.setFont(new Font("Arial", Font.BOLD, 15));
        btConnect.setBackground(Color.LIGHT_GRAY);

        btConnect.setPreferredSize(new Dimension(325, 30));

        pnBtConnect.setLayout(ltBtConnect);
        pnBtConnect.add(btConnect);
    }

    /**
     * method setListeners(). Is reponsible for listen the connect button of the
     * view.
     *
     * @return void
     */
    public void setListeners() {
        btConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ac) {
                View.views.get("login").setVisible(false);
                View.views.get("diary").setVisible(true);
            }
        });
    }
}

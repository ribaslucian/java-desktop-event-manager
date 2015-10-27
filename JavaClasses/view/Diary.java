/**
 * @author Lucian Rossoni Ribas <ribas.lucian@gmail.com>
 * @author Vinicius Alonso <?>
 *
 * @version 1.0
 *
 * The Diary view class represent the area for managent the events.s
 *
 * sm.malanche@gmail.com 4532848815 8815
 *
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
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;
import view.element.ButtonColumn;

public class Diary extends View {

    /**
     * attribute windowWidth, windowHeight. Attributes responsible for size of
     * the view.
     */
    private int windowWidth = 860;
    private int windowHeight = 414;

    /**
     * attribute pnLeft. Represents the main panel of the left column.
     */
    private JPanel pnLeft = new JPanel();
    private TitledBorder tbPnLeft = new TitledBorder("Adicionar Evento");

    /**
     * attribute pnRight. Represents the main panel of the right column.
     */
    private JPanel pnRight = new JPanel();
    private TitledBorder tbPnRight = new TitledBorder("Eventos Registrados");
    private JScrollPane scRight;

    /**
     * attributes with sufixe "Title". represents the elements that make up the
     * area Title.
     */
    private JPanel pnTitle = new JPanel();
    private FlowLayout ltTitle = new FlowLayout();
    private JLabel lbTitle = new JLabel("Título:");
    private JTextField tfTitle = new JTextField();

    /**
     * attributes with sufixe "Date". represents the elements that make up the
     * area Date.
     */
    private JPanel pnDate = new JPanel();
    private FlowLayout ltDate = new FlowLayout();
    private JLabel lbDate = new JLabel("Data:");
    private JFormattedTextField tfDate;

    /**
     * attributes with sufixe "Description". represents the elements that make up
     * the area Description.
     */
    private JPanel pnDescription = new JPanel();
    private FlowLayout ltDescription = new FlowLayout();
    private JLabel lbDescription = new JLabel("Descrição: ");
    private JTextArea tfDescription = new JTextArea();

    /**
     * attribute btCreate. Is the button that creates a new record.
     */
    private Button btCreate = new Button("Criar");

    /**
     * attribute btCreate. Is reponsive for delete and list events.
     */
    private JTable tbEvents = new JTable();

    /**
     * method Diary(). Is the constructor of the class, your responsibility is
     * initialize and define the basic attributes of the view.
     *
     * @return void
     */
    public Diary() {
        initialize("Agenda: Gerenciamento de Evetos", windowWidth, windowHeight);
        setContainer();

        setPnLeft();
        setPnRight();
    }

    /**
     * method setContainer(). Is responsible for defining container of parecent
     * view.
     *
     * @return void
     */
    @Override
    void setContainer() {
        container.setLayout(new BorderLayout());
        container = getContentPane();
    }

    /**
     * method setPnLeft(). Is responsible for defining panel of the left column.
     *
     * @return void
     */
    public void setPnLeft() {
        pnLeft.setPreferredSize(new Dimension(270, 400));
        pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
        tbPnLeft.setTitleFont(new Font("Arial", Font.BOLD, 18));
        tbPnLeft.setTitleColor(Color.DARK_GRAY);
        pnLeft.setBorder(tbPnLeft);

        setPnTitle();

        try {
            setPnDate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        setPnDescription();
        setBtCreate();

        container.add(pnLeft, BorderLayout.WEST);
    }

    /**
     * method setPnRight(). Is responsible for defining panel of the right
     * column.
     *
     * @return void
     */
    public void setPnRight() {
        pnRight.setPreferredSize(new Dimension(585, 400));
        pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
        tbPnRight.setTitleFont(new Font("Arial", Font.BOLD, 18));
        tbPnRight.setTitleColor(Color.DARK_GRAY);
        pnRight.setBorder(tbPnRight);

        setTable();

        container.add(pnRight, BorderLayout.EAST);
    }

    /**
     * method setPnTitle(). Is responsible for defining the title area.
     *
     * @return void
     */
    public void setPnTitle() {
        ltTitle.setAlignment((int) LEFT_ALIGNMENT);
        lbTitle.setFont(new Font("Arial", Font.PLAIN, 16));
        tfTitle.setPreferredSize(new Dimension(250, 32));

        pnTitle.setLayout(ltTitle);
        pnTitle.add(lbTitle);
        pnTitle.add(tfTitle);

        pnLeft.add(pnTitle);
    }

    /**
     * method setPnDate(). Is responsible for defining the date area.
     *
     * @return void
     */
    public void setPnDate() throws ParseException {
        ltDate.setAlignment((int) LEFT_ALIGNMENT);
        lbDate.setFont(new Font("Arial", Font.PLAIN, 16));

        MaskFormatter mkDate = new MaskFormatter("##/##/####");
        mkDate.setPlaceholderCharacter('_');

        tfDate = new JFormattedTextField(mkDate);
        tfDate.setPreferredSize(new Dimension(250, 32));

        pnDate.setLayout(ltDate);
        pnDate.add(lbDate);
        pnDate.add(tfDate);

        pnLeft.add(pnDate);
    }

    /**
     * method setPnDescription(). Is responsible for defining the description
     * area.
     *
     * @return void
     */
    public void setPnDescription() {
        ltDescription.setAlignment((int) LEFT_ALIGNMENT);
        lbDescription.setFont(new Font("Arial", Font.PLAIN, 16));
        tfDescription.setPreferredSize(new Dimension(250, 150));

        pnDescription.setLayout(ltDescription);
        pnDescription.add(lbDescription);
        pnDescription.add(tfDescription);

        pnLeft.add(pnDescription);
    }

    /**
     * method setBtCreate(). Is responsible for defining the button that create
     * de event.
     *
     * @return void
     */
    public void setBtCreate() {
        JPanel pnBtCreate = new JPanel(new FlowLayout());
        pnBtCreate.add(btCreate);

        btCreate.setFont(new Font("Arial", Font.BOLD, 14));
        btCreate.setPreferredSize(new Dimension(250, 35));

        pnLeft.add(pnBtCreate);
    }

    /**
     * method setTable(). Is responsible for defining the table that is
     * delete and list event.
     *
     * @return void
     */
    public void setTable() {
        String[] columns = {"Data", "Título", "Descrição", ""};

        String[][] rows = new String[100][4];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 3) {
                    rows[i][j] = "Apagar";
                } else {
                    rows[i][j] = "a" + (i + 1) + "," + (j + 1);
                }
            }
        }

        tbEvents.setModel(new DefaultTableModel(rows, columns));

        setListeners();

        scRight = tbEvents.createScrollPaneForTable(tbEvents);
        pnRight.add(scRight);
    }

    /**
     * method setListeners(). Is reponsible for listen the create and delete
     * event button of the view.
     *
     * @return void
     */
    public void setListeners() {
        Action delete = new AbstractAction() {
            private int dialogButton;

            public void actionPerformed(ActionEvent e) {
                JTable tbEvents = (JTable) e.getSource();
                int row = Integer.valueOf(e.getActionCommand());

                String eventTitle = (String) tbEvents.getModel().getValueAt(row, 1);
                int dialogResult = JOptionPane.showConfirmDialog(null, "Você tem Certeza que deseja Deletar o Evento \"" + eventTitle + "\".", "Warning", dialogButton);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    ((DefaultTableModel) tbEvents.getModel()).removeRow(row);
                    JOptionPane.showMessageDialog(View.views.get("diary"), "Evento \"" + eventTitle + "\" foi deletado.");
                }
            }
        };
        ButtonColumn btDelete = new ButtonColumn(tbEvents, delete, 3);

        btCreate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ac) {
                DefaultTableModel model = (DefaultTableModel) tbEvents.getModel();

                Vector row = new Vector();
                row.add(tfDate.getText());
                row.add(tfTitle.getText());
                row.add(tfDescription.getText());
                row.add("Apagar");
                model.addRow(row);

                JOptionPane.showMessageDialog(null, "Evento \"" + tfTitle.getText() + "\" criado com sucesso.");

                tfDate.setText("");
                tfTitle.setText("");
                tfDescription.setText("");
            }
        });
    }

}

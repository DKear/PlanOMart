package admin.main.panels;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class AdminMainBodyPanel extends JPanel{

    //private JTable returnField;
    public JTextArea returnField;
    public DropBoxPanel dropBoxPanel;

    public AdminMainBodyPanel(){
        setBorder(new BevelBorder(BevelBorder.RAISED));
        JScrollPane scroll;

        returnField = new JTextArea();
        returnField.setLineWrap(true);
        returnField.setWrapStyleWord(true);
        returnField.setFont(new Font("Arial", Font.PLAIN, 42));
        returnField.setEditable(false);

        scroll = new JScrollPane(returnField, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        dropBoxPanel = new DropBoxPanel();

        setLayout(new MigLayout("insets 0 0","[fill,70%][fill,30%]","[grow]"));
        add(scroll, "grow, span 4");
        add(dropBoxPanel, "grow");
    }

    public JTextArea getReturnField() {
        return returnField;
    }
}
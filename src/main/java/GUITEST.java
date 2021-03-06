import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUITEST {
    private JFrame myframe;
    private JDialog mydialog;

    public GUITEST() {
        super();
        myframe = new JFrame(); // instantiation
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        myframe.setSize(screenSize.width, screenSize.height);
        myframe.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnNewWindow = new JButton("Admin");
        btnNewWindow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mydialog = new JDialog();
                mydialog.setSize(screenSize.width, screenSize.height);
                mydialog.setTitle("Admin Window");
                mydialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL); // prevent user from doing something else
                mydialog.setVisible(true);
            }
        });
        myframe.getContentPane().add(btnNewWindow);

        JButton btnCloseProgram = new JButton("Close Program");
        btnCloseProgram.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                myframe.dispose();
            }
        });
        myframe.getContentPane().add(btnCloseProgram);
        myframe.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUITEST();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
    }
}

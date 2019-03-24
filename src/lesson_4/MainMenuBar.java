package lesson_4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuBar extends JMenuBar implements ActionListener {
    public MainMenuBar() {
        super();
        JMenu mFile = new JMenu("File");
        JMenu mEdit = new JMenu("Edit");
        JMenuItem miFileNew = new JMenuItem("New");
        JMenuItem miFileExit = new JMenuItem("Exit");
        add(mFile);
        add(mEdit);
        mFile.add(miFileNew);
        mFile.addSeparator(); // разделительная линия в меню
        mFile.add(miFileExit);

        miFileExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}

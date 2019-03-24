package lesson_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends JFrame implements ActionListener {
    private JTextArea chatText;
    private JTextField messageText;
    private JButton sendButton;
    private MainMenuBar mainMenuBar;


    public ChatWindow() {
        setTitle("Окно чата");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 500);

        mainMenuBar = new MainMenuBar();
        add(mainMenuBar, BorderLayout.NORTH);

        chatText = new JTextArea();
        chatText.setEnabled(false);
        chatText.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(chatText);
        add(scrollPane, BorderLayout.CENTER);

        JPanel masssegePanel = new JPanel(new BorderLayout());
        add(masssegePanel, BorderLayout.SOUTH);

        messageText = new JTextField("");
        masssegePanel.add(messageText,BorderLayout.CENTER);

        sendButton = new JButton("Send");
        masssegePanel.add(sendButton, BorderLayout.SOUTH);

        messageText.addActionListener(this);
        sendButton.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        chatText.setText(chatText.getText() + messageText.getText() + "\n");
        messageText.setText("");
    }
}

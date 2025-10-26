package ui;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import misc.Login;

public class MainWindow {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel messageLabel;
    private JButton loginButton;

    public MainWindow() {
        showLoginScreen();
    }

public void showLoginScreen() {
    frame = new JFrame("Login - Student Management System");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 250);
    frame.setLocationRelativeTo(null);
    frame.setLayout(new GridLayout(4, 1, 10, 10));

    usernameField = new JTextField();
    passwordField = new JPasswordField();

    Dimension fieldSize = new Dimension(180, 25);
    usernameField.setPreferredSize(fieldSize);
    passwordField.setPreferredSize(fieldSize);

    messageLabel = new JLabel("", JLabel.CENTER);
    messageLabel.setForeground(Color.RED);

    loginButton = new JButton("Login");

    // Username row
    JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
    userPanel.add(new JLabel("Username:"));
    userPanel.add(usernameField);

    // Password row
    JPanel passPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
    passPanel.add(new JLabel("Password:"));
    passPanel.add(passwordField);

    // Login button row
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    buttonPanel.add(loginButton);

    frame.add(userPanel);
    frame.add(passPanel);
    frame.add(buttonPanel);
    frame.add(messageLabel);
    
    loginButton.addActionListener(e -> {
        try{

        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        boolean hasError = false;
        
        usernameField.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.GRAY, 1));
        passwordField.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.GRAY, 1));

        if (username.isEmpty()) {
            usernameField.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.RED, 2));
            hasError = true;
        }
        
        if (password.isEmpty()) {
            passwordField.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.RED, 2));
            hasError = true;
        }
        
        if (hasError) {
            JOptionPane.showMessageDialog(null, "Please fill all required fields.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return; 
        }
       
        if (Login.user_login(username, password)) {
               HomePage h = new HomePage();
               h.setVisible(true);
               frame.setVisible(false);
        } else {
              messageLabel.setText("Invalid username or password!");
            }
        } catch (IllegalArgumentException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Validation Error", JOptionPane.ERROR_MESSAGE);
    } 
    });

    frame.setVisible(true);
}

}

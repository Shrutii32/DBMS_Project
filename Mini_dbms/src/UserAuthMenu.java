import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JPanel;

public class UserAuthMenu extends JFrame {

    public UserAuthMenu() {
        setTitle("User Menu - Recipe Recommendations");
        setSize(1400, 872);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);
        UserLogin u = new UserLogin();
        // === Gradient Background Panel ===
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();

                // Soft orange-pink gradient (like Login theme)
                Color c1 = new Color(255, 200, 180);
                Color c2 = new Color(255, 150, 120);
                GradientPaint gp = new GradientPaint(0, 0, c1, 0, height, c2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, width, height);
            }
        };
        backgroundPanel.setLayout(new GridBagLayout());

        // === Center translucent panel ===
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(new Color(255, 255, 255, 180));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(50, 120, 50, 120));

        // === Title ===
        JLabel title = new JLabel("👤 User Authentication Menu");
        title.setFont(new Font("SansSerif", Font.BOLD, 26));
        title.setForeground(new Color(60, 40, 30));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Please select an option to continue");
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 18));
        subtitle.setForeground(new Color(80, 60, 50));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        menuPanel.add(title);
        menuPanel.add(Box.createVerticalStrut(15));
        menuPanel.add(subtitle);
        menuPanel.add(Box.createVerticalStrut(40));

        // === Buttons ===
        JButton loginBtn = new JButton("Login");
        JButton signupBtn = new JButton("Sign Up");
        JButton backBtn = new JButton("Back to Main Menu");

        JButton[] buttons = { loginBtn, signupBtn, backBtn };
        for (JButton btn : buttons) {
            btn.setFont(new Font("SansSerif", Font.BOLD, 18));
            btn.setBackground(new Color(255, 255, 255, 220));
            btn.setForeground(new Color(50, 30, 20));
            btn.setFocusPainted(false);
            btn.setMaximumSize(new Dimension(300, 50));
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

            // Hover effect
            btn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    btn.setBackground(new Color(255, 240, 200));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    btn.setBackground(new Color(255, 255, 255, 220));
                }
            });
        }

        menuPanel.add(loginBtn);
        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(signupBtn);
        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(backBtn);

        // Add menu panel to background
        backgroundPanel.add(menuPanel);
        add(backgroundPanel);

        setVisible(true);

        // === Button Actions ===
        loginBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Opening User Login...");
            new UserLogin();
            dispose();
        });

        signupBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Opening User Signup...");
            new UserSignup();
            dispose();
        });

        backBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Returning to Main Menu...");
            new MainMenu();
            dispose();
        });
    }

    public static void main(String[] args) {
        new UserAuthMenu();
    }
}
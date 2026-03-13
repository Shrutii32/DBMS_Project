import javax.swing.*;
import java.awt.*;

//-import java.awt.event.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Recipe Recommendations");
        setSize(1400, 872);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // === Background Image ===
        ImageIcon bg = new ImageIcon("Landing.png"); // use same image for consistency
        JLabel background = new JLabel(bg);
        background.setLayout(new GridBagLayout());
        setContentPane(background);

        // === Center Panel ===
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
        mainPanel.setBackground(new Color(255, 255, 255, 150)); // semi-transparent white

        // === Title ===
        JLabel title = new JLabel(" Personalized Recipe Recommendation System");
        title.setFont(new Font("SansSerif", Font.BOLD, 26));
        title.setForeground(new Color(60, 40, 30));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // === Subtitle ===
        JLabel subtitle = new JLabel("Welcome! Choose your menu to continue");
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 18));
        subtitle.setForeground(new Color(80, 60, 50));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(title);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(subtitle);
        mainPanel.add(Box.createVerticalStrut(40));

        // === Buttons ===
        JButton adminBtn = new JButton("Admin Menu");
        JButton userBtn = new JButton("User Menu");
        JButton exitBtn = new JButton("Exit");

        JButton[] buttons = { adminBtn, userBtn, exitBtn };
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

        // Add buttons to panel
        mainPanel.add(adminBtn);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(userBtn);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(exitBtn);

        // Add main panel to background
        background.add(mainPanel);

        setVisible(true);

        // === Button Actions ===
        adminBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Opening Admin Menu...");
            // new AdminMenu();
            dispose();
        });

        userBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Opening User Menu...");
            new UserAuthMenu();
            dispose();
        });

        exitBtn.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
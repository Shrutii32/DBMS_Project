import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UserLogin {
    UserLogin() {
        JFrame frame = new JFrame("Recipe Recommendations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 872);
        frame.setLayout(new BorderLayout());

        // Background image
        ImageIcon bg = new ImageIcon("Landing.png");
        JLabel background = new JLabel(bg);
        background.setLayout(new GridBagLayout()); // allows centered panel
        frame.setContentPane(background);

        // Login panel
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        loginPanel.setBackground(new Color(255, 255, 255, 150)); // translucent white

        // Labels and fields
        JLabel l1 = new JLabel("Email:");
        JTextField t1 = new JTextField(20);
        JLabel l2 = new JLabel("Password:");
        JPasswordField t2 = new JPasswordField(20);
        JButton btn = new JButton("Login");
        JButton BackBtn = new JButton("Back");

        // Fonts
        l1.setFont(new Font("SansSerif", Font.PLAIN, 16));
        l2.setFont(new Font("SansSerif", Font.PLAIN, 16));
        btn.setFont(new Font("SansSerif", Font.BOLD, 16));
        BackBtn.setFont(new Font("SansSerif", Font.BOLD, 16));

        // Add components
        loginPanel.add(l1);
        loginPanel.add(t1);
        loginPanel.add(Box.createVerticalStrut(10));
        loginPanel.add(l2);
        loginPanel.add(t2);
        loginPanel.add(Box.createVerticalStrut(20));
        loginPanel.add(btn);
        loginPanel.add(BackBtn);

        // Add login panel to background (centered)
        background.add(loginPanel);

        // Show frame
        frame.setVisible(true);

        // Button Action
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = t1.getText();
                String password = new String(t2.getPassword());

                try (Connection con = DBConnection.getConnection()) {
                    String sql = "SELECT * FROM User WHERE email=? AND password=?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, email);
                    ps.setString(2, password);

                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(frame, "Hello " + rs.getString("UF_name") + "!!");
                        new AfterLogin(rs.getInt("u_id"));
                        // new Recipes(); // open next page
                        frame.dispose(); // close login window
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid email or password");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                }
            }
        });

        BackBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Returning to Main Menu...");
            new MainMenu();
            frame.dispose();
        });

    }

    public static void main(String[] args) {
        new UserLogin();

    }
}

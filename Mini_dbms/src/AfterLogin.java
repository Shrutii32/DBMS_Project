
import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
import java.sql.*;

public class AfterLogin {
    AfterLogin(int current_id) {
        JFrame frame = new JFrame("Recipe Recommendations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 872);
        frame.setLayout(new BorderLayout());

        // === Background image ===
        ImageIcon bg = new ImageIcon("Landing.png");
        JLabel background = new JLabel(bg);
        background.setLayout(new GridBagLayout());
        frame.setContentPane(background);

        // === Center translucent panel ===
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
        menuPanel.setBackground(new Color(255, 255, 255, 180));

        JLabel title = new JLabel(" Welcome to Recipe Menu");
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setForeground(new Color(60, 40, 30));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton hbtn = new JButton("View History");
        JButton rbtn = new JButton("Find Recipes");
        hbtn.setFont(new Font("SansSerif", Font.BOLD, 22));
        menuPanel.add(hbtn);
        rbtn.setFont(new Font("SansSerif", Font.BOLD, 22));
        menuPanel.add(rbtn);

        menuPanel.add(title);
        menuPanel.add(Box.createVerticalStrut(40));
        menuPanel.add(hbtn);
        menuPanel.add(Box.createVerticalStrut(30));
        menuPanel.add(rbtn);

        background.add(menuPanel);
        frame.setVisible(true);

        // === Button Actions ===
        hbtn.addActionListener(e -> showHistory(current_id));
        // new RecipeFilter(current_id);
        rbtn.addActionListener(e -> {
            new RecipeFilter(current_id);
            // r.main(null);
            dispose();
        });
        // call reciepe );
    }

    private void dispose() {
    }

    // METHOD 1: Show History
    private void showHistory(int userId) {
        JFrame historyFrame = new JFrame("Your History");
        historyFrame.setSize(700, 500);
        historyFrame.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        historyFrame.add(scrollPane, BorderLayout.CENTER);

        try (Connection con = DBConnection.getConnection()) {
            String sql = """
                        SELECT r.rec_id, r.R_name, r.Descr
                        FROM Selected s
                        JOIN Recipes r ON s.rec_id = r.rec_id
                        WHERE s.u_id = ?
                    """;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            boolean found = false;
            while (rs.next()) {
                found = true;
                int recipeId = rs.getInt("rec_id");
                String name = rs.getString("R_name");
                String descr = rs.getString("Descr");

                JPanel recipePanel = new JPanel(new BorderLayout());
                recipePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                JTextArea area = new JTextArea("🍽 " + name + "\n\n" + descr);
                area.setEditable(false);
                area.setLineWrap(true);
                area.setWrapStyleWord(true);
                area.setFont(new Font("SansSerif", Font.PLAIN, 14));

                JButton reviewBtn = new JButton("Give Review");
                reviewBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
                reviewBtn.setBackground(new Color(100, 180, 100));
                reviewBtn.setForeground(Color.WHITE);
                reviewBtn.setFocusPainted(false);

                reviewBtn.addActionListener(e -> {
                    JOptionPane.showMessageDialog(historyFrame, "Open review for Recipe ID: " + recipeId);
                    new reviews(userId);
                    historyFrame.dispose();
                });

                recipePanel.add(area, BorderLayout.CENTER);
                recipePanel.add(reviewBtn, BorderLayout.EAST);

                contentPanel.add(recipePanel);
            }

            if (!found) {
                JLabel emptyLabel = new JLabel("No recipes found in your history.");
                emptyLabel.setFont(new Font("SansSerif", Font.ITALIC, 16));
                emptyLabel.setHorizontalAlignment(SwingConstants.CENTER);
                contentPanel.add(emptyLabel);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(historyFrame, "Error fetching history!");
        }

        historyFrame.setLocationRelativeTo(null);
        historyFrame.setVisible(true);
    }

}

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class reviews {

    private int recipeId;

    public reviews(int recipeId) {
        this.recipeId = recipeId;
        createReviewFrame();
    }

    private void createReviewFrame() {
        JFrame frame = new JFrame("Add Review");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel ratingLabel = new JLabel("Rate this recipe (1–5):");
        JTextField ratingField = new JTextField();

        JLabel reviewLabel = new JLabel("Write your review:");
        JTextArea reviewArea = new JTextArea(5, 20);
        reviewArea.setLineWrap(true);
        reviewArea.setWrapStyleWord(true);

        JButton submitBtn = new JButton("Submit");
        submitBtn.setBackground(new Color(34, 139, 34));
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setFont(new Font("SansSerif", Font.BOLD, 14));

        submitBtn.addActionListener(e -> {
            String reviewText = reviewArea.getText().trim();
            double rating;

            try {
                rating = Double.parseDouble(ratingField.getText());
                if (rating < 1.0 || rating > 5.0) {
                    JOptionPane.showMessageDialog(frame, "Rating must be between 1.0 and 5.0!");
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid numeric rating!");
                return;
            }

            if (reviewText.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Review cannot be empty!");
                return;
            }

            addReviewToDatabase(recipeId, reviewText, rating);
            JOptionPane.showMessageDialog(frame, "Review submitted successfully!");
            frame.dispose();
        });

        panel.add(ratingLabel);
        panel.add(ratingField);
        panel.add(reviewLabel);
        panel.add(new JScrollPane(reviewArea));

        frame.add(panel, BorderLayout.CENTER);
        frame.add(submitBtn, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void addReviewToDatabase(int recipeId, String reviewText, double rating) {
        String sql = "INSERT INTO reviews (rec_id, reviews, ratings) VALUES (?, ?, ?)";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, recipeId);
            ps.setString(2, reviewText);
            ps.setDouble(3, rating);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Recipes {
    public Recipes(String ingList, String cuisine, String level, String protein, String calories, String fats,
            String carbs, String sugar, String fibre, int userId) {

        JFrame frame = new JFrame("Filtered Recipes");
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel recipePanel = new JPanel();
        recipePanel.setLayout(new BoxLayout(recipePanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(recipePanel);
        frame.add(scrollPane, BorderLayout.CENTER);

        try {
            Connection con = DBConnection.getConnection();

            // Call your stored procedure instead of a fixed query
            String sql = "{ CALL FilterRecipes(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
            CallableStatement cs = con.prepareCall(sql);

            cs.setString(1, ingList);
            cs.setString(2, cuisine);
            cs.setString(3, level);
            cs.setString(4, protein);
            cs.setString(5, calories);
            cs.setString(6, fats);
            cs.setString(7, carbs);
            cs.setString(8, sugar);
            cs.setString(9, fibre);
            cs.setInt(10, userId);

            ResultSet rs = cs.executeQuery();

            boolean hasResults = false;

            while (rs.next()) {
                hasResults = true;
                String name = rs.getString("R_name");
                int r_id = rs.getInt("rec_id");
                String recCuisine = rs.getString("Cuisine");
                double recCalories = rs.getDouble("Calories");
                double recProtein = rs.getDouble("Protein");
                double recCarbs = rs.getDouble("Carbs");
                double recFibre = rs.getDouble("Fibre");
                double recSugar = rs.getDouble("Sugar");
                double Fats = rs.getDouble("Fats");
                int time = rs.getInt("Time");
                String recLevel = rs.getString("Level");
                String instructions = rs.getString("Instructions");
                String descr = rs.getString("Descr");

                JPanel card = new JPanel();
                card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
                card.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                card.setBackground(new Color(245, 245, 245));
                card.setMaximumSize(new Dimension(500, 150));

                JLabel title = new JLabel("🍽 " + name);
                title.setFont(new Font("SansSerif", Font.BOLD, 18));
                JLabel details = new JLabel(
                        "Cuisine: " + recCuisine +
                                " | Calories: " + recCalories +
                                " | Protein: " + recProtein +
                                " | Carbs: " + recCarbs +
                                " | Fibre: " + recFibre +
                                " | Sugar: " + recSugar +
                                " | Time: " + time + " min" +
                                " | Level: " + recLevel);

                JButton viewBtn = new JButton("View Details");
                JButton selectBtn = new JButton("Select");

                viewBtn.addActionListener(e -> {
                    showRecipeDetails(r_id, name, descr, instructions, recCuisine, recCalories, recProtein, time,
                            recLevel,
                            Fats, recCarbs, recSugar, recFibre);
                });

                selectBtn.addActionListener(e -> {
                    addRecipeDetails(userId, r_id);
                });

                card.add(title);
                card.add(details);
                card.add(Box.createRigidArea(new Dimension(0, 5)));
                card.add(viewBtn);
                card.add(selectBtn);

                recipePanel.add(Box.createRigidArea(new Dimension(0, 10)));
                recipePanel.add(card);
            }

            if (!hasResults) {
                recipePanel.add(new JLabel("No recipes found for selected filters."));
            }

            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
        }

        frame.setVisible(true);
    }

    private void showRecipeDetails(int recipeId, String name, String descr, String instructions, String cuisine,
            Double cal, Double protein, int time, String level, Double fats, Double carbs,
            Double sugar, Double fibre) {

        JDialog dialog = new JDialog((Frame) null, "Recipe Details", true);
        dialog.setSize(500, 600);
        dialog.setLayout(new BorderLayout());

        // --- Fetch ingredients for the recipe ---
        StringBuilder ingredientList = new StringBuilder();
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT Ingredient FROM Recipe_Ingredients WHERE rec_id = ?");
            ps.setInt(1, recipeId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ingredientList.append("• ").append(rs.getString("Ingredient")).append("\n");
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            ingredientList.append("Error loading ingredients.\n");
            e.printStackTrace();
        }

        // --- Display all details including ingredients ---
        JTextArea details = new JTextArea();
        details.setEditable(false);
        details.setLineWrap(true);
        details.setWrapStyleWord(true);
        details.setText(
                "🍽 " + name + "\n\n" +
                        "Cuisine: " + cuisine + "\n" +
                        "Calories: " + cal + "\n" +
                        "Protein: " + protein + "\n" +
                        "Sugar: " + sugar + "\n" +
                        "Fibre: " + fibre + "\n" +
                        "Fats: " + fats + "\n" +
                        "Carbs: " + carbs + "\n" +
                        "Time: " + time + " min\n" +
                        "Difficulty: " + level + "\n\n" +
                        "🧂 Ingredients:\n" + ingredientList.toString() + "\n" +
                        "📝 Description:\n" + descr + "\n\n" +
                        "👨‍🍳 Instructions:\n" + instructions);

        JScrollPane scroll = new JScrollPane(details);
        dialog.add(scroll, BorderLayout.CENTER);

        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> dialog.dispose());
        dialog.add(closeBtn, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    private void addRecipeDetails(int userId, int recipe_id) {
        String sql = "INSERT INTO Selected (u_id, rec_id) VALUES (?, ?)";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, userId);
            ps.setInt(2, recipe_id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Recipe added to Selected list!");
            }

            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error adding recipe: " + e.getMessage());
        }
    }

    /*
     * public static void main(String[] args) {
     * new Recipes("banana", "Indian", "Any", "Any", "Any", "Any", "Any", "Any",
     * "Any", 1);
     * }
     */
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RecipeFilter extends JFrame {
    private DefaultListModel<String> listModel;
    private JList<String> ingredientList;
    private JTextField ingredientField;

    public RecipeFilter(int current_id) {

        Font uiFont = new Font("SansSerif", Font.PLAIN, 20);
        UIManager.put("Label.font", uiFont);
        UIManager.put("Button.font", uiFont);
        UIManager.put("TextField.font", uiFont);
        UIManager.put("ComboBox.font", uiFont);

        setTitle("Recipe Filters");
        setSize(1400, 872);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- Background image ---
        ImageIcon bg = new ImageIcon("Landing.png");
        JLabel background = new JLabel(bg);
        background.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        setContentPane(background);

        // --- Transparent panel for filters ---
        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(new GridLayout(10, 2, 15, 15));
        filterPanel.setBackground(new Color(255, 255, 255, 180));
        filterPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        Font labelFont = new Font("SansSerif", Font.PLAIN, 20);

        // --- Ingredients section ---
        JLabel l1 = new JLabel("Add Ingredients:");
        l1.setFont(labelFont);
        ingredientField = new JTextField(10);
        JButton addBtn = new JButton("Add");
        JButton removeBtn = new JButton("Remove");

        JPanel ingPanel = new JPanel();
        ingPanel.add(ingredientField);
        ingPanel.add(addBtn);
        ingPanel.add(removeBtn);

        listModel = new DefaultListModel<>();
        ingredientList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(ingredientList);
        scrollPane.setPreferredSize(new Dimension(150, 70));

        // Dropdown options
        // String[] anyLowMedHigh = { "Any", "Low", "Medium", "High" };

        // Create combo boxes with variable names so we can access them later
        JComboBox<String> cuisineBox = new JComboBox<>(
                new String[] { "Any", "Indian", "Chinese", "Mexican", "Continental" });
        JComboBox<String> levelBox = new JComboBox<>(new String[] { "Any", "Easy", "Medium", "Hard" });
        JComboBox<String> proteinBox = new JComboBox<>(
                new String[] { "Any", "Low(<10g)", "Medium(10g-20g)", "High(>20g)" });
        JComboBox<String> calorieBox = new JComboBox<>(
                new String[] { "Any", "Low(<250)", "Medium(250-500)", "High(>500)" });
        JComboBox<String> fatBox = new JComboBox<>(new String[] { "Any", "Low(<5g)", "Medium(5g-15g)", "High(>15g)" });
        JComboBox<String> carbBox = new JComboBox<>(
                new String[] { "Any", "Low(<15g)", "Medium(15g-40g)", "High(>40g)" });
        JComboBox<String> fibreBox = new JComboBox<>(new String[] { "Any", "Low(<2g)", "Medium(2g-5g)", "High(>5g)" });
        JComboBox<String> sugarBox = new JComboBox<>(
                new String[] { "Any", "Low(<5g)", "Medium(5g-15g)", "High(>15g)" });

        // Now add them to the filter panel
        filterPanel.add(l1);
        filterPanel.add(ingPanel);
        filterPanel.add(new JLabel("Ingredients List:"));
        filterPanel.add(scrollPane);
        filterPanel.add(new JLabel("Cuisine:"));
        filterPanel.add(cuisineBox);
        filterPanel.add(new JLabel("Difficulty:"));
        filterPanel.add(levelBox);
        filterPanel.add(new JLabel("Protein:"));
        filterPanel.add(proteinBox);
        filterPanel.add(new JLabel("Calories:"));
        filterPanel.add(calorieBox);
        filterPanel.add(new JLabel("Fats:"));
        filterPanel.add(fatBox);
        filterPanel.add(new JLabel("Carbs:"));
        filterPanel.add(carbBox);
        filterPanel.add(new JLabel("Fibre:"));
        filterPanel.add(fibreBox);
        filterPanel.add(new JLabel("Sugar:"));
        filterPanel.add(sugarBox);

        // --- Search button at bottom ---
        JButton searchBtn = new JButton("Search Recipes");
        JButton BackBtn = new JButton("Go Back");
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(255, 255, 255, 150));
        bottomPanel.add(searchBtn);
        bottomPanel.add(BackBtn);

        // --- Add everything to frame ---
        // add(filterPanel, BorderLayout.CENTER);
        JScrollPane scroll = new JScrollPane(filterPanel);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);

        // Use BorderLayout to place scroll in center of the frame
        background.setLayout(new BorderLayout());
        background.add(scroll, BorderLayout.CENTER);
        background.add(bottomPanel, BorderLayout.SOUTH);

        // --- Add button actions ---
        addBtn.addActionListener(e -> {
            String ingredient = ingredientField.getText().trim();
            if (!ingredient.isEmpty() && !listModel.contains(ingredient)) {
                listModel.addElement(ingredient);
                ingredientField.setText("");
            }
        });

        removeBtn.addActionListener(e -> {
            for (String selected : ingredientList.getSelectedValuesList()) {
                listModel.removeElement(selected);
            }
        });

        searchBtn.addActionListener(e -> {
            ArrayList<String> ingredients = new ArrayList<>();
            for (int i = 0; i < listModel.size(); i++)
                ingredients.add(listModel.get(i));
            String ingList = String.join(",", ingredients);

            String cuisine = (String) cuisineBox.getSelectedItem();
            String level = (String) levelBox.getSelectedItem();
            String protein = (String) proteinBox.getSelectedItem();
            String calories = (String) calorieBox.getSelectedItem();
            String fats = (String) fatBox.getSelectedItem();
            String carbs = (String) carbBox.getSelectedItem();
            String fibre = (String) fibreBox.getSelectedItem();
            String sugar = (String) sugarBox.getSelectedItem();

            new Recipes(ingList, cuisine, level, protein, carbs, calories, fats, sugar, fibre, current_id);
        });

        BackBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Returning to Main Menu...");
            new MainMenu();
            dispose();
        });

        setVisible(true);
    }

    /*
     * public static void main(String[] args) {
     * new RecipeFilter(1);
     * }
     */

}

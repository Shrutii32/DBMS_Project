import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class UserSignup extends JFrame {
    private JTextField fnameField, mnameField, lnameField, emailField, contactField, dobField, weightField;
    private JPasswordField passField;
    private JCheckBox[] healthBoxes;

    public UserSignup() {
        setTitle("User Sign Up - Recipe Recommendations");
        setSize(1400, 872);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();
                Color c1 = new Color(255, 220, 200);
                Color c2 = new Color(255, 170, 140);
                GradientPaint gp = new GradientPaint(0, 0, c1, 0, height, c2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, width, height);
            }
        };
        backgroundPanel.setLayout(new GridBagLayout());

        JPanel signupPanel = new JPanel(new GridBagLayout());
        signupPanel.setBackground(new Color(255, 255, 255, 180));
        signupPanel.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        backgroundPanel.add(signupPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("User Sign Up");
        title.setFont(new Font("SansSerif", Font.BOLD, 26));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        signupPanel.add(title, gbc);
        gbc.gridwidth = 1;

        Font fieldFont = new Font("SansSerif", Font.PLAIN, 16);

        // ======= Fields =======
        gbc.gridy++;
        gbc.gridx = 0;
        signupPanel.add(new JLabel("First Name:*"), gbc);
        fnameField = new JTextField(20);
        fnameField.setFont(fieldFont);
        gbc.gridx = 1;
        signupPanel.add(fnameField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        signupPanel.add(new JLabel("Middle Name:"), gbc);
        mnameField = new JTextField(20);
        mnameField.setFont(fieldFont);
        gbc.gridx = 1;
        signupPanel.add(mnameField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        signupPanel.add(new JLabel("Last Name:*"), gbc);
        lnameField = new JTextField(20);
        lnameField.setFont(fieldFont);
        gbc.gridx = 1;
        signupPanel.add(lnameField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        signupPanel.add(new JLabel("Email:*"), gbc);
        emailField = new JTextField(20);
        emailField.setFont(fieldFont);
        gbc.gridx = 1;
        signupPanel.add(emailField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        signupPanel.add(new JLabel("Password:*"), gbc);
        passField = new JPasswordField(20);
        passField.setFont(fieldFont);
        gbc.gridx = 1;
        signupPanel.add(passField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        signupPanel.add(new JLabel("Contact:"), gbc);
        contactField = new JTextField(20);
        contactField.setFont(fieldFont);
        gbc.gridx = 1;
        signupPanel.add(contactField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        signupPanel.add(new JLabel("Date of Birth (YYYY-MM-DD):"), gbc);
        dobField = new JTextField(20);
        dobField.setFont(fieldFont);
        gbc.gridx = 1;
        signupPanel.add(dobField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        signupPanel.add(new JLabel("Weight (kg):"), gbc);
        weightField = new JTextField(20);
        weightField.setFont(fieldFont);
        gbc.gridx = 1;
        signupPanel.add(weightField, gbc);

        // ====== Health Concerns ======
        gbc.gridy++;
        gbc.gridx = 0;
        signupPanel.add(new JLabel("Select Health Concerns:"), gbc);

        JPanel healthPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        String[] concerns = { "Diabetes", "High BP", "Obesity", "Heart Disease", "Thyroid", "Cholesterol", "PCOS",
                "Lactose Intolerance", "None" };
        healthBoxes = new JCheckBox[concerns.length];
        for (int i = 0; i < concerns.length; i++) {
            healthBoxes[i] = new JCheckBox(concerns[i]);
            healthPanel.add(healthBoxes[i]);
        }

        gbc.gridx = 1;
        signupPanel.add(healthPanel, gbc);

        // ===== Buttons =====
        JButton registerBtn = new JButton("Register");
        registerBtn.setFont(new Font("SansSerif", Font.BOLD, 18));
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        signupPanel.add(registerBtn, gbc);

        JButton backBtn = new JButton("Back to Menu");
        gbc.gridy++;
        signupPanel.add(backBtn, gbc);

        add(backgroundPanel);
        setVisible(true);

        registerBtn.addActionListener(e -> registerUser());
        backBtn.addActionListener(e -> {
            new UserAuthMenu();
            dispose();
        });
    }

    private void registerUser() {
        String fname = fnameField.getText().trim();
        String lname = lnameField.getText().trim();
        String email = emailField.getText().trim();
        String pass = new String(passField.getPassword()).trim();
        String dob = dobField.getText().trim();
        String weightStr = weightField.getText().trim();

        if (fname.isEmpty() || lname.isEmpty() || email.isEmpty() || pass.isEmpty() || dob.isEmpty()
                || weightStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all required fields!");
            return;
        }

        try (Connection con = DBConnection.getConnection()) {
            double weight = Double.parseDouble(weightStr);

            // Insert into User table
            String query = "INSERT INTO User (UF_name, UL_name, email, password, dob, weight) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, email);
            ps.setString(4, pass);
            ps.setString(5, dob);
            ps.setDouble(6, weight);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            int userId = 0;
            if (rs.next())
                userId = rs.getInt(1);

            // Insert selected health concerns
            ArrayList<String> selectedConcerns = new ArrayList<>();
            for (JCheckBox cb : healthBoxes) {
                if (cb.isSelected() && !cb.getText().equals("None")) {
                    selectedConcerns.add(cb.getText());
                }
            }

            if (!selectedConcerns.isEmpty()) {
                String hcQuery = "INSERT INTO user_health_concerns (u_id, health_concern) VALUES (?, ?)";
                PreparedStatement ps2 = con.prepareStatement(hcQuery);
                for (String concern : selectedConcerns) {
                    ps2.setInt(1, userId);
                    ps2.setString(2, concern);
                    ps2.executeUpdate();
                }
            }

            JOptionPane.showMessageDialog(this, "User Registered Successfully!");
            new UserAuthMenu();
            dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Weight must be a valid number!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new UserSignup();
    }
}

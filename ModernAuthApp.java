import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class ModernAuthApp extends JFrame {

    private JPanel cardPanel;
    private CardLayout cardLayout;

    // Theme Colors
    private final Color BG_COLOR = new Color(245, 247, 250);
    private final Color PRIMARY_COLOR = new Color(79, 70, 229); // Indigo
    private final Color PRIMARY_HOVER = new Color(67, 56, 202);
    private final Color CARD_BG = Color.WHITE;
    private final Color TEXT_DARK = new Color(30, 41, 59);
    private final Color TEXT_MUTED = new Color(100, 116, 139);
    private final Color BORDER_COLOR = new Color(226, 232, 240);

    public ModernAuthApp() {
        setTitle("Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 560);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main Background Panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(BG_COLOR);

        // Card Container
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setOpaque(false);

        // Add Forms
        cardPanel.add(createLoginForm(), "login");
        cardPanel.add(createRegisterForm(), "register");

        mainPanel.add(cardPanel);
        add(mainPanel);
    }

    // --- LOGIN FORM ---
    private JPanel createLoginForm() {
        RoundedPanel panel = new RoundedPanel(20, CARD_BG);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(30, 30, 30, 30));
        panel.setPreferredSize(new Dimension(340, 460));

        // Header
        JLabel title = new JLabel("Welcome Back");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(TEXT_DARK);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Sign in to continue");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        subtitle.setForeground(TEXT_MUTED);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Inputs
        JTextField emailField = createTextField("Enter your email");
        JPasswordField passwordField = createPasswordField("Enter password");

        // Submit Button
        JButton loginBtn = createPrimaryButton("Sign In");
        loginBtn.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            JOptionPane.showMessageDialog(this, "Logging in with: " + email);
        });

        // Switch to Register Text
        JPanel switchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        switchPanel.setOpaque(false);
        JLabel noAccount = new JLabel("Don't have an account?");
        noAccount.setForeground(TEXT_MUTED);
        noAccount.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        JLabel registerLink = new JLabel("Sign Up");
        registerLink.setForeground(PRIMARY_COLOR);
        registerLink.setFont(new Font("Segoe UI", Font.BOLD, 12));
        registerLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cardLayout.show(cardPanel, "register");
            }
        });

        switchPanel.add(noAccount);
        switchPanel.add(registerLink);

        // Assemble Component Structure
        panel.add(title);
        panel.add(subtitle);
        panel.add(Box.createRigidArea(new Dimension(0, 25)));
        panel.add(createFieldLabel("Email"));
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(emailField);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(createFieldLabel("Password"));
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(passwordField);
        panel.add(Box.createRigidArea(new Dimension(0, 25)));
        panel.add(loginBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(switchPanel);

        return panel;
    }

    // --- REGISTER FORM ---
    private JPanel createRegisterForm() {
        RoundedPanel panel = new RoundedPanel(20, CARD_BG);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(30, 30, 30, 30));
        panel.setPreferredSize(new Dimension(340, 460));

        // Header
        JLabel title = new JLabel("Create Account");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(TEXT_DARK);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Sign up to get started");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        subtitle.setForeground(TEXT_MUTED);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Inputs
        JTextField nameField = createTextField("Full Name");
        JTextField emailField = createTextField("Email Address");
        JPasswordField passwordField = createPasswordField("Create Password");

        // Submit Button
        JButton registerBtn = createPrimaryButton("Sign Up");
        registerBtn.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            JOptionPane.showMessageDialog(this, "Registered user: " + name + " (" + email + ")");
        });

        // Switch to Login Text
        JPanel switchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        switchPanel.setOpaque(false);
        JLabel hasAccount = new JLabel("Already have an account?");
        hasAccount.setForeground(TEXT_MUTED);
        hasAccount.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        JLabel loginLink = new JLabel("Sign In");
        loginLink.setForeground(PRIMARY_COLOR);
        loginLink.setFont(new Font("Segoe UI", Font.BOLD, 12));
        loginLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cardLayout.show(cardPanel, "login");
            }
        });

        switchPanel.add(hasAccount);
        switchPanel.add(loginLink);

        // Assemble Component Structure
        panel.add(title);
        panel.add(subtitle);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(createFieldLabel("Full Name"));
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(nameField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(createFieldLabel("Email"));
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(emailField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(createFieldLabel("Password"));
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(passwordField);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(registerBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(switchPanel);

        return panel;
    }

    // --- UI HELPER METHODS ---

    private JLabel createFieldLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setForeground(TEXT_DARK);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setMaximumSize(new Dimension(280, 20));
        return label;
    }

    private JTextField createTextField(String placeholder) {
        JTextField field = new JTextField();
        styleInputField(field);
        return field;
    }

    private JPasswordField createPasswordField(String placeholder) {
        JPasswordField field = new JPasswordField();
        styleInputField(field);
        return field;
    }

    private void styleInputField(JTextField field) {
        field.setMaximumSize(new Dimension(280, 36));
        field.setPreferredSize(new Dimension(280, 36));
        field.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        field.setForeground(TEXT_DARK);
        field.setCaretColor(PRIMARY_COLOR);
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER_COLOR, 1, true),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
    }

    private JButton createPrimaryButton(String text) {
        JButton button = new JButton(text);
        button.setMaximumSize(new Dimension(280, 40));
        button.setPreferredSize(new Dimension(280, 40));
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(PRIMARY_COLOR);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(PRIMARY_HOVER);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(PRIMARY_COLOR);
            }
        });

        return button;
    }

    // --- CUSTOM ROUNDED CONTAINER ---
    private static class RoundedPanel extends JPanel {
        private final int cornerRadius;
        private final Color backgroundColor;

        public RoundedPanel(int radius, Color bgColor) {
            this.cornerRadius = radius;
            this.backgroundColor = bgColor;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(backgroundColor);
            g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));
            g2.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ModernAuthApp().setVisible(true);
        });
    }
}
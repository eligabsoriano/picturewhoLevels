import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class settings extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        settings frame = new settings();
        frame.setTitle("Settings");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 650);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(131, 101, 172));
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());

        JLabel settingsLabel = new JLabel("Settings");
        settingsLabel.setHorizontalAlignment(JLabel.CENTER);
        settingsLabel.setFont(loadFont("src/PaytoneOne-Regular.ttf", Font.BOLD, 33));
        settingsLabel.setForeground(Color.WHITE);
        settingsLabel.setOpaque(true);
        settingsLabel.setBackground(Color.decode("#5E4580"));
        int topPadding = 30;
        int leftPadding = 0;
        int bottomPadding = 50;
        int rightPadding = 0;
        settingsLabel.setBorder(BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding));

        topPanel.add(settingsLabel, BorderLayout.NORTH);
        frame.add(topPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 1));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        buttonPanel.setBackground(new Color(131, 101, 172));

        // Sounds Button
        JButton soundsButton = createStyledButton("Sounds", Color.decode("#E7E4DB"));
        buttonPanel.add(soundsButton);

        // Notification CheckBox
        JCheckBox notificationCheckBox = new JCheckBox("Notification with free hints");
        notificationCheckBox.setFont(new Font("Arial", Font.PLAIN, 18));
        notificationCheckBox.setForeground(Color.WHITE);
        notificationCheckBox.setOpaque(false);
        notificationCheckBox.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
        // Adjusting checkbox width
        notificationCheckBox.setPreferredSize(new Dimension(300, 30));
        notificationCheckBox.setBackground(Color.decode("#E7E4DB"));
        notificationCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox source = (JCheckBox) e.getSource();
                boolean isSelected = source.isSelected();
                System.out.println("Notification with free hints is " + (isSelected ? "enabled" : "disabled"));
            }
        });
        buttonPanel.add(notificationCheckBox);

        // Account Button
        JButton accountButton = createStyledButton("Manage account", Color.decode("#E7E4DB"));
        buttonPanel.add(accountButton);

        // Settings Button
        JButton settingsButton = createStyledButton("Option in settings", Color.decode("#E7E4DB"));
        buttonPanel.add(settingsButton);

        // Terms of Service Button
        JButton termsOfServiceButton = createStyledButton("Term of Service", Color.decode("#E7E4DB"));
        buttonPanel.add(termsOfServiceButton);

        // Privacy Policy Button
        JButton privacyPolicyButton = createStyledButton("Privacy policy", Color.decode("#E7E4DB"));
        buttonPanel.add(privacyPolicyButton);

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Method to create styled button
    private static JButton createStyledButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Paytone One", Font.BOLD, 23));
        button.setForeground(Color.decode("#5E4580"));
        button.setBackground(backgroundColor);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return button;
    }

    // Method to load custom font with specified style and size
    private static Font loadFont(String path, int style, float size) {
        try {
            File file = new File(path);
            return Font.createFont(Font.TRUETYPE_FONT, file).deriveFont(style, size);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return new Font(Font.SANS_SERIF, Font.PLAIN, (int) size);
        }
    }
}

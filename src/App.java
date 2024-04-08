import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class App extends JFrame {

    private JLabel imageLabel;

    public App() {
        setSize(1000, 650);
        setTitle("Picture Who");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(131, 101, 172));
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());

        //title
        JLabel pictureWhoLabel = new JLabel("PICTURE WHO?");
        pictureWhoLabel.setHorizontalAlignment(JLabel.CENTER);
        pictureWhoLabel.setFont(loadFont("src/PaytoneOne-Regular.ttf", Font.BOLD, 33));
        pictureWhoLabel.setForeground(Color.WHITE);
        pictureWhoLabel.setOpaque(true);
        pictureWhoLabel.setBackground(Color.decode("#5E4580"));
        int topPadding = 30;
        int leftPadding = 0;
        int bottomPadding = 50;
        int rightPadding = 0;
        pictureWhoLabel.setBorder(BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding));

        topPanel.add(pictureWhoLabel, BorderLayout.NORTH);
        add(topPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 430, -30, 430));
        buttonPanel.setBackground(Color.decode("#5E4580"));

        // Play button
        JButton playButton = new JButton("Play");
        playButton.setFont(new Font("segoe ui black", Font.BOLD, 23));
        playButton.setForeground(Color.decode("#5E4580"));
        playButton.setBackground(Color.WHITE);
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openDifficultyWindow();
            }
        });
        buttonPanel.add(playButton);
    
        // Settings button
        JButton settingsButton = new JButton("Settings");
        settingsButton.setFont(new Font("segoe ui black", Font.BOLD, 20));
        settingsButton.setForeground(Color.decode("#5E4580"));
        settingsButton.setBackground(Color.WHITE);
        buttonPanel.add(settingsButton);
    
        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("segoe ui black", Font.BOLD, 23));
        exitButton.setForeground(Color.decode("#5E4580"));
        exitButton.setBackground(Color.WHITE);;
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(App.this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });
        buttonPanel.add(exitButton);
    
        add(buttonPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(Color.decode("#5E4580"));

        ImageIcon imageIcon = new ImageIcon("img/thinking.png");
        JLabel imageLabel = new JLabel(imageIcon);
        bottomPanel.add(imageLabel);

        add(bottomPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    private void openDifficultyWindow() {
        JFrame difficultyFrame = new JFrame("Select Difficulty");
        difficultyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        difficultyFrame.setSize(700, 200);
        difficultyFrame.setResizable(false);
        

        JPanel difficultyPanel = new JPanel(new GridLayout(1, 0));
        difficultyPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        // Buttons for different difficulty levels
        JButton easyButton = new JButton("Easy");
        easyButton.setFont(new Font("segoe ui black", Font.BOLD, 23));
        easyButton.setForeground(Color.decode("#5E4580"));
        easyButton.setBackground(Color.WHITE);

        JButton moderateButton = new JButton("Moderate");
        moderateButton.setFont(new Font("segoe ui black", Font.BOLD, 23));
        moderateButton.setForeground(Color.decode("#5E4580"));
        moderateButton.setBackground(Color.WHITE);

        JButton hardButton = new JButton("Hard");
        hardButton.setFont(new Font("segoe ui black", Font.BOLD, 23));
        hardButton.setForeground(Color.decode("#5E4580"));
        hardButton.setBackground(Color.WHITE);

        easyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(difficultyFrame, "Easy difficulty selected");
                difficultyFrame.dispose();
                new easyLevels();
            }
        });

        moderateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(difficultyFrame, "Moderate difficulty selected");
                difficultyFrame.dispose();
                new moderatelevel1();
            }
        });

        hardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(difficultyFrame, "Hard difficulty selected");
                difficultyFrame.dispose();
                new hardlevel1();
            }
        });

        difficultyPanel.add(easyButton);
        difficultyPanel.add(moderateButton);
        difficultyPanel.add(hardButton);

        difficultyFrame.add(difficultyPanel);
        difficultyFrame.setLocationRelativeTo(null);
        difficultyFrame.setVisible(true);
    }

    // Method to load custom font with specified style and size
    private Font loadFont(String path, int style, float size) {
        try {
            File file = new File(path);
            return Font.createFont(Font.TRUETYPE_FONT, file).deriveFont(style, size);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();

            return new Font(Font.SANS_SERIF, Font.PLAIN, (int) size);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                App game = new App();
                game.setVisible(true);
            }
        });
    }
}
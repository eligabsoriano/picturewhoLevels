import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class easyLevels5 implements ActionListener {
    private JButton submitButton;
    @SuppressWarnings("unused")
    private int currentLevel = 1;

    public easyLevels5() {
        openGameWindow();
    }

    private void openGameWindow() {
        JFrame gameFrame = new JFrame("Picture Who");
        gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameFrame.setSize(1000, 600);

        JPanel mainPanel = new JPanel(new BorderLayout());
        gameFrame.getContentPane().add(mainPanel);

        JPanel imagePanel = new JPanel(new GridLayout(2, 2));
        mainPanel.add(imagePanel, BorderLayout.CENTER);

        // Load different images into ImageIcons
        ImageIcon imageIcon1 = new ImageIcon("img/t.jpg");
        ImageIcon imageIcon2 = new ImageIcon("img/ta.jpg");
        ImageIcon imageIcon3 = new ImageIcon("img/tad.jpg");
        ImageIcon imageIcon4 = new ImageIcon("img/tag.jpg");
        // Scale images to fit within the cells
        Image image1 = imageIcon1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        Image image2 = imageIcon2.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        Image image3 = imageIcon3.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        Image image4 = imageIcon4.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);

        ImageIcon scaledImageIcon1 = new ImageIcon(image1);
        ImageIcon scaledImageIcon2 = new ImageIcon(image2);
        ImageIcon scaledImageIcon3 = new ImageIcon(image3);
        ImageIcon scaledImageIcon4 = new ImageIcon(image4);

        // Create JLabels and set the scaled icons
        JLabel imageLabel1 = new JLabel(scaledImageIcon1);
        JLabel imageLabel2 = new JLabel(scaledImageIcon2);
        JLabel imageLabel3 = new JLabel(scaledImageIcon3);
        JLabel imageLabel4 = new JLabel(scaledImageIcon4);

        imagePanel.add(imageLabel1);
        imagePanel.add(imageLabel2);
        imagePanel.add(imageLabel3);
        imagePanel.add(imageLabel4);

        JPanel answerPanel = new JPanel(new BorderLayout());
        mainPanel.add(answerPanel, BorderLayout.SOUTH);

        JTextField answerField = new JTextField();
        answerField.setPreferredSize(new Dimension(300, 50));
        answerPanel.add(answerField, BorderLayout.CENTER);
        answerField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (submitButton != null) {
                    submitButton.doClick();
                }
            }
        });

        // Initialize the class-level submitButton instead of declaring a new one
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredAnswer = answerField.getText().trim().toLowerCase();
                String correctAnswer = "tag"; // Replace with your actual answer

                if (enteredAnswer.equals(correctAnswer)) {
                    JOptionPane.showMessageDialog(gameFrame, "astig, deanlister ka na nyan");
                    gameFrame.dispose();
                    openNextLevel();
                } else {
                    JOptionPane.showMessageDialog(gameFrame, "yuck");
                }

                answerField.setText("");
            }
        });

        answerPanel.add(submitButton, BorderLayout.EAST);

        gameFrame.pack();
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }
    private void openNextLevel() {
        currentLevel++;
        new easyLevels6(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        openGameWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new easyLevels5(); 
            }
        });
    }
}

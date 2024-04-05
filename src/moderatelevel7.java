import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class moderatelevel7 implements ActionListener {
    private JButton submitButton;
    @SuppressWarnings("unused")
    private int currentLevel = 1;

    public moderatelevel7() {
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

        ImageIcon imageIcon1 = new ImageIcon("img/driver.jpg");
        ImageIcon imageIcon2 = new ImageIcon("img/sleeperdriver.jpg");
        ImageIcon imageIcon3 = new ImageIcon("img/crydriver.jpg");
        ImageIcon imageIcon4 = new ImageIcon("img/olddriver.jpg");

        Image image1 = imageIcon1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        Image image2 = imageIcon2.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        Image image3 = imageIcon3.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        Image image4 = imageIcon4.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);

        ImageIcon scaledImageIcon1 = new ImageIcon(image1);
        ImageIcon scaledImageIcon2 = new ImageIcon(image2);
        ImageIcon scaledImageIcon3 = new ImageIcon(image3);
        ImageIcon scaledImageIcon4 = new ImageIcon(image4);

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

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredAnswer = answerField.getText().trim().toLowerCase();
                String correctAnswer = "driver"; 
        
                if (enteredAnswer.equals(correctAnswer)) {
                    JPanel messagePanel = new JPanel();
                    messagePanel.setLayout(new BorderLayout());
        
                    ImageIcon icon = new ImageIcon("img/6f54a865e73f38212e1a75c99317ef2e.jpg");
                    Image image5 = icon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
                    ImageIcon scaledImageIcon5 = new ImageIcon(image5);
                    JLabel imageLabel5 = new JLabel(scaledImageIcon5);
                    imagePanel.add(imageLabel5);
        
                    messagePanel.add(imageLabel5, BorderLayout.CENTER);
        
                    JOptionPane.showMessageDialog(gameFrame, "wew talino talaga");
        
                    gameFrame.dispose();
                    openNextLevel();
                } else {
                    JOptionPane.showMessageDialog(gameFrame, "OPS ULET BATA");
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
        new moderatelevel8(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        openGameWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new moderatelevel7(); 
            }
        });
    }
}
package minesweeper;
//import javax.swing.border.
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.Random;

public class game extends JFrame {
    
    public game(int size) {
        this.setSize(size*30, size*30 + 50);
        this.setTitle("Minesweeper");
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    private static void setMines(int size) {
        Random rand = new Random();
        
        int noOfBombs = (size*3)/2;
        
        int[] xPoints = new int[noOfBombs];
        for (int i = 0; i < noOfBombs; i++) {
            xPoints[i] = rand.nextInt(noOfBombs + 1);
        }
        
        int[] yPoints = new int[noOfBombs];
        for (int i = 0; i < noOfBombs; i++) {
            yPoints[i] = rand.nextInt(noOfBombs + 1);
        }
        
        for (int i = 0; i < noOfBombs; i++) {
            System.out.println(xPoints[i] + ", " + yPoints[i]);
        }
    }
    
    public static void main(int size) {
        game frame = new game(size);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        panel1 = new JPanel();
        panel2 = new JPanel();

        BoxLayout g1 = new BoxLayout(panel1, BoxLayout.X_AXIS);
        //FlowLayout g1 = new FlowLayout();
        panel1.setLayout(g1);
        JLabel jLabel1 = new JLabel(" Flags = ");
        flagsLabel = new JLabel("  ");
        smileButton = new JButton();
        smileButton.setPreferredSize(new Dimension(30, 30));
        smileButton.setMaximumSize(new Dimension(30, 30));
        //smileButton.setMinimumSize(new Dimension(18, 18));
        smileButton.setBorderPainted(true);
        JLabel jLabel2 = new JLabel(" Time :");
        timeLabel = new JLabel("....");
        // jLabel1.getWidth() == 39
        // flagsLabel.getWidth() == 14
        // smileButton.getWidth() == 30
        // jLabel2.getWidth()) == 37
        
        panel1.add(jLabel1);
        panel1.add(flagsLabel);
        panel1.add(Box.createRigidArea(new Dimension((size-1)*15 - 53,50)));
        panel1.add(smileButton, BorderLayout.PAGE_START);
        panel1.add(Box.createRigidArea(new Dimension((size-1)*15 - 65,50)));
        panel1.add(jLabel2);
        panel1.add(timeLabel);
        
        
        GridLayout g2 = new GridLayout(size, size);
        panel2.setLayout(g2);

        buttons = new JToggleButton[size][size];

        for (int i=0; i<size; i++) {
            for (int j=0; j<size ; j++ ) {
                buttons[i][j] = new JToggleButton();
                buttons[i][j].setPreferredSize(new Dimension(12, 12));
                buttons[i][j].setBorder(new EtchedBorder());
                buttons[i][j].setBackground(Color.LIGHT_GRAY);
                buttons[i][j].setBorderPainted(true);
                buttons[i][j].setToolTipText("It's " + Integer.toString(i) + ", " + Integer.toString(j));
                panel2.add(buttons[i][j]);
            }
        }

        mainPanel.add(panel1);
        mainPanel.add(panel2);
        frame.setContentPane(mainPanel);
        
        // Algorithms
        setMines(size);

    }

    private static JToggleButton[][] buttons;
    private static JPanel panel1;
    private static JPanel panel2;
    private static JLabel flagsLabel;
    private static JButton smileButton;
    private static JLabel timeLabel;
}
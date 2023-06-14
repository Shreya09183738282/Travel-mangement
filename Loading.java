import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Loading extends JFrame implements Runnable {

    private JPanel contentPane;
    private JProgressBar progressBar;
    Connection conn;
    String username;
    int s;
    Thread th;

    public static void main(String[] args) {
        new Loading("").setVisible(true);
    }

    public void setUploading() {
        setVisible(false);
        th.start();
    }

    public void run() {
        try {
            for (int i = 0; i < 200; i++) {
                s = s + 1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();
                if (v < m) {
                    progressBar.setValue(progressBar.getValue() + 1);
                } else {
                    i = 201;
                    setVisible(false);
                    new Home(username).setVisible(true);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Loading(String username) {
        this.username = username;
        th = new Thread((Runnable) this);

        setBounds(500, 200, 650, 400);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(72,209, 204));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbllibraryManagement = new JLabel("Travel and Toursim Application");
        lbllibraryManagement.setForeground(new Color(77, 72, 209));
        lbllibraryManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
        lbllibraryManagement.setBounds(50, 20, 600, 35);
        contentPane.add(lbllibraryManagement);

        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(150, 100, 300, 35);
        contentPane.add(progressBar);

        JLabel lblNewLabel_2 = new JLabel("Loading,Wait....");
        lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lblNewLabel_2.setForeground(new Color(160, 82, 45));
        lblNewLabel_2.setBounds(200, 140, 150, 30);
        contentPane.add(lblNewLabel_2);

        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setBounds(0, 0, 650, 400);
        contentPane.add(panel);

        setUndecorated(true);
        setUploading();
    }
}
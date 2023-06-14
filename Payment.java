import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Prity
 */
public class Payment extends JFrame{
    JButton pay,back;
    public Payment(){

        setLayout(null);
        setBounds(500, 200, 800, 600);

        JLabel label=new JLabel("Pay using Paytm");
        label.setFont(new Font("Raleway", Font.BOLD, 40));
        label.setBounds(50, 20, 350, 45);
        add(label);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i8 = i7.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l4 = new JLabel(i9);
        l4.setBounds(0, 0, 800, 600);
        add(l4);

        pay = new JButton("Pay");
        pay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Paytm().setVisible(true);

            }
        });
        pay.setBounds(420, 0, 80, 40);
        l4.add(pay);

        back=new JButton("Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        back.setBounds(520, 0, 80, 40);
        l4.add(back);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public static void main(String[] args)
    {
        new Payment().setVisible(true);
    }

}
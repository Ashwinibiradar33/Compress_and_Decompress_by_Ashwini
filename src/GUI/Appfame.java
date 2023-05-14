package GUI;
        import comp_decom.Comprssor;
        import comp_decom.Decompreesor;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.*;
        import javax.imageio.plugins.jpeg.JPEGImageReadParam;
        import javax.swing.*;
        import java.io.*;
        import java.awt.image.BufferedImage;

/**
 *
 * @author Ashwini S Biradar
 */
public class Appfame extends JFrame implements ActionListener {
    JButton compressbutton;
    JButton decompressbutton;
    JLabel label;

    Appfame() {
        //close the frame once window is exit
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setTitle("Compressor and Decompressor");
        label = new JLabel("Compressor and Decompressor");
        label.setBounds(200, 20, 800, 30);
        label.setFont(new Font("DIALOG", Font.ITALIC, 25));
        label.setForeground(Color.RED);


        //initialise button with title
        compressbutton = new JButton("Select file to Compress");
        compressbutton.setBounds(50, 100, 200, 30);

        compressbutton.addActionListener(this);
        decompressbutton = new JButton("Select file to Decompress");
        decompressbutton.setBounds(500, 100, 200, 30);
        decompressbutton.addActionListener(this);

        //set size of the frame
        this.setSize(800, 500);
        //set backgraound color

        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);
        //add buttons to frame
        this.add(compressbutton);
        this.add(decompressbutton);
        this.add(label);

        //set visible

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compressbutton) {
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    Comprssor.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }

        }

        if (e.getSource() == decompressbutton) {
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    Decompreesor.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }

        }
    }
}
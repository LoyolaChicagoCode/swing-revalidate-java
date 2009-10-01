package revalidate;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Test {
  public static void main(String[] args) throws IOException {
    final JFrame frame = new JFrame("Revalidate Test");
    frame.getContentPane().setLayout(new GridLayout(0, 1));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);

    String s = null;
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("enter text for labels below:");
    while ((s = in.readLine()) != null) {
      final JLabel l = new JLabel(s);
      SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          frame.getContentPane().add(l);
//      ((JFrame) l.getRootPane().getParent()).pack();
          // better:
          Component root = SwingUtilities.getRoot(l);
          if (root instanceof Window) {
            ( (Window) root).pack();
          }
        }
      });
    }
  }
}
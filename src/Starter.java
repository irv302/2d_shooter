import javax.swing.JFrame;
// import javax.swing.plaf.basic.BasicBorders;

public class Starter extends JFrame {

    public Starter()
    {
        add(new Board());
        setTitle("G A Fire!!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        new Starter();
    }
}

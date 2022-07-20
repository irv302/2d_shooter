import javax.swing.JFrame;
// import javax.swing.plaf.basic.BasicBorders;

public class Starter extends JFrame {

    public Starter()
    {
        add(new Board());
        setTitle("Space Invade");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        new Starter();
    }
}

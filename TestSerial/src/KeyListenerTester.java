
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KeyListenerTester extends JFrame implements KeyListener {

    JLabel label;
	SerialConnection serialConnection;
	
    public KeyListenerTester(String s) {
        super(s);
        JPanel p = new JPanel();
        label = new JLabel("Key Listener!");
        p.add(label);
        add(p);
        addKeyListener(this);
        setSize(200, 100);
        setVisible(true);
		//System.out.println("Befor connection");
		//Finde the right COM port in devices
		serialConnection = new SerialConnection("COM3");
		//System.out.println("Befor reader connection");
		SerialConnectionReader serialConnectionReader = serialConnection.getSerialConnectionReader();

    }

    @Override
    public void keyTyped(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            //System.out.println("up key typed");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            //System.out.println("down key typed");
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP) {
           // System.out.println("up key pressed");
            serialConnection.write("awa".getBytes());
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
          //  System.out.println("down key pressed");
            serialConnection.write("asa".getBytes());
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
           // System.out.println("up key Released");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
           // System.out.println("down key Released");
        }
    }

    public static void main(String[] args) {
        new KeyListenerTester("Ping Pong Game");
    }
}
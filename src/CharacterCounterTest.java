import java.awt.*;
import java.awt.event.*;

class CharacterCounterFrame extends Frame implements TextListener {
    TextArea textArea = new TextArea(17, 41);
    String text;
    int count = 0;
    int countNoSpace = 0;

    public CharacterCounterFrame() {
        setTitle("文字数カウンタ");
        setLayout(new FlowLayout());
        setSize(400, 400);
        setFont(new Font("Monospaced", Font.PLAIN, 18));
        textArea.addTextListener(this);
        add(textArea);
    }

    public void paint(Graphics g) {
        g.drawString(count + "文字  " + countNoSpace + "文字(空白・改行を除く)", 20, 382);
    }

    public void textValueChanged(TextEvent e) {
        text = textArea.getText();
        count = text.length();
        countNoSpace = text.trim().length();
        repaint();
    }
}

public class CharacterCounterTest {
    public static void main(String[] args) {
        CharacterCounterFrame frame = new CharacterCounterFrame();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }
}

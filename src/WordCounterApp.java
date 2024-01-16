import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterApp extends JFrame {
    private JTextArea textArea;
    private JLabel resultLabel;

    public WordCounterApp() {
        // Set up the JFrame
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        textArea = new JTextArea();
        resultLabel = new JLabel("Word count: 0");

        // Set layout manager
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Add components to the frame
        add(new JScrollPane(textArea));
        add(resultLabel);

        // Add DocumentListener to update word count when the text changes
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateWordCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateWordCount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateWordCount();
            }
        });
    }

    private void updateWordCount() {
        String text = textArea.getText().trim();
        if (text.isEmpty()) {
            resultLabel.setText("Word count: 0");
        } else {
            String[] words = text.split("\\s+");
            int wordCount = words.length;
            resultLabel.setText("Word count: " + wordCount);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCounterApp().setVisible(true);
            }
        });
    }
}
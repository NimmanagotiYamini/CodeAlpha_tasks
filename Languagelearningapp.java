import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LanguageLearningApp extends JFrame {

    private JTextArea displayArea;
    private JProgressBar progressBar;

    private int lessonsCompleted = 0;

    String[][] vocabulary = {
            {"Hello", "Hola", "OH-la"},
            {"Thank You", "Gracias", "GRA-see-as"},
            {"Water", "Agua", "AH-gwa"},
            {"Friend", "Amigo", "AH-mee-go"}
    };

    public LanguageLearningApp() {

        setTitle("Language Learning App");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Arial", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(displayArea);

        JButton vocabularyBtn = new JButton("Vocabulary");
        JButton grammarBtn = new JButton("Grammar");
        JButton flashcardBtn = new JButton("Flashcards");
        JButton quizBtn = new JButton("Quiz");
        JButton progressBtn = new JButton("Progress");

        JPanel panel = new JPanel();

        panel.add(vocabularyBtn);
        panel.add(grammarBtn);
        panel.add(flashcardBtn);
        panel.add(quizBtn);
        panel.add(progressBtn);

        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(progressBar, BorderLayout.SOUTH);

        vocabularyBtn.addActionListener(e -> showVocabulary());

        grammarBtn.addActionListener(e -> showGrammar());

        flashcardBtn.addActionListener(e -> showFlashcards());

        quizBtn.addActionListener(e -> startQuiz());

        progressBtn.addActionListener(e -> showProgress());

        displayArea.setText(
                "Welcome to Language Learning App\n\n" +
                "Choose a category to start learning.");
    }

    private void showVocabulary() {

        StringBuilder sb = new StringBuilder();

        sb.append("VOCABULARY LESSON\n\n");

        for (String[] word : vocabulary) {
            sb.append("English: ").append(word[0])
                    .append("\nTranslation: ").append(word[1])
                    .append("\nPronunciation: ").append(word[2])
                    .append("\n\n");
        }

        displayArea.setText(sb.toString());

        lessonsCompleted++;
    }

    private void showGrammar() {

        displayArea.setText(
                "GRAMMAR LESSON\n\n" +
                "Present Tense:\nUsed for current actions.\n\n" +
                "Past Tense:\nUsed for completed actions.\n\n" +
                "Future Tense:\nUsed for upcoming actions.");

        lessonsCompleted++;
    }

    private void showFlashcards() {

        StringBuilder sb = new StringBuilder();

        sb.append("FLASHCARDS\n\n");

        for (String[] word : vocabulary) {

            sb.append("Word: ")
                    .append(word[0])
                    .append("\nTranslation: ")
                    .append(word[1])
                    .append("\n\n");
        }

        displayArea.setText(sb.toString());

        lessonsCompleted++;
    }

    private void startQuiz() {

        int score = 0;

        String answer1 = JOptionPane.showInputDialog(
                this,
                "Translate 'Hello'");

        if ("Hola".equalsIgnoreCase(answer1))
            score++;

        String answer2 = JOptionPane.showInputDialog(
                this,
                "Translate 'Water'");

        if ("Agua".equalsIgnoreCase(answer2))
            score++;

        JOptionPane.showMessageDialog(
                this,
                "Quiz Completed!\nScore: "
                        + score + "/2");

        progressBar.setValue(score * 50);
    }

    private void showProgress() {

        int progress = Math.min(lessonsCompleted * 20, 100);

        progressBar.setValue(progress);

        displayArea.setText(
                "LEARNING PROGRESS\n\n" +
                "Lessons Completed: " + lessonsCompleted +
                "\nProgress: " + progress + "%");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new LanguageLearningApp().setVisible(true);
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Flashcard {
    String question;
    String answer;

    Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}

public class FlashcardQuizApp extends JFrame {

    private ArrayList<Flashcard> flashcards;
    private int currentIndex = 0;

    private JTextArea displayArea;
    private JButton showAnswerBtn, nextBtn, prevBtn;
    private JButton addBtn, editBtn, deleteBtn;

    public FlashcardQuizApp() {

        flashcards = new ArrayList<>();

        flashcards.add(new Flashcard(
                "What is Java?",
                "Java is an object-oriented programming language."));
        flashcards.add(new Flashcard(
                "What is OOP?",
                "Object-Oriented Programming."));
        flashcards.add(new Flashcard(
                "What is JVM?",
                "Java Virtual Machine."));

        setTitle("Flashcard Quiz App");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Arial", Font.PLAIN, 18));
        displayArea.setLineWrap(true);
        displayArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(displayArea);

        showAnswerBtn = new JButton("Show Answer");
        nextBtn = new JButton("Next");
        prevBtn = new JButton("Previous");
        addBtn = new JButton("Add");
        editBtn = new JButton("Edit");
        deleteBtn = new JButton("Delete");

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(prevBtn);
        buttonPanel.add(showAnswerBtn);
        buttonPanel.add(nextBtn);
        buttonPanel.add(addBtn);
        buttonPanel.add(editBtn);
        buttonPanel.add(deleteBtn);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        showQuestion();

        showAnswerBtn.addActionListener(e -> showAnswer());

        nextBtn.addActionListener(e -> {
            if (currentIndex < flashcards.size() - 1) {
                currentIndex++;
                showQuestion();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Last Flashcard Reached!");
            }
        });

        prevBtn.addActionListener(e -> {
            if (currentIndex > 0) {
                currentIndex--;
                showQuestion();
            } else {
                JOptionPane.showMessageDialog(this,
                        "First Flashcard Reached!");
            }
        });

        addBtn.addActionListener(e -> addFlashcard());

        editBtn.addActionListener(e -> editFlashcard());

        deleteBtn.addActionListener(e -> deleteFlashcard());
    }

    private void showQuestion() {
        displayArea.setText(
                "Question:\n\n" +
                flashcards.get(currentIndex).question);
    }

    private void showAnswer() {
        displayArea.setText(
                "Question:\n\n" +
                flashcards.get(currentIndex).question +
                "\n\nAnswer:\n\n" +
                flashcards.get(currentIndex).answer);
    }

    private void addFlashcard() {
        String question = JOptionPane.showInputDialog(
                this, "Enter Question:");

        if (question == null || question.trim().isEmpty())
            return;

        String answer = JOptionPane.showInputDialog(
                this, "Enter Answer:");

        if (answer == null || answer.trim().isEmpty())
            return;

        flashcards.add(new Flashcard(question, answer));

        JOptionPane.showMessageDialog(this,
                "Flashcard Added Successfully!");
    }

    private void editFlashcard() {

        Flashcard card = flashcards.get(currentIndex);

        String question = JOptionPane.showInputDialog(
                this,
                "Edit Question:",
                card.question);

        if (question == null)
            return;

        String answer = JOptionPane.showInputDialog(
                this,
                "Edit Answer:",
                card.answer);

        if (answer == null)
            return;

        card.question = question;
        card.answer = answer;

        showQuestion();

        JOptionPane.showMessageDialog(this,
                "Flashcard Updated!");
    }

    private void deleteFlashcard() {

        if (flashcards.size() == 1) {
            JOptionPane.showMessageDialog(this,
                    "Cannot delete last flashcard.");
            return;
        }

        flashcards.remove(currentIndex);

        if (currentIndex >= flashcards.size()) {
            currentIndex = flashcards.size() - 1;
        }

        showQuestion();

        JOptionPane.showMessageDialog(this,
                "Flashcard Deleted!");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new FlashcardQuizApp().setVisible(true);
        });
    }
}

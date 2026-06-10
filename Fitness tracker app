import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FitnessTrackerApp extends JFrame {

    private JTextField stepsField;
    private JTextField workoutField;
    private JTextField caloriesField;

    private JTextArea summaryArea;
    private JProgressBar stepsProgress;

    private int totalSteps = 0;
    private int totalCalories = 0;
    private int totalWorkoutMinutes = 0;

    public FitnessTrackerApp() {

        setTitle("Fitness Tracker App");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));

        panel.add(new JLabel("Steps Walked:"));
        stepsField = new JTextField();
        panel.add(stepsField);

        panel.add(new JLabel("Workout Time (mins):"));
        workoutField = new JTextField();
        panel.add(workoutField);

        panel.add(new JLabel("Calories Burned:"));
        caloriesField = new JTextField();
        panel.add(caloriesField);

        JButton addButton = new JButton("Log Activity");
        panel.add(addButton);

        JButton summaryButton = new JButton("Show Summary");
        panel.add(summaryButton);

        panel.add(new JLabel("Daily Step Goal Progress"));

        stepsProgress = new JProgressBar(0, 10000);
        stepsProgress.setStringPainted(true);
        panel.add(stepsProgress);

        summaryArea = new JTextArea();
        summaryArea.setEditable(false);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(summaryArea), BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int steps = Integer.parseInt(stepsField.getText());
                    int workout = Integer.parseInt(workoutField.getText());
                    int calories = Integer.parseInt(caloriesField.getText());

                    totalSteps += steps;
                    totalWorkoutMinutes += workout;
                    totalCalories += calories;

                    stepsProgress.setValue(totalSteps);

                    JOptionPane.showMessageDialog(
                            null,
                            "Fitness Activity Logged Successfully!");

                    stepsField.setText("");
                    workoutField.setText("");
                    caloriesField.setText("");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Please enter valid values.");
                }
            }
        });

        summaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String summary =
                        "===== FITNESS DASHBOARD =====\n\n" +
                        "Total Steps: " + totalSteps + "\n" +
                        "Workout Minutes: " + totalWorkoutMinutes + "\n" +
                        "Calories Burned: " + totalCalories + "\n\n" +
                        "Step Goal Progress: "
                        + (totalSteps * 100 / 10000) + "%";

                summaryArea.setText(summary);
            }
        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FitnessTrackerApp().setVisible(true);
            }
        });
    }
}

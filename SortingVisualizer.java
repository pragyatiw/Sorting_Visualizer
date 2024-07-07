import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SortingVisualizer extends JPanel {

    private int[] array;
    private static final int DELAY = 100;

    public SortingVisualizer(int[] array) {
        this.array = array;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLUE);
        int width = getWidth();
        int height = getHeight();
        int barWidth = width / array.length;

        for (int i = 0; i < array.length; i++) {
            int barHeight = (int) (((double) array[i] / array.length) * height);
            g.setColor(Color.BLACK);
            g.fillRect(i * barWidth, height - barHeight, barWidth, barHeight);
        }
    }

    public void sortAndVisualize() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    repaint();
                    try {
                        Thread.sleep(DELAY);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sorting Visualizer");
        int[] array = new int[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * array.length);
        }
        SortingVisualizer panel = new SortingVisualizer(array);
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panel.sortAndVisualize();
    }
}

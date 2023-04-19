package SmartEnergyGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ClientGUI {

    private List<JTextField> entryFields;
    private List<JTextField> replyFields;

    public static void main(String[] args) {
        /*
         * Creates a new instance of the ClientGUI and builds the UI
         */
        ClientGUI gui = new ClientGUI();
        gui.build();
    }

    private void build() {
        /*
         * Builds the UI and sets up the event listeners
         */
        entryFields = new ArrayList<>();
        replyFields = new ArrayList<>();

        JFrame frame = new JFrame("Smart Energy Controller");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel servicePanel = new JPanel();
        servicePanel.setLayout(new BoxLayout(servicePanel, BoxLayout.Y_AXIS));
        servicePanel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
        servicePanel.add(new ServicePanel("Heater Service", "Invoke", entryFields, replyFields));
        servicePanel.add(new ServicePanel("Temperature Service", "Invoke", entryFields, replyFields));
        servicePanel.add(new ServicePanel("Setting Service", "Invoke", entryFields, replyFields));
        servicePanel.add(new ServicePanel("Usage Service", "Stream", entryFields, replyFields));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonPanel.add(closeButton);
        frame.add(servicePanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}

package org.emp.gl.clients;


import javax.swing.*;
import java.awt.*;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.TimerChangeListener;

public class HorlogeGraphique extends JFrame implements TimerChangeListener {

    private JLabel labelHeure;
    private TimerService service;

    private int heures = 0;
    private int minutes = 0;
    private int secondes = 0;

    public HorlogeGraphique(TimerService service) {
        this.service = service;
        this.service.addTimeChangeListener(this);

        setTitle("Horloge Graphique");
        setSize(250, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        labelHeure = new JLabel("00:00:00", SwingConstants.CENTER);
        labelHeure.setFont(new Font("Arial", Font.BOLD, 30));
        add(labelHeure, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void propertyChange(String prop, Object oldValue, Object newValue) {
        switch (prop) {
            case TimerChangeListener.HEURE_PROP:
                heures = (int) newValue;
                break;
            case TimerChangeListener.MINUTE_PROP:
                minutes = (int) newValue;
                break;
            case TimerChangeListener.SECONDE_PROP:
                secondes = (int) newValue;
                break;
        }

        labelHeure.setText(String.format("%02d:%02d:%02d", heures, minutes, secondes));
    }
}

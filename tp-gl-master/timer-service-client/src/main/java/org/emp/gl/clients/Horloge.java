package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class Horloge implements TimerChangeListener {

    private final String name;
    private final TimerService timerService;

    public Horloge(String name, TimerService timerService) {
        this.name = name;
        this.timerService = timerService;

        // Inscription à l’observable (le timer)
        timerService.addTimeChangeListener(this);

        System.out.println("Horloge " + name + " initialisée !");
    }

    // Réaction aux changements de temps
    @Override
    public void propertyChange(String prop, Object oldValue, Object newValue) {
        if (TimerChangeListener.SECONDE_PROP.equals(prop)) {
            afficherHeure();
        }
    }

    // Affichage de l’heure
    public void afficherHeure() {
        System.out.println(name + " affiche " +
                String.format("%02d:%02d:%02d",
                        timerService.getHeures(),
                        timerService.getMinutes(),
                        timerService.getSecondes()));
    }
}

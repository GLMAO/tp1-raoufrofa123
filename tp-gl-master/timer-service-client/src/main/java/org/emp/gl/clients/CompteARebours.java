package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class CompteARebours implements TimerChangeListener {

    private final String name;
    private int compteur;
    private final TimerService timerService;

    public CompteARebours(String name, int compteurInitial, TimerService timerService) {
        this.name = name;
        this.compteur = compteurInitial;
        this.timerService = timerService;

        // Inscription à l’observable
        timerService.addTimeChangeListener(this);

        System.out.println("Compte à rebours '" + name + "' initialisé à " + compteur + " secondes");
    }

    @Override
    public void propertyChange(String prop, Object oldValue, Object newValue) {
        if (TimerChangeListener.SECONDE_PROP.equals(prop)) {
            if (compteur > 0) {
                compteur--;
                afficher();
                if (compteur == 0) {
                    System.out.println("⏰ " + name + " terminé !");
                    // Désinscription de l’observable
                    timerService.removeTimeChangeListener(this);
                }
            }
        }
    }

    private void afficher() {
        System.out.println(name + " -> " + compteur + " secondes restantes");
    }
}

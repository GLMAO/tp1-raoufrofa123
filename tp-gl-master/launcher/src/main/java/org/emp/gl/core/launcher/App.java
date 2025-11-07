package org.emp.gl.core.launcher;
import org.emp.gl.clients.HorlogeGraphique;
import org.emp.gl.clients.Horloge;
import org.emp.gl.clients.CompteARebours;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;

public class App {

    public static void main(String[] args) {
        testDuTimeService();
        // Maintenir le programme en vie
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void testDuTimeService() {
        TimerService service = new DummyTimeServiceImpl();

        new Horloge("Horloge 1", service);
        new Horloge("Horloge 2", service);

        new CompteARebours("Compte A", 10, service);
        new CompteARebours("Compte B", 5, service);
        new HorlogeGraphique(service);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

package LLD.StructuralPattern;

/*
The Facade Design Pattern is a structural pattern that provides a simplified interface to a complex subsystem of classes, libraries, or frameworks. It hides the complexities of the system and provides an easier way to access functionality.

Why We Need This
Sometimes, systems can become quite complex with many interdependent classes and a complicated API. The Facade pattern provides a way to create a simpler interface that clients can use to interact with the system, making it easier to use and understand.

Where We Need This
The Facade pattern is useful in scenarios where:

You have a complex system with many classes or subsystems and you want to provide a simple interface for clients.
You want to decouple clients from the internal workings of the system, making the system easier to maintain and extend.
You need to interact with a legacy system that has a complicated or confusing API.
What Problem It Solves
The Facade pattern addresses the problem of reducing complexity by providing a simplified interface to a complex subsystem. This makes it easier for clients to use the subsystem and reduces the dependencies between clients and the subsystem's internal classes.
 */

// Subsystem classes
class DVDPlayer {
    public void on() {
        System.out.println("DVD Player on");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void off() {
        System.out.println("DVD Player off");
    }
}

class Projector {
    public void on() {
        System.out.println("Projector on");
    }

    public void off() {
        System.out.println("Projector off");
    }
}

class Amplifier {
    public void on() {
        System.out.println("Amplifier on");
    }

    public void setVolume(int level) {
        System.out.println("Setting volume to " + level);
    }

    public void off() {
        System.out.println("Amplifier off");
    }
}

// Facade
class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private Amplifier amplifier;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Projector projector, Amplifier amplifier) {
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.amplifier = amplifier;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        projector.on();
        amplifier.on();
        amplifier.setVolume(10);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        dvdPlayer.off();
        projector.off();
        amplifier.off();
    }
}

// Client
public class FacadePattern {
    public static void main(String[] args) {
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        Amplifier amplifier = new Amplifier();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, projector, amplifier);

        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }
}


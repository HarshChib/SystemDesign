package LLD.DesignQuestions;

import java.util.*;

class Address{
    String city;
    String state;
    String country;
    int postalCode;

    public Address(String city, String state, String country, int postalCode) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return city + ", " + state + ", " + country + ", " + postalCode;
    }
}

enum SeatType {
    RECLINER,
    NORMAL
}
class Seat {
    int seatId;
    int price;
    SeatType seatType;
    boolean booked;

    public Seat(int seatId, int price, SeatType seatType) {
        this.seatId = seatId;
        this.price = price;
        this.seatType = seatType;
    }

    public int getSeatId() {
        return seatId;
    }

    public int getPrice() {
        return price;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public boolean isBooked() {
        return booked;
    }
}
class City {
    int cityId;
    String cityName;

    public City(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public int getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }
}
class Screen {
    int screenId;
    List<Seat> seats;

    public Screen(int screenId, List<Seat> seats) {
        this.screenId = screenId;
        this.seats = seats;
    }
}
class Show {
    int showId;
    Movie movie;
    Theater theater;
    Screen Screen;
    List<Seat> seats;
    String startTime;

    public Show(int showId, Movie movie, Theater theater, Screen screen, List<Seat> seats, String startTime) {
        this.showId = showId;
        this.movie = movie;
        this.theater = theater;
        Screen = screen;
        this.seats = seats;
        this.startTime = startTime;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public LLD.DesignQuestions.Screen getScreen() {
        return Screen;
    }

    public void setScreen(LLD.DesignQuestions.Screen screen) {
        Screen = screen;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}

class Theater {
    int theaterId;

    String theaterName;

    City city;
    Address address;
    List<Show> shows;

    public Theater(int theaterId, String theaterName, City city, Address address, List<Show> shows) {
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.city = city;
        this.address = address;
        this.shows = shows;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Show> getShows(Movie movie) {
        return this.shows.stream().filter(show -> show.getMovie().getMovieId() == movie.getMovieId()).toList();
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}
class Movie {
    int movieId;
    String movieName;

    public Movie(int movieId, String movieName) {
        this.movieId = movieId;
        this.movieName = movieName;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }
}
class MovieController {
    Map<City, List<Movie>> cityVSMovies;
    List<Movie> allMovies;

    public MovieController(Map<City, List<Movie>> cityVSMovies, List<Movie> allMovies) {
        this.cityVSMovies = cityVSMovies;
        this.allMovies = allMovies;
    }

    public void addMovie(Movie movie, City city) {
        this.allMovies.add(movie);
        if (!cityVSMovies.containsKey(city)) {
            this.cityVSMovies.put(city, new ArrayList<>());
        }
        this.cityVSMovies.get(city).add(movie);
    }


    public Movie getMovie(String movieName) {
        return this.allMovies.stream().filter(movie -> movie.getMovieName().contains(movieName)).findFirst().orElse(null);
    }

    public List<Movie> getMovies(City city) {
        return this.cityVSMovies.get(city);
    }
}

class TheaterController {
    Map<City, List<Theater>> cityVSTheater;

    public TheaterController(Map<City, List<Theater>> cityVSTheater) {
        this.cityVSTheater = cityVSTheater;
    }

    public Map<Theater, List<Show>> getMovieShows (Movie movie, City city) {
        List<Theater> theaters = cityVSTheater.get(city);
        Map<Theater, List<Show>> movieShows =  new HashMap<>();
        for (Theater theater : theaters) {
            List<Show> shows = theater.getShows(movie);
            if(!shows.isEmpty()) {
                movieShows.put(theater, shows);
            }
        }
        return movieShows;
    }

    public int bookSeats(List<Seat> seats) {
        int totalPrice = 0;
        for (Seat seat : seats) {
            totalPrice+=seat.getPrice();
        }
        return totalPrice;
    }
}

public class BookMyShow {
    public static void main(String[] args) {
        City city = new City(1, "San Francisco");

        Address address1 = new Address("123 Market St", "San Francisco", "USA", 94103);
        Address address2 = new Address("456 Castro St", "San Francisco", "USA", 94114);

        Movie movie1 = new Movie(1, "Avengers");
        Movie movie2 = new Movie(2, "Inception");

        Seat seat1 = new Seat(1, 10, SeatType.NORMAL);
        Seat seat2 = new Seat(2, 15, SeatType.RECLINER);
        Seat seat3 = new Seat(3, 10, SeatType.NORMAL);

        Screen screen1 = new Screen(1, Arrays.asList(seat1, seat2, seat3));
        Screen screen2 = new Screen(2, Arrays.asList(seat1, seat2));

        Show show1 = new Show(1, movie1, null, screen1, List.of(seat1,seat2, seat3), "10:00 AM");
        Show show2 = new Show(2, movie2, null, screen2, new ArrayList<>(), "12:00 PM");

        Theater theater1 = new Theater(1, "AMC Metreon 16", city, address1, Arrays.asList(show1));
        Theater theater2 = new Theater(2, "Castro Theatre", city, address2, Arrays.asList(show2));

        show1.theater = theater1;
        show2.theater = theater2;

        Map<City, List<Movie>> cityVSMovies = new HashMap<>();
        Map<City, List<Theater>> cityVSTheater = new HashMap<>();

        MovieController movieController = new MovieController(cityVSMovies, new ArrayList<>());
        TheaterController theaterController = new TheaterController(cityVSTheater);

        movieController.addMovie(movie1, city);
        movieController.addMovie(movie2, city);

        cityVSTheater.put(city, Arrays.asList(theater1, theater2));

        // Simulate user interaction
        Scanner sc = new Scanner(System.in);

        List<Movie> movies = movieController.getMovies(city);
        System.out.println("Below is the list of movies in city: " + city.getCityName());
        for (Movie movie : movies) {
            System.out.println(movie.getMovieName());
        }

        System.out.println("Enter Movie Name:");
        String movieName = sc.nextLine();
        Movie movie = movieController.getMovie(movieName);

        Map<Theater, List<Show>> theaterShows = theaterController.getMovieShows(movie, city);
        System.out.println("Below is the list of theaters:");
        for (Theater theater : theaterShows.keySet()) {
            System.out.println(theater.getTheaterName());
            System.out.println(theater.getAddress());
        }

        System.out.println("Enter Theater Name:");
        String theaterName = sc.nextLine();
        Theater selectedTheater = theaterShows.keySet().stream().filter(theater -> theater.getTheaterName().contains(theaterName)).findFirst().orElse(null);

        System.out.println("Here's a list of active shows for " + movieName + ":");
        List<Show> shows = theaterShows.get(selectedTheater);
        for (Show show : shows) {
            System.out.println("Screen ID: " + show.getScreen().screenId);
            System.out.println("Movie: " + show.getMovie().getMovieName());
            System.out.println("Start Time: " + show.getStartTime());
            System.out.println();
        }

        //Assuming User selected first show
        System.out.println("Available seats");
        for(Seat seat: shows.get(0).getSeats()) {
            if(!seat.isBooked()) {
                System.out.println(seat.getSeatId());
            }
        }
        int totalPrice = theaterController.bookSeats(shows.get(0).getSeats());
        System.out.println("Payable amount : " + totalPrice);
    }
}

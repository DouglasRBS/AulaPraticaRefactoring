public class Rental {

    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    // método getCharge() agora delega o cálculo para Movie
    public double getCharge() {
        return _movie.getCharge(_daysRented);
    }

    // método extraído do Customer e movido para cá
    public int getFrequentRenterPoints() {
        // add frequent renter points
        if ((this.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
            this.getDaysRented() > 1)
            return 2;  // bônus

        return 1;      // padrão
    }
}

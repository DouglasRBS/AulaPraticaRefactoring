public class Movie {

    // constantes ainda usadas pelas subclasses de Price
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;

    // *** passo 3: substituir o priceCode por um Price ***
    private Price _price;

    public Movie(String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public String getTitle() {
        return _title;
    }

    // método extraído da classe Rental
    public double getCharge(int daysRented) {

        double thisAmount = 0;

        switch (getPriceCode()) {
            case REGULAR:
                thisAmount += 2;
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 1.5;
                break;

            case NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;

            case CHILDRENS:
                thisAmount += 1.5;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 1.5;
                break;
        }

        return thisAmount;
    }

    // método extraído e movido para cá no Passo 2
    public int getFrequentRenterPoints(int daysRented) {

        // regra: NEW_RELEASE com mais de 1 dia rende 2 pontos
        if ((this.getPriceCode() == Movie.NEW_RELEASE) &&
            daysRented > 1)
            return 2;

        return 1;
    }
}

public class Movie {

    // constantes ainda usadas pelas subclasses de Price
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;

    // passo 3: substituir o priceCode por um Price
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

    // método agora apenas delega para Price
    public double getCharge(int daysRented) {
    System.out.println("Price.getCharge chamado");
    return 0;
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

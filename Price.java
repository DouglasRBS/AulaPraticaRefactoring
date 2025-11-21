public abstract class Price {

    public abstract int getPriceCode();

    public abstract double getCharge(int daysRented);

    // Agora este é o método definitivo, que Movie apenas repassa
    public int getFrequentRenterPoints(int daysRented) {
        // Regra padrão: sempre 1 ponto
        return 1;
    }
}

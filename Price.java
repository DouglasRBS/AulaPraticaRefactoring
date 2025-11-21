public abstract class Price {

    public abstract int getPriceCode();

    public abstract double getCharge(int daysRented);

    // Regra padrão para pontos de fidelidade
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    // Agora o Customer apenas delega para TextStatement
    public String statement() {
        return new TextStatement().value(this);
    }

    // Agora o Customer apenas delega para HtmlStatement
    public String htmlStatement() {
        return new HtmlStatement().value(this);
    }

    // Fica público para as subclasses de Statement acessarem
    public Enumeration getRentals() {
        return _rentals.elements();
    }

    // Fica público para Statement usar
    public double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    // Fica público também
    public int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}

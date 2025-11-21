import java.util.Enumeration;

public abstract class Statement {

    public String value(Customer aCustomer) {
        String result = headerString(aCustomer);

        Enumeration rentals = aCustomer.getRentals();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += eachRentalString(each);
        }

        result += footerString(aCustomer);

        return result;
    }

    // MÉTODOS QUE AS SUBCLASSES DEVEM IMPLEMENTAR:

    protected abstract String headerString(Customer aCustomer);

    protected abstract String eachRentalString(Rental each);

    protected abstract String footerString(Customer aCustomer);
}

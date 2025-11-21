public class HtmlStatement extends Statement {

    @Override
    protected String headerString(Customer aCustomer) {
        return "<H1>Rentals for <EM>" + aCustomer.getName() +
                "</EM></H1><P>\n";
    }

    @Override
    protected String eachRentalString(Rental each) {
        return each.getMovie().getTitle() + ": " +
                String.valueOf(each.getCharge()) + "<BR>\n";
    }

    @Override
    protected String footerString(Customer aCustomer) {
        return "<P>You owe <EM>" +
                String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n" +
                "On this rental you earned <EM>" +
                String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";
    }
}

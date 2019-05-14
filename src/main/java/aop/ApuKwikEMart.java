package aop;



public class ApuKwikEMart implements KwikEMart {

    private boolean squisheeMachineEmpty;

    public Squishee buySquishee(Customer customer)
            throws KwikEMartException {
        if (customer.isBroke()) {
            throw new CustomerIsBrokeException();
        }
        if (squisheeMachineEmpty) {
            throw new NoMoreSquisheesException();
        }
        return new Squishee();
    }

    public static void main(String[] args) throws KwikEMartException {
        Squishee squishee = new ApuKwikEMart().buySquishee(new Customer());
    }
}

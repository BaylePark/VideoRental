import java.util.Hashtable;
import java.util.List;

public class RentalService {
    private Hashtable<Customer, List<Rental>> rentals = new Hashtable<Customer, List<Rental>>();

    public RentalService() {

    }

    public List<Rental> getRentals(Customer customer) {
        return rentals.get(customer);
    }

    public void setRentals(Customer customer, List<Rental> rentalList) {
        rentals.put(customer, rentalList);
    }

    public void addRental(Customer customer, Rental rental) {
        rentals.get(customer).add(rental);
    }

    public void clearRentals(Customer customer) {
        rentals.remove(customer);
    }
}
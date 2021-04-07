import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class RentalService {
    private Hashtable<Customer, List<Rental>> rentals = new Hashtable<Customer, List<Rental>>();

    public RentalService() {

    }

    public List<Rental> getRentals(Customer customer) {
    	List<Rental> ret = rentals.get(customer);
    	if (ret == null) {
    		return new ArrayList<Rental>();
    	}
    	return ret;
    }

    public void setRentals(Customer customer, List<Rental> rentalList) {
        rentals.put(customer, rentalList);
    }

    public void addRental(Customer customer, Rental rental) {
        if (rentals.contains(customer) == false) {
        	setRentals(customer, new ArrayList<Rental>());
        }
        rentals.get(customer).add(rental);
    }

    public void clearRentals(Customer customer) {
    	List<Rental> ret = rentals.get(customer);
    	ret.clear();
    }
}
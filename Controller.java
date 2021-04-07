import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Controller {
    private List<Customer> customers = new ArrayList<Customer>();
    private List<Video> videos = new ArrayList<Video>();

    private RentalService rentalService = new RentalService();
    private ReportService report = new ReportService();

    public Controller() {

    }

    public Customer findCustomer(String customerName) {
        Customer foundCustomer = null;

        for (Customer customer : customers) {
            if (customer.getName().equals(customerName)) {
                foundCustomer = customer;
                break;
            }
        }

        return foundCustomer;
    }

    public void clearRentals(String customerName) {
        Customer foundCustomer = findCustomer(customerName);

        if (foundCustomer == null) {
            System.out.println("No customer found");
        } else {
            List<Rental> rentals = rentalService.getRentals(foundCustomer);
            System.out.println("Name: " + foundCustomer.getName() + "\tRentals: " + rentals.size());
            for (Rental rental : rentals) {
                System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ");
                System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode());
            }

            rentalService.clearRentals(foundCustomer);
        }
    }

    public void returnVideo(String customerName, String videoTitle) {
        Customer foundCustomer = findCustomer(customerName);

        if (foundCustomer == null)
            return;

        System.out.println("Enter video title to return: ");

        List<Rental> customerRentals = rentalService.getRentals(foundCustomer);
        for (Rental rental : customerRentals) {
            if (rental.getVideo().getTitle().equals(videoTitle) && rental.getVideo().isRented()) {
                rental.returnVideo();
                rental.getVideo().setRented(false);
                break;
            }
        }
    }

    public void init() {
        Customer james = new Customer("James");
        Customer brown = new Customer("Brown");
        customers.add(james);
        customers.add(brown);

        Video v1 = new CDVideo("v1", new RegularPriceCode(new NoPointPolicy()), new Date());
        Video v2 = new DVDVideo("v2", new NewReleasePriceCode(new OnePointPolicy()), new Date());
        videos.add(v1);
        videos.add(v2);

        Rental r1 = new Rental(v1);
        Rental r2 = new Rental(v2);

        rentalService.addRental(james, r1);
        rentalService.addRental(james, r2);
    }

    public void listVideos() {
        for (Video video : videos) {
            System.out.println("Price code: " + video.getPriceCode() + "\tTitle: " + video.getTitle());
        }
    }

    public void listCustomers() {
        for (Customer customer : customers) {
            List<Rental> rentals = rentalService.getRentals(customer);
            System.out.println("Name: " + customer.getName() + "\tRentals: " + rentals.size());
            for (Rental rental : rentals) {
                System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ");
                System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode());
            }
        }
    }

    public void getCustomerReport(String customerName) {
        Customer foundCustomer = findCustomer(customerName);

        if (foundCustomer == null) {
            System.out.println("No customer found");
        } else {
            String result = report.getReport(foundCustomer, rentalService.getRentals(foundCustomer));
            System.out.println(result);
        }
    }

    public void rentVideo(String customerName, String videoTitle) {
        System.out.println("Enter customer name: ");

        Customer foundCustomer = findCustomer(customerName);

        if (foundCustomer == null)
            return;

        System.out.println("Enter video title to rent: ");

        Video foundVideo = null;
        for (Video video : videos) {
            if (video.getTitle().equals(videoTitle) && video.isRented() == false) {
                foundVideo = video;
                break;
            }
        }

        if (foundVideo == null)
            return;

        Rental rental = new Rental(foundVideo);
        foundVideo.setRented(true);

        List<Rental> customerRentals = rentalService.getRentals(foundCustomer);
        customerRentals.add(rental);
        rentalService.setRentals(foundCustomer, customerRentals);
    }

    public void registerVideo(String title, int videoType, int priceCode) {
        final int VHS = 1;
        final int CD = 2;
        final int DVD = 3;

        final int REGULAR = 1;
        final int NEW_RELEASE = 2;
        Date registeredDate = new Date();
        Video video = null;
        PriceCode code = null;
        PointPolicy pp = null;

        switch (priceCode) {
        case REGULAR:
            code = new RegularPriceCode(new NoPointPolicy());
            break;
        case NEW_RELEASE:
            code = new NewReleasePriceCode(new OnePointPolicy());
            break;
        }

        switch (videoType) {
        case VHS:
            video = new VHSVideo(title, code, registeredDate);
            break;
        case CD:
            video = new CDVideo(title, code, registeredDate);
            break;
        case DVD:
            video = new DVDVideo(title, code, registeredDate);
            break;
        }

        videos.add(video);
    }

    public void registerCustomer(String customerName) {
        Customer customer = new Customer(customerName);
        customers.add(customer);
    }
}

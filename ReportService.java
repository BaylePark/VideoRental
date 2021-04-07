import java.util.Date;
import java.util.List;

public class ReportService {
    CouponPolicy couponPolicy;

    public ReportService(CouponPolicy couponPolicy) {
        this.couponPolicy = couponPolicy;
    }

    public String getReport(Customer customer, List<Rental> rentals) {
        String result = "Customer Report for " + customer.getName() + "\n";

        double totalCharge = 0;
        int totalPoint = 0;

        for (Rental each : rentals) {
            double eachCharge = 0;
            int eachPoint = 0;
            int daysRented = 0;

            if (each.getStatus() == 1) { // returned Video
                long diff = each.getReturnDate().getTime() - each.getRentDate().getTime();
                daysRented = (int) (diff / (1000 * 60 * 60 * 24)) + 1;
            } else { // not yet returned
                long diff = new Date().getTime() - each.getRentDate().getTime();
                daysRented = (int) (diff / (1000 * 60 * 60 * 24)) + 1;
            }

            eachCharge = each.getVideo().getPriceCode().getCharge(daysRented);

            eachPoint++;
            eachPoint += each.getVideo().getPriceCode().getPoint();

            if (daysRented > each.getDaysRentedLimit())
                eachPoint -= Math.min(eachPoint, each.getVideo().getLateReturnPointPenalty());

            result += "\t" + each.getVideo().getTitle() + "\tDays rented: " + daysRented + "\tCharge: " + eachCharge
                    + "\tPoint: " + eachPoint + "\n";

            totalCharge += eachCharge;

            totalPoint += eachPoint;
        }

        result += "Total charge: " + totalCharge + "\tTotal Point:" + totalPoint + "\n";

        couponPolicy.print(totalPoint);

        return result;
    }
}

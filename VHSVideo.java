import java.util.Date;

public class VHSVideo extends Video {
    public VHSVideo(String title, PriceCode priceCode, Date registeredDate) {
        super(title, priceCode, registeredDate);
    }

    public int getLateReturnPointPenalty() {
        return 1;
    }

    public int getlimit() {
        return 5;
    }
}

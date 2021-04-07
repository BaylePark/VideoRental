import java.util.Date;

public class DVDVideo extends Video {
    public DVDVideo(String title, PriceCode priceCode, Date registeredDate) {
        super(title, priceCode, registeredDate);
    }

    public int getLateReturnPointPenalty() {
        return 3;
    }

    public int getlimit() {
        return 2;
    }
}

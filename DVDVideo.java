import java.util.Date;

public class DVDVideo extends Video {
    public DVDVideo(String title, int priceCode, Date registeredDate) {
        super(title, priceCode, registeredDate);
    }

    public int getLateReturnPointPenalty() {
        return 3;
    }
}

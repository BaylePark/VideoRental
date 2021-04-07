import java.util.Date;

public class CDVideo extends Video {
    public CDVideo(String title, int priceCode, Date registeredDate) {
        super(title, priceCode, registeredDate);
    }

    public int getLateReturnPointPenalty() {
        return 2;
    }

    public int getlimit() {
        return 3;
    }
}

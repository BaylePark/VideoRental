import java.util.Date;

public class VHSVideo extends Video {
    public VHSVideo(String title, int priceCode, Date registeredDate) {
        super(title, priceCode, registeredDate);
    }

    public int getLateReturnPointPenalty() {
        return 1;
    }
}

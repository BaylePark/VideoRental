import java.util.Date;

public abstract class Video {
	private String title;
	private PriceCode priceCode;

	private Date registeredDate;
	private boolean rented;

	public Video(String title, PriceCode priceCode, Date registeredDate) {
		this.setTitle(title);

		this.setPriceCode(priceCode);
		this.registeredDate = registeredDate;
	}

	public abstract int getLateReturnPointPenalty();

	public abstract int getlimit();

	public PriceCode getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(PriceCode priceCode) {
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
}

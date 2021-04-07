public class NewReleasePriceCode implements PriceCode {
    PointPolicy pointPolicy;

    public NewReleasePriceCode(PointPolicy pointPolicy) {
        this.pointPolicy = pointPolicy;
    }

    public int getCharge(int daysRented) {
        return daysRented * 3;
    }

    public int getPoint() {
        return pointPolicy.getPoint();
    }

    @Override
    public String toString() {
        return "2";
    }
}

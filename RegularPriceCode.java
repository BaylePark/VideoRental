public class RegularPriceCode implements PriceCode {
    PointPolicy pointPolicy;

    public RegularPriceCode(PointPolicy pointPolicy) {
        this.pointPolicy = pointPolicy;
    }

    public int getCharge(int daysRented) {
        int eachCharge = 2;
        if (daysRented > 2)
            eachCharge += (daysRented - 2) * 1.5;
        return eachCharge;
    }

    public int getPoint() {
        return pointPolicy.getPoint();
    }

    @Override
    public String toString() {
        return "1";
    }
}

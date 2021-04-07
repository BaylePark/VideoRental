public class DefaultCouponPolicy implements CouponPolicy {

    @Override
    public void print(int totalPoint) {
        if (totalPoint >= 10) {
            System.out.println("Congrat! You earned one free coupon");
        }
        if (totalPoint >= 30) {
            System.out.println("Congrat! You earned two free coupon");
        }
    }

}

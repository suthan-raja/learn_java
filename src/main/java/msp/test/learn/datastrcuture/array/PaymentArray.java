package msp.test.learn.datastrcuture.array;

public class PaymentArray {

    int categoryId;
    int categoryName;
    String categoryImgType;

    @Override
    public String toString() {
        return "PaymentArray{" +
                "categoryId=" + categoryId +
                ", categoryName=" + categoryName +
                ", categoryImgType='" + categoryImgType + '\'' +
                '}';
    }

    public PaymentArray(int categoryId, int categoryName, String categoryImgType) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryImgType = categoryImgType;
    }
}

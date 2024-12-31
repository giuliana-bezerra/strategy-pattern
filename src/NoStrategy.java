public class NoStrategy {
    public static void main(String[] args) {
        int paymentMethod = 3; // 1 - Credit Card, 2 - Boleto, 3 - Pix
        double amount = 3.0;

        if (paymentMethod == 1) {
            System.out.println("Validing credit card...");
            System.out.println("Paid R$ " + amount + " with credit card.");
        } else if (paymentMethod == 2) {
            System.out.println("Generating barcode...");
            System.out.println("Paid R$ " + amount + " with boleto.");
        } else if (paymentMethod == 3) {
            System.out.println("Generating QR Code...");
            System.out.println("Paid R$ " + amount + " with Pix.");
        } else {
            throw new IllegalStateException("Payment method not supported.");
        }
    }
}

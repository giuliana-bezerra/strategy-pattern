import java.util.function.Consumer;

public class ModernStrategy {
  public static void main(String[] args) {
    String paymentMethod = "PIX"; // "CREDIT_CARD", "BOLETO", "PIX"
    PaymentType.valueOf(paymentMethod).pay(3.0);
  }
}

class PaymentMethods {
  public static void creditCard(Double amount) {
    System.out.println("Validing credit card...");
    System.out.println("Paid R$ " + amount + " with credit card.");
  }

  public static void boleto(Double amount) {
    System.out.println("Generating barcode...");
    System.out.println("Paid R$ " + amount + " with boleto.");
  }

  public static void pix(Double amount) {
    System.out.println("Generating QR Code...");
    System.out.println("Paid R$ " + amount + " with Pix.");
  }
}

enum PaymentType {
  CREDIT_CARD(PaymentMethods::creditCard), BOLETO(PaymentMethods::boleto),
  PIX(PaymentMethods::pix);

  private Consumer<Double> paymentStrategy;

  PaymentType(Consumer<Double> paymentStrategy) {
    this.paymentStrategy = paymentStrategy;
  }

  public void pay(Double amount) {
    paymentStrategy.accept(amount);
  }
}

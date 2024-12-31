public class CommonStrategy {
  public static void main(String[] args) {
    var paymentMethodCode = 1; // 1 - Credit Card, 2 - Boleto, 3 - Pix
    var amount = 3.0;

    var paymentMethod = switch (paymentMethodCode) {
      case 1 -> new CreditCard();
      case 2 -> new Boleto();
      case 3 -> new Pix();
      default -> throw new IllegalStateException("Payment method not supported.");
    };

    var processor = new PaymentProcessor(paymentMethod);
    processor.pay(amount);
  }
}

class PaymentProcessor {
  private PaymentMethod paymentMethod;

  public PaymentProcessor(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public void pay(double amount) {
    if (paymentMethod == null)
      throw new IllegalStateException("Payment method not supported.");
    paymentMethod.pay(amount);
  }
}

interface PaymentMethod {
  void pay(double amount);
}

class CreditCard implements PaymentMethod {
  @Override
  public void pay(double amount) {
    System.out.println("Validing credit card...");
    System.out.println("Paid R$ " + amount + " with credit card.");
  }
}

class Boleto implements PaymentMethod {
  @Override
  public void pay(double amount) {
    System.out.println("Generating barcode...");
    System.out.println("Paid R$ " + amount + " with boleto.");
  }
}

class Pix implements PaymentMethod {
  @Override
  public void pay(double amount) {
    System.out.println("Generating QR Code...");
    System.out.println("Paid R$ " + amount + " with Pix.");
  }
}

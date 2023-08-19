package payment_details;

public class testPayment {
    public static void main(String[] args) {
        Payment payment = new Payment("NG", "NGN", 122, "08141745803", "firstName", "lastName", "hassanyahya@gmail.com",
                "Bank",
                "FLWPUBK-6cbb62c7b01a981fb38406604ab3727e-X");

        String txRef = payment.getTxRef();
        System.out.println(
                "https://checkout-v3-ui-qa.myflutterwave.com/?"+
                        "PBFPubKey="+payment.getPublicKey()+
                        "&txref="+payment.getTxRef()+
                        "&currency="+payment.getCurrency()+
                        "&country="+payment.getCountry()+
                        "&customer_email="+payment.getEmail()+
                        "&amount="+payment.getAmount()+
                        "&customer_phone="+payment.getPhone()+
                        "&payment_options=card,account,ussd,banktransfer,qr,barter,alipay,mpesa,mobilemoney,payattitude,1voucher,mobilemoney,card,ussd,mpesa,cryptocurrency,wechat,paga,internetbanking,nqr" +
                        "&customer_fullname="+payment.getFullName()
        );
    }
}

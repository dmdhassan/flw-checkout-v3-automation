package payment_details;

import java.util.Random;

public class Payment {
    private String country;
    private String currency;
    private double amount;
    private String phone;
    private String firstName;
    private String lastName;
    private String email;
    private String paymentMethod;
    private String txRef;
    private String publicKey;

    public Payment(
            String country,
            String currency,
            double amount,
            String phone,
            String firstName,
            String lastName,
            String email,
            String paymentMethod,
            String publicKey) {
        this.country = country;
        this.currency = currency;
        this.amount = amount;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.paymentMethod = paymentMethod;
        this.publicKey = publicKey;
        setTxRef(12);
    }



    public String getTxRef() {
        return txRef;
    }

    public void setTxRef(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        this.txRef = sb.toString();
    }

    public String getCountry() {
        return country;
    }

    public String getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getPhone() {
        return phone;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public String getLink() {
        return "https://checkout-v3-ui-qa.myflutterwave.com/?"+
                "PBFPubKey="+getPublicKey()+
                "&txref="+getTxRef()+
                "&currency="+getCurrency()+
                "&country="+getCountry()+
                "&customer_email="+getEmail()+
                "&amount="+getAmount()+
                "&customer_phone="+getPhone()+
                "&payment_options=card,account,ussd,banktransfer,qr,barter,alipay,mpesa,mobilemoney,1voucher,mobilemoney,card,ussd,mpesa,cryptocurrency,wechat,paga,internetbanking,nqr" +
                "&customer_fullname="+ getFullName();
    }

}

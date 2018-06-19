package global;

public class Client implements SecureSerializable{
    private static int cryptkey  = 32;
    private String name;
    private int age;
    private String creditCard;
    private transient String checkDigit;


    public Client(String name, int age, String creditCard, String checkDigit) {
        this.name = name;
        this.age = age;
        this.creditCard = creditCard;
        this.checkDigit = checkDigit;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", creditCard='" + creditCard + '\'' +
                ", verificatingDigit='" + checkDigit + '\'' +
                '}';
    }

    @Override
    public SecureSerializable encrypt() {

        //"Criptografa" o cartão de credito
        long creditCardAux = Long.parseLong(this.creditCard.replace(".",""));
        creditCardAux = creditCardAux << cryptkey;
        String encryptedCreditCard = Long.toString(creditCardAux);

        //cria uma cópia do objeto atual, com o cartão criptografado
        Client encryptedClone = new Client(this.name, this.age, encryptedCreditCard, this.checkDigit);

        return encryptedClone;
    }

    @Override
    public void decrypt() {
        long creditCardAux = Long.parseLong(this.creditCard);
        creditCardAux = creditCardAux >> cryptkey;
        String decryptedCreditCard = Long.toString(creditCardAux);

        this.creditCard = decryptedCreditCard;
    }
}

package global;

public class MainSerialize {
    public static void main(String... args){
        Client client = new Client("Charles", 37, "123.225.45", "984");

        String fileName = "safeClient.ser";
        Serializator.serialize(client, fileName);

        System.out.println("Client serialized:");
        System.out.println(client.toString());
    }
}

package global;

public class MainDeserialize {
    public static void main(String... args){
        String fileName = "safeClient.ser";
        Client client = (Client)Serializator.deserialize(fileName);

        System.out.println("Client deserialized:");
        System.out.println(client.toString());
    }
}

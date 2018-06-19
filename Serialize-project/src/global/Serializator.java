package global;

import java.io.*;

public class Serializator {

    public static void serialize(SecureSerializable obj, String fileName){
        try{

            //cria o arquivo, se ele ainda não existir
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream writer = new ObjectOutputStream(file);

            //criptografa o objeto
            obj = obj.encrypt();

            //escreve o estado do objeto no arquivo
            writer.writeObject(obj);

            //libera o arquivo para leitura/escrita
            //por outros problemas
            writer.flush();
            writer.close();
            file.flush();
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Object deserialize(String fileName){
        try{

            //cria o arquivo, se ele ainda não existir
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream reader = new ObjectInputStream(file);

            //escreve o estado do objeto no arquivo
            Object objSerialized = reader.readObject();

            //libera o arquivo para leitura/escrita
            reader.close();
            file.close();

            //descriptografa o objeto deserializado e o retorna
            SecureSerializable obj = (SecureSerializable)objSerialized;
            obj.decrypt();
            return obj;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

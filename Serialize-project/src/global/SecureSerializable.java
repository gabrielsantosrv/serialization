package global;

import java.io.Serializable;

public interface SecureSerializable extends Serializable {
    SecureSerializable encrypt();
    void decrypt();
}

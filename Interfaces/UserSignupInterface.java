package Interfaces;

import java.lang.*;
import SourceCode.*;

public interface UserSignupInterface {
    void saveSignupData(String username, char[] password, String mobileNumber, String email, String formattedDateTime);
}

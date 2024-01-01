package Interfaces;

import java.lang.*;
import SourceCode.*;

public interface AddUserInterface {
    void saveSignUpData(String username, char[] password, String mobileNumber, String email, String formattedDateTime);
}

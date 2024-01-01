package Interfaces;

import java.lang.*;
import SourceCode.*;


public interface AdminLoginInterface {
    boolean checkLoginData(String username, char[] password);
	void actionPerformed(java.awt.event.ActionEvent ae);
}
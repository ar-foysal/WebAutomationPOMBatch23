package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {

    @DataProvider(name = "invalidCredentials")
    public static Object invalidLoginDate(){
        Object[][] data = {{"xagopot780@deligy.com","123456", "Your email or password is incorrect!" },
                            {"xagopot780@","123456aa", "" },
                            {"xagopot780@deligy.com","", "" },
                            {"","123456aa", "" },
                            {"","", "" },
                            {"xagopot780@deligy.co","123456", "Your email or password is incorrect!" }
        };
        return data;
    }
}

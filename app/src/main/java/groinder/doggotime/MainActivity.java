package groinder.doggotime;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String accountType = "groinder.doggotime.account.DOGGO_ACCOUNT";
        AccountManager accountManager = AccountManager.get(this);
        Account[] accounts = accountManager.getAccountsByType(accountType);
        String password = accountManager.getPassword(accounts[0]);
//        Account account = new Account("krzysiek7775@gmail.com",accountType);
//        boolean success = accountManager.addAccountExplicitly(account,"P@ssw0rd",null);
    }
}

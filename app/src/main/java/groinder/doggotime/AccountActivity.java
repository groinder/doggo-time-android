package groinder.doggotime;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static groinder.doggotime.LoginActivity.CREDENTIALS_RESULT;

public class AccountActivity extends AppCompatActivity {
    static final int CREDENTIALS_REQUEST = 1;

    private String accountType = "groinder.doggotime.account.DOGGO_ACCOUNT";
    private Bundle credentials = null;
    private OnAuthenticatedListener listener;
    AccountManager accountManager = AccountManager.get(this);

    void getAccount(OnAuthenticatedListener listener) {
        this.listener = listener;

        if (credentials == null) {
            Account[] accounts = accountManager.getAccountsByType(accountType);

            if (accounts.length > 0) {
                Account account = accounts[0];

                credentials.putString("email", account.name);
                credentials.putString("password", accountManager.getPassword(account));

                listener.onAuthenticated(credentials);
            } else {
                Intent intent = new Intent(this, LoginActivity.class);
                startActivityForResult(intent, CREDENTIALS_REQUEST);
            }

        } else {
            listener.onAuthenticated(credentials);
        }
    }

    @Override
    public void onActivityResult(int i, int i1, Intent intent) {
        if (i == CREDENTIALS_RESULT) {
            credentials = intent.getBundleExtra("credentials");
            Account account = new Account(credentials.getString("email"), accountType);
            accountManager.addAccountExplicitly(account, credentials.getString("password"), null);
            listener.onAuthenticated(credentials);
        }
    }
}

package com.project.dispatchandroid.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.project.dispatchandroid.R;
import com.project.dispatchandroid.utils.AppHelper;

public class HomeActivity extends AppCompatActivity {

    // Cognito user object
    private CognitoUser user;

    // User details
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        username = AppHelper.getCurrUser();
        user = AppHelper.getPool().getUser(username);
    }

    public void signOut(View v) {
        user.signOut();
        Log.d("HomeActivity", "User is signing out");
        finish();
    }
}

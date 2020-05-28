package c.khan.androidbuddy;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AndroidBuddy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_buddy);

        BodyPartFragment headFrag = new BodyPartFragment();

        FragmentManager fragManager = getSupportFragmentManager();

        fragManager.beginTransaction()
                .add(R.id.head_container, headFrag)
                .commit();

    }
}

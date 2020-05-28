package c.khan.androidbuddy;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AndroidBuddy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_buddy);

        if (savedInstanceState == null) {

            FragmentManager fragManager = getSupportFragmentManager();

            BodyPartFragment headFrag = new BodyPartFragment();

            headFrag.setmImageIds(ImageAssets.getHeads());
            headFrag.setListIndex(1);

            fragManager.beginTransaction()
                    .add(R.id.head_container, headFrag)
                    .commit();


            BodyPartFragment bodyfrag = new BodyPartFragment();

            bodyfrag.setmImageIds(ImageAssets.getBodies());
            bodyfrag.setListIndex(1);

            fragManager.beginTransaction()
                    .add(R.id.body_container, bodyfrag)
                    .commit();


            BodyPartFragment legfrag = new BodyPartFragment();

            legfrag.setmImageIds(ImageAssets.getLegs());
            legfrag.setListIndex(1);

            fragManager.beginTransaction()
                    .add(R.id.leg_container, legfrag)
                    .commit();

        }
    }
}

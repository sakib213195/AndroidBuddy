package c.khan.androidbuddy;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    public int head_index, body_index, leg_index;

    private boolean TabPane;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.AndroidBuddyLinearLayout) != null){
            TabPane = true;

            Button NXTBtn = (Button) findViewById(R.id.next_button);
            NXTBtn.setVisibility(View.GONE);

            GridView TabGrid = (GridView) findViewById (R.id.images_grid_view);
            TabGrid.setNumColumns(2);

            if (savedInstanceState == null) {

                FragmentManager fragManager = getSupportFragmentManager();

                BodyPartFragment headFrag = new BodyPartFragment();

                headFrag.setmImageIds(ImageAssets.getHeads());
                int headIndex = getIntent().getIntExtra("headIndex", 0);
                headFrag.setListIndex(headIndex);

                fragManager.beginTransaction()
                        .add(R.id.head_container, headFrag)
                        .commit();


                BodyPartFragment bodyfrag = new BodyPartFragment();

                bodyfrag.setmImageIds(ImageAssets.getBodies());
                int bodyIndex = getIntent().getIntExtra("headIndex", 0);
                bodyfrag.setListIndex(bodyIndex);

                fragManager.beginTransaction()
                        .add(R.id.body_container, bodyfrag)
                        .commit();


                BodyPartFragment legfrag = new BodyPartFragment();

                legfrag.setmImageIds(ImageAssets.getLegs());
                int legIndex = getIntent().getIntExtra("legIndex", 0);
                legfrag.setListIndex(legIndex);

                fragManager.beginTransaction()
                        .add(R.id.leg_container, legfrag)
                        .commit();

            }



        } else {
            TabPane = false;
        }
    }

    public void onImageSelected(int position) {
        Toast.makeText(this, "Selected", Toast.LENGTH_SHORT).show();

        int bodyNo = position / 12;

        int bodyIndex = position - 12 * bodyNo;

        if (TabPane) {

            BodyPartFragment TabFragment = new BodyPartFragment();

            switch (bodyNo) {
                case 0:
                    TabFragment.setmImageIds(ImageAssets.getHeads());
                    TabFragment.setListIndex(bodyIndex);

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.body_container, TabFragment)
                            .commit();
                    break;

                case 1:
                    TabFragment.setmImageIds(ImageAssets.getBodies());
                    TabFragment.setListIndex(bodyIndex);

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.body_container, TabFragment)
                            .commit();
                    break;

                case 2:
                    TabFragment.setmImageIds(ImageAssets.getLegs());
                    TabFragment.setListIndex(bodyIndex);

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.body_container, TabFragment)
                            .commit();
                    break;

                default:
                    break;
            }

        }

        else {

            switch (bodyNo) {
                case 0:
                    head_index = bodyIndex;
                    break;
                case 1:
                    body_index = bodyIndex;
                    break;
                case 2:
                    leg_index = bodyIndex;
                    break;
                default:
                    break;
            }


            Bundle b = new Bundle();
            b.putInt("headIndex", head_index);
            b.putInt("bodyIndex", body_index);
            b.putInt("legIndex", leg_index);


            final Intent intent = new Intent(this, AndroidBuddy.class);
            intent.putExtras(b);


            Button nextButton = (Button) findViewById(R.id.next_button);
            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(intent);

                }
            });
        }
    }
    }



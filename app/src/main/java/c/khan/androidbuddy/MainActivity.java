package c.khan.androidbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    public int head_index, body_index, leg_index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onImageSelected(int position) {
        Toast.makeText(this, "Position = " + position, Toast.LENGTH_SHORT).show();

        int bodyNo = position / 12;

        int bodyIndex = position - 12 * bodyNo;

        switch (bodyNo) {
            case 0 : head_index = bodyIndex;
            break;
            case 1 : body_index = bodyIndex;
            break;
            case 2 : leg_index = bodyIndex;
            break;
            default:break;
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



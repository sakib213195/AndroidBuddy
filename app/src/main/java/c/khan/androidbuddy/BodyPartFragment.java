package c.khan.androidbuddy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * Created by Khan Desktop on 28-May-20.
 */

public class BodyPartFragment extends Fragment {

    public BodyPartFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.bodypart, container, false);

        ImageView imageView = (ImageView) rootView.findViewById(R.id.bodypart_imageview);

        imageView.setImageResource(ImageAssets.getHeads().get(0));

        return rootView;

    }

}

package c.khan.androidbuddy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;


/**
 * Created by Khan Desktop on 28-May-20.
 */

public class BodyPartFragment extends Fragment {

    private static final String TAG = "BodyPartFragment";

    private List <Integer> mImageIds;
    private int mListIndex;

    public BodyPartFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.bodypart, container, false);

        ImageView imageView = (ImageView) rootView.findViewById(R.id.bodypart_imageview);

        //imageView.setImageResource(ImageAssets.getHeads().get(0));

        if (mImageIds != null){
            imageView.setImageResource(mImageIds.get(mListIndex));
        }

        else {
            Log.v(TAG, "Error: No image ID");
        }



        return rootView;

    }

    public void setmImageIds(List<Integer> imageIds){
        mImageIds = imageIds;
    }

    public void setListIndex (int index){
        mListIndex = index;
    }

}

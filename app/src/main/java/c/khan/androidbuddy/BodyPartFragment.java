package c.khan.androidbuddy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Khan Desktop on 28-May-20.
 */

public class BodyPartFragment extends Fragment {

    public static final String IMAGE_LIST = "img_ID";
    public static final String IMAGE_INDEX = "img_index";


    private static final String TAG = "BodyPartFragment";

    private List <Integer> mImageIds;
    private int mListIndex;

    public BodyPartFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        if (savedInstanceState != null){
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_LIST);
            mListIndex = savedInstanceState.getInt(IMAGE_INDEX);
        }

        View rootView = inflater.inflate(R.layout.bodypart, container, false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.bodypart_imageview);

        //imageView.setImageResource(ImageAssets.getHeads().get(0));

        if (mImageIds != null){
            imageView.setImageResource(mImageIds.get(mListIndex));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (mListIndex < mImageIds.size()-1){
                        mListIndex++;
                    } else {
                        mListIndex = 0;
                    }

                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            }

            );

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

    @Override
    public void onSaveInstanceState (Bundle currentState){
        currentState.putIntegerArrayList(IMAGE_LIST, (ArrayList<Integer>)mImageIds);
        currentState.putInt(IMAGE_INDEX, mListIndex);
    }

}

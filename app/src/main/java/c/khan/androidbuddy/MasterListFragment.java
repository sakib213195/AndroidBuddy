package c.khan.androidbuddy;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;

public class MasterListFragment extends Fragment {

    OnImageClickListener mCallback;

    public interface OnImageClickListener {
        void onImageSelected (int pos);
    }

    @Override
    public void onAttach (Context context){
        super.onAttach(context);

        try {
            mCallback = (OnImageClickListener) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString() + " = error occured");
        }

    }

    public MasterListFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        final View rootView = inflater.inflate(R.layout.activity_master_list_fragment, container, false);

        GridView gridView = (GridView) rootView.findViewById(R.id.images_grid_view);

        MasterListAdapter mAdapter = new MasterListAdapter(getContext(), ImageAssets.getAll());

        gridView.setAdapter(mAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Trigger the callback method and pass in the position that was clicked
                mCallback.onImageSelected(position);
            }
        });

        return rootView;


    }



}

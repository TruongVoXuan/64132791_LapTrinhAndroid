package truong.vx.th_bai3_chuyenmanhinh_fragmentassignment.TiengAnh;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import truong.vx.th_bai3_chuyenmanhinh_fragmentassignment.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentTiengAnh3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentTiengAnh3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragmentTiengAnh3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragmentTiengAnh3.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentTiengAnh3 newInstance(String param1, String param2) {
        BlankFragmentTiengAnh3 fragment = new BlankFragmentTiengAnh3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_tieng_anh3, container, false);
    }
}
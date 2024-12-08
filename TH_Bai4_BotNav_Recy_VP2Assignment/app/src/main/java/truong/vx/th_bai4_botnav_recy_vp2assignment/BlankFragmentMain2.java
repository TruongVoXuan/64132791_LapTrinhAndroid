package truong.vx.th_bai4_botnav_recy_vp2assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentMain2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentMain2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragmentMain2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragmentMain2.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentMain2 newInstance(String param1, String param2) {
        BlankFragmentMain2 fragment = new BlankFragmentMain2();
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_main2, container, false);

        // Tìm nút cn2Btn và thêm sự kiện
        ImageButton cn2Btn = view.findViewById(R.id.cn2Btn);
        cn2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang CN2Activity
                Intent intent = new Intent(getActivity(), CN2.class);
                startActivity(intent);
            }
        });

        // Tìm nút iconBtn1 và thêm sự kiện
        ImageButton iconBtn1 = view.findViewById(R.id.cn1Btn);
        iconBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển lại MainActivity
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });


        ImageButton cn3Btn = view.findViewById(R.id.cn3Btn);
        cn3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang CN2Activity
                Intent intent = new Intent(getActivity(), CN3.class);
                startActivity(intent);
            }
        });

        ImageButton cn4Btn = view.findViewById(R.id.cn4Btn);
        cn4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang CN4Activity
                Intent intent = new Intent(getActivity(), CN4.class);
                startActivity(intent);
            }
        });


        return view;
    }
}
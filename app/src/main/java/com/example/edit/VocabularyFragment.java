package com.example.edit;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;







public class VocabularyFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vocabulary, container, false);

        LinearLayout linearLayout = view.findViewById(R.id.aaa);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý khi LinearLayout được click, ví dụ mở một activity mới
                Intent intent = new Intent(getActivity(), DashboardActivity.class);
                startActivity(intent);
            }
        });
        LinearLayout llinearLayout = view.findViewById(R.id.aaaa);
        llinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), listItem2.class);
                startActivity(intent);
            }
        });
        LinearLayout lllinearLayout = view.findViewById(R.id.aaaaa);
        lllinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), listItem1.class);
                startActivity(intent);
            }
        });

        return view;
    }
}

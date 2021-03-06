package com.omegaspockatari.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Kiora on 8/6/2016.
 */
public class TourFragment extends Fragment {
    public TourFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tour_guide_list, container, false);

        final ArrayList<TourGuideItem> tourGuideItems = new ArrayList<>();

        TourGuideAdapter adapter = new TourGuideAdapter(getContext(), tourGuideItems);

        tourGuideItems.add(new TourGuideItem(R.string.tour_website_1, R.string.tour_address_1,
                R.string.tour_name_1, R.string.tour_blurb_1, R.drawable.tour_picture_1));
        tourGuideItems.add(new TourGuideItem(R.string.tour_website_2, R.string.tour_address_2,
                R.string.tour_name_2, R.string.tour_blurb_2, R.drawable.tour_picture_2));
        tourGuideItems.add(new TourGuideItem(R.string.tour_website_3, R.string.tour_address_3,
                R.string.tour_name_3, R.string.tour_blurb_3, R.drawable.tour_picture_3));
        tourGuideItems.add(new TourGuideItem(R.string.tour_website_4, R.string.tour_address_4,
                R.string.tour_name_4, R.string.tour_blurb_4, R.drawable.tour_picture_4));
        tourGuideItems.add(new TourGuideItem(R.string.tour_website_5, R.string.tour_address_5,
                R.string.tour_name_5, R.string.tour_blurb_5, R.drawable.tour_picture_5));

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), TourGuidePage.class);

                intent.putParcelableArrayListExtra("tourGuideItems", tourGuideItems);

                startActivity(intent);
            }
        });

        return listView;
    }
}

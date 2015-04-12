package com.migapro.criminalintent.ui;

import android.app.DialogFragment;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.migapro.criminalintent.util.PictureUtils;

public class ImageFragment extends DialogFragment {
    public static final String EXTRA_IMAGE_PATH = "com.migapro.criminalintent.image_path";

    private ImageView mImageView;

    public static ImageFragment newInstance(String imagePath) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_IMAGE_PATH, imagePath);

        ImageFragment fragment = new ImageFragment();
        fragment.setArguments(args);
        fragment.setStyle(DialogFragment.STYLE_NO_TITLE, 0);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mImageView = new ImageView(getActivity());

        String path = (String) getArguments().getSerializable(EXTRA_IMAGE_PATH);
        BitmapDrawable drawable = PictureUtils.getScaledDrawable(getActivity(), path);

        mImageView.setImageDrawable(drawable);

        return mImageView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        PictureUtils.clearImageView(mImageView);
    }
}

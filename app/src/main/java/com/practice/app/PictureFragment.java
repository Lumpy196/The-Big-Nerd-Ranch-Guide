package com.practice.app;



import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.io.File;


public class PictureFragment extends DialogFragment {

    private static final String ARG_PICTURE_FILE = "picture_file";

    private static final String DIALOG_PICTURE = "DialogPicture";



    private ImageView mDialogPicture;

    public static PictureFragment newInstance(File file) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PICTURE_FILE, file);

        PictureFragment fragment = new PictureFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



/*
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dialog, container, false);
        mDialogPicture = view.findViewById(R.id.photo_dialog);
        File file = (File)getArguments().getSerializable(ARG_PICTURE_FILE);
        Bitmap bitmap = BitmapFactory.decodeFile(file.getPath());
        mDialogPicture.setImageBitmap(bitmap);
        return view;

    }
*/

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_dialog, null);
        mDialogPicture = view.findViewById(R.id.photo_dialog);
        File file = (File)getArguments().getSerializable(ARG_PICTURE_FILE);
        Bitmap bitmap = BitmapFactory.decodeFile(file.getPath());
        mDialogPicture.setImageBitmap(bitmap);
        return new AlertDialog.Builder(getActivity()).setView(view).setTitle("show picture").create();
    }
}

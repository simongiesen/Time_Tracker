package com.elliot_labs.timetracker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Elliot on 2/5/2017.
 */

public class CategoryAddFragment extends Fragment implements OnClickListener {

    DatabaseHelper timeDatabase;
    EditText newCategoryEditText;
//    Spinner parentAddSpinner;
    Button createButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_category_add, container, false);

        newCategoryEditText = (EditText) v.findViewById(R.id.newCategoryEditText);
        createButton = (Button) v.findViewById(R.id.createButton);
//        parentAddSpinner = (Spinner) v.findViewById(R.id.parentAddSpinner);
        timeDatabase = new DatabaseHelper(getActivity());

        createButton.setOnClickListener(this);

//        updateSelectorItems();

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.createButton:
//                Integer parentID = (int) (long) parentAddSpinner.getSelectedItemId();
                String nameOfCategory = newCategoryEditText.getText().toString();

                if (nameOfCategory.trim().isEmpty()) {
                    Toast.makeText(getActivity(),"Please type a category name.", Toast.LENGTH_LONG).show();
                } else {
                    boolean errorCheck = timeDatabase.addDataCategories(nameOfCategory, 0);

                    if (errorCheck) {
                        Toast.makeText(getActivity(),"Saved!", Toast.LENGTH_LONG).show();
                        newCategoryEditText.setText("");
                    } else {
                        Toast.makeText(getActivity(),"Something went wrong :-(", Toast.LENGTH_LONG).show();
                    }
                }
//                updateSelectorItems();
                break;
        }
    }


//    public void updateSelectorItems(){
//        SparseArray<String> categoryNames = timeDatabase.getColumnData("categories", 1);
//        categoryNames.put(0, "None");
//        SparseStringsAdapter spinnerAdapter = new SparseStringsAdapter(getActivity(), categoryNames);
//        parentAddSpinner.setAdapter(spinnerAdapter);
//        parentAddSpinner.setSelection(0);
//    }
}
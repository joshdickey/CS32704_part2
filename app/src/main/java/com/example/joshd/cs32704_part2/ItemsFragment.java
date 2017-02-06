package com.example.joshd.cs32704_part2;


import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.sip.SipAudioCall;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemsFragment extends Fragment {
    onEditTextChangedListener mCallback;

    interface onEditTextChangedListener{
        public void onEditTextIsChanged(double total);

    }

    private double item1, item2, item3, item4, total;
    private EditText txvItem4, txvItem1, txvItem2, txvItem3;
    MainActivity ma;

    public ItemsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_items, container, false);

        txvItem1 = (EditText) rootView.findViewById(R.id.edtItemAmount1);
        txvItem2 = (EditText) rootView.findViewById(R.id.edtItemAmount2);
        txvItem3 = (EditText) rootView.findViewById(R.id.edtItemAmount3);
        txvItem4 = (EditText) rootView.findViewById(R.id.edtItemAmount4);

//        mCallback.onEditTextIsChanged(44);

        txvItem1.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                item1 = Double.parseDouble(txvItem1.getText().toString());
                if (!txvItem1.getText().toString().isEmpty()){
                    item1 = Double.parseDouble(txvItem1.getText().toString());
                    setTotal();
                }else{
                    item1 = 0;
                    setTotal();

                }
                mCallback.onEditTextIsChanged(total);
            }
        });



        return rootView;
    }

    public void setTotal(){
        total = item1 + item2 + item3 + item4;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (onEditTextChangedListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()
                    + " must implement onEditTextChangedListener");
        }
    }


}


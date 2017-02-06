package com.example.joshd.cs32704_part2;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TotalsFragment extends Fragment {


    View rootView;
    double total;
    TextView txvTotal;

    public TotalsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_totals, container, false);
        txvTotal = (TextView) rootView.findViewById(R.id.txvTotalAmountValue);

        return rootView;
    }



    @Override
    public void onPause() {
        super.onPause();
        Log.d("test", "Totals Fragment on Pause");
        SharedPreferences preferences = getActivity().getPreferences(getActivity().MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("txvTotal", txvTotal.getText().toString());
        editor.putFloat("total", (float) total);
        editor.apply();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("test", "Totals Fragment on Resume");

        MainActivity ma = (MainActivity)getActivity();
        total = ma.getTotal();
        String sTotal;
        sTotal = "$" + ma.getTotal();
        TextView txvTotal = (TextView) rootView.findViewById(R.id.txvTotalAmountValue);
        txvTotal.setText(sTotal);
        Log.d("test", "Totals Fragment on Resume total is " + total + " and total from main is " + ma.getTotal());

        SharedPreferences preferences = getActivity().getPreferences(getActivity().MODE_PRIVATE);
        txvTotal.setText(preferences.getString("txvTotal", ""));
        total = preferences.getFloat("total", 0);

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("test", "Totals Fragment On Start");
    }

    public void setTotal(Double total) {
        //     this.total = total;

        txvTotal = (TextView)rootView.findViewById(R.id.txvTotalAmountValue);
        txvTotal.setText("$" + total.toString());
    }
}

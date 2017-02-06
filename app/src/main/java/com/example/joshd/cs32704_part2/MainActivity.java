package com.example.joshd.cs32704_part2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ItemsFragment.onEditTextChangedListener{

    private double total, tax, totalWithTax, oldTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.totalsFrame, new TotalsFragment(), "totals")
                .add(R.id.ItemsFrame, new ItemsFragment(), "Items")
                .commit();

    }

    @Override
    public void onEditTextIsChanged(double total) {
        Log.e("test", "Main Total from Items is" + total);
        this.total = total;
        this.totalWithTax = total + tax;

        if (totalWithTax != oldTotal) {
            TotalsFragment totalsFragment = (TotalsFragment) getSupportFragmentManager().findFragmentByTag("totals");
            totalsFragment.setTotal(totalWithTax);
        }
    }

    public double getTotal(){
        return totalWithTax;
    }
}

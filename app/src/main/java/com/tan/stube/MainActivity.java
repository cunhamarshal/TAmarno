package com.tan.stube;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {
    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainGrid = (GridLayout)findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);
    }
    private void setSingleEvent(GridLayout mainGrid) {
        for (int i = 0 ; i < mainGrid.getChildCount();i++)
        {
            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int finalI = i;

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (finalI == 0)
                    {
                        Intent intent = new Intent(MainActivity.this, PLembagaActivity.class);
                        startActivity(intent);
                    }else if (finalI == 1)
                    {
                        Intent intent = new Intent(MainActivity.this, PPengembangActivity.class);
                        startActivity(intent);
                    }else if (finalI == 2)
                    {
                        Intent intent = new Intent(MainActivity.this, BeritaActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }

    public void exit(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Comfirm exit")
                .setMessage("Ingin Keluar ?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
        .show();

    }
}

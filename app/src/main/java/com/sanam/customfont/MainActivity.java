package com.sanam.customfont;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button btnAlertDialog;
    Button btnCustomAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.txt);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/NotoSansUI-Bold.ttf");
        txt.setTypeface(typeface);

        btnAlertDialog = (Button) findViewById(R.id.btnAlertDialog);
        btnCustomAlertDialog = (Button) findViewById(R.id.btnCustomAlert);

        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("This is title");
                builder.setMessage("So you wanna close this application?");

                builder.setPositiveButton("Ya, just quit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }
                );
                builder.setNegativeButton("Nop, stay", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }
                );

                builder.setNeutralButton("No idea", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });

        btnCustomAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View customView = inflater.inflate(R.layout.custom_dialog_box, null);

                Button like = (Button) customView.findViewById(R.id.btnLike);
                Button dislike = (Button) customView.findViewById(R.id.btnDislike);

                like.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "You've got good eye sight", Toast.LENGTH_SHORT).show();
                    }
                });

                dislike.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "You've got very bad eye sight", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setView(customView);
                builder.create();
                builder.show();
            }
        });
    }
}

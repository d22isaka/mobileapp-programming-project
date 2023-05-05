package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

  //  Atom atom = new Atom("Helium", "nonMetal", 1 );
    //String info = atom.info();

    private RecyclerViewAdapter adapter;

    ArrayList<Atom> atoms = new ArrayList<>(Arrays.asList(
            new Atom ("H ","Väte ", "Icke-metaller", 1),
            new Atom("He ","Helium ", "Ädelgas", 2),
            new Atom("Li ","Litium ", "Alkalimetall", 3),
            new Atom("Be ","Beryllium ", "Alkaliskt jordartsmetall", 4),
            new Atom("B ","Bor ", "Halvmetall", 5),
            new Atom("C ","Kol ", "icke-metall", 6),
            new Atom("N ","Kväve ", "icke-metall", 7),
            new Atom("O ","Syre ", "icke-metall", 8),
            new Atom("F ","Fluor ", "icke-metall", 9),
            new Atom("Ne ","Neon ", "Ädelgas", 10)
    ));




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button about = findViewById(R.id.about);
        TextView textView = findViewById(R.id.textView);

        adapter = new RecyclerViewAdapter(this, atoms, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(Atom item) {
                Toast.makeText(MainActivity.this, item.getType(), Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView view = findViewById(R.id.recycler_view);
        view.setLayoutManager(new GridLayoutManager(this, 1));
        view.setAdapter(adapter);

    //    textView.setText(info);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
            }
        });


    }

}

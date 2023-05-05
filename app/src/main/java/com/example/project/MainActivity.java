package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Atom atom = new Atom("Helium", "nonMetal", 1 );
    String info = atom.info();

    private RecyclerViewAdapter adapter;

    ArrayList<Atom> atoms = new ArrayList<>(Arrays.asList(
            new Atom ("Väte", "Icke-metaller", 1),
            new Atom("Helium", "Ädelgas", 2),
            new Atom("Litium", "Alkalimetall", 3),
            new Atom("Beryllium", "Alkalist jordartsmetall", 4),
            new Atom("Bor", "Halvmetall", 5),
            new Atom("Kol", "icke-metall", 6),
            new Atom("Kväve", "icke-metall", 7),
            new Atom("Syre", "icke-metall", 8),
            new Atom("Fluor", "icke-metall", 9),
            new Atom("Neon", "Ädelgas", 10)
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
                Toast.makeText(MainActivity.this, item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView view = findViewById(R.id.recycler_view);
        view.setLayoutManager(new LinearLayoutManager(this));
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

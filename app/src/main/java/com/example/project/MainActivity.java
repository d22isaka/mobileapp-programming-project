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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=d22isaka";

    private List<Atom> atomList;
    private RecyclerViewAdapter adapter;

    ArrayList<Atom> atoms = new ArrayList<>(Arrays.asList(
            new Atom("H ", "Väte ", "Icke-metaller", 1),

            new Atom("He ", "Helium ", "Ädelgas", 2),
            new Atom("Li ", "Litium ", "Alkalimetall", 3),
            new Atom("Be ", "Beryllium ", "Alkaliskt jordartsmetall", 4),
            new Atom("B ", "Bor ", "Halvmetall", 5),
            new Atom("C ", "Kol ", "icke-metall", 6),
            new Atom("N ", "Kväve ", "icke-metall", 7),
            new Atom("O ", "Syre ", "icke-metall", 8),
            new Atom("F ", "Fluor ", "icke-metall", 9),
            new Atom("Ne ", "Neon ", "Ädelgas", 10)
    ));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        new JsonTask(this).execute(JSON_URL);

        atomList = new ArrayList<Atom>();

        Button about = findViewById(R.id.about);
        TextView textView = findViewById(R.id.textView);
        TextView category = findViewById(R.id.category);

        adapter = new RecyclerViewAdapter(this, atoms, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(Atom item) {
                Toast.makeText(MainActivity.this, item.getType(), Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView view = findViewById(R.id.recycler_view);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);


        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
            }
        });


    }


    @Override
    public void onPostExecute(String json) {


        Gson gson = new Gson();
        Type type = new TypeToken<List<Atom>>() {
        }.getType();

        atomList = gson.fromJson(json, type);
        adapter.addData(atomList);


        Collections.sort(atomList, new Comparator<Atom>() {
            @Override
            public int compare(Atom a1, Atom a2) {
                return a1.getName().compareTo(a2.getName());
            }
        });

        adapter.notifyDataSetChanged();


    }
}

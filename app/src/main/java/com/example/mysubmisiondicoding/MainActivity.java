package com.example.mysubmisiondicoding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvrumahadat;
    private ArrayList<Rumah> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvrumahadat = findViewById(R.id.rvrumahadat);
        rvrumahadat.setHasFixedSize(true);

        list.addAll(DataRumahAdat.getListdata());
        showReclerList();

    }
    private void showReclerList() {
        rvrumahadat.setLayoutManager(new LinearLayoutManager(this));
        ListRumahAdatAdapter listRumahAdatAdapter = new ListRumahAdatAdapter(list);
        rvrumahadat.setAdapter(listRumahAdatAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selecedMode){
        switch (selecedMode){
            case R.id.btnprofile:
                Intent profileku = new Intent(MainActivity.this, profil.class);
                startActivity(profileku);
                break;
        }
    }
}

package id.ac.polinema.prokjekuts.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import id.ac.polinema.prokjekuts.R;
import id.ac.polinema.prokjekuts.data.Data;
import id.ac.polinema.prokjekuts.data.AsmaulHusna;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<AsmaulHusna> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView)findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(Data.getListTokoh());

        setActionBarTitle("Asmaul Husna");
        showRecyclerList();
    }

    private void clickList() {
        ItemClickSupport.addTo(rv).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedTokoh(list.get(position));
            }
        });
    }

    private void showRecyclerList(){
        rv.setLayoutManager(new LinearLayoutManager(this));
        AsmaulHusnaAdapter asmaulHusnaAdapter = new AsmaulHusnaAdapter(this);
        asmaulHusnaAdapter.setListTokoh(list);
        rv.setAdapter(asmaulHusnaAdapter);
        clickList();
    }

    private void showRecyclerGrid(){
        rv.setLayoutManager(new GridLayoutManager(this, 2));
        AsmaulHusnaAdapterGrid asmaulHusnaAdapterGrid = new AsmaulHusnaAdapterGrid(this);
        asmaulHusnaAdapterGrid.setListTokoh(list);
        rv.setAdapter(asmaulHusnaAdapterGrid);
        clickList();
    }

    private void showRecyclerCard(){
        rv.setLayoutManager(new LinearLayoutManager(this));
        AsmaulHusnaAdapterCard asmaulHusnaAdapterCard = new AsmaulHusnaAdapterCard(this);
        asmaulHusnaAdapterCard.setListTokoh(list);
        rv.setAdapter(asmaulHusnaAdapterCard);
        clickList();
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    private void showSelectedTokoh(AsmaulHusna tokoh){
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("name", tokoh.getName());
        intent.putExtra("remarks", tokoh.getRemarks());
        intent.putExtra("photo", tokoh.getPhoto());
        intent.putExtra("desc", tokoh.getDesc());
        startActivity(intent);
        Toast.makeText(this, "Kamu memilih '"+tokoh.getName()+"'", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String title = null;
        switch (item.getItemId()){
            case R.id.menu_list:
                showRecyclerList();
                break;

            case R.id.menu_grid:
                showRecyclerGrid();
                break;

            case R.id.menu_cardview:
                showRecyclerCard();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}

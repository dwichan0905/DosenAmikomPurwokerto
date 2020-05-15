package id.dwichan.dosenamikompurwokerto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvDosen;
    private ArrayList<String> nama = new ArrayList<>();
    private ArrayList<String> ringkasan = new ArrayList<>();
    private ArrayList<Integer> foto = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvDosen = findViewById(R.id.rvDosen);
        rvDosen.setHasFixedSize(true);

        addList();
        showRecyclerList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void addList() {
        nama.add("Abdul Azis");
        nama.add("Abednego Dwi Septiadi");
        nama.add("Adam Prayogo Kuncoro");
        nama.add("Agus Pramono");
        nama.add("Bagus Adhi Kusuma");
        nama.add("Bunga Asriandhini");
        nama.add("Eldas Puspita Rini");
        nama.add("Mohammad Imron");
        nama.add("Nandang Hermanto");
        nama.add("Shodiq Khalidy");

        ringkasan.add("Dosen sejak Tahun Ajaran 2015/2016");
        ringkasan.add("Dosen sejak Tahun Ajaran 2014/2015");
        ringkasan.add("Dosen sejak Tahun Ajaran 2015/2016");
        ringkasan.add("Dosen sejak Tahun Ajaran 2016/2017");
        ringkasan.add("Dosen sejak Tahun Ajaran 2012/2013");
        ringkasan.add("Dosen sejak Tahun Ajaran 2019/2020");
        ringkasan.add("Dosen sejak Tahun Ajaran 2010/2011");
        ringkasan.add("Dosen sejak Tahun Ajaran 2010/2011");
        ringkasan.add("Dosen sejak Tahun Ajaran 2010/2011");
        ringkasan.add("Dosen sejak Tahun Ajaran 2010/2011");

        foto.add(R.drawable.abdul_azis);
        foto.add(R.drawable.abednego);
        foto.add(R.drawable.adamp);
        foto.add(R.drawable.agus_pramono);
        foto.add(R.drawable.bagus);
        foto.add(R.drawable.bunga);
        foto.add(R.drawable.eldas);
        foto.add(R.drawable.imron);
        foto.add(R.drawable.nandang);
        foto.add(R.drawable.shodiq);
    }

    private void showRecyclerList() {
        rvDosen.setLayoutManager(new LinearLayoutManager(this));
        ListDosenAdapter lda = new ListDosenAdapter(this, nama, ringkasan, foto);
        rvDosen.setAdapter(lda);
    }

    public void showAbout(MenuItem item) {
        Intent i = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(i);
    }
}

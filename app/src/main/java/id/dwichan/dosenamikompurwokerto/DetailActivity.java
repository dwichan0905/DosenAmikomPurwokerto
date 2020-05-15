package id.dwichan.dosenamikompurwokerto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {
    TextView tvNamaDosen, tvEmailDosen, tvAlamatDosen, tvSejakTA, tvNoTelp, tvRincian;
    ImageView imgDosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Detail Dosen");
        }

        int getPos = getIntent().getIntExtra("position", 0);

        tvNamaDosen = findViewById(R.id.tvNamaDosen);
        tvEmailDosen = findViewById(R.id.tvEmailDosen);
        tvAlamatDosen = findViewById(R.id.tvAlamatDosen);
        tvSejakTA = findViewById(R.id.tvSejakTA);
        tvNoTelp = findViewById(R.id.tvNoTelp);
        tvRincian = findViewById(R.id.tvRincian);
        imgDosen = findViewById(R.id.imgDosen);

        Glide.with(this)
                .load(DosenCollection.foto[getPos])
                .into(imgDosen);
        tvNamaDosen.setText(DosenCollection.nama[getPos]);
        tvEmailDosen.setText(DosenCollection.email[getPos]);
        tvAlamatDosen.setText(DosenCollection.alamat[getPos]);
        tvSejakTA.setText(DosenCollection.sejakTA[getPos]);
        tvNoTelp.setText(DosenCollection.noTelp[getPos]);
        tvRincian.setText(DosenCollection.rincian[getPos]);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
        }
        return true;
    }
}

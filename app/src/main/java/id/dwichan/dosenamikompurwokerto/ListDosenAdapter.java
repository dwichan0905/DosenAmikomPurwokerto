package id.dwichan.dosenamikompurwokerto;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListDosenAdapter extends RecyclerView.Adapter<ListDosenAdapter.ListViewHolder> {
    private Context con;
    private ArrayList<String> nama;
    private ArrayList<String> ringkasan;
    private ArrayList<Integer> foto;

    public ListDosenAdapter(Context con, ArrayList<String> nama, ArrayList<String> ringkasan, ArrayList<Integer> foto) {
        this.con = con;
        this.nama = nama;
        this.foto = foto;
        this.ringkasan = ringkasan;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_dosen, parent, false);
        return new ListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, final int position) {
        Glide.with(con)
                .load(foto.get(position))
                .apply(new RequestOptions().override(55, 55))
                .into(holder.civPhoto);
        holder.tvNama.setText(nama.get(position));
        holder.tvRingkasan.setText(ringkasan.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(con, String.valueOf(position), Toast.LENGTH_SHORT).show();
                con.startActivity(new Intent(con, DetailActivity.class).putExtra("position", position));
            }
        });
    }



    @Override
    public int getItemCount() {
        return nama.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView civPhoto;
        TextView tvNama, tvRingkasan;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            civPhoto = itemView.findViewById(R.id.civPhoto);
            tvNama = itemView.findViewById(R.id.tvNamaDosen);
            tvRingkasan = itemView.findViewById(R.id.tvRingkasan);
        }
    }
}

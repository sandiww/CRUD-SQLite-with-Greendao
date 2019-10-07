package com.codewith.sandisuryadi.samplecrudgreendao.create;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.codewith.sandisuryadi.samplecrudgreendao.R;
import com.codewith.sandisuryadi.samplecrudgreendao.home.HomeActivity;
import com.codewith.sandisuryadi.samplecrudgreendao.utils.database.DaoHandler;
import com.codewith.sandisuryadi.samplecrudgreendao.utils.database.DaoSession;
import com.codewith.sandisuryadi.samplecrudgreendao.utils.database.TblPengeluaran;

import java.nio.file.attribute.FileAttribute;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CreateActivity extends AppCompatActivity {
    @BindView(R.id.etPembelian)
    EditText etPembelian;
    @BindView(R.id.etNominal)
    EditText etNominal;
    @BindView(R.id.btnSimpan)
    Button btnSimpan;

    private Unbinder unbinder;
    private DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Buat Pengeluaran");

            unbinder = ButterKnife.bind(this);
            daoSession = DaoHandler.getInstance(this);

            btnSimpan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String pembelian = etPembelian.getText().toString();
                    String nominal = etNominal.getText().toString();

                    if (pembelian.isEmpty() || nominal.isEmpty()){
                        Toast.makeText(CreateActivity.this, "Data Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
                    } else {
                        /*
                    Fungsi untuk menambahkan data kedalam database. Disini kita menambahkan data
                    kedalam tabel TblPengeluaran.
                    Di Greendao jika mau menambakan data fungsi yang kita panggil adalah insert.
                     */

                        TblPengeluaran tblPengeluaran = new TblPengeluaran();
                        tblPengeluaran.setPengeluaran(pembelian);
                        tblPengeluaran.setNominal(Integer.parseInt(nominal));
                        daoSession.getTblPengeluaranDao().insert(tblPengeluaran);

                        Toast.makeText(CreateActivity.this, "Berhasil Input Data", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(CreateActivity.this, HomeActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        finish();
                    }
                }
            });
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}

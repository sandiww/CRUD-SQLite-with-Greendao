package com.codewith.sandisuryadi.samplecrudgreendao.utils.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class TblPengeluaran {
    @Id(autoincrement = true)
    private Long idTblPengeluaran;

    private String pengeluaran;
    private int nominal;
    @Generated(hash = 388400954)
    public TblPengeluaran(Long idTblPengeluaran, String pengeluaran, int nominal) {
        this.idTblPengeluaran = idTblPengeluaran;
        this.pengeluaran = pengeluaran;
        this.nominal = nominal;
    }
    @Generated(hash = 177408923)
    public TblPengeluaran() {
    }
    public Long getIdTblPengeluaran() {
        return this.idTblPengeluaran;
    }
    public void setIdTblPengeluaran(Long idTblPengeluaran) {
        this.idTblPengeluaran = idTblPengeluaran;
    }
    public String getPengeluaran() {
        return this.pengeluaran;
    }
    public void setPengeluaran(String pengeluaran) {
        this.pengeluaran = pengeluaran;
    }
    public int getNominal() {
        return this.nominal;
    }
    public void setNominal(int nominal) {
        this.nominal = nominal;
    }
}

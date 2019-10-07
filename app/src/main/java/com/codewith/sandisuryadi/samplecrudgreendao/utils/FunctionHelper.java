package com.codewith.sandisuryadi.samplecrudgreendao.utils;

import java.text.NumberFormat;
import java.util.Locale;

/*
Fungsi untuk mengconvert sebuah nilai menjadi format Rupiah.
Contoh : 1000 akan menjadi Rp1.000
 */
public class FunctionHelper {
    public static String convertRupiah(int nominal){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(nominal);
    }
}

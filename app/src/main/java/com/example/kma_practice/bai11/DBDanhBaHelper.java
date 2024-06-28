package com.example.kma_practice.bai11;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.kma_practice.bai10.AccountBai10;

import java.util.ArrayList;
import java.util.List;

public class DBDanhBaHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "DB_DANHBA";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "taikhoans";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_NAME + " TEXT, "
            + KEY_PHONE + " TEXT)";

    public DBDanhBaHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addTaiKhoan(AccountBai10 tk) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, tk.getName());
        values.put(KEY_PHONE, tk.getPhoneNumber());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<AccountBai10> getAll() {
        List<AccountBai10> accountList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                AccountBai10 account = new AccountBai10();
                account.setId(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_ID)));
                account.setName(cursor.getString(cursor.getColumnIndexOrThrow(KEY_NAME)));
                account.setPhoneNumber(cursor.getString(cursor.getColumnIndexOrThrow(KEY_PHONE)));
                accountList.add(account);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return accountList;
    }

    public void updateTaiKhoan(AccountBai10 tk) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, tk.getName());
        values.put(KEY_PHONE, tk.getPhoneNumber());
        db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[]{String.valueOf(tk.getId())});
        db.close();
    }

    public void deleteTaiKhoan(AccountBai10 tk) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + " = ?",
                new String[]{String.valueOf(tk.getId())});
        db.close();
    }
}

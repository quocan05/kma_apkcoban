package com.example.kma_practice.bai11;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kma_practice.R;
import com.example.kma_practice.bai10.AccountBai10;

import java.util.List;

public class Bai11Activity extends AppCompatActivity {

    private List<AccountBai10> accountList;
    private AccountAdapter accountAdapter;

    private DBDanhBaHelper  dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai11);

        dbHelper = new DBDanhBaHelper(this);
        loadAccounts();

        ListView listView = findViewById(R.id.listViewAccounts);
        accountAdapter = new AccountAdapter();
        listView.setAdapter(accountAdapter);

        Button btnAddAccount = findViewById(R.id.btnAddAccount);
        btnAddAccount.setOnClickListener(v -> {
            AccountBai10 newAccount = new AccountBai10();
            dbHelper.addTaiKhoan(newAccount);
            loadAccounts();
            accountAdapter.notifyDataSetChanged();
        });
    }

    private void loadAccounts() {
        accountList = dbHelper.getAll();
    }

    private class AccountAdapter extends android.widget.BaseAdapter {

        @Override
        public int getCount() {
            return accountList.size();
        }

        @Override
        public Object getItem(int position) {
            return accountList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                convertView = LayoutInflater.from(Bai11Activity.this)
                        .inflate(R.layout.listaccbai11, parent, false);

                holder = new ViewHolder();
                holder.etAccountName = convertView.findViewById(R.id.etAccountName);
                holder.etAccountPhone = convertView.findViewById(R.id.etAccountPhone);
                holder.btnApply = convertView.findViewById(R.id.btnApply);
                holder.btnDelete = convertView.findViewById(R.id.btnDelete);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            AccountBai10 account = (AccountBai10) getItem(position);
            holder.etAccountName.setText(account.getName());
            holder.etAccountPhone.setText(account.getPhoneNumber());

            holder.btnApply.setOnClickListener(v -> {
                account.setName(holder.etAccountName.getText().toString());
                account.setPhoneNumber(holder.etAccountPhone.getText().toString());
                dbHelper.updateTaiKhoan(account);
                loadAccounts();
                notifyDataSetChanged();
                Toast.makeText(Bai11Activity.this, "Tài khoản đã được cập nhật", Toast.LENGTH_SHORT).show();
            });

            holder.btnDelete.setOnClickListener(v -> {
                dbHelper.deleteTaiKhoan(account);
                loadAccounts();
                notifyDataSetChanged();
                Toast.makeText(Bai11Activity.this, "Tài khoản đã được xóa", Toast.LENGTH_SHORT).show();
            });

            return convertView;
        }

        private class ViewHolder {
            EditText etAccountName;
            EditText etAccountPhone;
            Button btnApply;
            Button btnDelete;
        }
    }
}

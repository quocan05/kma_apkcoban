package com.example.kma_practice.bai4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListUser {
    private List<Account> listUSer;

    private void addUser() {
        this.listUSer = new ArrayList<Account>();
        listUSer.add(new Account("Quoc An", "0989999999", "quocan","123"));
        listUSer.add(new Account("Nguyen Nhung", "0989999999", "nguyennhung","123"));
        listUSer.add(new Account("Tuan Anh", "0989999999", "tuananh","123"));
        listUSer.add(new Account("Goku", "0989999999", "quocan","123"));
        listUSer.add(new Account("Vegeta", "0989999999", "vegeta","123"));
    }
    public ListUser() {
        addUser();
    }

    public List<Account> getListUSer() {
        return listUSer;
    }

    public void setListUSer(List<Account> listUSer) {
        this.listUSer = listUSer;
    }

    @Override
    public String toString() {
        return "ListUser{" +
                "listUSer=" + listUSer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListUser)) return false;
        ListUser listUser = (ListUser) o;
        return Objects.equals(listUSer, listUser.listUSer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listUSer);
    }
}

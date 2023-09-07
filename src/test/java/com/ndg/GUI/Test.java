package com.ndg.GUI;

import com.ndg.ConnectionMySQL.ConnectionSQL;

import java.util.Vector;

public class Test {
    public static void main(String[] args) {
        ConnectionSQL.getConnection();
        System.out.println(ConnectionSQL.getYearNH(99999999).size());
    }
}

package com.ndg.GUI;

import com.ndg.ConnectionMySQL.ConnectionSQL;


public class App {
    public static void main( String[] args ) {
        new Application().setVisible(true);
        ConnectionSQL.getConnection();
    }
}

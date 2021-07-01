package de.schleimer.skyblockre.api;

import org.bukkit.Bukkit;
import org.sqlite.JDBC;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQL extends JDBC {
    private final String username;
    private final String password;
    private final String hostname;
    private final String database;
    private final int port;
    private Connection con;

    public MySQL(String host, int port,String database , String username , String password){
        this.database = database;
        this.hostname = host;
        this.password = password;
        this.username = username;
        this.port = port;
        connect();
    }

    public void connect(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://"+hostname + ":"+port+":"+database+"?autoreconnect=true",username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            Bukkit.getConsoleSender().sendMessage("MySQL Disconnected ");
        }
    }

    public void disconnect(){
        try {
            this.con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean hasConnection(){
        return this.con != null;
    }

    public Connection getConnection(){
        return this.con;
    }

    public Connection getCon() {
        return con;
    }
}

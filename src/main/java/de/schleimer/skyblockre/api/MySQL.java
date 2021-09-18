package de.schleimer.skyblockre.api;

import de.schleimer.skyblockre.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class MySQL {

    private String host;
    private String port;
    private String database;
    private String user;
    private String password;
    private static MySQL sql = new MySQL();
    private Connection connection;
    public static MySQL getMySQL () {return sql;}

    private MySQL() {
        FileConfiguration fileConfiguration = Main.getPlugin().getConfig();
        host = fileConfiguration.getString("MySQL.host");
        port = fileConfiguration.getString("MySQL.port");
        database = fileConfiguration.getString("MySQL.database");
        user= fileConfiguration.getString("MySQL.user");
        password = fileConfiguration.getString("MySQL.password");
    }

    public boolean isConnected(){
        return  (connection != null);
    }
    public void connect() {
        if (!isConnected()
                && host != null
                && port != null
                && database != null
                && user != null
                && password != null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?useJDBCCompliantTimezoneShift=true&&serverTimezone=UTC&&useUnicode=true&autoReconnect=true&&useSSL=false", user, password);
                Bukkit.getConsoleSender().sendMessage("(DEBUG) Datenbank verbunden");
            }catch (SQLException e){
                e.printStackTrace();
            }

        }
    }

    public void disconnect() {
        if(isConnected()) {
            try {
                connection.close();
                Bukkit.getConsoleSender().sendMessage("(DEBUG) Datenbank getrennt");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        connection = null;
    }
}

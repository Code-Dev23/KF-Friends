package it.codedev.juicefriends.database;

import it.codedev.juicefriends.JuiceFriends;

public class Database {
    private JuiceFriends main;

    public Database(JuiceFriends main, String type) {
        switch(type) {
            case "mysql":
                new MySQL(main, "localhost", 3306, "juicefriends", "", "");
                break;
            default:
                new SQLite(main);
                break;
        }
    }

    // working in progress...
}

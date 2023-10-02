package org.persistencia.models;

public class Entry {
    private int id;
    private String username;
    private String password;
    private String website;
    private String notes;

    public Entry() {}
    public Entry(int id, String username, String password, String website, String notes) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.website = website;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

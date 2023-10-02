package org.persistencia.models;

import java.util.ArrayList;
import java.util.List;

public class Vault {
    private int id;
    private String name;
    private List<Entry> entries;
    private String owner;
    private String description;

    public Vault() {}
    public Vault(int id, String name, String owner, String description) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.description = description;
        this.entries = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void addEntry(Entry entry) {
        entries.add(entry);
    }

    public void removeEntry(Entry entry) {
        entries.remove(entry);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

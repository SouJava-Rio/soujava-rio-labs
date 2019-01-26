package br.org.soujava.rio.helidon.model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private String speaker;

    public Event() { }

    public Event(String name, String description, String speaker) {
        super();
        this.name = name;
        this.description = description;
        this.speaker = speaker;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    @Override
    public String toString() {
        return "name:" + name + ", description:" + description + ", speaker:" + speaker;
    }
    
    public JsonObject forRest() {

        var builder = Json.createObjectBuilder();
        return builder.add("id", id)
                      .add("name", name)
                      .add("description", description)
                      .add("speaker", speaker)
                      .build();
    }
}

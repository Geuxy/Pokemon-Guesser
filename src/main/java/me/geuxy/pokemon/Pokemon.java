package me.geuxy.pokemon;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javafx.scene.image.Image;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

@Getter
public class Pokemon {

    /*
     * Pokemon Information
     */
    private final String name;
    private final String imageUrl;

    private final int number;

    private final List<String> types;

    private Image sprite;

    /**
     * Setup information from JSON.
     *
     * @param json the JSON object of the pokemon.
     */
    public Pokemon(JsonElement json) {
        JsonObject object = json.getAsJsonObject();

        JsonObject name = object.get("name").getAsJsonObject();
        JsonObject image = object.get("image").getAsJsonObject();

        this.name = name.get("english").getAsString();
        this.number = object.get("id").getAsInt();
        this.imageUrl = image.get("sprite").getAsString();
        this.types = new LinkedList<>();

        JsonArray array = object.get("type").getAsJsonArray();

        for(JsonElement type : array) {
            types.add(type.getAsString().toLowerCase());
        }
    }

    /*
     * Sets the pokemons sprite / image.
     */
    public void setSprite() {
        this.sprite = new Image(imageUrl, 256, 256, true, false);
    }

    /**
     * Checks if this pokemon is the given type.
     *
     * @param type Given type.
     *
     * @return pokemons types contains the given type.
     */
    public boolean isType(String type) {
        return types.contains(type);
    }

}

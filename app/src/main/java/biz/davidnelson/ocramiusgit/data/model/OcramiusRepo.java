package biz.davidnelson.ocramiusgit.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OcramiusRepo {

    private String name;
    private String id;
    private String language;

    @SerializedName("clone_url")
    private String cloneUrl;
    @SerializedName("updated_at")
    private String updatedAt;

    private Owner owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCloneUrl() {
        return cloneUrl;
    }

    public String getLanguage() {
        return language;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getOwnerAvatarUrl() {
        return owner.avatarUrl;
    }

    public String getOwnerLogin() {
        return owner.login;
    }

    class Owner {
        private String login;

        @SerializedName("avatar_url")
        private String avatarUrl;
    }
}

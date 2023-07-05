package com.example.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;

@Component
public class GsonComponent{
    public final Gson gson;

    public GsonComponent(){
        this.gson = new Gson();
    }

    public Gson getGson(){
        return this.gson;
    }

// Gson (검색)

}


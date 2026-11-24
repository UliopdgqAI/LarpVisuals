package com.larp.visuals.gui.animation;

public enum AnimationType {
    SCALE(0, "Scale"),
    FADE(1, "Fade"),
    SLIDE(2, "Slide");
    
    private final int id;
    private final String name;
    
    AnimationType(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public static AnimationType getById(int id) {
        for (AnimationType type : values()) {
            if (type.id == id) return type;
        }
        return SCALE;
    }
}
package me.amiralles;

import com.fasterxml.jackson.annotation.JsonCreator;

public record SkillReview(String skill, String role) {

    @JsonCreator
    public SkillReview {
    }

}

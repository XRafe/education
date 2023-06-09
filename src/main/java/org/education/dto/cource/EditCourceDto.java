package org.education.dto.cource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class EditCourceDto {

    private final String title;

    private final String info;

    private final String imageUrl;

    private final String direction;


    public EditCourceDto(@JsonProperty("title") String title,
                         @JsonProperty("info") String info,
                         @JsonProperty("imageUrl") String imageUrl,
                         @JsonProperty("direction") String direction) {
        this.title = title;
        this.info = info;
        this.imageUrl = imageUrl;
        this.direction = direction;
    }
}

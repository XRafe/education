package org.education.dto.module;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class EditModuleDto {

    private final String title;
    private final String info;

    public EditModuleDto(@JsonProperty("title") String title,
                         @JsonProperty("info") String info) {
        this.title = title;
        this.info = info;
    }
}

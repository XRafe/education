package org.education.dto.report;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateReportDto {

    private String text;

    private Integer rating;

    public CreateReportDto(@JsonProperty("text") String text,
                           @JsonProperty("rating") Integer rating) {
        this.text = text;
        this.rating = rating;
    }
}

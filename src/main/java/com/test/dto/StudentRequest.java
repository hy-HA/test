package com.test.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "학생정보")
public class StudentRequest {

    @Schema(description  = "이름")
    private String name;

    @Schema(description = "점수")
    private Integer score;
}

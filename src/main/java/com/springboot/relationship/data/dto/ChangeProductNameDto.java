package com.springboot.relationship.data.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangeProductNameDto {
    private Long number;
    private String name;
}

package com.github.blackchronos.foodspect_back.core.supplement.model;

import com.github.blackchronos.foodspect_back.core.utils.IdService;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("supplements")
public class Supplement {
    @Id
    @Builder.Default
    public String id = IdService.getRandomIdString();

    public String code;
    public String name;
    public String description;

    public int rating;
}

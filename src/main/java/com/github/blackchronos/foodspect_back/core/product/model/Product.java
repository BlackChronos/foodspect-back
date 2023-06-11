package com.github.blackchronos.foodspect_back.core.product.model;

import com.github.blackchronos.foodspect_back.core.supplement.model.Supplement;
import com.github.blackchronos.foodspect_back.core.utils.IdService;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("products")
public class Product {
    @Id
    @Builder.Default
    public String id = IdService.getRandomIdString();

    public String name;
    public String description;

    public String producer;

    @Builder.Default
    public Nutrition nutrition = null;
    public Supplement[] supplements;
    public Category[] category;

    public String photoLink;

}

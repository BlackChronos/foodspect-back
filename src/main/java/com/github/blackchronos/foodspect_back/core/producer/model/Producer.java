package com.github.blackchronos.foodspect_back.core.producer.model;


import com.github.blackchronos.foodspect_back.core.utils.IdService;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("producers")
public class Producer {
    @Id
    @Builder.Default
    public String id = IdService.getRandomIdString();

    public String name;
    public String description;
    public String phone;
    public String address;
    public String logoLink;

//    @ReadOnlyProperty
//    @DocumentReference(lazy = true, lookup = "{'producer':?#{#self._id}}")
//    public List<Product> products;
}

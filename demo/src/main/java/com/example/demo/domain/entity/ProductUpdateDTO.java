package com.example.demo.domain.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openapitools.jackson.nullable.JsonNullable;

@SuppressWarnings("FieldMayBeFinal")
public class ProductUpdateDTO {
    @NotNull
    private JsonNullable<String> name = JsonNullable.undefined();

    @NotNull
    private JsonNullable<Integer> price = JsonNullable.undefined();

    public JsonNullable<String> getName() {
        return name;
    }

    public JsonNullable<Integer> getPrice() {
        return price;
    }

    public ProductUpdateDTO(){
    }
}

package com.mimaraslan.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 
@ToString
@EqualsAndHashCode
@Builder
public class LombokModel
{
    private @NonNull String name;
    private @NonNull String age;
    private @NonNull String address;
 
    public static void main(String[] args)
    {
        LombokModel lombokModel = new LombokModelBuilder()
                                    .name("Sajal")
                                    .address("India")
                                    .age("100")
                                    .build();
     
        System.out.println(lombokModel);   
    }
}  
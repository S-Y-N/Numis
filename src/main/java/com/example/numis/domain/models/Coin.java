package com.example.numis.domain.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.awt.*;
import java.io.Serializable;

@Entity
@Getter
@Table(name = "coins",indexes = {
        @Index(columnList = "name",unique = true),
        @Index(columnList = "year"),
        @Index(columnList = "price"),
        @Index(columnList = "grade"),
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coin implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @NotEmpty
    @Setter
    @Column(name ="name",length = 64,nullable = false)
    private String name;

    @NotNull
    @NotEmpty
    @Setter
    @Column(name = "year",length = 12,nullable = false)
    private String year;

    /*Тираж монет*/
    @Setter
    @Column(name = "circulation",length = 32,nullable = true)
    private String  circulation;

    @NotNull
    @NotEmpty
    @Setter
    @Column(name = "material",length = 32,nullable = false)
    private String material;

    @NotNull
    @NotEmpty
    @Setter
    @Column(name = "weight",length = 16,nullable = false)
    private String weight;

    @NotNull
    @NotEmpty
    @Setter
    @Column(name = "diameter",length = 16,nullable = false)
    private String diameter;

    @NotNull
    @NotEmpty
    @Setter
    @Column(name = "gurt",length = 32,nullable = false)
    private String gurt;

    @NotNull
    @NotEmpty
    @Setter
    @Column(name = "price",length = 16,nullable = false)
    private String price;

    @NotNull
    @NotEmpty
    @Setter
    @Column(name = "grade",length = 16,nullable = false)
    private String grade;

    @NotNull
    @NotEmpty
    @Setter
    @Column(name = "diff",length = 512,nullable = false)
    private String diff;

    @Setter
    @Column(name = "qnt",length = 16,nullable = true)
    private int qnt;


    @Lob
    @Column(name = "imageData",length = 1024)
    private byte [] picture;

}

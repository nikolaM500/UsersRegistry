package com.nikola.nikola.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class BusinessNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String source_name;
    @Column
    private String author;
    @Column
    private String title;
    @Column
    private String url;
    @Column
    private String url_img;
    @Column
    private String time_published;
    @Column
    private String content;
}

package com.example.inflearnjpa1.entity.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Album extends Item {

    private String artist;
}
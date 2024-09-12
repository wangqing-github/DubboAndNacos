package com.wq.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Account {
    private int id;
    private String name;

    public Account(String name) {
        this.name = name;
    }
}

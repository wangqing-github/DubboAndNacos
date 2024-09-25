package com.wq.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class SimpleMsg implements Serializable {
    private String msg;
}

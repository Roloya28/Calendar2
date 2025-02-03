package com.example.calendar2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalendarModel {

    private Long id;
    private String author;
    private String todolist;
    private String password;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}

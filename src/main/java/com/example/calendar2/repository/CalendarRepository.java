package com.example.calendar2.repository;

import com.example.calendar2.entity.CalendarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CalendarRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createCalendar(CalendarModel calendarModel) {
        String sql = "insert into calendar (author, todolist, password, createDate, updateDate) values(?,?,?,?,?)";
        return jdbcTemplate.update(sql, calendarModel.getAuthor(), calendarModel.getTodolist(), calendarModel.getPassword(), calendarModel.getCreateDate(), calendarModel.getUpdateDate());
    }

    public List<CalendarModel> getAllCalendars(String author, String updateDate) {
        StringBuilder sql = new StringBuilder("select * from calendar where 1=1");
        List<Object> params = new ArrayList<>();

        if (author != null && !author.isEmpty()) {
            sql.append(" and author = ?");
            params.add(author);
        }

        if (updateDate != null && !updateDate.isEmpty()) {
            sql.append(" and date(updateDate) = ?");
            params.add(Date.valueOf(updateDate));
        }

        sql.append(" order by updateDate desc");

        return jdbcTemplate.query(sql.toString(), params.toArray(), new BeanPropertyRowMapper<>(CalendarModel.class));
    }

    public CalendarModel getCalendarById(Long id) {
        String sql = "select * from calendar where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(CalendarModel.class), id);
    }

    public void updateCalendar(CalendarModel calendarModel) {
        String sql = "update calendar set todolist = ?, author = ?, updateDate = ?, where id = ?";
        jdbcTemplate.update(sql, calendarModel.getTodolist(), calendarModel.getAuthor(), calendarModel.getUpdateDate(), calendarModel.getId());
    }

    public void deleteCalendar(Long id) {
        String sql = "delete from calendar where id = ?";
        jdbcTemplate.update(sql, id);
    }
}

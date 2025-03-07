package com.example.calendar2.controller;

import com.example.calendar2.dto.CalendarDto;
import com.example.calendar2.entity.CalendarModel;
import com.example.calendar2.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    // Create API
    @PostMapping("/calendars")
    public void createCalendar(@RequestBody CalendarModel calendarModel) {
        calendarService.createCalendar(calendarModel);
    }

    // Read All API
    @GetMapping("/lists")
    public List<CalendarModel> getAllCalendars(@RequestParam(required = false) String author,
                                               @RequestParam(required = false) String updateDate) {
        return calendarService.getAllCalendars(author, updateDate);
    }

    // Read One API
    @GetMapping("/lists/{id}")
    public CalendarModel getCalendarById(@PathVariable Long id) {
        return calendarService.getCalendarById(id);
    }

    // Update API
    @PutMapping("/{id}")
    public String updateCalendar(@PathVariable Long id, @RequestBody CalendarDto calendarDto) {
        try {
            calendarService.updateCalendar(id, calendarDto);
            return "수정완료";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    // Delete API
    @DeleteMapping("/{id}")
    public String deleteCalendar(@PathVariable Long id, @RequestParam String password) {
        try {
            calendarService.deleteCalendar(id, password);
            return "삭제 완료";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}

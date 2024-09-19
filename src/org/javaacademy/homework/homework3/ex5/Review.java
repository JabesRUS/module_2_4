package org.javaacademy.homework.homework3.ex5;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Review {
//    id отзыва, текст отзыва, количество лайков
    private Integer id;
    private String text;
    private Integer countLikes;
    private LocalDateTime dateTime;

    public Review(Integer id, String text, Integer countLikes, LocalDateTime dateTime) {
        this.id = id;
        this.text = text;
        this.countLikes = countLikes;
        this.dateTime = dateTime;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Integer getCountLikes() {
        return countLikes;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", countLikes=" + countLikes +
                ", dateTime=" + dateTime +
                "}\n";
    }
}

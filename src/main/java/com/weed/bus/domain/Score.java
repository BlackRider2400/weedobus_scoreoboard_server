package com.weed.bus.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "score")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Score {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nickname")
    @NotNull
    private String nickname;

    @Column(name = "score")
    @NotNull
    private int score;

    @Column(name = "date")
    @NotNull
    private LocalDateTime date;
}

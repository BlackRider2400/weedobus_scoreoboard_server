package com.weed.bus.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Setter
public class ScoreDto {
    private Long id;
    private String nickname;
    private int score;
    private LocalDateTime date;

}

package com.weed.bus.mapper;

import com.weed.bus.domain.Score;
import com.weed.bus.domain.ScoreDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreMapper {
    public Score mapToScore(ScoreDto scoreDto){
        return new Score(
                scoreDto.getId(),
                scoreDto.getNickname(),
                scoreDto.getScore(),
                scoreDto.getDate()
        );
    }

    public ScoreDto mapToScoreDto(Score score){
        return new ScoreDto(
                score.getId(),
                score.getNickname(),
                score.getScore(),
                score.getDate()
        );
    }

    public List<ScoreDto> mapToScoreDtoList(final List<Score> scoreList){
        return scoreList.stream()
                .map(this::mapToScoreDto)
                .collect(Collectors.toList());
    }
}

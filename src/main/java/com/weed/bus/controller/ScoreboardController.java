package com.weed.bus.controller;

import com.weed.bus.domain.Score;
import com.weed.bus.domain.ScoreDto;
import com.weed.bus.mapper.ScoreMapper;
import com.weed.bus.repository.ScoreRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static java.util.Collections.max;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class ScoreboardController {

    private final ScoreRepository repository;
    private final ScoreMapper mapper;

    public ScoreboardController(ScoreRepository repository, ScoreMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping(value = "")
    public List<ScoreDto> getScoreBoard(){
        List<Score> scoreList = repository.findAll();
        List<Integer> scoreNum = new ArrayList<>();
        List<Score> top10list = new ArrayList<>();
        for(Score score:scoreList){
            scoreNum.add(score.getScore());
        }
        if(scoreList.size() > 10){
            for (int i = 0; i < 10; i++){
                int max = Collections.max(scoreNum);
                int index = scoreNum.indexOf(max);
                top10list.add(scoreList.get(index));
                scoreNum.remove(index);
                scoreList.remove(index);
            }
        }else{
            int size = scoreList.size();
            for (int i = 0; i < size; i++){
                int max = Collections.max(scoreNum);
                int index = scoreNum.indexOf(max);
                top10list.add(scoreList.get(index));
                scoreNum.remove(index);
                scoreList.remove(index);
            }
        }

        return mapper.mapToScoreDtoList(top10list);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createScore(@RequestBody ScoreDto scoreDto){
        scoreDto.setDate(LocalDateTime.now());
        Score score = mapper.mapToScore(scoreDto);
        repository.save(score);
    }
}

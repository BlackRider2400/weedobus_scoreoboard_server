package com.weed.bus.repository;

import com.weed.bus.domain.Score;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ScoreRepository extends CrudRepository<Score, Long> {
    List<Score> findAll();
}

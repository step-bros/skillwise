package com.stepbros.skillwise.reward;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseBody
@CrossOrigin
public class RewardController {
    private final RewardRepository rewardRepository;
    RewardController(RewardRepository rewardRepository){
        this.rewardRepository = rewardRepository;
    }

    @GetMapping(path = "rewards")
    List<RewardEntity> getAllRewards(){
        return rewardRepository.findAll();
    }
}

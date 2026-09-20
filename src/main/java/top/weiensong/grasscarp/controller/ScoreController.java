package top.weiensong.grasscarp.controller;

import org.springframework.web.bind.annotation.*;
import top.weiensong.grasscarp.model.Score;
import top.weiensong.grasscarp.service.ScoreService;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping("/{schoolId}")
    public List<Score> getBySchoolId(@PathVariable String schoolId) {
        return scoreService.getBySchoolId(schoolId);
    }
}
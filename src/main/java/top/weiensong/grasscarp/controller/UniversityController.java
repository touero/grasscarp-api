package top.weiensong.grasscarp.controller;

import org.springframework.web.bind.annotation.*;
import top.weiensong.grasscarp.model.University;
import top.weiensong.grasscarp.model.UniversitySearchResult;
import top.weiensong.grasscarp.service.UniversityService;

import java.util.Collection;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/{schoolId}")
    public University get(@PathVariable String schoolId) {
        return universityService.get(schoolId);
    }

    @GetMapping("/search")
    public Collection<UniversitySearchResult> search(@RequestParam String keyword) {
        return universityService.search(keyword);
    }
}
package top.weiensong.grasscarp.controller;

import org.springframework.web.bind.annotation.*;
import top.weiensong.grasscarp.model.Major;
import top.weiensong.grasscarp.service.MajorService;

import java.util.List;

@RestController
@RequestMapping("/api/majors")
public class MajorController {

    private final MajorService majorService;

    public MajorController(MajorService majorService) {
        this.majorService = majorService;
    }

    @GetMapping("/{schoolId}")
    public List<Major> getBySchoolId(@PathVariable String schoolId) {
        return majorService.getBySchoolId(schoolId);
    }
}
package top.weiensong.grasscarp.service;
import top.weiensong.grasscarp.mapper.UniversityMapper;
import top.weiensong.grasscarp.model.University;
import top.weiensong.grasscarp.model.UniversitySearchResult;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.stream.Collectors;

import java.util.List;

@Service
public class UniversityService {

    private final UniversityMapper universityMapper;

    public UniversityService(UniversityMapper universityMapper) {
        this.universityMapper = universityMapper;
    }

    public University get(String schoolId) {
        return universityMapper.selectById(schoolId);
    }

    public List<UniversitySearchResult> search(String keyword) {
        QueryWrapper<University> wrapper = new QueryWrapper<>();
        wrapper.select("school_id", "name");
        wrapper.like("name", keyword);

        return universityMapper.selectList(wrapper).stream()
                .map(university -> {
                    UniversitySearchResult result = new UniversitySearchResult();
                    result.setSchoolId(university.getSchoolId());
                    result.setName(university.getName());
                    return result;
                })
                .collect(Collectors.toList());
    }
}
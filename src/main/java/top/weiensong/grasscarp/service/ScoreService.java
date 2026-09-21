package top.weiensong.grasscarp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import top.weiensong.grasscarp.mapper.ScoreMapper;
import top.weiensong.grasscarp.model.Score;
import top.weiensong.grasscarp.utils.ProvinceMapper;

import java.util.List;

@Service
public class ScoreService {

    private final ScoreMapper scoreMapper;

    public ScoreService(ScoreMapper scoreMapper) {
        this.scoreMapper = scoreMapper;
    }

    public List<Score> getBySchoolId(String schoolId) {
        QueryWrapper<Score> wrapper = new QueryWrapper<>();
        wrapper.eq("school_id", schoolId);

        List<Score> scores = scoreMapper.selectList(wrapper);

        for (Score score : scores) {
            score.setProvinceName(
                    ProvinceMapper.getName(score.getProvinceId())
            );
        }

        return scores;
    }
}
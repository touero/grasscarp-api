package top.weiensong.grasscarp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import top.weiensong.grasscarp.mapper.MajorMapper;
import top.weiensong.grasscarp.model.Major;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MajorService {

    private final MajorMapper majorMapper;

    public MajorService(MajorMapper majorMapper) {
        this.majorMapper = majorMapper;
    }

    public List<Major> getBySchoolId(String schoolId) {
        QueryWrapper<Major> wrapper = new QueryWrapper<>();
        wrapper.eq("school_id", schoolId);

        return majorMapper.selectList(wrapper).stream()
                .map(major -> {
                    Major result = new Major();
                    result.setSpecialName(major.getSpecialName());
                    result.setTypeName(major.getTypeName());
                    result.setLevel3Name(major.getLevel3Name());
                    result.setLevel2Name(major.getLevel2Name());
                    result.setLimitYear(major.getLimitYear());
                    return result;
                })
                .collect(Collectors.toList());
    }
}
package com.mtgz.sc.manager.web.service;

import com.mtgz.sc.manager.common.constants.Constant;
import com.mtgz.sc.manager.common.entity.SysDeptEntity;
import com.mtgz.sc.manager.common.entity.UserWindowDto;
import com.mtgz.sc.manager.common.page.Page;
import com.mtgz.sc.manager.common.page.PageHelper;
import com.mtgz.sc.manager.dao.mapper.SysDeptMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("sysDeptService")
public class SysDeptService {
    @Autowired
    private SysDeptMapper sysDeptMapper;

    
    public SysDeptEntity queryObject(Long deptId) {
        return sysDeptMapper.queryObject(deptId);
    }

    
    public List<SysDeptEntity> queryList(Map<String, Object> map) {
        return sysDeptMapper.queryList(map);
    }

    
    public void save(SysDeptEntity sysDept) {
        sysDeptMapper.save(sysDept);
    }

    
    public void update(SysDeptEntity sysDept) {
        sysDeptMapper.update(sysDept);
    }

    
    public void delete(Long deptId) {
        sysDeptMapper.delete(deptId);
    }

    
    public List<Long> queryDetpIdList(Long parentId) {
        return sysDeptMapper.queryDetpIdList(parentId);
    }

    
    public String getSubDeptIdList(Long deptId) {
        //部门及子部门ID列表
        List<Long> deptIdList = new ArrayList<>();

        //获取子部门ID
        List<Long> subIdList = queryDetpIdList(deptId);
        getDeptTreeList(subIdList, deptIdList);

        //添加本部门
        deptIdList.add(deptId);

        String deptFilter = StringUtils.join(deptIdList, ",");
        return deptFilter;
    }

    /**
     * 递归
     */
    public void getDeptTreeList(List<Long> subIdList, List<Long> deptIdList) {
        for (Long deptId : subIdList) {
            List<Long> list = queryDetpIdList(deptId);
            if (list.size() > 0) {
                getDeptTreeList(list, deptIdList);
            }

            deptIdList.add(deptId);
        }
    }

    
    public Page<UserWindowDto> queryPageByDto(UserWindowDto userWindowDto, int pageNum) {
        PageHelper.startPage(pageNum, Constant.pageSize);
        sysDeptMapper.queryPageByDto(userWindowDto);
        return PageHelper.endPage();
    }
}

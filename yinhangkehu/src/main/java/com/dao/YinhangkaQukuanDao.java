package com.dao;

import com.entity.YinhangkaQukuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YinhangkaQukuanView;

/**
 * 取款 Dao 接口
 *
 * @author 
 */
public interface YinhangkaQukuanDao extends BaseMapper<YinhangkaQukuanEntity> {

   List<YinhangkaQukuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

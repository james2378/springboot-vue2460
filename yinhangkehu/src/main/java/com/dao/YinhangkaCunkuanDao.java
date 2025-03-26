package com.dao;

import com.entity.YinhangkaCunkuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YinhangkaCunkuanView;

/**
 * 存款 Dao 接口
 *
 * @author 
 */
public interface YinhangkaCunkuanDao extends BaseMapper<YinhangkaCunkuanEntity> {

   List<YinhangkaCunkuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

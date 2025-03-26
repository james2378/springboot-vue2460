package com.dao;

import com.entity.YinhangkaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YinhangkaView;

/**
 * 银行卡 Dao 接口
 *
 * @author 
 */
public interface YinhangkaDao extends BaseMapper<YinhangkaEntity> {

   List<YinhangkaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

package com.dao;

import com.entity.YinhangkaZhuanzhangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YinhangkaZhuanzhangView;

/**
 * 转账 Dao 接口
 *
 * @author 
 */
public interface YinhangkaZhuanzhangDao extends BaseMapper<YinhangkaZhuanzhangEntity> {

   List<YinhangkaZhuanzhangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

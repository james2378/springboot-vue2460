package com.dao;

import com.entity.JinronggongjuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JinronggongjuView;

/**
 * 金融工具 Dao 接口
 *
 * @author 
 */
public interface JinronggongjuDao extends BaseMapper<JinronggongjuEntity> {

   List<JinronggongjuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

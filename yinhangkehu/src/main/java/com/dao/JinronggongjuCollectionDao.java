package com.dao;

import com.entity.JinronggongjuCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JinronggongjuCollectionView;

/**
 * 金融工具收藏 Dao 接口
 *
 * @author 
 */
public interface JinronggongjuCollectionDao extends BaseMapper<JinronggongjuCollectionEntity> {

   List<JinronggongjuCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

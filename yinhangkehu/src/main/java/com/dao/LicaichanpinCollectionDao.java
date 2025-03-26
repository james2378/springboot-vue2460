package com.dao;

import com.entity.LicaichanpinCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LicaichanpinCollectionView;

/**
 * 理财产品收藏 Dao 接口
 *
 * @author 
 */
public interface LicaichanpinCollectionDao extends BaseMapper<LicaichanpinCollectionEntity> {

   List<LicaichanpinCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

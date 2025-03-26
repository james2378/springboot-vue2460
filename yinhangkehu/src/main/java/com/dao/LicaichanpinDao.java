package com.dao;

import com.entity.LicaichanpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LicaichanpinView;

/**
 * 理财产品 Dao 接口
 *
 * @author 
 */
public interface LicaichanpinDao extends BaseMapper<LicaichanpinEntity> {

   List<LicaichanpinView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

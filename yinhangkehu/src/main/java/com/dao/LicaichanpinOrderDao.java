package com.dao;

import com.entity.LicaichanpinOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LicaichanpinOrderView;

/**
 * 理财产品订单 Dao 接口
 *
 * @author 
 */
public interface LicaichanpinOrderDao extends BaseMapper<LicaichanpinOrderEntity> {

   List<LicaichanpinOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

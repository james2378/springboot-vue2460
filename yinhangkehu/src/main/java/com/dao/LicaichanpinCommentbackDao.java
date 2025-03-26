package com.dao;

import com.entity.LicaichanpinCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LicaichanpinCommentbackView;

/**
 * 理财产品评价 Dao 接口
 *
 * @author 
 */
public interface LicaichanpinCommentbackDao extends BaseMapper<LicaichanpinCommentbackEntity> {

   List<LicaichanpinCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

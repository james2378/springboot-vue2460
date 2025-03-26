package com.dao;

import com.entity.JinronggongjuCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JinronggongjuCommentbackView;

/**
 * 金融工具评价 Dao 接口
 *
 * @author 
 */
public interface JinronggongjuCommentbackDao extends BaseMapper<JinronggongjuCommentbackEntity> {

   List<JinronggongjuCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

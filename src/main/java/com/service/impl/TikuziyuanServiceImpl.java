package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.TikuziyuanDao;
import com.entity.TikuziyuanEntity;
import com.service.TikuziyuanService;
import com.entity.vo.TikuziyuanVO;
import com.entity.view.TikuziyuanView;

@Service("tikuziyuanService")
public class TikuziyuanServiceImpl extends ServiceImpl<TikuziyuanDao, TikuziyuanEntity> implements TikuziyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TikuziyuanEntity> page = this.selectPage(
                new Query<TikuziyuanEntity>(params).getPage(),
                new EntityWrapper<TikuziyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TikuziyuanEntity> wrapper) {
		  Page<TikuziyuanView> page =new Query<TikuziyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TikuziyuanVO> selectListVO(Wrapper<TikuziyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TikuziyuanVO selectVO(Wrapper<TikuziyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TikuziyuanView> selectListView(Wrapper<TikuziyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TikuziyuanView selectView(Wrapper<TikuziyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

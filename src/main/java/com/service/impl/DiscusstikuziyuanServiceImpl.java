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


import com.dao.DiscusstikuziyuanDao;
import com.entity.DiscusstikuziyuanEntity;
import com.service.DiscusstikuziyuanService;
import com.entity.vo.DiscusstikuziyuanVO;
import com.entity.view.DiscusstikuziyuanView;

@Service("discusstikuziyuanService")
public class DiscusstikuziyuanServiceImpl extends ServiceImpl<DiscusstikuziyuanDao, DiscusstikuziyuanEntity> implements DiscusstikuziyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusstikuziyuanEntity> page = this.selectPage(
                new Query<DiscusstikuziyuanEntity>(params).getPage(),
                new EntityWrapper<DiscusstikuziyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusstikuziyuanEntity> wrapper) {
		  Page<DiscusstikuziyuanView> page =new Query<DiscusstikuziyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusstikuziyuanVO> selectListVO(Wrapper<DiscusstikuziyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusstikuziyuanVO selectVO(Wrapper<DiscusstikuziyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusstikuziyuanView> selectListView(Wrapper<DiscusstikuziyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusstikuziyuanView selectView(Wrapper<DiscusstikuziyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

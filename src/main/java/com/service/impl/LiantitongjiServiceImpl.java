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


import com.dao.LiantitongjiDao;
import com.entity.LiantitongjiEntity;
import com.service.LiantitongjiService;
import com.entity.vo.LiantitongjiVO;
import com.entity.view.LiantitongjiView;

@Service("liantitongjiService")
public class LiantitongjiServiceImpl extends ServiceImpl<LiantitongjiDao, LiantitongjiEntity> implements LiantitongjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LiantitongjiEntity> page = this.selectPage(
                new Query<LiantitongjiEntity>(params).getPage(),
                new EntityWrapper<LiantitongjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LiantitongjiEntity> wrapper) {
		  Page<LiantitongjiView> page =new Query<LiantitongjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LiantitongjiVO> selectListVO(Wrapper<LiantitongjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LiantitongjiVO selectVO(Wrapper<LiantitongjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LiantitongjiView> selectListView(Wrapper<LiantitongjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LiantitongjiView selectView(Wrapper<LiantitongjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

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


import com.dao.DefentongjiDao;
import com.entity.DefentongjiEntity;
import com.service.DefentongjiService;
import com.entity.vo.DefentongjiVO;
import com.entity.view.DefentongjiView;

@Service("defentongjiService")
public class DefentongjiServiceImpl extends ServiceImpl<DefentongjiDao, DefentongjiEntity> implements DefentongjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DefentongjiEntity> page = this.selectPage(
                new Query<DefentongjiEntity>(params).getPage(),
                new EntityWrapper<DefentongjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DefentongjiEntity> wrapper) {
		  Page<DefentongjiView> page =new Query<DefentongjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DefentongjiVO> selectListVO(Wrapper<DefentongjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DefentongjiVO selectVO(Wrapper<DefentongjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DefentongjiView> selectListView(Wrapper<DefentongjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DefentongjiView selectView(Wrapper<DefentongjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

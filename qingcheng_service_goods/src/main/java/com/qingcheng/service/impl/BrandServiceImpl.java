package com.qingcheng.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qingcheng.dao.BrandMapper;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    /**
     * 查询所有品牌
     * @return
     */
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    /**
     * 分页查询品牌
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageResult<Brand> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        Page<Brand> brandPage = (Page<Brand>) brandMapper.selectAll();
        return new PageResult<>(brandPage.getTotal(), brandPage.getResult());
    }

    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    @Override
    public List<Brand> findList(Map<String, Object> searchMap) {
        return brandMapper.selectByExample(createExample(searchMap));
    }

    /**
     * 条件 + 分页 查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageResult<Brand> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page, size);
        Page<Brand> brandPage = (Page<Brand>) findList(searchMap);
        return new PageResult<>(brandPage.getTotal(), brandPage.getResult());
    }

    /**
     * 根据品牌id查询
     * @param id
     * @return
     */
    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    /**
     * 新增品牌
     * @param brand
     */
    @Override
    public void add(Brand brand) {
        brandMapper.insert(brand);
    }

    /**
     * 修改品牌
     * @param brand
     */
    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    /**
     * 删除品牌
     * @param id
     */
    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 组装条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (CollectionUtils.isEmpty(searchMap)) {
            //名称条件
            if(!StringUtils.isEmpty(searchMap.get("name"))){
                criteria.andLike("name","%"+
                        (String)searchMap.get("name")+"%");
            }
            //首字母
            if(!StringUtils.isEmpty(searchMap.get("letter"))){
                criteria.andEqualTo("letter",
                        (String)searchMap.get("letter"));
            }
        }
        return example;
    }

}

package com.qingcheng.service.goods;

import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Brand;
import java.util.List;
import java.util.Map;

public interface BrandService {

    /**
     * 查询所有品牌
     * @return
     */
    List<Brand> findAll();

    /**
     * 分页查询品牌
     * @param page
     * @param size
     * @return
     */
    PageResult<Brand> findPage(int page, int size);

    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    List<Brand> findList(Map<String, Object> searchMap);

    /**
     * 条件 + 分页 查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    PageResult<Brand> findPage(Map<String,Object> searchMap,int page,
                                      int size);

    /**
     * 根据品牌id查询
     * @param id
     * @return
     */
    Brand findById(Integer id);

    /**
     * 添加品牌
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改品牌
     * @param brand
     */
    void update(Brand brand);

    /**
     * 删除品牌
     * @param id
     */
    void delete(Integer id);
}

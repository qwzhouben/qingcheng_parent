package com.qingcheng.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.entity.PageResult;
import com.qingcheng.entity.Result;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @DESC:
 * @author: zhouben
 * @date: 2020/4/26 0026 13:56
 */
@RestController
@RequestMapping("brand")
public class BrandController {

    @Reference
    BrandService brandService;

    /**
     * 查询所有品牌
     * @return
     */
    @GetMapping("/findAll")
    public List<Brand> findAll(){
        return brandService.findAll();
    }

    @GetMapping("/findPage")
    public PageResult<Brand> findPage(int page, int size){
        return brandService.findPage(page, size);
    }

    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    @PostMapping("/findList")
    public List<Brand> findList(@RequestBody Map<String,Object> searchMap){
        return brandService.findList(searchMap);
    }

    /**
     * 条件 + 分页 查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    @PostMapping("/findPage")
    public PageResult<Brand> findPage(@RequestBody Map<String,Object>
                                              searchMap,int page, int size){
        return brandService.findPage(searchMap,page,size);
    }

    /**
     * 根据品牌id查询
     * @param id
     * @return
     */
    @GetMapping("/findById")
    public Brand findById(Integer id){
        return brandService.findById(id);
    }

    /**
     * 新增品牌
     * @param brand
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result();
    }

    /**
     * 修改品牌
     * @param brand
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody Brand brand){
        brandService.update(brand);
        return new Result();
    }

    @GetMapping("/delete")
    public Result delete(Integer id){
        brandService.delete(id);
        return new Result();
    }
}

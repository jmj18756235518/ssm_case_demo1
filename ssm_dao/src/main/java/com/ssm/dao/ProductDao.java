package com.ssm.dao;

import com.ssm.domain.Product;

import java.util.List;

public interface ProductDao {

    /***
     * 查询所有
     * @return
     */
    List<Product> findAll();

    /***
     * 保存商品
     * @param product
     */
    void saveProduct(Product product);

    /**
     * 根据id删除product
     * @param id
     */
    void delProductById(String id);

    /***
     * 进行页面回显功能
     * @param id
     * @return
     */
    Product findProductById(String id);

    /**
     * 根据id对product进行更新
     * @param product
     */
    public void updateProductById(Product product);
}

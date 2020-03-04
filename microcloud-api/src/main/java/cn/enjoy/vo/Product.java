package cn.enjoy.vo;

import java.io.Serializable;

/**
 * @author mla
 * @description
 * @prjectName microcloud
 * @className Product
 * @date 2020/2/28  11:05
 */
public class Product implements Serializable {
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    private Long productId;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    private String productName;
    private String productDesc;


}

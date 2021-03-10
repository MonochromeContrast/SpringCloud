package com.chen.springcloud.page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * @author chen
 * @date 2021/3/8 8:01
 */
@ApiModel(description = "统一分页查询结构")
public class PageBeanSearch<T>{

    @ApiModelProperty("<p>当前页码，必填</p>")
    private int currentPage;

    @ApiModelProperty("<p>每页记录条数</p>")
    private int pageSize;

    @ApiModelProperty("<p>查询载体</p>")
    private T query;

    public PageBeanSearch(){}

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public T getQuery() {
        return query;
    }

    public void setCurrentPage(final int currentPage) {
        this.currentPage = currentPage;
    }

    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }

    public void setQuery(final T query) {
        this.query = query;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        else if(!(o instanceof PageBeanSearch)){
            return false;
        }
        else {
            PageBeanSearch<?> other = (PageBeanSearch)o;
            if(!other.canEqual(this)){
                return false;
            }
            else if(this.getCurrentPage() != other.getCurrentPage()){
                return false;
            }
            else if(this.getPageSize() != other.getPageSize()){
                return false;
            }
            else {
                Object this$query = this.getQuery();
                Object other$query = other.getQuery();
                if(this$query == null){
                    if(other$query == null){
                        return true;
                    }
                }
                else if(this$query.equals(other$query)){
                    return true;
                }
                return false;
            }
        }

    }

    protected boolean canEqual(final Object other){return other instanceof PageBeanSearch;}
    @Override
    public int hashCode() {
        int result = 1;
        result = result * 59 + this.getCurrentPage();
        result = result * 59 + this.getPageSize();
        Object $query = this.getQuery();
        result = result * 59 + ($query == null ? 43:$query.hashCode());
        return result;
    }

    @Override
    public String toString(){
        return "PageBeanSearch(currentPage=" + this.currentPage +",pageSize=" + this.pageSize + ",query=" + this.query + ")";
    }
}

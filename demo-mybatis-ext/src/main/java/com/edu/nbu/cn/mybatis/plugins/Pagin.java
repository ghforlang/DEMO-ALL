package com.edu.nbu.cn.mybatis.plugins;


import java.io.Serializable;
import java.util.*;

public class Pagin<T> implements Serializable {
    /**
     * 单次查询最大的行数
     */
    protected static final int MAX_ROWS_TO_FIND = 10000;
    /**
     * 当前将要查询的页码
     */
    private                int toPage           = 1;
    /**
     * 总行数
     */
    private int totalRows;
    /**
     * 总页数
     */
    private int totalPages;
    /**
     * 初始化的页大小
     */
    private int pageSize = 18;

    /**
     * 分页
     */
    private String pageSizeSelect = "25,50,100";

    public String getPageSizeSelect() {
        return pageSizeSelect;
    }

    public void setPageSizeSelect(String pageSizeSelect) {
        this.pageSizeSelect = pageSizeSelect;
    }

    /**
     * 浏览器回传参数
     */
    private transient Map<String, Object> conditionsMap = new HashMap<String, Object>();

    private transient List<T> resultList;

    public List<T> getResultList() {
        if (resultList == null) {
            resultList = new ArrayList<T>(0);
        }
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public int getToPage() {
        return toPage;
    }

    public void setToPage(int toPage) {
        if (toPage > 0) {
            this.toPage = toPage;
        }
    }

    public long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public long getToRow() {
        if (getFromRow() + pageSize > totalRows) {
            return totalRows;
        } else {
            return getFromRow() + pageSize;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getFromRow() {
        return this.getToPage() * this.getPageSize() - this.getPageSize();
    }

    public int getTotalPages() {
        totalPages = (int) Math.ceil((double) totalRows / pageSize);
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }


    public String getPrePageTitle() {
        if (toPage <= 1) {
            return "";
        }
        return "上一页";
    }

    public long getPrePage() {
        if (toPage <= 1) {
            return 1;
        }
        return toPage - 1;
    }

    public String getNextPageTitle() {
        if (toPage >= totalPages) {
            return "";
        }
        return "下一页";
    }

    public long getNextPage() {
        if (toPage >= totalPages) {
            return totalPages;
        }
        return toPage + 1;
    }

    public String getFirstPageTitle() {
        if (toPage <= 1) {
            return "";
        }
        return "首页";
    }

    public long getFirstPage() {
        return 1;
    }

    public String getLastPageTitle() {
        if (toPage >= totalPages) {
            return "";
        }
        return "末页";
    }

    public long getLastPage() {
        return totalPages;
    }

    public List<Integer> getPageNumbers() {
        //显示前三页+后三页
        int pageShow = 6;
        List<Integer> numbers = new ArrayList<Integer>(pageShow);
        int totalPages = getTotalPages();
        if (totalPages <= 5) {
            for (int i = 1; i <= totalPages; i++) {
                numbers.add(i);
            }
            return numbers;
        }
        for (int i = -(pageShow / 2); i <= (pageShow / 2); i++) {
            numbers.add(toPage + i);
        }
        if (numbers.get(0) < 1) {
            int adjust = 1 - numbers.get(0);
            for (int i = 0; i < adjust; i++) {
                numbers.remove(0);
                numbers.add(numbers.get(numbers.size() - 1) + 1);
            }
        }

        if (numbers.get(numbers.size() - 1) > totalPages) {
            int adjust = numbers.get(numbers.size() - 1) - totalPages;
            for (int i = 0; i < adjust; i++) {
                numbers.remove(numbers.size() - 1);
                if (numbers.get(0) - 1 > 0) {
                    numbers.add(0, numbers.get(0) - 1);
                }
            }
        }

        return numbers;
    }

    public void setConditionsMap(Map<String, Object> conditionsMap) {
        this.conditionsMap = conditionsMap;
    }

    public Map<String, Object> getConditionsMap() {
        return this.conditionsMap;
    }

    public Set<Map.Entry<String, Object>> getConditionEntries() {
        return conditionsMap.entrySet();
    }

    public void addCondition(String key, Object value) {
        this.conditionsMap.put(key, value);
    }

    public Object getCondition(String key) {
        return this.conditionsMap.get(key);
    }

    private Long currentUserId;

    public Long getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(Long id) {
        this.currentUserId = id;
    }
}

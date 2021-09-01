package com.edu.nbu.cn.mybatis.baseclass;

import com.edu.nbu.cn.mybatis.plugins.Pagin;

import java.util.Collection;
import java.util.List;


public interface IBaseManager<Model> {
    /**
     * findByPagin
     *
     * @param pagin
     */
    void findByPagin(Pagin<Model> pagin);

    /**
     * deleteByIds
     *
     * @param record
     * @param ids
     * @return
     */
    Integer deleteByIds(Model record, Long[] ids);

    /**
     * deleteByIds
     *
     * @param record
     * @param ids
     * @return
     */
    Integer deleteByIds(Model record, List<Long> ids);

    /**
     * deleteById
     *
     * @param record
     * @param id
     * @return
     */
    Integer deleteById(Model record, long id);

    /**
     * findById
     *
     * @param id
     * @return
     */
    Model findById(Long id);

    /**
     * save
     *
     * @param model
     */
    void save(Model model);

    /**
     * findByIds
     *
     * @param ids
     * @return
     */
    List<Model> findByIds(Long[] ids);

    /**
     * findByIds
     *
     * @param ids
     * @return
     */
    List<Model> findByIds(List<Long> ids);

    /**
     * batchInsert
     *
     * @param records
     * @return
     */
    int batchInsert(Collection<Model> records);

    /**
     * batchUpdate
     *
     * @param records
     * @return
     */
    int batchUpdate(Collection<Model> records);

    /**
     * batchUpdateSelective
     *
     * @param records
     * @param clazz
     * @return
     */
    int batchUpdateSelective(Collection<Model> records, Class<Model> clazz);
}

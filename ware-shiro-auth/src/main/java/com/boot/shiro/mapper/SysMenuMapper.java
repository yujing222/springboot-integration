package com.boot.shiro.mapper;

import com.boot.shiro.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface SysMenuMapper {
    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     */
    List<SysMenuEntity> queryListParentId(Long parentId);

    /**
     * 查询全部数据
     */
    List<SysMenuEntity> selectList () ;

    /**
     * 获取不包含按钮的菜单列表
     */
    List<SysMenuEntity> queryNotButtonList();
}
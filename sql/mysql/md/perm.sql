-- 菜单 SQL
INSERT INTO system_menu(name, permission, type, sort, parent_id,
                        path, icon, component, status, component_name)
VALUES ('影片管理', '', 2, 0, 2924,
        'movie', '', 'md/movie/index', 0, 'Movie');

-- 按钮父菜单ID
-- 暂时只支持 MySQL。如果你是 Oracle、PostgreSQL、SQLServer 的话，需要手动修改 @parentId 的部分的代码
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
INSERT INTO system_menu(name, permission, type, sort, parent_id,
                        path, icon, component, status)
VALUES ('影片查询', 'md:movie:query', 3, 1, @parentId,
        '', '', '', 0);
INSERT INTO system_menu(name, permission, type, sort, parent_id,
                        path, icon, component, status)
VALUES ('影片创建', 'md:movie:create', 3, 2, @parentId,
        '', '', '', 0);
INSERT INTO system_menu(name, permission, type, sort, parent_id,
                        path, icon, component, status)
VALUES ('影片更新', 'md:movie:update', 3, 3, @parentId,
        '', '', '', 0);
INSERT INTO system_menu(name, permission, type, sort, parent_id,
                        path, icon, component, status)
VALUES ('影片删除', 'md:movie:delete', 3, 4, @parentId,
        '', '', '', 0);
INSERT INTO system_menu(name, permission, type, sort, parent_id,
                        path, icon, component, status)
VALUES ('影片导出', 'md:movie:export', 3, 5, @parentId,
        '', '', '', 0);
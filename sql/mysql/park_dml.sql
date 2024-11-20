-- 菜单 SQL
INSERT INTO system_menu(name, permission, type, sort, parent_id,
                        path, icon, component, status, component_name)
VALUES ('车位租赁信息管理', '', 2, 0, 2814,
        'rent-info', '', 'park/rent/index', 0, 'RentInfo');

-- 按钮父菜单ID
-- 暂时只支持 MySQL。如果你是 Oracle、PostgreSQL、SQLServer 的话，需要手动修改 @parentId 的部分的代码
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
INSERT INTO system_menu(name, permission, type, sort, parent_id,
                        path, icon, component, status)
VALUES ('车位租赁信息查询', 'park:rent-info:query', 3, 1, @parentId,
        '', '', '', 0);
INSERT INTO system_menu(name, permission, type, sort, parent_id,
                        path, icon, component, status)
VALUES ('车位租赁信息创建', 'park:rent-info:create', 3, 2, @parentId,
        '', '', '', 0);
INSERT INTO system_menu(name, permission, type, sort, parent_id,
                        path, icon, component, status)
VALUES ('车位租赁信息更新', 'park:rent-info:update', 3, 3, @parentId,
        '', '', '', 0);
INSERT INTO system_menu(name, permission, type, sort, parent_id,
                        path, icon, component, status)
VALUES ('车位租赁信息删除', 'park:rent-info:delete', 3, 4, @parentId,
        '', '', '', 0);
INSERT INTO system_menu(name, permission, type, sort, parent_id,
                        path, icon, component, status)
VALUES ('车位租赁信息导出', 'park:rent-info:export', 3, 5, @parentId,
        '', '', '', 0);
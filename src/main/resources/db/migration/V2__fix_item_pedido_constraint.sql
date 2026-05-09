SET @idx_exists := (
    SELECT COUNT(1)
    FROM information_schema.statistics
    WHERE table_schema = DATABASE()
      AND table_name = 'item_pedido'
      AND index_name = 'uk_item_pedido_pedido_produto'
);

SET @sql := IF(
    @idx_exists = 0,
    'ALTER TABLE item_pedido ADD CONSTRAINT uk_item_pedido_pedido_produto UNIQUE (pedido_id, produto_id)',
    'SELECT 1'
);

PREPARE stmt FROM @sql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

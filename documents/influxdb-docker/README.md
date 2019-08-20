# influxdb docker-entrypoint-initdb.d
 
Please use `.sh` instead of `*.iql` in docker-entrypoint-initdb.d

## note

> The **MEASUREMENTS** can not delete directly,
> delete the **MEASUREMENTS** by `DROP RETENTION POLICY "rp_name" ON "db_name"`. 
> It mean the **MEASUREMENTS** is belong to `db_name.rp_name`.

> **MEASUREMENTS** 的数据无法直接删除，只能通过删除**数据保存策略**来删除**MEASUREMENTS**，
> 例如命令：`DROP RETENTION POLICY "rp_name" ON "db_name"`
> 从侧面说明**MEASUREMENTS**的数据归属于数据库的某个**数据保存策略**
> 在插入数据（points）到**MEASUREMENTS**中，也是需要制定数据库以及数据保存策略的。

## use influx to connect influxdb server

```bash
docker-compose exec tsdb influx -host 127.0.0.1 -port 8086 -username admin -password admin
```

- `SHOW DATABASES`
- `SHOW MEASUREMENTS`
- `SHOW RETENTION POLICIES ON example`
- `SELECT * FROM weather ORDER BY time DESC LIMIT 3`
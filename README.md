# influxdb-example

influxdb-example, java

## run influxdb by docker

```bash
docker run -p 8086:8086 \
      -v influxdb:/var/lib/influxdb \
      influxdb
```
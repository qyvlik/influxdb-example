#!/bin/sh

$INFLUX_CMD "CREATE RETENTION POLICY \"rp_default\" ON \"$INFLUXDB_DB\" DURATION 7d REPLICATION 1 DEFAULT"

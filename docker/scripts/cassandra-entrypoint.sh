#!/bin/bash
# initialized in docker-compose.yml
#if [[ ! -z "$CASSANDRA_KEYSPACE" && $1 = 'cassandra' ]]; then
#  # Create default keyspace for single node cluster
#  CQL="CREATE KEYSPACE $CASSANDRA_KEYSPACE WITH REPLICATION = {'class': 'SimpleStrategy', 'replication_factor': 1};"
#  until echo $CQL | cqlsh; do
#    echo "cqlsh: Cassandra is unavailable - retry later"
#    sleep 2
#  done &
#fi
KEYSPACE_CQL="CREATE KEYSPACE IF NOT EXISTS $CASSANDRA_KEYSPACE WITH REPLICATION = {'class': 'SimpleStrategy', 'replication_factor': 1};"
USER_TABLE_CQL="CREATE TABLE IF NOT EXISTS $CASSANDRA_KEYSPACE.user (id UUID PRIMARY KEY, name TEXT, email TEXT);"

until echo $KEYSPACE_CQL | cqlsh && echo $USER_TABLE_CQL | cqlsh ; do
  echo "cqlsh: Cassandra is unavailable.."
  sleep 2
done &

exec /docker-entrypoint.sh "$@"
FROM cassandra:3.11.6
COPY docker/scripts/cassandra-entrypoint.sh cassandra-entrypoint.sh
ENTRYPOINT ["./cassandra-entrypoint.sh"]
CMD ["cassandra", "-f"]
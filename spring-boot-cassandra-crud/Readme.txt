TERMINAL 1
---------------
cd $CASSANDRA_HOME
pwd
/usr/local/Cellar/cassandra/cassandra-3.11.6
 ./bin/cassandra -f
 
 
TERMINAL 2
---------------
cd $CASSANDRA_HOME
cqlsh

CREATE KEYSPACE mytestdb
WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 2};

use mytestdb;

DESCRIBE keyspaces;

CREATE TABLE tutorial(
   id timeuuid PRIMARY KEY,
   title text,
   description text,
   published boolean
);


CREATE CUSTOM INDEX idx_title ON mytestdb.tutorial (title) 
USING 'org.apache.cassandra.index.sasi.SASIIndex' 
WITH OPTIONS = {
'mode': 'CONTAINS', 
'analyzer_class': 'org.apache.cassandra.index.sasi.analyzer.NonTokenizingAnalyzer', 
'case_sensitive': 'false'};

SELECT * FROM tutorial;
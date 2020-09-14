/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.braisdom.objsql;


import java.sql.Connection;
import java.sql.SQLException;

/**
 * A factory for creating the <code>Connection</code> of database, it is necessary
 * for ObjectiveSql in runtime. It will be used in <code>Databases.installConnectionFactory</code> method,
 * for a application customizes various connections.
 * <b>Notice:</b> The ConnectionFactory will be inject at the application beginning.
 *
 * @see Databases#installConnectionFactory(ConnectionFactory)
 */
public interface ConnectionFactory {

    String DEFAULT_DATA_SOURCE_NAME = "default";

    /**
     * Return a new connection of database, certainly, the connection can be retrieved
     * from a connection pool also.
     * The implementors should create different database connections by different
     * datasource name, and the datasource name is defined with <code>DataSourceName</code>
     *
     * @param dataSource the name is acquired from ThreadLocal
     * @return a connection of database
     * @throws SQLException
     *
     * @see com.github.braisdom.objsql.annotations.DataSourceName
     * @see Databases#setCurrentDataSourceName(String)
     * @see Databases#getCurrentDataSourceName()
     */
    Connection getConnection(String dataSource) throws SQLException;
}

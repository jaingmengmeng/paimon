/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.paimon.rest;

import org.apache.paimon.rest.requests.CreateDatabaseRequest;
import org.apache.paimon.rest.requests.DropDatabaseRequest;
import org.apache.paimon.rest.responses.CreateDatabaseResponse;
import org.apache.paimon.rest.responses.DatabaseName;
import org.apache.paimon.rest.responses.GetDatabaseResponse;
import org.apache.paimon.rest.responses.ListDatabasesResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.paimon.rest.RESTCatalogInternalOptions.DATABASE_COMMENT;

/** Mock REST message. */
public class MockRESTMessage {

    public static String databaseName() {
        return "database";
    }

    public static CreateDatabaseRequest createDatabaseRequest(String name) {
        boolean ignoreIfExists = true;
        Map<String, String> options = new HashMap<>();
        options.put("a", "b");
        return new CreateDatabaseRequest(name, ignoreIfExists, options);
    }

    public static DropDatabaseRequest dropDatabaseRequest() {
        boolean ignoreIfNotExists = true;
        boolean cascade = true;
        return new DropDatabaseRequest(ignoreIfNotExists, cascade);
    }

    public static CreateDatabaseResponse createDatabaseResponse(String name) {
        Map<String, String> options = new HashMap<>();
        options.put("a", "b");
        return new CreateDatabaseResponse(name, options);
    }

    public static GetDatabaseResponse getDatabaseResponse(String name) {
        Map<String, String> options = new HashMap<>();
        options.put("a", "b");
        options.put(DATABASE_COMMENT.key(), "comment");
        return new GetDatabaseResponse(name, options);
    }

    public static ListDatabasesResponse listDatabasesResponse(String name) {
        DatabaseName databaseName = new DatabaseName(name);
        List<DatabaseName> databaseNameList = new ArrayList<>();
        databaseNameList.add(databaseName);
        return new ListDatabasesResponse(databaseNameList);
    }
}

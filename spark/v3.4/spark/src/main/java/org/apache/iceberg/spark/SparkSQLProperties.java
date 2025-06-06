/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.iceberg.spark;

import java.time.Duration;

public class SparkSQLProperties {

  private SparkSQLProperties() {}

  // Controls whether vectorized reads are enabled
  public static final String VECTORIZATION_ENABLED = "spark.sql.iceberg.vectorization.enabled";

  // Controls which Parquet reader implementation to use
  public static final String PARQUET_READER_TYPE = "spark.sql.iceberg.parquet.reader-type";
  public static final ParquetReaderType PARQUET_READER_TYPE_DEFAULT = ParquetReaderType.ICEBERG;

  // Controls whether reading/writing timestamps without timezones is allowed
  @Deprecated
  public static final String HANDLE_TIMESTAMP_WITHOUT_TIMEZONE =
      "spark.sql.iceberg.handle-timestamp-without-timezone";

  // Controls whether timestamp types for new tables should be stored with timezone info
  @Deprecated
  public static final String USE_TIMESTAMP_WITHOUT_TIME_ZONE_IN_NEW_TABLES =
      "spark.sql.iceberg.use-timestamp-without-timezone-in-new-tables";

  // Controls whether to perform the nullability check during writes
  public static final String CHECK_NULLABILITY = "spark.sql.iceberg.check-nullability";
  public static final boolean CHECK_NULLABILITY_DEFAULT = true;

  // Controls whether to check the order of fields during writes
  public static final String CHECK_ORDERING = "spark.sql.iceberg.check-ordering";
  public static final boolean CHECK_ORDERING_DEFAULT = true;

  // Controls whether to preserve the existing grouping of data while planning splits
  public static final String PRESERVE_DATA_GROUPING =
      "spark.sql.iceberg.planning.preserve-data-grouping";
  public static final boolean PRESERVE_DATA_GROUPING_DEFAULT = false;

  // Controls whether to push down aggregate (MAX/MIN/COUNT) to Iceberg
  public static final String AGGREGATE_PUSH_DOWN_ENABLED =
      "spark.sql.iceberg.aggregate-push-down.enabled";
  public static final boolean AGGREGATE_PUSH_DOWN_ENABLED_DEFAULT = true;

  // Controls write distribution mode
  public static final String DISTRIBUTION_MODE = "spark.sql.iceberg.distribution-mode";

  // Controls the WAP ID used for write-audit-publish workflow.
  // When set, new snapshots will be staged with this ID in snapshot summary.
  public static final String WAP_ID = "spark.wap.id";

  // Controls the WAP branch used for write-audit-publish workflow.
  // When set, new snapshots will be committed to this branch.
  public static final String WAP_BRANCH = "spark.wap.branch";

  // Controls write compress options
  public static final String COMPRESSION_CODEC = "spark.sql.iceberg.compression-codec";
  public static final String COMPRESSION_LEVEL = "spark.sql.iceberg.compression-level";
  public static final String COMPRESSION_STRATEGY = "spark.sql.iceberg.compression-strategy";

  // Overrides the data planning mode
  public static final String DATA_PLANNING_MODE = "spark.sql.iceberg.data-planning-mode";

  // Overrides the delete planning mode
  public static final String DELETE_PLANNING_MODE = "spark.sql.iceberg.delete-planning-mode";

  // Controls whether to report locality information to Spark while allocating input partitions
  public static final String LOCALITY = "spark.sql.iceberg.locality.enabled";

  public static final String EXECUTOR_CACHE_ENABLED = "spark.sql.iceberg.executor-cache.enabled";
  public static final boolean EXECUTOR_CACHE_ENABLED_DEFAULT = true;

  public static final String EXECUTOR_CACHE_TIMEOUT = "spark.sql.iceberg.executor-cache.timeout";
  public static final Duration EXECUTOR_CACHE_TIMEOUT_DEFAULT = Duration.ofMinutes(10);

  public static final String EXECUTOR_CACHE_MAX_ENTRY_SIZE =
      "spark.sql.iceberg.executor-cache.max-entry-size";
  public static final long EXECUTOR_CACHE_MAX_ENTRY_SIZE_DEFAULT = 64 * 1024 * 1024; // 64 MB

  public static final String EXECUTOR_CACHE_MAX_TOTAL_SIZE =
      "spark.sql.iceberg.executor-cache.max-total-size";
  public static final long EXECUTOR_CACHE_MAX_TOTAL_SIZE_DEFAULT = 128 * 1024 * 1024; // 128 MB

  public static final String EXECUTOR_CACHE_LOCALITY_ENABLED =
      "spark.sql.iceberg.executor-cache.locality.enabled";
  public static final boolean EXECUTOR_CACHE_LOCALITY_ENABLED_DEFAULT = false;

  // Controls whether to report available column statistics to Spark for query optimization.
  public static final String REPORT_COLUMN_STATS = "spark.sql.iceberg.report-column-stats";
  public static final boolean REPORT_COLUMN_STATS_DEFAULT = true;
}

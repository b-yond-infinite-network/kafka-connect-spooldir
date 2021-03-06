/**
 * Copyright © 2016 Jeremy Custenborder (jcustenborder@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jcustenborder.kafka.connect.spooldir.elf.converters;

import org.apache.kafka.connect.data.Field;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class LocalDateLogFieldConverter extends LogFieldConverter {
  private static final ZoneId ZONE_ID = ZoneId.of("UTC");

  @Override
  protected Object convert(Object input) {
    final LocalDate localDate = (LocalDate) input;
    final Instant instant = localDate.atStartOfDay(ZONE_ID).toInstant();
    return Date.from(instant);
  }

  public LocalDateLogFieldConverter(String logFieldName, Field field) {
    super(logFieldName, field);
  }
}

/**
 * This file is part of Graylog.
 *
 * Graylog is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Graylog is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Graylog.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.graylog2.events;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.util.Objects;

@JsonAutoDetect
public final class SimpleEvent {
    @JsonProperty
    private final String payload;

    @JsonCreator
    public SimpleEvent(@JsonProperty("payload") String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("payload", payload)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof SimpleEvent)) return false;

        final SimpleEvent that = (SimpleEvent) o;
        return Objects.equals(this.payload, that.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(payload);
    }
}
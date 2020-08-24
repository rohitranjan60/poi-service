package com.benz.ccp.poiservice.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "start",
    "duration",
    "recurrence"
})
public class Structured implements Serializable
{

    @JsonProperty("start")
    private String start;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("recurrence")
    private String recurrence;
    private final static long serialVersionUID = -2811447344670206605L;

    @JsonProperty("start")
    public String getStart() {
        return start;
    }

    @JsonProperty("start")
    public void setStart(String start) {
        this.start = start;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("recurrence")
    public String getRecurrence() {
        return recurrence;
    }

    @JsonProperty("recurrence")
    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(start).append(duration).append(recurrence).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Structured) == false) {
            return false;
        }
        Structured rhs = ((Structured) other);
        return new EqualsBuilder().append(start, rhs.start).append(duration, rhs.duration).append(recurrence, rhs.recurrence).isEquals();
    }

}